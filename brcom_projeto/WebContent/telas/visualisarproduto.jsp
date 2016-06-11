<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <jsp:useBean class="br.com.brcom.managedbeans.ManagedBeanProduto" id="mb"></jsp:useBean>
    
     <!-- tag libs -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produto</title>

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
	        			<li><a href="/brcom_projeto/ControleCliente?action=logout" data-toggle="modal" ><span class="glyphicon glyphicon-off"></span> Logout</a></li>
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
	        			<li><a href="telas/cliente/cadastrocliente.jsp" data-toggle="modal" ><span class="glyphicon glyphicon-user"></span> Minha conta </a></li>
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
	
		<div class="col-md-12">
			<div class="col-md-6" >
				<img src="img/${produto.foto}" alt="${produto.nomeProduto}" width="500" height="500"/>
				<hr/>
				
			
				<h4><b>Unidades em estoque:..............</b> ${produto.quantidadeProduto}</h4>
			</div>
			
			
			<div class="col-md-6" align="left" >
			<br>
			<br>
			<br>
			
						<h2><b>Preço por unid.:...........</b> <fmt:formatNumber type="currency" value="${produto.precoProduto}"/></h2>
							<hr/>
							
						<a href="ControleCompra?action=comprar&id=${produto.idProduto}" class="btn btn-success btn-block"> Comprar </a>
						
						
							<hr/>
						<div align="left">
							<h4><b>COD:....................</b> ${produto.idProduto}</h4>
							<h4><b>Nome:..................</b> ${produto.nomeProduto}</h4>
							<h4><b>Preço:..................</b> ${produto.precoProduto}</h4>
						</div>
				
		    	 <form id="formulario" name="formulario" method="post" 
		    	 action="/brcom_projeto/ControleProduto?action=adicionaraocarrinho&id=${produto.idProduto}">
		    		 <input type="submit" value="Adicionar ao carrinho" class="btn btn-primary btn-block"/>
		  		 </form>
				
				
				<h4>${mensagem}</h4>
				<hr/>
				<h4>Valor total da compra: ${precoTotalCompra} R$</h4>
			</div>
			
			
			
		</div>
		
	
		
			<div class="col-md-12">
				<hr/>
				<h4><b>Descrição:...........</b> ${produto.descricaoProduto} </h4>
				
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
				incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
				exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor 
				in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur 
				sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id 
				est laborum."
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