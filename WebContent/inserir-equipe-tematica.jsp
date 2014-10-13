<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EquipeTematica.do?ref=novo&id=${param.id }" method="post">
		<label>
		<input type="radio" name="especificacao" value="docente" id="docente" />
		Docente</label>
		<label>
		<input type="radio" name="especificacao" value="tecnico" id="tecnico" />
		Técnico Administrativo</label>
		<label>
		<input type="radio" name="especificacao" value="bolsista" id="bolsista" />
		Bolsista</label>
		<label>
		<input type="radio" name="especificacao" value="externo" id="externo" />
		Externo</label>
		
		
	
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
			<input type="radio" name="voluntario" value="sim" id="Voluntario_0" />
			Sim</label>
		<label>
		<input type="radio" name="voluntario" value="nao" id="Voluntario_1" />
		Não</label>


		</p>

		<input type="submit" value="Salvar">

</form>

</body>
</html>