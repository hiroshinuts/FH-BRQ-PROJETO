<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Chama o managed bean -->
    <jsp:useBean class="br.com.brcom.managedbeans.ManagedBeanProduto" id="mb"></jsp:useBean>
    <jsp:useBean class="br.com.brcom.managedbeans.ManagedBeanCategoria" id="mbC"></jsp:useBean>
    
    <!-- tag libs -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar mercadoria</title>

	<!-- arquivos css do boostrap -->
	<link rel="stylesheet" type="text/css" href="/brcom_projeto/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/brcom_projeto/bootstrap/css/bootstrap-theme.min.css"/>
	
	
	<!-- arquivos javascript -->
	<script type="text/javascript" src="bootstrap/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.validate.min.js"></script>
	
	<style>  
	 
    .jumbotron {
      background-color: #1976D2;
    }
    
  </style>

</head>

		<div class="jumbotron">
  			<div class="container text-center">
    			<h1><font color="white">Edição de mercadorias</font></h1>      
    			<p><font color="white">Área restrita a funcionarios</font></p>
  			</div>
		</div>
		
<body class="container">

	 
		
	
	<div class="col-md-12">
	
		<div>
			<h3>Mercadoria:  </h3> <br>
			<h4></h4>
			<hr/>
			
			<a href="/brcom_projeto/arearestrita/funcionario/index.jsp" class="btn btn-primary">
		 		<span class="glyphicon glyphicon-arrow-left"></span> Voltar
		 	</a>

			<a href="ControleFuncionario?action=logout" class="btn btn-danger btn-sm">
		 		<span class="glyphicon glyphicon-off"></span> Logout
		 	</a>
		 	
		 	
			
		</div>
	
			<hr/>
			<div class="col-md-12">
				<form id="formulario" name="formulario" 
						enctype="multipart/form-data" 
						method="post" 
						action="/brcom_projeto/ControleProduto?action=atualizar">
				
					
					<!-- AULA 10 -->
					
					<label>Id do produto:</label>
					<input type="text" id="id" name="id" value="${produto.idProduto}" class="form-control" readonly placeholder="Produto"/> <br/>
				
					<label>Nome do produto:</label>
					<input type="text" id="nome" name="nome" value="${produto.nomeProduto}" class="form-control" placeholder="Produto"/> <br/>
					
					<label>Descricao do produto:</label>
					<input type="text" id="descricao" name="descricao" value="${produto.descricaoProduto}"class="form-control" placeholder="Descrição"/> <br/>
					
					<label>Categoria:</label>
					<select id="categoria" name="categoria" class="form-control">
						<option value="${produto.categoria}">${produto.categoria}</option>
						<c:forEach items="${mbC.listagemCategorias}" var="cat">
							<option value="${cat}">${cat}</option>
						</c:forEach>
					</select> <br/>
					
					<label>Imagem:</label>
					<input type="file" id="foto" name="foto" class="form-control"/> <br/>
					
					<label>Preco do produto:</label>
					<input type="number" min="0.01" step="0.01" max="10000" id="preco" name="preco" value="${produto.precoProduto}" class="form-control" placeholder="Preço"/> <br/>
					
					<label>Quantidade do produto:</label>
					<input type="number" min="1" id="quantidade" name="quantidade" class="form-control" value="${produto.quantidadeProduto}" placeholder="Quantidade"/> <br/>
					
					<input type="submit" value="Atualizar" class="btn btn-success"/>
					
					<br/>
					<br/>
					${mensagem}
				</form>			
			</div>
			
	</div>	
	
	
	
	
	
	

</body>
</html>