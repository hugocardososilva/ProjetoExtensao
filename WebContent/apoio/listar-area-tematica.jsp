<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar �rea Tem�tica</title>
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
			<th>AREA</th>
			<th>DESCRI��O</th>
			
		</tr>
		
		<c:forEach var="area" items="${requestScope.lista }">
			<tr>
				<td>${area.id }</td>
				<td>${area.sigla }</td>
				<td>${area.area }</td>
				<td>${area.descricao }</td>
				
				
					
					<td><a href="Apoio.do?ref=editar&tipo=${requestScope.tipo }&id=${area.id } "><button type="button" class="btn btn-warning right">Editar</button></a></td>
					
					
<%-- 					<td><a href="Apoio.do?ref=excluir&tipo=${requestScope.tipo }&id=${area.id }"><button type="button" class="btn btn-danger right">Excluir</button></a></td> --%>
					
				
				
				
				
			</tr>
		
		</c:forEach>
		


</table>
	
</div>

</body>
</html>