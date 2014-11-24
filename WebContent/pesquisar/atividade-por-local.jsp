<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Pesquisar por local</h4>
 			</div>
		 <div class="panel-body">
	<form role="form" action="PesquisarAtividades.do?ref=local" method="post">
		
				 <h4>Local de atividade</h4>
			          	 
			<select class="form-control" name="localAtividade" id="local">
				<c:forEach var="local"  items="${requestScope.listaLocal }">
						<option value="${local.id }">${local.codigo } - ${local.local }</option>
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