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
<title>Cadastro de mercadoria</title>

	<!-- arquivos css do boostrap -->
	<link rel="stylesheet" type="text/css" href="/brcom_projeto/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/brcom_projeto/bootstrap/css/bootstrap-theme.min.css"/>
	
	
	<!-- arquivos javascript -->
	<script type="text/javascript" src="bootstrap/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
		
		$(document).ready(
			function(){				
				$("#formulario").validate(
					{
						rules:{
							nome	   : "required",
							descricao  : "required",
							categoria  : "required",
							foto   	   : "required",
							preco 	   : "required",
							quantidade : "required"
						},
						messages:{
							nome 		 :{ required : "Por favor, informe o nome da mercadoria" },
							descricao    :{ required : "Por favor, informe a descrição da mercadoria." },
							categoria    :{ required : "Por favor, selecione a categoria." },
							foto  		 :{ required : "Por favor, envie a foto da mercadoria." },
							preco		 :{ required : "Por favor, informe o preço da mercadoria." },
							quantidade 	 :{ required : "Por favor, informe q quantidade." }
						}
					}	
				);				
			}		
		);
	
	</script>
	
	<style>  
	 
    .jumbotron {
      background-color: #1976D2;
    }
    
  </style>

</head>

		<div class="jumbotron">
  			<div class="container text-center">
    			<h1><font color="white">Cadastro de mercadorias</font></h1>      
    			<p><font color="white">Área restrita a funcionarios</font></p>
  			</div>
		</div>
		
<body class="container">

	 
		
	
	<div class="col-md-12">
	
		<div>
			<h3>Bem vindo, ${sessionScope.funcionariologado.nome} </h3> <br>
			<h4>Cargo: ${sessionScope.funcionariologado.cargo}</h4>
			<hr/>

			<a href="/brcom_projeto/ControleFuncionario?action=logout" class="btn btn-danger btn-sm">
		 		<span class="glyphicon glyphicon-off"></span> Logout
		 	</a>
		</div>
	
			<hr/>
			<div class="col-md-4">
				<form id="formulario" name="formulario" 
						enctype="multipart/form-data" 
						method="post" 
						action="/brcom_projeto/ControleProduto?action=cadastrar">
				
				
					<label>Nome do produto:</label>
					<input type="text" id="nome" name="nome" class="form-control" placeholder="Produto"/> <br/>
					
					<label>Descricao do produto:</label>
					<input type="text" id="descricao" name="descricao" class="form-control" placeholder="Descrição"/> <br/>
					
					<!-- Categoria -->
					<label>Categoria:</label>
					<select id="categoria" name="categoria" class="form-control">
						<option value="">- Selecione uma categoria -</option>
						<c:forEach items="${mbC.listagemCategorias}" var="cat">
						<option value="${cat}">${cat}</option>
						<br/>
					</c:forEach>
					</select> <br/>
					
					
					<label>Imagem:</label>
					<input type="file" id="foto" name="foto" class="form-control"/> <br/>
					
					<label>Preco do produto:</label>
					<input type="number" id="preco" name="preco" class="form-control" placeholder="Preço"/> <br/>
					
					<label>Quantidade do produto:</label>
					<input type="number" min="1" id="quantidade" name="quantidade" class="form-control" placeholder="Quantidade"/> <br/>
					
					<input type="submit" value="Cadastrar produto" class="btn btn-success"/>
					
					<br/>
					<br/>
					${mensagem}
				</form>			
			</div>
			
			<div class="col-md-8">
				<table class="table table-striped">
	
					<thead>
						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>Descrição</th>
							<th>Preço</th>
							<th>Quantidade</th>
							<th>Operações</th>
						</tr>		
					</thead>
							
					<tbody>
						<c:forEach items="${mb.listagemProduto}" var="f"> <!-- repete a linha a cada item da lista -->
							<tr>
								<td>${f.idProduto}</td>
								<td>${f.nomeProduto}</td>
								<td>${f.descricaoProduto}</td>
								<td><fmt:formatNumber type="currency" value="${f.precoProduto}"/></td>
								<td>${f.quantidadeProduto}</td>
								<td> <a href="/brcom_projeto/ControleProduto?action=editar&id=${f.idProduto}" class="btn btn-primary btn-sm"> Editar </a> </td>
								<td> <a href="/brcom_projeto/ControleProduto?action=excluir&id=${f.idProduto}" class="btn btn-danger btn-sm"
										onClick="return confirm('Deseja excluir?');"> Excluir </a> </td>
										
							</tr>
						</c:forEach>	
						
					</tbody>		
					
					<tfoot>
						<tr>
							<td colspan="7"> Quantidade de produtos cadastrados: ${fnc:length(mb.listagemProduto)}</td> 
						</tr>		
					</tfoot>
		
				</table>
			</div>
	</div>	
	
	
	
	
	
	

</body>
</html>