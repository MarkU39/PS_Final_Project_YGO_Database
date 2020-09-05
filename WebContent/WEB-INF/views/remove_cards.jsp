<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Remove Cards from Collection</title>
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
		<div class = "container" id = "add_remove_form">
			<!-- This section details the form for adding/removing cards -->
			<h3> Remove Cards from Collection </h3>
			<form:form method = "POST" action = "${pageContext.request.contextPath}/remove_cards" modelAttribute = "card">
				<table>
					<tr>
						<td><form:label path = "name">Card Name</form:label></td>
						<td><form:input path = "name"></form:input></td>
					</tr>
					<tr>
						<td><form:label path = "setCode">Set Code</form:label></td>
						<td><form:input path = "setCode"></form:input></td>
					</tr>
					<tr>
						<td><form:label path = "rarity">Rarity</form:label></td>
						<td>
							<form:select path = "rarity">
								<form:option value = "common" label = "Common"/>
								<form:option value = "rare" label = "Rare"/>					
								<form:option value = "super" label = "Super Rare"/>
								<form:option value = "ultra" label = "Ultra Rare"/>
								<form:option value = "secret" label = "Secret Rare"/>
								<form:option value = "ultimate" label = "Ultimate Rare"/>
								<form:option value = "dt" label = "Duel Terminal"/>
								<form:option value = "prismatic" label = "Prismatic Secret Rare"/>
								<form:option value = "starlight" label = "Starlight Rare"/>
								<form:option value = "gold" label = "Gold Rare"/>
								<form:option value = "goldSecret" label = "Gold Secret Rare"/>
								<form:option value = "premiumGold" label = "Premium Gold Rare"/>
								<form:option value = "otherFoil" label = "Other Foiling"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td><form:label path = "printing">Printing</form:label></td>
						<td>
							<form:select path = "printing">
								<form:option value = "unlimited" label = "Unlimited"/>
								<form:option value = "first" label = "1st Edition"/>					
								<form:option value = "ltd" label = "LIMITED EDITION"/>
								<form:option value = "dt" label = "DUEL TERMINAL"/>
							</form:select>
						</td>
					</tr>
					<tr><td><input type = "submit" value = "Submit"></td></tr>	
				</table>
			</form:form>
			<form action = "home">
				<input type = "submit" value = "Return to Home"> 
			</form>
		</div>
	</body>
</html>
	
	