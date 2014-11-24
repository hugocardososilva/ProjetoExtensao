<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="Mensage" uri="projeto.tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar atividades</title>
</head>
<body>
<div class="container">
<Sessao:TagSessaoUser/>
<c:import url="../scripts.jsp"/>
<c:import url="../header.jsp"/>
<c:import url="../menu.jsp"/>

	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
	
		<c:forEach items="${requestScope.lista }" var="atividade">
		<table class="table table-bordered table-hover">
		<tr></tr>
		
		
			 
		
		<tr>
			<th>Titulo</th>
			<td>${atividade.titulo } <a href="Atividades.do?ref=visualizar&id=${atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Visualizar</button></a></td>
		</tr>
		<tr>
			<th>Coordenador</th>
			<td>${atividade.coordenador.nome }</td>
		</tr>
		<tr>
			<th>Data de Início</th>
			<td><fmt:formatDate value="${atividade.dataInicio }" type="both"   
pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<th>Data Término</th>
			<td><fmt:formatDate value="${atividade.dataTermino }" type="both"   
pattern="dd/MM/yyyy" /></td>
		</tr>
		
		
	</table>
	</c:forEach>
	
		
	
</div>
</body>
</html>