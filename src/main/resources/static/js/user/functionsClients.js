function validaesVacio(dato){
    return !dato.trim().length;
}

function validar(){
    let name = $("#name").val();
    let email = $("#email").val();
    let identification = $("#identification").val();
    let errores="";
    $("#mensajes").html("");

    if( validaesVacio(name)) {
        errores="name vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#name").focus();
        return false;
    }else if( validaesVacio(email)) {  
        errores="email vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#email").focus();
        return false;
    }else if( validaesVacio(identification)) {  
        errores="identification vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#identification").focus();
        return false;
    }else{
        $("#mensajes").html("");
        $("#mensajes").hide(500);
        return true;
    }
    return true;
}

function validarEditar(){
    let id = $("#idEdit").val();
    let name = $("#nameEdit").val();
    let email = $("#emailEdit").val();
    let age = $("#ageEdit").val();
    let errores="";
    $("#mensajes").html("");

    if( validaesVacio(id)) {
        errores="id vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#idEdit").focus();
        return false;
    }else if( validaesVacio(name)) {
        errores="name vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#nameEdit").focus();
        return false;
    }else if( validaesVacio(email)) {  
        errores="email vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#emailEdit").focus();
        return false;
    }else if( validaesVacio(age)) { 
        errores="age vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#ageEdit").focus();
        return false;
    }else{
        $("#mensajes").html("");
        $("#mensajes").hide(500);
        return true;
    }
    return true;
}
