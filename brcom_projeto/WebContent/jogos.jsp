<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Chama o managed bean -->
    <jsp:useBean class="br.com.brcom.managedbeans.ManagedBeanProdutoJogo" id="mb"></jsp:useBean>
    
     <!-- tag libs -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NerdComio - Loja Online</title>


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
  
  
  <script type="text/javascript">

	$(document).ready(
	
		function(){
			
	
			$("#btnlogin").click(
				function(){		
					
					// JSON JAVASCRIPT OBJECT NOTATION					
					var dados = {
						"email" : $("#emaillogin").val(),
						"senha" : $("#senhalogin").val(),
						
					};
					
					$("#mensagemjanela").html("Efetuando login...");
					
					$.ajax(
						{
							type: "POST",
							url:  "ControleCliente?action=login",
							data: dados,
							success: function(msg){ 
								
								$("#mensagemjanela").html(msg);
								
								$("#email").val("");
								$("#senha").val("");
								
							},
							error: function(e){
								alert('erro');
								$("#mensagemjanela").html(e)
							
								
							}
						}
					);
					
				}
			);
			

		}
	);

</script>
  
	
</head>


<body>

 	<%  
     if (session.getAttribute("usuariologado") != null) {  
    	 %>
    	 
    	 <nav class="navbar navbar-inverse navbar-fixed-top">
	        <div class="container-fluid">
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav">
	                    <li><a href="/brcom_projeto/index.jsp">Início</a></li>
	                    
	                    
	                </ul>                
	                <ul class="nav navbar-nav navbar-right">
	                	<li><a href="">Bem vindo, ${sessionScope.usuariologado.nome}</a></li>
	        			<li><a href="/brcom_projeto/arearestrita/cliente/dadoscliente.jsp" data-toggle="modal" ><span class="glyphicon glyphicon-user"></span> Minha conta </a></li>
	        			<li><a href="/brcom_projeto/arearestrita/cliente/carrinho.jsp" data-toggle="modal" ><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
	        			<li><a href="ControleCliente?action=logout" data-toggle="modal" ><span class="glyphicon glyphicon-off"></span> Logout</a></li>
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
    	
    	 
    	 <%
     } else {
    	 %>
    	 
    	  <nav class="navbar navbar-inverse navbar-fixed-top">
	        <div class="container-fluid">
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav">
	                    <li><a href="/brcom_projeto/index.jsp">Início</a></li>
	                    
	                    
	                </ul>                
	                <ul class="nav navbar-nav navbar-right">
	        			<li><a href="#janela" data-toggle="modal" ><span class="glyphicon glyphicon-user"></span> Minha conta </a></li>
	        			<li><a href="telas/cliente/cadastrocliente.jsp" data-toggle="modal" ><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
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
    	 
    	 
    	 <%
     }
  	%>
	
	
	
	<div class = "container">
	
		<div class="col-md-12" >
			
			
			<div class="col-md-3" >
			
			<span id="mensagemjanela"></span>
			 	<h2>Categorias</h2>
			      <ul class="nav nav-pills nav-stacked">
			     	<li><a href="/brcom_projeto/index.jsp">Início</a></li>
			        <li><a href="/brcom_projeto/eletronicos.jsp">Eletrônicos</a></li>
			        <li><a href="/brcom_projeto/livros.jsp">Livros</a></li>
			        <li class="active" ><a href="/brcom_projeto/jogos.jsp">Jogos</a></li>
			      </ul><br>
			
	
	
	
	
			</div>
			
			<div class="col-md-9" >
		
				<div id="section1" class="carousel slide" data-ride="carousel">
			  
			  		<div class="carousel-inner" role="listbox">
			  		
			  		<div class="item active" align="center">
			  		
							<a href="index.jsp"><img src="img/logotipo.jpg" alt="Televisão" width="500" height="500"/></a>		      		
				    </div>
			  		
			  		 <c:forEach items="${mb.listagemProduto}" var="f">
				    	 <div class="item" align="center">
				    	 <form id="formulario" name="formulario" method="get" action="/brcom_projeto/ControleProduto?action=visualizar&id=${f.idProduto}">
	       					 	<a href="/brcom_projeto/ControleProduto?action=visualizar&id=${f.idProduto}"><img src="img/${f.foto}" alt="${f.nomeProduto}" width="500" height="500"/></a>
	       					 </form>	
	      				</div>
					 </c:forEach>
				    
				   
					 <a class="left carousel-control" href="#section1" role="button" data-slide="prev">
					   <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					   <span class="sr-only">Anterior</span>
					 </a>
					  
					 <a class="right carousel-control" href="#section1" role="button" data-slide="next">
					   <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					   <span class="sr-only">Próxima</span>
					 </a>
					</div>
			
				</div>
		
			</div>
		
		</div>
	
	</div>

