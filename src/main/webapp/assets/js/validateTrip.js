//$(document).ready(function(){
//
//
//    //alert("Валидатор в действии");
//    var flag;
//    $('#saveTrip').click(function () {
//        //alert("Нажата Саве");
//        flag = true;
//        var leftBank = $('#leftCoast :checkbox:checked').length > 0;
//        if (!leftBank) {
//            flag = false;
//            $("#errorLeftBank").html("Левый  Выберите как минимум одну точку маршрута");
//        } else {
//            $("#errorLeftBank").html("");
//        }
//
//        var rightBank = $('#rightCoast :checkbox:checked').length > 0;
//        if (!rightBank > 0) {
//            flag = false;
//            $("#errorRightBank").html("Правый Выберите как минимум одну точку маршрута");
//        } else {
//            $("#errorRightBank").html("");
//        }
//        sendIt(flag);
//    });
//    function sendIt(flaggg) {
//        if (flaggg) {
//            $('#form').submit();
//        }else{
//            alert("выбери точки");
//        }
//    }
//});

function checkTrip() {
    var flag = true;
    var leftBank = $('#leftCoast :checkbox:checked').length > 0;
    if (!leftBank) {
        flag = false;
        $("#errorLeftBank").html("ЛЕВЫЙ Выберите как минимум одну точку маршрута");
    } else {
        $("#errorLeftBank").html("");
    }

    var rightBank = $('#rightCoast :checkbox:checked').length > 0;
    if (!rightBank) {
        flag = false;
        $("#errorRightBank").html("ПРАВЫЙ Выберите как минимум одну точку маршрута");
    } else {
        $("#errorRightBank").html("");
    }
    return flag;
}

