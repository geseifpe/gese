<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br">
<head>
<title>gese</title>

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen" />
<link href="resources/css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="resources/js/jquery-3.1.1.min.js" type="text/javascript"></script>

<script src="resources/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
	
<script type="text/javascript" src="resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<link type="text/css" rel="stylesheet" href="resources/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" />

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
	<div class="container">
		<div class="row">
			<div class="col-md-5">									
				<div class="col-md-12">
				<i class="fa fa-2x text-success fa-university"> Portal para
					Programas de Inicia��o Cient�fica, Tecnol�gica e de Incentivo
					Acad�mico do IFPE</i>
					<hr />
					<a class="btn btn-success btn-lg" href="/gese" style="color: white;">Retornar</a>
				</div>
			</div>
			
			<div class="col-md-7">

				<form method="post" action="inserirAluno" class="form-horizontal"
					data-toggle="validator">

					<fieldset>
						<h3 class="text-success">Cadastro de Aluno</h3>
						<hr />
						<div class="form-group">
							<label class="col-md-3 control-label" for="nome">Nome</label>
							<div class="col-md-4">
								<input id="nome" name="nome" type="text"
									class="form-control input-md" maxlength="50"
									placeholder="Digite seu nome completo" required="required"
									data-error="Por favor, informe seu Nome" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="cpf">CPF</label>
							<div class="col-md-4">
								<input id="cpf" name="cpf" type="text"
									class="form-control input-md" maxlength="11"
									placeholder="Digite apenas n�meros" required="required"
									data-error="Por favor, informe seu CPF"/>
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="campus_id">Campus</label>
							<div class="col-md-4">
								<select id="campus_id" name="campus_id" class="form-control">

									<c:forEach var="campus" items="${listaCampus}" varStatus="id">
										<option value="${campus.id}">${campus.cidade}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="curso_id">Curso</label>
							<div class="col-md-4">
								<select id="curso_id" name="curso_id" class="form-control">

									<c:forEach var="curso" items="${listaCurso}" varStatus="id">
										<option value="${curso.id}">${curso.nome}</option>																			
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="matricula">Matricula</label>
							<div class="col-md-4">
								<input id="matricula" name="matricula" type="text"
									class="form-control input-md" maxlength="20"
									placeholder="Digite sua matr�cula" required="required" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-3 control-label" for="nascimento">Data
								de Nascimento</label>
							<div class="col-md-4">
								<input id="nascimento" name="nascimento" type="text"
									class="form-control input-md" required="required"
									data-error="Por favor, informe sua data de nascimento" />
									<script>
									$('#nascimento').datepicker({
										format: "dd-mm-yyyy",
									    startView: 2,
									    maxViewMode: 2,
									    autoclose: true,
										language: "pt-BR"
									});
									</script>
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="sexo">Sexo</label>
							<div class="col-md-4">
								<select id="sexo" name="sexo" class="form-control">
									<option value="M">Masculino</option>

									<option value="F">Feminino</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="telefone">Telefone</label>
							<div class="col-md-4">
								<input id="telefone" name="telefone" type="text"
									class="form-control input-md" placeholder="Apenas n�meros"
									maxlength="20" data-error="Por favor, informe seu Telefone" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="celular">Celular</label>
							<div class="col-md-4">
								<input id="celular" name="celular" type="text"
									class="form-control input-md" placeholder="Apenas n�meros"
									maxlength="20" data-error="Por favor, informe seu celular" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="linklattes">lattes</label>
							<div class="col-md-4">
								<input id="linklattes" name="linklattes" type="text"
									class="form-control input-md" placeholder="Digite seu Lattes"
									maxlength="200"
									data-error="Por favor, informe seu link do lattes" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="email">E-mail</label>
							<div class="col-md-4">
								<input id="email" name="email" type="email"
									class="form-control input-md" placeholder="Digite seu e-mail"
									required="required" maxlength="45"
									data-error="Por favor, informe seu e-mail" />
								<div class="help-block with-errors"></div>
							</div>
							<div class="col-md-4">
								<input id="emailConfirmacao" name="emailConfirmacao"
									type="email" placeholder="Confirme seu e-mail"
									class="form-control input-md" required="required"
									maxlength="45" data-match="#email"
									data-match-error="Aten��o! Os e-mails n�o s�o iguais." />
								<div class="with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="password">Senha</label>
							<div class="col-md-4">
								<input id="password" name="password" data-minlenght="6"
									type="password" class="form-control input-md"
									placeholder="Digite sua senha" required="required" />
								<div class="help-block">M�nimo de seis (6) digitos</div>
							</div>
							<div class="col-md-4">
								<input id="confirmPassword" name="confirmPassword"
									type="password" placeholder="Confirme sua senha"
									class="form-control" required="required" data-match="#password"
									data-match-error="Aten��o! As senhas n�o s�o iguais." />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label" for="submit">Se j�
								concluiu clique aqui:</label>
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
	<hr />
	<script src="resources/js/validator.min.js" type="text/javascript"></script>
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