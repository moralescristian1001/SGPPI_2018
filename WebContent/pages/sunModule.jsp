<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Sistema de gestión PPI</title>
      <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
      <link href="../vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
      <link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
      <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
      <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
   </head>
   <body>
      <div id="wrapper">
         <!-- Navigation -->
         <nav class="navbar navbar-default navbar-static-top" role="navigation"
            style="margin-bottom: 0">
            <div class="navbar-header">
               <button type="button" class="navbar-toggle" data-toggle="collapse"
                  data-target=".navbar-collapse">
               <span class="sr-only">Toggle navigation</span> <span
                  class="icon-bar"></span> <span class="icon-bar"></span> <span
                  class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="../index.jsp">Sistema de gestion PPI</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-top-links navbar-right">
               <li class="dropdown">
                  <a class="dropdown-toggle"
                     data-toggle="dropdown" href="#"> <i
                     class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                  </a>
                  <ul class="dropdown-menu dropdown-messages">
                     <li>
                        <a href="#">
                           <div>
                              <strong>John Smith</strong> <span class="pull-right text-muted">
                              <em>Yesterday</em>
                              </span>
                           </div>
                           <div>Lorem ipsum dolor sit amet, consectetur adipiscing
                              elit. Pellentesque eleifend...
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <strong>John Smith</strong> <span class="pull-right text-muted">
                              <em>Yesterday</em>
                              </span>
                           </div>
                           <div>Lorem ipsum dolor sit amet, consectetur adipiscing
                              elit. Pellentesque eleifend...
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <strong>John Smith</strong> <span class="pull-right text-muted">
                              <em>Yesterday</em>
                              </span>
                           </div>
                           <div>Lorem ipsum dolor sit amet, consectetur adipiscing
                              elit. Pellentesque eleifend...
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li><a class="text-center" href="#"> <strong>Read
                        All Messages</strong> <i class="fa fa-angle-right"></i>
                        </a>
                     </li>
                  </ul>
                  <!-- /.dropdown-messages -->
               </li>
               <!-- /.dropdown -->
               <li class="dropdown">
                  <a class="dropdown-toggle"
                     data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i>
                  <i class="fa fa-caret-down"></i>
                  </a>
                  <ul class="dropdown-menu dropdown-tasks">
                     <li>
                        <a href="#">
                           <div>
                              <p>
                                 <strong>Task 1</strong> <span class="pull-right text-muted">40%
                                 Complete</span>
                              </p>
                              <div class="progress progress-striped active">
                                 <div class="progress-bar progress-bar-success"
                                    role="progressbar" aria-valuenow="40" aria-valuemin="0"
                                    aria-valuemax="100" style="width: 40%">
                                    <span class="sr-only">40% Complete (success)</span>
                                 </div>
                              </div>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <p>
                                 <strong>Task 2</strong> <span class="pull-right text-muted">20%
                                 Complete</span>
                              </p>
                              <div class="progress progress-striped active">
                                 <div class="progress-bar progress-bar-info" role="progressbar"
                                    aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
                                    style="width: 20%">
                                    <span class="sr-only">20% Complete</span>
                                 </div>
                              </div>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <p>
                                 <strong>Task 3</strong> <span class="pull-right text-muted">60%
                                 Complete</span>
                              </p>
                              <div class="progress progress-striped active">
                                 <div class="progress-bar progress-bar-warning"
                                    role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                    aria-valuemax="100" style="width: 60%">
                                    <span class="sr-only">60% Complete (warning)</span>
                                 </div>
                              </div>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <p>
                                 <strong>Task 4</strong> <span class="pull-right text-muted">80%
                                 Complete</span>
                              </p>
                              <div class="progress progress-striped active">
                                 <div class="progress-bar progress-bar-danger"
                                    role="progressbar" aria-valuenow="80" aria-valuemin="0"
                                    aria-valuemax="100" style="width: 80%">
                                    <span class="sr-only">80% Complete (danger)</span>
                                 </div>
                              </div>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li><a class="text-center" href="#"> <strong>See
                        All Tasks</strong> <i class="fa fa-angle-right"></i>
                        </a>
                     </li>
                  </ul>
                  <!-- /.dropdown-tasks -->
               </li>
               <!-- /.dropdown -->
               <li class="dropdown">
                  <a class="dropdown-toggle"
                     data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
                  <i class="fa fa-caret-down"></i>
                  </a>
                  <ul class="dropdown-menu dropdown-alerts">
                     <li>
                        <a href="#">
                           <div>
                              <i class="fa fa-comment fa-fw"></i> New Comment <span
                                 class="pull-right text-muted small">4 minutes ago</span>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
                                 class="pull-right text-muted small">12 minutes ago</span>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <i class="fa fa-envelope fa-fw"></i> Message Sent <span
                                 class="pull-right text-muted small">4 minutes ago</span>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <i class="fa fa-tasks fa-fw"></i> New Task <span
                                 class="pull-right text-muted small">4 minutes ago</span>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li>
                        <a href="#">
                           <div>
                              <i class="fa fa-upload fa-fw"></i> Server Rebooted <span
                                 class="pull-right text-muted small">4 minutes ago</span>
                           </div>
                        </a>
                     </li>
                     <li class="divider"></li>
                     <li><a class="text-center" href="#"> <strong>See
                        All Alerts</strong> <i class="fa fa-angle-right"></i>
                        </a>
                     </li>
                  </ul>
                  <!-- /.dropdown-alerts -->
               </li>
               <!-- /.dropdown -->
               <li class="dropdown">
                  <a class="dropdown-toggle"
                     data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
                  <i class="fa fa-caret-down"></i>
                  </a>
                  <ul class="dropdown-menu dropdown-user">
                     <li><a href="#"><i class="fa fa-user fa-fw"></i> User
                        Profile</a>
                     </li>
                     <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                     </li>
                     <li class="divider"></li>
                     <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
                        Logout</a>
                     </li>
                  </ul>
                  <!-- /.dropdown-user -->
               </li>
               <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            <div class="navbar-default sidebar" role="navigation">
               <div class="sidebar-nav navbar-collapse">
                  <ul class="nav" id="side-menu">
                     <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                           <input type="text" class="form-control" placeholder="Search..."><span
                              class="input-group-btn">
                           <button class="btn btn-default" type="button">
                           <i class="fa fa-search"></i>
                           </button>
                           </span>
                        </div>
                        <!-- /input-group -->
                     </li>
                     <li><a href="sunModule.html"><i class="glyphicon glyphicon-education"></i>
								Módulo sol</a></li>
						<li><a href="quadrant.html"><i class="glyphicon glyphicon-list"></i>
								Cuandrantes</a></li>	
                  </ul>
               </div>
               <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
         </nav>
         <div id="page-wrapper">
            <div class="row">
               <div class="col-lg-12">
                  <h1 class="page-header">Módulo sol</h1>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <div class="alert alert-danger" role="alert" id="errorDiv"
               style="display: none; width: 100%;">
               <button type="button" class="close">
               <span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
               </button>
               <span class="alert-content">${errors}</span>
            </div>
            <div class="alert alert-success" role="alert" id="successDiv"
               style="display: none; width: 100%;">
               <button type="button" class="close">
               <span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
               </button>
               <span class="alert-content">${success}</span>
            </div>
            <form>
               <div class="row">
                  <div class="col-lg-12">
                     <div class="panel panel-default">
                        <div class="panel-heading">Módulo sol</div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                           <table width="100%"
                              class="table table-striped table-bordered table-hover"
                              id="dataTables-example">
                              <thead>
                                 <tr>
                                    <th>Código</th>
                                    <th>Asignatura</th>
                                    <th>Semestre</th>
                                    <th>Acción</th>
                                 </tr>
                              </thead>
                              <!--                                 <tbody> -->
                              <c:forEach items="${listAsig}" var="asig">
                                 <tr>
                                    <td>
                                       <c:out value="${asig.codigo}" />
                                    </td>
                                    <td>
                                       <c:out value="${asig.nombre}" />
                                    </td>
                                    <td>
                                       <c:out value="${asig.semestre}" />
                                    </td>
                                    <td><input type="button" data-toggle="modal"
                                       data-target="#myModal" class="btn btn-default pull-left"
                                       onclick="updateModuloSol(${asig.idAsignatura},'${asig.codigo}','${asig.nombre}',${asig.semestre})"
                                       value="Actualizar" /> <input type="button"
                                       class="btn btn-default pull-left"
                                       onclick="confirmation(${asig.idAsignatura});"
                                       value="Eliminar" /></td>
                                 </tr>
                              </c:forEach>
                              <!--                                 </tbody> -->
                           </table>
                           <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                     </div>
                     <!-- /.panel -->
                  </div>
                  <input type="button" data-toggle="modal" data-target="#myModal"
                     class="btn btn-default pull-left" name="guardar" value="Nuevo"></input>
               </div>
            </form>
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
               <div class="modal-dialog">
                  <!-- Modal content-->
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Modal Header</h4>
                     </div>
                     <div class="modal-body">
                        <input type='hidden' id="idAsig" name="idAsig"
                           class="form-control" value="${idAsignatura}" />
                        <div class="form-group">
                           <label for="cliente">*Código:</label>
                           <div class='input-group' id='fecha'>
                              <input type="text" class="form-control" name="code" id="code" placeholder="Ingrese el codigo de la asignatura">
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="empleado">*Asignatura:</label>
                           <div class='input-group' id='fecha'>
                              <input type="text" class="form-control" name="asig" id="asig"
                                 placeholder="Ingrese el nombre de la asignatura">
                           </div>
                        </div>
                        <div class="form-group ">
                           <label for="totalVenta">*Semestre:</label>
                           <div class='input-group' id='fecha'>
                              <span class="input-group-addon"></span> 
                              <select
                                 class="form-control" id="semes" name="semes">
                                 <option>Seleccione</option>
                                 <option>1</option>
                                 <option>2</option>
                                 <option>3</option>
                                 <option>4</option>
                              </select>
                           </div>
                        </div>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="button" class="btn btn-default pull-left"
                           value="Guardar" onclick="save();"></input>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <!-- /.row -->
      </div>
      <script src="../pagesJs/sunModule.js"></script>
      <script src="../vendor/jquery/jquery.min.js"></script>
      <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
      <script src="../vendor/metisMenu/metisMenu.min.js"></script>
      <script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
      <script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
      <script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>
      <script src="../dist/js/sb-admin-2.js"></script>
      <script>
         $(document).ready(function() {
             $('#dataTables-example').DataTable({
                 responsive: true
             });
         });
      </script>
   </body>
</html>
