<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="org.w3c.dom.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br">
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
<script src="resources/js/base.js"></script>
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
					id="brasil" alt="Brasil" src="resources\img\Brasilmage.png" /><span>BRASIL</span></a>
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
						class="img-responsive img-rounded" alt="Logotipo" />
				</div>
			</div>
		</div>
	</div>

	<div class="corpo">
		<div class="section">
			<div class="container acesso">
				<div class="row">

					<div class="col-md-5">
						<h3 class="text-left text-success">Portal para Programas de
							Iniciação Científica, Tecnológica e de Incentivo Acadêmico do
							IFPE</h3>
						<i class="fa fa-3x fa-fw text-success fa-university"></i>
					</div>

					<div class="col-md-5">
						<form class="form-horizontal" method="post" action="loginAluno">
							<h3 class="text-left text-success">Acesso</h3>
							<hr />
							<fieldset>
								<div class="form-group login">
									<div class="col-md-12" style="${display}" >
										<div class="alert alert-danger" >
											<strong> ${mensagem}</strong>
										</div>
									</div>
									<div class="col-md-5">
										<input id="cpf" name="cpf" type="text"
											placeholder="Digite seu CPF" class="form-control input-md"
											required="required" maxlength="11" />
									</div>

									<div class="col-md-5">
										<input id="password" name="password" type="password"
											placeholder="Digite sua senha" class="form-control input-md"
											required="required" />
									</div>

									<div class="col-md-2">

										<div class="dropdown">

											<input type="submit" id="submit" name="submit"
												class="btn btn-success" value="Entrar"></input>

										</div>
									</div>

									<div class="col-md-6">
										<label class="checkbox-inline" for="lembrar"> <input
											type="checkbox" name="lembrar" id="lembrar" value="" />Lembrar-me
										</label>
									</div>
							</fieldset>
							<hr />
						</form>

						<div class="col-md-3">

							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">
									Cadastre-se <span></span>
								</button>

								<ul class="dropdown-menu">
									<li><a href="cadastroAlunoTela">Aluno</a></li>
									<li><a href="cadastroPesquisador">Pesquisador</a></li>
								</ul>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-3 text-left">
					<!--Título-->
					<h3 class="text-left text-success">O IFPE</h3>
					<hr />

					<!--Menu de opções-->
					<ul class="list-group text-primary">
						<li class="list-group-item"><a href="#">Institucional</a></li>
						<li class="list-group-item"><a href="#">Ensino</a></li>
						<li class="list-group-item"><a href="#">Pesquisa e
								Inovação</a></li>
						<li class="list-group-item"><a href="#">Noticías</a></li>
						<li class="list-group-item"><a href="#">Calendário</a></li>
						<li class="list-group-item"><a href="#">Congressos</a></li>
					</ul>

				</div>

				<div class="col-md-7">
					<!--Notícias-->
					<h3 class="text-success">Notícias</h3>
					<hr />

					<div class="row">
						<div class="col-md-6">
							<a href="#"><img src="resources\img\noticiaComum1.png"
								class="img-responsive" alt="Notícias" />
								<h4>III Encontro de Extensão reúne comunidade acadêmica</h4>
								<p>Troca de experiências extensionistas acontece no Campus
									Pesqueira.</p> </a>
						</div>

						<div class="col-md-6">
							<a href="javascript:void(0);"><img
								src="resources\img\noticiaComum2.png" class="img-responsive"
								alt="Notícias" />
								<h4>Consup | Nota Oficial sobre correção do regulamento
									eleitoral</h4>
								<p>Retificação nos critérios da lista de eleitores aptos
									atende à decisão tomada pelo colegiado em outubro. Por um erro,
									definição não foi contempla.</p></a>
						</div>
					</div>

					<div class="row noticiaBaixo">
						<div class="col-md-6">
							<hr class="linhaBaixo" />
							<a href="#"><img src="resources\img\noticiaComum3.png"
								class="img-responsive" alt="Notícias" />
								<h4>Atletas do IFPE são recebidos pela reitora</h4>
								<p>Os medalhistas na etapa nacional dos JIF´s 2015 foram
									parabenizados pela equipe gestora. Grupo agradeceu apoio
									recebido pela instituição.</p></a>
						</div>

						<div class="col-md-6">
							<hr class="linhaBaixo" />
							<a href="#"><img src="resources\img\noticiaComum4.png"
								class="img-responsive" alt="Notícias" />
								<h4>INOVA IFPE: Equipes multidisciplinares apresentam
									produtos finais</h4>
								<p>Grupos criaram soluções inovadoras para problemas que
									surgiram após o desastre em Mariana (MG).</p></a>
						</div>
					</div>

				</div>
			</div>
			<hr />
		</div>
	</div>
	<footer class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h4>
						Desenvolvido com Bootstrap por <a href="#">Diogo Brito </a>
					</h4>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>