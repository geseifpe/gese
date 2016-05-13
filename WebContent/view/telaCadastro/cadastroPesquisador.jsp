<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<form class="form-horizontal" action="../telaInicial.jsp">
							<fieldset>
								<h3 class="text-success">Cadastro de Pesquisador</h3>
								<hr />
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="siape">SIAPE</label>
									<div class="col-md-4">
										<input id="siape" name="siape" type="text"
											class="form-control input-md" maxlength="45"
											placeholder="Digite seu SIAPE" required="required" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="cpf">CPF</label>
									<div class="col-md-4">
										<input id="cpf" name="cpf" type="text"
											class="form-control input-md" maxlength="11"
											placeholder="Digite apenas números" required="required" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="nome">Nome</label>
									<div class="col-md-4">
										<input id="nome" name="nome" type="text"
											class="form-control input-md" maxlength="50"
											placeholder="Digite seu nome completo" required="required" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">Cargo</label>
									<div class="col-md-4">
										<div class="radio">
											<label for="prof"> <input id="prof" type="radio"
												name="cargo" value="p" checked="checked" /> Professor
											</label>
										</div>
										
										<div class="radio">
											<label for="adm"> <input id="adm" type="radio"
												name="cargo" value="a" /> Administrativo
											</label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">Títulação</label>
									<div class="col-md-4">
										<div class="radio">
											<label for="mestrado"> <input id="mestrado"
												type="radio" name="titulacao" value="m" checked="checked" />
												Mestrado
											</label>
										</div>
										
										<div class="radio">
											<label for="doutorado"> <input id="doutorado"
												type="radio" name="titulacao" value="d" /> Doutorado
											</label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">Regime</label>
									<div class="col-md-4">
										<div class="radio">
											<label for="mestre"> <input id="mestre" type="radio"
												name="regime" value="m" checked="checked" /> Mestrado
											</label>
										</div>
										
										<div class="radio">
											<label for="doutor"> <input id="doutor" type="radio"
												name="regime" value="d" /> Doutorado
											</label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="campus">Selecione
										o seu Campus</label>
									<div class="col-md-4">
										<select id="campus" name="campus" class="form-control">
											<option value="afogados">Afogados</option>
											<option value="barreiros">Barreiros</option>
											<option value="beloJardim">Belo Jardim</option>
											<option value="canbo">Cabo</option>
											<option value="caruaru">Caruaru</option>
											<option value="garanhuns">Garanhuns</option>
											<option value="igarassu">Igarassu</option>
											<option value="jaboatao">Jaboatão</option>
											<option value="olinda">Olinda</option>
											<option value="palmares">Palmares</option>
											<option value="paulista">Paulista</option>
											<option value="pesqueira">Pesqueira</option>
											<option value="recife">Recife</option>
											<option value="vitoria">Vitória</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="nascimento">Data
										de nascimento</label>
									<div class="col-md-4">
										<input id="nascimento" name="nascimento" type="date"
											class="form-control input-md" required="required" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">Sexo</label>
									<div class="col-md-4">
										<div class="radio">
											<label for="masculino"> <input type="radio"
												name="radios" id="masculino" value="m" checked="checked" />
												Masculino
											</label>
										</div>
										
										<div class="radio">
											<label for="feminino"> <input type="radio"
												name="radios" id="feminino" value="f" /> Feminino
											</label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="tel">Telefone</label>
									<div class="col-md-4">
										<input id="tel" name="tel" type="text"
											class="form-control input-md" placeholder="Apenas números"
											maxlength="20" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="cel">Celular</label>
									<div class="col-md-4">
										<input id="cel" name="tel" type="text"
											class="form-control input-md" placeholder="Apenas números"
											maxlength="20" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="lattes">Lattes</label>
									<div class="col-md-4">
										<input id="lattes" name="lattes" type="text"
											class="form-control input-md"
											placeholder="Digite o endereço do seu lattes"
											required="required" maxlength="200" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">E-mail 1</label>
									<div class="col-md-4">
										<input name="email" type="email"
											class="form-control input-md email"
											placeholder="Digite seu e-mail" required="required"
											maxlength="45" />
									</div>
									<label class="col-md-2 control-label">Confirmação do
										e-mail 1</label>
									<div class="col-md-4">
										<input name="emailConfirmacao" type="email"
											class="form-control input-md emailConfirmacao"
											placeholder="Confirme seu e-mail" required="required"
											maxlength="45" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">E-mail 2</label>
									<div class="col-md-4">
										<input name="email" type="email"
											class="form-control input-md email"
											placeholder="Digite seu e-mail" required="required"
											maxlength="45" />
									</div>
									<label class="col-md-2 control-label">Confirmação do
										e-mail 2</label>
									<div class="col-md-4">
										<input name="emailConfirmacao" type="email"
											class="form-control input-md emailConfirmacao"
											placeholder="Confirme seu e-mail" required="required"
											maxlength="45" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="senha">Senha</label>
									<div class="col-md-4">
										<input id="senha" name="senha" type="password"
											class="form-control input-md" placeholder="Digite sua senha"
											required="required" />
									</div>
									<label class="col-md-2 control-label" for="senhaConfirmacao">Confirmação
										de senha</label>
									<div class="col-md-4">
										<input id="senhaConfirmacao" name="senhaConfirmacao"
											type="password" placeholder="Confirme sua senha"
											class="form-control input-md" required="required" />
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
</body>
</html>