<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-8">
	<form class="form-horizontal" action="updateAluno" method="post"
		data-toggle="validator" role="form">
		<fieldset>
			<h3 class="text-success">Editar Aluno</h3>
			<hr />
			<input type="text" name="cpf" value="${aluno.cpf}" hidden="hidden" />
			<div class="form-group">
				<label class="col-md-2 control-label" for="nome">Nome</label>
				<div class="col-md-4">
					<input id="nome" name="nome" type="text"
						class="form-control input-md" maxlength="50" value="${aluno.nome}" />
				</div>
			</div>			

			<div class="form-group">
				<label class="col-md-2 control-label" for="campus_id">Informe
					seu Campus</label>
				<div class="col-md-4">
					<select id="campus_id" name="campus_id" class="form-control">

						<c:forEach var="campus" items="${listaCampus}" varStatus="id">
							<option value="${campus.id}"
								<c:if test="${campus.id == aluno.campus_id}">selected="selected"</c:if>>${campus.cidade}</option>

						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="curso_id">Informe
					seu Curso</label>
				<div class="col-md-4">
					<select id="curso_id" name="curso_id" class="form-control">

						<c:forEach var="curso" items="${listaCurso}" varStatus="id">
							<option value="${curso.id}"
								<c:if test="${curso.id == aluno.curso_id}">selected="selected"</c:if>>${curso.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="matricula">Matricula</label>
				<div class="col-md-4">
					<input id="matricula" name="matricula" type="text"
						class="form-control input-md" maxlength="20"
						placeholder="Digite sua matrícula" required="required"
						value="${aluno.matricula}" />
				</div>
			</div>
			
			<script>
			$('#nascimento').datepicker({
				format: "dd-mm-yyyy",					    
			    autoclose: true,
				language: "pt-BR"
			});
			</script>
			<div class="form-group">
				<label class="col-md-2 control-label" for="nascimento">Data
					de nascimento</label>
				<div class="col-md-4">
				<input id="nascimento" name="nascimento" type="text" value="${aluno.nascimento}"
					class="form-control input-md" required="required"
					data-error="Por favor, informe sua data de nascimento"/>
					<script>
					$('#nascimento').datepicker({
						format: "dd-mm-yyyy",					    
					    autoclose: true,
						language: "pt-BR"
					});
					</script>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="sexo">Informe
					seu Sexo</label>
				<div class="col-md-4">
					<select id="sexo" name="sexo" class="form-control">
						<option value="M"
							<c:if test="${aluno.sexo == 'M'.charAt(0) }">selected="selected"</c:if>>Masculino</option>

						<option value="F"
							<c:if test="${aluno.sexo == 'F'.charAt(0) }">selected="selected"</c:if>>Feminino</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="telefone">Telefone</label>
				<div class="col-md-4">
					<input id="telefone" name="telefone" type="text"
						class="form-control input-md" placeholder="Apenas números"
						maxlength="20" required="required" value="${aluno.telefone}"
						data-error="Por favor, informe seu telefone" />
					<div class="help-block with-error"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="celular">Celular</label>
				<div class="col-md-4">
					<input id="celular" name="celular" type="text"
						class="form-control input-md" placeholder="Apenas números"
						maxlength="20" required="required" value="${aluno.celular }"
						data-error="Por favor, informe seu celular" />
					<div class="help-block with-error"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="linklattes">lattes</label>
				<div class="col-md-4">
					<input id="linklattes" name="linklattes" type="text"
						class="form-control input-md" placeholder="Digite sue Lattes"
						maxlength="50" required="required" value="${aluno.linklattes }"
						data-error="Por favor, informe o link do seu lattes" />
					<div class="help-block with-error"></div>

				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="email">E-mail</label>
				<div class="col-md-4">
					<input id="email" name="email" type="email"
						class="form-control input-md" placeholder="Digite seu e-mail"
						required="required" maxlength="45" value="${aluno.email}"
						data-error="Por favor, informe um e-mail correto." />
					<div class="help-block with-errors"></div>
				</div>
				<div class="col-md-4">
					<input id="emailConfirmacao" name="emailConfirmacao" type="email"
						placeholder="Confirme seu e-mail" class="form-control input-md"
						required="required" maxlength="45" value="${aluno.email}"
						data-error="Por favor, informe um e-mail correto."
						data-match="#email"
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
	<script src="resources/js/validator.min.js" type="text/javascript"></script>
</div>