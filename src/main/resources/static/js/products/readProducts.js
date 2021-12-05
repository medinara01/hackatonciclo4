$(document).ready(function () {
    estadoInicial();
    listar();
});

function listar() {
    $.ajax({
        url: "http://localhost:8080/api/supplements/all",
        //url: "http://150.230.40.244:8080/api/supplements/all",
        type: "GET",
        contentType: "application/JSON",
        dataType: 'json',
        xhrFields: {
            withCredentials: false
        },

        success: function (respuesta) {
            loadProducts(respuesta);
        },

        error: function (xhr, status) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
        },

        complete: function (xhr, status) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Obteniendo listado de Productos...");
            $("#mensajes").hide(1500);
        }
    });
}

function loadProducts(items){
    $("#tableDataProducts").html("");
    const tableBody = document.getElementById("tableDataProducts");
    let dataHtml = "";

    for (var i=0; i < items.length; i++) {
        dataHtml += `<tr>
                <td>${items[i].id}</td>
                <td>${items[i].name}</td>
                <td>${items[i].address}</td>
                <td>${items[i].extension}</td>
                <td>${items[i].description}</td>
                <td><button class="btn btn-success btn-sm" onclick="editarRegistro(${items[i].id})">Editar</button></td>
                <td><button class="btn btn-danger btn-sm" onclick="borrarRegistro(${items[i].id}) id="liveToastBtn">Borrar</button></td>
            </tr>`;
    }
    $("#tableDataProducts").html(dataHtml);
}

function estadoInicial(){
    $("#nuevo").hide();
    $("#editar").hide();
    $("#listado").show(500);
    $("#nuevoRegistro").show(500)

    $("#id").val("")
    $("#name").val("")
    $("#address").val("")
    $("#extension").val("")
}
