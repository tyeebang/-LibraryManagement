<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정 (member 테이블)</h1>
	
	<% String id = request.getParameter("id"); %>
	
	<form action="./updateProc.jsp" method="post">
		<p>사용자 ID : <input type="text" name="id" value="<%=id%>" readonly></p>
		<p>사용자 PWD : <input type="password" name="pwd"></p>
		<input type="submit" value="수정">
		<input type="reset" value="초기화">
	</form>
	
	<br><br>
	<a href="./index.jsp">돌아가기</a>
</body>
</html>