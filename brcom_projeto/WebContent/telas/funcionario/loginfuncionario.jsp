<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area restrita - Login do Funcionário</title>

		<!-- Boostrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- arquivos javascript -->
	<script type="text/javascript" src="bootstrap/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

</head>
<body class="container">

	 <div class="well well-sm">
		<h2> Área de Acesso Restrito</h2>
	 </div>
	 
	 <div> 
	 	<a href="/brcom_projeto/index.jsp">Voltar</a> para a página inicial	 
	   </div> 
	   
	   <hr/>

	<form name = "formulario" method="post" action="/brcom_projeto/ControleFuncionario?action=autenticarloginfuncionario">
		<div class="col-md-12" >
			<div class="col-md-4" align="center">
				<input type="email" name="email" class="form-control"  placeholder="Email">
				<input type="password" name="senha" class="form-control" placeholder="Senha">
				<hr/>
				${mensagem}
				<input type="submit" value="Autenticar Usuario"
					   class="btn btn-success btn-block"/>
			</div>
		</div>
	</form>

</body>
</html>