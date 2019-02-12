var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';
var cont = 0;
var contReal = 0;
var insertar = false;


function guardarTeamForm(){
	insertar = true;
	cont = 0;
	$("#codigo").val("");
	$("#nombre").val("");
	$("#id_asignatura").val("-1");
	$("#nombre").val("");
	
	$("#div_tabla_estudiantes").empty();
	for(var i = 0; i < 3; i++){
		agregarEstudiante();
	}
	
}

function updateTeam() {
	jQuery('#errorDiv').css('display', 'none');
	var codigo = jQuery("#codigo").val();
	var nombre = jQuery("#nombre").val();
	var idAsignatura = jQuery("#id_asignatura").val();
	var idEquipo = jQuery("#id_equipo").val();

	if (codigo == null || codigo == "" || codigo == "0") {
		jQuery('#messageErrorModal').html("Debe ingresar el código");
		jQuery('#errorModal').css('display', 'block');
		return;
	}else{ 
		if(codigo <= 0) {
			jQuery('#messageErrorModal').html("Debe ingresar un código valido");
			jQuery('#errorModal').css('display', 'block');
			return;
		}
	}
	if (nombre == null || nombre == "" || nombre == "0") {
		jQuery('#messageErrorModal').html("Debe ingresar el nombre");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if (idAsignatura == null ||idAsignatura == "" || idAsignatura == "-1") {
		jQuery('#messageErrorModal').html("Debe seleccionar el módulo sol");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	var idUsuario = [];
	var errorAsignandoEquipo = false;
	jQuery("input[name*='id_usuario'],select[name*='id_usuario']").each(
	function(id) {
		id += 1;
		if(id == "1" && jQuery(this).val() == "-1"){
			jQuery('#messageErrorModal').html("Debe seleccionar un estudiante en el primer campo obligatoriamente, el resto son opcionales");
			jQuery('#errorModal').css('display', 'block');
			errorAsignandoEquipo = true;
		}else if(idUsuario.indexOf(jQuery(this).val()) >= 0){
			jQuery('#messageErrorModal').html("No puedes repetir estudiante");
			jQuery('#errorModal').css('display', 'block');
			errorAsignandoEquipo = true;
		}else if(jQuery(this).val() != "-1"){
			idUsuario.push(jQuery(this).val());
		}
	});
	if(errorAsignandoEquipo){
		return;
	}
	idUsuario = idUsuario.join(",");
	jQuery
			.ajax({
				url : urlFull + '/pages/team/updateTeam.html',
				data : {
					codigo : codigo,
					nombre : nombre,
					id_asignatura : idAsignatura,
					id_equipo : idEquipo,
					id_usuario : idUsuario
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
							if(insertar){
								var idEquipo = data.id_equipo;
								$("#id_equipo").val(idEquipo);
							}
							jQuery("html, body").animate({ scrollTop: 0 }, 600);
							jQuery('#myModalEditar').modal('hide');
							jQuery('.modal-backdrop').removeClass('in');
							setTimeout(function() {
									location.reload();
							}, 2000);
						} else {
							jQuery('#messageErrorModal').html(
									"Ocurrió un error guardando el equipo");
							jQuery('#errorModal').css('display', 'block');
							return;
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

function confirmationTeam(id) {
	if (confirm('Seguro que desea eliminar el equipo?')) {
		deleteTeam(id);
	}
}

function updateTeamForm(id, codigo, nombre, idAsignatura, estudiantes) {
	jQuery('#id_equipo').val(id);
	jQuery('#codigo').val(codigo);
	jQuery('#nombre').val(nombre);
	jQuery('#id_asignatura').val(idAsignatura);
	var i = 1;
	$("#div_tabla_estudiantes").empty();
	for (i = 1; i <= estudiantes.length; i++) {
		var est = estudiantes[i - 1];
		$("#div_tabla_estudiantes")
				.append(
						"<div class='row' id='est_div_"
								+ i
								+ "'><div class='col-sm-12'><input type='hidden' name='id_usuario["
								+ i
								+ "]' id='id_usuario_"
								+ i
								+ "' value='"
								+ est.id_usuario
								+ "'>"
								+ est.nombre
								+ "<a href='javascript:eliminarEstudiante("
								+ i
								+ ")'><i class='fa fa-remove fa-fw'></i></a></div></div>")
	}
	
	cont = i - 1;
	contReal = i - 1;
	for(var i = estudiantes.length; i < 3; i++){
		agregarEstudiante();
	}
}

function actualizarEstudiante(contSelect){
	
	var idEstudiante = jQuery("#id_usuario_" + contSelect).val();
	
	
	
	var prev = $("#id_usuario_" + contSelect).data("prev");
	
	if(idEstudiante != "-1"){
		$("select[id^='id_usuario_']:not(#id_usuario_"+contSelect + ") option[value='"+idEstudiante+"']").hide();
		$("select[id^='id_usuario_']:not(#id_usuario_"+contSelect + ") option[value='"+prev+"']").show();
	}else{
		$("select[id^='id_usuario_']:not(#id_usuario_"+contSelect + ") option[value='"+prev+"']").show();
	}
	
	
	jQuery("#id_usuario_" + contSelect).data("prev", idEstudiante);
}

function agregarEstudiante(row) {
	cont++;
	
	if(row == undefined){
		row = cont;
	}
	var options = jQuery("#template-sin-equipo").html();
	var mensaje = row == 1 ? "Estudiante obligatorio" : "Estudiante opcional";

	jQuery("#div_tabla_estudiantes").append(
			"<div class='row' id='est_div_" + row
					+ "'><div class='col-sm-12'>" +
							"<select name='id_usuario["
					+ row + "]' id='id_usuario_" + row
					+ "' class='form-control' onchange='actualizarEstudiante("+row+")'><option value='-1'>"+mensaje+"</option>" + options + "</select>")
	jQuery("#id_usuario_" + row).data("prev", "-1");
}
function eliminarEstudiante(row) {
	if (contReal > 1) {
		$("#est_div_" + row).remove();
		agregarEstudiante(row);
		contReal--;
	}
	
}

function deleteTeam(id) {
	jQuery('#errorDiv').css('display', 'none');
	var idEquipo = id;

	if (idEquipo == "" || idEquipo == "" || idEquipo == undefined) {
		jQuery('#errorDiv').html("No se encontró el equipo");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : urlFull + '/pages/team/deleteTeam.html',
		data : {
			id_equipo : idEquipo
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
					jQuery("html, body").animate({ scrollTop: 0 }, 600);
					setTimeout(function() {
						location.reload();
					}, 2000);
				} else {
					jQuery('#errorDiv').html(
							"Ocurrió un error eliminando el equipo");
					jQuery('#errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('#errorDiv')
						.html("Ocurrió un error eliminando el equipo");
				jQuery('#errorDiv').css('display', 'block');
				return;
			}
		}
	});
}
