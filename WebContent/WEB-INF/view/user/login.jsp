<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/index.css" /><!-- URL 링크 잡기. -->
<body>
<div id="wrapper">
<header id="index_header">
	홈즈
</header>
<section id="index_section">
	<article>
		<table id="index_table">
			<tr>
				<th colspan="5"><a href="#">HOME</a></th>
			</tr>
			<tr>
				<td colspan="5">
				<form id="auth_form" action="${ctx}/user/auth.do">
					<table id="index_login_box">
						<tr>
							<td><input id="index_input_id" name="id" type="text" placeholder="id" tabindex="1" value="23"/></td>
							<td rowspan="2"><button id="index_input_btn">로그인</button></td>
						</tr>
						<tr>
							<td><input id="index_input_password" name="pass" type="password" placeholder="pass" tabindex="2" value="23"/></td>
						</tr>
					</table>
				</form>
				<a id="go_join_link" href="#">
					처음 오셨나요 
				</a>
				<a id="go_admin_link" href="#">
					관리자
				</a>
				<a id="go_JDBC_link" href="#">
					JDBCTest
				</a>
				</td>
			</tr>
		</table>
	</article>
</section>
</div>
<%@ include file="../common/foorter.jsp" %>
</body>
<script>
document.querySelector('#go_join_link').addEventListener("click",function () {
	alert("짜란");
	location.href="${pageContext.request.contextPath}/user/join_form.do"
},false);
document.querySelector('#go_JDBC_link').addEventListener("click",function(){
	alert("JDBC");
	location.href="${pageContext.request.contextPath}/common/jdbc_test.do"
},false);
document.querySelector('#go_admin_link').addEventListener("click",function(){
	alert("관리자");
	location.href="${pageContext.request.contextPath}/admin/main.do"
},false);
document.querySelector('#index_input_btn').addEventListener("click",function(){
	alert("로그인");
	document.querySelector('#auth_form').submit();
},false);
</script>
</html>