package com.spring.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.poi.ss.usermodel.Cell;
import com.mybatis.models.Asignatura;
import com.mybatis.models.AsignaturaExample;
import com.mybatis.models.Cargo;
import com.mybatis.models.CargoExample;
import com.mybatis.models.Equipo;
import com.mybatis.models.Estudiantesxequipos;
import com.mybatis.models.EstudiantesxequiposExample;
import com.mybatis.models.Profesoresxasignaturas;
import com.mybatis.models.ProfesoresxasignaturasExample;
import com.mybatis.models.Semestre;
import com.mybatis.models.Usuarios;
import com.mybatis.models.UsuariosExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class usersController {
	daoHelper dao = new daoHelper();

	@RequestMapping("pages/users")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {
			// System.out.println(dao.getAsignaturaMapper().selectByExample(new
			// AsignaturaExample()));
			model.addAttribute("user", (Usuarios) request.getSession().getAttribute("user"));
			CargoExample ce = new CargoExample();
			ce.setOrderByClause("descripcion");
			List<Cargo> cargos = dao.getCargoMapper().selectByExample(ce);

			Map<Cargo, List<Usuarios>> usuariosXCargo = new HashMap<Cargo, List<Usuarios>>();

			for (Cargo cargo : cargos) {
				UsuariosExample usuEx = new UsuariosExample();
				usuEx.createCriteria().andIdCargoEqualTo(cargo.getIdCargo());
				String orderClause = "nombre";

				usuEx.setOrderByClause(orderClause);
				List<Usuarios> usuarios = dao.getUsuariosMapper().selectByExample(usuEx);
				for (Usuarios usu : usuarios) {
					String info = "";
					switch (cargo.getIdCargo()) {
					case 1: // Estudiante
						EstudiantesxequiposExample eeex = new EstudiantesxequiposExample();
						eeex.createCriteria().andIdEstudianteEqualTo(usu.getIdUsuario());
						List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(eeex);

						for (Estudiantesxequipos exe : exes) {
							Equipo eq = dao.getEquipoMapper().selectByPrimaryKey(exe.getIdEquipo());
							Semestre semestre = dao.getSemestreMapper().selectByPrimaryKey(eq.getIdSemestre());
							info += eq.getNombre() + " - Semestre " + semestre.getAno() + "-" + semestre.getNumero()
									+ "<br>";
						}

						break;
					case 2:// Profesor
						ProfesoresxasignaturasExample paex = new ProfesoresxasignaturasExample();
						paex.createCriteria().andIdProfesorEqualTo(usu.getIdUsuario());
						List<Profesoresxasignaturas> pxas = dao.getProfesoresxasignaturasMapper().selectByExample(paex);
						for (Profesoresxasignaturas pxa : pxas) {
							Asignatura asig = dao.getAsignaturaMapper().selectByPrimaryKey(pxa.getIdAsignatura());
							info += asig.getNombre() + "<br>";
						}
						break;
					case 3:// Asesor

						break;
					case 4:// Evaluador

						break;
					case 5:// Coordinador

						break;
					default:
						break;
					}
					usu.setUsuario(info == "" ? "" : "<td>" + info + "</td>");
					// EstudiantesxequiposExample eeex = new
					// EstudiantesxequiposExample();
					// eeex.createCriteria().andIdEstudianteEqualTo();
				}
				usuariosXCargo.put(cargo, usuarios);
			}
			request.setAttribute("users", usuariosXCargo);
			// model.addAttribute("users", usuariosXCargo);

			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			return new ModelAndView("pages/users");
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

	@RequestMapping("pages/users/saveUser")
	public void saveSaleUser(HttpServletRequest request, HttpServletResponse response) {
		try {

//			InputStream myxls = new FileInputStream("C:\\Users\\USER\\workspace\\SGPPI_2018\\usuarios_subida.xlsx");
//			HSSFWorkbook wb = new HSSFWorkbook(myxls);
//
//			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
//				HSSFSheet sheet = wb.getSheetAt(i);
//				int idCargo = i + 1;
//				for (int r = 0; r < sheet.getLastRowNum(); r++) {
//					HSSFRow row = sheet.getRow(r);
//					String correo = row.getCell(0).getStringCellValue();
//					String nombre = row.getCell(1).getStringCellValue();
//					String apellido = row.getCell(2).getStringCellValue();
//					String cedula = row.getCell(3).getStringCellValue();
//
//					HSSFCell fechaNacCell = row.getCell(4); // fechaNac
//
//					if (!HSSFDateUtil.isCellDateFormatted(fechaNacCell)) {
//						response.getWriter()
//								.write("<script>location.href='../users.html?errors=La fecha de nacimiento de la página "
//										+ idCargo + " en la fila " + r + " no es fecha';</script>");
//						return;
//					}
//					Date fechaNac = HSSFDateUtil.getJavaDate(fechaNacCell.getNumericCellValue());
//					Usuarios usu = new Usuarios();
//					
//					//nextVaal
//					int idUsuario = 2; 
//					usu.setIdUsuario(idUsuario);
//					usu.setCorreo(correo);
//					usu.setNombre(nombre);
//					usu.setApellidos(apellido);
//					usu.setCedula(cedula);
//					usu.setFechaNac(fechaNac);
//
//					if (idCargo == 2) { // profesor
//						// revisamos tambien la celda 5
//						if (!row.getCell(4).getStringCellValue().equals("")) {
//							String asignaturasString = row.getCell(4).getStringCellValue();
//							String[] asignaturasCodigos = asignaturasString.split(",");
//							
//							AsignaturaExample asigEx = new AsignaturaExample();
//							asigEx.createCriteria().andCodigoIn(Arrays.asList(asignaturasCodigos));
//							List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(asigEx);
//							for(Asignatura asig : asignaturas){
//								Profesoresxasignaturas pxa = new Profesoresxasignaturas();
//								pxa.setIdAsignatura(asig.getIdAsignatura());
//								pxa.setIdProfesor(usu.getIdUsuario());
//								dao.getProfesoresxasignaturasMapper().insert(pxa);
//							}
//						}
//
//					}
//
//					if (true) { // exists
//						dao.getUsuariosMapper().insert(usu);
//					} else { // not exists
//						UsuariosExample usuEx = new UsuariosExample();
//						usuEx.createCriteria().andCedulaEqualTo(cedula);
//						dao.getUsuariosMapper().updateByExample(usu, usuEx);
//					}
//
//				}
//
//			}

			response.getWriter()
					.write("<script>location.href='../users.html?errors=Error al subir el archivo';</script>");
			// request.getRequestDispatcher("../users.html?err=true").forward(request,
			// response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("pages/users/updateUser")
	public void updateSaleUser(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();

		try {
			String correo = request.getParameter("correo");
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String fechaNac = request.getParameter("fechaNac");
			int idCargo = Integer.parseInt(request.getParameter("idCargo"));
			String cedula = request.getParameter("cedula");
			String idUser = request.getParameter("id_usuario");
			Usuarios usuario = new Usuarios();

			usuario.setCorreo(correo);
			usuario.setNombre(nombre);
			usuario.setApellidos(apellidos);

			// usuario.setFechaNac(fechaNac);
			usuario.setIdCargo(idCargo);

			usuario.setCedula(cedula);

			if (idUser != null && !idUser.isEmpty() && !idUser.equals("0") && !idUser.equals("undefined")
					&& !idUser.equals("null")) {
				usuario.setIdUsuario(Integer.parseInt(idUser));
				dao.getUsuariosMapper().updateByPrimaryKey(usuario);
			} else {
				object.put("status", "errors");
				object.put("message", "Ha ocurrido un error inesperado");
			}

			object.put("status", "ok");
			object.put("message", "Se ha creado el cuadrante correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando el cuadrante");
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
