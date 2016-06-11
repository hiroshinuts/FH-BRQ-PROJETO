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
<link rel="stylesheet" type="text/css" media="screen, projector, print" href="/financial_health/css/pizza.css"/>

<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/financial_health/js/snap.svg.js"></script>
<script type="text/javascript" src="/financial_health/js/pizza.js"></script>
<script>
   $(document).ready(
		function(){
			 $(window).load(function() {
			      Pizza.init();
			      $(document).foundation();
			    });
		}	   		
   );
  </script>

</head>
<body class="container">

	
	<div class="col-md-12">
	<jsp:include page="/template/topo.jsp"></jsp:include>
	
	Id do Usuario: <label> ${usuariologado.idUsuario} </label> <br/>
  	Usuario Autenticado: <label> ${usuariologado.nome} </label> <br/>
	<h3>Lan�amentos por data</h3>
		<a href="/financial_health/logado/indexlogado.jsp">Voltar</a> para a p�gina inicial.
	<hr/>
	
		<!-- GRAFICO -->
		
			<div class="container">
	<div class="row">
	</div>
    <div class="row">
        <div class="col-md-4">
    	<h2>Lan�amento por Periodo</h2>
          <ul data-pie-id="svg">
           	 <li data-value='<fmt:formatNumber value="${somainva}" maxFractionDigits="2"/>'>Investimento(${somainva})</li>
           	<li data-value='<fmt:formatNumber value="${somadfa}" maxFractionDigits="2"/>'>Despesa Fixa(${somadfa})</li>
            <li data-value='<fmt:formatNumber value="${somadva}" maxFractionDigits="2"/>'>Despesa Variavel(${somadva})</li>
          </ul>
        </div>
        <div class="col-md-4">
          <div id="svg"></div>
        </div>
     </div>
		
		<!-- FIM GRAFICO -->
		
		<form name="formulario" method="post" action="/financial_health/ControleBuscaPorData?action=buscadata">
		<label>Data Inicio</label>
		<input type="date"  name="dateini" id="dateini"/>
		<label>Data Fim</label>
		<input type="date" name="datefim" id="datefim"/>
		<input type="submit">
		
		</form>
			<p>
				${mensagem}
			</p>
			
	<label>Investimento</label>		
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${sessionScope.dadosinv}" var="inv">
				<tr>
					<td>${inv.idInvestimento }   </td>
					<td>${inv.nome }  </td>
					<td>
					<fmt:formatNumber value="${inv.valor}" type="currency">
  					</fmt:formatNumber>
					  </td>
					<td>
					${inv.dataInvestimento}
					<fmt:formatDate value="${dv.dataInvestimento}" type="date" pattern="dd/MM/yyyy" />
					  </td>
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
				<fmt:formatNumber value="${sessionScope.somainva}" type="currency">
  				</fmt:formatNumber></th>
				<th></th>
			</tr>
		</tfoot>
	</table>
	
	<label>Despesa Fixa</label>
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
	
	<c:forEach items="${sessionScope.dadosdf}" var="df">
				<tr>
					<td>${df.idDespesaFixa }   </td>
					<td>${df.nome }  </td>
					<td>
					<fmt:formatNumber value="${df.valor}" type="currency">
  					</fmt:formatNumber>
					</td>
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
				 <fmt:formatNumber value="${sessionScope.somadfa}" type="currency">
  				 </fmt:formatNumber>
  				 </th>
				<th></th>
			</tr>
		</tfoot>
	</table>
	</div>
	<label>Despesa Variavel</label>
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${sessionScope.dadosdv}" var="dv">
				<tr>
					<td>${dv.idDespesaVariavel }   </td>
					<td>${dv.nome }  </td>
					<td>
					<fmt:formatNumber value="${dv.valor}" type="currency">
  					</fmt:formatNumber>
					  </td>
					<td>
					${dv.dataDespesaVariavel}"
					
					
					  </td>
					<td>
						<a href="/financial_health/ControleDespesaVariavel?action=editar&id=${dv.idDespesaVariavel}" class="btn btn-default btn-sm">
							<spam class="glyphicon glyphicon-pencil"></spam>
						</a>
							
					
					
						<a href="/financial_health/ControleDespesaVariavel?action=excluir&id=${dv.idDespesaVariavel}" class="btn btn-danger btn-sm
						 onclick="return confirm('Deseja excluir este item?');" >
							<spam class="glyphicon glyphicon-trash"></spam>	 
*						 </a>
					</td>
				</tr>
	</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th></th>
				<th>Total:</th>
				<th>
				 <fmt:formatNumber value="${sessionScope.somadva}" type="currency">
  				 </fmt:formatNumber>
  				 </th>
			</tr>
		</tfoot>
	</table>
</body>
</html>