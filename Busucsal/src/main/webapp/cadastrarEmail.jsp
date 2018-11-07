<!DOCTYPE html>
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
				<div class="col-lg-8 col-lg-offset-2 centered">
					<form action="EmailService" method="post">
						<h2>Cadastrar E-mail:</h2>
						<p>Para receber avisos e mudan�as de h�rarios e rotas:</p>
						<input type="email" name="email" class="form-control"
							placeholder="E-mail do estudante"><br>
						<button type="submit" class="btn btn-success">Cadastrar</button>
						<br>

					</form>
				</div>
			</div>
		</div>
	</div>

	<div id="footer">
		<div class="container">
			<div class="row">

				<div class="col-lg-5">
					<h4>SOBRE O PROJETO:</h4>
					<p><a href="https://github.com/guilhermeeng99/busucsal"
						target="_blank">Reposit�rio</a><br>
					Tel Ucsal: (71) 3203-8800</p>

				</div>
				<div class="col-lg-6">
					<p>Para melhoria da mobilidade, a UCSAL disponibilizou o
						BUSUCSAL. As rotas e hor�rios est�o dispon�veis na p�gina da
						Universidade e nos murais. Mas se uma viagem atrasar ou se for
						necess�ria uma mudan�a de �ltima hora, o que fazer? Onde
						consultar? Agora voc� acha tudo aqui!</p>

				</div>


			</div>

		</div>
	</div>

	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>