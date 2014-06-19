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
      <c:forEach var="product" items="${cart.getList()}" varStatus="c">
      				 <tr>                    
                    <td>${product.getProductName()}</td>
                    <td>${product.getPriceZl()}</td>
                <!--    <td><a id="cart" href="remove/${c.index}">Usun</a> </td> -->  
                    <td>	<form name="myremove" action="remove" method="POST">
									<input type="hidden" name="toRemove" value="${c.index}">
									<input type="submit" value="Usun" />
								</form>
                    </tr>
        </c:forEach>
        <tr>
        <td>Razem: </td>
                    <td>${cart.calcTotalCost() }</td>
                     <td></td>
                    </tr>
        </table>
</div>

<div>
<form method="post" action="cart">
<td><input type="radio" name="shipping" value="Kurier" checked>Kurier</td>
<td><input type="radio" name="shipping" value="Poczta Polska" checked>Poczta Polska</td>
<input type="submit" value="Wybierz">
</form>
</div>

<form method="get" action="payment">
<input type="submit" value="Przejdz do platnosci">
</form>

</body>

</html>