<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<title>Adicionar Linha de Extens�o</title>
</head>
<body>
<div class="container">
<Sessao:TagSessaoUser/>
<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Nova Linha de Extens�o</h4>
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
		
		<input type="hidden" name="tipo" value="extensao">
		<label for="nome">N�mero<br />
		</label>
			<input class="form-control" value="${requestScope.apoio.numero }" name="numero" required="required" type="text" id="numero" size="3" maxlength="3" />
		</div>
		<label for="nome">Denomina��o <br />
		</label>
			<input class="form-control" name="denominacao" value="${requestScope.apoio.denominacao }" required="required" type="text" id="denominacao" size="50" maxlength="100" />
		<label for="nome">Defini��es <br />
		</label>
			<input class="form-control" name="definicoes" value="${requestScope.apoio.definicoes }" required="required" type="text" id="definicoes" size="50" maxlength="100" />
		
		
		
		
		
		

	


		 <button type="submit" class="btn btn-info">Salvar</button>
		 </form>
</div>
</div>
</div>
	


</body>
</html>