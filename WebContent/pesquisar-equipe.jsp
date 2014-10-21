<html>
<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Pesquisar</h4>
 			</div>
		 <div class="panel-body">
	<form role="form" action="Participantes.do?ref=pesquisar&id=${param.id }" method="post">
	<div class="radio">
	<label>
	<input type="radio" name="campo" checked="checked" value="nome">
	Nome
	</label>
	<label>
	<input type="radio" name="campo"  value="email">
	Email
	</label>
		<input type="hidden"  name="tipo" value="${param.especificacao }">
		
		<label for="pesquisa">
		<input name="pesquisa" class="form-control" type="text" id="pesquisa" />
		</label>
		</div>
		
		<button type="submit" class="btn btn-info">Pesquisar</button> 


	</form>
	</div>
	</div>
</html>