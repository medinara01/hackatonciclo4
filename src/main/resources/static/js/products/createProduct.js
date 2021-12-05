function registrar() {
    let datos={
        id: $("#id").val(),
        name: $("#name").val(),
        address: $("#address").val(),
        extension: $("#extension").val(),
        description: $("#description").val()
    }

    let datosPeticion = JSON.stringify(datos);

    if (validar()){
        $.ajax({
            url: "http://localhost:8080/api/supplements/save",
            //url: "http://150.230.40.244:8080/api/supplements/save",
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
    $("#name").focus();
    $("#editar").hide();
    $("#nuevoRegistro").hide(500)
    $("#listado").hide(500);
}
