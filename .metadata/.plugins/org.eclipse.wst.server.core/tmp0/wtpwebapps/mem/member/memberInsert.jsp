<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 등록</h1>
	
	<form action="insertProc.jsp" method="post">
		<p>사용자 ID : <input type="text" name="id"></p>
		<p>사용자 PWD : <input type="password" name="pwd"></p> <br>
		<input type="submit" value="추가">
		<input type="reset" value="초기화">
	</form>
	
	<br>
	<br>
	
	<a href="./index.jsp">돌아가기</a>
</body>
</html>