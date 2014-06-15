<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="adminstyles.css" />
<title>Witamy Cie, kochany adminie!</title>
</head>
<body>
	<%@include file="session_testa.jsp"%>
	<nav>
		<h1>Witamy w sklepie</h1>
	</nav>
	<header id="site_head">
		<div class="header_cont">
			<nav>
				<ul id="navlist">
					<li><a href="./admin">Strona główna</a></li>
					<li><a href="./addproduct">Dodaj produkt</a></li>
					<li><a href="./browse">Przegladaj</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<div id="main">
		<div id="prawa">
			<h3>Dodaj nowy produkt</h3>
			<form method="post" action="/addproduct">

				<ul>
					<li id="li_1"><label for="element_1">Nazwa produktu </label>
						<div>
							<input id="element_1" name="prodname" type="text" maxlength="255" size="50" />
						</div></li>
					<li id="li_2"><label for="element_2">Cena </label>
						<div>
							<input id="element_2" name="prodprice" type="text"
								maxlength="255" />
						</div></li>
					<li id="li_3"><label for="element_3">Opis </label>
						<div>
							<textarea id="element_3" name="proddesc"></textarea>
						</div></li>
					<li id="li_4"><label for="element_4">Producent </label>
						<div>
							<select name="prodsupplier">
								<c:forEach var="sup" items="${supList}">
									<option value="${sup.getId()}">${sup.getName()}</option>
								</c:forEach>
							</select>
						</div></li>
					<li id="li_5"><label for="element_5">Kategoria</label>
						<div>
							<select name="prodcat">
								<c:forEach var="cat" items="${catList}">
									<option value="${cat.getId()}">${cat.getCategoryName()}</option>
								</c:forEach>
							</select>
						</div>
					<li><input id="saveForm" class="button_text" type="submit"
						name="submit" value="Dodaj" /></li>
				</ul>
			</form>

			<p>${mp.loginMessage}</p>

			<form method="post" action="/addcat">
				<div>
					<h3>Dodaj nową kategorię</h3>
					<input name="newcat" type="text" maxlength="255" /> <input
						type="submit" name="submitcat" value="Dodaj kategorię" />
				</div>
			</form>

			<form method="post" action="/addsupplier">
				<div>
					<h3>Dodaj nowego dostawcę</h3>
					<input name="newsup" type="text" maxlength="255" /> <input
						type="submit" name="submitsup" value="Dodaj producenta" />
				</div>
			</form>
		</div>
	</div>
	<footer></footer>
</body>

</html>

