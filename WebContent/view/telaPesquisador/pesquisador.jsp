<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Protótipo</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen" />
<script src="resources/js/jquery-2.2.1.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>

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
						à informação</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="http://www.brasil.gov.br/barra#participe">Participe</a></li>
					<li><a href="https://www.servicos.gov.br">Serviços</a></li>
					<li><a href="http://www4.planalto.gov.br/legislacao">Legislação</a></li>
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
					<img src="resources\img\ifpeImagem.png"
						class="img-responsive img-rounded" alt="Logotipo">
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
						<form method="post">
							<input class="btn btn-default mesmo-tamanho" type="submit"
								name="opcao" value="Perfil" /> <input
								class="btn btn-default mesmo-tamanho" type="submit" name="opcao"
								value="Menssagens" /> <input
								class="btn btn-default mesmo-tamanho" type="submit" name="opcao"
								value="Submeter Projeto" /> <input
								class="btn btn-default mesmo-tamanho" type="submit" name="opcao"
								value="Convidar" /> <a href="logout"><input
								class="btn btn-default mesmo-tamanho" type="submit" name="opcao"
								value="Sair" /></a>
						</form>
					</div>

					<%
						String opcao = request.getParameter("opcao");
						if (request.getParameter("opcao") == null) {
					%>
					<jsp:include page="editar_pesquisador.jsp" />

					<%
						} else {
							if (opcao.equals("Perfil")) {
					%>
					<jsp:include page="perfil_pesquisador.jsp" />

					<%
						} else if (opcao.equals("Menssagens")) {
					%>
					<jsp:include page="menssagem_pesquisador.jsp" />

					<%
						} else if (opcao.equals("Submeter Projeto")) {
					%>
					<jsp:include page="submeter_projeto_pesquisador.jsp" />
					<%
						} else if (opcao.equals("Convidar")) {
					%>
					<jsp:include page="convidar_pesquisador.jsp" />

					<%
						} else if (opcao.equals("Sair")) {
								opcao = "http://localhost:8080/Projeto_Pibiti_2016/";
								response.sendRedirect(opcao);
					%>

					<%
						}
						}
					%>

				</div>
			</div>		
		<hr>
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