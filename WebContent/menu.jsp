<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
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
	<li><a href="UserController.do?ref=inicio">In�cio</a></li>
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
				 <li role="presentation" class="dropdown-header">T�cnico</li>
				 	<li><a href="<c:url value='/Participantes.do?ref=add&tipo=tecnico'/>" >Adicionar T�cnico </a></li>
				 	<li><a href="<c:url value='/Participantes.do?ref=listar&tipo=tecnico'/>" >Listar T�cnicos</a></li>
				 <li role="presentation" class="dropdown-header">Bolsista</li>
				 	<li><a href="<c:url value='/Participantes.do?ref=add&tipo=bolsista'/>" >Adicionar Bolsista</a></li>
				 	<li><a href="<c:url value='/Participantes.do?ref=listar&tipo=bolsista'/>" >Listar Bolsistas</a></li>
				 <li role="presentation" class="dropdown-header">Externo</li>
				 	<li><a href="<c:url value='/Participantes.do?ref=add&tipo=externo'/>" >Adicionar Externo</a></li>
				 	<li><a href="<c:url value='/Participantes.do?ref=listar&tipo=externo'/>" >Listar Externos</a></li>
				
		
			 
			
			 </ul>
			 </li>
			 
		</li>
		
			<li class="dropdown">
		 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Apoio <span class="caret"></span></a>
			 <ul class="dropdown-menu" role="menu">
			 	<li role="presentation" class="dropdown-header">V�nculo</li>
			 		 <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=vinculo'/>" >Adicionar V�nculo</a></li>
<%-- 			 		 <li><a href="<c:url value='/Participantes.do?ref=listar&tipo=coordenador'/>" >Listar V�nculo</a></li> --%>
			 	<li role="presentation" class="dropdown-header">Tipo de Atividade</li>
				 	 <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=tipoAtividade'/>" >Adicionar Tipo de Atividade</a></li>
				 <li role="presentation" class="dropdown-header">Local de Realiza��o</li>
				 	 <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=local'/>" >Adicionar Local de Realiza��o</a></li>
				 <li role="presentation" class="dropdown-header">Linha de Extens�o</li>
				  <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=extensao'/>" >Adicionar Linha de Extens�o</a></li>
				 <li role="presentation" class="dropdown-header">�rea Tem�tica</li>
				 	 <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=areaTematica'/>" >Adicionar �rea Tem�tica</a></li>>
				
		
			 
			
			 </ul>
			 </li>
			
			 </ul>
			  <form class="navbar-form navbar-right" action="UserController.do?ref=login" method="post" >
        <div class="form-group">
          <input type="text" class="form-control" placeholder="login">
        </div>
        <div class="form-group">
          <input type="password" class="form-control" placeholder="senha">
        </div>
        <button type="submit" class="btn btn-default">Login</button>
      </form>
		
	
</div>
</div>
</nav>