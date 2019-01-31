var puerto = '8080';
function solicitarCitaForm(dia, hora, diaString) {
	jQuery('#dia-hora-asesoria').html(diaString + " de " + (Math.floor(hora)) + ":" + (hora % 1 == 0 ? "00" : "30") + " a " + (Math.floor(hora + 0.5)) + ":" + ((hora + 0.5) % 1 == 0 ? "00" : "30"));
	jQuery("#dia_semana").val(dia);
	jQuery("#hora_semana").val(hora);
	jQuery("#foot-MyModal").html('<div class="modal-footer" id="footer-div">\
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>\
						<input type="button" class="btn btn-primary pull-left"\
							name="guardar" value="Solicitar" onclick="saveSolicitud();"></input>\
					</div>');
	jQuery("#myModal").modal("show");
}
function verMiAsesoria(dia, hora, diaString, asesorNombre){
	jQuery('#asesor-nombre').html("<label>Asesor:</label>" + asesorNombre + "<i class='fa fa-user fa-fw'></i>");
	jQuery('#dia-hora-asesoria').html(
			diaString + " de " + hora + ":00 a " + (hora + 1) + ":00");
	jQuery("#dia_semana").val(dia);
	jQuery("#hora_semana").val(hora);
	jQuery("#foot-MyModal").empty();
	jQuery("#myModal").modal("show");
	
}

function saveSolicitud(){
	jQuery('#errorDiv').css('display', 'none');
	
	var diaSemana = jQuery('#dia_semana').val();
	var horaSemana = jQuery('#hora_semana').val();
		
		
	jQuery.ajax({
		url : 'http://localhost:'+puerto+'/SGPPI_2018/pages/request/saveRequest.html',
		data: {dia_semana:diaSemana, hora_semana:horaSemana},
		success: function(o) {
			if(o=="") {
				return;
			}
			var data;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
				}else if(data.status != undefined && data.status == 'ok'){
					jQuery('#successDiv').html(data.message);
		        	jQuery('#successDiv').css('display', 'block');
		        	clear();
		        	jQuery('#myModal').modal('hide');
					jQuery('.modal-backdrop').removeClass('in');
					setTimeout(function() {
							location.reload();
					}, 2000);
				}else{
					jQuery('#messageErrorModal').html("Ocurrió un error guardando la asesoria");
					jQuery('#errorModal').css('display', 'block');
				}
			} catch (err) {
				jQuery('#messageErrorModal').html("Ocurrió un error guardando la asesoria");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
}

function confirmationSolicitud(id){
	if (confirm('Seguro que desea eliminar la asesoria?')) {
		deleteSolicitud(id);
	}
}


function deleteSolicitud(id) {
	jQuery('#errorDiv').css('display', 'none');
	var idSolicitud = id;
	
	if(idSolicitud == "" || idSolicitud == "" || idSolicitud == undefined){
		jQuery('#errorDiv').html("No se encontró la solicitud");
		jQuery('#errorDiv').css('display', 'block');
	    return;
	}
	if(confirm("Esta seguro que desea eliminar su solicitd?")){
		jQuery.ajax({
			url : 'http://localhost:'+puerto+'/SGPPI_2018/pages/request/deleteRequest.html',
			data: {id_solicitud:idSolicitud},
			success: function(o) {
				if(o=="") {
					return;
				}
				var data;
				try {
					data = jQuery.parseJSON(o);
					if (data.status != undefined && data.status == 'errors') {
						jQuery('#messageErrorModal').html(data.message);
						jQuery('#errorModal').css('display', 'block');
					}else if(data.status != undefined && data.status == 'ok'){
						jQuery('#successDiv').html(data.message);
			        	jQuery('#successDiv').css('display', 'block');
			        	clear();
			        	jQuery('#myModal').modal('hide');
						jQuery('.modal-backdrop').removeClass('in');
						setTimeout(function() {
								location.reload();
						}, 2000);
					}else{
						jQuery('#messageErrorModal').html("Ocurrió un error eliminando la solicitud");
						jQuery('#errorModal').css('display', 'block');
					}
				} catch (err) {
					jQuery('#messageErrorModal').html("Ocurrió un error eliminando la solicitud");
					jQuery('#errorModal').css('display', 'block');
					return;
				}
			}
		});
	}
	
}

function clear(){
	jQuery('#id_equipo').val("-1");
	jQuery('#id_asesoria').val("");
	jQuery('#dia_semana').val("");
	jQuery('#hora_semana').val("");
}