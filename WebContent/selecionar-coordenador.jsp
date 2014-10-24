<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered table-hover">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Voluntário?</th>
			<th>Setor</th>
			<th>Telefone primário</th>
			<th>Telefone auxiliar</th>
			<th>Tipo</th>
			<th>Opções</th>
			
		</tr>
		
		<c:forEach var="participante" items="${requestScope.lista }">
			<tr>
				<td>${participante.nome }</td>
				<td>${participante.email }</td>
				<td>${participante.voluntario }</td>
				<td>${participante.setor }</td>
				<td>${participante.telPrimario }</td>
				<td>${participante.telAuxiliar }</td>
				<td>${participante.tipo }</td>
				<td><a href="Participantes.do?ref=inserir&tipo=${requestScope.tipo }&id=${requestScope.id }&idParticipante=${participante.id}"><button type="button" class="btn btn-success right">Inserir</button></a></td>
				
				
			</tr>
		
		</c:forEach>
		


</table>
	
	
	
	
	