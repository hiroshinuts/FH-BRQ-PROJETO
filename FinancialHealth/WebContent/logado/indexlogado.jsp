<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="/FinancialHealth/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/FinancialHealth/css/bootstrap-theme.min.css"/>
<!-- Arquivos Javascript -->
<script type="text/javascript" src="/FinancialHealth/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/FinancialHealth/js/bootstrap.min.js"></script>

</head>
<body>
	
		<a href="#" data-target="#janelainvestimento" data-toggle="modal">Cadastrar Investimento</a>
		<a href="#" data-target="#janeladespesafixa" data-toggle="modal">Cadastrar Despesa Fixa</a>
		<a href="#" data-target="#janeladespesavariavel" data-toggle="modal">Cadastrar Despesa Variavel</a>
		<a href="analise.jsp" >An�lise</a> 
		
		
		<div id="janelainvestimento" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header bg-primary">
					<span class="glyphicon glyphicon-user"></span>
						Cadastrar Investimento
				</div>		
				<div class="modal-body">
				
					Preencha os campos abaixo para registrar:
					<hr/>
					
					<form name="formularioinvestimento" method="post" action="ControleInvestimento?action=cadastrar">
						
						<label>Nome do Investimento</label>
						<input type="text" name="nome" class="form-control" placeholder="Digite aqui"/>
						<br/>
						<label>Valor:</label>
						<input type="number" name="valor" class="form-control" placeholder="Digite aqui"/>
						<br/>
						
						<label>Data do Investimento</label><br/>
						<input  type="date" name="datainvestimento" class="form-control required" />
						<br/><br/>
						
						<input type="submit" value="Cadastrar" class="btn btn-success" />
						
					</form>
				
				</div>		
				</div>			
			</div> 
		</div>
		
			<div id="janeladespesafixa" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header bg-primary">
					<span class="glyphicon glyphicon-user"></span>
						Cadastrar Despesa Fixa
				</div>		
				<div class="modal-body">
				
					Preencha os campos abaixo para registrar:
					<hr/>
					
					<form name="formulariodespesafixa" method="post" action="ControleDespesaFixa?action=cadastrar">
						
						<label>Nome da Despesa</label>
						<input type="text" name="nome" class="form-control" placeholder="Digite aqui"/>
						<br/>
						<label>Valor:</label>
						<input type="number" name="valor" class="form-control" placeholder="Digite aqui"/>
						<br/>
						
						<label>Data da Despesa</label><br/>
						<input  type="date" name="datadespesafixa" class="form-control required" />
						<br/><br/>
						
						<input type="submit" value="Cadastrar" class="btn btn-success" />
						
					</form>
				
				</div>		
				</div>			
			</div> 
		</div>
		
			<div id="janeladespesavariavel" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header bg-primary">
					<span class="glyphicon glyphicon-user"></span>
						Cadastrar Despesa Variavel
				</div>		
				<div class="modal-body">
				
					Preencha os campos abaixo para registrar:
					<hr/>
					
					<form name="formulariodespesavariavel" method="post" action="ControleDespesaVariavel?action=cadastrar">
						<label>Nome da Despesa</label>
						<input type="text" name="nome" class="form-control" placeholder="Digite aqui"/>
						<br/>
						<label>Valor:</label>
						<input type="number" name="valor" class="form-control" placeholder="Digite aqui"/>
						<br/>
						
						<label>Data da Despesa</label><br/>
						<input  type="date" name="datadespesavariavel" class="form-control required" />
						<br/><br/>
						
						<input type="submit" value="Cadastrar" class="btn btn-success" />
					
					</form>
				
				</div>		
				</div>			
			</div> 
		</div>

</body>
</html>