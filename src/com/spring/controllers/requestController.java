package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.mybatis.models.Estudiantesxequipos;
import com.mybatis.models.EstudiantesxequiposExample;
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
			
			//obtenemos el semestre actual
			int idSemestreActual = dao.getSemestreMapper().selectSemestreActual().getIdSemestre();

			//equipos del semestra actual
			EquipoExample eEx = new EquipoExample();
			eEx.createCriteria().andIdSemestreEqualTo(idSemestreActual);
			List<Equipo> equipos = dao.getEquipoMapper().selectByExample(eEx);

			//obteniendo el equipo del usuario
			EstudiantesxequiposExample axeEx = new EstudiantesxequiposExample();
			axeEx.createCriteria().andIdEstudianteEqualTo(usu.getIdUsuario())
					.andIdEquipoIn(equipos.stream().map(Equipo::getIdEquipo).collect(Collectors.toList()));
			List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(axeEx);
			
			
			//si el usuario tiene un equipo y es de este semestre
			if (!exes.isEmpty() && exes.size() == 1) {
				
				Equipo equipoEstudiante = dao.getEquipoMapper().selectByPrimaryKey(exes.get(0).getIdEquipo());
				
				UsuariosExample usuEx = new UsuariosExample();
				usuEx.createCriteria().andIdCargoEqualTo(3).andEstadoEqualTo(true);

				List<Usuarios> asesores = dao.getUsuariosMapper().selectByExample(usuEx);

				AsesoriasExample aEx = new AsesoriasExample();
				aEx.createCriteria().andIdSemestreEqualTo(idSemestreActual);
				List<Asesorias> asesorias = dao.getAsesoriasMapper().selectByExample(aEx);

				SolicitudAsesoriaExample saEx = new SolicitudAsesoriaExample();
				saEx.createCriteria().andAceptadaEqualTo(false).andIdEquipoEqualTo(equipoEstudiante.getIdEquipo());

				List<SolicitudAsesoria> solicitudes = dao.getSolicitudAsesoriaMapper().selectByExample(saEx);

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

	@RequestMapping("pages/request/saveRequest")
	public void saveSaleSchedule(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {

			Usuarios estudiante = (Usuarios) request.getSession().getAttribute("user");
			
			int idSemestreActual = dao.getSemestreMapper().selectSemestreActual().getIdSemestre();
			
			//equipos del semestra actual
			EquipoExample eEx = new EquipoExample();
			eEx.createCriteria().andIdSemestreEqualTo(idSemestreActual);
			List<Equipo> equipos = dao.getEquipoMapper().selectByExample(eEx);
			
			EstudiantesxequiposExample axeEx = new EstudiantesxequiposExample();
			axeEx.createCriteria().andIdEstudianteEqualTo(estudiante.getIdUsuario())
					.andIdEquipoIn(equipos.stream().map(Equipo::getIdEquipo).collect(Collectors.toList()));
			List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(axeEx);
			
			
			
			String idSolicitud = request.getParameter("id_asesoria");
			int diaSemana = Integer.parseInt(request.getParameter("dia_semana"));
			int horaSemana = Integer.parseInt(request.getParameter("hora_semana"));

			SolicitudAsesoria solicitud = new SolicitudAsesoria();
			solicitud.setIdEquipo(exes.get(0).getIdEquipo());
			solicitud.setDiaSemana(diaSemana);
			solicitud.setHoraSemana(horaSemana);
			solicitud.setAceptada(false);
			

			if (idSolicitud != null && !idSolicitud.isEmpty() && !idSolicitud.equals("0")
					&& !idSolicitud.equals("undefined") && !idSolicitud.equals("null")) {
				solicitud.setIdSolicitud(Integer.parseInt(idSolicitud));
				dao.getSolicitudAsesoriaMapper().updateByPrimaryKey(solicitud);
			} else {
				dao.getSolicitudAsesoriaMapper().insert(solicitud);
			}

			object.put("status", "ok");
			object.put("message", "Se ha creado la solicitud correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando la solicitud");
		}
		writeObject(object, response);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/request/deleteRequest")
	public void deleteSchedule(HttpServletRequest request, HttpServletResponse response) {
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
