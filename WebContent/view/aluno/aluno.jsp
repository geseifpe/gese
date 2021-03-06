<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br">
<head>
<title>${aluno.nome}</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen" />
<script src="resources/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="resources/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" />

<script type="text/javascript">
	$(document).ready(function() {
		$("#perfil").show();
		$("#editar").hide();
		$("#mensagem").hide();
		$("#frequencia").hide();

	});

	function exibirinclude(id) {
		var e = document.getElementById(id);

		$("#perfil").hide();
		$("#editar").hide();
		$("#mensagem").hide();
		$("#frequencia").hide();
		$("#" + id).show();
	}
</script>

<meta name="viewport"
	content="width=device-width, initial-scale=1; charset= UTF-8" />
<link href="resources/css/base.css" rel="stylesheet" type="text/css" />
</head>
<body data-spy="scroll">
	<div class="navbar navbar-default navbar-static-top top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-ex-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="http://www.brasil.gov.br"><img
					id="brasil" alt="Brasil" src="resources\img\Brasilmage.png"><span>BRASIL</span></a>
				<a class="navbar-brand"
					href="http://brasil.gov.br/barra#acesso-informacao"><span>Acesso
						� informa��o</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="http://www.brasil.gov.br/barra#participe">Participe</a></li>
					<li><a href="https://www.servicos.gov.br">Servi�os</a></li>
					<li><a href="http://www4.planalto.gov.br/legislacao">Legisla��o</a></li>
					<li class=""><a
						href="http://www.brasil.gov.br/barra#orgaos-atuacao-canais">Canais</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="section bandeira">
		<div class="container">
			<div class="row">
				<div class="col-md-3 text-justify">
					<img src="resources\img\IFPELogo.png"
						class="img-responsive img-rounded" alt="Logotipo" />
				</div>
			</div>
		</div>
	</div>
	<div class="corpo">
		<div class="section">
			<hr />
			<div class="row">
				<div class="col-md-3 text-left">
					<!-- Menu Principal -->

					<ul style="list-style-type: none">
						<li><input class="btn btn-default mesmo-tamanho"
							type="submit" name="opcao" value="Perfil"
							onclick="exibirinclude('perfil')" /></li>
						<li><input class="btn btn-default mesmo-tamanho"
							type="button" name="opcao" onclick="exibirinclude('editar')"
							value="Editar" /></li>
						<li><input class="btn btn-default mesmo-tamanho"
							type="button" name="opcao" value="Mensagens"
							onclick="exibirinclude('mensagem')" /></li>
						<li><input class="btn btn-default mesmo-tamanho"
							type="submit" name="opcao" value="Relat�rio Mensal"
							onclick="exibirinclude('frequencia')" /></li>
						<li><a href="logout"> <input
								class="btn btn-default mesmo-tamanho" type="submit" name="opcao"
								value="Sair" /></a></li>
					</ul>
				</div>

				<div id="perfil">
					<jsp:include page="perfilAluno.jsp" />
				</div>

				<div id="editar">
					<jsp:include page="editarAluno.jsp" />
				</div>

				<div id="mensagem">
					<jsp:include page="menssagemAluno.jsp" />
				</div>

				<div id="frequencia">
					<jsp:include page="frequenciaMensalAluno.jsp" />
				</div>
			</div>
		</div>
		<hr />
	</div>
	<footer class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h4>
						Desenvolvido com Bootstrap por <a href="#">Diogo Brito</a>
					</h4>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>