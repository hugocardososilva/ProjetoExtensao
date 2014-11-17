<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<div class="panel panel-default">
  			<div class="panel-heading">
  				<h4>Docentes</h4>
  			</div>
		<div class="panel-body">
		<a href="Participantes.do?ref=novo&especificacao=docente&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" type="button" class="btn btn-success right">Adicionar Docente</button></a>
		<c:choose>
			<c:when test="${requestScope.atividade.docentes.isEmpty() }">
				
				<p>Nenhum docente adicionado </p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="docente" items="${requestScope.atividade.docentes }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${docente.nome }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${docente.email }</td>
			</tr>
			<tr>
				<th>Telefone</th>
				<td>${docente.telPrimario }</td>
			</tr>
			<tr>
				<th>Voluntário ?</th>
				<td>${docente.voluntario }</td>
			</tr>
			<tr>
				<th>Opções</th>
				
				<td>
					<a href="Participantes.do?ref=editar&tipo=docente&id=${requestScope.atividade.id }&idParticipante=${docente.id}">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
				<a href="Participantes.do?ref=remover&tipo=docente&id=${requestScope.atividade.id }&idParticipante=${docente.id}">
					<button  class="btn btn-danger" type="button">Remover</button>
				</a>
				</td>
				
			</tr>
			</table>
			</c:forEach>
				
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		
			</div>
			</div>