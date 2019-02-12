var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';

function asignarCitaForm(dia, hora, diaString) {
	jQuery('#dia-hora-asesoria').html(diaString + " de " + (Math.floor(hora)) + ":" + (hora % 1 == 0 ? "00" : "30") + " a " + (Math.floor(hora + 0.5)) + ":" + ((hora + 0.5) % 1 == 0 ? "00" : "30"));
	jQuery("#dia_semana").val(dia);
	jQuery("#hora_semana").val(hora);
	jQuery("#myModal").modal("show");
}
function modificarCitaForm(id_asesoria, id_equipo, dia, hora, diaString,
		idSolicitud, fechaSolicitud) {
	jQuery('#dia-hora-asesoria').html(
			diaString + " de " + hora + ":00 a " + (hora + 1) + ":00");
	jQuery("#dia_semana").val(dia);
	jQuery("#hora_semana").val(hora);
	jQuery("#id_equipo").val(id_equipo == null ? -1 : id_equipo);
	jQuery("#id_solicitud").val(idSolicitud);
	jQuery("#fecha-solicitud").html("<label>Fecha solicidad: </label>" + fechaSolicitud);
	jQuery("#id_asesoria").val(id_asesoria);
	jQuery("#myModal").modal("show");
}

function saveAsesoria() {
	jQuery('#errorDiv').css('display', 'none');
	var idEquipo = jQuery('#id_equipo').val();
	var diaSemana = jQuery('#dia_semana').val();
	var horaSemana = jQuery('#hora_semana').val();
	var idAsesoria = jQuery("#id_asesoria").val();
	var idSolicitud = jQuery("#id_solicitud").val();
	if (idEquipo == "" || idEquipo == "-1") {
		// jQuery('#errorDiv').html("Debe ingresar el equipo");
		// jQuery('#errorDiv').css('display', 'block');
		// return;
	}

	jQuery.ajax({
		url : urlFull + '/pages/schedule/saveSchedule.html',
		data : {
			id_asesoria : idAsesoria,
			id_equipo : idEquipo,
			dia_semana : diaSemana,
			hora_semana : horaSemana,
			id_solicitud : idSolicitud
		},
		success : function(o) {
			if (o == "") {
				return;
			}
			var data;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
				} else if (data.status != undefined && data.status == 'ok') {
					jQuery('#successDiv').html(data.message);
					jQuery('#successDiv').css('display', 'block');
					jQuery("html, body").animate({ scrollTop: 0 }, 600);
					jQuery('#myModal').modal('hide');
					jQuery('.modal-backdrop').removeClass('in');
					setTimeout(function() {
							location.reload();
					}, 2000);
				} else {
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

function confirmationAsesoria(id) {
	if (confirm('Seguro que desea eliminar la asesoria?')) {
		deleteAsesoria(id);
	}
}

function deleteAsesoria(id) {
	jQuery('#errorDiv').css('display', 'none');
	var idAsesoria = id;

	if (idAsesoria == "" || idAsesoria == "" || idAsesoria == undefined) {
		jQuery('#errorDiv').html("No se encontró la asesoria");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : urlFull + '/pages/schedule/deleteSchedule.html',
		data : {
			id_asesoria : idAsesoria
		},
		success : function(o) {
			if (o == "") {
				return;
			}
			var data;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
				} else if (data.status != undefined && data.status == 'ok') {
					jQuery('#successDiv').html(data.message);
					jQuery('#successDiv').css('display', 'block');
					jQuery("html, body").animate({ scrollTop: 0 }, 600);
					jQuery('#myModal').modal('hide');
					jQuery('.modal-backdrop').removeClass('in');
					setTimeout(function() {
							location.reload();
					}, 2000);
				} else {
					jQuery('#messageErrorModal').html("Ocurrió un error eliminando la asesoria");
					jQuery('#errorModal').css('display', 'block');
				}
			} catch (err) {
				jQuery('#messageErrorModal').html("Ocurrió un error eliminando la asesoria");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
}