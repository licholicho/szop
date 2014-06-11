<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.user != null}">
	<form name="myform" action="/add" method="POST">
		<input type="hidden" name="prodId" value="${prod.getId()}"> <input
			type="submit" value="Dodaj do koszyka" />
	</form>
	<!--  <a id="cart" href="add/${prod.getId()}">Dodaj do koszyka</a> -->
</c:if>