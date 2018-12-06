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
				<a class="navbar-brand" href="ListarUsuarioHorarioRoteiroServlet"><img
					src="assets/img/busucsal_icon.png" alt="Icone Busucsal" height="55"
					width="55"> Busucsal</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right pt navbar-brand">
					<li><a href="ListarUsuarioServlet"> <%
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
					<h2>Tabela de Horários</h2>
					<br>
					<table>
						<thead>
							<tr>
								<th>Id</th>
								<th>Horário</th>
								<th>Data</th>
								<th>Roteiro</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="h" items="${horario}">
								<tr>
									<td>${h.id}</td>
									<td>${h.horario}</td>
									<td>${h.data}</td>
									<td>${h.roteiro}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-lg-8 col-lg-offset-2 centered">
					<h2>Tabela de Roteiros</h2>
					<br>
					<table>
						<thead>
							<tr>
								<th>Id</th>
								<th>Rota</th>
								<th>Saída</th>
								<th>Parada</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="r" items="${roteiro}">
								<tr>
									<td>${r.id}</td>
									<td>${r.rota}</td>
									<td>${r.saida}</td>
									<td>${r.parada}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<c:import url="rodape.jsp"></c:import>

</body>
</html>