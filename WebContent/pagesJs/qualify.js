var urlFull = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port : '') + '/SGPPI_2018';
totalRubricas = 0;
totalRubricasSeleccionadas = 0;
function saveQualify() {
	jQuery('#errorDiv').css('display', 'none');
	var id_equipo = jQuery('#id_equipo').val();
	var rubricas = jQuery('.items_rubrica.item-activo');
	var observaciones = jQuery('#observaciones').val();
	var idSocializacion = jQuery('#id_socializacion').val();
	var items = "";
	var itemsArray = [];
	
	if(totalRubricas > totalRubricasSeleccionadas){
		jQuery('#messageErrorModal').html("No ha seleccionado las notas de las rúbricas");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	
	rubricas.each(function() {
		var partesId = $(this).attr("id").split("_");
		itemsArray.push(partesId[2] + "_" + partesId[3]);
	});
	
	items = itemsArray.join(",");
	
	if (rubricas == "") {
		jQuery('#messageErrorModal').html("No ha seleccionado las notas de las rúbricas");
		jQuery('#errorModal').css('display', 'block');
		return;
	}
	jQuery.ajax({
		url : urlFull + '/pages/qualify/saveQualify.html',
		data : {
			id_equipo : id_equipo,
			rubricas : items,
			observaciones : observaciones,
			id_socializacion : idSocializacion
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

function abrirEquipo(idEquipo, codigo, nombre, asignatura, idAsignatura, nota) {
	totalRubricas = 0;
	totalRubricasSeleccionadas = 0;
	jQuery('#id_equipo').val(idEquipo);
	jQuery('#codigo').html(codigo);
	jQuery('#nombre').html(nombre);
	jQuery('#asignatura').html(asignatura);
	if(nota != ""){
		jQuery("#guardar_calificacion").prop("disabled", true);
	}

	// buscar la asignatura

	jQuery.ajax({
		url : urlFull + '/pages/qualify/getInfoAdicional.html',
		data : {
			id_asignatura : idAsignatura,
			id_socializacion : $("#id_socializacion").val(),
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
					jQuery('#messageErrorModal').html(data.message);
					jQuery('#errorModal').css('display', 'block');
				} else if (data.status != undefined && data.status == 'ok') {
					$("#rubricas").html(
							"<table class='table'>" + "<thead><tr>"
									+ "<td>Rúbrica</td>"
									+ "<td>Estudiantes</td>"
									+ "<td>Deficiente(0)</td>"
									+ "<td>Insuficiente(1)</td>"
									+ "<td>Aceptable(2)</td>"
									+ "<td>Bueno(3)</td>" + "</tr></thead>"
									+ data.info + "</table>");
					totalRubricas = data.totalRubricas;
					actualizarRubricas();
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
	jQuery('#rubricas').append();
}
function actualizarRubricas() {
	$(".items_rubrica").click(
			function() {
				if ($(this).hasClass("item-seleccionable")) {
					if($(this).hasClass("item-activo")){
						totalRubricasSeleccionadas--;
					}else{
						totalRubricasSeleccionadas++;
					}
					$(this).toggleClass("item-activo");
					
					
					const idRubrica = $(this).attr("id").split("_")[1];
					const usuarioNota = $(this).attr("id").split("_")[2];
					console.log(idRubrica + " " + usuarioNota);
					$("td[id*='item_" + idRubrica + "_" + usuarioNota + "']").not(
							"#" + $(this).attr("id")).toggleClass(
							"item-seleccionable");
				}

			});

}
