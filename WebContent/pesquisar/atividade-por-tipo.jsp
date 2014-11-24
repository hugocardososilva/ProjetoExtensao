<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Pesquisar por tipo</h4>
 			</div>
		 <div class="panel-body">
	<form role="form" action="PesquisarAtividades.do?ref=tipo" method="post">
		
				 <h4>Tipo de atividade</h4>
			          	 
			<select class="form-control" name="tipoAtividade" id="tipo">
				<c:forEach var="tipo"  items="${requestScope.listaTipo }">
						<option value="${tipo.id }">${tipo.nome }</option>
						</c:forEach>
				
			</select>
			<label for="inicio">Data In�cio
				<input name="inicio" class="form-control" type="date"   />
				</label>
				
				<label for="fim">Data T�rmino
				<input name="fim" class="form-control" type="date"   />
				</label>
				
				<button type="submit" class="btn btn-info">Pesquisar</button> 
	</form>
	</div>
	</div>