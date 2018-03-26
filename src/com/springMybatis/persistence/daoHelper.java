package com.springMybatis.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.mappers.AsignaturaMapper;
import com.mybatis.mappers.CargoMapper;
import com.mybatis.mappers.CuadranteMapper;
import com.mybatis.mappers.EquipoMapper;
import com.mybatis.mappers.EstudiantesxequiposMapper;
import com.mybatis.mappers.ProfesoresxasignaturasMapper;
import com.mybatis.mappers.RubricaxitemMapper;
import com.mybatis.mappers.UsuariosMapper;

public class daoHelper {
	
	private AsignaturaMapper asignaturaMapper;
	private CargoMapper cargoMapper;
	private CuadranteMapper cuadranteMapper;
	private EquipoMapper equipoMapper;
	private EstudiantesxequiposMapper estudiantesxequiposMapper;
	private ProfesoresxasignaturasMapper profesoresxasignaturasMapper;
	private RubricaxitemMapper rubricaxitemMapper;
	private UsuariosMapper usuariosMapper;
	
	public daoHelper(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring_myBatis_config.xml");
		asignaturaMapper = (AsignaturaMapper) context.getBean("asignaturaMapper");
		cargoMapper = (CargoMapper) context.getBean("cargoMapper");
		cuadranteMapper = (CuadranteMapper) context.getBean("cuadranteMapper");
		equipoMapper = (EquipoMapper) context.getBean("equipoMapper");
		estudiantesxequiposMapper = (EstudiantesxequiposMapper) context.getBean("estudiantesxequiposMapper");
		profesoresxasignaturasMapper = (ProfesoresxasignaturasMapper) context.getBean("profesoresxasignaturasMapper");
		rubricaxitemMapper = (RubricaxitemMapper) context.getBean("rubricaxitemMapper");
		usuariosMapper = (UsuariosMapper) context.getBean("usuariosMapper");
	}

	public AsignaturaMapper getAsignaturaMapper() {
		return asignaturaMapper;
	}

	public void setAsignaturaMapper(AsignaturaMapper asignaturaMapper) {
		this.asignaturaMapper = asignaturaMapper;
	}

	public CargoMapper getCargoMapper() {
		return cargoMapper;
	}

	public void setCargoMapper(CargoMapper cargoMapper) {
		this.cargoMapper = cargoMapper;
	}

	public CuadranteMapper getCuadranteMapper() {
		return cuadranteMapper;
	}

	public void setCuadranteMapper(CuadranteMapper cuadranteMapper) {
		this.cuadranteMapper = cuadranteMapper;
	}

	public EquipoMapper getEquipoMapper() {
		return equipoMapper;
	}

	public void setEquipoMapper(EquipoMapper equipoMapper) {
		this.equipoMapper = equipoMapper;
	}

	public EstudiantesxequiposMapper getEstudiantesxequiposMapper() {
		return estudiantesxequiposMapper;
	}

	public void setEstudiantesxequiposMapper(EstudiantesxequiposMapper estudiantesxequiposMapper) {
		this.estudiantesxequiposMapper = estudiantesxequiposMapper;
	}

	public ProfesoresxasignaturasMapper getProfesoresxasignaturasMapper() {
		return profesoresxasignaturasMapper;
	}

	public void setProfesoresxasignaturasMapper(ProfesoresxasignaturasMapper profesoresxasignaturasMapper) {
		this.profesoresxasignaturasMapper = profesoresxasignaturasMapper;
	}

	public RubricaxitemMapper getRubricaxitemMapper() {
		return rubricaxitemMapper;
	}

	public void setRubricaxitemMapper(RubricaxitemMapper rubricaxitemMapper) {
		this.rubricaxitemMapper = rubricaxitemMapper;
	}

	public UsuariosMapper getUsuariosMapper() {
		return usuariosMapper;
	}

	public void setUsuariosMapper(UsuariosMapper usuariosMapper) {
		this.usuariosMapper = usuariosMapper;
	}

}
