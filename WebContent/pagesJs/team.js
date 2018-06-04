var puerto = '8080';
var cont = 0;
var contReal = 0;
function updateTeam() {
	jQuery('#errorDiv').css('display', 'none');
	var codigo = jQuery("#codigo").val();
	var nombre = jQuery("#nombre").val();
	var idAsignatura = jQuery("#id_asignatura").val();
	var idEquipo = jQuery("#id_equipo").val();

	if (codigo == "" || codigo == "0") {
		jQuery('#errorDiv').html("Debe ingresar el código");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (nombre == "" || nombre == "0") {
		jQuery('#errorDiv').html("Debe ingresar el nombre");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (idAsignatura == "" || idAsignatura == "-1") {
		jQuery('#errorDiv').html("Debe seleccionar el módulo sol");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	var idUsuario = [];
	jQuery("input[name*='id_usuario'],select[name*='id_usuario']").each(
			function(element) {
				idUsuario.push(jQuery(this).val());
			})
	idUsuario = idUsuario.join(",");
	jQuery
			.ajax({
				url : 'http://localhost:' + puerto
						+ '/SGPPI_2018/pages/team/updateTeam.html',
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
							jQuery('#errorDiv').html(data.message);
							jQuery('#errorDiv').css('display', 'block');
						} else if (data.status != undefined
								&& data.status == 'ok') {
							jQuery('#successDiv').html(data.message);
							jQuery('#successDiv').css('display', 'block');
							clear();
//							setTimeout(function() {
//								location.reload();
//							}, 500);
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
function saveUser() {
	jQuery('#errorDiv').css('display', 'none');
	var num = jQuery('#num').val();
	var nomCuadra = jQuery('#nomCuadra').val();
	var desCuadra = jQuery('#desCuadra').val();
	var asigAso = jQuery('#asigAso').val();
	var idCuadra = jQuery("#idCuadra").val();
	if (num == "" || num == "0") {
		jQuery('#errorDiv').html("Debe ingresar el número del cuadrante");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (nomCuadra == "" || nomCuadra == "0") {
		jQuery('#errorDiv').html("Debe nngresar el nombre del cuadrante");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (desCuadra == "" || desCuadra == "0") {
		jQuery('#errorDiv').html("Debe ingresar la descripción");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (asigAso == "" || asigAso == "0") {
		jQuery('#errorDiv').html("Debe seleccionar la asignatura asociada");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}

	jQuery
			.ajax({
				url : 'http://localhost:' + puerto
						+ '/SGPPI_2018/pages/quadrant/saveQuadrant.html',
				data : {
					num : num,
					nomCuadra : nomCuadra,
					desCuadra : desCuadra,
					asigAso : asigAso,
					idCuadra : idCuadra
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
	cont = i;
	contReal = i;
}
function agregarEstudiante() {
	cont++;
	contReal++;
	var options = jQuery("#template-sin-equipo").html();
	jQuery("#div_tabla_estudiantes").append(
			"<div class='row' id='est_div_" + cont
					+ "'><div class='col-sm-12'><select name='id_usuario["
					+ cont + "]' id='id_usuario_" + cont
					+ "' class='form-control'>" + options + "</select>")
}
function eliminarEstudiante(row) {
	if (contReal > 1) {
		$("#est_div_" + row).remove();
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
		url : 'http://localhost:' + puerto
				+ '/SGPPI_2018/pages/team/deleteTeam.html',
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
					clear();
					setTimeout(function() {
						location.reload();
					}, 500);
				} else {
					jQuery('errorDiv').html(
							"Ocurri&oacute; un error eliminando el equipo");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv')
						.html("Ocurrió un error eliminando el equipo");
				jQuery('errorDiv').css('display', 'block');
				return;
			}
		}
	});
}

function clear() {
	jQuery('#num').val("");
	jQuery('#nomCuadra').val("");
	jQuery('#desCuadra').val("");
	jQuery('#asigAso').val("");
}
