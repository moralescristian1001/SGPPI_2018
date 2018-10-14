package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import com.mybatis.models.Califxsoc;
import com.mybatis.models.CalifxsocExample;
import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import com.mybatis.models.Estudiantesxequipos;
import com.mybatis.models.EstudiantesxequiposExample;
import com.mybatis.models.Evento;
import com.mybatis.models.EventoExample;
import com.mybatis.models.Profesoresxasignaturas;
import com.mybatis.models.ProfesoresxasignaturasExample;
import com.mybatis.models.Salon;
import com.mybatis.models.SalonExample;
import com.mybatis.models.Salonxequipo;
import com.mybatis.models.SalonxequipoExample;
import com.mybatis.models.Salonxprofesores;
import com.mybatis.models.SalonxprofesoresExample;
import com.mybatis.models.SeguimientoAsistencia;
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
public class socialController {

	daoHelper dao = new daoHelper();

	@RequestMapping("pages/social")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {
			Usuarios usu = (Usuarios) request.getSession().getAttribute("user");
			Semestre semestreActual = (Semestre) request.getSession().getAttribute("semestre");
			model.addAttribute("user", usu);

			List<Evento> eventos = dao.getEventoMapper().selectByExample(new EventoExample());
			List<TipoEvento> tiposEvento = dao.getTipoEventoMapper().selectByExample(new TipoEventoExample());
			List<Salon> salones = dao.getSalonMapper().selectByExample(new SalonExample());

			EquipoExample eEx = new EquipoExample();
			eEx.createCriteria().andIdSemestreEqualTo(semestreActual.getIdSemestre());
			List<Equipo> equipos = dao.getEquipoMapper().selectByExample(eEx);

			UsuariosExample usuEx = new UsuariosExample();
			usuEx.createCriteria().andIdCargoIn(Arrays.asList(new Integer[] { 2, 4, 6}));
			List<Usuarios> evaluadores = dao.getUsuariosMapper().selectByExample(usuEx);

			model.addAttribute("tiposEvento", tiposEvento);
			model.addAttribute("eventos", eventos);
			model.addAttribute("salones", salones);
			model.addAttribute("equipos", equipos);
			model.addAttribute("evaluadores", evaluadores);
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			return new ModelAndView("pages/social");
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

	@RequestMapping("pages/social/getInfoAdicional")
	public void getInfoAdicional(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();

		try {
			int idEvento = Integer.parseInt(request.getParameter("id_evento"));
			JSONArray salones = new JSONArray();

			SocializacionExample sEx = new SocializacionExample();
			sEx.createCriteria().andIdEventoEqualTo(idEvento);
			Socializacion social = dao.getSocializacionMapper().selectByExample(sEx).get(0);

			SalonxequipoExample sxeEx = new SalonxequipoExample();
			sxeEx.createCriteria().andIdSocializacionEqualTo(social.getIdSocializacion());

			List<Salonxequipo> salonxequipo = dao.getSalonxequipoMapper().selectByExample(sxeEx);

			SalonxprofesoresExample sxpEx = new SalonxprofesoresExample();
			sxpEx.createCriteria().andIdSocializacionEqualTo(social.getIdSocializacion());

			List<Salonxprofesores> salonxprofesor = dao.getSalonxprofesoresMapper().selectByExample(sxpEx);

			for (Salonxequipo sxe : salonxequipo) {
				
				JSONObject salon = getPosition(salones, sxe.getIdSalon());
				if (salon == null) {
					// si no fue ingresada

					Salon salonObj = dao.getSalonMapper().selectByPrimaryKey(sxe.getIdSalon());
					salon = new JSONObject();
					salon.put("idSalon", salonObj.getIdSalon());
					salon.put("descripcion", salonObj.getDescripcion());
					salones.add(salon);
				}
				JSONArray equipos = null;
				if (salon.containsKey("equipos")) {
					equipos = (JSONArray) salon.get("equipos");
				} else {
					equipos = new JSONArray();
					salon.put("equipos", equipos);
				}

				equipos.add(sxe.getIdEquipo());
			}

			for (Salonxprofesores sxp : salonxprofesor) {
				
				JSONObject salon = getPosition(salones, sxp.getIdSalon());
				JSONArray evaluadores = null;
				if (salon.containsKey("evaluadores")) {
					evaluadores = (JSONArray) salon.get("evaluadores");
				} else {
					evaluadores = new JSONArray();
					salon.put("evaluadores", evaluadores);
				}

				evaluadores.add(sxp.getIdProfesor());
			}

			object.put("status", "ok");
			object.put("salones", salones);
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurri� un error buscando el evento");
		}

		response.setCharacterEncoding("UTF-8");
		writeObject(object, response);
	}

	@RequestMapping("pages/social/saveSocial")
	public void saveSaleSchedule(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

			String idEvento = request.getParameter("id_evento");
			String fecha = request.getParameter("fecha");
			String duracionHoras = request.getParameter("duracion_horas");
			String idTipoEvento = request.getParameter("id_tipo_evento");
			String idEquipos = request.getParameter("id_equipo");
			String idEvaluadores = request.getParameter("id_evaluador");

			Evento evento = new Evento();
			evento.setFecha(formatter.parse(fecha));
			evento.setIdTipoEvento(Integer.parseInt(idTipoEvento));
			evento.setDuracionHoras(Integer.parseInt(duracionHoras));

			Socializacion socializacion = null;

			if (idEvento != null && !idEvento.isEmpty() && !idEvento.equals("0") && !idEvento.equals("undefined")
					&& !idEvento.equals("null")) {
				evento.setIdEvento(Integer.parseInt(idEvento));
				dao.getEventoMapper().updateByPrimaryKey(evento);

				SocializacionExample sEx = new SocializacionExample();
				sEx.createCriteria().andIdEventoEqualTo(evento.getIdEvento());
				socializacion = dao.getSocializacionMapper().selectByExample(sEx).get(0);

			} else {
				int idEventoInt = dao.getEventoMapper().getNextId();
				evento.setIdEvento(idEventoInt);
				dao.getEventoMapper().insert(evento);
				// creamos la socializaci�n
				socializacion = new Socializacion();
				int idSocializacion = dao.getSocializacionMapper().getNextId();
				socializacion.setIdSocializacion(idSocializacion);
				socializacion.setIdEvento(evento.getIdEvento());
				dao.getSocializacionMapper().insert(socializacion);

			}

			// asignamos los equipos y evaluadores a socializaci�n

			String[] idEquiposArrStr = idEquipos.split(",");
			String[] idEvaluadoresArrStr = idEvaluadores.split(",");

			// int[] equipos = new int[idEquiposArrStr.length];
			// for (int i = 0; i < equipos.length; i++) {
			// equipos[i] = Integer.parseInt(idEquiposArrStr[i]);
			// }

			// primeros eliminamos
			SalonxequipoExample sxeEx = new SalonxequipoExample();
			sxeEx.createCriteria().andIdSocializacionEqualTo(socializacion.getIdSocializacion());

			SalonxprofesoresExample sxpEx = new SalonxprofesoresExample();
			sxpEx.createCriteria().andIdSocializacionEqualTo(socializacion.getIdSocializacion());

			dao.getSalonxequipoMapper().deleteByExample(sxeEx);
			dao.getSalonxprofesoresMapper().deleteByExample(sxpEx);

			// despues recorremos
			for (String idEquipoStr : idEquiposArrStr) {
				String[] idEquipoStrArr = idEquipoStr.split("_");
				String idSalon = idEquipoStrArr[0];
				String idEquipo = idEquipoStrArr[1];
				Salonxequipo sxe = new Salonxequipo();
				sxe.setIdEquipo(Integer.parseInt(idEquipo));
				sxe.setIdSalon(Integer.parseInt(idSalon));
				sxe.setIdSocializacion(socializacion.getIdSocializacion());
				dao.getSalonxequipoMapper().insert(sxe);
			}

			for (String idEvaluadorStr : idEvaluadoresArrStr) {
				String[] idEvaluadorStrArr = idEvaluadorStr.split("_");
				String idSalon = idEvaluadorStrArr[0];
				String idEvaluador = idEvaluadorStrArr[1];
				Salonxprofesores sxp = new Salonxprofesores();
				sxp.setIdProfesor(Integer.parseInt(idEvaluador));
				sxp.setIdSalon(Integer.parseInt(idSalon));
				sxp.setIdSocializacion(socializacion.getIdSocializacion());
				dao.getSalonxprofesoresMapper().insert(sxp);
			}

			object.put("status", "ok");
			object.put("message", "Se ha creado la asesoria correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurri� un error guardando el asesoria");
		}
		writeObject(object, response);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/social/deleteSocial")
	public void deleteSchedule(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String idEvento = request.getParameter("id_evento");
			if (idEvento != null && !idEvento.isEmpty() && !idEvento.equals("0") && !idEvento.equals("undefined")
					&& !idEvento.equals("null")) {
				EventoExample aseEx = new EventoExample();
				aseEx.createCriteria().andIdEventoEqualTo(Integer.parseInt(idEvento));
				List<Evento> aseList = dao.getEventoMapper().selectByExample(aseEx);
				if (aseList != null && !aseList.isEmpty()) {
					
					//buscamos socializaciones y despues buscamos el 
					SocializacionExample seEx = new SocializacionExample();
					seEx.createCriteria().andIdEventoEqualTo(aseList.get(0).getIdEvento());
					
					List<Socializacion> socs = dao.getSocializacionMapper().selectByExample(seEx);
					Socializacion soc = socs.get(0);
					int idSoc = soc.getIdSocializacion();
					
					SalonxequipoExample sxeEx = new SalonxequipoExample();
					sxeEx.createCriteria().andIdSocializacionEqualTo(idSoc);
					
					List<Salonxequipo> salonesxequipos = dao.getSalonxequipoMapper().selectByExample(sxeEx);
					
					CalifxsocExample califxsocEx = new CalifxsocExample();
					califxsocEx.createCriteria().andIdSalonxequipoIn(salonesxequipos.stream().map(Salonxequipo::getIdSalonxequipo).collect(Collectors.toList()));
					
					List<Califxsoc> califxsoc = dao.getCalifxsocMapper().selectByExample(califxsocEx);
					
					if(!califxsoc.isEmpty()) {
						object.put("status", "errors");
						object.put("message", "El evento ya tiene registros de realizado no se puede eliminar");
					}else {	
						dao.getSalonxequipoMapper().deleteByExample(sxeEx);
						
						SalonxprofesoresExample sxpEx = new SalonxprofesoresExample();
						sxpEx.createCriteria().andIdSocializacionEqualTo(idSoc);
						
						dao.getSalonxprofesoresMapper().deleteByExample(sxpEx);
						
						dao.getSocializacionMapper().deleteByPrimaryKey(idSoc);
						
						dao.getEventoMapper().deleteByExample(aseEx);
						object.put("status", "ok");
						object.put("message", "Se ha eliminado el evento correctamente");
					}
				} else {
					object.put("status", "errors");
					object.put("message", "No se encontr� el evento a eliminar");
				}
			} else {
				object.put("status", "errors");
				object.put("message", "Ocurri� un error eliminando el evento");
			}
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurri� un error eliminando el evento");
		}
		writeObject(object, response);
	}

	private JSONObject getPosition(JSONArray jsonArray, int indice) throws JSONException {
		for (Object obj : jsonArray) {
			if (((JSONObject) obj).containsKey("idSalon")
					&& Integer.parseInt(((JSONObject) obj).get("idSalon").toString()) == indice) {
				return (JSONObject) obj;
			}
		}
		return null; // it wasn't found at all
	}

	public void writeObject(JSONObject object, HttpServletResponse response) {
		try {
			object.writeJSONString(response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
