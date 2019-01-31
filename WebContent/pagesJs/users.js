var puerto = '8080';
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
	var asignaturas = jQuery(
			"input[name*='id_asignatura'], select[name*='id_asignatura']")
			.each(function(element) {
				idAsignatura.push(jQuery(this).val());
			});
	idAsignatura = idAsignatura.join(",");
	if (correo == null || correo == undefined || correo == "") {
		jQuery("#messageErrorModal").html("Debe ingresar el correo");
		jQuery('#errorModal').css('display', 'block');
		return;
	}else{
		if(!correo.includes("@elpoli.edu.co")){
			jQuery("#messageErrorModal").html("El correo debe ser institucional");
			jQuery('#errorModal').css('display', 'block');
			return;
		}
	}
	if (nombre == null || nombre == undefined || nombre == "") {
		jQuery("#messageErrorModal").html("Debe ingresar el nombre");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if (apellidos == null || apellidos == undefined || apellidos == "") {
		jQuery("#messageErrorModal").html("Debe ingresar los apellidos");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if (fechaNac == null || fechaNac == "") {
		jQuery("#messageErrorModal").html("Debe ingresar la fecha de nacimiento");
		jQuery('#errorModal').css('display', 'block');
		return;
	}else{
		var today = formatDate(new Date());
		if(today <= fechaNac){
			jQuery("#messageErrorModal").html("La fecha seleccionada no es valida");
			jQuery('#errorModal').css('display', 'block');
			return;
		}
	}
	if (idCargo == "-1") {
		jQuery("#messageErrorModal").html("Debe ingresar el cargo");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if (cedula == null || cedula == undefined || cedula == "" || cedula == "0") {
		jQuery("#messageErrorModal").html("Debe ingresar la cédula");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if (idCargo == 3 && (isNaN(minimo_asesorias) || minimo_asesorias == "" || minimo_asesorias == "0")) {
		jQuery('#errorDiv').html("Debe ingresar un minimo de asesorias y debe ser mayor a 0");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	
	
	jQuery.ajax({
		url : 'http://localhost:' + puerto
				+ '/SGPPI_2018/pages/users/updateUser.html',
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
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
				} else if (data.status != undefined && data.status == 'ok') {
					jQuery('#successDivFormMessage').html(data.message);
					jQuery('#successDivForm').css('display', 'block');
					jQuery("html, body").animate({ scrollTop: 0 }, 600);
					jQuery('#myModalEditar').modal('hide');
					jQuery('.modal-backdrop').removeClass('in');
					setTimeout(function() {
							location.reload();
					}, 2000);
				} else {
					jQuery('messageErrorModal').html(
							"Ocurrió un error modificando el usuario");
					jQuery('errorModal').css('display', 'block');
				}
			} catch (err) {
				jQuery('messageErrorModal').html(
						"Ocurrió un error modificando el usuario");
				jQuery('errorModal').css('display', 'block');
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
					url : 'http://localhost:' + puerto
							+ '/SGPPI_2018/pages/users/getInfoAdicional.html',
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

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
}
