package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.models.AsignaturaExample;
import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import com.mybatis.models.Semestre;
import com.mybatis.models.Usuarios;
import com.mybatis.models.UsuariosExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class home {
	daoHelper dao = new daoHelper();

	@RequestMapping("pages/home")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if(request.getSession().getAttribute("user") != null){
			Usuarios usuario = (Usuarios)request.getSession().getAttribute("user");
			if(!usuario.getCambioClave()) {
				try {
				response.getWriter().write("<script>location.href='./changePassword.html';</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}else {
				UsuariosExample usuariosEx = new UsuariosExample();
				usuariosEx.createCriteria().andEstadoEqualTo(true);
				List<Usuarios> usuariosActivos = dao.getUsuariosMapper().selectByExample(usuariosEx);
				
				Semestre sem = dao.getSemestreMapper().selectSemestreActual();
				EquipoExample eEx = new EquipoExample();
				eEx.createCriteria().andIdSemestreEqualTo(sem.getIdSemestre());
				List<Equipo> equiposActivos = dao.getEquipoMapper().selectByExample(eEx);
				
				model.addAttribute("user", (Usuarios)request.getSession().getAttribute("user"));
				model.addAttribute("usuarios_creados", String.valueOf(usuariosActivos.size()));
				model.addAttribute("semestreActual", sem.getAno() + " - " + sem.getNumero());
				model.addAttribute("equipos_creados", String.valueOf(equiposActivos.size()));
				return new ModelAndView("pages/home");
			}
		}else{
			
			try {
				response.getWriter().write("<script>location.href='../index.jsp';</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	}
}
