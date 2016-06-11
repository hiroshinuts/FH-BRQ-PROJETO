
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
     			 </ul>
            </div>
        </div>
    </nav>


       <div class="jumbotron">
  			<div class="container text-center">
    			<h1><font color="white">BRcom</font></h1>      
    			<p><font color="white">Loja Online</font></p>
  			</div>
		</div>
    
    
    <!-- JANELA -->
	<div id="janela" class="modal fade" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					Login			
				</div>
				
				<div class="modal-body"> Informe os dados para login
				<hr/>
				
					<form name="formulario" id="formulario" method="post" action="ControleFuncionario?action=cadastrar">
					
						<label>Email</label>
						<input type="text" name="nome" class="form-control required" placeholder="Email"/> <br>
						
						<label>Senha</label>
						<input type="text" name="salario" class="form-control required" placeholder="senha"/> <br>
						
						
						<input type="submit" value="Login" class="btn btn-success btn-block"/>
						
					</form>						
				</div>
				
				<div class="modal-footer">
							Ainda não tenho conta. <a href="telas/cliente/cadastrocliente.jsp" >Cadastrar</a>
				</div>
				
			</div>		
		</div>	
	</div>


