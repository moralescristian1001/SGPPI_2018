var puerto = '8080';

function changePassword() {
	jQuery('#errorDiv').css('display', 'none');
	var cambioClave = jQuery('#cambioClave').val() == 'true' ? 1 : 0;
	var claveAnterior = jQuery('#clave_anterior').val();
	var claveNueva = jQuery('#clave_nueva').val();
	var claveNuevaRepetir = jQuery('#clave_nueva_repetir').val();
	
	if (claveAnterior == "") {
		jQuery('#errorDiv').html("Debe ingresar la contraseña anterior");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (claveNueva == "") {
		jQuery('#errorDiv').html("Debe ingresar la contraseña nueva");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (claveNuevaRepetir == "") {
		jQuery('#errorDiv').html("Ingrese nuevamente la contraseña");
		jQuery('#errorDiv').css('display', 'block');
		jQuery('#clave_nueva_repetir').focus();
		return;
	}
	if(claveNueva != claveNuevaRepetir){
		jQuery('#errorDiv').html("La claves nuevas ingresadas no concuerdan");
		jQuery('#errorDiv').css('display', 'block');
		jQuery('#clave_nueva_repetir').focus();
		return;
	}
	if(claveAnterior == claveNueva){
		jQuery('#errorDiv').html("La clave anterior y la clave nueva no pueden ser la misma");
		jQuery('#errorDiv').css('display', 'block');
		jQuery('#clave_nueva').focus();
		return;
	}
	var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';
	
	jQuery.ajax({
		url : urlFull + '/pages/changePassword/savePassword.html',
		data : {
			clave_nueva: claveNueva,
			clave_anterior: claveAnterior
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
					jQuery('#successDiv').css('display', 'none');
				} else if (data.status != undefined && data.status == 'ok') {
					jQuery('#successDiv').html(data.message);
					jQuery('#successDiv').css('display', 'block');
					jQuery('#errorDiv').css('display', 'none');
					if(!cambioClave){
						setTimeout(function(){ location.href = urlFull + "/pages/home.html"}, 3000);
					}
				}
			} catch (err) {
				jQuery('errorDiv').html(
						"Ocurrió un error validando los datos");
				jQuery('errorDiv').css('display', 'block');
				jQuery('#successDiv').css('display', 'none');
				return;
			}
		}
	});
}