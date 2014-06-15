<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<td><form name="myform" action="/update" method="POST">
		<input type="hidden" name="prodIdA" value="${prod.getId()}"> <input
			type="submit" value="Aktualizuj" />
	</form></td>
	<td><form name="myform" action="/delete" method="POST">
		<input type="hidden" name="prodIdA" value="${prod.getId()}"> <input
			type="submit" value="Usun" />
	</form></td>