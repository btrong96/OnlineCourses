var FormModalIsValid = true;
function ValidateRequireControl(el, errorMes) {
    $(el).removeClass('is-invalid')
    $(el).nextAll(".spanError").remove()
    if ($(el).val() == null || $(el).val() == undefined) {
        $(el).addClass('is-invalid')
        $(el).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
        FormModalIsValid = false
    }
    else {
        let valuectl = $(el).val().trim()
        if (valuectl == null || valuectl == '') {
            $(el).addClass('is-invalid')
            $(el).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
            FormModalIsValid = false
        }
    }
}

function CreateValidate(el, errorMes) {
    $(el).removeClass('is-invalid')
    $(el).nextAll(".spanError").remove()

    $(el).addClass('is-invalid')
    $(el).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
    FormModalIsValid = false

}

function ClearError(el) {
    $(el).removeClass('is-invalid')
    $(el).nextAll(".spanError").remove()
}

function ValidateRequireControlMaxLength(el, errorMes, length) {
    if (FormModalIsValid) {
        let valuectl = $(el).val().trim()
        if (valuectl != null && valuectl != '') {
            $(el).removeClass('is-invalid')
            $(el).nextAll(".spanError").remove()
            if (valuectl.length > length) {
                $(el).addClass('is-invalid')
                $(el).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
                FormModalIsValid = false
            }
        }
    }
}
function ValidateRequireControlMinLength(el, errorMes, length) {
    if (FormModalIsValid) {
        let valuectl = $(el).val().trim()
        if (valuectl != null && valuectl != '') {
            $(el).removeClass('is-invalid')
            $(el).nextAll(".spanError").remove()
            if (valuectl.length < length) {
                $(el).addClass('is-invalid')
                $(el).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
                FormModalIsValid = false
            }
        }
    }
}

function ValidateRequireControlPass(el1, el2, errorMes) {
    let valuectl1 = $(el1).val().trim()
    let valuectl2 = $(el2).val().trim()
    if (valuectl1 != null && valuectl1 != '' && valuectl2 != null && valuectl2 != '') {
        $(el2).removeClass('is-invalid')
        $(el2).nextAll(".spanError").remove()
        if (valuectl1 != valuectl2) {
            $(el2).addClass('is-invalid')
            $(el2).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
            FormModalIsValid = false
        }
    }
}

function ValidateRequireControlEmail(el, errorMes) {
    let valuectl = $(el).val().trim()
    $(el).removeClass('is-invalid')
    $(el).nextAll(".spanError").remove()
    if (FormModalIsValid) {
        if (ValidateEmail(valuectl) == false) {
            $(el).addClass('is-invalid')
            $(el).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
            FormModalIsValid = false
        }
    }
}


function ValidateNumber(el, errorMes) {
    let valuectl = $(el).val().trim()
    $(el).removeClass('is-invalid')
    $(el).nextAll(".spanError").remove()
    if (FormModalIsValid) {
        if (CheckIsNumber(valuectl) == false) {
            $(el).addClass('is-invalid')
            $(el).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
            FormModalIsValid = false
        }
    }
}


function ValidatePassword(el, errorMes) {
    let valuectl = $(el).val().trim()
    $(el).removeClass('is-invalid')
    $(el).nextAll(".spanError").remove()
    if (FormModalIsValid) {
        if (CheckPassword(valuectl) == false) {
            $(el).addClass('is-invalid')
            $(el).after(`<span class = "text-danger spanError"> ${errorMes}</span>`)
            FormModalIsValid = false
        }
    }
}
function ValidateEmail(mail) {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        return (true)
    }
    return (false)
}


// mật khẩu phải có 1 chữ hoa, 1 chữ thường , 1 số, 1 chữ cái đặc biệt, 8-15 kí tự
function CheckPassword(inputtxt) {
    let decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    if (inputtxt.match(decimal)) {
        return true
    }
    return false
}
function CheckIsNumber(num) {
    if (Number.isInteger(Number(num))) {
        return true
    }
    return false
}

function LoadAjaxContent(url, container) {
    $(container).html("<div><div class=\"loader\"></div></div>");
    $.ajax({
        url: encodeURI(url),
        cache: false,
        type: "GET",
        success: function (data) {
            $(container).html(data);
        }
    });
}

function PostAction(url, container) {
    $(container).html("<div><div class=\"loader\"></div></div>");
    $.ajax({
        url: encodeURI(url),
        cache: false,
        type: "GET",
        success: function (data) {
            $(container).html(data);
        }
    });
}