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
<link rel="stylesheet" type="text/css" href="/financial_health/css/business-casual.css" />

<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/financial_health/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/financial_health/js/messages_pt_BR.min.js"></script>
<script type="text/javascript">

$(document).ready( //quando a p�gina carregar...
function(){ //fa�a..
//validar o formul�rio..
$("#formulario").validate(
{
rules:{
nome : "required"
				},messages:{
						nome:{
							required : "Por favor, informe o nome.."
							}
				 }
			}
		);
	}
);
</script>

</head>
<body class="container">
	
	<div class="col-md-12">
	<jsp:include page="/template/topo.jsp"></jsp:include>
	
  	<h5><label>Usuario: </label> ${usuariologado.nome} <br/></h5>
		<h5><a href="/financial_health/logado/indexlogado.jsp">Voltar</a> para a p�gina inicial.</h5>
	<hr/>

	<div class="col-md-4">
		<div class="box">
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
		</div>
		
		<div class="col-md-8">
			<h3><label>*****VALOR FIXADO DA POUPAN�A DE 0,5%*****</label></h3><br/>
			
			<h3><label>Diversificar os investimentos, al�m de um maior rendimento, gera mais seguran�a para seu investimento</label></h3><br/>
			
			<h3><label>Conforme os dados passados, seu Rendimento � de :</label></h3><br/>
			
			<div class= "well well-sm">
			
			<font size="15"><label><fmt:formatNumber value="${mensagem}" maxFractionDigits="2" type="currency"/></label></h1></font>
			
			</div>
			
		
		
		
		
		
		
		
		
		
		</div>
		
	</div>
</body>
</html>