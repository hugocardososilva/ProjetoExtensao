<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selecionar ${requestScope.tipo }</title>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
</head>
<body>
<div class="container">
<Sessao:TagSessaoUser/>
<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
		<table class="table table-bordered table-hover">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Volunt�rio?</th>
			<th>Op��es</th>
			
		</tr>
		
		<c:forEach var="participante" items="${requestScope.lista }">
			<tr>
				<td>${participante.nome }</td>
				<td>${participante.email }</td>
				<td>${participante.telPrimario }
				<td>${participante.voluntario }</td>
				<c:choose>
					<c:when test="${requestScope.id == null }">
					<td><a href="Participantes.do?ref=editar&tipo=${requestScope.tipo }&idParticipante=${participante.id}"><button type="button" class="btn btn-warning right">Editar</button></a></td>
					
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
				<c:import url="inserir-participante.jsp"/>
			</c:when>
	</c:choose>
</div>

</body>
</html>