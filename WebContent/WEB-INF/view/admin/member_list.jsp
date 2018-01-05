<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>관리자 화면</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_member.css">
<body style="text-align: center;">
<header>
			<h1>관리자 페이지</h1>
</header>
<div id="admin_div">
			<aside id="admin_aside">
				<ul>
					<li>
						<a id="join_member" href="#">회원가입</a>
					</li>
					<li>
						보류중
					</li>
				</ul>
			</aside>
			<section id="admin_section">
			<select style="height: 30px;">
			<option value="">성별</option>
			<option value="">이름</option>
			<option value="">ID</option></select>
			<input type="text" id="searchStr" name="searchStr"/>
			<button id="searchbtn">검색</button><br /><br />
				<table id="admin_table">
					<tr>
						<th>NO</th>
						<th>ID</th>
						<th>이 름</th>
						<th>생년월일</th>
						<th>성별</th>
						<th>전화번호</th>
						<th>이메일</th>
						<th>주소</th>
					</tr>
					<tr>
						<td colspan="8"><button id="add_member_btn">추가</button></td>
					</tr>
				</table>
			</section>
</div>
<%@ include file="../common/foorter.jsp" %>
</body>
</html>