<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br">
<head>
<title>Protótipo</title>

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
					<img src="resources\img\ifpeImagem.png" class="img-responsive img-rounded"
						alt="Logotipo" />
				</div>
			</div>
		</div>
	</div>
	<div class="corpo">
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-3 text-left">
						<h3 class="text-left text-success">O IFPE</h3>
						<hr />
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
					
					<div class="col-md-8">
						<form class="form-horizontal" action="inserirPesquisador" method="post"
						data-toggle="validator" role="form">
							<fieldset>
								<h3 class="text-success">Cadastro de Pesquisador</h3>
								<hr />
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="siape">SIAPE</label>
									<div class="col-md-4">
										<input id="siape" name="siape" type="text"
											class="form-control input-md" maxlength="45"
											placeholder="Digite seu SIAPE" required="required" 
											data-error="Por favor, informe seu SIAPE"/>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="cpf">CPF</label>
									<div class="col-md-4">
										<input id="cpf" name="cpf" type="text"
											class="form-control input-md" maxlength="11"
											placeholder="Digite apenas números" required="required"
											data-error="Por favor, informe seu CPF"/>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="nome">Nome</label>
									<div class="col-md-4">
										<input id="nome" name="nome" type="text"
											class="form-control input-md" maxlength="50"
											placeholder="Digite seu nome completo" required="required"
											data-error="Por favor, informe seu nome"/>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">Cargo</label>
									<div class="col-md-4">
										<div class="radio">
											<label for="professor"> <input id="professor" type="radio"
												name="cargo" value="P" checked="checked" /> Professor
											</label>
										</div>
										
										<div class="radio">
											<label for="administrativo"> <input id="administrativo" type="radio"
												name="cargo" value="A" /> Administrativo
											</label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">Titulação</label>
									<div class="col-md-4">
										<div class="radio">
											<label for="mestrado"> <input id="mestrado"
												type="radio" name="titulacao" value="M" checked="checked" />
												Mestrado
											</label>
										</div>
										
										<div class="radio">
											<label for="doutorado"> <input id="doutorado"
												type="radio" name="titulacao" value="D" /> Doutorado
											</label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">Regime</label>
									<div class="col-md-4">
										<div class="radio">
											<label for="20h"> <input id="20h" type="radio"
												name="regime" value="20" checked="checked" /> 20 Horas
											</label>
										</div>
										
										<div class="radio">
											<label for="40h"> <input id="40h" type="radio"
												name="regime" value="40" /> 40 Horas
											</label>
										</div>
										<div class="radio">
											<label for="DE"> <input id="DE" type="radio"
												name="regime" value="DE" /> D.E.
											</label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="campusId">Informe
										seu Campus</label>
									<div class="col-md-4">
										<select id="campusId" name="campusId" class="form-control">

											<c:forEach var="campus" items="${listaCampus}" varStatus="id">
												<option value="${campus.id}">${campus.nome}</option>

											</c:forEach>
										</select>
									</div>
								</div>
																
								<div class="form-group">
									<label class="col-md-2 control-label">Sexo</label>
									<div class="col-md-4">
										<div class="radio">
											<label for="masculino"> <input type="radio"
												name="sexo" id="masculino" value="M" checked="checked" />
												Masculino
											</label>
										</div>
										
										<div class="radio">
											<label for="feminino"> <input type="radio"
												name="sexo" id="feminino" value="F" /> Feminino
											</label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="telefone">Telefone</label>
									<div class="col-md-4">
										<input id="telefone" name="telefone" type="text"
											class="form-control" placeholder="Apenas números"
											maxlength="20"/>										
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="celular">Celular</label>
									<div class="col-md-4">
										<input id="celular" name="celular" type="text"
											class="form-control" placeholder="Apenas números"
											maxlength="20" data-error="Por favor, informe seu celular"
											required="required"/>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="linklattes">Lattes</label>
									<div class="col-md-4">
										<input id="linklattes" name="linklattes" type="text"
											class="form-control"
											placeholder="Digite o endereço do seu lattes"
											required="required" maxlength="200" data-error="Por favor, informe seu lattes"/>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="email1">E-mail 1</label>
									<div class="col-md-4">
										<input id="email1" name="email1" type="email"
											class="form-control"
											placeholder="Digite seu e-mail" required="required"
											maxlength="45" data-error="Por favor, informe seu email"/>
										<div class="help-block with-errors"></div>
									</div>									
									<div class="col-md-4">
										<input id="emailConfirmacao1" name="emailConfirmacao1" type="email"
											class="form-control input-md"
											placeholder="Confirme seu e-mail" required="required"
											maxlength="45" data-match="#email1" data-match-error="Atenção! Os e-mails não são iguais."/>
											<div class="help-block with-errors"></div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="email2">E-mail 2</label>
									<div class="col-md-4">
										<input id="email2" name="email2" type="email"
											class="form-control" placeholder="Digite seu e-mail" maxlength="45"
											data-error="Por favor, informe um e-mail correto."/>
											<div class="help-block with-errors"></div>
									</div>									
									<div class="col-md-4">
										<input name="emailConfirmacao2" id="emailConfirmacao2" 
											type="email" class="form-control input-md" placeholder="Digite seu e-mail"
											 maxlength="45" data-match="#email2" data-match-error="Atenção! Os e-mails não são iguais."/>
											<div class="help-block with-errors"></div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="password">Senha</label>
									<div class="col-md-4">
										<input id="password" name="password" data-minlenght="6" type="password"
											class="form-control input-md" placeholder="Digite sua senha"
											required="required" />
											<div class="help-block">Mínimo de seis (6) digitos</div>
									</div>									
									<div class="col-md-4">
										<input id="confirmPassword" name="confirmPassword"
											type="password" placeholder="Confirme sua senha"
											class="form-control" required="required"
											data-match="#password" data-match-error="Atenção! As senhas não são iguais."/>
											<div class="help-block with-errors"></div>
									</div>
								</div>
								
								<!-- Button -->
								<div class="form-group">
									<label class="col-md-2 control-label" for="submit">Se
										já concluiu clique aqui:</label>
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
	<script src="resources/js/validator.min.js" type="text/javascript"></script>
</body>
</html>