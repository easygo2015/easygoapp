$(document).ready(function(){
    var animationFadeIn = 'animated fadeIn';
    var animationFadeOut = 'animated fadeOut';
    var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
    $("input:radio").on("change", function(){
        var descr = $(this).val();
        $("#description").val(descr);
    });

    $('#pointForm').bind('submit', function(event) {
            if(!$('#description').val().length) {
                event.preventDefault();
                $("#confirmError").removeClass("displayNone").addClass(animationFadeIn).one(animationEnd, function(){
                    $(this).removeClass(animationFadeIn);
                    $(this).addClass(animationFadeOut).one(animationEnd, function(){
                        $(this).removeClass(animationFadeOut);
                    });
                    $(this).addClass("displayNone");
                });
            }
    });
});