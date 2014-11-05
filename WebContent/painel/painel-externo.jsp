<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Externos</h4>
 			</div>
		 <div class="panel-body">
					
				<p><a href="Participantes.do?ref=novo&especificacao=externo&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Externo</button></a></p>
			
		<c:choose>
			<c:when test="${requestScope.atividade.externos.isEmpty() }">
					
				<p>Nenhum externo adicionado</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="externo" items="${requestScope.atividade.externos }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${externo.nome }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${externo.email }</td>
			</tr>
			<tr>
				<th>Telefone</th>
				<td>${externo.telPrimario }</td>
			</tr>
			<tr>
				<th>Voluntario?</th>
				<td>${externo.voluntario }</td>
			</tr>
			<tr>
				<th>Opções</th>
				<td>
					<a href="Participantes.do?ref=editar&especificacao=externo&id=${requestScope.atividade.id }&idParticipante=${externo.id}">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
				<a href="Participantes.do?ref=remover&especificacao=externo&id=${requestScope.atividade.id }&idParticipante=${externo.id}">
					<button class="btn btn-danger" type="button">Remover</button>
				</a></td>
			</tr>
			</table>
			</c:forEach>
				
			
			
			
			
			</c:otherwise>
			
		</c:choose>
			
			</div>
			</div>