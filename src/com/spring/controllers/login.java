package com.spring.controllers;


import java.util.List;
import java.util.stream.Collectors;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.models.Equipo;
import com.mybatis.models.EquipoExample;
import com.mybatis.models.Estudiantesxequipos;
import com.mybatis.models.EstudiantesxequiposExample;
import com.mybatis.models.Semestre;
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
				
				//obtenemos el semestre actual
				Semestre semestreActual =dao.getSemestreMapper().selectSemestreActual(); 
				request.getSession().setAttribute("semestre", semestreActual);

				//equipos del semestra actual
				EquipoExample eEx = new EquipoExample();
				eEx.createCriteria().andIdSemestreEqualTo(semestreActual.getIdSemestre());
				List<Equipo> equipos = dao.getEquipoMapper().selectByExample(eEx);
				
				if(user.getIdCargo() == 1 || user.getIdCargo() == 6){
					
					//obteniendo el equipo del usuario
					EstudiantesxequiposExample axeEx = new EstudiantesxequiposExample();
					axeEx.createCriteria().andIdEstudianteEqualTo(user.getIdUsuario())
							.andIdEquipoIn(equipos.stream().map(Equipo::getIdEquipo).collect(Collectors.toList()));
					List<Estudiantesxequipos> exes = dao.getEstudiantesxequiposMapper().selectByExample(axeEx);
					if (!exes.isEmpty() && exes.size() == 1) {
						Equipo equipoEstudiante = dao.getEquipoMapper().selectByPrimaryKey(exes.get(0).getIdEquipo());
						request.getSession().setAttribute("team", equipoEstudiante);
					}else{
						request.getSession().setAttribute("team", null);
					}
				}
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
