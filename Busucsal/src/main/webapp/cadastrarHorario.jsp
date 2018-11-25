<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.ucsal.admin.model.Admin"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="assets/img/busucsal_icon.png">

<title>Busucsal</title>

<link href="assets/css/bootstrap.css" rel="stylesheet">

<link href="assets/css/main.css" rel="stylesheet">

</head>

<body>
	<%
		Admin adminLogin = (Admin) session.getAttribute("adminLogin");
	%>
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="ListarAdminHorarioRoteiroServlet"><img
					src="assets/img/busucsal_icon.png" alt="Icone Busucsal" height="55"
					width="55"> Busucsal</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right pt navbar-brand">
					<li><a href="ListarAdminHorarioRoteiroServlet"> <%
 	out.print(adminLogin.getNome());
 %>
					</a></li>
					<li><a href="LogarAdminServlet">Sair</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div id="ww">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4 centered">
					<div class="table-responsive">
						<h2>Cadastrar Horário</h2>
						<br>
						<form action="CadastrarHorarioServlet" method="POST">
							<div class="form-group">
								<label>Horário</label> <input class="form-control"
									type="text" name="horario" />
							</div>
							<div class="form-group">
								<label>Data</label> <input class="form-control" type="text"
									name="data" />
							</div>
							<div class="form-group">
								<label>Roteiro</label> <input class="form-control" type="text"
									name="roteiro" />
							</div>
							<button type="submit" class="btn btn-primary">Inserir</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>


	<div id="footer">
		<div class="container">
			<div class="row">

				<div class="col-lg-5">
					<h4>SOBRE O PROJETO:</h4>
					<h4>
						<a href="https://github.com/guilhermeeng99/Busucsal"
							target="_blank">Repositrio</a>
					</h4>
					<h4>
						<a href="https://www.ucsal.br" target="_blank">Site UCSAL</a>
					</h4>
					<h4>Tel Ucsal: (71) 3203-8800</h4>
				</div>
				<div class="col-lg-6">
					<p>Para melhoria da mobilidade, a UCSAL disponibilizou o
						BUSUCSAL. As rotas e horrios esto disponveis na pgina da
						Universidade e nos murais. Mas se uma viagem atrasar ou se for
						necessria uma mudana de ltima hora, o que fazer? Onde consultar?
						Agora voc acha tudo aqui!</p>

				</div>

			</div>

		</div>
	</div>

</body>
</html>