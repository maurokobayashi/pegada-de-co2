$(document).ready(function(){
	
	$("#btnCalcular").click(function(){
    
    	var cep = $("#inputCep").val();
	    
	    if(naoInformouCep(cep)) {
	    	alert("Informe o seu CEP");
	    }
	    else {
	    	cep = String(cep).replace("-", "");
		    calcularEmissao(cep);
		    $("#resultado").modal('toggle');
	    }
	});
	
	naoInformouCep = function(cep) {
    	return cep == undefined || cep == "";
    };
    
    calcularEmissao = function(cep) {
    	
    	var uri = "services/emissao/" + cep;

        $.getJSON(uri, function(data) {

        	var transporte = data.meio_transporte + ",";
        	var distancia = data.distancia + " km,";
        	var emissao = data.emissao + " kg de CO2";
        	
        	$("#resultadoTransporte").html(transporte);
        	$("#resultadoDistancia").html(distancia);
        	$("#resultadoEmissao").html(emissao);
       	});
    }

});
