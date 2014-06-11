<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css" />
<title>Nowosci</title>
</head>
<body>
	<%@include file="session_test.jsp"%>
	<nav>
		<h1>Witamy w sklepie</h1>
	</nav>
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

	<div class="tablecss">
		<table id="mtable" border="1">


			<c:forEach var="product" items="${productList}">

				<tr>

					<td>${product.getProductName()}</td>
					<td>${product.getSupplierName()}</td>
					<td>${product.getPrice()}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<footer>
		<c:if test="${currentPage != 1}">
			<a href="newarrivals?page=${currentPage - 1}">Poprzednia</a>
		</c:if>

		<c:forEach begin="1" end="${noOfPages}" var="i">
			<c:choose>
				<c:when test="${currentPage eq i}">
                    ${i}
                </c:when>
				<c:otherwise>
					<a href="newarrivals?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${currentPage lt noOfPages}">
			<td><a href="newarrivals?page=${currentPage + 1}">Następna</a>
		</c:if>


	</footer>
</body>

</html>