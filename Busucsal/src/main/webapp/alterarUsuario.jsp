<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.ucsal.busucsal.model.Usuario"%>
<html>

<c:import url="cabecalho.jsp"></c:import>

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
						<h2>Alterar Usuário</h2>
						<br>
						<form action="AlterarUsuarioServlet" method="POST">
							<input type="hidden" name="id" value="${usuarioLogin.id}">
							<div class="form-group">
								<label>Nome</label> <input class="form-control" type="text"
									name="nome" value="${usuarioLogin.nome}" />
							</div>
							<div class="form-group">
								<label>Login</label> <input class="form-control" type="text"
									name="login" value="${usuarioLogin.login}" />
							</div>
							<div class="form-group">
								<label>Senha</label> <input class="form-control" type="text"
									name="senha" value="${usuarioLogin.senha}" />
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