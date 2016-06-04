<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-theme.min.css" />
</head>
<body class = "container">

	<h2>Cadastro de Usuario</h2><br/>
	<form name="formulario" method="post" action="ControleUsuario?action=cadastrarUsuario">
	<br/><br/>
	
	<label>Nome Completo:</label><br/>
	<input type="text" name="nome" class="form-control required" placeholder="Digite aqui"/>
	<br/><br/>
	
	<label>Email:</label><br/>
	<input type="text" name="email" class="form-control required" placeholder="Digite aqui"/>
	<br/><br/>
	
	<label>cpf:</label><br/>
	<input type="text" name="cpf" class="form-control required" placeholder="cpf"/>
	<br/><br/>
	
	<label>Data de Nascimento</label><br/>
	<input  type="date" name="datanascimento" class="form-control required" />
	<br/><br/>
	
	<label>Rendimento Mensal:</label><br/>
	<input type="number" name="rendimentomensalliquido" class="form-control required"/>
	<br/><br/>
	
	<label>Senha:</label><br/>
	<input type="password" name="senha" class="form-control required" />
	<br/><br/>
	
	<input type="submit" value="Cadastrar" class="btn btn-success" />
	
	<br/><br/>
	
	</form>
	
</body>
</html>