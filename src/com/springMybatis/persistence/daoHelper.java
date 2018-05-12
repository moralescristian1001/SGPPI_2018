package com.springMybatis.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.mappers.AsesoriasMapper;
import com.mybatis.mappers.AsignaturaMapper;
import com.mybatis.mappers.CargoMapper;
import com.mybatis.mappers.CuadranteMapper;
import com.mybatis.mappers.EquipoMapper;
import com.mybatis.mappers.EstudiantesxequiposMapper;
import com.mybatis.mappers.ProfesoresxasignaturasMapper;
import com.mybatis.mappers.RubricaxitemMapper;
import com.mybatis.mappers.SeguimientoAsistenciaMapper;
import com.mybatis.mappers.SeguimientoMapper;
import com.mybatis.mappers.SemestreMapper;
import com.mybatis.mappers.SolicitudAsesoriaMapper;
import com.mybatis.mappers.UsuariosMapper;
import com.mybatis.models.SeguimientoAsistencia;
import com.mybatis.models.SolicitudAsesoria;

public class daoHelper {
	
	private AsignaturaMapper asignaturaMapper;
	private CargoMapper cargoMapper;
	private CuadranteMapper cuadranteMapper;
	private EquipoMapper equipoMapper;
	private EstudiantesxequiposMapper estudiantesxequiposMapper;
	private ProfesoresxasignaturasMapper profesoresxasignaturasMapper;
	private RubricaxitemMapper rubricaxitemMapper;
	private UsuariosMapper usuariosMapper;
	private SemestreMapper semestreMapper;
	private AsesoriasMapper asesoriasMapper;
	private SolicitudAsesoriaMapper solicitudAsesoriaMapper;
	private SeguimientoMapper seguimientoMapper;
	private SeguimientoAsistenciaMapper seguimientoAsistenciaMapper;
	
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
		semestreMapper = (SemestreMapper) context.getBean("semestreMapper");
		asesoriasMapper = (AsesoriasMapper) context.getBean("asesoriasMapper");
		solicitudAsesoriaMapper = (SolicitudAsesoriaMapper) context.getBean("solicitudAsesoriaMapper");
		seguimientoMapper = (SeguimientoMapper) context.getBean("seguimientoMapper");
		seguimientoAsistenciaMapper = (SeguimientoAsistenciaMapper) context.getBean("seguimientoAsistenciaMapper");
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

	public SemestreMapper getSemestreMapper() {
		return semestreMapper;
	}

	public void setSemestreMapper(SemestreMapper semestreMapper) {
		this.semestreMapper = semestreMapper;
	}
	
	public AsesoriasMapper getAsesoriasMapper() {
		return asesoriasMapper;
	}

	public void setAsesoriasMapper(AsesoriasMapper asesoriasMapper) {
		this.asesoriasMapper = asesoriasMapper;
	}
	
	public SolicitudAsesoriaMapper getSolicitudAsesoriaMapper() {
		return solicitudAsesoriaMapper;
	}

	public void setSolicitudAsesoriaMapper(SolicitudAsesoriaMapper solicitudAsesoriaMapper) {
		this.solicitudAsesoriaMapper = solicitudAsesoriaMapper;
	}	
	
	public SeguimientoMapper getSeguimientoMapper() {
		return seguimientoMapper;
	}

	public void setSeguimientoMapper(SeguimientoMapper seguimientoMapper) {
		this.seguimientoMapper = seguimientoMapper;
	}
	
	public SeguimientoAsistenciaMapper getSeguimientoAsistenciaMapper() {
		return seguimientoAsistenciaMapper;
	}

	public void setSeguimientoMapper(SeguimientoAsistenciaMapper seguimientoAsistenciaMapper) {
		this.seguimientoAsistenciaMapper = seguimientoAsistenciaMapper;
	}
}
