<style>
.btn span.glyphicon {
	opacity: 0;
}

.btn.active span.glyphicon {
	opacity: 1;
}
</style>
<div class=col-md-8>
	<h3 class="text-success">Enviar Relatório Mensal</h3>
	<hr />
	<form class="form-horizontal" enctype="multipart/form-data" method="post" action="submeterProjeto"
		data-toggle="validator" role="form">
		<fieldset>
			<div class="form-group">
				<label class="control-label col-md-2">Anexos </label>
				<div class="col-md-7">
					<input id="input-2" name="input2[]" multiple="multiple" type="file"
						class="file file-loading" data-show-upload="false"
						data-allowed-file-extensions='["pdf"]' accept=".pdf" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="submeter_projeto">Submeter</label>
				<div class="col-md-4">					
					<input class="btn btn-success" type="submit" value="Enviar"/>
				</div>
			</div>
		</fieldset>
	</form>
</div>
<script src="resources/js/validator.min.js" type="text/javascript"></script>