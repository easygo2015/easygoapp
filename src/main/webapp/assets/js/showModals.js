$(document).ready(function () {
    $('#deleteLink').bind('click', function (e) {
        $('#deleteMessage').addClass('slideDown');
        e.preventDefault();
    });
    $('#continue').bind('click', function (e) {
        $('#deleteMessage').addClass('slideUp');
        e.preventDefault();
    });
    $('#changePasswordLink').bind('click', function (e) {
        $('#changePassword').show('slow');
        e.preventDefault();
    } );
    $('#cancel').bind('click', function(){
        $('#changePassword').hide('slow');
    })
});