<h3 class="text-success">Submissão de Projeto</h3>
<form class="form-horizontal" method="post" action="">
	<fieldset>		
		<div class="form-group">
			<label class="col-md-2 control-label" for="titulo">Título</label>
			<div class="col-md-4">
				<input id="titulo" name="titulo" type="text"
					placeholder="Insira um título" class="form-control input-md"
					required="required">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="descricao_projeto">Descrição</label>
			<div class="col-md-4">
				<textarea class="form-control" rows="4" id="descricao_projeto"
					placeholder="Insira uma descrição" required="required"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="area_projeto">Área</label>
			<div class="col-md-4">
				<input id="area_projeto" name="area_projeto" type="text"
					placeholder="Insira a área" class="form-control input-md"
					required="required">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="ehfomento">E-fomento</label>
			<div class="col-md-4">
				<input id="ehfomento" name="ehfomento" type="number"
					placeholder="insira o E-fomento" class="form-control input-md"
					required="required">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="data_inicio">Data
				de Inicio</label>
			<div class="col-md-4">
				<input id="data_inicio" name="data_inicio" type="text"
					placeholder="Insira uma data" class="form-control input-md"
					required="required">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="data_termino">Data
				de Término</label>
			<div class="col-md-4">
				<input id="data_termino" name="data_termino" type="text"
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