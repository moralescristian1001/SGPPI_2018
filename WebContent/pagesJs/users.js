var puerto = '8080';
function updateUser() {
	jQuery('#errorDiv').css('display', 'none');
	var correo = jQuery("#correo");
	var nombre = jQuery("#nombre");
	var apellidos = jQuery("#apellidos");
	var fechaNac = jQuery("#fecha_nac");
	var idCargo = jQuery("#id_cargo");
	var cedula = jQuery("#cedula");

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
		jQuery('#errorDv').html("Debe ingresar el cargo");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (cedula == "" || cedula == "0") {
		jQuery('#errorDv').html("Debe ingresar la cédula");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : 'http://localhost:' + puerto
				+ '/SGPPI_2018/pages/users/updateUser.html',
		data : {
			correo: correo,
			nombre : nombre,
			apellidos: apellidos,
			fechaNac: fechaNac,
			idCargo: idCargo,
			cedula: cedula
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
							"Ocurrió un error guardando el usuario");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv').html(
						"Ocurrió un error guardando el usuario");
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

	jQuery.ajax({
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
				} else if (data.status != undefined && data.status == 'ok') {
					jQuery('#successDiv').html(data.message);
					jQuery('#successDiv').css('display', 'block');
					clear();
					setTimeout(function() {
						location.reload();
					}, 500);
				} else {
					jQuery('errorDiv').html(
							"Ocurrió un error guardando el cuadrante");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv').html(
						"Ocurrió un error guardando el cuadrante");
				jQuery('errorDiv').css('display', 'block');
				return;
			}
		}
	});
}

function confirmationUser(id) {
	if (confirm('Seguro que desea eliminar el usuario?')) {
		deleteUsuario(id);
	}
}

function updateUserForm(id_usuario, correo, nombre, apellidos, semest) {
	jQuery('#idCuadra').val(id);
	jQuery('#num').val(code);
	jQuery('#nomCuadra').val(nom);
	jQuery('#desCuadra').val(encar);
	jQuery('#asigAso').val(semest)
}

function deleteUsuario(id) {
	jQuery('#errorDiv').css('display', 'none');
	var idUsuario = id;

	if (idUsuario == "" || idUsuario == "" || idUsuario == undefined) {
		jQuery('#errorDiv').html("No se encontró el usuario");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : 'http://localhost:' + puerto
				+ '/SGPPI_2018/pages/user/deleteUser.html',
		data : {
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
				} else if (data.status != undefined && data.status == 'ok') {
					jQuery('#successDiv').html(data.message);
					jQuery('#successDiv').css('display', 'block');
					clear();
					setTimeout(function() {
						location.reload();
					}, 500);
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

function clear() {
	jQuery('#num').val("");
	jQuery('#nomCuadra').val("");
	jQuery('#desCuadra').val("");
	jQuery('#asigAso').val("");
}
