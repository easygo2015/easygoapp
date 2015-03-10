$(document).ready(function () {
    var validate = {
        'latitude': function () {
            var latitude = $('#latitude');
            var ele = $('#enterlatitude');
            var isCoordinate = /^[0-9]+([,.][0-9]{1,6})?$/
            if(!ele.match(isCoordinate)){
                validate.errors = true;
                latitude.removeClass('has-success').addClass('has-error has-feedback');
                $('.glyphicon').remove();
                ele.after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
                $('#latitudeError').removeClass('hidden').addClass('show');
            } else {
                latitude.removeClass('has-error').addClass('has-success has-feedback');
                $('.glyphicon').remove();
                ele.after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
                $('#latitudeError').removeClass('show').addClass('hidden');
            }
        },
        'longitude': function () {
            var longitude = $('#longitude');
            var ele = $('#enterlongitude');
            var isCoordinate = /^[0-9]+([,.][0-9]{1,6})?$/
            if (!ele.match(isCoordinate)) {
                validate.errors = true;
                longitude.removeClass('has-success').addClass('has-error has-feedback');
                $('.glyphicon').remove();
                ele.after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
                $('#longitudeError').removeClass('hidden').addClass('show');
            } else {
                longitude.removeClass('has-error').addClass('has-success has-feedback');
                $('.glyphicon').remove();
                ele.after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
                $('#longitudeError').removeClass('show').addClass('hidden');
            }
        },
        'isleft': function () {
            if ($('input[name="isLeft"]:checked').length === 0) {
                validate.errors = true;
                $('#isLeft').removeClass('has-success').addClass('has-error');
                $('#isLeftError').removeClass('hidden').addClass('show');
            } else {
                $('#isLeft').removeClass('has-error').addClass('has-success');
                $('#isLeftError').removeClass('show').addClass('hidden');
            }
        },
        'description': function () {
            var description = $('#description');
            var ele = $('#enterdescription');
            if (ele.val().length < 3) {
                validate.errors = true;
                description.removeClass('has-success').addClass('has-error has-feedback');
                $('.glyphicon').remove();
                ele.after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
                $('#descriptionError').removeClass('hidden').addClass('show');
            } else {
                name.removeClass('has-error').addClass('has-success has-feedback');
                $('.glyphicon').remove();
                ele.after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
                $('#descriptionError').removeClass('show').addClass('hidden');
            }
        }
    };

    $('#enterlatitude').change(validate.latitude);
    $('#enterlongitude').change(validate.longitude);
    $('input[name="isleft"]').change(validate.gender);
    $('#enterdescription').change(validate.longitude);
});