<br>
<br>

		<div class="container">    
		  <div class="row" >
		  
			  <c:forEach items="${mb.listagemProduto}" var="f">
			  
				  	<div class="col-sm-4">
				      <div class="panel panel-primary">
				        <div class="panel-heading">Produto: ${f.nomeProduto}</div>
				        <div class="panel-body" align="center" >
				        	<form id="formulario" name="formulario" method="post" action="/brcom_projeto/ControleProduto?action=visualizar&id=${f.idProduto}">				        	
				        			<img src="img/${f.foto}" alt="${f.nomeProduto}" height="160" width="300"/>
				        			<hr/>
				        		<input type="submit" value="Visualizar" class="btn btn-success btn-block"/>
				        	</form>
				        </div>
				        <div class="panel-footer">
				        	Nome: ${f.nomeProduto} <br>
				        	Preço: ${f.precoProduto}
				        </div>
				      </div>
				    </div>
			  
			  </c:forEach>
		    	
		    	   
		  </div>
		</div><br>

						


		<footer class="container-fluid text-center">
			  <p>Todos os direitos reservados à NerdComio</p>  
				  <form class="form-inline">Fique por dentro das ofertas:
				    <input type="email" class="form-control" size="50" placeholder="Email">
				    <button type="button" class="btn btn-danger">Registrar</button>
				  </form>
				  
			  <div align="right">
			  	<a href="telas/funcionario/loginfuncionario.jsp">Area restrita</a>
			  </div>
		  
		  
		</footer>


 <!-- JANELA -->
	<div id="janela" class="modal fade" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					Login			
				</div>
				
				<div class="modal-body"> Informe os dados para login
				<hr/>		
					
					
						<label>Email</label>
						<input type="text" id="emaillogin" name="nome" class="form-control required" placeholder="Email"/> <br>
						
						<label>Senha</label>
						<input type="password" id="senhalogin" name="senha" class="form-control required" placeholder="senha"/> <br>
					
						<!-- VER COMO APARECE ESSA MENSAGEM -->
						<span id="mensagemjanela"></span> <br>
						
					
    
						
						
						
						<button class = "btn btn-success btn-block" id = "btnlogin">Login</button>
						
						
						
						
										
				</div>
				
				<div class="modal-footer">
							Ainda não tenho conta. <a href="telas/cliente/cadastrocliente.jsp" >Cadastrar</a>
				</div>
				
			</div>		
		</div>	
	</div>

</body>
</html>


	Dúvidas:	
	remover itens do carrinho pela posição da lista
	como exibe mensagem de falha no login no modal de login pelo ajax
	centralizar tela de cadastro
	
	
	
	implementar:
	categoria no produto - testar
	validações em todos os campos do sistema
	visualizar histórico de compras
	Email confirmação da compra
	
	
	verificar:
	todos os titles
	Todos os jumbotron
	Quando compra se está redirecionando corretamente
	
	Consertar:
	comprar sem estar logado


