<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="ch.hearc.servlet.model.Tache" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ToDo Liste application</title>
</head>
<body>

<div>
	<center>
		<h1>Liste des tâches</h1>
		
		<form action="/ToDoList/taches" method="get">
	  		<input type="submit" value="Afficher"/>
		</form>
	</center>
</div>


<ul>
<% 
	List<Tache> taches = (List<Tache>)request.getAttribute("liste_taches");

	for(Tache tache: taches){
%>
			<li><%= tache.getDescription() + ", due: " + tache.getDueDate() %></li>
<%	
	}
	
%>

</ul>
<div>
	<center>
		<h1>Ajouter une tâche</h1>
		
		<form action="/ToDoList/taches" method="post">
			
			<label size="100" for="description">Description:</label>
			<input id="description" name="description" type="text" /><br/>
			
			<label>Due date:</label>
			<input id="due_date" name="due_date" type="text" /><br/>
			
		
			<input type="submit" value="Sauver tâche"/>
		
		</form>
		
	</center>
</div>




</body>
</html>