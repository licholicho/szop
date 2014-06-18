<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css" href="adminstyles.css" />
<title>Witamy Cie, kochany adminie!</title>
</head>
<body>
<%@include file="session_testa.jsp" %>
    <nav><h1>Witamy w sklepie</h1></nav>
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
				<p>Witamy na stronie administratora, ${sessionScope.currentUser.getLogin()}!</p>
				<c:if test="${sessionScope.currentUser == null}">
				<h1>ZALOGUJ SIĘ</h1>
				<form action="./admin" method="post">
            Podaj login: <input name="login" type="text" value="" size="20"/>${ma.loginMessage}<br/>
            Podaj hasło: <input name="pass" type="password" size="20"/>${ma.passMessage}<br/>
            <input type="submit" value="Zaloguj się"/>
        </form>
        </c:if>
				</div>

			</div>
			
        <footer></footer>
</body>

</html>

