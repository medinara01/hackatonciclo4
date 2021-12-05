function editarRegistro(llaveId) {
    let datos = {
        id: llaveId
    }
    console.log(datos)
    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        url: "http://localhost:8080/api/Reservation/" + llaveId,
        //url: "http://150.230.40.244:8080/api/Reservation/" + llaveId,
        type: 'GET',
        contentType:"application/JSON",
        dataType: 'json',

        success: function (respuesta) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Información recuperada...");
            $("#mensajes").hide(1000);
            editarRespuesta(respuesta);
            activaEditar();
        },

        error: function (xhr, status) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Error peticion PUT..." + status);
        }
    });
}

function editarRespuesta(items) {
    $("#idReservationEdit").val(items.idReservation);
    $("#clientEdit").val(items.client.idClient);
    $("#farmEdit").val(items.farm.id);
    $("#startDateEdit").val(items.startDate);
    $("#devolutionDateEdit").val(items.devolutionDate);
    $("#statusEdit").val(items.status);
    $("#scoreEdit").val(items.score);
}

function actualizar() {
    let datosEdit = {
        idReservation: $("#idReservationEdit").val(),
        client: {"idClient":$("#clientEdit").val()},
        farm: {"id":$("#farmEdit").val()},
        startDate :$("#startDateEdit").val(),
        devolutionDate :$("#devolutionDateEdit").val(),
        status :$("#statusEdit").val(),
        score :$("#scoreEdit").val()
    }

    let datosPeticionEdit = JSON.stringify(datosEdit);
    console.log(datosEdit.score)

    if (validarEditar()) {
        $.ajax({
            url: "http://localhost:8080/api/Reservation/update",
            //url: "http://150.230.40.244:8080/api/Reservation/update",
            data: datosPeticionEdit,
            type: 'PUT',
            contentType: "application/JSON",

            success: function (respuesta) {
                $("#mensajes").show(1000);
                $("#mensajes").html("Registro actualizado...");
                $("#mensajes").hide(1000);
                listar();
                estadoInicial();
            },

            error: function (xhr, status) {
                $("#mensajes").show(1000);
                $("#mensajes").html("Error peticion Post..." + status);
            }
        });
    }
}

function activaEditar() {
    $("#idEdit").hide();
    $("#editar").show(500);
    $("#idEdit").focus();
    $("#nuevo").hide();
    $("#nuevoRegistro").hide(500)
    $("#listado").hide(500);
}