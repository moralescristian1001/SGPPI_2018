<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	if (request.getSession().getAttribute("user") != null) {
		System.out.print(request.getSession().getAttribute("user"));
		response.getWriter().write("<script>location.href='pages/home.html';</script>");
	} else {
%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SGPPI</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="vendor/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="./pagesJs/login.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<style>
#background {
	position: fixed;
	width: 100%;
	height: 100%;
	background: url("./img/sd_background.png");
	background-size: 100% 100%;
	background-repeat: no-repeat;
}

#login-data {
	color: white;
	background-color: rgba(128, 128, 128, 0.4);
}
.panel-heading{
	background-color: #E8C63E !important;
	color: #196844 !important;
	font-weight: bold;
}
</style>
<body>

	<div id="background">
		<div class="container">
			<div class="row mt-auto">
				<div class="col-md-12">
					<div class="text-center">
						<img src="./img/logo_poli_letra_negra.png">
					</div>

				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default" id="login-data">
						<div class="panel-heading">
							<h3 class="panel-title text-center">Iniciar Sesión</h3>
						</div>
						<div class="panel-body">
							<form role="form">
								<fieldset>
									Usa tu correo institucional para acceder al sistema
									<div class="form-group">
										<input class="form-control" placeholder="E-mail" name="email"
											type="email" id="email" autofocus>
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password"
											name="password" id="password" type="password" value="">
									</div>
									<div class="checkbox">
										<label> <input name="remember" type="checkbox">Recordar
										</label>
									</div>
									<div class="alert alert-danger" role="alert" id="errorDiv"
										style="display: none; width: 100%;">
										<button type="button" class="close">
											<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
										</button>
										<span class="alert-content">${errors}</span>
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<input type="button" class="btn btn-lg btn-success btn-block"
										value="Iniciar Sesión" onclick="login()">
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>


</body>
</html>
<%
	}
%>