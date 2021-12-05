function generateReportStatus(){
    console.log("test")
    $.ajax({
        url: "http://localhost:8080/api/Reservation/report-status",
        //url: "http://150.230.40.244:8080/api/Reservation/report-status",
        type: 'GET',
        contentType:"application/json",
        dataType: 'JSON',

        xhrFields: {
            withCredentials: false
        },

        success: function (respuesta) {
            console.log(respuesta);
            listar(respuesta);
        },

        error: function (xhr, status) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Error peticion POST..." + status );
        }
    });
}

function listar(items){
    $("#resultadoStatus").html("");
    const tableBody = document.getElementById("resultadoStatus");
    let dataHtml = "";

    dataHtml += `<tr>
            <td>${items.completed}</td>
            <td>${items.cancelled}</td>
        </tr>`;

    $("#resultadoStatus").html(dataHtml);
}

function traerReporteDate(){
    var fechaInicio = document.getElementById("reservStartDate").value;
    var fechaCierre = document.getElementById("reservReturnDate").value;
    console.log(fechaInicio);
    console.log(fechaCierre);
    
    $.ajax({
        url:"http://168.138.247.22:80/api/Reservation/report-dates/"+fechaInicio+"/"+fechaCierre,
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            listarDate(respuesta);
        }
    });
}

function listarDate(items){
    $("#resultadoDate").html("");
    const tableBody = document.getElementById("resultadoDate");
    let dataHtml = "";

    for (var i=0; i < items.length; i++) {
        dataHtml += `<tr>
            <td>${items[i].devolutionDate}</td>
            <td>${items[i].startDate}</td>
            <td>${items[i].status}</td>
        </tr>`;
    }

    $("#resultadoDate").html(dataHtml);
}

function traerReporteClientes(){
    $.ajax({
        url:"http://168.138.247.22:80/api/Reservation/report-clients",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            listarClientes(respuesta);
        }
    });
}

function listarClientes(items){
    $("#resultadoClient").html("");
    const tableBody = document.getElementById("resultadoClient");
    let dataHtml = "";

    for (var i=0; i < items.length; i++) {
        dataHtml += `<tr>
            <td>${items[i].total}</td>
            <td>${items[i].client.name}</td>
            <td>${items[i].client.email}</td>
            <td>${items[i].client.age}</td>
        </tr>`;
    }

    $("#resultadoClient").html(dataHtml);
}
