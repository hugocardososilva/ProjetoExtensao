<html>
<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Novo Participante</h4>
 			</div>
		 <div class="panel-body">
<form role="form" action="Participantes.do?ref=novo&id=${requestScope.id }" method="post">
		
		<div class="form-group">
		
		<input type="hidden" name="tipo" value="${requestScope.especificacao }">
		
		<label for="nome">Nome <br />
		</label>
			<input class="form-control" name="nome" type="text" id="nome" size="50" maxlength="100" />
		</div>
		
		<div class="form-group">
			<label for="email">Email<br />
		</label>
			<input class="form-control" name="email" type="text" id="email" size="50" maxlength="100" />
		
		</div>
		<div class="form-group">
			<label for="telPrimario">Telefone<br />
		</label>
			<input class="form-control" name="telPrimario" type="text" id="telPrimario" size="50" maxlength="100" />
		
		</div>
		
		
		<div class="radio">
			<h4>Voluntário</h4>
			<label>
			<input type="radio" name="voluntario" checked="checked" value="true" id="Voluntario_0" />
			Sim</label>
		<label>
		<input type="radio" name="voluntario" value="false" id="Voluntario_1" />
		Não</label>


</div>
		 <button type="submit" class="btn btn-info">Salvar</button>

</form>
</div>
</div>
</div>
</body>
</html>