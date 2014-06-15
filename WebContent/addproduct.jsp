<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css" href="adminstyles.css" />
<title>Witamy Cie, kochany adminie!</title>
</head>
<body>
<%@include file="session_test.jsp" %>
    <nav><h1>Witamy w sklepie</h1></nav>
   <header id="site_head">
			<div class="header_cont">
			  <nav>
		<ul id="navlist">
			<li><a href="./addproduct">Dodaj produkty</a></li>
			<li><a href="./browse">Przegladaj</a></li>
			<li><a href="./money">Zyski</a></li>
			</ul>
			</nav>
			</div>
			</header>
		<form id="form_860448" class="appnitro"  method="post" action="">
						
			<ul >		
					<li id="li_1" >
		<label class="description" for="element_1">Nazwa produktu </label>
		<div>
			<input id="element_1" name="element_1" type="text" maxlength="255" value=""/> 
		</div> 
		</li>		<li id="li_2" >
		<label class="description" for="element_2">Cena </label>
		<div>
			<input id="element_2" name="element_2" type="text" maxlength="255" value=""/> 
		</div> 
		</li>		<li id="li_3" >
		<label class="description" for="element_3">Opis </label>
		<div>
			<textarea id="element_3" name="element_3" ></textarea> 
		</div> 
		</li>		<li id="li_4" >
		<label class="description" for="element_4">Producent </label>
		<div>
			<input id="element_4" name="element_4" type="text" maxlength="255" value=""/> 
		</div> 
		</li>		<li id="li_5" >
		<label class="description" for="element_5">Kategoria </label>
		<div>
		<select name="category">
						<c:forEach var="cat" items="${categoryList}">
							<option value="${cat.getCategoryName()}">${cat.getCategoryName()}</option>
						</c:forEach>
				</select>
				</div>
		</li>		<li id="li_6" >
		<label class="description" for="element_6">Dostępny od </label>
		<div>
			<input id="element_6" name="element_6" type="date" maxlength="255" value=""/> 
		</div> 
		</li>
			
					<li class="buttons">
			    <input type="hidden" name="form_id" value="860448" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Dodaj" />
		</li>
			</ul>
		</form>	
	

			
        <footer></footer>
</body>

</html>

