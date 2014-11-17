<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar ${requestScope.tipo }</title>
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
</head>
<body>

<div class="container">
<Sessao:TagSessaoUser/>
<c:import url="../scripts.jsp"/>
<c:import url="../header.jsp"/>
<c:import url="../menu.jsp"/>

	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>

			<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Editar Participante</h4>
 			</div>
		 <div class="panel-body">
<form role="form" action="Participantes.do?ref=alterar&id=${requestScope.id }" method="post">
		
		<div class="form-group">
		
		<input type="hidden" name="tipo" value="${requestScope.tipo }">
		<input type="hidden" name="idParticipante" value="${requestScope.participante.id }">
		
		<label for="nome">Nome <br />
		</label>
			<input class="form-control" name="nome" required="required" value="${requestScope.participante.nome }" type="text" id="nome" size="50" maxlength="100" />
		</div>
		
		<div class="form-group">
			<label for="email">Email<br />
		</label>
			<input class="form-control" name="email" value="${requestScope.participante.email }" type="email" id="email" size="50" maxlength="100" />
		
		</div>
		<div class="form-group">
			<label for="telPrimario">Telefone<br />
		</label>
			<input class="form-control" name="telPrimario" value="${requestScope.participante.telPrimario }" type="text" id="email" size="50" maxlength="100" />
		
		</div>
		<c:choose>
		<c:when test="${requestScope.participante.voluntario == true }">
		<div class="radio">
			<h4>Voluntário</h4>
			<label>
			<input type="radio" name="voluntario" checked="checked" value="true" id="Voluntario_0" />
			Sim</label>
		<label>
		<input type="radio" name="voluntario" value="false" id="Voluntario_1" />
		Não</label>
</div>
		</c:when>
		<c:otherwise>
			<div class="radio">
			<h4>Voluntário</h4>
			<label>
			<input type="radio" name="voluntario"  value="true" id="Voluntario_0" />
			Sim</label>
		<label>
		<input type="radio" checked="checked" name="voluntario" value="false" id="Voluntario_1" />
		Não</label>
</div>
		</c:otherwise>
		</c:choose>
		
		 <button type="submit" class="btn btn-info">Editar</button>

</form>
</div>
</div>
</div>
</body>
</html>