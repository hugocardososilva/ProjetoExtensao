<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<title>Adicionar Local</title>
</head>
<body>
<div class="container">
<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Novo Local</h4>
 			</div>
		 <div class="panel-body">
<form role="form" action="Apoio.do?ref=add" method="post">
		
		<div class="form-group">
		
		<input type="hidden" name="tipo" value="local">
		<label for="nome">Código<br />
		</label>
			<input class="form-control" name="codigo" required="required" type="text" id="sigla" size="3" maxlength="3" />
		</div>
		<label for="nome">Local <br />
		</label>
			<input class="form-control" name="local" required="required" type="text" id="nome" size="50" maxlength="100" />
		
		
		
		
		
		

	


		 <button type="submit" class="btn btn-info">Salvar</button>
		 </form>
</div>
</div>
</div>
	


</body>
</html>