var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';
function save() {
	jQuery('#errorDiv').css('display', 'none');
	var idSalon = jQuery('#idSalon').val();
	var descripcion = jQuery('#descripcion').val();

	if (descripcion == null || descripcion == undefined || descripcion == "" || descripcion == "0") {
		jQuery("#messageErrorModal").html("Debe ingresar la descripción");
		jQuery('#errorModal').css('display', 'block');
		return;
	}

	jQuery.ajax({
		url : urlFull + '/pages/classRoom/saveClassRoom.html',
		data : {
			idSalon : idSalon,
			descripcion : descripcion
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
					jQuery('#messageErrorModal').html("Ocurrió un error guardando el salón");
					jQuery('#errorModal').css('display', 'block');
					return;
				}
			} catch (err) {
				jQuery('#messageErrorModal').html("Ocurrió un error guardando el salón");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
}
function confirmation(id) {
	if (confirm('Seguro que desea eliminar el salón?')) {
		deleteSale(id);
	}
}

function deleteSale(id) {
	jQuery('#errorDiv').css('display', 'none');
	var idSalon = id;

	if (idSalon == "" || idSalon == null || idSalon == undefined) {
		jQuery('#errorDiv').html("No se encontró salón asociado");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : urlFull + '/pages/classRoom/deleteClassRoom.html',
		data : {
			idSalon : idSalon
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
					setTimeout(function() {
						location.reload();
					}, 2000);
				} else {
					jQuery('#errorDiv').html(
							"Ocurrió un error eliminando el salón");
					jQuery('#errorDiv').css('display', 'block');
				}
			} catch (err) {
				jQuery('#errorDiv').html(
						"Ocurrió un error eliminando el salón");
				jQuery('#errorDiv').css('display', 'block');
				return;
			}
		}
	});
}
