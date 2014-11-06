<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<title>Adicionar Vínculo</title>
</head>
<body>
<div class="container">
<c:import url="../scripts.jsp"/>
	<c:import url="../header.jsp"/>
	<c:import url="../menu.jsp"/>
	
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Novo Vínculo</h4>
 			</div>
		 <div class="panel-body">
<form role="form" action="Apoio.do?ref=add" method="post">
		
		<div class="form-group">
		
		<input type="hidden" name="tipo" value="vinculo">
		
		<label for="nome">Nome <br />
		</label>
			<input class="form-control" name="nome" required="required" type="text" id="nome" size="50" maxlength="100" />
		</div>
		
		
		
		



		 <button type="submit" class="btn btn-info">Salvar</button>

</form>
</div>
</div>
	
</div>	


</body>
</html>