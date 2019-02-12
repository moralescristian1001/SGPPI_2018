package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class qualifyGradeReportController {

	daoHelper dao = new daoHelper();

	@RequestMapping("pages/qualifyGradeReport")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {
			if(request.getParameter("id_socializacion") == null) {
				model.addAttribute("errors", "Error consiguiendo la socializaciÃ³n");
				return new ModelAndView("pages/home");
			}else {
				Integer idSocializacion = Integer.parseInt(request.getParameter("id_socializacion"));
				Usuarios usuario = (Usuarios)request.getSession().getAttribute("user");
				
				//capturamos la socializacion
				
				Socializacion soc = dao.getSocializacionMapper().selectByPrimaryKey(idSocializacion);
				Evento evento = dao.getEventoMapper().selectByPrimaryKey(soc.getIdEvento());
				//capturamos los profesores de esa socializaciÃ³n
				SalonxprofesoresExample sxpEx = new SalonxprofesoresExample();
				sxpEx.createCriteria().andIdSocializacionEqualTo(idSocializacion);
				List<Salonxprofesores> salonxprofesores = dao.getSalonxprofesoresMapper().selectByExample(sxpEx);
				
				UsuariosExample proEx = new UsuariosExample();
				proEx.createCriteria().andIdUsuarioIn(salonxprofesores.stream().map(Salonxprofesores::getIdProfesor).collect(Collectors.toList()));
				List<Usuarios> profesores = dao.getUsuariosMapper().selectByExample(proEx); 
				
				//capturamos los equipos
				SalonxequipoExample sxeEx = new SalonxequipoExample();
				sxeEx.createCriteria().andIdSocializacionEqualTo(idSocializacion);
				List<Salonxequipo> salonxequipos = dao.getSalonxequipoMapper().selectByExample(sxeEx);
				
				List<Salon> salones = dao.getSalonMapper().selectByExample(new SalonExample());

				EquipoExample eEx = new EquipoExample();
				eEx.createCriteria().andIdEquipoIn(salonxequipos.stream().map(Salonxequipo::getIdEquipo).collect(Collectors.toList()));
				List<Equipo> equipos = dao.getEquipoMapper().selectByExample(eEx);
				
				CalifxsocExample cxsEx = new CalifxsocExample();
				cxsEx.createCriteria().andIdSalonxequipoIn(salonxequipos.stream().map(Salonxequipo::getIdSalonxequipo).collect(Collectors.toList()));
				
				List<Califxsoc> califxsoc = dao.getCalifxsocMapper().selectByExample(cxsEx);
				
				NotasxcalifxsocExample nxcxsEx = new NotasxcalifxsocExample();
				nxcxsEx.createCriteria().andIdCalifxsocIn(califxsoc.stream().map(Califxsoc::getIdCalifxsoc).collect(Collectors.toList()));
				
				List<Notasxcalifxsoc> notasxcalifxsoc = dao.getNotasxcalifxsocMapper().selectByExample(nxcxsEx);
					
				RubricaxitemExample rxiEx = new RubricaxitemExample(); 
				rxiEx.createCriteria().andIdRubricaxitemIn(notasxcalifxsoc.stream().map(Notasxcalifxsoc::getIdRubricaxitem).collect(Collectors.toList()));
				List<Rubricaxitem> rubricasxitem = dao.getRubricaxitemMapper().selectByExample(rxiEx);
				
				RubricaExample rubricaEx = new RubricaExample(); 
				rubricaEx.createCriteria().andIdRubricaIn(rubricasxitem.stream().map(Rubricaxitem::getIdRubrica).collect(Collectors.toList()));
				rubricaEx.setOrderByClause("numero ASC");
				List<Rubrica> rubricas = dao.getRubricaMapper().selectByExample(rubricaEx);
				
				
				List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(new AsignaturaExample());
				
				
				
				model.addAttribute("soc", soc);
				model.addAttribute("evento", evento);
				
				model.addAttribute("salonxprofesores", salonxprofesores);
				model.addAttribute("salonxequipos", salonxequipos);
				model.addAttribute("salones", salones);
				model.addAttribute("profesores", profesores);
				
				
				model.addAttribute("equipos", equipos);
				model.addAttribute("califxsoc", califxsoc);
				model.addAttribute("notasxcalifxsoc", notasxcalifxsoc);
				
				model.addAttribute("rubricasxitem", rubricasxitem);
				model.addAttribute("rubricas", rubricas);
				
				model.addAttribute("asignaturas", asignaturas);
				model.addAttribute("user", usuario);
				
				return new ModelAndView("pages/qualifyGradeReport");
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

	@RequestMapping("pages/qualifyGradeReport/getInformation")
	public void saveSaleQualify(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			JSONArray info = new  JSONArray();
			
			
			object.put("status", "ok");
			object.put("message", "Se ha creado la calificación correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando la calificación");
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
