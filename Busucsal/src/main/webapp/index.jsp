<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="assets/img/ucsalLogo.jpg">

<title>Busucsal</title>

<link href="assets/css/bootstrap.css" rel="stylesheet">


<link href="assets/css/main.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="assets/js/hover.zoom.js"></script>
<script src="assets/js/hover.zoom.conf.js"></script>

</head>

<body>



	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="ListaServlet">BUSUCSAL</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logarAdministrador.jsp">Logar Administrador</a></li>
					<li><a href="cadastrarEmail.jsp">Cadastrar E-mail</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div id="ww">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 centered">
					<h2>Tabela de Horário</h2>
					<div class="table-responsive">
						<table class="table table-bordered">
							<tr>
								<th>Id</th>
								<th>Roteiro</th>
								<th>Dia</th>
								<th>Horário</th>
							</tr>
							<c:forEach var="h" items="${horario}">
								<tr>
									<td>${h.id}</td>
									<td>${h.roteiro}</td>
									<td>${h.data}</td>
									<td>${h.horario}</td>
								</tr>
							</c:forEach>

						</table>
					</div>

				</div>
				<div class="col-lg-8 col-lg-offset-2 centered">
					<h2>Tabela de Roteiro</h2>
					<div class="table-responsive">
						<table class="table table-bordered">
							<tr>
								<th>Id</th>
								<th>Roteiro</th>
								<th>Saída</th>
								<th>Parada</th>
							</tr>
							<c:forEach var="r" items="${rota}">
								<tr>
									<td>${r.id}</td>
									<td>${r.roteiro}</td>
									<td>${r.saida}</td>
									<td>${r.paradas}</td>
								</tr>
							</c:forEach>

						</table>
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
					<p>
						<a href="https://github.com/guilhermeeng99/busucsal"
							target="_blank">Repositório</a><br> Tel Ucsal: (71)
						3203-8800
					</p>
				</div>
				<div class="col-lg-6">
					<p>Para melhoria da mobilidade, a UCSAL disponibilizou o
						BUSUCSAL. As rotas e horários estão disponíveis na página da
						Universidade e nos murais. Mas se uma viagem atrasar ou se for
						necessária uma mudança de última hora, o que fazer? Onde
						consultar? Agora você acha tudo aqui!</p>

				</div>

			</div>

		</div>
	</div>

	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>