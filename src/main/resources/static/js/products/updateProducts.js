function editarRegistro(llaveId) {
    let datos = {
        id: llaveId
    }

    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        url: "http://localhost:8080/api/supplements/" + llaveId,
        //url: "http://150.230.40.244:8080/api/supplements/" + llaveId,
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
    $("#idEdit").val(items.id);
    $("#nameEdit").val(items.name);
    $("#addressEdit").val(items.address);
    $("#extensionEdit").val(items.extension);
    $("#descriptionEdit").val(items.description);
}

function actualizar() {
    let datos = {
        id: $("#idEdit").val(),
        name: $("#nameEdit").val(),
        address: $("#addressEdit").val(),
        exension: $("#extensionEdit").val(),
        description: $("#descriptionEdit").val(),
    }

    let datosPeticion = JSON.stringify(datos);

    if (validarEditar()) {
        $.ajax({
            url: "http://localhost:8080/api/supplements/update",
            //url: "http://150.230.40.244:8080/api/supplements/update",
            data: datosPeticion,
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
