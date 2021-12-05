function borrarRegistro(llaveId) {
    let datos={
        id: llaveId
    }

    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        url: "http://localhost:8080/api/Reservation/" + llaveId,
        //url: "http://150.230.40.244:8080/api/Reservation/" + llaveId,
        data : datosPeticion,
        type: 'DELETE',
        contentType:"application/JSON",
        dataType: 'json',

        success: function (respuesta) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Registro eliminado...");
            $("#mensajes").hide(1000);
            listar();
        },

        error: function (xhr, status) {
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
        }
    });
}
