<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-default" role="navigation">
 <div class="container-fluid">
<div class="navbar-header">
	 <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu-atividade">
	 </button>
</div>
<div class="collapse navbar-collapse" id= "menu-atividade" >
	<ul class="nav navbar-nav">
		<li class="dropdown">
		 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Atividade <span class="caret"></span></a>
			 <ul class="dropdown-menu" role="menu">
			 	<li><a href="atividade/cadastrar-atividade.jsp">Nova Atividade</a></li>
			 	 
			 </ul>
		
		<li class="dropdown">
		 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Participantes <span class="caret"></span></a>
			 <ul class="dropdown-menu" role="menu">
			 	<li role="presentation" class="dropdown-header">Coordenador</li>
			 		 <li><a href="<c:url value='/Participantes.do?ref=add&tipo=coordenador'/>" >Adicionar Coordenador</a></li>
			 		 <li><a href="<c:url value='/Participantes.do?ref=listar&tipo=coordenador'/>" >Listar Coordenadores</a></li>
			 	<li role="presentation" class="dropdown-header">Docente</li>
				 	<li><a href="<c:url value='/Participantes.do?ref=add&tipo=docente'/>" >Adicionar Docente</a></li>
				 	<li><a href="<c:url value='/Participantes.do?ref=listar&tipo=docente'/>" >Listar Docentes</a></li>
				 <li role="presentation" class="dropdown-header">Técnico</li>
				 	<li><a href="<c:url value='/Participantes.do?ref=add&tipo=tecnico'/>" >Adicionar Técnico </a></li>
				 	<li><a href="<c:url value='/Participantes.do?ref=listar&tipo=tecnico'/>" >Listar Técnicos</a></li>
				 <li role="presentation" class="dropdown-header">Bolsista</li>
				 	<li><a href="<c:url value='/Participantes.do?ref=add&tipo=bolsista'/>" >Adicionar Bolsista</a></li>
				 	<li><a href="<c:url value='/Participantes.do?ref=listar&tipo=bolsista'/>" >Listar Bolsistas</a></li>
				 <li role="presentation" class="dropdown-header">Externo</li>
				 	<li><a href="<c:url value='/Participantes.do?ref=add&tipo=externo'/>" >Adicionar Externo</a></li>
				 	<li><a href="<c:url value='/Participantes.do?ref=listar&tipo=externo'/>" >Listar Externos</a></li>
				
		
			 
			
			 </ul>
			 </li>
		</li>
			 </ul>
		
	
</div>
</div>
</nav>