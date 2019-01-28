package com.spring.controllers;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.models.Usuarios;
import com.springMybatis.persistence.daoHelper;

/**
 * Servlet implementation class aboutUs
 */
@Controller
public class onlineHelp extends HttpServlet {
	daoHelper dao = new daoHelper();

	@RequestMapping("pages/onlineHelp")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		Usuarios usuario = (Usuarios)request.getSession().getAttribute("user");
		model.addAttribute("user", usuario);
		return new ModelAndView("pages/onlineHelp");
		
	}

}
