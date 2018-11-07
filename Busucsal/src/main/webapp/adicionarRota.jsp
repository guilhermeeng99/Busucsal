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
		</div>
	</div>

	<div id="ww">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4 centered">
					<div class="table-responsive">
		<form action="InserirRota" method="POST">
			<div class="form-group">
				<label>Roteiro</label> <input class="form-control" type="text"
					name="roteiro" />
			</div>
			<div class="form-group">
				<label>Saída</label> <input class="form-control" type="text"
					name="saida" />
			</div>
			<div class="form-group">
				<label>Paradas</label> <input class="form-control" type="text"
					name="paradas" />
			</div>
			<button type="submit" class="btn btn-primary mb-2">Inserir</button>
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