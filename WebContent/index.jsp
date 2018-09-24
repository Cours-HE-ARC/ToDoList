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
    	<h1 class="display-4">Gestion des t�ches</h1>
    	<p class="lead">Application de gestion des t�ches permettant de tester les servlet J2E</p>

</div>
</div>
 

<div class="card" style="margin-left:20px">
			
  <h3 class="card-header">Liste des t�ches</h3>
  <div class="card-body">
    <ul>
		<% 
			List<Tache> taches = (List<Tache>)request.getAttribute("liste_taches");
		
			for(Tache tache: taches){
		%>
					<li><%= tache.getDescription() + ", �ch�ance: " + tache.getDueDate() %></li>
		<%	
			}
			
		%>
		
	</ul>
  </div>
  
<div class="card">

  <h3 class="card-header">Ajouter une t�che</h3>
  <div class="card-body">
    <center>
    <form action="/ToDoList/taches" method="post">
			
			<label size="100" for="description">Description:</label>
			<input id="description" name="description" type="text" /><br/>
			
			<label>Ech�ance:</label>
			<input id="due_date" name="due_date" type="text" /><br/>
			
		
			<input type="submit" value="Sauver t�che"/>
		
		</form>
		</center>
  </div>

</div>
</div>









</body>
</html>