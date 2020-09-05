<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Want List</title>
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
		<!-- I'll add a div here in which I can display the want list -->
		<div class = container id = "listDisplay">
			<table class = "table" id = "wantList">
				<thead>
					<tr>
						<th>Card Name</th>
						<th>Set Code</th>
						<th>Rarity</th>
						<th>Printing</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items = "${wantList}" var = "card">
					<tr>
						<td>${card.name}</td>
						<td>${card.setCode}</td>
						<td>${card.rarity}</td>
						<td>${card.printing}</td>
						<td>${card.quantity}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>			
		</div>
		
		<!-- And here I'll add buttons to add and remove cards from the want list -->
		<div class = "container">
			<form action = "add_to_want_list">
				<input type = "submit" name = "addCardsToWantList" value="Add card(s)">
			</form>	
			<form action = "remove_from_want_list">
				<input type = "submit" name = "removeCardsFromWantList" value="Remove card(s)">
			</form>
			<form action = "home">
				<input type = "submit" name = "home" value = "Return to Home">
			</form>
		</div>
	</body>
</html>
	
	