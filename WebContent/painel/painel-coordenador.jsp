<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Coordenador</h4>
 			</div>
		 <div class="panel-body">
			
		<c:choose>
			<c:when test="${requestScope.atividade.coordenador == null }">
				<p><a href="Participantes.do?ref=novo&especificacao=coordenador&id=${requestScope.atividade.id }"><button style="clear:both;float:right" type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"> </span>Adicionar Coordenador</button></a></p>
						<p>Nenhum coordenador adicionado</p>
					
							
						
			</c:when>
				<c:otherwise>
				
					
					
				<table class="table table-bordered table-hover ">
				<tr>
							<th class="tdnome">Nome</th>
							<td>${requestScope.atividade.coordenador.nome }</td>
							
				</tr>
				<tr>
							<th>Tipo</th>
							<td>${requestScope.atividade.coordenador.tipo }</td>
				</tr>
				<tr>
							<th>Setor</th>
							<td>${requestScope.atividade.coordenador.setor }</td>
				</tr>
				<tr>
							<th>Email</th>
							<td>${requestScope.atividade.coordenador.email }</td>
				</tr>
				<tr>
							<th>Telefone primário</th>
							<td>${requestScope.atividade.coordenador.telPrimario }</td>
				</tr>
					<tr>
							<th>Telefone auxiliar</th>
							<td>${requestScope.atividade.coordenador.telAuxiliar }</td>
				</tr>
					<tr>
						<th>Voluntário ?</th>
						<td>${requestScope.atividade.coordenador.voluntario }</td>
					</tr>
				<tr>
				<th>Opçoes</th>
				<td>
					<a href="Coordenador.do?ref=editar">
						<button class="btn btn-warning" type="button">Editar</button>
					</a>
					<a href="Participantes.do?ref=remover&especificacao=coordenador&id=${requestScope.atividade.id }&idParticipante=${requestScope.atividade.coordenador.id}">
						<button class="btn btn-danger" type="button">Remover</button>
					</a>
				</td>
				
				</tr>
				</table>
				</c:otherwise>
		</c:choose>	
		</div>
		</div>
		