<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
 <%@ taglib prefix="Mensage" uri="projeto.tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Atividade</title>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
</head>
<body>
	<div class="container">
	<Sessao:TagSessaoUser/>
	<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
	
	<c:import url="../pesquisar/atividade-por-periodo.jsp"/>
	<c:import url="../pesquisar/atividade-por-tipo.jsp"/>
	<c:import url="../pesquisar/atividade-por-vinculo.jsp"/>
	<c:import url="../pesquisar/atividade-por-coordenador.jsp"/>
	
		</div>
		
</body>
</html></html>