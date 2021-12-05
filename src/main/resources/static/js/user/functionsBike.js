function validaesVacio(dato){
    return !dato.trim().length;
}

function validar(){
    let brand = $("#brand").val();
    let serialNumber = $("#serialNumber").val();
    let errores="";
    $("#mensajes").html("");

    if( validaesVacio(brand)) {
        errores="brand vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#brand").focus();
        return false;
    }else if( validaesVacio(serialNumber)) {  
        errores="serialNumber vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#mensajes").hide(1500);
        $("#serialNumber").focus();
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
