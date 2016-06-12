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
<link rel="stylesheet" type="text/css" href="/financial_health/css/login.css"/>
<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/financial_health/js/messages_pt_BR.min.js"></script>
<script type="text/javascript" src="/financial_health/js/login.js"></script>

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
	
	<!--  SNIPPER -->
	
	<div class="container">
    <div class="row">
        <div class="col-md-12">
           
            <div class="wrap">
                <p class="form-title">${mensagem}</p>
                <p class="form-title">
                    Entrar </p>
				<form name = "formulario" class="login" id="formulario" method="post" action="/financial_health/ControleUsuario?action=login">
				<input type="text" name="cpf" placeholder="Digite o seu cpf"><br/>
				<input type="password" name="senha"  placeholder="Senha">
				<input type="submit" value="Login" class="btn btn-success btn-sm"/>
               	<a href="index.jsp" class="btn btn-danger btn-block">Voltar
	 			</a>
                </form>
                
            </div>
        </div>
    </div>
</div>
	

</body>
</html>