package com.spring.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
			Usuarios user = (Usuarios) request.getSession().getAttribute("user");
			model.addAttribute("user", user);
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
						if (info.isEmpty()) {
							info = "Sin equipo asignado";
						}

						break;
					case 2:// Profesor
						
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
			// getting asignaturas
			List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(new AsignaturaExample());

			request.setAttribute("cargos", cargos);
			request.setAttribute("users", usuariosXCargo);
			request.setAttribute("asignaturas", asignaturas);
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

			InputStream myxls = new FileInputStream("C:\\Users\\USER\\workspace\\SGPPI_2018\\usuarios_subida.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(myxls);
			int numberSheets = wb.getNumberOfSheets();

			for (int i = 0; i < numberSheets; i++) {
				XSSFSheet sheet = wb.getSheetAt(i);
				int idCargo = i + 1;
				int lastRows = sheet.getLastRowNum();
				for (int r = 1; r <= lastRows; r++) {
					XSSFRow row = sheet.getRow(r);
					String correo = row.getCell(0).getStringCellValue();
					String nombre = row.getCell(1).getStringCellValue();
					String apellido = row.getCell(2).getStringCellValue();
					String cedula = String.valueOf((int) row.getCell(3).getNumericCellValue());

					XSSFCell fechaNacCell = row.getCell(4); // fechaNac

					if (!HSSFDateUtil.isCellDateFormatted(fechaNacCell)) {
						response.getWriter()
								.write("<script>location.href='../users.html?errors=La fecha de nacimiento de la pï¿½gina "
										+ idCargo + " en la fila " + r + " no es fecha';</script>");
						return;
					}
					Date fechaNac = HSSFDateUtil.getJavaDate(fechaNacCell.getNumericCellValue());
					Usuarios usu = new Usuarios();

					// nextVaal
					int idUsuario = dao.getUsuariosMapper().getNextId();
					usu.setIdUsuario(idUsuario);
					usu.setCorreo(correo);
					usu.setUsuario(correo);
					usu.setClave(cedula);
					usu.setIdCargo(idCargo);
					usu.setNombre(nombre);
					usu.setApellidos(apellido);
					usu.setCedula(cedula);
					usu.setFechaNac(fechaNac);
					usu.setEstado(true);

					if (!dao.getUsuariosMapper().checkUserExists(cedula)) { // exists
						dao.getUsuariosMapper().insert(usu);
					} else { // not exists
						UsuariosExample usuEx = new UsuariosExample();
						usuEx.createCriteria().andCedulaEqualTo(cedula);
						dao.getUsuariosMapper().updateByExample(usu, usuEx);
					}

					if (idCargo == 2) { // profesor
						// revisamos tambien la celda 5
						if (!row.getCell(5).getStringCellValue().equals("")) {
							String asignaturasString = row.getCell(5).getStringCellValue();
							String[] asignaturasCodigos = asignaturasString.split(",");

							AsignaturaExample asigEx = new AsignaturaExample();
							asigEx.createCriteria().andCodigoIn(Arrays.asList(asignaturasCodigos));
							List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(asigEx);

							ProfesoresxasignaturasExample pxaEx = new ProfesoresxasignaturasExample();
							pxaEx.createCriteria().andIdAsignaturaIn(
									asignaturas.stream().map(Asignatura::getIdAsignatura).collect(Collectors.toList()))
									.andIdProfesorEqualTo(usu.getIdUsuario());
							dao.getProfesoresxasignaturasMapper().deleteByExample(pxaEx);

							for (Asignatura asig : asignaturas) {

								Profesoresxasignaturas pxa = new Profesoresxasignaturas();
								pxa.setIdAsignatura(asig.getIdAsignatura());
								pxa.setIdProfesor(usu.getIdUsuario());
								dao.getProfesoresxasignaturasMapper().insert(pxa);
							}
						}

					}

				}

			}
			response.setCharacterEncoding("UTF-8");
			response.getWriter()
					.write("<script>location.href='../users.html?success=Se han guardado el/los usuarios';</script>");
			// request.getRequestDispatcher("../users.html?err=true").forward(request,
			// response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/users/updateUser")
	public void updateSaleUser(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();

		try {
			String correo = request.getParameter("correo");
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String fechaNac = request.getParameter("fecha_nac");
			int idCargo = Integer.parseInt(request.getParameter("id_cargo"));
			String cedula = request.getParameter("cedula");
			String idUser = request.getParameter("id_usuario");
			int estado = Integer.parseInt(request.getParameter("estado"));
			String minimoAsesoriasStr = request.getParameter("minimo_asesorias");
			Integer minimoAsesorias = null;
			
			if(idCargo == 3) { //Si es asesor
				minimoAsesorias = Integer.parseInt(minimoAsesoriasStr);
			}
			
			Usuarios usuario = new Usuarios();

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

			usuario.setCorreo(correo);
			usuario.setNombre(nombre);
			usuario.setApellidos(apellidos);
			usuario.setFechaNac(formatter.parse(fechaNac));
			usuario.setIdCargo(idCargo);
			usuario.setCedula(cedula);
			usuario.setUsuario(correo);
			usuario.setClave(cedula);
			usuario.setCambioClave(false);
			usuario.setEstado(estado == 1 ? true : false);
			usuario.setMinimoAsesorias(minimoAsesorias);
			
			if (idUser != null && !idUser.isEmpty() && !idUser.equals("0") && !idUser.equals("undefined")
					&& !idUser.equals("null")) {
				usuario.setIdUsuario(Integer.parseInt(idUser));
				dao.getUsuariosMapper().updateByPrimaryKey(usuario);
			} else {
				dao.getUsuariosMapper().insert(usuario);
			}
			object.put("status", "ok");
			object.put("message", "Se ha guardado la informaciï¿½n correctamente");
		} catch (Exception e) {
			String cause = e.getLocalizedMessage();
			if(cause.contains("Duplicate entry")) {
				object.put("status", "errors");
				object.put("message", "El correo electrónico ya existe, por favor digite otro correo");
			}else {
				object.put("status", "errors");
				object.put("message", "Ocurrió un error guardando el usuario");
			}
		}
		response.setCharacterEncoding("UTF-8");
		writeObject(object, response);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/users/getInfoAdicional")
	public void getInfoAdicional(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();

		try {
			int idUser = Integer.parseInt(request.getParameter("id_usuario"));
			int idCargo = Integer.parseInt(request.getParameter("id_cargo"));
			String info = "";
			if (idCargo == 1) { // si es estudiante
				EstudiantesxequiposExample eeex = new EstudiantesxequiposExample();
				eeex.createCriteria().andIdEstudianteEqualTo(idUser);
				List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(eeex);
				Semestre semestreActual = dao.getSemestreMapper().selectSemestreActual();

				for (Estudiantesxequipos exe : exes) {
					Equipo eq = dao.getEquipoMapper().selectByPrimaryKey(exe.getIdEquipo());
					if (semestreActual.getIdSemestre() == eq.getIdSemestre()) {
						info = "<label>Semestre Actual:</label> " + eq.getNombre();
						break;
					}
				}
				if (info.isEmpty()) {
					info = "Sin equipo asignado";
				}
				info = "<div class='row'><div class='col-sm-12'>" + info + "</div></div>";
			} else if (idCargo == 2) {
				ProfesoresxasignaturasExample paex = new ProfesoresxasignaturasExample();
				paex.createCriteria().andIdProfesorEqualTo(idUser);
				List<Profesoresxasignaturas> pxas = dao.getProfesoresxasignaturasMapper().selectByExample(paex);
				info = "<div id='asignaturas'>";
				int cont = 0;
				for (Profesoresxasignaturas pxa : pxas) {
					cont++;
					Asignatura asig = dao.getAsignaturaMapper().selectByPrimaryKey(pxa.getIdAsignatura());
					info += "<div class='row' id='asignatura_" + cont + "'><div class='col-sm-12'>" + asig.getNombre()
							+ "<input type='hidden' name='id_asignatura[" + cont + "]' id='id_asignatura_" + cont
							+ "' value='" + asig.getIdAsignatura() + "'><a href='javascript:eliminarAsignatura(" + cont
							+ ")'><i class='fa fa-remove fa-fw'></i></a></div></div>";
				}
				info += "</div><div class='row'><div class='col-sm-12'><a href='javascript:agregarAsignatura()' class='btn btn-success'><i class='fa fa-plus fa-fw'></i></a></div></div>";
			}

			object.put("status", "ok");
			object.put("info", info);
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurriï¿½ un error guardando el cuadrante");
		}

		response.setCharacterEncoding("UTF-8");
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
