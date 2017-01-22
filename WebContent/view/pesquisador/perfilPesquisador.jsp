<div class="row">
	<div class="col-md-7 col-lg-8 col-lg-offset-0">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">${pesquisador.nome}</h3>
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
									<td>Titulação</td>
									<td>${pesquisador.titulacaoCompleta}</td>
								</tr>
								<tr>
									<td>Genero:</td>
									<td>${pesquisador.sexoCompleto}</td>
								</tr>
								<tr>
									<td>Lattes:</td>
									<td><a href="${pesquisador.linklattes}">Currículo Lattes</a></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><a href="${pesquisador.email1}">${pesquisador.email1}</a></td>
								</tr>
								<tr>
									<td>Contato:</td>
									<td>${pesquisador.telefone}(Fixo) <br /> <br />
										${pesquisador.celular} (Móvel)
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>			
		</div>
	</div>
</div>