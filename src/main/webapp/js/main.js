(function ($) {
	
	/*==================================================================
    [ method get ]*/
	$(".js-load-chamados").on('click', function() {
		$.ajax({
				url: "http://localhost:8080/api_proway/rest/chamados/",
				type: "GET",
				success: function(response) {
					desenhaTabela(response);
				}
		});
	});
	
	/*==================================================================
    [ method post ]
    $("input[name='status-chamado']:checked").val();
    */
	$(".js-save-chamados").on('click', function() {
		var elAssunto = document.getElementById('assunto');
		var strAssunto = elAssunto.value;
		var elMensagem = document.getElementById('mensagem');
		var strMensagem = elMensagem.value;

		var chamados = {};		
		chamados.assunto = strAssunto;
		chamados.status =  $("input[name='status-chamado']:checked").val();
		chamados.mensagem = strMensagem;
	
		var chamadoObj = JSON.stringify(chamados);
		$.ajax({
				url: 'http://localhost:8080/api_proway/rest/chamados/',
				headers: { 
					contentType: 'application/json'				
				},
				type: 'POST',
				data:chamadoObj,
				contentType: 'application/json; charset=utf-8',
				success: function() {
					//alert('salvo com sucesso');
				},
				error: function(error) {
					alert('ERROS '+ error);
				}
		});
	});
	
    "use strict";

    /*==================================================================
    [ Validate after type ]*/
    $('.validate-input .input100').each(function(){
        $(this).on('blur', function(){
            if(validate(this) == false){
                showValidate(this);
            }
            else {
                $(this).parent().addClass('true-validate');
            }
        })    
    })
  
  
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
           $(this).parent().removeClass('true-validate');
        });
    });

     function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');

        $(thisAlert).append('<span class="btn-hide-validate">&#xf136;</span>')
        $('.btn-hide-validate').each(function(){
            $(this).on('click',function(){
               hideValidate(this);
            });
        });
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).removeClass('alert-validate');
        $(thisAlert).find('.btn-hide-validate').remove();
    }
    
    function desenhaTabela(dados) {
    	$(".js-chamados-table-body tr").remove();
    	for(var i=0; i < dados.length; i++) {
    		desenhaLinha(dados[i]);
    	}
    }

    function desenhaLinha(linha) {
    	var linhaTabela = $("<tr/>");
    	$(".js-chamados-table-body").append(linhaTabela);
    	linhaTabela.append("<td>" + linha.id + "</td>");
    	linhaTabela.append("<td>" + linha.assunto + "</td>");
    	linhaTabela.append("<td>" + linha.mensagem + "</td>");
    	linhaTabela.append("<td>" + linha.status + "</td>");
    }
    

})(jQuery);