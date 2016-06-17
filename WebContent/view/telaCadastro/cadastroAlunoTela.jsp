<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br">

<head>
<title>Prot�tipo</title>

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen" />
<script src="resources/js/jquery-2.2.1.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1; charset= UTF-8" />
<link href="resources/css/base.css" rel="stylesheet" type="text/css" />
<script src="resources/js/cadastroJs.js" type="text/javascript"></script>

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
					<img src="resources\img\ifpeImagem.png"
						class="img-responsive img-rounded" alt="Logotipo">
				</div>

			</div>
		</div>
	</div>

	<div class="corpo">
		<div class="section">
			<div class="container">

				<div class="row">

					<div class="col-md-3">
						<h3 class="text-left text-success">O IFPE</h3>
						<hr />
						<ul class="list-group text-primary">
							<li class="list-group-item"><a href="#">Institucional</a></li>
							<li class="list-group-item"><a href="#">Ensino</a></li>
							<li class="list-group-item"><a href="#">Pesquisa e
									Inova��o</a></li>
							<li class="list-group-item"><a href="#">Notic�as</a></li>
							<li class="list-group-item"><a href="#">Calend�rio</a></li>
							<li class="list-group-item"><a href="#">Congressos</a></li>
						</ul>
					</div>

					<div class="col-md-7">
					
						<form method="post" action="inserirAluno" class="form-horizontal">

							<fieldset>
								<h3 class="text-success">Cadastro de Aluno</h3>
								<hr>
								<div class="form-group">
									<label class="col-md-2 control-label" for="nome">Nome</label>
									<div class="col-md-4">
										<input id="nome" name="nome" type="text"
											class="form-control input-md" maxlength="50"
											placeholder="Digite seu nome completo" required="required">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="cpf">CPF</label>
									<div class="col-md-4">
										<input id="cpf" name="cpf" type="text"
											class="form-control input-md" maxlength="11"
											placeholder="Digite apenas n�meros" required="required">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="campusId">Selecione
										o seu Campus</label>
									<div class="col-md-4">
										<select id="campusId" name="campusId" class="form-control">
										
											<c:forEach var="campus" items="${listaCampus}" varStatus="id">
                                                   <option value="${campus.id }">${campus.nome}</option>

											</c:forEach>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="cursoId">Selecione
										o seu Curso</label>
									<div class="col-md-4">
										<select id="cursoId" name="cursoId" class="form-control">
										
											<c:forEach var="curso" items="${listaCurso}" varStatus="id">
                                                   <option value="${curso.id }">${curso.nome}</option>

											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="matricula">Matricula</label>
									<div class="col-md-4">
										<input id="matricula" name="matricula" type="text"
											class="form-control input-md" maxlength="20"
											placeholder="Digite sua matr�cula" required="required">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="nascimento">Data
										de nascimento</label>
									<div class="col-md-4">
										<input id="nascimento" name="nascimento" type="date"
											class="form-control input-md" required="required">
									</div>
								</div>

								<div class="form-group text-left">
									<label class="col-md-2 control-label">Sexo</label>
									<div class="col-md-5">

										<div class="radio">
											<label for="masculino"> <input type="radio"
												name="sexo" id="masculino" value="m" checked="checked" />Masculino
											</label>
										</div>

										<div class="radio">
											<label for="feminino"> <input type="radio"
												name="sexo" id="feminino" value="f" />Feminino
											</label>
										</div>

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="telefone">Telefone</label>
									<div class="col-md-4">
										<input id="telefone" name="telefone" type="text"
											class="form-control input-md" placeholder="Apenas n�meros"
											maxlength="20">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="celular">Celular</label>
									<div class="col-md-4">
										<input id="celular" name="celular" type="text"
											class="form-control input-md" placeholder="Apenas n�meros"
											maxlength="20">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="linklattes">lattes</label>
									<div class="col-md-4">
										<input id="linklattes" name="linklattes" type="text"
											class="form-control input-md" placeholder="Digite sue Lattes"
											maxlength="200">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="email">E-mail</label>
									<div class="col-md-4">
										<input id="email" name="email" type="email"
											class="form-control input-md" placeholder="Digite seu e-mail"
											required="required" maxlength="45">
									</div>

									<label class="col-md-2 control-label" for="emailConfirmacao">Confirma��o
										do e-mail</label>
									<div class="col-md-4">
										<input id="emailConfirmacao" name="emailConfirmacao"
											type="email" placeholder="Confirme seu e-mail"
											class="form-control input-md" required="required"
											maxlength="45">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="password">Senha</label>
									<div class="col-md-4">
										<input id="password" name="password" type="password"
											class="form-control input-md" placeholder="Digite sua senha"
											required="required">
									</div>

									<label class="col-md-2 control-label" for="senhaConfirmacao">Confirma��o
										de senha</label>
									<div class="col-md-4">
										<input id="senhaConfirmacao" name="senhaConfirmacao"
											type="password" placeholder="Confirme sua senha"
											class="form-control input-md" required="required">
									</div>
								</div>

								<!-- Button -->
								<div class="form-group">
									<label class="col-md-2 control-label" for="submit">Se
										j� concluiu clique aqui:</label>
									<div class="col-md-8">
										<input type="submit" id="submit" name="submit"
											class="btn btn-success" value="Enviar"></input>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
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