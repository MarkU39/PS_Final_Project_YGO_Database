<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Card to Deck</title>
		<link href="stylesheet_name.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-success">
				<a class="navbar-brand" href="home">YGO Database</a>
				<div class="collapse navbar-collapse">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<a class="nav-link" href="home">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="add_cards">Add Cards</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="remove_cards">Remove Cards</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="search_cards">Search Cards</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="deck_lists">View/Edit Deck Lists</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="want_list">View/Edit Want List</a>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- This section contains the form through which we will get the information used to add a card -->
		<div id = "search_form_div" class = "container">
			<h3>Search Collection For Cards</h3>
			<form id = "search_form" action = "view_deck" method = "post">
				<label>Card Name</label><input type = "text" name = "cardName"><br>
				<label>Card Type</label>
				<select name = "type" id = "typeSelector">
					<option value = "monster">Monster</option>
					<option value = "spell">Spell</option>
					<option value = "trap">Trap</option>
				</select><br>
				<label>Quantity</label><input type = "text" name = "quantity"><br>
				<input type = "submit" name = "submit" value = "Add to Deck">
			</form>
		</div>
	</body>
</html>
	
	