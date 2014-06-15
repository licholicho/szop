<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css" href="styles.css" />
<title>New arrivals</title>
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
						<div class="tablecss" >
<table id="mtable" border="1" >
        <tr>
        <td>Razem: </td>
                    <td>${cart.calcTotalCost() }</td>
                    </tr>
                    
        </table>
</div>

<div>
<form method="post" action="./payment">
<td><input type="radio" name="pay" value="CreditCardStrategy" checked>Karta kredytowa</td>
<td><input type="radio" name="pay" value="PayPalStrategy" checked>PayPal</td>
<input type="submit" value="Wybierz">
</form>
</div>

<p>${msg.loginMessage}</p>
</body>

</html>