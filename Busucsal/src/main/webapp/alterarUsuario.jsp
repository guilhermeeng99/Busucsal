<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.ucsal.busucsal.model.Usuario"%>
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
		Usuario usuarioLogin = (Usuario) session.getAttribute("usuarioLogin");
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
					<li><a href="ListarUsuarioHorarioRoteiroServlet"> <%
 	out.print(usuarioLogin.getNome());
 %>
					</a></li>
					<li><a href="LogarUsuarioServlet">Sair</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div id="ww">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 centered">
					<div class="table-responsive">
						<h2>Alterar Usu�rio</h2>
						<br>
						<form action="AlterarUsuarioServlet" method="POST">
							<input type="hidden" name="id" value="${horario.id}">
							<div class="form-group">
								<label>Nome</label> <input class="form-control" type="text"
									name="nome" value="${horario.nome}" />
							</div>
							<div class="form-group">
								<label>Login</label> <input class="form-control" type="text"
									name="login" value="${horario.login}" />
							</div>
							<div class="form-group">
								<label>Senha</label> <input class="form-control" type="text"
									name="senha" value="${horario.senha}" />
							</div>
							<button type="submit" class="btn btn-primary">Inserir</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<c:import url="rodape.jsp"></c:import>

</body>
</html>