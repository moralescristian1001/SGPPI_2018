<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp" />
<div id="wrapper">
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Salones</h1>
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
						<div class="panel-heading">Salones</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Descripción</th>
										<th>Acciones</th>
									</tr>
								</thead>
								<!--                                 <tbody> -->
								<c:forEach items="${listSalones}" var="salon">
									<tr>
										<td><c:out value="${salon.descripcion}" /></td>
										<td><input type="button"
											class="btn btn-default pull-left"
											onclick="confirmation(${salon.idSalon});"
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
				<div class="row" style="padding: 50px">
				<input type="button" data-toggle="modal" data-target="#myModal"
					class="btn btn-default pull-left" name="guardar" value="Nuevo"></input>
				</div>
			</div>
		</form>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
               <div class="modal-dialog">
                  <!-- Modal content-->
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Salones</h4>
                     </div>
                     <div class="modal-body">
                     	<div id="errorModal" class="alert alert-danger alert-dismissible" role="alert" style="display: none">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong id="messageErrorModal"></strong>
						</div>
                        <input type='hidden' id="idSalon" name="idSalon"
                           class="form-control" value="${idSalon}" />
                        <div class="form-group">
                           <label class="col-6" for="cliente"><li style="list-style: none; display: inline-flex;">
							<span class="glyphicon glyphicon-info-sign" aria-hidden="true" data-toggle="tooltip" 
							title="El campo descripción se compone del bloque y el número del salón, por ejemplo: P17 - 306"></span>
							</li> *Descripción:</label>
                           <div class='input-group col-lg-12' id='fecha'>
                              <input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese el codigo de la asignatura" maxlength="8">
                           </div>
                        </div>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <input type="button" class="btn btn-default pull-left"
                           value="Guardar" onclick="save();"></input>
                     </div>
                  </div>
               </div>
            </div>
		</div>
	<!-- /.row -->
</div>
<script src="../pagesJs/classRoom.js"></script>
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
             $('[data-toggle="tooltip"]').tooltip(); 
         });
      </script>
</body>
</html>
