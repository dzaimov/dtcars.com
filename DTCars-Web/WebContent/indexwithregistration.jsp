<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DTCARS.com - Сайт за автомобили</title>
<link rel="stylesheet" href="css\style.css" type="text/css">
</head>
<body>
	<ul class="top-menu">
		<li><a href="car.html">Автомобили</a></li>
		<li><a href="bus.html">Бусове</a></li>
		<li><a href="truck.html">Камиони</a></li>
		<li><a href="moto.html">Мотоциклети</a></li>
		<li><a href="bike.html">Велосипеди</a></li>
	</ul>
	<hr>
	<h1>
		<a class="logo-text" href="index.html"><img alt="logo"
			src="img\car-logo.png"> DTCARS.com</a>
	</h1>
	<hr>
	<ul>
		<li><a href="index.html">Начало</a></li>
		<li><a href="publish.html">Публикуване</a></li>
		<li><a href="search.html">Търсене</a></li>
		<li><a href="dealerships.html">Автокъщи</a></li>
		<li><a href="my_profile.html">Моят профил</a></li>
	</ul>
	<hr>
	<div class="main">
		<div class="quick_search">
			<h2>Търсене</h2>
			<div>
				<form action="server.com" method="get">
					<h4>Основна Категория</h4>
					<select class="menu_category" name="category">
						<option value="car">Автомобили</option>
						<option value="bus">Бусове</option>
						<option value="truck">Камиони</option>
						<option value="moto">Мотоциклети</option>
						<option value="bike">Велосипеди</option>
					</select>
				</form>
			</div>
			<br>
			<div>
				<form action="server.com" method="get">
					<h4>Марка</h4>
					<select class="quick_left" name="brand">
						<option value="audi">Audi</option>
						<option value="bmw">BMW</option>
						<option value="fiat">Fiat</option>
						<option value="mercedes">Mercedes</option>
						<option value="opel">Opel</option>
					</select>
				</form>
				<form action="server.com" method="get">
					<h4>Модел</h4>
					<select class="quick_right" name="model">
						<option value="a6">A6</option>
						<option value="320">320</option>
						<option value="stilo">Stilo</option>
						<option value="sl63">SL63</option>
						<option value="astra">Astra</option>
					</select>
				</form>
			</div>
			<div>
				<form action="server.com">
					<h4>Максимална цена</h4>
					<input class="price" type="text" name="max_price">
				</form>
				<form action="server.com" method="get">
					<h4>Година</h4>
					<select class="quick_right" name="year">
						<option value="2016">2016</option>
						<option value="2015">2015</option>
						<option value="2014">2014</option>
						<option value="2013">2013</option>
						<option value="2012">2012</option>
					</select>
				</form>
			</div>
			<div>
				<form action="server.com" method="get">
					<h4>Двигател</h4>
					<select class="quick_left" name="engine">
						<option value="gasoline">Бензинов</option>
						<option value="diesel">Дизелов</option>
						<option value="hybrid">Хибриден</option>
						<option value="electric">Електрически</option>
					</select>
				</form>
				<form action="server.com" method="get">
					<h4>Скоростна кутия</h4>
					<select class="quick_right" name="gearbox">
						<option value="manual">Ръчна</option>
						<option value="automatic">Автоматична</option>
						<option value="semi-automatic">Полуавтоматична</option>
					</select>
				</form>
			</div>
			<div class="search_line">
				<br> <a class="full_search" href="search.html"><b>Подробно
						търсене</b></a>
				<form action="server.com">
					<input class="button" type="submit" name="search_button"
						value="Търси">
				</form>
			</div>
		</div>
		<div class="main_right">
			<table>
				<tr>
					<th scope="col">Брой обяви</th>
				</tr>
				<tr>
					<td>100</td>
				</tr>
			</table>
			<div class="sign_form">
				<%
					String name = (String) request.getAttribute("name");
					if (name == null) {
				%>
				<p>Грешенo попълнени полета при регистрация!</p>
				<div id="registrationLoginButons">
					<button
						onclick="document.getElementById('login').style.display='block'"
						style="width: auto;">Вход</button>
					<div id="login" class="modal">

						<form class="modal-content animate" action="LoginServlet"
							method="post">
							<div class="imgcontainer">
								<span
									onclick="document.getElementById('login').style.display='none'"
									class="close" title="Close Modal">&times;</span>
							</div>

							<div class="container">
								<input type="text" placeholder="Въведи имейл:" name="email"
									required> <input type="password"
									placeholder="Въведи парола:" name="password" required>

								<button type="submit">Вход</button>
								<input type="checkbox" checked="checked"> Запомни ме
							</div>

							<div class="container" style="background-color: #f1f1f1">
								<button type="button"
									onclick="document.getElementById('login').style.display='none'"
									class="cancelbtn">Затвори</button>
							</div>
						</form>
					</div>
					<button
						onclick="document.getElementById('register').style.display='block'"
						style="width: auto;">Регистрация</button>

					<div id="register" class="modal">
						<form class="modal-content animate" action="RegisterServlet"
							method="post">
							<div class="imgcontainer">
								<span
									onclick="document.getElementById('register').style.display='none'"
									class="close" title="Close Modal">&times;</span>
							</div>

							<div class="container">
								<input type="text" placeholder="Въведи имейл:" name="email"
									required> <input type="password"
									placeholder="Въведи парола:" name="password" required>
								<input type="text" placeholder="Въведи име:" name="name"
									required> <input type="text"
									placeholder="Въведи телефон:" name="phone" required> <input
									type="text" placeholder="Въведи град:" name="location" required>

								<button type="submit">Регистрация</button>
							</div>

							<div class="container" style="background-color: #f1f1f1">
								<button type="button"
									onclick="document.getElementById('register').style.display='none'"
									class="cancelbtn">Затвори</button>
							</div>
						</form>
					</div>
				</div>
				<%
					} else {
				%>
				
				<p>Регистрацията беше успешна!</p>
				<p>
					Здравейте,
					<%=name.toString()%></p>
				<%
					}
				%>

			</div>
		</div>
	</div>
</body>
</html>