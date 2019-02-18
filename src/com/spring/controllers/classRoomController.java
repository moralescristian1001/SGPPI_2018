package com.spring.controllers;

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
import com.mybatis.models.Salon;
import com.mybatis.models.SalonExample;
import com.mybatis.models.Usuarios;
import com.springMybatis.persistence.daoHelper;

@Controller
public class classRoomController {
	
	daoHelper dao = new daoHelper();
	
	@RequestMapping("pages/classRoom")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		Usuarios usuario = (Usuarios)request.getSession().getAttribute("user");
		model.addAttribute("listSalones", dao.getSalonMapper().selectByExample(new SalonExample()));
		model.addAttribute("user", usuario);
		return new ModelAndView("pages/classRoom");
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("pages/classRoom/saveClassRoom")
	public void saveSale(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		try {
			String idSalon = request.getParameter("idSalon");
			String descripcion = request.getParameter("descripcion");
			
			Salon salon = new Salon();
			salon.setDescripcion(descripcion.trim());
			SalonExample salonEx = new SalonExample();
			salonEx.createCriteria().andDescripcionEqualTo(descripcion);
			List<Salon> listSalones = dao.getSalonMapper().selectByExample(salonEx);
			if(listSalones == null || listSalones.isEmpty()) {
				if (idSalon != null && !idSalon.isEmpty() && !idSalon.equals("0") && !idSalon.equals("undefined")
						&& !idSalon.equals("null")) {
					salon.setIdSalon(Integer.parseInt(idSalon));
					dao.getSalonMapper().updateByPrimaryKey(salon);
				} else {
					dao.getSalonMapper().insert(salon);
				}
				object.put("status", "ok");
				object.put("message", "Se ha guardado la información correctamente");
			}else {
				object.put("status", "errors");
				object.put("message", "El salón con la descripción ingresada ya existe en el sistema.");
			}
		} catch (Exception e) {
			object.put("status", "errors");
			object.put("message", "Ocurrió un error guardando el salón");
		}
		response.setCharacterEncoding("UTF-8");
		writeObject(object, response);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("pages/classRoom/deleteClassRoom")
	public void deleteSale(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		try {
			String idSalon = request.getParameter("idSalon");
			if (idSalon != null && !idSalon.isEmpty() && !idSalon.equals("0") && !idSalon.equals("undefined")
					&& !idSalon.equals("null")) {
				SalonExample salonEx = new SalonExample();
				salonEx.createCriteria().andIdSalonEqualTo(Integer.parseInt(idSalon));
				List<Salon> salon = dao.getSalonMapper().selectByExample(salonEx);
				if (salon != null && !salon.isEmpty()) {
					dao.getSalonMapper().deleteByExample(salonEx);
					object.put("status", "ok");
					object.put("message", "Se ha eliminado correctamente el salón");
				} else {
					object.put("status", "errors");
					object.put("message", "No se encontró el salón a eliminar");
				}
			} else {
				object.put("status", "errors");
				object.put("message", "Ocurrió un error eliminando el salón");
			}
		} catch (Exception e) {
			String cause = e.getLocalizedMessage();
			if(cause.contains("foreign key constraint")) {
				object.put("status", "errors");
				object.put("message", "El salón está asociado con alguna entidad del sistema, no es posible eliminarlo");
			}else {
				object.put("status", "errors");
				object.put("message", "Ocurrió un error eliminando el salón");				
			}
		}
		response.setCharacterEncoding("UTF-8");
		writeObject(object, response);
	}
	
	public void writeObject(JSONObject object, HttpServletResponse response) {
		try {
			object.writeJSONString(response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		};
	}

}
