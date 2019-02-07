var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';
function login() {
	jQuery('#errorDiv').css('display', 'none');

	var email = jQuery('#email').val();
	var password = jQuery('#password').val();
	if (email == "" || password == "0") {
		jQuery('#errorDiv').html("Debe ingresar el correo y la contraseña");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	if (!validateEmailPoli(email)) {
		jQuery('#errorDiv').html("No es un correo válido del politécnico");
		jQuery('#errorDiv').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : urlFull + '/login.html',
		data : {
			email : email,
			password : password,
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
					location.href = "pages/home.html";
				}
			} catch (err) {
				jQuery('errorDiv').html(
						"Ocurrió un error validando los datos");
				jQuery('errorDiv').css('display', 'block');
				return;
			}
		}
	});
}

function validateEmailPoli(email) {
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@elpoli.edu.co$/;
	return re.test(String(email).toLowerCase());
}