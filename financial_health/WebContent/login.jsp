<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

	<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap-theme.min.css"/>
<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>

</head>
<body class="container">

<jsp:include page="template/topo.jsp"></jsp:include>

	 <div class="well well-sm">
		<h2> �rea de Acesso Restrito</h2>
	 </div>
	 
	 <div> 
	 	<a href="index.jsp">Voltar</a> para a p�gina inicial.
	 	<br/>
	 	<br/>
	 	<br/>	 
	   </div> 

	<form name = "formulario" method="post" action="ControleUsuario?action=login">
		<div class="col-md-12" >
		
			<div class="col-md-5">
				<input type="text" name="cpf" class="form-control"  placeholder="CPF"><br/>
				<input type="password" name="senha" class="form-control" placeholder="Senha">
				${mensagem}
				
				<br/><br/>
				<input type="submit" value="Autenticar Usuario"
					   class="btn btn-success btn-block"/>
			</div>
		</div>
	</form>

</body>
</html>