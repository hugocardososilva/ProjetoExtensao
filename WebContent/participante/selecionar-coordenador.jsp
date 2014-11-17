<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
     <%@ taglib prefix="Mensage" uri="projeto.tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Coordenador</title>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
</head>
<body>
<div class="container">
<Sessao:TagSessaoUser/>
	<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
<table class="table table-bordered table-hover">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Voluntário?</th>
			<th>Setor</th>
			<th>Telefone primário</th>
			<th>Telefone auxiliar</th>
			<th>Tipo</th>
			<th>Opções</th>
			
		</tr>
		
		<c:forEach var="participante" items="${requestScope.lista }">
			<tr>
				<td>${participante.nome }</td>
				<td>${participante.email }</td>
				<td>${participante.voluntario }</td>
				<td>${participante.setor }</td>
				<td>${participante.telPrimario }</td>
				<td>${participante.telAuxiliar }</td>
				<td>${participante.tipo }</td>
				<c:choose>
					<c:when test="${requestScope.id == null }">
						<td><a href="Participantes.do?ref=editar&tipo=${requestScope.tipo }&id=${requestScope.id }&idParticipante=${participante.id}"><button type="button" class="btn btn-warning right">Editar</button></a></td>
					</c:when>
					
					<c:otherwise>
						<td><a href="Participantes.do?ref=inserir&tipo=${requestScope.tipo }&id=${requestScope.id }&idParticipante=${participante.id}"><button type="button" class="btn btn-success right">Inserir</button></a></td>
					</c:otherwise>	
				</c:choose>
				
				
				
			</tr>
		
		</c:forEach>
		


</table>
<c:choose>
			<c:when test="${requestScope.id != null }">
	<c:import url="inserir-coordenador.jsp"/>
			</c:when>
</c:choose>
	
</div>
</body>
</html>
	
	
	
	