<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Pesquisar por Coordenador</h4>
 			</div>
		 <div class="panel-body">
	<form role="form" action="PesquisarAtividades.do?ref=coordenador" method="post">
		
				 <h4>Coordenador da atividade</h4>
			          	 
			<select class="form-control" name="coordenadorAtividade" id="coordenador">
				<c:forEach var="coordenador"  items="${requestScope.listaCoordenador }">
						<option value="${coordenador.id }">${coordenador.nome }</option>
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