<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js">
   
</script>
</head>
<body>

   <h3>��ǰ����Ʈ</h3>
   <table border="1" cellspacing="0">
      <thead>
         <tr>
            <th>��ȣ</th>
            <th>�̹���</th>
            <th>�̸�</th>
            <th>����Ŀ</th>
            <th>����</th>
            <th>������</th>
            <th>���</th>
            <th>����</th>
         </tr>
      </thead>
      <c:forEach var="p" items="${list}">
         <tr>
            <td>${p.num}</td>
            <td><img id="bigImg" src="${pageContext.request.contextPath }/img?fname=${file0 }&num=${p.num}" style="width:60px;height:60px"></td>
            <td><a href="${pageContext.request.contextPath }/product/detail?num=${p.num}">${p.name}</a></td>
            <td>${p.maker}</td>
            <td>${p.price}</td>
            <td>${p.origin}</td>
            <td>${p.material}</td>
            <td>${p.quantity}</td>            
         </tr>
      </c:forEach>
   </table>
   
   
   