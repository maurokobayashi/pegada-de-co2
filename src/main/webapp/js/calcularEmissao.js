$(document).ready(function(){
	
	$("#btnCalcular").click(function(){
    	var cep = $("#inputCep").val();
	    
	    if(naoInformouCep(cep)) {
	    	alert("Informe o seu CEP");
	    }
	    else {
		    calcularEmissao(cep);
		    $("#resultado").modal('toggle');
	    }
	});
	
	naoInformouCep = function(cep) {
    	return cep == undefined || cep == "";
    };
    
    calcularEmissao = function(cep) {
    	var uri = "services/emisao/" + cep;

        $.getJSON(uri, function(data) {
        	alert(JSON.stringify(data));
        	var emissao = data.emissao;
       	});
    }

});
