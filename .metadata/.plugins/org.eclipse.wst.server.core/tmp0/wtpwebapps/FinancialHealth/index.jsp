<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FinancialHealth</title>

	<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="/FinancialHealth/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/FinancialHealth/css/bootstrap-theme.min.css"/>
<!-- Arquivos Javascript -->
<script type="text/javascript" src="/FinancialHealth/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/FinancialHealth/js/bootstrap.min.js"></script>

</head>
<body class="container">

	<jsp:include page="template/topo.jsp"></jsp:include>
	
	<div class="col-md-12">
	
		<h3>Bem Vindo</h3>
		<hr/>
		
		<div class="col-md-8 panel text-center">
				<div class="glyphicon glyphicon-plus-sign" style="font-size: 3em;">
				<br/><br/>
					<a href="cadastro.jsp" class="btn btn-default btn-block">Cadastro</a>
				</div>
		
				<div class="col-md-8 panel text-center">
					<div class="glyphicon glyphicon-play" style="font-size: 3em;">
					<br/><br/>
						<a href="login.jsp" class="btn btn-default btn-block">Login</a>
					</div>
				</div>
		</div>
	</div>
</body>
</html>