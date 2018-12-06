<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.ucsal.busucsal.model.Admin"%>
<html>

<c:import url="cabecalho.jsp"></c:import>

<body>
	<%
		Admin adminLogin = (Admin) session.getAttribute("adminLogin");
	%>

	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
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
								<th>Alterar</th>
								<th>Remover</th>
								<th>Adicionar</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="h" items="${horario}">
								<tr>
									<td>${h.id}</td>
									<td>${h.horario}</td>
									<td>${h.data}</td>
									<td>${h.roteiro}</td>
									<td><a href="AlterarHorarioServlet?id=${h.id}">ALTERAR</a></td>
									<td><a href="RemoverHorarioServlet?id=${h.id}">REMOVER</a></td>
									<td><a href="cadastrarHorario.jsp">ADICIONAR</a></td>

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
								<th>Alterar</th>
								<th>Remover</th>
								<th>Adicionar</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="r" items="${roteiro}">
								<tr>
									<td>${r.id}</td>
									<td>${r.rota}</td>
									<td>${r.saida}</td>
									<td>${r.parada}</td>
									<td><a href="AlterarRoteiroServlet?id=${r.id}">ALTERAR</a></td>
									<td><a href="RemoverRoteiroServlet?id=${r.id}">REMOVER</a></td>
									<td><a href="cadastrarRoteiro.jsp">ADICIONAR</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-lg-8 col-lg-offset-2 centered">
					<h2>Tabela de Usuários</h2>
					<br>
					<table>
						<thead>
							<tr>
								<th>Id</th>
								<th>Rota</th>
								<th>Saída</th>
								<th>Parada</th>
								<th>Alterar</th>
								<th>Remover</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="u" items="${usuario}">
								<tr>
									<td>${u.id}</td>
									<td>${u.nome}</td>
									<td>${u.login}</td>
									<td>${u.senha}</td>
									<td><a href="AlterarUsuarioServlet?id=${r.id}">ALTERAR</a></td>
									<td><a href="RemoverUsuarioServlet?id=${r.id}">REMOVER</a></td>
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