<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap-theme.min.css"/>
<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>

</head>
<body class="container">
	
	<div class="col-md-12">
	<jsp:include page="/template/topo.jsp"></jsp:include>
	
	<h3>Cadastro de Usuario</h3>
		<a href="/financial_health/logado/indexlogado.jsp">Voltar</a> para a p�gina inicial.
	<hr/>
	
		MOSTRAR GRAFICOS - LISTA - 
		
		<form name="formulario" method="post" action="">
		<label>Data Inicio</label>
		<input type="date" />
		<label>Data Fim</label>
		<input type="date" />
		
		</form>
			<p>
				${mensagem}
			</p>
			
	<table class="table">
		<thead>
			<tr>
				<th>C�digo</th>
				<th>Nome</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>  </td>
					<td>  </td>
					<td>  </td>
					<td>  </td>
				</tr>
		</tbody>
	</table>
	
	</div>
	
</body>
</html>