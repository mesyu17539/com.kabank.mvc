<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script>
/* location.href = "hello.do"; */
 <%-- location.href = "<%=application.getContextPath() %>/member/login.do";--%>
/*  location.href = "${pageContext.request.contextPath}/user.do?cmd=move&page=login";/* get만 지울수 있다. set은 못지운다. */ 
 location.href = "${pageContext.request.contextPath}/user.do";
</script>