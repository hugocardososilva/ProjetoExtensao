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
			<th class="tdnome">ID</th>
			<td>${atividade.id }</td>
		</tr>
		<tr>
			<th>Titulo</th>
			<td>${atividade.titulo }</td>
		</tr>
		<tr>
			<th>Tipo da Atividade</th>
			<td>${atividade.tipoAtividade.nome }</td>
		</tr>
		<tr>
			<th>Vínculo</th>
			<td>${atividade.vinculo.nome }</td>
		</tr>
		<tr>
			<th>Fonte de Recursos</th>
			<td>${atividade.fonteDeRecurso }</td>
		</tr>
		<tr>
			<th>Valor</th>
			<td><fmt:formatNumber type="currency" currencySymbol="R$" currencyCode="BRL" value="${atividade.valor }"/></td>
	</tr>
	</table>
	</c:forEach>
	
		
	
</div>
</body>
</html>