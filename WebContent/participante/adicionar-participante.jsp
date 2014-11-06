<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<title>Adicionar ${requestScope.tipo }</title>
</head>
<body>
<div class="container">
<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	<c:import url="inserir-participante.jsp"/>
	
</div>

</body>
</html>