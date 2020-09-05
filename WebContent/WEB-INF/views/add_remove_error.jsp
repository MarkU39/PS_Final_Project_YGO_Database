<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Error During Add/Remove</title>
		<link href="stylesheet_name.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-success">
				<a class="navbar-brand" href="./home.html">YGO Database</a>
				<div class="collapse navbar-collapse">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<a class="nav-link" href="./home.html">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./add_remove.html">Add/Remove Cards</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./record_trade.html">Record Trade</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./search_cards.html">Search Cards</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./deck_lists.html">View/Edit Deck Lists</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./want_list.html">View/Edit Want List</a>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		
		
		<h3>Error</h3>
		<p>An error occurred; please try again.</p>
		
		<form action = "home" method = "get">
			<input type = "submit" value="Return to Home">
		</form>
	</body>
</html>
	