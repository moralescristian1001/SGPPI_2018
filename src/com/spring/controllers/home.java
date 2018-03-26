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

import com.mybatis.models.Asignatura;
import com.mybatis.models.AsignaturaExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class home {
	daoHelper dao = new daoHelper();

	@RequestMapping("pages/home")
	public String sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if(request.getSession().getAttribute("user") != null){
//			Usuarios usu = request.getSession().getAttribute("user");
			return "pages/home";
//			return new ModelAndView("pages/sunModule");
		}else{
//			return new ModelAndView("index");
//			try {
//				response.getWriter().write("<script>location.href='../index.jsp';</script>");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			return "/index";
		}
		
	}

	public void writeObject(JSONObject object, HttpServletResponse response) {
		try {
			object.writeJSONString(response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
	}
}
