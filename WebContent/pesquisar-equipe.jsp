<html>
	<form action="Participantes.do?ref=pesquisar&id=${param.id }" method="post">
	<label>
	<input type="radio" name="campo" value="nome">
	Nome
	</label>
	<label>
	<input type="radio" name="campo" value="email">
	Email
	</label>
		<input type="hidden" name="tipo" value="${param.especificacao }">
		<input name="pesquisa" type="text" id="pesquisa" />
		
		<input type="submit" value="Pesquisar"> 


	</form>
</html>