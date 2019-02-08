<%@page import="org.json.JSONObject"%>
<%@page import="com.mybatis.models.Evento"%>
<%@page import="com.mybatis.models.Rubrica"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.mybatis.models.Califxsoc"%>
<%@page import="com.mybatis.models.Rubricaxitem"%>
<%@page import="com.mybatis.models.Asignatura"%>
<%@page import="com.mybatis.models.Usuarios"%>
<%@page import="com.mybatis.models.Notasxcalifxsoc"%>
<%@page import="com.mybatis.models.Equipo"%>
<%@page import="com.mybatis.models.Salon"%>
<%@page import="com.mybatis.models.Salonxequipo"%>
<%@page import="java.util.List"%>
<%@page import="com.mybatis.models.Salonxprofesores"%>
<%@page import="com.mybatis.models.Socializacion"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp" />
<div id="wrapper">
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="row">
		<%
			
			Evento evento = (Evento)request.getAttribute("evento");
		%>
			<div class="col-lg-12">
				<h1 class="page-header">Informe Notas <%=(evento.getIdTipoEvento() == 1 ? "Primera " : "Segunda" ) + "socializacion - Año " + (1900 + evento.getFecha().getYear())%></h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Hist&oacute;rico</div>
					<!-- /.panel-heading -->
					<div class="panel-body" style="overflow-x: auto;">
						<div><button onclick="window.print()" type="button"><i class="fa fa-file-pdf-o"> Exportar Reporte</i></button></div>
						<%
						Socializacion soc = (Socializacion)request.getAttribute("soc");
						List<Salonxprofesores> salonxprofesores = (List<Salonxprofesores>)request.getAttribute("salonxprofesores");
						List<Salonxequipo> salonxequipos = (List<Salonxequipo>)request.getAttribute("salonxequipos");
						List<Salon> salones = (List<Salon>)request.getAttribute("salones");
						List<Usuarios> profesores = (List<Usuarios>)request.getAttribute("profesores");
						List<Equipo> equipos = (List<Equipo>)request.getAttribute("equipos");
						List<Califxsoc> califxsoc = (List<Califxsoc>)request.getAttribute("califxsoc");
						List<Notasxcalifxsoc> notasxcalifxsoc = (List<Notasxcalifxsoc>)request.getAttribute("notasxcalifxsoc");
						List<Rubricaxitem> rubricasxitem = (List<Rubricaxitem>)request.getAttribute("rubricasxitem");
						List<Rubrica> rubricas = (List<Rubrica>)request.getAttribute("rubricas");
						List<Asignatura> asignaturas = (List<Asignatura>)request.getAttribute("asignaturas");
						
						for(Salon salon : salones){
							boolean fueUsadoSalon = false;
							for(Salonxequipo salonxequipo : salonxequipos){
								if(salonxequipo.getIdSalon() == salon.getIdSalon()){
									fueUsadoSalon = true;
									break;
								}
							}
							if(fueUsadoSalon){
								
									
						%>
						<table width="100%"
							class="table table-striped table-bordered table-hover"
							id="dataTables-example-<%=salon.getIdSalon()%>">
							<caption><%=salon.getDescripcion()%></caption>
							<thead>
								
								<tr>
									<th>Evaluador</th>
									<th>Equipo</th>
									<th>M&oacute;dulo sol</th>
									<%for(int i = 1; i <= 10; i++){
									%>
										<th>R<%=i%></th>
									<%
									}%>
									<th>Comentarios</th>
									<th>Nota parcial</th>
									<th>Nota final</th>
								</tr>
							</thead>
							<tbody>
							<%
							for(Salonxequipo salonxequipo : salonxequipos){
								if(salonxequipo.getIdSalon() != salon.getIdSalon()){
									continue;
								}
								Equipo equipo = null;
								for(Equipo equipoObj : equipos){
									if(equipoObj.getIdEquipo() == salonxequipo.getIdEquipo()){
										equipo = equipoObj;
										break;
									}
								}
								//ya tengo equipo
								boolean firstEvaluador = true;
								int cantidadCalificadores = 0;
								int cantidadCalificadoresAsistentes = 0;
								double sumaNotas = 0.0;
								for(Salonxprofesores salonxprofesor : salonxprofesores){
									Usuarios profesor = null;
									if(salonxprofesor.getIdSalon() == salon.getIdSalon()){
										for(Usuarios profesorObj : profesores){
											if(salonxprofesor.getIdProfesor() == profesorObj.getIdUsuario()){
												profesor = profesorObj;
												break;
											}
											
										}
									}
									if(profesor == null){ //si el profesor no se estuvo en el salón seleccionado 
										continue;
									}
									cantidadCalificadores++;
									
									Califxsoc calificacion = null;
									for(Califxsoc calificacionObj : califxsoc){
										if(calificacionObj.getIdCalificador() == profesor.getIdUsuario() && calificacionObj.getIdSalonxequipo() == salonxequipo.getIdSalonxequipo()){
											//profesor ha calificado el equipo
											calificacion = calificacionObj;
											break;
										}
									}
									
									String sunModule = "";
									for(Asignatura asignatura : asignaturas){
										if(asignatura.getIdAsignatura() == equipo.getIdAsignatura()){
											sunModule = asignatura.getNombre();
											break;
										}
									}
								%>
								<tr>
									<td><%=profesor.getNombre() + " " + profesor.getApellidos()%></td>
									<td><%=equipo.getNombre()%></td>
									<td><%=sunModule%></td>
									<%
									JSONArray rubricasJSON = new JSONArray();
									JSONArray notas = new JSONArray();
									
									if(calificacion != null){
										cantidadCalificadoresAsistentes++;
										int cantidadRubricas = 0;
										for(Notasxcalifxsoc nota : notasxcalifxsoc){
											if(nota.getIdCalifxsoc() == calificacion.getIdCalifxsoc()){
												rubricasJSON.add(nota.getIdRubricaxitem());
											}
										}
										for(Rubricaxitem rubricaxitem : rubricasxitem){
											if(rubricasJSON.indexOf(rubricaxitem.getIdRubricaxitem()) >= 0){
												JSONObject notaObj = new JSONObject();
												notaObj.put("rubrica", rubricaxitem.getIdRubrica());
												notaObj.put("calificacion", rubricaxitem.getCalificacion());
												notas.add(notaObj);
											}
										}
										int puntaje = 0;
										for(Rubrica rubrica : rubricas){
											int notaRub = -1;
											for(Object nota : notas){
												JSONObject notaObj = (JSONObject)nota;
												if(notaObj.getInt("rubrica") == rubrica.getIdRubrica()){
													notaRub = notaObj.getInt("calificacion");
													puntaje += notaRub;
													break;
												}
											}
											if(notaRub == -1){
												continue;	
											}
											cantidadRubricas++;
											%>
											<td><%=notaRub%></td>
											<%
										}
										for(int i = cantidadRubricas; i < 10; i++){
											%>
											<td>N/A</td>
											<%
										}
										int X = cantidadRubricas * 3;
										int Y = cantidadRubricas * 2;
												
										double notaParcial = puntaje < cantidadRubricas ? 0.0 : 3.0 + (((puntaje - Y ) * 2) / (X - Y));
										sumaNotas += notaParcial; 
										%>
										<td><%=calificacion.getObservaciones()%></td>
										<td><%=notaParcial%></td>
										<%
										if(firstEvaluador){
											firstEvaluador = false;
											%>
											<td id="total-<%=salonxequipo.getIdSalonxequipo()%>" style="vertical-align: middle;"></td>
											<%
										}
									}else{
										%>
										<td colspan="12"><div align="center">ESTE EVALUADOR NO HIZO LA EVALUACIÓN DE ESTE EQUIPO</div></td>
										
										<%
										if(firstEvaluador){
											firstEvaluador = false;
											%>
											<td id="total-<%=salonxequipo.getIdSalonxequipo()%>" style="vertical-align: middle;"></td>
											<%
										}
									}
									
									%>
								</tr>
								<%
								}
								double notaFinal = 0;
								if(cantidadCalificadoresAsistentes > 0){
									notaFinal = sumaNotas / cantidadCalificadoresAsistentes;	
								}
								
							%>
							
							
						<script>
							
							document.getElementById("total-<%=salonxequipo.getIdSalonxequipo()%>").rowSpan = '<%=cantidadCalificadores%>';
							document.getElementById("total-<%=salonxequipo.getIdSalonxequipo()%>").innerHTML = '<%=notaFinal%>';
						</script>
						<%
								} // for salonxequipo
							 
							
							%>
							</tbody>
						</table><%
						}//if fueUsado
						}// for salones
						%>
						<!-- /.table-responsive -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
		</div>
	</div>		
</div>
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="../dist/js/sb-admin-2.js"></script>

</body>
</html>
