$(document).ready(function () {
    estadoInicial();
    listar();
});

function listar() {
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        //url: "http://150.230.40.244:8080/api/Category/all",
        type: "GET",
        contentType: "application/JSON",
        dataType: 'json',
        xhrFields: {
            withCredentials: false
        },

        success: function (respuesta) {
            console.log(respuesta)
            loadCategories(respuesta);
        },

        error: function (xhr, status) {
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
        },

        complete: function (xhr, status) {
            $("#mensajes").html("Obteniendo listado de fincas...");
            $("#mensajes").hide(1000);
        }
    });
}

function loadCategories(items){
    $("#tableDataCategories").html("");
    const tableBody = document.getElementById("tableDataCategories");
    let dataHtml = "";

    for (var i=0; i < items.length; i++) {
        dataHtml += `<tr>
                <td>${items[i].id}</td>
                <td>${items[i].name}</td>
                <td>${items[i].description}</td>
                <td><button class="btn btn-success btn-sm" onclick="editarRegistro(${items[i].id})">Editar</button></td>
                <td><button class="btn btn-danger btn-sm" onclick="borrarRegistro(${items[i].id})">Borrar</button></td>
            </tr>`;
    }
    $("#tableDataCategories").html(dataHtml);
}

function estadoInicial(){
    $("#nuevo").hide();
    $("#editar").hide();
    $("#listado").show(500);
    $("#nuevoRegistro").show(500)
    $("#id").val("")
    $("#name").val("")
    $("#description").val("")
}

