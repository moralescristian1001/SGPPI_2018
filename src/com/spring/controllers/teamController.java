package com.spring.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.models.Asignatura;
import com.mybatis.models.AsignaturaExample;
import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import com.mybatis.models.Estudiantesxequipos;
import com.mybatis.models.EstudiantesxequiposExample;
import com.mybatis.models.Profesoresxasignaturas;
import com.mybatis.models.Semestre;
import com.mybatis.models.SolicitudAsesoria;
import com.mybatis.models.SolicitudAsesoriaExample;
import com.mybatis.models.Usuarios;
import com.mybatis.models.UsuariosExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class teamController {

	daoHelper dao = new daoHelper();

	@RequestMapping("pages/team")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response) {

		if (request.getSession().getAttribute("user") != null) {
			// System.out.println(dao.getAsignaturaMapper().selectByExample(new
			// AsignaturaExample()));
			model.addAttribute("user", (Usuarios) request.getSession().getAttribute("user"));
			Semestre semestreActual = (Semestre) request.getSession().getAttribute("semestre");

			EquipoExample eEx = new EquipoExample();
			eEx.createCriteria().andIdSemestreEqualTo(semestreActual.getIdSemestre());
			List<Equipo> equipos = dao.getEquipoMapper().selectByExample(eEx);

			EstudiantesxequiposExample eeEx = new EstudiantesxequiposExample();
			eeEx.createCriteria().andIdEquipoIn(equipos.stream().map(Equipo::getIdEquipo).collect(Collectors.toList()));
			List<Estudiantesxequipos> estudiantesxequipos = dao.getEstudiantesxequiposMapper().selectByExample(eeEx);

			List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(new AsignaturaExample());

			UsuariosExample estEx = new UsuariosExample();
			estEx.createCriteria().andIdUsuarioIn(estudiantesxequipos.stream().map(Estudiantesxequipos::getIdEstudiante)
					.collect(Collectors.toList()));

			List<Usuarios> estudiantes = dao.getUsuariosMapper().selectByExample(estEx);

			request.setAttribute("equipos", equipos);
			request.setAttribute("estudiantesxequipos", estudiantesxequipos);
			request.setAttribute("estudiantes", estudiantes);
			request.setAttribute("asignaturas", asignaturas);

			response.setCharacterEncoding("UTF-8");
			return new ModelAndView("pages/team");
		} else {
			// return new ModelAndView("index");
			try {
				response.getWriter().write("<script>location.href='../index.jsp';</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
	}

	@RequestMapping("pages/team/saveTeam")
	public void saveSaleTeam(HttpServletRequest request, HttpServletResponse response) {
		int r = 1;
		try {
			InputStream myxls = new FileInputStream("C:\\Users\\USER\\workspace\\SGPPI_2018\\equipos_subida.xls");
			XSSFWorkbook wb = new XSSFWorkbook(myxls);

			XSSFSheet sheet = wb.getSheetAt(0);
			// fisrt row will be titles
			int lastRow = sheet.getLastRowNum();
			for (r = 1; r <= lastRow; r++) {
				XSSFRow row = sheet.getRow(r);
				int codigo = (int)row.getCell(0).getNumericCellValue();
				String nombre = row.getCell(1).getStringCellValue();
				String codigoAsignatura = row.getCell(2).getStringCellValue();
				String cedulas = row.getCell(3).getStringCellValue();

				String errors = "";
//				if (codigo.isEmpty()) {
//					errors += "Código,";
//				}
				if(nombre.isEmpty()){
					errors += "Nombre,";
				}
				if(codigoAsignatura.isEmpty()){
					errors += "Código asignatura,";
				}
				if(cedulas.isEmpty()){
					errors += "Cédulas,";
				}
				
				if(!errors.isEmpty()){
					response.getWriter();
					errors = errors.trim();
					response.getWriter().write("<script>location.href='../team.html?errors=Error(s) en la fila "+r+" "+ errors+ ".';</script>");
				}
				
				Equipo eq = new Equipo();

				// nextVaal
				AsignaturaExample asigEx = new AsignaturaExample();
				asigEx.createCriteria().andCodigoEqualTo(codigoAsignatura);
				List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(asigEx);
				Asignatura asig = asignaturas.get(0);
				int idEquipo = dao.getEquipoMapper().getNextId();

				eq.setIdEquipo(idEquipo);
				eq.setCodigo(codigo);
				eq.setNombre(nombre);
				eq.setIdAsignatura(asig.getIdAsignatura());
				eq.setIdSemestre(dao.getSemestreMapper().selectSemestreActual().getIdSemestre());
				// if (true) { // exists
				dao.getEquipoMapper().insert(eq);
				// } else { // not exists
				//
				// }
				// insert estudiantes x equipo
				String[] cedulasArray = cedulas.split(",");
				for (String cedula : cedulasArray) {
					UsuariosExample usuEx = new UsuariosExample();
					usuEx.createCriteria().andCedulaEqualTo(cedula);
					List<Usuarios> estudiantes = dao.getUsuariosMapper().selectByExample(usuEx);
					Usuarios estudiante = estudiantes.get(0);

					Estudiantesxequipos exe = new Estudiantesxequipos();
					exe.setIdEstudiante(estudiante.getIdUsuario());
					exe.setIdEquipo(eq.getIdEquipo());
					dao.getEstudiantesxequiposMapper().insert(exe);
				}
			}

			response.getWriter()
					.write("<script>location.href='../team.html?success=Se han guardado el/los equipos';</script>");

			// response.getWriter()
			// .write("<script>location.href='../team.html?errors=Error al subir
			// el archivo';</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
				e.printStackTrace();
			
		}
	}

	@RequestMapping("pages/team/updateTeam")
	public void updateSaleTeam(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();

		try {
			String codigo = request.getParameter("codigo");

			String nombre = request.getParameter("nombre");
			int idSemestre = dao.getSemestreMapper().selectSemestreActual().getIdSemestre();
			String idAsignatura = request.getParameter("id_asignatura");

			Equipo equipo = new Equipo();

			String idEquipo = request.getParameter("id_equipo");

			equipo.setCodigo(Integer.parseInt(codigo));
			equipo.setNombre(nombre);
			equipo.setIdSemestre(idSemestre);
			equipo.setIdAsignatura(Integer.parseInt(idAsignatura));
			// usuario.setFechaNac(fechaNac);

			if (idEquipo != null && !idEquipo.isEmpty() && !idEquipo.equals("0") && !idEquipo.equals("undefined")
					&& !idEquipo.equals("null")) {
				equipo.setIdEquipo(Integer.parseInt(idEquipo));
				dao.getEquipoMapper().updateByPrimaryKey(equipo);
			} else {
				object.put("status", "errors");
				object.put("message", "Ha ocurrido un error inesperado");
			}

			object.put("status", "ok");
			object.put("message", "Se ha creado el equipo correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando el equipo");
		}
		writeObject(object, response);

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/team/deleteTeam")
	public void deleteTeam(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String idEquipo = request.getParameter("id_equipo");
			if (idEquipo != null && !idEquipo.isEmpty() && !idEquipo.equals("0") && !idEquipo.equals("undefined")
					&& !idEquipo.equals("null")) {
				EquipoExample eqEx = new EquipoExample();
				eqEx.createCriteria().andIdEquipoEqualTo(Integer.parseInt(idEquipo));
				List<Equipo> equipoList = dao.getEquipoMapper().selectByExample(eqEx);
				if (equipoList != null && !equipoList.isEmpty()) {
					dao.getEquipoMapper().deleteByExample(eqEx);
					object.put("status", "ok");
					object.put("message", "Se ha eliminado el equipo correctamente");
				} else {
					object.put("status", "errors");
					object.put("message", "No se encontró el equipo a eliminar");
				}
			} else {
				object.put("status", "errors");
				object.put("message", "Ocurrió un error eliminando el equipo");
			}
		} catch (Exception e) {
			object.put("status", "errors");
			object.put("message", "Ocurrió un error eliminando el equipo");
		}
		writeObject(object, response);
	}

	public void writeObject(JSONObject object, HttpServletResponse response) {
		try {
			object.writeJSONString(response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
