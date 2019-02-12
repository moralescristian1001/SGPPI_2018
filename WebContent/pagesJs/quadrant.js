var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';
function saveCuadra(){
	jQuery('#errorDiv').css('display', 'none');
	var num = jQuery('#num').val();
	var nomCuadra = jQuery('#nomCuadra').val();
	var desCuadra = jQuery('#desCuadra').val();
	var asigAso = jQuery('#asigAso').val();
	var idCuadra = jQuery("#idCuadra").val();
	if(num == "" || num == "0"){
		jQuery('#messageErrorModal').html("Debe ingresar el número del cuadrante");
		jQuery('#errorModal').css('display', 'block');
	    return;
	}
	if(nomCuadra == "" || nomCuadra == "0"){
		jQuery('#messageErrorModal').html("Debe ingresar el nombre del cuadrante");
		jQuery('#errorModal').css('display', 'block');
	    return;
	}
	if(desCuadra == "" || desCuadra == "0"){
		jQuery('#messageErrorModal').html("Debe ingresar la descripción");
		jQuery('#errorModal').css('display', 'block');
	    return;
	}
	if(asigAso == "" || asigAso == "0"){
		jQuery('#messageErrorModal').html("Debe seleccionar la asignatura asociada");
		jQuery('#errorModal').css('display', 'block');
	    return;
	}
	
	jQuery.ajax({
		url : urlFull + '/pages/quadrant/saveQuadrant.html',
		data: {num: num, nomCuadra:nomCuadra, desCuadra:desCuadra, asigAso:asigAso, idCuadra: idCuadra},
		success: function(o) {
			if(o=="") {
				return;
			}
			var data;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
				}else if(data.status != undefined && data.status == 'ok'){
					jQuery('#successDiv').html(data.message);
		        	jQuery('#successDiv').css('display', 'block');
		        	jQuery("html, body").animate({ scrollTop: 0 }, 600);
					jQuery('#myModal').modal('hide');
					jQuery('.modal-backdrop').removeClass('in');
					setTimeout(function() {
							location.reload();
					}, 2000);
				}else{
					jQuery('#messageErrorModal').html("Ocurrió un error guardando el cuadrante");
					jQuery('#errorModal').css('display', 'block');
					return;
				}
			} catch (err) {
				jQuery('#messageErrorModal').html("Ocurrió un error guardando el cuadrante");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
}

function confirmationCuadra(id){
	if (confirm('Seguro que desea eliminar el cuadrante?')) {
		deleteCuadra(id);
	}
}

function updateCuadrantes(id,code,nom,encar,semest){
	jQuery('#idCuadra').val(id);
	jQuery('#num').val(code);
	jQuery('#nomCuadra').val(nom);
	jQuery('#desCuadra').val(encar);
	jQuery('#asigAso').val(semest)
}

function deleteCuadra(id) {
	jQuery('#errorDiv').css('display', 'none');
	var idCuadra = id;
	
	if(idCuadra == "" || idCuadra == "" || idCuadra == undefined){
		jQuery('#messageErrorModal').html("No se encontró el cuadrante");
		jQuery('#errorModal').css('display', 'block');
	    return;
	}
	jQuery.ajax({
		url : urlFull + '/pages/quadrant/deleteQuadrant.html',
		data: {idCuadra:idCuadra},
		success: function(o) {
			if(o=="") {
				return;
			}
			var data;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
				}else if(data.status != undefined && data.status == 'ok'){
					jQuery('#successDiv').html(data.message);
		        	jQuery('#successDiv').css('display', 'block');
		        	jQuery("html, body").animate({ scrollTop: 0 }, 600);
		        	setTimeout(function(){ location.reload(); }, 1000);
				}else{
					jQuery('#messageErrorModal').html("Ocurri&oacute; un error eliminando el cuadrante");
					jQuery('#errorModal').css('display', 'block');
				}
			} catch (err) {
				jQuery('#messageErrorModal').html("Ocurrió un error eliminando el cuadrante");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
}
