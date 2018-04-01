package com.spring.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.mybatis.models.Usuarios;
import com.springMybatis.persistence.daoHelper;

@Controller
public class scheduleController {
	
	daoHelper dao = new daoHelper();
	
	@RequestMapping("pages/schedule")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response) throws UnsupportedEncodingException{
		if (request.getSession().getAttribute("user") != null) {
//			System.out.println(dao.getAsignaturaMapper().selectByExample(new AsignaturaExample()));
			model.addAttribute("user", (Usuarios)request.getSession().getAttribute("user"));
			model.addAttribute("listSchedules", dao.getCuadranteMapper().getRecords());
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
	
}
