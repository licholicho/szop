<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css" href="styles.css" />
<title>Witamy</title>
</head>
<body>
<%@include file="session_test.jsp" %>
    <nav><h1>Witamy w sklepie</h1></nav>
   <header id="site_head">
			<div class="header_cont">
			  <nav>
		<ul id="navlist">
			<li><a href="./home">Strona główna</a></li>
			<li><a href="./newarrivals">Nowości</a></li>
			<li><a href="./search">Szukaj</a></li>
			</ul>
			</nav>
			</div>
			</header>
	
			
<div id="main">
				<div id="prawa">
				<h1>ZALOGUJ SIĘ</h1>
				<form action="./login" method="post">
            Podaj login: <input name="login" type="text" value="" size="20"/>${messageL.loginMessage}<br/>
            Podaj hasło: <input name="pass" type="password" size="20"/>${messageL.passMessage}<br/>
            <input type="submit" value="Zaloguj się"/>
        </form>
				</div>
				<div id="lewa">
				<h1>NIE MASZ KONTA? ZAREJESTRUJ SIĘ!</h1>
					   <form name="rform" action="./register" method="POST">
            Podaj login: <input name="loginr" type="text" value="" size="20"/> ${messageR.loginMessage}<br/>
            Podaj hasło: <input name="passr" type="password" size="20"/> ${messageR.passMessage}<br/>
            <input type="submit" value="Zarejestruj się" />
        </form>
				</div>

			</div>
			
        <footer></footer>
</body>

</html>

