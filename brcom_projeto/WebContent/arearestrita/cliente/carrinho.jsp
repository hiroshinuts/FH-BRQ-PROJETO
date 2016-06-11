<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    
    <!-- tag libs -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrinho de compras - NerdComio</title>

	<!-- Boostrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- arquivos javascript -->
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">

			
		window.onload = precoTotal;
		
	</script>
	
	
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
		
		<div class= "container">
			<div>
				<h3>Carinho de compras</h3>
			</div>
		</div>
		<hr/>

		<div class="container">
			<div class="col-md-12">
				<div class="col-md-7">
					<table class="table table-hover">
		
						<thead>
							<tr>
								<th>Código</th>
								<th>Nome</th>
								<th>Descrição</th>
								<th>Preço</th>
								<th>Quantidade</th>
								<th>Excluir?</th>
							</tr>		
						</thead>
								
						<tbody>
							<c:forEach items="${sessionScope.carrinho.listaProdutos}" var="f" varStatus="loop"> <!-- repete a linha a cada item da lista -->
								<tr>
									<td>${f.idProduto}</td>
									<td>${f.nomeProduto}</td>
									<td>${f.descricaoProduto}</td>
									<td><fmt:formatNumber type="currency" value="${f.precoProduto}"/></td>
									<td>${f.quantidadeProduto}</td>										<!-- pegar a index -->
									<td> <a href="/brcom_projeto/ControleProduto?action=excluirdocarrinho&pos=${loop.index}" class="btn btn-danger btn-sm"
										onClick="return confirm('Deseja excluir do carrinho?');"> Excluir do carrinho de compras?</a> </td>
									</tr>
							</c:forEach>
						</tbody>		
						
						<tfoot>
						</tfoot>
			
					</table>
				</div>
				
					<div class="col-md-5">
							<h3> Preço total da compra: ${precoTotalCompra} R$</h3>  <h3 id="precototal"></h3>
							
						
							
							<hr/>							
							
										<a href="/brcom_projeto/ControleCompra?action=validarcompra" class="btn btn-success btn-sm"> Comprar</a>
										<hr/>
										${mensagem}
										
					</div>
			</div>
		</div>
		
</body>
</html>