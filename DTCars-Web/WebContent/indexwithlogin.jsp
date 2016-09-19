<%@page import="com.dtcars.users.PrivateUser"%>
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
		<li><a href="index.html" class="selected">Автомобили</a></li>
		<li><a href="index_bus.html">Бусове</a></li>
		<li><a href="index_truck.html">Камиони</a></li>
		<li><a href="index_moto.html">Мотоциклети</a></li>
		<li><a href="index_bike.html">Велосипеди</a></li>
	</ul>
	<hr>
	<h1>
		<a class="logo-text" href="index.html"><img alt="logo"
			src="img/car-logo.png"> DTCARS<span class="dot_logo">.</span>com</a>
	</h1>
	<hr>
	<ul>
		<li><a href="indexwithlogin.jsp">Начало</a></li>
		<%
			PrivateUser user = (PrivateUser) request.getAttribute("user");
			if (user == null) {
				user = (PrivateUser) session.getAttribute("user");
			}
			if (user != null) {
		%>
		<li><a href="publish.html">Публикуване</a></li>
		<%
			}
		%>
		<li><a href="search.html">Търсене</a></li>
		<li><a href="dealerships.html">Автокъщи</a></li>
		<%
			if (user != null) {
		%>
		<li><a href="my_profile.html">Моят профил</a></li>
		<%
			}
		%>
	</ul>
	<hr>
	<div class="main">
		<div class="quick_search">
			<h2>Търсене</h2>
			<div>
				<form action="server.com" method="get">
					<h4>Основна Категория</h4>
					<select class="menu_category" name="category" onchange="func(this)">
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
				<form id="bike_type" action="server.com" method="get">
					<h4>Вид</h4>
					<select class="quick_left" name="bike_type">
						<option value="">Всички</option>
						<option value="city">Градски</option>
						<option value="track">Пистов</option>
						<option value="mountain">Планински</option>
						<option value="tricycle">Триколка</option>
						<option value="hybrid">Хибрид</option>
						<option value="road">Шосеен</option>
					</select>
				</form>
				<form action="server.com" method="get">
					<h4>Марка</h4>
					<select class="quick_left" name="brand">
						<option value="">Всички</option>
						<option value="Acura">Acura</option>
						<option value="Alfa romeo">Alfa romeo</option>
						<option value="Aston martin">Aston martin</option>
						<option value="Audi">Audi</option>
						<option value="Austin">Austin</option>
						<option value="Bentley">Bentley</option>
						<option value="Bmw">Bmw</option>
						<option value="Bugatti">Bugatti</option>
						<option value="Buick">Buick</option>
						<option value="Cadillac">Cadillac</option>
						<option value="Chevrolet">Chevrolet</option>
						<option value="Chrysler">Chrysler</option>
						<option value="Citroen">Citroen</option>
						<option value="Corvette">Corvette</option>
						<option value="Dacia">Dacia</option>
						<option value="Daewoo">Daewoo</option>
						<option value="Daihatsu">Daihatsu</option>
						<option value="Dodge">Dodge</option>
						<option value="Ferrari">Ferrari</option>
						<option value="Fiat">Fiat</option>
						<option value="Ford">Ford</option>
						<option value="Great Wall">Great Wall</option>
						<option value="Honda">Honda</option>
						<option value="Hyundai">Hyundai</option>
						<option value="Infiniti">Infiniti</option>
						<option value="Isuzu">Isuzu</option>
						<option value="Jaguar">Jaguar</option>
						<option value="Kia">Kia</option>
						<option value="Lada">Lada</option>
						<option value="Lamborghini">Lamborghini</option>
						<option value="Lancia">Lancia</option>
						<option value="Lexus">Lexus</option>
						<option value="Lincoln">Lincoln</option>
						<option value="Lotus">Lotus</option>
						<option value="Maserati">Maserati</option>
						<option value="Maybach">Maybach</option>
						<option value="Mazda">Mazda</option>
						<option value="McLaren">McLaren</option>
						<option value="Mercedes">Mercedes</option>
						<option value="Mg">Mg</option>
						<option value="Mini">Mini</option>
						<option value="Mitsubishi">Mitsubishi</option>
						<option value="Morgan">Morgan</option>
						<option value="Moskvich">Moskvich</option>
						<option value="Nissan">Nissan</option>
						<option value="Opel">Opel</option>
						<option value="Peugeot">Peugeot</option>
						<option value="Pontiac">Pontiac</option>
						<option value="Porsche">Porsche</option>
						<option value="Renault">Renault</option>
						<option value="Rolls-Royce">Rolls-Royce</option>
						<option value="Rover">Rover</option>
						<option value="Saab">Saab</option>
						<option value="Scion">Scion</option>
						<option value="Seat">Seat</option>
						<option value="Skoda">Skoda</option>
						<option value="Smart">Smart</option>
						<option value="Ssang yong">Ssang yong</option>
						<option value="Subaru">Subaru</option>
						<option value="Suzuki">Suzuki</option>
						<option value="Tesla">Tesla</option>
						<option value="Toyota">Toyota</option>
						<option value="Volvo">Volvo</option>
						<option value="Vw">Vw</option>
						<option value="Други">Други</option>
					</select>
				</form>
				<form id="model" action="server.com" method="get">
					<h4>Модел</h4>
					<select class="quick_right" name="model">
						<option value="">Всички</option>
					</select>
				</form>
			</div>
			<div>
				<form action="server.com">
					<h4>Максимална цена</h4>
					<input class="price" type="text" name="max_price">
				</form>
				<form id="bike_gears" action="server.com" method="get">
					<h4>Скорости</h4>
					<select class="quick_right" name="bike_gears">
						<option value="">Всички</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="12">12</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="18">18</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="24">24</option>
						<option value=">24">>24</option>
						<option value="1">без скорости</option>
					</select>
				</form>
				<form id="year" action="server.com" method="get">
					<h4>Година</h4>
					<select class="quick_right" name="year">
						<option value="2016">след 2016</option>
						<option value="2015">след 2015</option>
						<option value="2014">след 2014</option>
						<option value="2013">след 2013</option>
						<option value="2012">след 2012</option>
						<option value="2011">след 2011</option>
						<option value="2010">след 2010</option>
						<option value="2009">след 2009</option>
						<option value="2008">след 2008</option>
						<option value="2007">след 2007</option>
						<option value="2006">след 2006</option>
						<option value="2005">след 2005</option>
						<option value="2004">след 2004</option>
						<option value="2003">след 2003</option>
						<option value="2002">след 2002</option>
						<option value="2001">след 2001</option>
						<option value="2000">след 2000</option>
						<option value="1999">след 1999</option>
						<option value="1998">след 1998</option>
						<option value="1997">след 1997</option>
						<option value="1996">след 1996</option>
						<option value="1995">след 1995</option>
						<option value="1994">след 1994</option>
						<option value="1993">след 1993</option>
						<option value="1992">след 1992</option>
						<option value="1991">след 1991</option>
						<option value="1990">след 1990</option>
						<option value="1989">след 1989</option>
						<option value="1988">след 1988</option>
						<option value="1987">след 1987</option>
						<option value="1986">след 1986</option>
						<option value="1985">след 1985</option>
						<option value="1984">след 1984</option>
						<option value="1983">след 1983</option>
						<option value="1982">след 1982</option>
						<option value="1981">след 1981</option>
						<option value="1980">след 1980</option>
						<option value="1979">след 1979</option>
						<option value="1978">след 1978</option>
						<option value="1977">след 1977</option>
						<option value="1976">след 1976</option>
						<option value="1975">след 1975</option>
						<option value="1974">след 1974</option>
						<option value="1973">след 1973</option>
						<option value="1972">след 1972</option>
						<option value="1971">след 1971</option>
						<option value="1970">след 1970</option>
					</select>
				</form>
			</div>
			<div>
				<form id="engine" action="server.com" method="get">
					<h4>Двигател</h4>
					<select class="quick_left" name="engine">
						<option value="gasoline">Бензинов</option>
						<option value="diesel">Дизелов</option>
						<option value="hybrid">Хибриден</option>
						<option value="electric">Електрически</option>
					</select>
				</form>
				<form id="gearbox" action="server.com" method="get">
					<h4>Скоростна кутия</h4>
					<select class="quick_right" name="gearbox">
						<option value="manual">Ръчна</option>
						<option value="automatic">Автоматична</option>
						<option value="semi-automatic">Полуавтоматична</option>
					</select>
				</form>
			</div>
			<p id="space"></p>
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
			<div class="sign_form">
				<%
					if (user == null) {
				%>
				<h4>Грешен имейл или парола!</h4>
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
						session.setAttribute("user", user);
				%>
				<br>
				<h4>
					Здравейте,
					<%=user.getName().toString()%>
				</h4>
				<%
					}
				%>

			</div>

		</div>
	</div>

	<script type="text/javascript">
		function func(elem) {
			if (elem.value == 'bike') {
				document.getElementById("bike_type").style.display = "inline-block";
				document.getElementById("bike_gears").style.display = "inline-block";
				document.getElementById("space").style.display = "inline-block";
				document.getElementById("model").style.display = "none";
				document.getElementById("year").style.display = "none";
				document.getElementById("engine").style.display = "none";
				document.getElementById("gearbox").style.display = "none";
			} else {
				document.getElementById("bike_type").style.display = "none";
				document.getElementById("bike_gears").style.display = "none";
				document.getElementById("space").style.display = "none";
				document.getElementById("model").style.display = "inline-block";
				document.getElementById("year").style.display = "inline-block";
				document.getElementById("engine").style.display = "inline-block";
				document.getElementById("gearbox").style.display = "inline-block";
			}
		}
	</script>

</body>
</html>