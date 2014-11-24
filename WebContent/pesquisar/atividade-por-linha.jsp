<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Pesquisar por Linha de Extens�o</h4>
 			</div>
		 <div class="panel-body">
	<form role="form" action="PesquisarAtividades.do?ref=linha" method="post">
		
				 <h4>Linha de Extens�o da atividade</h4>
			          	 
			<select class="form-control" name="linhaAtividade" id="linha">
				<c:forEach var="linha"  items="${requestScope.listaLinha }">
						<option value="${linha.id }">${linha.numero } - ${linha.denominacao }</option>
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