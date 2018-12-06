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
					<div class="table-responsive">
						<h2>Alterar Horário</h2>
						<br>
						<form action="AlterarHorarioServlet" method="POST">
							<input type="hidden" name="id" value="${horario.id}">
							<div class="form-group">
								<label>Horário</label> <input class="form-control" type="text"
									name="horario" value="${horario.horario}" />
							</div>
							<div class="form-group">
								<label>Data</label> <input class="form-control" type="text"
									name="data" value="${horario.data}" />
							</div>
							<div class="form-group">
								<label>Roteiro</label> <input class="form-control" type="text"
									name="roteiro" value="${horario.roteiro}" />
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