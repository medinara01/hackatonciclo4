function validaesVacio(dato){
    return !dato.trim().length;
}

function validar(){
    let idReservation = $("#id").val();
    let startDate = $("#startDate").val();
    let devolutionDate = $("#devolutionDate").val();
    let status = $("#status").val();
    let score = $("#score").val();
    let client = $("#client").val();
    let farm = $("#farm").val();
    let errores="";
    $("#mensajes").html("");

    if( validaesVacio(idReservation)) {
        errores="id vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#id").focus();
        return false;
    }else if( validaesVacio(startDate)) {
        errores="startDate vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#startDate").focus();
        return false;
    }else if( validaesVacio(devolutionDate)) {
        errores="devolutionDate vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#devolutionDate").focus();
        return false;
    }else if( validaesVacio(status)) {
        errores="status vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#status").focus();
        return false;
    }else if( validaesVacio(score)) {
        errores="score vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#score").focus();
        return false;
    }else if( validaesVacio(client)) {
        errores="client vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#client").focus();
        return false;
    }else if( validaesVacio(farm)) {
        errores="farm vacio<br>";
        $("#mensajes").html(farm);
        $("#mensajes").show(500);
        $("#farm").focus();
        return false;
    }else{
        $("#mensajes").html("");
        $("#mensajes").hide(500);
        return true;
    }
    return true;
}

function validarEditar(){
    let idReservation = $("#idReservationEdit").val();
    let startDate = $("#startDateEdit").val();
    let devolutionDate = $("#devolutionDateEdit").val();
    // let client = $("idClient" = $("#clientEdit").val());
    // let farm = $("id" = $("#farmEdit").val());
    let errores="";
    $("#mensajes").html("");

    if( validaesVacio(idReservation)) {
        errores="idReservation vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#idReservationEdit").focus();
        return false;
    }else if( validaesVacio(startDate)) {
        errores="startDate vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#startDateEdit").focus();
        return false;
    }else if( validaesVacio(devolutionDate)) {
        errores="devolutionDate vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#devolutionDateEdit").focus();
        return false;
    // }else if( validaesVacio(client)) {
    //     errores="client vacio<br>";
    //     $("#mensajes").html(errores);
    //     $("#mensajes").show(500);
    //     $("#clientEdit").focus();
    //     return false;
    // }else if( validaesVacio(farm)) {
    //     errores="farm vacio<br>";
    //     $("#mensajes").html(farm);
    //     $("#mensajes").show(500);
    //     $("#farmEdit").focus();
    //     return false;
    }else{
        $("#mensajes").html("");
        $("#mensajes").hide(500);
        return true;
    }
    return true;
}
