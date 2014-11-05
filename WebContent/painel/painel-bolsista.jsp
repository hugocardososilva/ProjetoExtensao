<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Bolsistas</h4>
 			</div>
		 <div class="panel-body">
				
			<p><a href="Participantes.do?ref=novo&especificacao=bolsista&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Bolsista</button></a></p>
		<c:choose>
			<c:when test="${requestScope.atividade.bolsistas.isEmpty() }">
				
				<p>Nenhum bolsista adicionado</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="bolsista" items="${requestScope.atividade.bolsistas }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${bolsista.nome }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${bolsista.email }</td>
			</tr>
			<tr>
				<th>Telefone</th>
				<td>${bolsista.telPrimario }</td>
			</tr>
			<tr>
				<th>Voluntario?</th>
				<td>${bolsista.voluntario }</td>
			</tr>
			<tr>
				<th>Opções</th>
				<td>
					<a href="Participantes.do?ref=editar&especificacao=bolsista&id=${requestScope.atividade.id }&idParticipante=${bolsista.id}">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Participantes.do?ref=remover&especificacao=bolsista&id=${requestScope.atividade.id }&idParticipante=${bolsista.id}">
						<button class="btn btn-danger" type="button">Remover</button>
					</a>
				</td>
			</tr>
			</table>
			
			</c:forEach>
				
			
			
			
			
			</c:otherwise>
			
		</c:choose>
		</div>
		</div>
		