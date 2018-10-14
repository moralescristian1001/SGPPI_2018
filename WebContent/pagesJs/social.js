var puerto = '8080';
var cont = [];
var contEv = [];

function agregarSalon(id, descripcion) {
	var salonTemplate = $("#template-salon").html();
	salonTemplate = salonTemplate.replace(/\{id_salon\}/g, id).replace(
			/\{salon\}/, descripcion);
	$("#salones_informacion").append(salonTemplate);
}

function eliminarSalon(id) {
	$("#salon_div_" + id).remove();
}
function agregarEquipo(id_salon) {
	cont[id_salon] = typeof cont[id_salon] != 'undefined' ? cont[id_salon] + 1
			: 1;
	var equipoTemplate = $("#template-equipo").html();
	equipoTemplate = equipoTemplate.replace(/\{id_salon\}/g, id_salon).replace(
			/\{cont\}/g, cont[id_salon]);

	$("#equipos_div_" + id_salon).append(equipoTemplate);

}
function quitarEquipo(id_salon, id_row) {

	$("#div_row_equipo_" + id_salon + "_" + id_row).remove();

}
function agregarEvaluador(id_salon) {
	contEv[id_salon] = typeof contEv[id_salon] != 'undefined' ? contEv[id_salon] + 1
			: 1;
	var evaluadorTemplate = $("#template-evaluador").html();
	evaluadorTemplate = evaluadorTemplate.replace(/\{id_salon\}/g, id_salon)
			.replace(/\{cont\}/g, contEv[id_salon]);

	$("#evaluadores_div_" + id_salon).append(evaluadorTemplate);

}
function quitarEvaluador(id_salon, id_row) {

	$("#div_row_evaluador_" + id_salon + "_" + id_row).remove();

}
function updateSocializacionForm(idEvento, idTipoEvento, fecha, duracionHoras) {
	$("#idEvento").val(idEvento);
	$("#id_tipo_evento").val(idTipoEvento);
	$("#fecha").val(fecha);
	$("#duracion_horas").val(duracionHoras);
	$("#salones_informacion").empty();
	$("#boton-guardar").hide();
	cont = [];
	contEv = [];
	jQuery.ajax({
		url : 'http://localhost:' + puerto
				+ '/SGPPI_2018/pages/social/getInfoAdicional.html',
		data : {
			id_evento : idEvento
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
					var salones = data.salones;
					for (var i = 0; i < salones.length; i++) {
						var salon = salones[i];
						var equipos = salon.equipos;
						var evaluadores = salon.evaluadores;

						$("#salon_" + salon.idSalon).prop("checked", true);
						agregarSalon(salon.idSalon, salon.descripcion);
						for (var j = 0; j < equipos.length; j++) {
							agregarEquipo(salon.idSalon);
							$("#id_equipo_" + salon.idSalon + "_" + cont[salon.idSalon])
									.val(equipos[j]);
						}
						for (var j = 0; j < evaluadores.length; j++) {
							agregarEvaluador(salon.idSalon);
							$("#id_evaluador_" + salon.idSalon + "_"
											+ contEv[salon.idSalon]).val(
									evaluadores[j]);
						}
					}
				} else {
					jQuery('errorDiv').html(
							"Ocurri&oacute; un error eliminando el cuadrante");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv').html(
						"Ocurrió un error eliminando el cuadrante");
				jQuery('errorDiv').css('display', 'block');
				return;
			}
		}
	});
}
function updateSocializacion() {
	jQuery('#errorDiv').css('display', 'none');
	var fecha = jQuery("#fecha").val();
	var id_tipo_socializacion = jQuery("#id_tipo_socializacion").val();
	var duracionHoras = jQuery("#duracion_horas").val();
	var id_evento = jQuery("#id_evento").val();

	if (fecha == "" || fecha == "0") {
		jQuery('#errorDiv').html("Debe ingresar la fecha");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (id_tipo_socializacion == "" || id_tipo_socializacion == "0") {
		jQuery('#errorDiv').html("Debe ingresar el tipo de socialización");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (duracionHoras == "" || duracionHoras == "-1") {
		jQuery('#errorDiv').html("Debe seleccionar la duración");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	var idEquipos = [];
	jQuery("input[name*='id_equipo'],select[name*='id_equipo']").each(
			function(element) {
				idEquipos.push(jQuery(this).val());
			})
	idEquipos = idEquipos.join(",");

	var idEvaluadores = [];
	jQuery("input[name*='id_evaluador'],select[name*='id_evaluador']").each(
			function(element) {
				idEvaluadores.push(jQuery(this).val());
			})
	idEvaluadores = idEvaluadores.join(",");

	jQuery
			.ajax({
				url : 'http://localhost:' + puerto
						+ '/SGPPI_2018/pages/social/updateSocial.html',
				data : {
					id_evento : id_evento,
					fecha : fecha,
					id_tipo_socializacion : id_tipo_socializacion,
					duracion_horas : duracionHoras,
					id_equipo : idEquipos,
					id_evaluador : idEvaluadores
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
						} else if (data.status != undefined
								&& data.status == 'ok') {
							jQuery('#successDiv').html(data.message);
							jQuery('#successDiv').css('display', 'block');
							clear();
							// setTimeout(function() {
							// location.reload();
							// }, 500);
						} else {
							jQuery('errorDiv').html(
									"Ocurrió un error guardando el equipo");
							jQuery('errorDiv').css('display', 'block');
						}
					} catch (err) {
						jQuery('errorDiv').html(
								"Ocurrió un error guardando el equipo");
						jQuery('errorDiv').css('display', 'block');
						return;
					}
				}
			});
}
function saveSocializacion() {
	jQuery('#errorDiv').css('display', 'none');
	var fecha = jQuery("#fecha").val();
	var id_tipo_evento = jQuery("#id_tipo_evento").val();
	var duracionHoras = jQuery("#duracion_horas").val();
	var idEvento = jQuery("#idEvento").val();
	if (fecha == "" || fecha == "0") {
		jQuery('#errorDiv').html("Debe ingresar la fecha");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (id_tipo_evento == "" || id_tipo_evento == "0") {
		jQuery('#errorDiv').html("Debe ingresar el tipo de socialización");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (duracionHoras == "" || duracionHoras == "-1") {
		jQuery('#errorDiv').html("Debe seleccionar la duración");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	var idEquipos = [];
	jQuery("input[name*='id_equipo'],select[name*='id_equipo']").each(
			function(element) {
				idEquipos.push(jQuery(this).attr("id").split("_")[2] + "_"
						+ jQuery(this).val());
			});
	idEquipos = idEquipos.join(",");

	var idEvaluadores = [];
	jQuery("input[name*='id_evaluador'],select[name*='id_evaluador']").each(
			function(element) {
				idEvaluadores.push(jQuery(this).attr("id").split("_")[2] + "_"
						+ jQuery(this).val());
			})
	idEvaluadores = idEvaluadores.join(",");

	jQuery
			.ajax({
				url : 'http://localhost:' + puerto
						+ '/SGPPI_2018/pages/social/saveSocial.html',
				data : {
					fecha : fecha,
					id_tipo_evento : id_tipo_evento,
					duracion_horas : duracionHoras,
					id_equipo : idEquipos,
					id_evaluador : idEvaluadores,
					id_evento : idEvento
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
						} else if (data.status != undefined
								&& data.status == 'ok') {
							jQuery('#successDiv').html(data.message);
							jQuery('#successDiv').css('display', 'block');
							clear();
							setTimeout(function() {
								location.reload();
							}, 500);
						} else {
							if(typeof data.message !== "undefined"){
								jQuery('errorDiv').html(data.message);
							}else{
								jQuery('errorDiv').html(
								"Ocurrió un error guardando el evento");
							}
							
							
					jQuery('errorDiv').css('display', 'block');
						}
					} catch (err) {
						jQuery('errorDiv').html(
								"Ocurrió un error guardando el evento");
						jQuery('errorDiv').css('display', 'block');
						return;
					}
				}
			});
}

function confirmationSocializacion(id) {
	if (confirm('Seguro que desea eliminar la socialización?')) {
		deleteSocializacion(id);
	}
}

function deleteSocializacion(id) {
	jQuery('#errorDiv').css('display', 'none');
	var idSocializacion = id;

	if (idSocializacion == "" || idSocializacion == ""
			|| idSocializacion == undefined) {
		jQuery('#errorDiv').html("No se encontró la socialización");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	jQuery
			.ajax({
				url : 'http://localhost:' + puerto
						+ '/SGPPI_2018/pages/social/deleteSocial.html',
				data : {
					id_evento : idSocializacion
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
						} else if (data.status != undefined
								&& data.status == 'ok') {
							jQuery('#successDiv').html(data.message);
							jQuery('#successDiv').css('display', 'block');
							clear();
							setTimeout(function() {
								location.reload();
							}, 500);
						} else {
							jQuery('errorDiv')
									.html(
											"Ocurri&oacute; un error eliminando la socialización");
							jQuery('errorDiv').css('display', 'block');
						}
					} catch (err) {
						jQuery('errorDiv').html(
								"Ocurrió un error eliminando la socialización");
						jQuery('errorDiv').css('display', 'block');
						return;
					}
				}
			});
}
