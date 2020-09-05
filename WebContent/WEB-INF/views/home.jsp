<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>YGO Database Home</title>
		<link href="./WebContent/WEB-INF/views/home_style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-success">
				<a class="navbar-brand" href="home">YGO Database</a>
			</nav>
		</header>
		<div id = "menu" class = "container">
			<br />
			<div class = "row">
				<div class = "col-sm">
					<form:form method = "GET" action = "add_cards">
						<input type = "submit" value="Add Cards to Collection">
					</form:form>
				</div>
				<div class = "col-sm">
					<form:form method = "GET" action = "remove_cards">
						<input type = "submit" value="Remove Cards from Collection">
					</form:form>
				</div>
			</div>
			<br />
			<div class = "row">
				<div class = "col-sm">
					<form:form method = "GET" action = "want_list">
						<input type = "submit" value="View/Edit Want List">
					</form:form>
				</div>
				<div class = "col-sm">
					<form:form method = "GET" action = "deck_lists">
						<input type = "submit" value="View/Edit Deck Lists">
					</form:form>
				</div>
			</div>
			<br>
			<div class = "row">
				<div class = "col-sm">
					<form:form method = "GET" action = "search_cards">
						<input type = "submit" value="Search Collection for Cards">
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>
	
	