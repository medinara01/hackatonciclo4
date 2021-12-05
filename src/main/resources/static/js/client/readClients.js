$(document).ready(function () {
    estadoInicial();
    listar();
});

function listar() {
    $.ajax({
        url: "http://localhost:8080/api/Client/all",
        //url: "http://150.230.40.244:8080/api/Client/all",
        type: "GET",
        contentType: "application/JSON",
        dataType: 'json',
        xhrFields: {
            withCredentials: false
        },

        success: function (respuesta) {
            loadClients(respuesta);
        },

        error: function (xhr, status) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
        },

        complete: function (xhr, status) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Obteniendo listado de Clientes...");
            $("#mensajes").hide(1000);
        }
    });
}

function loadClients(items){
    $("#tableDataClients").html("");
    const tableBody = document.getElementById("tableDataClients");
    let dataHtml = "";

    for (var i=0; i < items.length; i++) {
        dataHtml += `<tr>
                <td>${items[i].idClient}</td>
                <td>${items[i].name}</td>
                <td>${items[i].email}</td>
                <td>${items[i].age}</td>
                <td><button class="btn btn-success btn-sm" onclick="editarRegistro(${items[i].idClient})">Editar</button></td>
                <td><button class="btn btn-danger btn-sm" onclick="borrarRegistro(${items[i].idClient})">Borrar</button></td>
            </tr>`;
    }
    $("#tableDataClients").html(dataHtml);
}

function estadoInicial(){
    $("#nuevo").hide();
    $("#editar").hide();
    $("#listado").show(500);
    $("#nuevoRegistro").show(500)

    $("#id").val("")
    $("#name").val("")
    $("#email").val("")
    $("#age").val("")
}
