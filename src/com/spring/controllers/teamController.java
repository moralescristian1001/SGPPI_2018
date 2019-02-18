package com.spring.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.models.Asesorias;
import com.mybatis.models.AsesoriasExample;
import com.mybatis.models.Asignatura;
import com.mybatis.models.AsignaturaExample;
import com.mybatis.models.Cargo;
import com.mybatis.models.CargoExample;
import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import com.mybatis.models.Estudiantesxequipos;
import com.mybatis.models.EstudiantesxequiposExample;
import com.mybatis.models.Profesoresxasignaturas;
import com.mybatis.models.ProfesoresxasignaturasExample;
import com.mybatis.models.Rubrica;
import com.mybatis.models.RubricaExample;
import com.mybatis.models.Semestre;
import com.mybatis.models.SemestreExample;
import com.mybatis.models.SolicitudAsesoria;
import com.mybatis.models.SolicitudAsesoriaExample;
import com.mybatis.models.Usuarios;
import com.mybatis.models.UsuariosExample;
import com.mysql.fabric.xmlrpc.base.Array;
import com.springMybatis.persistence.daoHelper;

@Controller
public class teamController {

	daoHelper dao = new daoHelper();

	@RequestMapping("pages/teamReporte")
	public ModelAndView reporte(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {
			
			JSONArray arrayUsuarios = new JSONArray();
			int idSemestre = -1;
			if(request.getParameter("id_semestre") != null) {
				idSemestre = Integer.parseInt(request.getParameter("id_semestre"));
			}
			int estudiante = -1;
			if(request.getParameter("id_estudiante") != null) {
				estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
			}
			
			List<Cargo> cargos = dao.getCargoMapper().selectByExample(new CargoExample());
			EquipoExample usuEx = new EquipoExample();
			if(idSemestre >= 1 && estudiante >= 1) {
				EstudiantesxequiposExample eeex = new EstudiantesxequiposExample();
				eeex.createCriteria().andIdEstudianteEqualTo(estudiante);
				List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(eeex);
				
				usuEx.createCriteria().andIdEquipoIn(exes.stream().map(Estudiantesxequipos::getIdEquipo).collect(Collectors.toList())).andIdSemestreEqualTo(idSemestre);
			}else if(estudiante >= 1){
				EstudiantesxequiposExample eeex = new EstudiantesxequiposExample();
				eeex.createCriteria().andIdEstudianteEqualTo(estudiante);
				List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(eeex);
				
				usuEx.createCriteria().andIdEquipoIn(exes.stream().map(Estudiantesxequipos::getIdEquipo).collect(Collectors.toList()));
			}else if(idSemestre >= 1) {
				usuEx.createCriteria().andIdSemestreEqualTo(idSemestre);
			}
			
			
						
			String orderClause = "nombre";
			usuEx.setOrderByClause(orderClause);

			List<Equipo> usuarios = dao.getEquipoMapper().selectByExample(usuEx);
			int idSemestreActual = dao.getSemestreMapper().selectSemestreActual().getIdSemestre();
			for (Equipo usu : usuarios) {
				
				String integrantes = "";
				EstudiantesxequiposExample eeex = new EstudiantesxequiposExample();
				eeex.createCriteria().andIdEquipoEqualTo(usu.getIdEquipo());
				
				List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(eeex);
				for(Estudiantesxequipos aexe : exes) {
					Usuarios integrante = dao.getUsuariosMapper().selectByPrimaryKey(aexe.getIdEstudiante());
					integrantes += integrante.getNombre() + " " + integrante.getApellidos() + "<br>";
				}
				
				String asesoriasStr = "";
				AsesoriasExample aEx = new AsesoriasExample();
				aEx.createCriteria().andIdEquipoEqualTo(usu.getIdEquipo());
				List<Asesorias> asesorias = dao.getAsesoriasMapper().selectByExample(aEx);
				ArrayList<String> arrayDias = new ArrayList<String>(){
					{
						add(0,"Lunes");
						add(1,"Martes");
						add(2,"Miércoles");
						add(3,"Jueves");
						add(4,"Viernes");
						add(5,"Sábado");
					}
				};
				
				
				for(Asesorias asesoria : asesorias) {
					
					String diaSemana = arrayDias.get(asesoria.getDiaSemana() - 1);
					Usuarios asesor = dao.getUsuariosMapper().selectByPrimaryKey(asesoria.getIdAsesor());
					double hora = asesoria.getHoraSemana();
					
					String horaSemana = hora == 12 || hora == 12.5 ? ((int) hora) + ":" + (hora % 1 == 0 ? "00" : "30") + "PM"
							: (((int) hora % 12) + ":" + (hora % 1 == 0 ? "00" : "30") + (hora > 12 ? "PM" : "AM"));
					asesoriasStr += diaSemana + " " + horaSemana + " - " + asesor.getNombre() + " " + asesor.getApellidos() + "<br>";
				}
				
				
				Asignatura asig = dao.getAsignaturaMapper().selectByPrimaryKey(usu.getIdAsignatura());
				Semestre sem = dao.getSemestreMapper().selectByPrimaryKey(usu.getIdSemestre());
				Integer nota = 0;
				JSONObject usuJSON = new JSONObject();
				usuJSON.put("codigo", usu.getCodigo());
				usuJSON.put("nombre", usu.getNombre());
				usuJSON.put("asignatura", asig.getNombre());
				usuJSON.put("semestre", sem.getAno() + " - " + sem.getNumero());
				usuJSON.put("integrantes", integrantes);
				usuJSON.put("asesorias", asesoriasStr);
				arrayUsuarios.add(usuJSON);
			}
			
			// System.out.println(dao.getAsignaturaMapper().selectByExample(new
			// AsignaturaExample()));
			UsuariosExample estEx = new UsuariosExample();
			estEx.createCriteria().andIdCargoEqualTo(1);
			List<Usuarios> estudiantes = dao.getUsuariosMapper().selectByExample(estEx);
			SemestreExample semEx = new SemestreExample();
			short numeroSemestre = Calendar.getInstance().get(Calendar.MONTH) <= 6 ? (short)1 : (short)2;
			semEx.createCriteria().andAnoLessThan(Calendar.getInstance().get(Calendar.YEAR) + 1).andNumeroLessThanOrEqualTo(numeroSemestre);
			List<Semestre> semestres = dao.getSemestreMapper().selectByExample(semEx);
			
			Usuarios user = (Usuarios) request.getSession().getAttribute("user");
			model.addAttribute("user", user);
			request.setAttribute("semestres", semestres);
			request.setAttribute("estudiantes", estudiantes);
			request.setAttribute("equipos", arrayUsuarios);
			
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			return new ModelAndView("pages/teamsReporte");
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
			List<Estudiantesxequipos> estudiantesxequipos = new ArrayList<>();
			
			UsuariosExample estEx = new UsuariosExample();
			UsuariosExample estSinEquipoEx = new UsuariosExample();
			if(!equipos.isEmpty()) {
				EstudiantesxequiposExample eeEx = new EstudiantesxequiposExample();
				eeEx.createCriteria().andIdEquipoIn(equipos.stream().map(Equipo::getIdEquipo).collect(Collectors.toList()));
				estudiantesxequipos = dao.getEstudiantesxequiposMapper().selectByExample(eeEx);
				
				estEx.createCriteria().andIdUsuarioIn(estudiantesxequipos.stream().map(Estudiantesxequipos::getIdEstudiante)
						.collect(Collectors.toList()));
				
				estSinEquipoEx.createCriteria().andEstadoEqualTo(true).andIdCargoEqualTo(1)
						.andIdUsuarioNotIn(estudiantesxequipos.stream().map(Estudiantesxequipos::getIdEstudiante)
								.collect(Collectors.toList()));
			}else{
				estEx.createCriteria().andIdCargoLessThan(0);
				estSinEquipoEx.createCriteria().andEstadoEqualTo(true).andIdCargoEqualTo(1);
			}
			
			List<Rubrica> rubricas = dao.getRubricaMapper().selectByExample(new RubricaExample());
			
			AsignaturaExample asig = new AsignaturaExample();
			asig.createCriteria().andIdAsignaturaIn(rubricas.stream().map(Rubrica::getIdAsignatura).collect(Collectors.toList()));
			List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(asig);

			

			

			List<Usuarios> estudiantesSinEquipo = dao.getUsuariosMapper().selectByExample(estSinEquipoEx);
			List<Usuarios> estudiantes = dao.getUsuariosMapper().selectByExample(estEx);

			request.setAttribute("equipos", equipos);
			request.setAttribute("estudiantesxequipos", estudiantesxequipos);
			request.setAttribute("estudiantes", estudiantes);
			request.setAttribute("estudiantesSinEquipo", estudiantesSinEquipo);
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
			InputStream myxls = new FileInputStream("E:\\PPI\\SGPPI_2018\\equipos_subida.xls");
			XSSFWorkbook wb = new XSSFWorkbook(myxls);

			XSSFSheet sheet = wb.getSheetAt(0);
			// fisrt row will be titles
			int lastRow = sheet.getLastRowNum();
			for (r = 1; r <= lastRow; r++) {
				XSSFRow row = sheet.getRow(r);
				int codigo = (int) row.getCell(0).getNumericCellValue();
				String nombre = row.getCell(1).getStringCellValue();
				String codigoAsignatura = row.getCell(2).getStringCellValue();
				String cedulas = row.getCell(3).getStringCellValue();

				String errors = "";
				// if (codigo.isEmpty()) {
				// errors += "C�digo,";
				// }
				if (nombre.isEmpty()) {
					errors += "Nombre,";
				}
				if (codigoAsignatura.isEmpty()) {
					errors += "C�digo asignatura,";
				}
				if (cedulas.isEmpty()) {
					errors += "C�dulas,";
				}

				if (!errors.isEmpty()) {
					response.getWriter();
					errors = errors.trim();
					response.getWriter().write("<script>location.href='../team.html?errors=Error(s) en la fila " + r
							+ " " + errors + ".';</script>");
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
			boolean update = true;
			if(idEquipo.isEmpty()) {
				idEquipo = String.valueOf(dao.getEquipoMapper().getNextId());
				update = false;
			}
			
			equipo.setCodigo(Integer.parseInt(codigo));
			equipo.setNombre(nombre);
			equipo.setIdSemestre(idSemestre);
			equipo.setIdAsignatura(Integer.parseInt(idAsignatura));
			// usuario.setFechaNac(fechaNac);

			if (idEquipo != null && !idEquipo.isEmpty() && !idEquipo.equals("0") && !idEquipo.equals("undefined")
					&& !idEquipo.equals("null")) {
				equipo.setIdEquipo(Integer.parseInt(idEquipo));
				if(update) {
					
					dao.getEquipoMapper().updateByPrimaryKey(equipo);
				}else {
					dao.getEquipoMapper().insert(equipo);
				}
				
				

				String idEstudiantesStr = request.getParameter("id_usuario");
				String[] estudiantesArrStr = idEstudiantesStr.split(",");
				int[] estudiantes = new int[estudiantesArrStr.length];
				for (int i = 0; i < estudiantes.length; i++) {
					estudiantes[i] = Integer.parseInt(estudiantesArrStr[i]);
				}

				EstudiantesxequiposExample estxeqEx = new EstudiantesxequiposExample();
				estxeqEx.createCriteria().andIdEquipoEqualTo(equipo.getIdEquipo());
				dao.getEstudiantesxequiposMapper().deleteByExample(estxeqEx);

				for (int idEstudiante : estudiantes) {
					Estudiantesxequipos exe = new Estudiantesxequipos();
					exe.setIdEquipo(equipo.getIdEquipo());
					exe.setIdEstudiante(idEstudiante);
					dao.getEstudiantesxequiposMapper().insert(exe);
				}

			} else {
				dao.getEquipoMapper().insert(equipo);
				
				String idEstudiantesStr = request.getParameter("id_usuario");
				String[] estudiantesArrStr = idEstudiantesStr.split(",");
				int[] estudiantes = new int[estudiantesArrStr.length];
				
				for (int i = 0; i < estudiantes.length; i++) {
					estudiantes[i] = Integer.parseInt(estudiantesArrStr[i]);
				}

				for (int idEstudiante : estudiantes) {
					Estudiantesxequipos exe = new Estudiantesxequipos();
					exe.setIdEquipo(equipo.getIdEquipo());
					exe.setIdEstudiante(idEstudiante);
					dao.getEstudiantesxequiposMapper().insert(exe);
				}
			}

			object.put("status", "ok");
			object.put("id_equipo", idEquipo);
			object.put("message", "Se ha guardado la informaci�n correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurri� un error guardando el equipo");
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
					object.put("message", "No se encontr� el equipo a eliminar");
				}
			} else {
				object.put("status", "errors");
				object.put("message", "Ocurri� un error eliminando el equipo");
			}
		} catch (Exception e) {
			object.put("status", "errors");
			object.put("message", "Ocurri� un error eliminando el equipo");
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
