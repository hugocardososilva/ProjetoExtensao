<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
        <%@ taglib prefix="Mensage" uri="projeto.tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Início</title>
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
	<div class="row">
  <div class="col-md-3">
		<div class="list-group">
  <li class="list-group-item">Atividade</li>
  <a href="<c:url value='/atividade/cadastrar-atividade.jsp'/>" class="list-group-item"> Nova Atividade</a>
  <a href="<c:url value='/Atividades.do?ref=listar'/>" class="list-group-item">Listar Atividades</a>
  <a href="<c:url value='/PesquisarAtividades.do?ref=pesquisar'/>" class="list-group-item">Pesquisar Atividades</a>
  
</div>
</div>
  <div class="col-md-3">
			<div class="list-group">
			  <li class="list-group-item">Emitir Relatório</li>
			  <a href="<c:url value='/Relatorios.do?ref=periodo'/>" class="list-group-item">Por Período</a>
			  <a href="<c:url value='/Relatorios.do?ref=coordenador'/>" class="list-group-item">Por Coordenador</a>
			  <a href="<c:url value='/Relatorios.do?ref=tipo'/>" class="list-group-item">Por Tipo</a>
			  <a href="<c:url value='/Relatorios.do?ref=vinculo'/>" class="list-group-item">Por Vínculo</a>
			</div>
	</div>
</div>
	

	
	
</div>



</body>
</html>