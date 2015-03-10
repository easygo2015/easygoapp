$(document).ready(function () {
    $('#deleteLink').bind('click', function (e) {
        $('#deleteMessage').show('slow');
        e.preventDefault();
    });
    $('#continue').bind('click', function (e) {
        $('#deleteMessage').hide('slow');
        e.preventDefault();
    });
});