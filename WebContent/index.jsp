<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
        <%@ taglib prefix="Mensage" uri="projeto.tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>In�cio</title>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
</head>
<body>
<Sessao:TagSessaoUser/>
<div class="container">

<c:import url="scripts.jsp"/>
	<c:import url="header.jsp"/>
	<c:import url="menu.jsp"/>
	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
</div>
</body>
</html>