<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Participante</title>
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
</head>
<body>
	<div class="container">
	<Sessao:TagSessaoUser/>
	<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	<Mensage:mensagens mensagem="${requestScope.mensagem }"/>
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Pesquisar</h4>
 			</div>
		 <div class="panel-body">
	<form role="form" action="Participantes.do?ref=pesquisar&id=${requestScope.id }" method="post">
			<div class="radio">
			<label>
			
			<input type="radio" name="campo" checked="checked" value="nome">
			Nome
			</label>
			<label>
			
			<input type="radio" name="campo"  value="email">
			Email
			</label>
				
				<input type="hidden"  name="tipo" value="${requestScope.especificacao }">
				
				
				<label for="pesquisa">
				<input name="pesquisa" class="form-control" type="text" id="pesquisa" />
				</label>
				</div>
				
				<button type="submit" class="btn btn-info">Pesquisar</button> 
	</form>
	</div>
		</div>
		</div>
</body>
</html>