package com.spring.controllers;


import java.util.List;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mybatis.models.Usuarios;
import com.mybatis.models.UsuariosExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class login {
	daoHelper dao = new daoHelper();

	@SuppressWarnings("unchecked")
	@RequestMapping("login")
	public void logIn(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			
			Usuarios user = new Usuarios();
			
			user.setClave(password);
			user.setCorreo(email);
			
			if(new UsuariosExample().validateLogin(user)){
				
				request.getSession().setAttribute("user", user);
				object.put("status", "ok");
			}else{
				object.put("status", "errors");
				object.put("message", "Correo o contraseña no válidas");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error validando los datos");
		}
		response.setCharacterEncoding("UTF-8");

		writeObject(object, response);
	}
	@RequestMapping("pages/logout")
	public void logOut(HttpServletRequest request, HttpServletResponse response) {
		
		try {						
			request.getSession().setAttribute("user", null);
			response.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("../index.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void writeObject(JSONObject object, HttpServletResponse response) {
		try {
			object.writeJSONString(response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
