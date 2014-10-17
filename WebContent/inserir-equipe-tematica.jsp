<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Participante</title>
</head>
<body>
<form action="Participantes.do?ref=novo&id=${param.id }" method="post">
		
		
		
		<input type="hidden" name="tipo" value="${param.especificacao }">
		<label for="nome">Nome <br />
		</label>
			<input name="nome" type="text" id="nome" size="50" maxlength="100" />
		<p>
			<label for="email">Email<br />
		</label>
			<input name="email" type="text" id="email" size="50" maxlength="100" />
		</p>
		<p>Voluntario
		</p>
		<p>
			<label>
			<input type="radio" name="voluntario" value="true" id="Voluntario_0" />
			Sim</label>
		<label>
		<input type="radio" name="voluntario" value="false" id="Voluntario_1" />
		Não</label>


		</p>

		<input type="submit" value="Salvar">

</form>

</body>
</html>