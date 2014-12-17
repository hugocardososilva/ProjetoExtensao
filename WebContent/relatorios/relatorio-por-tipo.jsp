<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="Mensage" uri="projeto.tags"%>
<%@ taglib prefix="Sessao" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatórios por tipo</title>
<link  rel= "stylesheet"  href= "../bootstrap/css/bootstrap.min.css" >
<link  rel= "stylesheet"  href= "bootstrap/css/bootstrap.min.css" >
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
  					<h4>Relatório por Tipo</h4>
 			</div>
		 <div class="panel-body">
	<form target="_blank" role="form" action="Relatorios.do?ref=tipo" method="post">
		
				 <h4>Coordenador da atividade</h4>
			          	 
			<select class="form-control" name="tipoAtividade" id="tipo">
				<c:forEach var="tipo"  items="${requestScope.tipo }">
						<option value="${tipo.id }">${tipo.id } - ${tipo.nome } </option>
						</c:forEach>
				
			</select>
			<label for="inicio">Data Início
				<input name="inicio" class="form-control" type="date"   />
				</label>
				
				<label for="fim">Data Término
				<input name="fim" class="form-control" type="date"   />
				</label>
				
				
				<button type="submit" class="btn btn-info">Pesquisar</button> 
	</form>
	</div>
	</div>
	</div>

</body>
</html>