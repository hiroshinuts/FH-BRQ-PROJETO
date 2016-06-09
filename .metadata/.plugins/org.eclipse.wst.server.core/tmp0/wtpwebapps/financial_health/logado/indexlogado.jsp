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
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap-theme.min.css"/>
<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>

</head>
<body class="container">
	
	<div class="col-md-12">
	<jsp:include page="/template/topo.jsp"></jsp:include>
	
		Id do Usuario: <label> ${usuariologado.idUsuario} </label> <br/>
  		Usuario Autenticado: <label> ${usuariologado.nome} </label> <br/>
	
		<h4>${mensagem}</h4>
		<div class="col-md-3 panel text-center">
			<a href="#" data-target="#janelainvestimento" data-toggle="modal" class="btn btn-default btn-block">Cadastrar Investimento</a>
		</div>
		
		<div class="col-md-3 panel text-center">
			<a href="#" data-target="#janeladespesafixa" data-toggle="modal" class="btn btn-default btn-block">Cadastrar Despesa Fixa</a>
		</div>
			
		
		<div class="col-md-3 panel text-center">
			<a href="#" data-target="#janeladespesavariavel" data-toggle="modal" class="btn btn-default btn-block">Cadastrar Despesa Variavel</a>
		</div>
		
			<br/><br/><br/>
			
		<div class="col-md-3 panel text-center">
			<a href="/financial_health/logado/analise.jsp" class="btn btn-default btn-block" >Busca/Periodo</a> 
		</div>
		
		
		 <div class="col-md-3 panel text-center"> 
	 		<a href="/financial_health/ControleUsuario?action=logout" class="btn btn-danger btn-block">
	 			<span class="glyphicon glyphicon-off"></span> Logout
	 		</a>
	  	 </div> 
	
	<hr/>	
	
		
		<div id="janelainvestimento" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header bg-default">
					<span class="glyphicon glyphicon-user"></span>
						Cadastrar Investimento
				</div>		
				<div class="modal-body">
				
					Preencha os campos abaixo para registrar:
					<hr/>
					
					<form name="formularioinvestimento" method="post" action="/financial_health/ControleInvestimento?action=cadastrar">
						
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
				<div class="modal-header bg-default">
					<span class="glyphicon glyphicon-user"></span>
						Cadastrar Despesa Fixa
				</div>		
				<div class="modal-body">
				
					Preencha os campos abaixo para registrar:
					<hr/>
					
					<form name="formulariodespesafixa" method="post" action="/financial_health/ControleDespesaFixa?action=cadastrar">
						
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
				<div class="modal-header bg-default">
					<span class="glyphicon glyphicon-user"></span>
						Cadastrar Despesa Variavel
				</div>		
				<div class="modal-body">
				
					Preencha os campos abaixo para registrar:
					<hr/>
					
					<form name="formulariodespesavariavel" method="post" action="/financial_health/ControleDespesaVariavel?action=cadastrar">
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
	</div>
	
	<!-- GRAFICO VALORES IDEAL -->
	
	

<!-- FIM GRAFICO IDEAL -->
	
	<label>Investimento</label>		
	<table class="table">
		<thead>
			<tr>
				<th>C�digo</th>
				<th>Nome</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${sessionScope.dinv}" var="inv">
				<tr>
					<td>${inv.idInvestimento }   </td>
					<td>${inv.nome }  </td>
					<td>${inv.valor }  </td>
					<td>${inv.dataInvestimento }  </td>
					<td>
						<a href="/financial_health/ControleInvestimento?action=editar&id=${inv.idInvestimento}" class="btn btn-default btn-sm">
							<spam class="glyphicon glyphicon-pencil"></spam>
						</a>
							
					
					
						<a href="/financial_health/ControleInvestimento?action=excluir&id=${inv.idInvestimento}" class="btn btn-danger btn-sm
						 onclick="return confirm('Deseja excluir este item?');" >
							<spam class="glyphicon glyphicon-trash"></spam>	 
						 </a>
					</td>
				</tr>
	</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th></th>
				<th>Total:</th>
				<th>
				<fmt:formatNumber value="${sessionScope.somainv}" type="currency">
  				</fmt:formatNumber>
  				</th>
				<th></th>
			</tr>
		</tfoot>
	</table>
	
	<label>Despesa Fixa</label>
	<table class="table">
		<thead>
			<tr>
				<th>C�digo</th>
				<th>Nome</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
	
	<c:forEach items="${sessionScope.ddf}" var="df">
				<tr>
					<td>${df.idDespesaFixa }   </td>
					<td>${df.nome }  </td>
					<td>${df.valor }  </td>
					<td>${df.dataDespesaFixa }  </td><td>
						<a href="/financial_health/ControleDespesaFixa?action=editar&id=${df.idDespesaFixa}" class="btn btn-default btn-sm">
							<spam class="glyphicon glyphicon-pencil"></spam>
						</a>
							
					
					
						<a href="/financial_health/ControleDespesaFixa?action=excluir&id=${df.idDespesaFixa}" class="btn btn-danger btn-sm
						 onclick="return confirm('Deseja excluir este item?');" >
							<spam class="glyphicon glyphicon-trash"></spam>	 
						 </a>
					</td>
				</tr>
	</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th></th>
				<th>Total:</th>
				<th>
				 <fmt:formatNumber value="${sessionScope.somadf}" type="currency">
  				 </fmt:formatNumber>
  				 </th>
				<th></th>
			</tr>
		</tfoot>
	</table>
	
	<label>Despesa Variavel</label>
	<table class="table">
		<thead>
			<tr>
				<th>C�digo</th>
				<th>Nome</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${sessionScope.ddv}" var="dv">
				<tr>
					<td>${dv.idDespesaVariavel }   </td>
					<td>${dv.nome }  </td>
					<td>${dv.valor }  </td>
					<td>${dv.dataDespesaVariavel }  </td>
					<td>
						<a href="/financial_health/ControleDespesaVariavel?action=editar&id=${dv.idDespesaVariavel}" class="btn btn-default btn-sm">
							<spam class="glyphicon glyphicon-pencil"></spam>
						</a>
							
					
					
						<a href="/financial_health/ControleDespesaVariavel?action=excluir&id=${dv.idDespesaVariavel}" class="btn btn-danger btn-sm
						 onclick="return confirm('Deseja excluir este item?');" >
							<spam class="glyphicon glyphicon-trash"></spam>	 
						 </a>
					</td>
				</tr>
	</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th></th>
				<th>Total:</th>
				<th>
				 <fmt:formatNumber value="${sessionScope.somadv}" type="currency">
  				 </fmt:formatNumber>
  				 </th>
				<th></th>
			</tr>
		</tfoot>
	</table>
</body>
</html>