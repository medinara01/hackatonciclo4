$(document).ready(function () {
    estadoInicial();
    listar();
});

function listar() {
    $.ajax({
        url: "http://localhost:8080/api/Reservation/all",
        //url: "http://150.230.40.244:8080/api/Reservation/all",
        type: "GET",
        contentType: "application/JSON",
        dataType: 'json',

        success: function (respuesta) {
            console.log(respuesta)
            loadReservas(respuesta);
        },

        error: function (status) {
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
        },

        complete: function (status) {
            $("#mensajes").html("Obteniendo listado de reservas...");
            $("#mensajes").hide(1000);
        }
    });
}

function loadReservas(items){
    $("#tableDataReservas").html("");
    const tableBody = document.getElementById("tableDataReservas");
    let dataHtml = "";

    for (var i=0; i < items.length; i++) {
        dataHtml += `<tr>
                <td>${items[i].idReservation}</td>
                <td>${items[i].client.name}</td>
                <td>${items[i].farm.name}</td>
                <td>${items[i].startDate}</td>
                <td>${items[i].devolutionDate}</td>
                <td>${items[i].status}</td>
                <td>${items[i].score}</td>
                <td><button class="btn btn-success btn-sm" onclick="editarRegistro(${items[i].idReservation})">Editar</button></td>
                <td><button class="btn btn-danger btn-sm" onclick="borrarRegistro(${items[i].idReservation})">Borrar</button></td>
            </tr>`;
    }
    $("#tableDataReservas").html(dataHtml);
}

function estadoInicial(){
    $("#nuevo").hide();
    $("#editar").hide();
    $("#listado").show(500);
    $("#nuevoRegistro").show(500)

    $("#id").val("")
    $("#startDate").val("")
    $("#devolutionDate").val("")
    $("#status").val("")
    $("#score").val("")
}
