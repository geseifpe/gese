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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="resources/js/jquery-3.1.1.min.js" type="text/javascript"></script>

<script src="resources/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>	

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
					<img src="resources\img\IFPELogo.png"
						class="img-responsive img-rounded" alt="Logotipo" />
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<h3 class="text-left text-success"></h3>
				<i class="fa fa-2x text-success fa-university"> Portal para
					Programas de Iniciação Científica, Tecnológica e de Incentivo
					Acadêmico do IFPE</i>
				<hr />
				<a class="btn btn-primary btn-lg" href="/gese" style="color: white;">Retornar</a>
			</div>
			<div class="col-md-7">
				<form class="form-horizontal" action="inserirPesquisador"
					method="post" data-toggle="validator" role="form">
					<fieldset>
						<h3 class="text-success">Cadastro de Pesquisador</h3>
						<hr />

						<div class="form-group">
							<label class="col-md-2 control-label" for="siape">SIAPE</label>
							<div class="col-md-4">
								<input id="siape" name="siape" type="text"
									class="form-control input-md" maxlength="45"
									placeholder="Digite seu SIAPE" required="required"
									data-error="Por favor, informe seu SIAPE" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="cpf">CPF</label>
							<div class="col-md-4">
								<input id="cpf" name="cpf" type="text"
									class="form-control input-md" maxlength="11"
									placeholder="Digite apenas números" required="required"
									data-error="Por favor, informe seu CPF" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="nome">Nome</label>
							<div class="col-md-4">
								<input id="nome" name="nome" type="text"
									class="form-control input-md" maxlength="50"
									placeholder="Digite seu nome completo" required="required"
									data-error="Por favor, informe seu nome" />
								<div class="help-block with-errors"></div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="cargo">Cargo</label>
							<div class="col-md-4">
								<select id="cargo" name="cargo" class="form-control">
									<option value="P">Professor</option>

									<option value="A">Administrativo</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="titulacao">Titulação</label>
							<div class="col-md-4">
								<select id="titulacao" name="titulacao" class="form-control">
									<option value="M">Mestrado</option>

									<option value="D">Doutorado</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="regime">Regime</label>
							<div class="col-md-4">
								<select id="regime" name="regime" class="form-control">
									<option value="20">20 Horas</option>

									<option value="40">40 Horas</option>

									<option value="DE">D.E.</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="campus_id">Campus</label>
							<div class="col-md-4">
								<select id="campus_id" name="campus_id" class="form-control">

									<c:forEach var="campus" items="${listaCampus}" varStatus="id">
										<option value="${campus.id}">${campus.cidade}</option>

									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="sexo">Sexo</label>
							<div class="col-md-4">
								<select id="sexo" name="sexo" class="form-control">
									<option value="m">Masculino</option>

									<option value="f">Feminino</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="telefone">Telefone</label>
							<div class="col-md-4">
								<input id="telefone" name="telefone" type="text"
									class="form-control" placeholder="Apenas números"
									maxlength="20" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="celular">Celular</label>
							<div class="col-md-4">
								<input id="celular" name="celular" type="text"
									class="form-control" placeholder="Apenas números"
									maxlength="20" data-error="Por favor, informe seu celular"
									required="required" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="linklattes">Lattes</label>
							<div class="col-md-4">
								<input id="linklattes" name="linklattes" type="text"
									class="form-control"
									placeholder="Digite o endereço do seu lattes"
									required="required" maxlength="200"
									data-error="Por favor, informe seu lattes" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="email1">E-mail
								1</label>
							<div class="col-md-4">
								<input id="email1" name="email1" type="email"
									class="form-control" placeholder="Digite seu e-mail"
									required="required" maxlength="45"
									data-error="Por favor, informe seu email" />
								<div class="help-block with-errors"></div>
							</div>
							<div class="col-md-4">
								<input id="emailConfirmacao1" name="emailConfirmacao1"
									type="email" class="form-control input-md"
									placeholder="Confirme seu e-mail" required="required"
									maxlength="45" data-match="#email1"
									data-match-error="Atenção! Os e-mails não são iguais." />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="email2">E-mail
								2</label>
							<div class="col-md-4">
								<input id="email2" name="email2" type="email"
									class="form-control" placeholder="Digite seu e-mail"
									maxlength="45"
									data-error="Por favor, informe um e-mail correto." />
								<div class="help-block with-errors"></div>
							</div>
							<div class="col-md-4">
								<input name="emailConfirmacao2" id="emailConfirmacao2"
									type="email" class="form-control input-md"
									placeholder="Digite seu e-mail" maxlength="45"
									data-match="#email2"
									data-match-error="Atenção! Os e-mails não são iguais." />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="password">Senha</label>
							<div class="col-md-4">
								<input id="password" name="password" data-minlenght="6"
									type="password" class="form-control input-md"
									placeholder="Digite sua senha" required="required" />
								<div class="help-block">Mínimo de seis (6) digitos</div>
							</div>
							<div class="col-md-4">
								<input id="confirmPassword" name="confirmPassword"
									type="password" placeholder="Confirme sua senha"
									class="form-control" required="required" data-match="#password"
									data-match-error="Atenção! As senhas não são iguais." />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<!-- Button -->
						<div class="form-group">
							<label class="col-md-2 control-label" for="submit">Se já
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