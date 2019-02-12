var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';

var numeroRubrica = 0;
var opened = false;
var rubricaFila = "<tr>" +
		"<td>" +
		"<textarea id='rubrica_descripcion_{numeroRubrica}' name='rubrica_descripcion_{numeroRubrica}' class='form-control'></textarea>" +
		"</td>" +
		"<td>" +
		"<select id='id_tipo_rubrica_{numeroRubrica}' name='id_tipo_rubrica_{numeroRubrica}' class='form-control'>" +
		"<option value='-1'>Seleccione el tipo</option>" +
		"<option value='1'>Criterios Tématicos</option>" +
		"<option value='2'>Criterios Axiológicos</option>" +
		"</select>" +
		"</td>" +
		"<td>" +
		"<textarea id='item_{numeroRubrica}_0' name='item_{numeroRubrica}_0' class='form-control'></textarea>" +
		"</td>" +
		"<td>" +
		"<textarea id='item_{numeroRubrica}_1' name='item_{numeroRubrica}_1' class='form-control'></textarea>" +
		"</td>" +
		"<td>" +
		"<textarea id='item_{numeroRubrica}_2' name='item_{numeroRubrica}_2' class='form-control'></textarea>" +
		"</td>" +
		"<td>" +
		"<textarea id='item_{numeroRubrica}_3' name='item_{numeroRubrica}_3' class='form-control'></textarea>" +
		"</td>" +
		"</tr>";

function guardarRubricaForm(){
	if(!opened){
		opened = true;
		numeroRubrica = 1;
		
		var rubricaFila1 = rubricaFila.replace(/\{numeroRubrica\}/g, numeroRubrica);
		var rubricas = "<tbody>" +
					rubricaFila1
				"</tbody>";
		
		$("#rubricas").html(
				"<table class='table' id='table_rubricas'>" + "<thead><tr>"
						+ "<td>Rúbrica</td>"
						+ "<td>Tipo Rúbrica</td>"
						+ "<td>Deficiente(0)</td>"
						+ "<td>Insuficiente(1)</td>"
						+ "<td>Aceptable(2)</td>"
						+ "<td>Bueno(3)</td>" + "</tr></thead>"
						+ rubricas + "</table><input type='button' onclick='agregarRubrica()' value='Agregar Rúbrica' class='btn btn-primary'>");
		$("#guardar-btn").show();
	}
}
function agregarRubrica(){
	if(numeroRubrica + 1> 10){
		alert("Máximo pueden ser agregadas 10 rúbricas");
	}else{
		var rubricaFila1 = rubricaFila.replace(/\{numeroRubrica\}/g, ++numeroRubrica);
		$("#table_rubricas").append(rubricaFila1);
	}
}

function save() {
	jQuery('#errorDiv').css('display', 'none');
	if(jQuery("#id_asignatura").val() == "-1"){
		jQuery('#messageErrorModal').html(
		"Debe seleccionar la asignatura");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	if($("#id_asignatura").val() == "-1"){
		jQuery('#messageErrorModal').html("Por favor seleccionar una asignatura");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : urlFull + '/pages/rubric/saveRubric.html',
		data : $("#rubricas_form").serialize(),
		success : function(o) {
			if (o == "") {
				return;
			}
			var data;
			opened = false;
			try {
				data = jQuery.parseJSON(o);
				if (data.status != undefined && data.status == 'errors') {
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
				} else if (data.status != undefined && data.status == 'ok') {
					jQuery('#successDiv').html(data.message);
					jQuery('#successDiv').css('display', 'block');
					jQuery('#successDivForm').css('display', 'block');
					jQuery("html, body").animate({ scrollTop: 0 }, 600);
					jQuery('#myModalEditar').modal('hide');
					jQuery('.modal-backdrop').removeClass('in');
					setTimeout(function() {
							location.reload();
					}, 2000);
				} else {
					jQuery('#messageErrorModal').html(
							"Ocurrió un error guardando las rúbricas");
					jQuery('#errorModal').css('display', 'block');
					return;
				}
			} catch (err) {
				jQuery('#messageErrorModal').html(
						"Ocurrió un error guardando las rúbricas");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
}
function viewRubricForm(idAsignatura, version, nombreAsignatura) {
	// buscar la asignatura
	$("#id_asignatura").val(idAsignatura);
	$("#guardar-btn").hide();
	$("#nombre_asignatura").html(nombreAsignatura);
	$("#version").html(version);
	
	jQuery.ajax({
		url : urlFull + '/pages/qualify/getInfoAdicional.html',
		data : {
			id_asignatura : idAsignatura,
			version : version
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
					$("#rubricas").html(
							"<table class='table'>" + "<thead><tr>"
									+ "<td>Rúbrica</td>"
									+ "<td>Deficiente(0)</td>"
									+ "<td>Insuficiente(1)</td>"
									+ "<td>Aceptable(2)</td>"
									+ "<td>Bueno(3)</td>" + "</tr></thead>"
									+ data.info + "</table>");
				} else {
					jQuery('#messageErrorModal').html(
							"Ocurrió un error guardando la calificación");
					jQuery('#errorModal').css('display', 'block');
				}
			} catch (err) {
				jQuery('#messageErrorModal').html(
						"Ocurrió un error guardando la calificación");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
}
function updateRubricForm(idAsignatura, version, nombreAsignatura) {
	
	// buscar la asignatura
	$("#id_asignatura").val(idAsignatura);
	$("#guardar-btn").show();
	$("#nombre_asignatura").html(nombreAsignatura);
	$("#version").html(version);
	
	jQuery.ajax({
		url : urlFull + '/pages/qualify/getInfoAdicionalEditable.html',
		data : {
			id_asignatura : idAsignatura,
			version : version
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
					$("#rubricas").html(
							"<table class='table'>" + "<thead><tr>"
									+ "<td>Rúbrica</td>"
									+ "<td>Tipo Rúbrica</td>"
									+ "<td>Deficiente(0)</td>"
									+ "<td>Insuficiente(1)</td>"
									+ "<td>Aceptable(2)</td>"
									+ "<td>Bueno(3)</td>" + "</tr></thead>"
									+ data.info + "</table>");
				} else {
					jQuery('#messageErrorModal').html(
							"Ocurrió un error guardando la calificación");
					jQuery('#errorModal').css('display', 'block');
				}
			} catch (err) {
				jQuery('#messageErrorModal').html(
						"Ocurrió un error guardando la calificación");
				jQuery('#errorModal').css('display', 'block');
				return;
			}
		}
	});
	
}