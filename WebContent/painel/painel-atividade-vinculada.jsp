<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Atividades Vinculadas</h4>
 			</div>
		 <div class="panel-body">
					
				<p><a href="VincularAtividades.do?ref=novo&id=${requestScope.atividade.id }">
					<button style="clear:both;float:right;" class="btn btn-success" type="button">Adicionar Atividade</button>
					</a></p>
		
		<c:choose>
			<c:when test="${requestScope.atividade.atividades.isEmpty() }">
					
				<p>Nenhum atividade adicionada</p>
				
				
				
				
			</c:when>
			<c:otherwise>
			
			<c:forEach var="atividade" items="${requestScope.atividade.atividades }">
			<table class="table table-bordered table-hover ">
			<tr>
				<th class="tdnome">Titulo</th>
				<td>${atividade.titulo }</td>
			</tr>
			<tr>
				<th>Registro</th>
				<td>${atividade.registro }</td>
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