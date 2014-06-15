<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${sessionScope.user == null}">
<h3 id="r"><a href="./welcome.jsp">Zaloguj sie</a></h3>
</c:when>
<c:otherwise><h3 id="r">Witaj ${sessionScope.user}!<br><a href="./cart">Koszyk</a><br><a href="./checkout">Wyloguj sie</a></h3> 
</c:otherwise>
</c:choose>