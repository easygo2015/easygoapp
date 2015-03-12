$(document).ready(function () {
    var animationFadeInDown = 'animated fadeInDown';
    var animationFadeOutUp = 'animated fadeOutUp';
    var animationFadeIn = 'animated fadeIn';
    var animationFadeOut = 'animated fadeOut';
    var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
    $('#deleteProfile').on('click', function (event) {
        $('#deleteContent').toggleClass('displayNone', false);
        $('#deleteContent').addClass(animationFadeInDown).one(animationEnd, function () {
            $(this).removeClass(animationFadeInDown);
        });
        event.preventDefault();
    });
    $('#continue').on('click', function (event) {
        $('#deleteContent').addClass(animationFadeOutUp).one(animationEnd, function () {
            $(this).removeClass(animationFadeOutUp);
            $('#deleteContent').toggleClass('displayNone', true);
        });
        event.preventDefault();
    });
    $('#changePassword').on('click', function (event) {
        $('#changeContent').toggleClass('displayNone', false);
        $('#changeContent').addClass(animationFadeInDown).one(animationEnd, function () {
            $(this).removeClass(animationFadeInDown);
        });
        contentTriger = false;
        event.preventDefault();
    });
    $('#cancel').on('click', function (event) {
        $('#changeContent').addClass(animationFadeOutUp).one(animationEnd, function () {
            $(this).removeClass(animationFadeOutUp);
            $('#changeContent').toggleClass('displayNone', true);
        });
        event.preventDefault();
    });
    var message = $('#message');
    if(!message.hasClass("displayNone")){
        message.addClass(animationFadeInDown).one(animationEnd, function(){
            $(this).removeClass(animationFadeIn);
            $(this).addClass(animationFadeOut).one(animationEnd, function(){
                $(this).removeClass(animationFadeOut);
            });
            $(this).addClass("displayNone");
        });
    }

});
