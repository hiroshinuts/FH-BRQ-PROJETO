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
<link rel="stylesheet" type="text/css" href="/FinancialHealth/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/FinancialHealth/css/bootstrap-theme.min.css"/>
<!-- Arquivos Javascript -->
<script type="text/javascript" src="/FinancialHealth/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/FinancialHealth/js/bootstrap.min.js"></script>

</head>
<body>

	<div id="fullscreen_bg" class="fullscreen_bg"/>

<div class="container">

    <form class="form-signin" name="formulariologin" method="post" action="ControleUsuario?action=autenticar">
		<h1 class="form-signin-heading text-muted">Entrar</h1>
		<input name="cpf" type="text" class="form-control" placeholder="Digite seu CPF" required="" autofocus="">
		<input name="senha" type="password" class="form-control" placeholder="Password" required="">
		<input type="submit" value="Entrar" class="btn btn-success">
	</form>

</div>

</body>
</html>