<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>

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
	<form action="Coordenadores.do?ref=alterar&id=${requestScope.id }" method="post">

		
		<input type="hidden" name="idParticipante" value="${requestScope.participante.id }">
		<input type="hidden" name="tipo" value="${requestScope.especificacao }">
		<label for="nomeCoordenador">Nome Completo<br />
		</label>
		<input name="nomeCoordenador" required="required" class="form-control" value="${requestScope.participante.nome }" type="text"  id="nomeCoordenador" size="50" maxlength="100" />
		
		<c:choose>
		<c:when test="${requestScope.participante.tipo == 'Docente' }">
		<div class="radio">
				<label>
					
				<input type="radio" checked="checked" name="especificacaoCoordenador" value="Docente" id="especificacaoCoordenador_0" />
				Docente</label>
				<label>
				<input type="radio" name="especificacaoCoordenador" value="Técnico Administrativo" id="especificacaoCoordenador_1" />
				Técnico Administrativo</label>
				
		</div>
		</c:when>
		<c:otherwise>
		<div class="radio">
				<label>
					
				<input type="radio" name="especificacaoCoordenador" value="Docente" id="especificacaoCoordenador_0" />
				Docente</label>
				<label>
				<input type="radio" checked="checked" name="especificacaoCoordenador" value="Técnico Administrativo" id="especificacaoCoordenador_1" />
				Técnico Administrativo</label>
				
		</div>
		</c:otherwise>
		</c:choose>
		


			<label for="emailCoordenador">Email<br />
			</label>
			<input class="form-control" name="emailCoordenador" value="${requestScope.participante.email }" type="email" id="emailCoordenador" size="50" maxlength="100" />

		
		Voluntario
		
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
		
		<label  for="setorDeTrabalho">Setor de trabalho<br />
		</label>
		<input class="form-control" required="required" name="setorDeTrabalho" value="${requestScope.participante.setor }" type="text" id="setorDeTrabalho" value="" size="50" maxlength="50" />
		</p>
		<p>


		<label for="phonePrimario">Fone principal<br />
		</label>
		<input  class="form-control" pattern="[0-9]+$" required="required" name="phonePrimario" value="${requestScope.participante.telPrimario }" type="text" id="phonePrimario" size="50" maxlength="10" />

		<label for="phonePrimario"><br />
		Fone secundário<br />
		</label>
		<input class="form-control" pattern="[0-9]+$" required="required" name="phonePrimario2" value="${requestScope.participante.telAuxiliar }" type="text" id="phonePrimario" size="50" maxlength="10" />

		<button type="submit" class="btn btn-info">Editar</button> 




</form>