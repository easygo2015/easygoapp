$(document).ready(function () {
    var animationFadeInDown = 'animated fadeInDown';
    var animationFadeOutUp = 'animated fadeOutUp';
    var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
    $('#deleteProfile').on('click', function(event){
        $('#deleteContent').toggleClass('displayNone', false);
        $('#deleteContent').addClass(animationFadeInDown).one(animationEnd, function(){
            $(this).removeClass(animationFadeInDown);
        });
        event.preventDefault();
    });
    $('#continue').on('click', function(event) {
        $('#deleteContent').addClass(animationFadeOutUp).one(animationEnd, function() {
            $(this).removeClass(animationFadeOutUp);
            $('#deleteContent').toggleClass('displayNone', true);
        });
        event.preventDefault();
    });
    $('#continue').on('mouseover', function(event){
        $(this).addClass('animated bounce').one(animationEnd, function(){
           $(this).removeClass('animated bounce');
        });
    });
    $('#changePassword').on('click', function(event){
        $('#changeContent').toggleClass('displayNone', false);
        $('#changeContent').addClass(animationFadeInDown).one(animationEnd, function(){
            $(this).removeClass(animationFadeInDown);
        });
        event.preventDefault();
    });
    $('#cancel').on('click', function(event) {
        $('#changeContent').addClass(animationFadeOutUp).one(animationEnd, function() {
            $(this).removeClass(animationFadeOutUp);
            $('#changeContent').toggleClass('displayNone', true);
        });
        event.preventDefault();
    });

});