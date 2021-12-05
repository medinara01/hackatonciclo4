function registrar() {
    let datos={
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val(),
        cellPhone: $("#cellPhone").val(),
        idtype: $("#idtype").val(),
        identification: $("#identification").val(),
        city: $("#city").val(),
        location: $("#location").val(),
        neighborhood: $("#neighborhood").val(),
        address: $("#address").val(),
        facebook: $("#facebook").val(),
        twitter: $("#twitter").val(),
        google: $("#google").val(),
        instagram: $("#instagram").val()
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