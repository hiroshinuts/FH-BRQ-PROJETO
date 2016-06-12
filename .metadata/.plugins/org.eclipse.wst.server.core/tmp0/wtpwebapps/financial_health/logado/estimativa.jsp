<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estimativa</title>

<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" type="text/css" media="screen, projector, print" href="/financial_health/css/pizza.css"/>

<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/financial_health/js/messages_pt_BR.min.js"></script>

</head>
<body class="container">
	
	<div class="col-md-12">
	<jsp:include page="/template/topo.jsp"></jsp:include>
	
	<label>Id </label> ${usuariologado.idUsuario}
  	<label>Usuario: </label> ${usuariologado.nome} <br/>
		<a href="/financial_health/logado/indexlogado.jsp">Voltar</a> para a p�gina inicial.
	<hr/>

	<div class="col-md-4">
	
			<form id="formulario" name="formulario" method="post" action="/financial_health/ControleEstimativa?action=calcular">
			
				<label>Idade:</label><br/>
				<input type="number" id="idade" name="idade" class="form-control required" placeholder="Digite aqui"/>
				<br/>
				
				<label>Valor que imagina ganhar dos 18 aos 29 por mes:</label><br/>
				<input type="number" id="valor18_29" name="valor18_29" class="form-control required" placeholder="Digite aqui"/>
				<br/>
				
				<label>Valor que imagina ganhar dos 30 aos 39 por mes:</label><br/>
				<input type="number" id="valor30_39" name="valor30_39" class="form-control required" placeholder="Digite aqui"/>
				<br/>
				
				<label>Valor que imagina ganhar dos 40 aos 49 por mes:</label><br/>
				<input type="number" id="valor40_49" name="valor40_49" class="form-control required" placeholder="Digite aqui"/>
				<br/>
				
				<label>Valor que imagina ganhar dos 50 aos 65 por mes:</label><br/>
				<input type="number" id="valor50_65" name="valor50_65" class="form-control required" placeholder="Digite aqui"/>
				<br/>
				
				
				<input type="submit" value="Calcular" class="btn btn-success" />
				<br/>
			</form>
		</div>
		
		<div class="col-md-8">
			
			<h3><label>Alcan�ando o indicado que se deve "Investir" por m�s, que o sistema coloca como "Gr�fico Ideal"</label></h3>
			<h3><label>Para o calculo da estimativa, foi utilizado o valor fixo da poupan�a de: 0,5%</label></h3>
			<h3><label>Diversificar os investimentos fazem com que al�m de mais seguran�a um melhor rendimento.</label></h3>
			<h3><label>Conforme os dados passados, seu Rendimento � de :</label></h3><br/>
			
			<h1><label><fmt:formatNumber value="${mensagem}" maxFractionDigits="2" type="currency"/></label></h1>
			
		
		
		
		
		
		
		
		
		
		</div>
		
	</div>
</body>
</html>