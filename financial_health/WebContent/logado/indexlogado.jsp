<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle</title>

	<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" type="text/css" media="screen, projector, print" href="/financial_health/css/pizza.css"/>

<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/financial_health/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/financial_health/js/messages_pt_BR.min.js"></script>
<script type="text/javascript">

$(document).ready( //quando a p�gina carregar...
function(){ //fa�a..
//validar o formul�rio..
$("#formulario").validate(
{
rules:{
nome : "required"
				},messages:{
						nome:{
							required : "Por favor, informe o nome.."
							}
				 }
			}
		);
	}
);
</script>

</head>
<body class="container">
	
	<div class="col-md-12">
	<jsp:include page="/template/topo.jsp"></jsp:include>
	
		<label>Id </label> ${usuariologado.idUsuario}
  		<label>Usuario: </label> ${usuariologado.nome} <br/>
	
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
			<a href="/financial_health/logado/estimativa.jsp" class="btn btn-default btn-block" >Estimativa Futura</a> 
		</div>
		
		
		 <div class="col-md-3 panel text-center"> 
	 		<a href="/financial_health/ControleUsuario?action=logout" class="btn btn-danger btn-block">
	 			<span class="glyphicon glyphicon-off"></span> Logout
	 		</a>
	  	 </div> 
	
	<!-- MODAL CADASTRO  INV -DF -DV -->		
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
					
					<form name="formulario" id="formulario" method="post" action="/financial_health/ControleInvestimento?action=cadastrar">
						
						<label>Nome do Investimento</label>
						<input type="text" name="nome" class="form-control required" placeholder="Digite aqui"/>
						<br/>
						<label>Valor:</label>
						<input type="number" name="valor" class="form-control required" placeholder="Digite aqui"/>
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
					
					<form name="formulario" id="formulario" method="post" action="/financial_health/ControleDespesaFixa?action=cadastrar">
						
						<label>Nome da Despesa</label>
						<input type="text" name="nome" class="form-control required" placeholder="Digite aqui"/>
						<br/>
						<label>Valor:</label>
						<input type="number" name="valor" class="form-control required" placeholder="Digite aqui"/>
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
					
					<form name="formulario" method="post"  id="formulario" action="/financial_health/ControleDespesaVariavel?action=cadastrar">
						<label>Nome da Despesa</label>
						<input type="text" name="nome" class="form-control required" placeholder="Digite aqui"/>
						<br/>
						<label>Valor:</label>
						<input type="number" name="valor" class="form-control required" placeholder="Digite aqui"/>
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
	<!-- FIM DO MODAL CADASTRO  INV -DF -DV -->	
	
	
	
	<!-- GRAFICO VALORES IDEAL -->
	<div class="col-md-12">
	<table class="columns">
      <tr>
		<td><div class="col-md-4" id="graficoPorData" style="width: 600px; height: 600px;"></div></td>
		<td><div class="col-md-4" id="graficoLancamento" style="width: 600px; height: 600px;"></div></td>
		</tr>
	</table>
	</div>
		


<!-- FIM GRAFICO IDEAL -->
		<div class="col-md-12">
		<div class="panel panel-default">
		<div class="panel-heading">Investimento</div>
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
								<a href="/financial_health/ControleInvestimento?action=editarinv&id=${inv.idInvestimento}" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-pencil"></span>
								</a>
								
							
								<a href="/financial_health/ControleInvestimento?action=excluirinvindex&idinv=${inv.idInvestimento}" class="btn btn-danger btn-sm
								 onclick="return confirm('Deseja excluir este item?');" >
									<span class="glyphicon glyphicon-trash"></span>	 
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
		</div>
			</div>
	
	<div class="col-md-12">
	<div class="panel panel-default">
	<div class="panel-heading">Despesa Fixa</div>
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
					<td>${df.idDespesaFixa }</td>
					<td>${df.nome }  </td>
					<td>${df.valor }  </td>
					<td>${df.dataDespesaFixa }  </td><td>
						<a href="/financial_health/ControleDespesaFixa?action=editardf&id=${df.idDespesaFixa}"  class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
							
						<a href="/financial_health/ControleDespesaFixa?action=excluirdfindex&id=${df.idDespesaFixa}" class="btn btn-danger btn-sm
						 onclick="return confirm('Deseja excluir este item?');" >
							<span class="glyphicon glyphicon-trash"></span>	 
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
	</div>
	</div>
	
		<div class="col-md-12">
		<div class="panel panel-default">
		<div class="panel-heading">Despesa Variavel</div>
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
								<a href="/financial_health/ControleDespesaVariavel?action=editardv&id=${dv.idDespesaVariavel}" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-pencil"></span>
								</a>
									
							
							
								<a href="/financial_health/ControleDespesaVariavel?action=excluirdvindex&id=${dv.idDespesaVariavel}" class="btn btn-danger btn-sm
								 onclick="return confirm('Gostaria de excluir este item?');" >
									<span class="glyphicon glyphicon-trash"></span>	 
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
			</div>
			</div>
			
	
	<!-- Grafico Valor Ideal -->
	 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
	      google.charts.load("current", {packages:["corechart"]});
	      google.charts.setOnLoadCallback(drawVidealChart);
	      google.charts.setOnLoadCallback(drawLancamentoChart);
	      function drawVidealChart() {
	        var data = google.visualization.arrayToDataTable([
	          ['Task', 'Hours per Day'],
	          ['Investimento(${valoresGraficoIdeal[0]})',  ${valoresGraficoIdeal[0]}],
	          ['Despesa Fixa(${valoresGraficoIdeal[1]})',      ${valoresGraficoIdeal[1]}],
	          ['Despesa Variavel(${valoresGraficoIdeal[2]}})',  ${valoresGraficoIdeal[2]}],
	        ]);
	        
	
	        var options = {
	          title: 'Grafico Valor Ideal',
	          is3D: true,
	          colors: ['#41DE11', '#DEDE11', '#FD0404']
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('graficoPorData'));
	        chart.draw(data, options);
	      }
	      
	      function drawLancamentoChart() {

	          var data = google.visualization.arrayToDataTable([
	          ['Task', 'Hours per Day'],
	          ['Investimento(${somainv})',  ${somainv}],
	          ['Despesa Fixa(${somadf})',      ${somadf}],
	          ['Despesa Variavel(${somadv})',  ${somadv}],
	          ]);

	           var options = {
	          	title: 'Grafico Lancamento do Mes',
	         	 is3D: true,
	         	colors: ['#41DE11', '#DEDE11', '#FD0404']
	           };

	          var chart = new google.visualization.PieChart(document.getElementById('graficoLancamento'));
	          chart.draw(data, options);
	      }
   	 </script>
   	 
   	 
	
</body>
</html>