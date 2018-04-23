var puerto = '8080';
function asignarSolicitudForm(dia, hora, asesor, asesorNombre, diaString) {
	jQuery('#asesor-nombre').html(asesorNombre);
	jQuery('#dia-hora-asesoria').html(
			diaString + " de " + hora + ":00 a " + (hora + 1) + ":00");
	jQuery("#dia_semana").val(dia);
	jQuery("#hora_semana").val(hora);
	jQuery("#id_asesor").val(asesor);
	jQuery("#myModal").modal("show");
}
function modificarSolicitudForm(id_solicitud, id_equipo, dia, hora, diaString) {
	jQuery('#dia-hora-asesoria').html(
			diaString + " de " + hora + ":00 a " + (hora + 1) + ":00");
	jQuery("#dia_semana").val(dia);
	jQuery("#hora_semana").val(hora);
	
	jQuery("#id_equipo").val(id_equipo);
	jQuery("#id_asesoria").val(id_asesoria);
	jQuery("#myModal").modal("show");
}	

function saveSolicitud(){
	jQuery('#errorDiv').css('display', 'none');
	var idEquipo = jQuery('#id_equipo').val();
	var diaSemana = jQuery('#dia_semana').val();
	var horaSemana = jQuery('#hora_semana').val();
	var idAsesoria = jQuery("#id_asesoria").val();
	
	
	if(idEquipo == "" || idEquipo == "-1"){
		jQuery('#errorDiv').html("Debe ingresar el equipo");
		jQuery('#errorDiv').css('display', 'block');
	    return;
	}	
		
	jQuery.ajax({
		url : 'http://localhost:'+puerto+'/SGPPI_2018/pages/schedule/saveSchedule.html',
		data: {id_asesoria: idAsesoria, id_equipo: idEquipo, dia_semana:diaSemana, hora_semana:horaSemana},
		success: function(o) {
			if(o=="") {
				return;
			}
			var data;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#errorDiv').html(data.message);
					jQuery('#errorDiv').css('display', 'block');
				}else if(data.status != undefined && data.status == 'ok'){
					jQuery('#successDiv').html(data.message);
		        	jQuery('#successDiv').css('display', 'block');
		        	clear();
		        	setTimeout(function(){ location.reload(); }, 500);
				}else{
					jQuery('errorDiv').html("Ocurrió un error guardando la asesoria");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv').html("Ocurrió un error guardando la asesoria");
				jQuery('errorDiv').css('display', 'block');
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
	var idAsesoria = id;
	
	if(idAsesoria == "" || idAsesoria== "" || idAsesoria== undefined){
		jQuery('#errorDiv').html("No se encontró la asesoria");
		jQuery('#errorDiv').css('display', 'block');
	    return;
	}
	jQuery.ajax({
		url : 'http://localhost:'+puerto+'/SGPPI_2018/pages/schedule/deleteSchedule.html',
		data: {id_asesoria:idAsesoria},
		success: function(o) {
			if(o=="") {
				return;
			}
			var data;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#errorDiv').html(data.message);
					jQuery('#errorDiv').css('display', 'block');
				}else if(data.status != undefined && data.status == 'ok'){
					jQuery('#successDiv').html(data.message);
		        	jQuery('#successDiv').css('display', 'block');
		        	clear();
		        	setTimeout(function(){ location.reload(); }, 500);
				}else{
					jQuery('errorDiv').html("Ocurri&oacute; un error eliminando la asesoria");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv').html("Ocurrió un error eliminando la asesoria");
				jQuery('errorDiv').css('display', 'block');
				return;
			}
		}
	});
}

function clear(){
	jQuery('#id_equipo').val("-1");
	jQuery('#id_asesoria').val("");
	jQuery('#dia_semana').val("");
	jQuery('#hora_semana').val("");
}