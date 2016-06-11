<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Endereço e pagamento - NerdComio</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- arquivos javascript -->
	<script type="text/javascript" src="bootstrap/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	
	
	<style>  
	 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
    .jumbotron {
      background-color: #1976D2;
    }
    
  </style>
	

</head>
<body>

<%  
     if (session.getAttribute("usuariologado") != null) {  
    	 %><jsp:include page="/telas/templates/cabecalhoLogin.jsp"></jsp:include><%
     } else {
    	 %><jsp:include page="/telas/templates/cabecalho.jsp"></jsp:include><%
     }
  	%>
		
		<div class= "container">
			<div>
				<h2> Endereço e pagamento </h2>
			</div>
		</div>
		<hr/>
		
	
			<div class="container">
				<form id="formularioEnderecoPagamento" name="formularioEnderecoPagamento"
						method="post" 
						action="/brcom_projeto/ControleCompra?action=comprar">
				
					<h3> Endereço </h3>
				
					<label>Logradouro:</label>
					<input type="text" id="logradouro" name="logradouro" class="form-control" placeholder="Ex: Rua boa vista, nº 254"/> <br/>
					
					<label>Cidade :</label>
					<input type="text" id="cidade" name="cidade" class="form-control" placeholder="Ex: São Paulo"/> <br/>
					
					<label>Estado :</label>
					<input type="text" id="estado" name="estado" class="form-control" placeholder="Ex: SP"/> <hr/>
					
					<h3> Pagamento </h3>
										
					<label>Cartão de crédito:</label>
					<input type="text" id="cartaocredito" name="cartaocredito" class="form-control" placeholder="12345678910"/> <br/>
						
						
					<input type="submit" value="Confirmar compra" class="btn btn-success btn-sm"
										onClick="return confirm('Deseja efetuar a compora?');">
					
					<br/>
					<br/>
					${mensagem}
				</form>			
			</div>
			
			
			
	
		

				

</body>
</html>