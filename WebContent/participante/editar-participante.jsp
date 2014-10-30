<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


			<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Novo Participante</h4>
 			</div>
		 <div class="panel-body">
<form role="form" action="Participantes.do?ref=alterar&id=${requestScope.id }" method="post">
		
		<div class="form-group">
		
		<input type="hidden" name="tipo" value="${requestScope.tipo }">
		
		<label for="nome">Nome <br />
		</label>
			<input class="form-control" name="nome" required="required" type="text" id="nome" size="50" maxlength="100" />
		</div>
		
		<div class="form-group">
			<label for="email">Email<br />
		</label>
			<input class="form-control" name="email" type="email" id="email" size="50" maxlength="100" />
		
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

</body>
</html>