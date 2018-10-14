package com.spring.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.models.Asignatura;
import com.mybatis.models.AsignaturaExample;
import com.mybatis.models.Cuadrante;
import com.mybatis.models.CuadranteExample;
import com.mybatis.models.Rubrica;
import com.mybatis.models.RubricaExample;
import com.mybatis.models.Rubricaxitem;
import com.mybatis.models.Usuarios;
import com.springMybatis.persistence.daoHelper;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import oracle.net.aso.e;

@Controller
public class rubricController {
	daoHelper dao = new daoHelper();

	@RequestMapping("pages/rubric")
	public ModelAndView sale(HttpServletRequest request, ModelMap model, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getSession().getAttribute("user") != null) {                                    
//			System.out.println(dao.getAsignaturaMapper().selectByExample(new AsignaturaExample()));
			
			RubricaExample rEx = new RubricaExample();
			rEx.setOrderByClause("version DESC");
			AsignaturaExample aEx = new AsignaturaExample();
			aEx.setOrderByClause("nombre ASC");
			
			List<Asignatura> asignaturas = dao.getAsignaturaMapper().selectByExample(aEx);
			List<Rubrica> rubricas = dao.getRubricaMapper().selectByExample(rEx);
			Map<Asignatura, List<Rubrica>> asignaturasxrubricas = new HashMap<>();
			for(Asignatura asig : asignaturas) {
				
				List<Rubrica> rubricasAsignadas = new ArrayList<>();
				for(Iterator<Rubrica> i = rubricas.iterator(); i.hasNext();) {
					Rubrica r = i.next();
					boolean rubricaDeAsignatura = r.getIdAsignatura() == asig.getIdAsignatura();
					if(rubricaDeAsignatura) {
						rubricasAsignadas.add(r);
						i.remove();
					}
				}
				asignaturasxrubricas.put(asig, rubricasAsignadas);
			}
			
			
			model.addAttribute("user", (Usuarios)request.getSession().getAttribute("user"));
			model.addAttribute("listRubricas", asignaturasxrubricas);
			model.addAttribute("asignaturas", asignaturas);
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			return new ModelAndView("pages/rubric");
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
	@RequestMapping("pages/rubric/saveRubric")
	public void saveRubric(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		try {
			int idAsignatura = Integer.parseInt(request.getParameter("id_asignatura"));
			int version = dao.getRubricaMapper().getLastVersion(idAsignatura) + 1;
			
			Enumeration<String> enumeration = request.getParameterNames();
		    Map<String, String> modelMap = new HashMap<>();
		    while(enumeration.hasMoreElements()){
		        String parameterName = enumeration.nextElement();
		        modelMap.put(parameterName, request.getParameter(parameterName));
		    }
			
			Map<Integer, String> rubricas = new HashMap<Integer, String>();
			Map<Integer, Integer> idTiposRubrica = new HashMap<Integer, Integer>();
			Map<Integer, Map<Integer, String>> items = new HashMap<Integer, Map<Integer, String>>();
			
			for(Map.Entry<String, String> entry : modelMap.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				
				String[] infoItem = key.split("_");
				
				if(key.contains("rubrica_descripcion")) {
					
					if(value.equals("")) {
						throw new Exception("Porfavor completar la descripcion de las rúbricas");
					}
					rubricas.put(Integer.parseInt(infoItem[2]), value);
				}else if(key.contains("id_tipo_rubrica")) {
					
					if(value.equals("") || value.equals("-1")) {
						throw new Exception("Porfavor completar los tipos de las rúbricas");
					}
					idTiposRubrica.put(Integer.parseInt(infoItem[3]), Integer.parseInt(value));
				}else if(key.contains("item")) {
					
					if(value.equals("")) {
						throw new Exception("Porfavor completar las descripciones de las calificaciones");
					}
					if(items.get(Integer.parseInt(infoItem[1])) != null) {
						items.get(Integer.parseInt(infoItem[1])).put(Integer.parseInt(infoItem[2]), value);
					}else {
						Map<Integer, String> mapInfoItem = new HashMap<>();
						mapInfoItem.put(Integer.parseInt(infoItem[2]), value);
						items.put(Integer.parseInt(infoItem[1]), mapInfoItem);
					}
					
				}
				
			}
			
			
			for(Map.Entry<Integer, String> entry : rubricas.entrySet()) {
				Rubrica rubrica = new Rubrica();
				int idRubrica = dao.getRubricaMapper().getNextId();
				rubrica.setIdRubrica(idRubrica);
				rubrica.setIdAsignatura(idAsignatura);
				rubrica.setDescripcion(entry.getValue());
				rubrica.setIdTipoRubrica(idTiposRubrica.get(entry.getKey()));
				rubrica.setVersion(version);
				rubrica.setFechaVersion(new Date());
				rubrica.setNumero(entry.getKey());
				
				
				Map<Integer, String> itemsRubrica = null;
				for(Map.Entry<Integer, Map<Integer, String>> item : items.entrySet()) {
					if(item.getKey().intValue() == entry.getKey().intValue()) {
						itemsRubrica = item.getValue();
						break;
					}
				}
				
				
				dao.getRubricaMapper().insert(rubrica);
				for(Map.Entry<Integer, String> item : itemsRubrica.entrySet()) {
					
					Rubricaxitem itemRubrica = new Rubricaxitem();
					itemRubrica.setDescripcionItem(item.getValue());
					itemRubrica.setCalificacion(item.getKey());
					itemRubrica.setIdRubrica(idRubrica);
					dao.getRubricaxitemMapper().insert(itemRubrica);
				}
			}

			object.put("status", "ok");
			object.put("message", "Se ha creado el cuadrante correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			object.put("status", "errors");
			object.put("message", e.getMessage());
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
