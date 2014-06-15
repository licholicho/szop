<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${pay} == "PayPalStrategy"">
<h3></h3>
</c:when>
<c:otherwise>
<form action="./cart" method="post">
<input type="submit" value="Dodaj do koszyka"/>
</form>
</c:otherwise>
</c:choose>