<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de cliente</title>

	<!-- arquivos css do boostrap -->
	<link rel="stylesheet" type="text/css" href="/brcom_projeto/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/brcom_projeto/bootstrap/css/bootstrap-theme.min.css"/>
	
	<!-- arquivos javascript -->
	<script type="text/javascript" src="bootstrap/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.validate.min.js"></script>
	
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

		 <nav class="navbar navbar-inverse navbar-fixed-top">
	        <div class="container-fluid">
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav">
	                    <li><a href="/brcom_projeto/index.jsp">Início</a></li>
	                    
	                    
	                </ul>                
	                <ul class="nav navbar-nav navbar-right">
	        			<li><a href="#" data-toggle="modal" ><span class="glyphicon glyphicon-user"></span> Minha conta </a></li>
	        			<li><a href="#" data-toggle="modal" ><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
	     			 </ul>
	            </div>
	        </div>
    	</nav>


       <div class="jumbotron">
  			<div class="container text-center">
    			<h1><font color="white">NerdComio</font></h1>      
    			<p><font color="white">Loja Online para Nerds</font></p>
  			</div>
		</div>
		
	<div class= "container">
	
	
		<br>
		<br>
		<br>
	   		
			 	<div class="col-xs-6">
					<form id="formulario" name="formulario" method="post" action="/brcom_projeto/ControleCliente?action=cadastrar">
					
						<h3>Cadastre-se</h3>
						<hr/>
						<input type="text" id="nome" name="nome" class="form-control" placeholder="Nome"/> <br/>
						
						
						<input type="text" id="email" name="email" class="form-control" placeholder="Email"/> <br/>
						
						
						<input type="password" id="senha" name="senha" class="form-control" placeholder="Senha"/> <br/>
						
						
						<input type="password" id="confirmarsenha" name="confirmarsenha" class="form-control" placeholder="Confirmar senha"/> <br/>
						
						<input type="submit" value="Cadastrar! " class="btn btn-success btn-block"/>
						
						<br/>
						<br/>
						${mensagem}
					</form>			
				</div>
		
	</div>
	
	<br>
	<br>
	<br>
	<br>
						


		<footer class="container-fluid text-center">
			  <p>Todos os direitos reservados à BRcom</p>  
				  <form class="form-inline">Fique por dentro das ofertas:
				    <input type="email" class="form-control" size="50" placeholder="Email">
				    <button type="button" class="btn btn-danger">Registrar</button>
				  </form>
		  
		</footer>
	
</body>
</html>