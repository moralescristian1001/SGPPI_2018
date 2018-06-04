package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
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
import com.mybatis.models.Seguimiento;
import com.mybatis.models.SeguimientoAsistencia;
import com.mybatis.models.SeguimientoAsistenciaExample;
import com.mybatis.models.SeguimientoExample;
import com.mybatis.models.Semestre;
import com.mybatis.models.SolicitudAsesoria;
import com.mybatis.models.SolicitudAsesoriaExample;
import com.mybatis.models.Usuarios;
import com.mybatis.models.UsuariosExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class tracingController {

	daoHelper dao = new daoHelper();

	@RequestMapping("pages/tracing")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {
			// System.out.println(dao.getAsignaturaMapper().selectByExample(new
			// AsignaturaExample()));

			Usuarios usu = (Usuarios) request.getSession().getAttribute("user");
			Semestre semestreActual = (Semestre) request.getSession().getAttribute("semestre");

			model.addAttribute("user", usu);
			Calendar rightNow = Calendar.getInstance();
			int hora = rightNow.get(Calendar.HOUR_OF_DAY);
			int dia = rightNow.get(Calendar.DAY_OF_WEEK) - 1;
			List<Integer> cargosAsesores = new ArrayList<>();
			cargosAsesores.add(3);
			cargosAsesores.add(6);

			if (cargosAsesores.contains(usu.getIdCargo())) {
				// asesor
				AsesoriasExample aEx = new AsesoriasExample();
				aEx.createCriteria().andIdAsesorEqualTo(usu.getIdUsuario())
						.andIdSemestreEqualTo(semestreActual.getIdSemestre());
				List<Asesorias> asesorias = dao.getAsesoriasMapper().selectByExample(aEx);

				EquipoExample eEx = new EquipoExample();
				eEx.createCriteria().andIdSemestreEqualTo(semestreActual.getIdSemestre());
				List<Equipo> equipos = dao.getEquipoMapper().selectByExample(eEx);

				model.addAttribute("dia", dia);
				model.addAttribute("hora", hora);
				model.addAttribute("listAsesorias", asesorias);
				model.addAttribute("listEquipos", equipos);
				return new ModelAndView("pages/tracing_asesoria");
			} else {
				// estudiante
				// si el usuario tiene un equipo y es de este semestre
				if (request.getSession().getAttribute("team") != null) {

					Equipo equipoEstudiante = (Equipo) request.getSession().getAttribute("team");

					UsuariosExample usuEx = new UsuariosExample();
					usuEx.createCriteria().andIdCargoIn(cargosAsesores).andEstadoEqualTo(true);

					List<Usuarios> asesores = dao.getUsuariosMapper().selectByExample(usuEx);

					AsesoriasExample aEx = new AsesoriasExample();
					aEx.createCriteria().andIdSemestreEqualTo(
							((Semestre) request.getSession().getAttribute("semestre")).getIdSemestre());
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
					return new ModelAndView("pages/tracing");
				} else {
					model.addAttribute("errors", "No tienes equipo asignado");
					return new ModelAndView("pages/home");
				}
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

	@RequestMapping("pages/tracing/verTracing")
	public void verTracing(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();

		int idAsesoria = Integer.parseInt(request.getParameter("id_asesoria"));
		
		Asesorias asesoria = dao.getAsesoriasMapper().selectByPrimaryKey(idAsesoria);
		
		SeguimientoExample segEx = new SeguimientoExample();
		segEx.createCriteria().andIdAsesoriaEqualTo(idAsesoria);
		List<Seguimiento> seguimientos = dao.getSeguimientoMapper().selectByExample(segEx);
		
		EstudiantesxequiposExample eeEx = new EstudiantesxequiposExample();
		eeEx.createCriteria().andIdEquipoEqualTo(asesoria.getIdEquipo());
		
		List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(eeEx);
		
		JSONArray estudiantes = new JSONArray();
		for(Estudiantesxequipos exe : exes){
			Usuarios est = dao.getUsuariosMapper().selectByPrimaryKey(exe.getIdEstudiante());
			JSONObject estObj = new JSONObject();
			estObj.put("id_usuario", est.getIdUsuario());
			estObj.put("nombre_completo", est.getNombre() + " " + est.getApellidos());
			estudiantes.add(estObj);
		}
		JSONArray jsonSeguimientos = new JSONArray();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		
		
		for(Seguimiento seg : seguimientos){
			JSONObject segObj = new JSONObject();
			segObj.put("fecha", df.format(seg.getFecha()));
			segObj.put("observaciones", seg.getObservaciones());
			
			//searching estudiantes faltantes
			SeguimientoAsistenciaExample saEx = new SeguimientoAsistenciaExample();
			saEx.createCriteria().andIdSeguimientoEqualTo(seg.getIdSeguimiento());
			List<Integer> estAsistencia = dao.getSeguimientoAsistenciaMapper().selectByExample(saEx).stream().map(SeguimientoAsistencia::getIdEstudiante).collect(Collectors.toList());
			
			String noAsistentes = "";
			for(Estudiantesxequipos exe : exes){
				if(!estAsistencia.contains(exe.getIdEstudiante())){
					
					Usuarios est = dao.getUsuariosMapper().selectByPrimaryKey(exe.getIdEstudiante());
					noAsistentes += "<li>" +est.getNombre() + " " + est.getApellidos() + "</li>"; 
				}
			}
			if(!noAsistentes.isEmpty()){
				noAsistentes = "<ul>" + noAsistentes + "</ul>";
			}else{
				noAsistentes = "Sin Faltantes";
			}
			segObj.put("estudiantes_faltaron", noAsistentes);
			jsonSeguimientos.add(segObj);
		}
		object.put("seguimientos", jsonSeguimientos);
		object.put("estudiantes", estudiantes);

		writeObject(object, response);
	}

	@RequestMapping("pages/tracing/saveTracing")
	public void saveTracing(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {	
		
			int idAsesoria = Integer.parseInt(request.getParameter("id_asesoria"));
			String observaciones = request.getParameter("observaciones");
			String asistencia = request.getParameter("asistencia");
			
			String[] asistenciaArray = asistencia.split(",");
			
			Seguimiento seguimiento = new Seguimiento();
			
			int idSeguimiento = dao.getSeguimientoMapper().getNextId();
			
			seguimiento.setIdSeguimiento(idSeguimiento);
			seguimiento.setIdAsesoria(idAsesoria);
			seguimiento.setFecha(new Date());
			seguimiento.setObservaciones(observaciones);
			
			
			dao.getSeguimientoMapper().insert(seguimiento);
			
			for(String idEstudiante : asistenciaArray){
				SeguimientoAsistencia sa = new SeguimientoAsistencia();
				sa.setIdEstudiante(Integer.parseInt(idEstudiante));
				sa.setIdSeguimiento(idSeguimiento);
				dao.getSeguimientoAsistenciaMapper().insert(sa);
			}

			object.put("status", "ok");
			object.put("message", "Se ha creado el seguimiento correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando el seguimiento");
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
