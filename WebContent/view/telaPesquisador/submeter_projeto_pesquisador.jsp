<h3 class="text-success">Submissão de Projeto</h3>
<form class="form-horizontal" method="post" action="">
	<fieldset>		
		<div class="form-group">
			<label class="col-md-2 control-label" for="titulo">Título</label>
			<div class="col-md-4">
				<input id="titulo" name="titulo" type="text" maxlength="50"
					placeholder="Insira um título" class="form-control input-md"
					required="required">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="ehcoordenador">Coordenador</label>
			<div class="col-md-4">
				<input type="checkbox" class="form-control" name="ehcoordenador" id="ehcordenador"/>Sim												
			</div>
		</div>			
		<div class="form-group">
			<label class="col-md-2 control-label" for="data_inicio">Data
				de Início</label>
			<div class="col-md-4">
				<input id="data_inicio" name="data_inicio" type="date"
					placeholder="Insira uma data" class="form-control input-md"
					required="required">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="data_termino">Data
				de Término</label>
			<div class="col-md-4">
				<input id="data_termino" name="data_termino" type="date"
					placeholder="Insira uma data" class="form-control input-md"
					required="required">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="submeter_projeto">Submeter</label>
			<div class="col-md-4">
				<button id="submeter_projeto" name="submeter_projeto"
					class="btn btn-success">Enviar</button>
			</div>
		</div>
	</fieldset>
</form>