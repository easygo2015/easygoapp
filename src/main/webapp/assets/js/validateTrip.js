"use strict";

function checkTrip() {
    var flag = true;
    var leftBank = $('#checkLeftBank :checkbox:checked').length > 0;
    if (!leftBank) {
        flag = false;
        $("#errorLeftBank").html("Выберите как минимум одну точку маршрута");
    } else {
        $("#errorLeftBank").html("");
    }

    var rightBank = $('#checkRightBank :checkbox:checked').length > 0;
    if (!rightBank) {
        flag = false;
        $("#errorRightBank").html("Выберите как минимум одну точку маршрута");
    } else {
        $("#errorRightBank").html("");
    }
    return flag;
}

function saveInCurrentTrip() {
    alert($("count").value = "check");
}