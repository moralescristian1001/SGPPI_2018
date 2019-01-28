package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.models.AsignaturaExample;
import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import com.mybatis.models.Estudiantesxequipos;
import com.mybatis.models.EstudiantesxequiposExample;
import com.mybatis.models.Usuarios;
import com.springMybatis.persistence.daoHelper;

@Controller
public class changePassword {
	daoHelper dao = new daoHelper();

	@RequestMapping("pages/changePassword")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		Usuarios usuario = (Usuarios)request.getSession().getAttribute("user");
		model.addAttribute("user", usuario);
		return new ModelAndView("pages/changePassword");
		
	}
	
	@RequestMapping("pages/changePassword/savePassword")
	public void saveSaleTeam(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();

		try {
			Usuarios usuario = (Usuarios)request.getSession().getAttribute("user");
			String claveAnterior = request.getParameter("clave_anterior");
			String claveNueva = request.getParameter("clave_nueva");
			if(!usuario.getClave().equals(claveAnterior)) {
				object.put("status", "errors");
				object.put("message", "La clave anterior no concuerda con la que esta almacenada");
			}else {
				usuario.setClave(claveNueva);
				usuario.setCambioClave(true);
				dao.getUsuariosMapper().updateByPrimaryKey(usuario);
				object.put("status", "ok");
				object.put("message", "Se ha guardado la clave correctamente");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando la clave");
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
