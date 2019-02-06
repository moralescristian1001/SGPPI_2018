var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';

function verSeguimientoForm(dia, hora, diaString, idAsesoria, nombreEquipo,
		diaHoy) {
	jQuery('#dia-hora-asesoria').html(diaString + " de " + (Math.floor(hora)) + ":" + (hora % 1 == 0 ? "00" : "30") + " a " + (Math.floor(hora + 0.5)) + ":" + ((hora + 0.5) % 1 == 0 ? "00" : "30"));
	jQuery("#id_asesoria").val(idAsesoria);
	jQuery('#equipo-nombre').html(nombreEquipo);
	$("#seguimientos-tabla tbody").empty();
	$("#asistencia").empty();
	jQuery.ajax({
		url : urlFull + '/pages/tracing/verTracing.html',
		data : {
			id_asesoria : idAsesoria
		},
		success : function(o) {
			var data = jQuery.parseJSON(o);
			var seguimientos = data.seguimientos;
			
			if (seguimientos.length > 0) {
				for (var i = 0; i < seguimientos.length; i++) {
					$("#seguimientos-tabla tbody").append(
							"<tr>" + "<td>" + seguimientos[i]["fecha"]
									+ "</td>" + "<td>"
									+ seguimientos[i]["observaciones"]
									+ "</td>" + "<td>"
									+ seguimientos[i]["estudiantes_faltaron"]
									+ "</td>" + "</tr>");
				}

			}
			var estudiantes = data.estudiantes;
			
			for (var i = 0; i < estudiantes.length; i++) {
				$("#asistencia").append(
						"<option value='" + estudiantes[i]["id_usuario"] + "'>"
								+ estudiantes[i]["nombre_completo"]
								+ "</option>");
			}
		}
	});

	if (diaHoy == dia) {
		jQuery("#foot-MyModal")
				.html(
						'<div class="modal-footer" id="footer-div">\
				<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>\
				<input type="button" class="btn btn-primary pull-left"\
					name="guardar" value="Guardar Seguimiento" onclick="saveTracing();"></input>\
			</div>');
		jQuery("#div-agregar-seguimiento").show();
	}

	jQuery("#myModal").modal("show");

}
function verMiAsesoria(dia, hora, diaString, asesorNombre) {
	jQuery('#asesor-nombre').html(
			"<label>Asesor:</label>" + asesorNombre
					+ "<i class='fa fa-user fa-fw'></i>");
	jQuery('#dia-hora-asesoria').html(
			diaString + " de " + hora + ":00 a " + (hora + 1) + ":00");
	jQuery("#dia_semana").val(dia);
	jQuery("#hora_semana").val(hora);
	jQuery("#foot-MyModal").empty();
	jQuery("#myModal").modal("show");

}

function saveTracing() {
	jQuery('#errorDiv').css('display', 'none');

	var idAsesoria = jQuery("#id_asesoria").val();
	var observaciones = jQuery("#observaciones").val();
	var asistencia = jQuery("#asistencia").val();
	var asistencia = asistencia.join();
	
	jQuery.ajax({
		url : urlFull + '/pages/tracing/saveTracing.html',
		data : {
			id_asesoria : idAsesoria,
			observaciones: observaciones,
			asistencia:asistencia 
		},
		success : function(o) {
			if (o == "") {
				return;
			}
			var data;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#errorDiv').html(data.message);
					jQuery('#errorDiv').css('display', 'block');
				} else if (data.status != undefined && data.status == 'ok') {
					jQuery('#successDiv').html(data.message);
					jQuery('#successDiv').css('display', 'block');
					clear();
					setTimeout(function() {
						location.reload();
					}, 500);
				} else {
					jQuery('errorDiv').html(
							"Ocurrió un error guardando el seguimiento");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv').html(
						"Ocurrió un error guardando el seguimiento");
				jQuery('errorDiv').css('display', 'block');
				return;
			}
		}
	});
}

function clear() {
	jQuery('#id_equipo').val("-1");
	jQuery('#id_asesoria').val("");
	jQuery('#dia_semana').val("");
	jQuery('#hora_semana').val("");
}