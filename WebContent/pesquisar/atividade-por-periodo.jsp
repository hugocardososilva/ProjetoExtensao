<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="panel panel-default">
  			<div class="panel-heading">
  					<h4>Pesquisar por per�odo</h4>
 			</div>
		 <div class="panel-body">
	<form role="form" action="PesquisarAtividades.do?ref=periodo" method="post">
		
				<label for="inicio">Data In�cio
				<input name="inicio" class="form-control" type="date"   />
				</label>
				
				<label for="fim">Data T�rmino
				<input name="fim" class="form-control" type="date"   />
				</label>
				</div>
				
				<button type="submit" class="btn btn-info">Pesquisar</button> 
	</form>
	</div>