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
import com.mybatis.models.Usuarios;
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
				model.addAttribute("user", (Usuarios)request.getSession().getAttribute("user"));
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
