<%@page import="models.Atividade"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
    <%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
    <% 
    pageContext.setAttribute("lista", request.getAttribute("lista")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selecionar ${requestScope.tipo }</title>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
</head>
<body>
<div class="container">
<Sessao:TagSessaoUser/>
<c:import url="../scripts.jsp"/>
<c:import url="../header.jsp"/>
<c:import url="../menu.jsp"/>
		<table class="table table-bordered table-hover">
		<tr>
			<th>Titulo</th>
			<th>Registro</th>
			<th>Coordenador</th>
			<th>Opções</th>
			
		</tr>
		
		<c:forEach var="atividade" items="${lista }">
		 
			<tr>
				<td>${atividade.titulo }</td>
				<td>${atividade.registro }</td>
				<td>${atividade.coordenador.nome }</td>
				<td><a href="VincularAtividades.do?ref=inserir&id=${requestScope.id }&idAtividadeVincular=${atividade.id}"><button type="button" class="btn btn-success right">Inserir</button></a></td>
				
				
			</tr>
		
		</c:forEach>
</table>

</div>

</body>
</html>