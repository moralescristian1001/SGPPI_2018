<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp" />
<div id="wrapper">
	<jsp:include page="menu.jsp"></jsp:include>
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
										<td><c:out value="${asig.codigo}" /></td>
										<td><c:out value="${asig.nombre}" /></td>
										<td><c:out value="${asig.semestre}" /></td>
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
                           <div class='input-group col-lg-12' id='fecha'>
                              <input type="text" class="form-control" name="code" id="code" placeholder="Ingrese el codigo de la asignatura">
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="empleado">*Asignatura:</label>
                           <div class='input-group col-lg-12' id='fecha'>
                              <input type="text" class="form-control" name="asig" id="asig"
                                 placeholder="Ingrese el nombre de la asignatura">
                           </div>
                        </div>
                        <div class="form-group ">
                           <label for="totalVenta">*Semestre:</label>
                           <div class='input-group' id='fecha'>
                              <span class="input-group-addon"><i class="glyphicon glyphicon-ok"></i></span> 
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
