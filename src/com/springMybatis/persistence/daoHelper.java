package com.springMybatis.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.mappers.AsesoriasMapper;
import com.mybatis.mappers.AsignaturaMapper;
import com.mybatis.mappers.CalificacionMapper;
import com.mybatis.mappers.CalifxsocMapper;
import com.mybatis.mappers.CargoMapper;
import com.mybatis.mappers.CuadranteMapper;
import com.mybatis.mappers.EquipoMapper;
import com.mybatis.mappers.EstudiantesxequiposMapper;
import com.mybatis.mappers.EventoMapper;
import com.mybatis.mappers.NotasxcalifxsocMapper;
import com.mybatis.mappers.ProfesoresxasignaturasMapper;
import com.mybatis.mappers.RubricaMapper;
import com.mybatis.mappers.RubricaxitemMapper;
import com.mybatis.mappers.SalonMapper;
import com.mybatis.mappers.SalonxequipoMapper;
import com.mybatis.mappers.SalonxprofesoresMapper;
import com.mybatis.mappers.SeguimientoAsistenciaMapper;
import com.mybatis.mappers.SeguimientoMapper;
import com.mybatis.mappers.SemestreMapper;
import com.mybatis.mappers.SocializacionAsistenciaMapper;
import com.mybatis.mappers.SocializacionMapper;
import com.mybatis.mappers.SolicitudAsesoriaMapper;
import com.mybatis.mappers.TipoEventoMapper;
import com.mybatis.mappers.TipoRubricaMapper;
import com.mybatis.mappers.UsuariosMapper;
import com.mybatis.models.Califxsoc;
import com.mybatis.models.Notasxcalifxsoc;
import com.mybatis.models.SeguimientoAsistencia;
import com.mybatis.models.SolicitudAsesoria;
import com.mybatis.models.TipoEventoExample;

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
	private EventoMapper eventoMapper;
	private TipoEventoMapper tipoEventoMapper;
	private RubricaMapper rubricaMapper;
	private TipoRubricaMapper tipoRubricaMapper;
	private SocializacionMapper socializacionMapper;
	private SocializacionAsistenciaMapper socializacionAsistenciaMapper;
	private SalonMapper salonMapper;
	private SalonxequipoMapper salonxequipoMapper;
	private SalonxprofesoresMapper salonxprofesoresMapper;
	private CalificacionMapper calificacionMapper;
	private CalifxsocMapper califxsocMapper;
	private NotasxcalifxsocMapper notasxcalifxsocMapper;
	
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
		eventoMapper = (EventoMapper) context.getBean("eventoMapper");
		tipoEventoMapper = (TipoEventoMapper) context.getBean("tipoEventoMapper");
		rubricaMapper = (RubricaMapper) context.getBean("rubricaMapper");
		tipoRubricaMapper = (TipoRubricaMapper) context.getBean("tipoRubricaMapper");
		socializacionMapper = (SocializacionMapper) context.getBean("socializacionMapper");
		socializacionAsistenciaMapper = (SocializacionAsistenciaMapper) context.getBean("socializacionAsistenciaMapper");
		salonMapper = (SalonMapper) context.getBean("salonMapper");
		salonxequipoMapper = (SalonxequipoMapper) context.getBean("salonxequipoMapper");
		salonxprofesoresMapper = (SalonxprofesoresMapper) context.getBean("salonxprofesoresMapper");
		calificacionMapper = (CalificacionMapper) context.getBean("calificacionMapper");
		califxsocMapper= (CalifxsocMapper) context.getBean("califxsocMapper");
		notasxcalifxsocMapper = (NotasxcalifxsocMapper) context.getBean("notasxcalifxsocMapper");
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

	public void setSeguimientoAsistenciaMapper(SeguimientoAsistenciaMapper seguimientoAsistenciaMapper) {
		this.seguimientoAsistenciaMapper = seguimientoAsistenciaMapper;
	}

	public EventoMapper getEventoMapper() {
		return eventoMapper;
	}

	public void setEventoMapper(EventoMapper eventoMapper) {
		this.eventoMapper = eventoMapper;
	}

	public TipoEventoMapper getTipoEventoMapper() {
		return tipoEventoMapper;
	}

	public void setTipoEventoMapper(TipoEventoMapper tipoEventoMapper) {
		this.tipoEventoMapper = tipoEventoMapper;
	}

	public RubricaMapper getRubricaMapper() {
		return rubricaMapper;
	}

	public void setRubricaMapper(RubricaMapper rubricaMapper) {
		this.rubricaMapper = rubricaMapper;
	}

	public TipoRubricaMapper getTipoRubricaMapper() {
		return tipoRubricaMapper;
	}

	public void setTipoRubricaMapper(TipoRubricaMapper tipoRubricaMapper) {
		this.tipoRubricaMapper = tipoRubricaMapper;
	}

	public SocializacionMapper getSocializacionMapper() {
		return socializacionMapper;
	}

	public void setSocializacionMapper(SocializacionMapper socializacionMapper) {
		this.socializacionMapper = socializacionMapper;
	}

	public SocializacionAsistenciaMapper getSocializacionAsistenciaMapper() {
		return socializacionAsistenciaMapper;
	}

	public void setSocializacionAsistenciaMapper(SocializacionAsistenciaMapper socializacionAsistenciaMapper) {
		this.socializacionAsistenciaMapper = socializacionAsistenciaMapper;
	}

	public SalonMapper getSalonMapper() {
		return salonMapper;
	}

	public void setSalonMapper(SalonMapper salonMapper) {
		this.salonMapper = salonMapper;
	}

	public SalonxequipoMapper getSalonxequipoMapper() {
		return salonxequipoMapper;
	}

	public void setSalonxequipoMapper(SalonxequipoMapper salonxequipoMapper) {
		this.salonxequipoMapper = salonxequipoMapper;
	}

	public SalonxprofesoresMapper getSalonxprofesoresMapper() {
		return salonxprofesoresMapper;
	}

	public void setSalonxprofesoresMapper(SalonxprofesoresMapper salonxprofesoresMapper) {
		this.salonxprofesoresMapper = salonxprofesoresMapper;
	}

	public CalificacionMapper getCalificacionMapper() {
		return calificacionMapper;
	}

	public void setCalificacionMapper(CalificacionMapper calificacionMapper) {
		this.calificacionMapper = calificacionMapper;
	}

	public CalifxsocMapper getCalifxsocMapper() {
		return califxsocMapper;
	}

	public void setCalifxsocMapper(CalifxsocMapper califxsocMapper) {
		this.califxsocMapper = califxsocMapper;
	}

	public NotasxcalifxsocMapper getNotasxcalifxsocMapper() {
		return notasxcalifxsocMapper;
	}

	public void setNotasxcalifxsocMapper(NotasxcalifxsocMapper notasxcalifxsocMapper) {
		this.notasxcalifxsocMapper = notasxcalifxsocMapper;
	}

}
