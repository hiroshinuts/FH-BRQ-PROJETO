<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        
    <!-- Chama o managed bean -->
    <jsp:useBean class="br.com.brcom.managedbeans.ManagedBeanProduto" id="mb"></jsp:useBean>
    
    <!-- tag libs -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dados do cliente - NerdComio </title>

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

	<div class="container">
	
	
	
	
		
		<div>
			<h4> Bem vindo, ${sessionScope.usuariologado.nome}</h4>
		</div>
		
		<hr/>	

		
		<div class="col-md-12">
		
			<div class="col-md-6">
			
					<table class="table table-bordered">
		
						<thead>
							<h4> <strong>Dados do cliente</strong></h4>
						</thead>
								
						<tbody>
							<tr>
								<th>Nome: ${sessionScope.usuariologado.nome} </th> 
							</tr>
							<tr>
								<th>Email: ${sessionScope.usuariologado.email} </th> 
							</tr>
						</tbody>		
						
						<tfoot>		
						</tfoot>
					</table>
					
					<h4>Compras realizadas</h4>
					
						<table class="table table-hover">
							<thead>
								<tr></tr>
							</thead>
									
							<tbody>
							<c:forEach items="${listagemCompra}" var="t">
									<tr>
										<th>Produto: ${t.nomeProduto}</th> 
										<th>Preço: ${t.precoProduto}</th>
									</tr>
							</c:forEach>
							</tbody>		
							
							<tfoot>		
							</tfoot>
						</table>
					
					
			

		  	</div>		
		  			
		  			<div class="col-md-6" >
		  			
			  			<div><h4><b>Opções</b></h4></div>
						
						<div> 
					 		<a href="/brcom_projeto/arearestrita/cliente/carrinho.jsp" class="btn btn-success btn-sm">
					 		<span class="glyphicon glyphicon-shopping-cart"></span> Carrinho de compras
					 		</a>
			  			</div>
			  			 
			  			<hr/>
			  			
			  			<div> 
					 		<a href="/brcom_projeto/ControleCliente?action=logout" class="btn btn-danger btn-sm">
					 		<span class="glyphicon glyphicon-off"></span> Logout
					 		</a>
			  			</div>
			  			
					</div>
		  			
					
		</div>
		
		
		
		
		
		  	
		  	
		  	
	<br>
	<br>
	
	
	
			
	
	
	</div>
		

</body>
</html>