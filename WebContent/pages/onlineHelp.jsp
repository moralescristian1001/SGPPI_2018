<%@page import="com.mybatis.models.Usuarios"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:include page="header.jsp" />
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="../dist/js/sb-admin-2.js"></script>
<div id="wrapper">
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header text-center">Ayuda</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="row">
		<div class="col-3"></div>
			<div class="panel panel-default col-6">
			  <div class="panel-body text-center">
				<p style="font-size:20px;">Manual de Usuario en PDF <a href="../downloads/MANUAL_DE_USUARIO.pdf" target="_blank">Descargal&oacute; aqu&iacute;</a></p>
				<p style="font-size:20px;">Comunicarse con el correo <a href="mailto:ppityt@elpoli.edu.co?Subject=Ayuda%20SGPPI">ppityt@elpoli.edu.co</a> para recibir asesoria</p>
			  </div>
			</div>
		<div class="col-3"></div>			
		</div>
	</div>
</div>	
<jsp:include page="footer.jsp" />