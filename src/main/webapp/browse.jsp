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
					<li><a href="admin">Strona główna</a></li>
					<li><a href="addproduct">Dodaj produkt</a></li>
					<li><a href="browse">Przegladaj</a></li>
				</ul>
			</nav>
		</div>
	</header>


	<form method="post" action="/browse">
		<table>
			<tr>
				<td>Nazwa produktu:</td>
				<td><input type="text" name="producta" size="50" /></td>
				<td>Kategoria:</td>
				<td><select name="categorya">
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
							<td>${prod.getProductName()}</td>
							<%@include file="session_admin.jsp"%>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach var="prod" items="${allList}">
						<tr>
							<td>${prod.getProductName()}</td>
							<%@include file="session_admin.jsp"%>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>



		</table>
	</div>
	<footer>
		<c:if test="${currentPageS != 1}">
			<a href="browse?page=${currentPageS - 1}">Poprzednia</a>
		</c:if>

		<c:forEach begin="1" end="${noOfPagesS}" var="i">
			<c:choose>
				<c:when test="${currentPageS eq i}">
                    ${i}
                </c:when>
				<c:otherwise>
					<a href="browse?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${currentPageS lt noOfPagesS}">
			<td><a href="browse?page=${currentPageS + 1}">Następna</a>
		</c:if>


	</footer>

</body>

</html>

