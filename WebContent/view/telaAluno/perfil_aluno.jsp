
<div class="row">
	<div class="col-md-7 col-lg-8 col-lg-offset-0">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">${aluno.nome}</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3 col-lg-3 " align="center">
					
						<img alt="User Pic"
										src="http://old.sspw.pl/view/img/male_user.png"
										class="img-circle img-responsive">
						
						
					</div>
					<div class=" col-md-9 col-lg-9 ">
						<table class="table table-user-information">
							<tbody>
								<tr>
									<td>Área:</td>
									<td>Programação</td>
								</tr>
								<tr>
									<td>Nascimento:</td>
									<td>${aluno.nascimento}</td>
								</tr>
								<tr>
									<td>Genero:</td>
									<td>${aluno.sexoCompleto}</td>
								</tr>
								<tr>
									<td>Lattes:</td>
									<td><a href="${aluno.linklattes}">Currículo Lattes</a></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><a href="${aluno.email}">${aluno.email}</a>
									</td>
								</tr>
								<tr>
									<td>Contato:</td>
									<td>${aluno.telefone} (Fixo) <br /> <br /> ${aluno.celular} (Móvel)
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<form action="telaAlunoPerfil.html" method="get">
					<button data-toggle="tooltip" type="submit"
						class="btn btn-sm btn-info">Editar</button>
				</form>
			</div>
		</div>
	</div>
</div>