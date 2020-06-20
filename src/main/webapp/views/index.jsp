<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="addAlien" method="post">
	aid <input type="text" name="aid"><br>
	aname <input type="text" name="aname"><br>
	 <input type="submit">
 
 </form>
 <hr>
 <form action="getAlien" method="get">
 aid<input type="text" name="aid">
 <input type="submit">
 </form>
 <hr>
 <form action="getAlienByName" method="get">
 aname<input type="text" name="aname">
 <input type="submit">
 </form>
</body>
</html>