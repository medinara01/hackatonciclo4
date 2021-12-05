function registrar() {
    let datos={
        brand: $("#brand").val(),
        type: $("#type").val(),
        rin: $("#rin").val(),
        serial: $("#serial").val(),
        description: $("#description").val()
        
    }

    let datosPeticion = JSON.stringify(datos);

    if (validar()){
        $.ajax({
            url: "http://193.122.165.100:8080/api/Client/save",
            type: 'POST',
            contentType:"application/json",
            dataType: 'JSON',
            data : datosPeticion,
            xhrFields: {
                withCredentials: false
            },

            success: function (respuesta) {
                $("#mensajes").show(1000);
                $("#mensajes").html("Registro ingresado...");
                $("#mensajes").hide(1000);
                listar();
                estadoInicial();
            },

            error: function (xhr, status) {
                $("#mensajes").show(1000);
                $("#mensajes").html("Error peticion POST..." + status );
            }
        });
    }
}

function activaNuevo(){
    $("#nuevo").show(500);
    $("#id").focus();
    $("#editar").hide();
    $("#nuevoRegistro").hide(500)
    $("#listado").hide(500);
}