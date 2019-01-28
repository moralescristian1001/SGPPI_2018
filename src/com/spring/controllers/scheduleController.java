package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.models.Asesorias;
import com.mybatis.models.AsesoriasExample;
import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import com.mybatis.models.SolicitudAsesoria;
import com.mybatis.models.SolicitudAsesoriaExample;
import com.mybatis.models.Usuarios;
import com.springMybatis.persistence.daoHelper;

@Controller
public class scheduleController {

	daoHelper dao = new daoHelper();

	@RequestMapping("pages/schedule")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {
			// System.out.println(dao.getAsignaturaMapper().selectByExample(new
			// AsignaturaExample()));
			Usuarios usu = (Usuarios) request.getSession().getAttribute("user");
			model.addAttribute("user", (Usuarios) request.getSession().getAttribute("user"));

			int idSemestreActual = dao.getSemestreMapper().selectSemestreActual().getIdSemestre();

			EquipoExample eEx = new EquipoExample();
			eEx.createCriteria().andIdSemestreEqualTo(idSemestreActual);
			List<Equipo> equipos = dao.getEquipoMapper().selectByExample(eEx);

			List<SolicitudAsesoria> solicitudes = new ArrayList<>();
			List<Asesorias> asesorias = new ArrayList<>();
			
			if (!equipos.isEmpty()) {
				AsesoriasExample aEx = new AsesoriasExample();
				aEx.createCriteria().andIdSemestreEqualTo(idSemestreActual).andIdAsesorEqualTo(usu.getIdUsuario());
				asesorias = dao.getAsesoriasMapper().selectByExample(aEx);
				SolicitudAsesoriaExample sEx = new SolicitudAsesoriaExample();
				sEx.createCriteria().andAceptadaEqualTo(false)
						.andIdEquipoIn(equipos.stream().map(Equipo::getIdEquipo).collect(Collectors.toList()));
				solicitudes = dao.getSolicitudAsesoriaMapper().selectByExample(sEx);
			}
			model.addAttribute("listRequests", solicitudes);
			model.addAttribute("listSchedules", asesorias);
			model.addAttribute("listTeams", equipos);
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			return new ModelAndView("pages/schedule");
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
	@SuppressWarnings("unchecked")
	@RequestMapping("pages/schedule/saveSchedule")
	public void saveSaleSchedule(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {

			int idSemestreActual = dao.getSemestreMapper().selectSemestreActual().getIdSemestre();

			Usuarios asesor = (Usuarios) request.getSession().getAttribute("user");

			String idAsesoria = request.getParameter("id_asesoria");
			Integer idEquipo = request.getParameter("id_equipo").equals("-1") ? null
					: Integer.parseInt(request.getParameter("id_equipo"));
			int diaSemana = Integer.parseInt(request.getParameter("dia_semana"));
			double horaSemana = Double.parseDouble(request.getParameter("hora_semana"));
			String idSolicitud = request.getParameter("id_solicitud");

			Asesorias asesoria = new Asesorias();
			asesoria.setIdEquipo(idEquipo);
			asesoria.setDiaSemana(diaSemana);
			asesoria.setHoraSemana(horaSemana);
			asesoria.setIdSemestre(idSemestreActual);
			asesoria.setIdAsesor(asesor.getIdUsuario());

			if (idAsesoria != null && !idAsesoria.isEmpty() && !idAsesoria.equals("0")
					&& !idAsesoria.equals("undefined") && !idAsesoria.equals("null")) {
				asesoria.setIdAsesoria(Integer.parseInt(idAsesoria));
				dao.getAsesoriasMapper().updateByPrimaryKey(asesoria);
			} else {
				dao.getAsesoriasMapper().insert(asesoria);
			}
			if (idSolicitud != null && !idSolicitud.isEmpty() && !idSolicitud.equals("0")
					&& !idSolicitud.equals("undefined") && !idSolicitud.equals("null")) {
				SolicitudAsesoria solicitud = dao.getSolicitudAsesoriaMapper()
						.selectByPrimaryKey(Integer.parseInt(idSolicitud));
				if (solicitud.getIdEquipo() == idEquipo) {
					solicitud.setAceptada(true);
					dao.getSolicitudAsesoriaMapper().updateByPrimaryKey(solicitud);
				}

			}
			object.put("status", "ok");
			object.put("message", "Se ha guardado la asesoria correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando el asesoria");
		}
		response.setCharacterEncoding("UTF-8");
		writeObject(object, response);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/schedule/deleteSchedule")
	public void deleteSchedule(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String idAsesoria = request.getParameter("id_asesoria");
			if (idAsesoria != null && !idAsesoria.isEmpty() && !idAsesoria.equals("0")
					&& !idAsesoria.equals("undefined") && !idAsesoria.equals("null")) {
				
				AsesoriasExample aseEx = new AsesoriasExample();
				aseEx.createCriteria().andIdAsesoriaEqualTo(Integer.parseInt(idAsesoria));
				List<Asesorias> aseList = dao.getAsesoriasMapper().selectByExample(aseEx);
				if (aseList != null && !aseList.isEmpty()) {
					dao.getAsesoriasMapper().deleteByExample(aseEx);
					object.put("status", "ok");
					object.put("message", "Se ha eliminado la asesoria correctamente");
				} else {
					object.put("status", "errors");
					object.put("message", "No se encontró la asesoria a eliminar");
				}
			} else {
				object.put("status", "errors");
				object.put("message", "Ocurrió un error eliminando la asesoria");
			}
		} catch (Exception e) {
			object.put("status", "errors");
			object.put("message", "Ocurrió un error eliminando la asesoria");
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
