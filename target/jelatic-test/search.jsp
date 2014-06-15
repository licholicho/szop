<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css" />
<title>Szukaj</title>
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


	<form method="post" action="/search">
		<table>
			<tr>
				<td>Nazwa produktu:</td>
				<td><input type="text" name="product" size="50" /></td>
				<td>Kategoria:</td>
				<td><select name="category">
						<c:forEach var="cat" items="${categoryList}">
							<option value="${cat.getCategoryName()}">${cat.getCategoryName()}</option>
						</c:forEach>
				</select></td>
				<td><input type="submit" value="Szukaj" /></td>

			</tr>

		</table>

	</form>
	<div class="tablecss">
		<table id="mtable" border="1">
		<c:choose>
<c:when test="${productList.size() > 0}">
		<c:forEach var="prod" items="${productList}">
					<tr>
						<td>${prod.getProductName()}
						<%@include file="session_cart.jsp"%>
					</td>
					</tr>

					<tr>
						<td>asfa ea   ${prod.getProductDescription()}</td>
					</tr>
					<br>
				</c:forEach>
</c:when>
<c:otherwise>
	<c:forEach var="prod" items="${allList}">
					<tr>
						<td>${prod.getProductName()}
						<%@include file="session_cart.jsp"%>
					</td>
					</tr>

					<tr>
						<td>${prod.getProductDescription()}</td>
					</tr>
					<br>
				</c:forEach>
</c:otherwise>
</c:choose>
			
		
		
		</table>
	</div>
<footer>
		<c:if test="${currentPageS != 1}">
			<a href="search?page=${currentPageS - 1}">Poprzednia</a>
		</c:if>

		<c:forEach begin="1" end="${noOfPagesS}" var="i">
			<c:choose>
				<c:when test="${currentPageS eq i}">
                    ${i}
                </c:when>
				<c:otherwise>
					<a href="search?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${currentPageS lt noOfPagesS}">
			<td><a href="search?page=${currentPageS + 1}">Następna</a>
		</c:if>


	</footer>

</body>

</html>