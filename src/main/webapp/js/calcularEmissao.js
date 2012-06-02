$(document).ready(function() {
	
	$("#btnCalcular").click(function(){
    	calcularEmissao();
	});
	
	$("#frmCalcular").submit(function() {
		calcularEmissao();
	});
	
	calcularEmissao = function() {
		var cep = $("#inputCep").val();
	    if(naoInformouCep(cep)) {
	    	alert("Informe o seu CEP");
	    }
	    else {
	    	cep = String(cep).replace("-", "");
			var uri = "services/emissao/" + cep;

	        $.getJSON(uri, function(data) {
	        	var transporte = data.meio_transporte + ",";
	        	var distancia = data.distancia + " km,";
	        	var emissao = data.emissao + " kg de CO2";
	        	
	        	$("#resultadoTransporte").html(transporte);
	        	$("#resultadoDistancia").html(distancia);
	        	$("#resultadoEmissao").html(emissao);
	       	});
			
			var mensagemErro = data.mensagem;

			if(mensagemErro == undefined || mensagemErro == "") {
			    $("#resultado").modal('toggle');
			}
			else {
				alert(data.mensagem);
			}
	    }
	}
	
	naoInformouCep = function(cep) {
    	return cep == undefined || cep == "";
    };
    
});
