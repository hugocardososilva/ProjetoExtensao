<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<title>Adicionar Usuário</title>
</head>
<body>
<div class="container">
<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	
		<form action="UserController.do?ref=add" method="post">

		
		
		
		<label for="nomeCoordenador">Nome Completo<br />
		</label>
		<input name="nomeCoordenador" class="form-control" type="text" id="nomeCoordenador" size="50" maxlength="100" />

		<div class="radio">
				<label>
					
				<input type="radio" name="especificacaoCoordenador" value="Docente" id="especificacaoCoordenador_0" />
				Docente</label>
				<label>
				<input type="radio" name="especificacaoCoordenador" value="Técnico Administrativo" id="especificacaoCoordenador_1" />
				Técnico Administrativo</label>
				
		</div>
		
		


			<label for="emailCoordenador">Email<br />
			</label>
			<input class="form-control" name="emailCoordenador" type="text" id="emailCoordenador" size="50" maxlength="100" />

		
		Voluntario
		
		<div class="radio">
		<label>
		<input type="radio" name="voluntario" value="sim" id="Voluntario_0" />
		Sim</label>
		<label>
		<input type="radio" name="voluntario" value="nao" id="Voluntario_1" />
		Não</label>
</div>

		
		<label  for="setorDeTrabalho">Setor de trabalho<br />
		</label>
		<input class="form-control" name="setorDeTrabalho" type="text" id="setorDeTrabalho" value="" size="50" maxlength="50" />
		</p>
		<p>


		<label for="phonePrimario">Fone principal<br />
		</label>
		<input  class="form-control" name="phonePrimario" type="text" id="phonePrimario" size="50" maxlength="10" />

		<label for="phonePrimario"><br />
		Fone secundário<br />
		</label>
		<input class="form-control" name="phonePrimario2" type="text" id="phonePrimario" size="50" maxlength="10" />

		<button type="submit" class="btn btn-info">Salvar</button> 




</form>
	
	
	
</div>

</body>
</html>

</body>
</html>