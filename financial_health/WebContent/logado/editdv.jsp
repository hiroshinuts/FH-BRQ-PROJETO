<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- INICIO DO MODAL PARA EDITAR CADASTRO INV - DF - DV -->
	<div class="col-md-12">
	
				
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
	
	<!-- FIM DO MODAL DE EDIT -->

</body>
</html>