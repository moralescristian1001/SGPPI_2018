var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';
function save() {
	jQuery('#errorDiv').css('display', 'none');
	var idAsig = jQuery('#idAsig').val();
	var code = jQuery('#code').val();
	var asig = jQuery('#asig').val();
	var semes = jQuery('#semes').val();

	if (code == null || code == undefined || code == "") {
		jQuery("#messageErrorModal").html("Debe ingresar el código");
		jQuery('#errorModal').css('display', 'block');
		return;
	}else{
		var lengthCode = code.length;
		if(lengthCode > 8){
			jQuery("#messageErrorModal").html("El código no puede tener más de 8 caractares");
			jQuery('#errorModal').css('display', 'block');
			return;
		}
	}
	if (asig == null || asig == undefined || asig == "") {
		jQuery("#messageErrorModal").html("Debe ingresar el nombre de la asignatura");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if (semes == null || semes == undefined || semes == "" || semes == "0") {
		jQuery("#messageErrorModal").html("Debe ingresar el semestre");
		jQuery('#errorModal').css('display', 'block');
		return;
	}

	jQuery.ajax({
		url : urlFull + '/pages/sunModule/saveSunModulo.html',
		data : {
			idAsig : idAsig,
			code : code,
			asig : asig,
			semes : semes
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
					clear();
					jQuery("html, body").animate({ scrollTop: 0 }, 600);
					jQuery('#myModal').modal('hide');
					jQuery('.modal-backdrop').removeClass('in');
					setTimeout(function() {
							location.reload();
					}, 2000);
				} else {
					jQuery('#messageErrorModal').html("Ocurrió un error guardando la asignatura");
					jQuery('#errorModal').css('display', 'block');
					return;
				}
			} catch (err) {
				jQuery('#messageErrorModal').html("Ocurrió un error guardando la asignatura");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
}

function updateModuloSol(id, code, nom, semest) {
	jQuery('#idAsig').val(id);
	jQuery('#code').val(code);
	jQuery('#asig').val(nom);
	jQuery('#semes').val(semest);
	jQuery('#code').prop('disabled', true);
}

function confirmation(id) {
	if (confirm('Seguro que desea eliminar la asignatura?')) {
		deleteSale(id);
	}
}

function deleteSale(id) {
	jQuery('#errorDiv').css('display', 'none');
	var idAsig = id;

	if (idAsig == "" || idAsig == "" || idAsig == undefined) {
		jQuery('#errorDiv').html("No se encontró la asignatura");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : urlFull + '/pages/sunModule/deleteSunModule.html',
		data : {
			idAsig : idAsig
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
					jQuery('#myModal').modal('hide');
					jQuery('.modal-backdrop').removeClass('in');
					clear();
					setTimeout(function() {
						location.reload();
					}, 2000);
				} else {
					jQuery('errorDiv').html(
							"Ocurrió un error eliminando la asignatura");
					jQuery('errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('errorDiv').html(
						"Ocurrió un error eliminando la asignatura");
				jQuery('errorDiv').css('display', 'block');
				return;
			}
		}
	});
}

function clear() {
	jQuery('#code').val("");
	jQuery('#asig').val("");
	jQuery('#semes').val("");
}
