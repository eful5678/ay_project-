<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="${ pageContext.request.contextPath }/member/loginForm">�α���</a>
<a href="${ pageContext.request.contextPath }/member/joinForm">ȸ������</a>
<a href="${ pageContext.request.contextPath }/mypage/mypage">����������</a>
<a href="${ pageContext.request.contextPath }/board/list">������</a>
<c:import url="${ pageContext.request.contextPath }/product/list"></c:import>
</body>
</html>