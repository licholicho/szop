<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${sessionScope.currentUser == null}">
<h3 id="r"><a href="./admin">Zaloguj sie</a></h3>
</c:when>
<c:otherwise><h3 id="r"><a href="./admincheckout">Wyloguj sie</a></h3> 
</c:otherwise>
</c:choose>