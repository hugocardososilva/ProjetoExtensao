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
	<li><a href="<c:url value='/UserController.do?ref=inicio'/>">Início</a></li>
		<li class="dropdown">
		 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Atividade <span class="caret"></span></a>
			 <ul class="dropdown-menu" role="menu">
			 	<li><a href="<c:url value='/atividade/cadastrar-atividade.jsp'/>">Nova Atividade</a></li>
			 	<li><a href="<c:url value='/Atividades.do?ref=listar'/>">Listar Atividades</a></li>
			 	<li><a href="<c:url value='/PesquisarAtividades.do?ref=pesquisar'/>">Pesquisar Atividades</a></li>
			 	 
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
		
			<li class="dropdown">
		 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Apoio <span class="caret"></span></a>
			 <ul class="dropdown-menu" role="menu">
			 	<li role="presentation" class="dropdown-header">Vínculo</li>
			 		 <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=vinculo'/>" >Adicionar Vínculo</a></li>
			 		 <li><a href="<c:url value='/Apoio.do?ref=listar&tipo=vinculo'/>" >Listar Vínculo</a></li>
<%-- 			 		 <li><a href="<c:url value='/Participantes.do?ref=listar&tipo=coordenador'/>" >Listar Vínculo</a></li> --%>
			 	<li role="presentation" class="dropdown-header">Tipo de Atividade</li>
				 	 <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=tipoAtividade'/>" >Adicionar Tipo de Atividade</a></li>
				 	  <li><a href="<c:url value='/Apoio.do?ref=listar&tipo=tipoAtividade'/>" >Listar Tipo de Atividade</a></li>
				 <li role="presentation" class="dropdown-header">Local de Realização</li>
				 	 <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=local'/>" >Adicionar Local de Realização</a></li>
				 	 <li><a href="<c:url value='/Apoio.do?ref=listar&tipo=local'/>" >Listar Local de Realização</a></li>
				 <li role="presentation" class="dropdown-header">Linha de Extensão</li>
				  <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=extensao'/>" >Adicionar Linha de Extensão</a></li>
				  <li><a href="<c:url value='/Apoio.do?ref=Listar&tipo=extensao'/>" >Listar Linha de Extensão</a></li>
				 <li role="presentation" class="dropdown-header">Área Temática</li>
				 	 <li><a href="<c:url value='/Apoio.do?ref=novo&tipo=areaTematica'/>" >Adicionar Área Temática</a></li>
				 	 <li><a href="<c:url value='/Apoio.do?ref=listar&tipo=areaTematica'/>" >Listar Área Temática</a></li>
				
		
			 
			
			 </ul>
			 </li>
			<li class="dropdown">
		 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuário <span class="caret"></span></a>
			 <ul class="dropdown-menu" role="menu">
			 	<li role="presentation" class="dropdown-header">Usuário</li>
			 		 <li><a href="<c:url value='/UserController.do?ref=add'/>" >Adicionar Usuário</a></li>
<%-- 			 		 <li><a href="<c:url value='/Apoio.do?ref=listar&tipo=vinculo'/>" >Listar Vínculo</a></li> --%>
			 
			 					
		
			 
			
			 </ul>
			 </li>
			 </ul>
			 <c:choose>
			 <c:when test="${sessionScope.user== null }">
			  <form class="navbar-form navbar-right" action="UserController.do?ref=login" method="post" >
        <div class="form-group">
          <input type="text" name="login" class="form-control" placeholder="login">
        </div>
        <div class="form-group">
          <input type="password" name="senha" class="form-control" placeholder="senha">
        </div>
        <button type="submit" class="btn btn-default">Login</button>
      </form>
      
      </c:when>
      <c:otherwise>
      	<div class="navbar-right">Bem vindo, ${sessionScope.user.nome }  <a href="<c:url value='/UserController.do?ref=logoff'/>" ><button type="button" class="btn btn-default">Sair</button></a></div>
      </c:otherwise>
		</c:choose>
		
	
</div>
</div>
</nav>
   