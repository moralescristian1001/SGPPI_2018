package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.mybatis.models.Semestre;
import com.mybatis.models.SolicitudAsesoria;
import com.mybatis.models.SolicitudAsesoriaExample;
import com.mybatis.models.Usuarios;
import com.mybatis.models.UsuariosExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class requestController {

	daoHelper dao = new daoHelper();

	@RequestMapping("pages/request")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {
			// System.out.println(dao.getAsignaturaMapper().selectByExample(new
			// AsignaturaExample()));

			Usuarios usu = (Usuarios) request.getSession().getAttribute("user");
			model.addAttribute("user", usu);
			
			
			//si el usuario tiene un equipo y es de este semestre
			if (request.getSession().getAttribute("team") != null) {
				
				Equipo equipoEstudiante = (Equipo)request.getSession().getAttribute("team");
				
				
				List<Integer> cargosAsesores = new ArrayList<>();
				cargosAsesores.add(3);
				cargosAsesores.add(6);
				
				UsuariosExample usuEx = new UsuariosExample();
				usuEx.createCriteria().andIdCargoIn(cargosAsesores).andEstadoEqualTo(true);

				List<Usuarios> asesores = dao.getUsuariosMapper().selectByExample(usuEx);

				AsesoriasExample aEx = new AsesoriasExample();
				aEx.createCriteria().andIdSemestreEqualTo(((Semestre)request.getSession().getAttribute("semestre")).getIdSemestre());
				List<Asesorias> asesorias = dao.getAsesoriasMapper().selectByExample(aEx);

				SolicitudAsesoriaExample saEx = new SolicitudAsesoriaExample();
				saEx.createCriteria().andAceptadaEqualTo(false).andIdEquipoEqualTo(equipoEstudiante.getIdEquipo());

				List<SolicitudAsesoria> solicitudes = dao.getSolicitudAsesoriaMapper().selectByExample(saEx);
				
				model.addAttribute("equipoEstudiante", equipoEstudiante);
				model.addAttribute("listAsesorias", asesorias);
				model.addAttribute("listSolicitudes", solicitudes);
				model.addAttribute("listAsesores", asesores);
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				return new ModelAndView("pages/request");
			} else {
				model.addAttribute("errors", "No tienes equipo asignado");
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
	@SuppressWarnings("unchecked")
	@RequestMapping("pages/request/saveRequest")
	public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			
			Equipo equipoEstudiante = (Equipo)request.getSession().getAttribute("team");
			
			int diaSemana = Integer.parseInt(request.getParameter("dia_semana"));
			double horaSemana = Double.parseDouble(request.getParameter("hora_semana"));

			SolicitudAsesoria solicitud = new SolicitudAsesoria();
			solicitud.setIdEquipo(equipoEstudiante.getIdEquipo());
			solicitud.setDiaSemana(diaSemana);
			solicitud.setHoraSemana(horaSemana);
			solicitud.setAceptada(false);
			solicitud.setFechaSolicitud(new Date());
			
			dao.getSolicitudAsesoriaMapper().insert(solicitud);
			

			object.put("status", "ok");
			object.put("message", "Se ha creado la solicitud correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando la solicitud");
		}
		response.setCharacterEncoding("UTF-8");
		writeObject(object, response);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/request/deleteRequest")
	public void deleteRequest(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String idSolicitud = request.getParameter("id_solicitud");
			if (idSolicitud!= null && !idSolicitud.isEmpty() && !idSolicitud.equals("0")
					&& !idSolicitud.equals("undefined") && !idSolicitud.equals("null")) {
				SolicitudAsesoriaExample soliEx = new SolicitudAsesoriaExample();
				soliEx.createCriteria().andIdSolicitudEqualTo(Integer.parseInt(idSolicitud));
				List<SolicitudAsesoria> soliList = dao.getSolicitudAsesoriaMapper().selectByExample(soliEx);
				if (soliList != null && !soliList.isEmpty()) {
					dao.getSolicitudAsesoriaMapper().deleteByExample(soliEx);
					object.put("status", "ok");
					object.put("message", "Se ha eliminado la solicitud correctamente");
				} else {
					object.put("status", "errors");
					object.put("message", "No se encontró la solicitud a eliminar");
				}
			} else {
				object.put("status", "errors");
				object.put("message", "Ocurrió un error eliminando la solicitud");
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
