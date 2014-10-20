<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Coordenador</title>
</head>
<body>
<c:import url="/pesquisar-equipe.jsp"/>
<form action="Coordenador.do?ref=novo&id=${param.id }" method="post">
<h2>Coordenador</h2>
		
		<p>
		<input type="hidden" name="tipo" value="${param.especificacao }">
		<label for="nomeCoordenador">Nome Completo<br />
		</label>
		<input name="nomeCoordenador" type="text" id="nomeCoordenador" size="50" maxlength="100" />


		<label>
		<br />
		<br />
		<input type="radio" name="especificacaoCoordenador" value="docente" id="especificacaoCoordenador_0" />
		Docente</label>
		<label>
		<input type="radio" name="especificacaoCoordenador" value="tecnicoAdministrativo" id="especificacaoCoordenador_1" />
		Técnico Administrativo</label>
		</p>
		<p>


		<label for="emailCoordenador">Email<br />
		</label>
		<input name="emailCoordenador" type="text" id="emailCoordenador" size="50" maxlength="100" />

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
		<p>
		<label for="setorDeTrabalho">Setor de trabalho<br />
		</label>
		<input name="setorDeTrabalho" type="text" id="setorDeTrabalho" value="" size="50" maxlength="50" />
		</p>
		<p>


		<label for="phonePrimario">Fone principal<br />
		</label>
		<input name="phonePrimario" type="text" id="phonePrimario" size="50" maxlength="10" />

		<label for="phonePrimario"><br />
		Fone secundário<br />
		</label>
		<input name="phonePrimario2" type="text" id="phonePrimario" size="50" maxlength="10" />

		<input type="submit" value="Salvar">




</form>

</body>
</html>