var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';
var contAsig = 0;
function updateUser() {

	jQuery('#errorDiv').css('display', 'none');
	var correo = jQuery("#correo").val();
	var nombre = jQuery("#nombre").val();
	var apellidos = jQuery("#apellidos").val();
	var fechaNac = jQuery("#fecha_nac").val();
	var idCargo = jQuery("#id_cargo").val();
	var cedula = jQuery("#cedula").val();
	var estado = jQuery("#estado").val();
	var minimo_asesorias =  jQuery("#minimo_asesorias").val();
	var idUsuario = jQuery("#id_usuario").val();
	
	if (correo == "" || correo == "0") {
		jQuery('#errorDiv').html("Debe ingresar el correo");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (nombre == "" || nombre == "0") {
		jQuery('#errorDiv').html("Debe ingresar el nombre");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (apellidos == "" || apellidos == "0") {
		jQuery('#errorDiv').html("Debe ingresar los apellidos");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (fechaNac == "" || fechaNac == "0") {
		jQuery('#errorDiv').html("Debe ingresar la fecha de nacimiento");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (idCargo == "-1") {
		jQuery('#errorDiv').html("Debe ingresar el cargo");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (cedula == "" || cedula == "0") {
		jQuery('#errorDiv').html("Debe ingresar la cédula");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (idCargo == 3 && (isNaN(minimo_asesorias) || minimo_asesorias == "" || minimo_asesorias == "0")) {
		jQuery('#errorDiv').html("Debe ingresar un minimo de asesorias y debe ser mayor a 0");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	
	
	jQuery.ajax({
		url : urlFull + '/pages/users/updateUser.html',
		data : {
			id_usuario : idUsuario,
			correo : correo,
			nombre : nombre,
			apellidos : apellidos,
			fecha_nac : fechaNac,
			id_cargo : idCargo,
			cedula : cedula,
			estado : estado,
			minimo_asesorias: minimo_asesorias
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
							"Ocurrió un error modificando el usuario");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv').html(
						"Ocurrió un error modificando el usuario");
				jQuery('errorDiv').css('display', 'block');
				return;
			}
		}
	});
}
function mostrarYOcultarMinimoAsesorias(cargo){
	if(cargo == 3){
		$("#div_minimo_asesorias").show();
	}else{
		$("#div_minimo_asesorias").hide();
	}
}
function agregarAsignatura() {
	contAsig++;
	var options = jQuery("#asignaturas_options").html();
	jQuery("#asignaturas")
			.append(
					"<div class='row' id='"
							+ contAsig
							+ "'><div class='col-sm-12'><select name='id_asignatura["
							+ contAsig
							+ "]' id='id_asignatura_"
							+ contAsig
							+ "' class='form-control'><option value='-1'>Seleccione la asignatura...</option>"
							+ options + "</select></div></div>");
}
function cambioCargo(idCargo) {
	
	$("#info_adicional_usuario").empty();
	
	mostrarYOcultarMinimoAsesorias(idCargo);
}
function eliminarAsignatura(row) {
	$("#asignatura_" + row).remove();
}
function updateUserForm(id_usuario, correo, nombre, apellidos, cedula,
		fechaNac, idCargo, estado, minimoAsesorias) {
	contAsig = 1;
	jQuery('#id_usuario').val(id_usuario);
	jQuery('#correo').val(correo);
	jQuery('#nombre').val(nombre);
	jQuery('#apellidos').val(apellidos);
	jQuery('#cedula').val(cedula);
	
	var fechaNacSplit = fechaNac.split("/");
	fechaNacSplit.reverse();
	jQuery('#fecha_nac').val(fechaNacSplit.join("-"));
	jQuery('#id_cargo').val(idCargo);
	jQuery('#estado').val(estado)
	jQuery("#info_adicional_usuario").empty();
	
	if(idCargo == 3){
		$("#div_minimo_asesorias").show();
		$("#minimo_asesorias").val(minimoAsesorias);
	}
	
	if (idCargo == 1) {
		jQuery
				.ajax({
					url : urlFull + '/pages/users/getInfoAdicional.html',
					data : {
						id_usuario : id_usuario,
						id_cargo : idCargo
					},
					success : function(o) {
						if (o == "") {
							return;
						}
						var data;
						try {
							data = jQuery.parseJSON(o);
							if (data.status != undefined
									&& data.status == 'errors') {
								jQuery('#errorDiv').html(data.message);
								jQuery('#errorDiv').css('display', 'block');
							} else if (data.status != undefined
									&& data.status == 'ok') {
								var info = data.info;
								jQuery("#info_adicional_usuario").html(info);
							} else {
								jQuery('errorDiv')
										.html(
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

}

function clear() {
	jQuery('#num').val("");
	jQuery('#nomCuadra').val("");
	jQuery('#desCuadra').val("");
	jQuery('#asigAso').val("");
}
