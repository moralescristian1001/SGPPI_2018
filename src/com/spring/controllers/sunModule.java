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
public class sunModule {
	daoHelper dao = new daoHelper();

	@RequestMapping("pages/sunModule")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if(request.getSession().getAttribute("user") != null){
			model.addAttribute("listAsig", dao.getAsignaturaMapper().selectByExample(new AsignaturaExample()));
			model.addAttribute("listCuadrantes", dao.getCuadranteMapper().getRecords());
			model.addAttribute("ListEquipos", dao.getEquipoMapper().getRecords());
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			return new ModelAndView("pages/sunModule");
		}else{
//			return new ModelAndView("index");
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
	@RequestMapping("pages/sunModule/saveSunModulo")
	public void saveSale(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String idAsig = request.getParameter("idAsig");
			String code = request.getParameter("code");
			String asig = request.getParameter("asig");
			String semes = request.getParameter("semes");

			Asignatura asigna = new Asignatura();
			asigna.setCodigo(code);
			asigna.setNombre(asig);
			
			asigna.setSemestre(Integer.parseInt(semes));

			if (idAsig != null && !idAsig.isEmpty() && !idAsig.equals("0") && !idAsig.equals("undefined")
					&& !idAsig.equals("null")) {
				asigna.setIdAsignatura(Integer.parseInt(idAsig));
				dao.getAsignaturaMapper().updateByPrimaryKey(asigna);
			} else {
				dao.getAsignaturaMapper().insert(asigna);
			}

			object.put("status", "ok");
			object.put("message", "Se ha creado correctamente la asignatura");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando asignatura");
		}
		writeObject(object, response);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("pages/sunModule/deleteSunModule")
	public void deleteSale(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			String idAsig = request.getParameter("idAsig");
			if (idAsig != null && !idAsig.isEmpty() && !idAsig.equals("0") && !idAsig.equals("undefined")
					&& !idAsig.equals("null")) {
				AsignaturaExample asigEx = new AsignaturaExample();
				asigEx.createCriteria().andIdAsignaturaEqualTo(Integer.parseInt(idAsig));
				List<Asignatura> asigna = dao.getAsignaturaMapper().selectByExample(asigEx);
				if (asigna != null && !asigna.isEmpty()) {
					dao.getAsignaturaMapper().deleteByExample(asigEx);
					object.put("status", "ok");
					object.put("message", "Se ha eliminado correctamente la asignatura");
				} else {
					object.put("status", "errors");
					object.put("message", "No se encontró la asignatura a eliminar");
				}
			} else {
				object.put("status", "errors");
				object.put("message", "Ocurrió un error eliminando la asignatura");
			}
		} catch (Exception e) {
			object.put("status", "errors");
			object.put("message", "Ocurrió un error eliminando la asignatura");
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
