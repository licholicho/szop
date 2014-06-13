<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css" href="styles.css" />
<title>Home</title>
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
			
      <a id="cart" href="./search">${back.loginMessage}</a>
</body>

</html>

