<%@ taglib prefix="Mensage" uri="projeto.tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Participante</title>
</head>
<body>
		<div class="container">
<c:import url="scripts.jsp"/>
<c:import url="header.jsp"/>
<c:import url="menu.jsp"/>

	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
		<c:import url="/pesquisar-equipe.jsp"/>


<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Novo Participante</h4>
 			</div>
		 <div class="panel-body">
<form role="form" action="Participantes.do?ref=novo&id=${param.id }" method="post">
		
		<div class="form-group">
		
		<input type="hidden" name="tipo" value="${param.especificacao }">
		
		<label for="nome">Nome <br />
		</label>
			<input class="form-control" name="nome" type="text" id="nome" size="50" maxlength="100" />
		</div>
		
		<div class="form-group">
			<label for="email">Email<br />
		</label>
			<input class="form-control" name="email" type="text" id="email" size="50" maxlength="100" />
		
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