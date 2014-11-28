<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<title>Adicionar Tipo de Atividade</title>
</head>
<body>
<div class="container">
<Sessao:TagSessaoUser/>
<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Novo Tipo de Atividade</h4>
 			</div>
		 <div class="panel-body">
<c:choose>
<c:when test="${requestScope.apoio == null }">	
	 
<form role="form" action="Apoio.do?ref=add" method="post">
</c:when>	
<c:otherwise>
<form role="form" action="Apoio.do?ref=editar" method="post">
<input type="hidden" name="id" value="${requestScope.apoio.id }">
</c:otherwise>	
</c:choose>
		
		<div class="form-group">
		
		<input type="hidden" name="tipo" value="tipoAtividade">
		<label for="nome">Sigla<br />
		</label>
			<input class="form-control" value="${requestScope.apoio.sigla }" name="sigla" required="required" type="text" id="sigla" size="3" maxlength="3" />
		</div>
		<label for="nome">Nome <br />
		</label>
			<input class="form-control" name="nome" value="${requestScope.apoio.nome }" required="required" type="text" id="nome" size="50" maxlength="100" />
		
		
		
		
		
		

	


		 <button type="submit" class="btn btn-info">Salvar</button>
		 </form>
</div>
</div>
</div>
	


</body>
</html>