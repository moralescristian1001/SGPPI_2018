package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
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
import com.mybatis.models.Califxsoc;
import com.mybatis.models.CalifxsocExample;
import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import com.mybatis.models.Estudiantesxequipos;
import com.mybatis.models.EstudiantesxequiposExample;
import com.mybatis.models.Evento;
import com.mybatis.models.EventoExample;
import com.mybatis.models.Notasxcalifxsoc;
import com.mybatis.models.NotasxcalifxsocExample;
import com.mybatis.models.Profesoresxasignaturas;
import com.mybatis.models.ProfesoresxasignaturasExample;
import com.mybatis.models.Rubrica;
import com.mybatis.models.RubricaExample;
import com.mybatis.models.Rubricaxitem;
import com.mybatis.models.RubricaxitemExample;
import com.mybatis.models.Salon;
import com.mybatis.models.SalonExample;
import com.mybatis.models.Salonxequipo;
import com.mybatis.models.SalonxequipoExample;
import com.mybatis.models.Salonxprofesores;
import com.mybatis.models.SalonxprofesoresExample;
import com.mybatis.models.Semestre;
import com.mybatis.models.Socializacion;
import com.mybatis.models.SocializacionExample;
import com.mybatis.models.SolicitudAsesoria;
import com.mybatis.models.TipoEvento;
import com.mybatis.models.TipoEventoExample;
import com.mybatis.models.Usuarios;
import com.mybatis.models.UsuariosExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class qualifyController {

	daoHelper dao = new daoHelper();

	@RequestMapping("pages/qualify")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {

			Usuarios usu = (Usuarios) request.getSession().getAttribute("user");
			model.addAttribute("user", usu);

			// primero hay que buscar la socializaci�n que se este haciendo ya
			List<Evento> eventoActual = dao.getEventoMapper().selectEventosActuales();

			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			if (eventoActual.size() == 1) {

				SocializacionExample sEx = new SocializacionExample();
				sEx.createCriteria().andIdEventoEqualTo(eventoActual.get(0).getIdEvento());
				Socializacion soc = dao.getSocializacionMapper().selectByExample(sEx).get(0);

				SalonxprofesoresExample sxpEx = new SalonxprofesoresExample();
				sxpEx.createCriteria().andIdProfesorEqualTo(usu.getIdUsuario())
						.andIdSocializacionEqualTo(soc.getIdSocializacion());
				List<Salonxprofesores> sxp = dao.getSalonxprofesoresMapper().selectByExample(sxpEx);
				if (!sxp.isEmpty()) {

					SalonxequipoExample sxeEx = new SalonxequipoExample();
					sxeEx.createCriteria().andIdSocializacionEqualTo(soc.getIdSocializacion())
							.andIdSalonEqualTo(sxp.get(0).getIdSalon());

					Salon salon = dao.getSalonMapper().selectByPrimaryKey(sxp.get(0).getIdSalon());

					List<Salonxequipo> salonxequipos = dao.getSalonxequipoMapper().selectByExample(sxeEx);
					List<Equipo> equipos = new ArrayList<>();
					Map<Integer, Integer> notas = new HashMap<>();
					for (Salonxequipo sxe : salonxequipos) {
						Equipo equipo = dao.getEquipoMapper().selectByPrimaryKey(sxe.getIdEquipo());
						equipos.add(equipo);
						
						CalifxsocExample cxsEx = new CalifxsocExample();
						cxsEx.createCriteria().andIdSalonxequipoEqualTo(sxe.getIdSalonxequipo()).andIdCalificadorEqualTo(usu.getIdUsuario());
						List<Califxsoc> cxs = dao.getCalifxsocMapper().selectByExample(cxsEx);
						if(!cxs.isEmpty() && cxs.size() == 1){
							NotasxcalifxsocExample nxcxsEx = new NotasxcalifxsocExample();
							nxcxsEx.createCriteria().andIdCalifxsocEqualTo(cxs.get(0).getIdCalifxsoc());
							
							List<Notasxcalifxsoc> nxcxss = dao.getNotasxcalifxsocMapper().selectByExample(nxcxsEx);
							int nota = 0;
							for(Notasxcalifxsoc nxcxs : nxcxss){
								Rubricaxitem rxi = dao.getRubricaxitemMapper().selectByPrimaryKey(nxcxs.getIdRubricaxitem());
								nota += rxi.getCalificacion();
							}
							nota = nota / nxcxss.size();
							notas.put(equipo.getIdEquipo(), nota);
						}
					}

					List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(new AsignaturaExample());
					
					
					
					
					model.addAttribute("id_socializacion", soc.getIdSocializacion());
					model.addAttribute("equipos", equipos);
					model.addAttribute("asignaturas", asignaturas);
					model.addAttribute("notas", notas);
					model.addAttribute("salon", salon);
					return new ModelAndView("pages/qualify");
				} else {
					model.addAttribute("errors", "No se te ha asignado un salon en la socializaci�n");
					return new ModelAndView("pages/home");
				}
			} else {
				model.addAttribute("errors", "No hay socializaciones activas ahora misma");
				return new ModelAndView("pages/home");
			}

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

	@RequestMapping("pages/qualify/saveQualify")
	public void saveSaleQualify(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			Usuarios usu = (Usuarios) request.getSession().getAttribute("user");
			String observaciones = request.getParameter("observaciones");
			String rubricas = request.getParameter("rubricas");
			int idEquipo = Integer.parseInt(request.getParameter("id_equipo"));
			int idSocializacion = Integer.parseInt(request.getParameter("id_socializacion"));
			SalonxequipoExample sxeEx = new SalonxequipoExample();
			sxeEx.createCriteria().andIdSocializacionEqualTo(idSocializacion).andIdEquipoEqualTo(idEquipo);
			List<Salonxequipo> sxe = dao.getSalonxequipoMapper().selectByExample(sxeEx);
			
			Califxsoc califxsoc = new Califxsoc();
			
			int idCalifxsoc = dao.getCalifxsocMapper().getNextId();
			califxsoc.setIdCalifxsoc(idCalifxsoc);
			califxsoc.setIdCalificador(usu.getIdUsuario());
			califxsoc.setIdSalonxequipo(sxe.get(0).getIdSalonxequipo());
			califxsoc.setObservaciones(observaciones);
			dao.getCalifxsocMapper().insert(califxsoc);
			
			String[] rubricasArr = rubricas.split(",");
			for (String rubricaStr : rubricasArr){
				int rubrica = Integer.parseInt(rubricaStr);
				Notasxcalifxsoc nxcxs = new Notasxcalifxsoc();
				nxcxs.setIdCalifxsoc(idCalifxsoc);
				nxcxs.setIdRubricaxitem(rubrica);
				dao.getNotasxcalifxsocMapper().insert(nxcxs);
			}
			
			object.put("status", "ok");
			object.put("message", "Se ha creado la calificaci�n correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurri� un error guardando la calificaci�n");
		}
		writeObject(object, response);
	}

	@RequestMapping("pages/qualify/getInfoAdicionalEditable")
	public void getInfoAdicionalEditable(HttpServletRequest request, HttpServletResponse response) {
		infoAdicionalRubric(request, response, true);
	}
	
	@RequestMapping("pages/qualify/getInfoAdicional")
	public void getInfoAdicional(HttpServletRequest request, HttpServletResponse response) {
		infoAdicionalRubric(request, response, false);
	}
	private void infoAdicionalRubric(HttpServletRequest request, HttpServletResponse response, boolean editable) {
		JSONObject object = new JSONObject();

		try {
			int idAsignatura = Integer.parseInt(request.getParameter("id_asignatura"));
			
			int version = request.getParameter("version") == null ? dao.getRubricaMapper().getLastVersion(idAsignatura) : Integer.parseInt(request.getParameter("version"));
			
			// int idSocializacion =
			// Integer.parseInt(request.getParameter("id_socializacion"));
			String info = "";
			RubricaExample rEx = new RubricaExample();
			rEx.createCriteria().andIdAsignaturaEqualTo(idAsignatura).andVersionEqualTo(version);
			rEx.setOrderByClause("numero ASC");
			List<Rubrica> rubricas = dao.getRubricaMapper().selectByExample(rEx);
			if (!rubricas.isEmpty()) {
				int numRubrica = 1;
				for (Rubrica rubrica : rubricas) {
					RubricaxitemExample rxiEx = new RubricaxitemExample();
					rxiEx.createCriteria().andIdRubricaEqualTo(rubrica.getIdRubrica());
					rxiEx.setOrderByClause("calificacion ASC");
					List<Rubricaxitem> rxis = dao.getRubricaxitemMapper().selectByExample(rxiEx);

					if (rxis.isEmpty() || rxis.size() != 4) {
						object.put("status", "errors");
						object.put("info", "No hay rubricas relacionadas con el m�dulo sol del equipo");
						break;
					} else {
						if(editable) {
							info += "<tr><td><textarea id='rubrica_descripcion_"+numRubrica+"' name='rubrica_descripcion_"+numRubrica+"' class='form-control'>" +rubrica.getDescripcion() + "</textarea></td>";
							info += "<td>" +
									"<select id='id_tipo_rubrica_"+numRubrica+"' name='id_tipo_rubrica_"+numRubrica+"' class='form-control'>" +
									"<option value='-1'>Seleccione el tipo</option>" +
									"<option value='1' "+(rubrica.getIdTipoRubrica() == 1 ? "selected" : "") + ">Criterios Tématicos</option>" +
									"<option value='2' "+(rubrica.getIdTipoRubrica() == 2 ? "selected" : "") + ">Criterios Axiológicos</option>" +
									"</select>" +
									"</td>";
							int itemRubrica = 0;
							
							for (Rubricaxitem rxi : rxis) {
								info += "<td class='items_rubrica item-seleccionable' id='item_" + rubrica.getIdRubrica() + "_"
										+ rxi.getIdRubricaxitem() + "'>"
										+ "<textarea id='item_"+numRubrica+"_"+itemRubrica+"' name='item_"+numRubrica+"_"+itemRubrica+"' class='form-control'>" + rxi.getDescripcionItem() + "</textarea></td>";
								itemRubrica++;
							}
							numRubrica++;
						}else {
							info += "<tr><td>" + rubrica.getNumero() + " - " + rubrica.getDescripcion() + "</td>";
							for (Rubricaxitem rxi : rxis) {
								info += "<td class='items_rubrica item-seleccionable' id='item_" + rubrica.getIdRubrica() + "_"
										+ rxi.getIdRubricaxitem() + "'>" + rxi.getDescripcionItem() + "</td>";
							}
						}
						info += "</tr>";
						
					}
				}
				object.put("status", "ok");
				object.put("info", info);
			} else {
				object.put("status", "errors");
				object.put("info", "No hay rubricas relacionadas con el módulo sol del equipo");
			}

		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando el cuadrante");
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
