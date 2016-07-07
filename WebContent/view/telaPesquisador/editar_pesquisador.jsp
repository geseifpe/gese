<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-8">
	<form class="form-horizontal" action="updatePesquisador" method="post"
		data-toggle="validator" role="form">
		<fieldset>
			<h3 class="text-success">Editar Pesquisador</h3>
			<hr />

			<div class="form-group">
				<label class="col-md-2 control-label" for="siape">SIAPE</label>
				<div class="col-md-4">
					<input id="siape" name="siape" type="text"
						class="form-control input-md" maxlength="45"
						value="${pesquisador.siape}"
						placeholder=" Digite seu
						SIAPE" required="required"
						data-error="Por favor, informe seu SIAPE" />
					<div class="help-block with-errors"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="cpf">CPF</label>
				<div class="col-md-4">
					<input id="cpf" name="cpf" type="text"
						class="form-control input-md" maxlength="11"
						value="${pesquisador.cpf}"
						placeholder=" Digite apenas
						números" required="required"
						data-error="Por favor, informe seu CPF" />
					<div class="help-block with-errors"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="nome">Nome</label>
				<div class="col-md-4">
					<input id="nome" name="nome" type="text"
						class="form-control input-md" maxlength="50"
						value="${pesquisador.nome}"
						placeholder=" Digite seu nome
						completo" required="required"
						data-error="Por favor, informe seu nome" />
					<div class="help-block with-errors"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="cargo">Informe
					seu Cargo</label>
				<div class="col-md-4">
					<select id="cargo" name="cargo" class="form-control">
						<option value="P"
							<c:if test="${pesquisador.cargo == 'P'.charAt(0) }">selected="selected"</c:if>>Professor
						</option>

						<option value="A"
							<c:if test="${pesquisador.cargo == 'A'.charAt(0) }">selected="selected"</c:if>>Administrativo
						</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="titulacao">Informe
					sua Titulação</label>
				<div class="col-md-4">
					<select id="titulacao" name="titulacao" class="form-control">
						<option value="M"
							<c:if test="${pesquisador.titulacao == 'M'.charAt(0) }">selected="selected"</c:if>>Mestrado
						</option>

						<option value="D"
							<c:if test="${pesquisador.titulacao == 'D'.charAt(0) }">selected="selected"</c:if>>Doutorado
						</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="regime">Informe
					seu Regime</label>
				<div class="col-md-4">
					<select id="regime" name="regime" class="form-control">
						<option value="20"
							<c:if test="${pesquisador.regime == '20' }">selected="selected"</c:if>>20
							Horas</option>

						<option value="40"
							<c:if test="${pesquisador.regime == '40' }">selected="selected"</c:if>>40
							Horas</option>

						<option value="DE"
							<c:if test="${pesquisador.regime == 'DE' }">selected="selected"</c:if>>D.E.
						</option>
					</select>
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
				<label class="col-md-2 control-label" for="sexo">Informe seu
					Sexo</label>
				<div class="col-md-4">
					<select id="sexo" name="sexo" class="form-control">
						<option value="m"
							<c:if test="${aluno.sexo == 'm'.charAt(0) }">selected="selected"</c:if>>Masculino</option>

						<option value="f"
							<c:if test="${aluno.sexo == 'f'.charAt(0) }">selected="selected"</c:if>>Feminino</option>
					</select>
				</div>
			</div>


			<div class="form-group">
				<label class="col-md-2 control-label" for="telefone">Telefone</label>
				<div class="col-md-4">
					<input id="telefone" name="telefone" type="text"
						value="${pesquisador.telefone}" class="form-control"
						placeholder="Apenas números" maxlength="20" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="celular">Celular</label>
				<div class="col-md-4">
					<input id="celular" name="celular" type="text" class="form-control"
						placeholder="Apenas números" maxlength="20"
						value="${pesquisador.celular}"
						data-error=" Por
						favor, informe seu celular" required="required" />
					<div class="help-block with-errors"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="linklattes">Lattes</label>
				<div class="col-md-4">
					<input id="linklattes" name="linklattes" type="text"
						class="form-control" placeholder="Digite o endereço do seu lattes"
						required="required" maxlength="200"
						value="${pesquisador.linklattes}"
						data-error=" Por
						favor, informe seu lattes" />
					<div class="help-block with-errors"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="email1">E-mail 1</label>
				<div class="col-md-4">
					<input id="email1" name="email1" type="email" class="form-control"
						value="${pesquisador.email1}"
						placeholder=" Digite seu e-mail" required="required" maxlength="45"
						data-error="Por favor, informe seu email" />
					<div class="help-block with-errors"></div>
				</div>
				<div class="col-md-4">
					<input id="emailConfirmacao1" name="emailConfirmacao1" type="email"
						value="${pesquisador.email1}"
						class=" form-control input-md" placeholder="Confirme seu e-mail" required="required"
						maxlength="45" data-match="#email1"
						data-match-error="Atenção! Os e-mails não são iguais." />
					<div class="help-block with-errors"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="email2">E-mail 2</label>
				<div class="col-md-4">
					<input id="email2" name="email2" type="email" class="form-control"
						value="${pesquisador.email2}"
						placeholder=" Digite seu
						e-mail" maxlength="45"
						data-error="Por favor, informe um e-mail correto." />
					<div class="help-block with-errors"></div>
				</div>
				<div class="col-md-4">
					<input name="emailConfirmacao2" id="emailConfirmacao2" type="email"
						value="${pesquisador.email2}"
						class=" form-control input-md" placeholder="Digite seu e-mail" maxlength="45"
						data-match="#email2"
						data-match-error="Atenção! Os e-mails não são iguais." />
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


