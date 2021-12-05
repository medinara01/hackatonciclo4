function editarRegistro(llaveId) {
    let datos = {
        id: llaveId
    }
    
    console.log(llaveId)
    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        url: "http://localhost:8080/api/Client/" + llaveId,
        //url: "http://150.230.40.244:8080/api/Client/" + llaveId,
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
    $("#idEdit").val(items.idClient);
    $("#nameEdit").val(items.name);
    $("#emailEdit").val(items.email);
    $("#ageEdit").val(items.age);
}

function actualizar() {
    let datos = {
        idClient: $("#idEdit").val(),
        name: $("#nameEdit").val(),
        email: $("#emailEdit").val(),
        age: $("#ageEdit").val(),
    }

    let datosPeticion = JSON.stringify(datos);

    if (validarEditar()) {
        $.ajax({
            url: "http://localhost:8080/api/Client/update",
            //url: "http://150.230.40.244:8080/api/Client/update",
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
