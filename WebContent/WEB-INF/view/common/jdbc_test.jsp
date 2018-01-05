<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>JDBC</title>
</head>
<body>
	JDBC TEST
	DB에 있는 테이블 수는 ${requestScope.count}개 입니다<!-- requestScope 내에 count라는 id에 value를 지정해 놓았으니 가져가라 -->
</body>
</html>