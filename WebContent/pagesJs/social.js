
var cont = [];
var contEv = [];
var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';

function irInformeNotas(idEvento){
	location.href = urlFull + "/pages/qualifyGradeReport.html?id_socializacion=" + idEvento;
}

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
		url : urlFull + '/pages/social/getInfoAdicional.html',
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
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
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
					jQuery('#messageErrorModal').html(
							"Ocurri&oacute; un error eliminando el cuadrante");
					jQuery('#errorModal').css('display', 'block');
				}
			} catch (err) {
				jQuery('#messageErrorModal').html(
						"Ocurrió un error eliminando el cuadrante");
				jQuery('#errorModal').css('display', 'block');
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

	if (fecha == null || fecha == "") {
		jQuery('#messageErrorModal').html("Debe ingresar la fecha");
		jQuery('#errorModal').css('display', 'block');
		return;
	}else{
		var today = formatDate(new Date());
		if(fecha < today){
			jQuery("#messageErrorModal").html("La fecha seleccionada no es valida");
			jQuery('#errorModal').css('display', 'block');
			return;
		}
	}
	if (id_tipo_socializacion == null || id_tipo_socializacion == "0") {
		jQuery('#messageErrorModal').html("Debe ingresar el tipo de socialización");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if (duracionHoras == null || duracionHoras == "" || duracionHoras <= 0) {
		jQuery('#messageErrorModal').html("Debe ingresar la duración");
		jQuery('#errorModal').css('display', 'block');
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
				url : urlFull + '/pages/social/updateSocial.html',
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
							jQuery('#messageErrorModal').html(data.message);
							jQuery('#errorModal').css('display', 'block');
						} else if (data.status != undefined
								&& data.status == 'ok') {
							jQuery('#successDiv').html(data.message);
							jQuery('#successDiv').css('display', 'block');
							// setTimeout(function() {
							// location.reload();
							// }, 500);
						} else {
							jQuery('#messageErrorModal').html(
									"Ocurrió un error guardando el equipo");
							jQuery('#errorModal').css('display', 'block');
						}
					} catch (err) {
						jQuery('#messageErrorModal').html(
								"Ocurrió un error guardando el equipo");
						jQuery('#errorModal').css('display', 'block');
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
	if (fecha == null || fecha == "") {
		jQuery('#messageErrorModal').html("Debe ingresar la fecha");
		jQuery('#errorModal').css('display', 'block');
		return;
	}else{
		var today = formatDate(new Date());
		if(fecha < today){
			jQuery("#messageErrorModal").html("La fecha seleccionada no es valida");
			jQuery('#errorModal').css('display', 'block');
			return;
		}
	}
	if (id_tipo_evento == null || id_tipo_evento == "0") {
		jQuery('#messageErrorModal').html("Debe ingresar el tipo de socialización");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if (duracionHoras == null || duracionHoras == "" || duracionHoras <= 0) {
		jQuery('#messageErrorModal').html("Debe ingresar la duración");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	var cantidadSalones = 0;
	idEquipos = [];
	idEvaluadores = [];
	idEquiposGeneral = [];
	idEvaluadoresGeneral = [];
	var errorAsignandoEquipo = false;
	var errorAsignandoEvaluador = false;
	$("input[name*='salones']").each(function(){
		if($(this).is(":checked")){
			cantidadSalones++;
			var salon = $(this).val();
			var descripcionSalon = $(this).data("descripcion");
			var inserto = false; 
			//equipos
			
			
			jQuery("input[id*='id_equipo_" + salon + "'],select[id*='id_equipo_"+salon+"']").each(
					function(element) {
						var equipo = jQuery(this).val();
						if(equipo == "0"){
							jQuery('#messageErrorModal').html("Debe seleccionar el equipo en el salon " + descripcionSalon);
							jQuery('#errorModal').css('display', 'block');
							errorAsignandoEquipo = true;
							return;
						}
						if(idEquipos.indexOf(equipo) >= 0){
							jQuery('#messageErrorModal').html("No puedes repetir equipo en el salón " + descripcionSalon);
							jQuery('#errorModal').css('display', 'block');
							errorAsignandoEquipo = true;
							return;
						}
						
						if(idEquiposGeneral.indexOf(equipo) >= 0){
							jQuery('#messageErrorModal').html("Hay 2 o más salones con el equipo " + $(this).find("option:selected").html());
							jQuery('#errorModal').css('display', 'block');
							errorAsignandoEquipo = true;
							return;
						}
						
						idEquipos.push(salon + "_"
								+ equipo);
						idEquiposGeneral.push(equipo);
						inserto = true;
					});
			if(errorAsignandoEquipo){
				return;
			}
			if(!inserto){
				jQuery('#messageErrorModal').html("Debe agregar al menos un equipo del salón " + descripcionSalon);
				jQuery('#errorModal').css('display', 'block');
				return;
			}
			inserto = false;
			//end equipos
			
			//evaluadores
			var contEvaluadores = 0;
			jQuery("input[id*='id_evaluador_" + salon + "'],select[id*='id_evaluador_" + salon + "']").each(
					function(element) {
						var ev = jQuery(this).val()
						if(ev == "0"){
							jQuery('#messageErrorModal').html("Debe seleccionar el evaluador en el salon " + descripcionSalon);
							jQuery('#errorModal').css('display', 'block');
							errorAsignandoEvaluador = true;
							return;
						}
						if(idEvaluadores.indexOf(ev) >= 0){
							jQuery('#messageErrorModal').html("No puedes repetir evaluador en el salón " + descripcionSalon);
							jQuery('#errorModal').css('display', 'block');
							errorAsignandoEvaluador = true;
							return;
						}
						
						if(idEvaluadoresGeneral.indexOf(ev) >= 0){
							jQuery('#messageErrorModal').html("Hay 2 o más salones con el evaluador " + $(this).find("option:selected").html());
							jQuery('#errorModal').css('display', 'block');
							errorAsignandoEvaluador = true;
							return;
						}
						idEvaluadores.push(salon + "_"
								+ ev);
						idEvaluadoresGeneral.push(ev);
						inserto = true;
						contEvaluadores ++;
						
					});
			if(errorAsignandoEvaluador){
				return;
			}
			if(!inserto){
				jQuery('#messageErrorModal').html("Debe agregar al menos un evaluador del salón " + descripcionSalon);
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		
			//end evaluadores
		}
	})
	
	if(cantidadSalones == 0){
		jQuery('#messageErrorModal').html("Debe seleccionar al menos un salon");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	
	if(errorAsignandoEquipo){
		return;
	}
	if(idEquipos.length == 0){
		jQuery('#messageErrorModal').html("Debe seleccionar al menos un equipo en cada uno de los salones");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	idEquipos = idEquipos.join(",");
	
	
	if(errorAsignandoEvaluador){
		return;
	}
	if(idEvaluadores.length <=1){
		jQuery('#messageErrorModal').html("Debe seleccionar al menos 2 evaluadores en cada uno de los salones");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	idEvaluadores = idEvaluadores.join(",");
	
	
	
	jQuery
			.ajax({
				url : urlFull + '/pages/social/saveSocial.html',
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
							jQuery('#messageErrorModal').html(data.message);
							jQuery('#errorModal').css('display', 'block');
						} else if (data.status != undefined
								&& data.status == 'ok') {
							jQuery('#successDiv').html(data.message);
							jQuery('#successDiv').css('display', 'block');
							jQuery("html, body").animate({ scrollTop: 0 }, 600);
							jQuery('#myModal').modal('hide');
							jQuery('.modal-backdrop').removeClass('in');
							setTimeout(function() {
									location.reload();
							}, 2000);
						} else {
							if(typeof data.message !== "undefined"){
								jQuery('#messageErrorModal').html(data.message);
							}else{
								jQuery('#messageErrorModal').html(
								"Ocurrió un error guardando el evento");
							}
							
							
					jQuery('#errorModal').css('display', 'block');
						}
					} catch (err) {
						jQuery('#messageErrorModal').html(
								"Ocurrió un error guardando el evento");
						jQuery('#errorModal').css('display', 'block');
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
				url : urlFull + '/pages/social/deleteSocial.html',
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
							jQuery("html, body").animate({ scrollTop: 0 }, 600);
							jQuery('#myModal').modal('hide');
							jQuery('.modal-backdrop').removeClass('in');
							setTimeout(function() {
								location.reload();
							}, 2000);
						} else {
							jQuery('#errorDiv')
									.html(
											"Ocurrió un error eliminando la socialización");
							jQuery('#errorDiv').css('display', 'block');
						}
					} catch (err) {
						jQuery('#errorDiv').html(
								"Ocurrió un error eliminando la socialización");
						jQuery('#errorDiv').css('display', 'block');
						return;
					}
				}
			});
}

function formatDate(date) {
	  var hours = date.getHours();
	  var minutes = date.getMinutes();
	  var ampm = hours >= 12 ? 'pm' : 'am';
	  hours = hours % 12;
	  hours = hours ? hours : 12; // the hour '0' should be '12'
	  minutes = minutes < 10 ? '0'+minutes : minutes;
	  var strTime = hours + ':' + minutes + ' ' + ampm;
	  return date.getMonth()+1 + "/" + date.getDate() + "/" + date.getFullYear() + "  " + strTime;
	}
