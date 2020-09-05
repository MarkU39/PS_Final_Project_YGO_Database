<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View/Edit Deck List</title>
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
		<div class = "container">
			<table class = "table" id = "searchResultTable">
				<thead>
					<tr>
						<th>Card Name</th>
						<th>Quantity</th>
						<th>Remove?</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Crystron Halqifibrax</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Apollousa, Bow of the Goddess</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Crystron Halqifibrax</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Apollousa, Bow of the Goddess</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Crystron Halqifibrax</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Apollousa, Bow of the Goddess</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Crystron Halqifibrax</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Apollousa, Bow of the Goddess</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Crystron Halqifibrax</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Apollousa, Bow of the Goddess</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Crystron Halqifibrax</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Apollousa, Bow of the Goddess</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Crystron Halqifibrax</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Apollousa, Bow of the Goddess</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Crystron Halqifibrax</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
					<tr>
						<td>Apollousa, Bow of the Goddess</td>
						<td>1</td>
						<td><input type = "submit" name = "removeCardFromDeck" value="Remove 1"></td>
					</tr>
				</tbody>
			</table>
			<form action = "add_to_deck">
				<input type = "submit" name = "submit" value = "Add another card">
			</form>
			<form action = "deck_lists">
				<input type = "submit" name = "submit" value = "View Other Deck">
			</form>
			<form action = "home">
				<input type = "submit" name = "submit" value = "Return to Home">
			</form>
		</div>
	</body>
</html>
	
	