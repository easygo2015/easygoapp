$(document).ready(function(){
			var validate = {
				'fullName' : function() {
					var name = $('#name');
					var ele = $('#fullname');					
					if(ele.val().length < 3) {
							validate.errors = true;
							name.removeClass('has-success').addClass('has-error has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
							$('#nameError').removeClass('hidden').addClass('show');	
					} else {
							name.removeClass('has-error').addClass('has-success has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
							$('#nameError').removeClass('show').addClass('hidden');
					}
				},
				
				'gender' : function() {
					if($('input[name="gender"]:checked').length === 0){
						validate.errors = true;
                        $('#gender').removeClass('has-success').addClass('has-error');
						$('#genderError').removeClass('hidden').addClass('show');	
					}else{
                        $('#gender').removeClass('has-error').addClass('has-success');
						$('#genderError').removeClass('show').addClass('hidden');
					}
				},
				
				'car' : function() {
					if($('input[name="car"]:checked').length === 0){
						validate.errors = true;
                        $('#car').removeClass('has-success').addClass('has-error');
						$('#carError').removeClass('hidden').addClass('show');	
					}else{
                        $('#car').removeClass('has-error').addClass('has-success');
						$('#carError').removeClass('show').addClass('hidden');
					}
				},
				
				'email' : function() {
					var name = $('#blockemail');
					var ele = $('#email');
					var patt = /^.+@.+[.].{2,}$/i;					
					if(!patt.test(ele.val())) {
							validate.errors = true;
							name.removeClass('has-success').addClass('has-error has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
							$('#emailError').removeClass('hidden').addClass('show');	
					} else {
							name.removeClass('has-error').addClass('has-success has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
							$('#emailError').removeClass('show').addClass('hidden');
					}
				},

				'phone' : function() {
					var name = $('#blockphone');
					var ele = $('#phone');
					var patt = /^((8|\+3)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/;					
					if(!patt.test(ele.val())) {
							validate.errors = true;
							name.removeClass('has-success').addClass('has-error has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
							$('#phoneError').removeClass('hidden').addClass('show');	
					} else {
							name.removeClass('has-error').addClass('has-success has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
							$('#phoneError').removeClass('show').addClass('hidden');
					}
				},				
				
				'password' : function() {
					var name = $('#blockpassword');
					var ele = $('#password');					
					if(ele.val().length < 3) {
							validate.errors = true;
							name.removeClass('has-success').addClass('has-error has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
							$('#passwordError').removeClass('hidden').addClass('show');	
					} else {
							name.removeClass('has-error').addClass('has-success has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
							$('#passwordError').removeClass('show').addClass('hidden');
					}
				},

				'compas' : function() {
					var name = $('#blockcompare');
					var pas = $('#password');
					var ele = $('#compas');					
					if( ele.val()===""||(ele.val()!=pas.val())) {
							validate.errors = true;
							name.removeClass('has-success').addClass('has-error has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
							$('#comError').removeClass('hidden').addClass('show');	
					} else {
							name.removeClass('has-error').addClass('has-success has-feedback');
							$('.glyphicon').remove();
							ele.after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
							$('#comError').removeClass('show').addClass('hidden');
					}
				},
					
				'sendIt' : function(){
					if(!validate.errors){
						$('#form').submit();
					}
				}	
				
			};

// ======================================================

    $('#send').click(function (){
        validate.errors = false;
        validate.fullName();
        validate.gender();
        validate.car();
        validate.email();
        validate.phone();
        validate.password();
        validate.compas();
        validate.sendIt();
        return false;
    });

			
		$('#fullname').change(validate.fullName);
		$('input[name="gender"]').change(validate.gender);
		$('input[name="car"]').change(validate.car);
		$('#blockemail').change(validate.email);
		$('#blockphone').change(validate.phone);
		$('#password').change(validate.password);
		$('#compas').change(validate.compas);
		
});