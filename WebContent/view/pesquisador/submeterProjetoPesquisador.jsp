<style>
.btn span.glyphicon {
	opacity: 0;
}

.btn.active span.glyphicon {
	opacity: 1;
}
</style>
<div class=col-md-8>
	<h3 class="text-success">Submissão de Projeto</h3>
	<hr />
	<form class="form-horizontal" enctype="multipart/form-data" method="post" action="submeterProjeto"
		data-toggle="validator" role="form">
		<fieldset>
<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-md-2 control-label" for="titulo">Título</label> -->
<!-- 				<div class="col-md-4"> -->
<!-- 					<input id="titulo" name="titulo" type="text" maxlength="50" -->
<!-- 						placeholder="Insira um título" class="form-control input-md" -->
<!-- 						required="required" data-error="Por favor, informe um título" /> -->
<!-- 					<div class="help-block with-errors"></div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-md-2 control-label" for="ehcoordenador">Coordenador</label> -->

<!-- 				<div class="btn-group col-md-4" data-toggle="buttons"> -->

<!-- 					<label class="btn btn-success active"> <input -->
<!-- 						name="ehcoordenador" type="checkbox" autocomplete="off" checked> -->
<!-- 						<span class="glyphicon glyphicon-ok"></span> -->

<!-- 					</label> -->

<!-- 				</div> -->
<!-- 			</div> -->

			<div class="form-group">
				<label class="control-label col-md-2">Anexos </label>
				<div class="col-md-7">
					<input id="input-2" name="input2[]" multiple="multiple" type="file"
						class="file file-loading" data-show-upload="false"
						data-allowed-file-extensions='["pdf"]' accept=".pdf" />

				</div>
			</div>

<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-md-2 control-label" for="data_inicio">Data -->
<!-- 					de Início</label> -->
<!-- 				<div class="col-md-4"> -->
<!-- 					<input id="data_inicio" name="data_inicio" type="date" -->
<!-- 						placeholder="Insira uma data" class="form-control input-md" -->
<!-- 						required="required" -->
<!-- 						data-error="Por favor, informe uma data de início" /> -->
<!-- 					<div class="help-block with-errors"></div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-md-2 control-label" for="data_termino">Data -->
<!-- 					de Término</label> -->
<!-- 				<div class="col-md-4"> -->
<!-- 					<input id="data_termino" name="data_termino" type="date" -->
<!-- 						placeholder="Insira uma data" class="form-control input-md" -->
<!-- 						required="required" -->
<!-- 						data-error="Por favor, informe uma data de término" /> -->
<!-- 					<div class="help-block with-errors"></div> -->
<!-- 				</div> -->
<!-- 			</div> -->

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