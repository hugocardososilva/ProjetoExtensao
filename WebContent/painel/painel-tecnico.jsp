<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Técnicos Administrativos</h4>
 			</div>
		 <div class="panel-body">
				
			<p><a href="Participantes.do?ref=novo&especificacao=tecnico&id=${requestScope.atividade.id }"><button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Técnico</button></a></p>
		<c:choose>
			<c:when test="${requestScope.atividade.tecnicos.isEmpty() }">
				
				<p>Nenhum técnico administrativo adicionado</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="tecnico" items="${requestScope.atividade.tecnicos }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Nome</th>
				<td>${tecnico.nome }</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${tecnico.email }</td>
			</tr>
			<tr>
				<th>Telefone</th>
				<td>${tecnico.telPrimario }</td>
			</tr>
			<tr>
				<th>Voluntario?</th>
				<td>${tecnico.voluntario }</td>
			</tr>
			<tr>
				<th>Opções</th>
				<td>
					<a href="Participantes.do?ref=editar&especificacao=tecnico&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">
					<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Participantes.do?ref=remover&especificacao=tecnico&id=${requestScope.atividade.id }&idParticipante=${tecnico.id}">
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