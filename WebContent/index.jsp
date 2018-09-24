<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="ch.hearc.servlet.model.Tache" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ToDo Liste application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
    	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
    	crossorigin="anonymous">
</head>
<body>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    	<h1 class="display-4">Gestion des tâches</h1>
    	<p class="lead">Application de gestion des tâches permettant de tester les servlet J2E</p>

</div>
</div>
 

<div class="card" style="margin-left:20px">
			
  <h3 class="card-header">Liste des tâches</h3>
  <div class="card-body">
    <ul>
		<% 
			List<Tache> taches = (List<Tache>)request.getAttribute("liste_taches");
		
			for(Tache tache: taches){
		%>
					<li><%= tache.getDescription() + ", échéance: " + tache.getDueDate() %></li>
		<%	
			}
			
		%>
		
	</ul>
  </div>
  
<div class="card">

  <h3 class="card-header">Ajouter une tâche</h3>
  <div class="card-body">
    <center>
    <form action="/ToDoList/taches" method="post">
			
			<label size="100" for="description">Description:</label>
			<input id="description" name="description" type="text" /><br/>
			
			<label>Echéance:</label>
			<input id="due_date" name="due_date" type="text" /><br/>
			
		
			<input type="submit" value="Sauver tâche"/>
		
		</form>
		</center>
  </div>

</div>
</div>









</body>
</html>