<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selecionar ${requestScope.tipo }</title>
</head>
<body>
<table>
		<tr>
			<td>Nome</td>
			<td>Email</td>
			<td>Voluntário?</td>
			<td>Opções</td>
			<td></td>
		</tr>
		
		<c:forEach var="participante" items="${requestScope.lista }">
			<tr>
				<td>${participante.nome }</td>
				<td>${participante.email }</td>
				<td>${participante.voluntario }</td>
				<td><a href="Participantes.do?ref=inserir&tipo=${requestScope.tipo }&id=${requestScope.id }&idParticipante=${participante.id}">Inserir</a></td>
				<td><form action="Participantes.do?ref=inserir&tipo=${requestScope.tipo }&id=${requestScope.id }&idParticipante=${participante.id}" method="post">
				<input type="submit" value="Inserir"></form>
				
			</tr>
		
		</c:forEach>
		


</table>

</body>
</html>