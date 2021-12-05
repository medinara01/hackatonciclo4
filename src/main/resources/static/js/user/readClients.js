function readUser(llaveId) {
    console.log("llaveId")
    let datos = {
        id: llaveId
    }
    
    $.ajax({
        url: "http://193.122.165.100:8080/api/user/" + llaveId,
        type: "GET",
        contentType: "application/JSON",
        dataType: 'json',
        xhrFields: {
            withCredentials: false
        },

        success: function (respuesta) {
            alert("entro al success")
            console.log("respuesta:", respuesta)

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
    console.log("estamos aca")
    $("#DataClients").html("");
    const tableBody = document.getElementById("DataClients");
    let dataHtml = "";

    for (var i=0; i < items.length; i++) {
        dataHtml += `
        <h1>Documento: <span> ${items.identification}</span></h1>
        <h1>Tipo de Documento:<span> ${items.idtype}</span></h1>
        <h1>Nombre:<span> ${items.name}</span></h1>
        <h1>Correo Electrónico:<span> ${items.email}</span></h1>
        <h1>Telefono Celular:<span> ${items.cellPhone}</span></h1>
        <h1>Pais: <span> ${items.country}</span></h1>
        <h1>Ciudad:<span> ${items.city}</span></h1>
        <h1>Localidad:<span> ${items.location}</span></h1>
        <h1>Barrio:<span> ${items.neighborhood}</span></h1>
        <h1>Dirección:<span> ${items.address}</span></h1>
        <h1>twitter:<span> ${items.twitter}</span></h1>
        <h1>facebook:<span> ${items.facebook}</span></h1>
        <h1>instagram:<span> ${items.instagram}</span></h1>
        <h1>google:<span> ${items.google}</span></h1>
        <h1>Calificación de tus bicis:<span> ${items.calificationOwner}</span></h1>
        <h1>Tu calificación:<span> ${items.calificationUser}</span></h1>
        <h1>Tus Tokens:<span> ${items.tokens}</span></h1>
               `;
    }
    $("#DataClients").html(dataHtml);
}