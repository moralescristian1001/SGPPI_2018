package com.spring.controllers;

import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.models.AsignaturaExample;
import com.mybatis.models.Cuadrante;
import com.mybatis.models.CuadranteExample;
import com.springMybatis.persistence.daoHelper;

@Controller
public class quadrantController {
	daoHelper dao = new daoHelper();

	@RequestMapping("pages/quadrant")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {
//			System.out.println(dao.getAsignaturaMapper().selectByExample(new AsignaturaExample()));
			model.addAttribute("listAsig", dao.getAsignaturaMapper().selectByExample(new AsignaturaExample()));
			model.addAttribute("listCuadrantes", dao.getCuadranteMapper().getRecords());
			model.addAttribute("ListEquipos", dao.getEquipoMapper().getRecords());
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			return new ModelAndView("pages/quadrant");
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

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/quadrant/saveQuadrant")
	public void saveSaleCuadra(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String idCuadra = request.getParameter("idCuadra");
			String num = request.getParameter("num");
			String nomCuadra = request.getParameter("nomCuadra");
			String desCuadra = request.getParameter("desCuadra");
			String asigAso = request.getParameter("asigAso");

			Cuadrante cuadrant = new Cuadrante();
			cuadrant.setNumero(Integer.parseInt(num));
			;
			cuadrant.setNombre(nomCuadra);
			cuadrant.setDescripcion(desCuadra);
			cuadrant.setIdAsignatura(Integer.parseInt(asigAso));
			cuadrant.setIdSemestre(1);
			if (idCuadra != null && !idCuadra.isEmpty() && !idCuadra.equals("0") && !idCuadra.equals("undefined")
					&& !idCuadra.equals("null")) {
				cuadrant.setIdCuadrante(Integer.parseInt(idCuadra));
				dao.getCuadranteMapper().updateByPrimaryKey(cuadrant);
			} else {
				dao.getCuadranteMapper().insert(cuadrant);
			}

			object.put("status", "ok");
			object.put("message", "Se ha creado el cuadrante correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando el cuadrante");
		}
		writeObject(object, response);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/quadrant/deleteQuadrant")
	public void deleteCuadra(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String idCuadra = request.getParameter("idCuadra");
			if (idCuadra != null && !idCuadra.isEmpty() && !idCuadra.equals("0") && !idCuadra.equals("undefined")
					&& !idCuadra.equals("null")) {
				CuadranteExample cuaEx = new CuadranteExample();
				cuaEx.createCriteria().andIdCuadranteEqualTo(Integer.parseInt(idCuadra));
				List<Cuadrante> cuadraList = dao.getCuadranteMapper().selectByExample(cuaEx);
				if (cuadraList != null && !cuadraList.isEmpty()) {
					dao.getCuadranteMapper().deleteByExample(cuaEx);
					object.put("status", "ok");
					object.put("message", "Se ha eliminado el cuadrante correctamente");
				} else {
					object.put("status", "errors");
					object.put("message", "No se encontró el cuadrante a eliminar");
				}
			} else {
				object.put("status", "errors");
				object.put("message", "Ocurrió un error eliminando el cuadrante");
			}
		} catch (Exception e) {
			object.put("status", "errors");
			object.put("message", "Ocurrió un error eliminando el cuadrante");
		}
		writeObject(object, response);
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
