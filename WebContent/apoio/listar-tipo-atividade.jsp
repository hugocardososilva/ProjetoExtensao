<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Tipo de Atividade</title>
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
			<th>ID</th>
			<th>SIGLA</th>
			<th>NOME</th>
			
		</tr>
		
		<c:forEach var="tipo" items="${requestScope.lista }">
			<tr>
				<td>${tipo.id }</td>
				<td>${tipo.sigla }</td>
				<td>${tipo.nome }</td>
				
				
					
					<td><a href="Apoio.do?ref=editar&tipo=${requestScope.tipo }&id=${tipo.id}"><button type="button" class="btn btn-warning right">Editar</button></a></td>
					
					
<%-- 					<td><a href="Apoio.do?ref=excluir&tipo=${requestScope.tipo }&id=${tipo.id }"><button type="button" class="btn btn-danger right">Excluir</button></a></td> --%>
					
				
				
				
				
			</tr>
		
		</c:forEach>
		


</table>
	
</div>

</body>
</html>