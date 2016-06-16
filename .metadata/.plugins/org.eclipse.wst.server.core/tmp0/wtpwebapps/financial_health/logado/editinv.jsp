<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/financial_health/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" type="text/css" href="/financial_health/css/business-casual.css" />

<!-- Arquivos Javascript -->
<script type="text/javascript" src="/financial_health/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/financial_health/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/financial_health/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/financial_health/js/messages_pt_BR.min.js"></script>
<script type="text/javascript">

$(document).ready( //quando a página carregar...
function(){ //faça..
//validar o formulário..
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
<body>
<jsp:include page="/template/topo.jsp"></jsp:include>

	<h5><label>Usuario: </label> ${usuariologado.nome} <br/></h5>
		<h5><a href="/financial_health/logado/indexlogado.jsp">Voltar</a> para a página inicial.</h5>
	<hr/>

<!-- INICIO DO MODAL PARA EDITAR CADASTRO INV - DF - DV -->
	<div class="col-md-12">
				<div class="col-md-4">
					<div class="box">
					Preencha os campos abaixo para Editar:
					<hr/>
					
					<form name="formulario" method="post" action="/financial_health/ControleInvestimento?action=atualizarinv&id=${dadosi.idInvestimento}" >
						
						<label>Id</label><br/>
						<input type="text" name="idinvestimento" value="${dadosi.idInvestimento}" class="form-control" readonly="idInvestimento"/>
						<label>Nome do Investimento</label>
						<input type="text" name="nome" class="form-control" value="${dadosi.nome }"/>
						<br/>
						<label>Valor:</label>
						<input type="number" name="valor" class="form-control" value="${dadosi.valor }"/>
						<br/>
						
						<label>Data do Investimento</label><br/>
						<input  type="date" name="datainvestimento" class="form-control required"  value="${dadosi.dataInvestimento}"/>
						<br/><br/>
						
						
						<input type="submit" value="Cadastrar" class="btn btn-success" />
						
					</form>
					</div>
			</div>	
				
		</div>
	
	<!-- FIM DO MODAL DE EDIT -->

</body>
</html>