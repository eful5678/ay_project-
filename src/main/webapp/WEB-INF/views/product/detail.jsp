<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
   $(document).ready(function() {
      $(".img").mouseover(function() {
         $("#bigImg").attr('src', this.src);
      });
   });
</script>
</head>
<body>
<h3>��ǰ ���� ����</h3>


<table border="1" cellspacing="0">
<tr>
<th>��ȣ</th>
<td><input type="text" name="num" value="${p.num }">
</td>
</tr>

<tr>
<th>��ǰ��</th>
<td><input type="text" name="name" value="${p.name }">
</td>
</tr>

<tr>
         <th>�̹���</th>
         <td><c:if test="${empty file0 }">
               ��ϵ� �̹����� �����ϴ�.
               </c:if> 
               <c:if test="${not empty file0 }">
               <table>
                  <tr>
                     <td colspan="3">
                     <img id="bigImg" src="${pageContext.request.contextPath }/img?fname=${file0 }&num=${p.num }" 
                     style="width:150px;height:150px"></td>
                  </tr>
                  <tr>
                     <td><img src="${pageContext.request.contextPath }/img?fname=${file0 }&num=${p.num }" class="img" width="50" height="50"></td>
                     <td><img src="${pageContext.request.contextPath }/img?fname=${file1 }&num=${p.num }" class="img" width="50" height="50"></td>
                     <td><img src="${pageContext.request.contextPath }/img?fname=${file2 }&num=${p.num }" class="img" width="50" height="50"></td>
               </table>
            </c:if></td>
      </tr>
      

<tr>
<th>����Ŀ</th>
<td><input type="text" name="maker" value="${p.maker }">
</td>
</tr>

<tr>
<th>����</th>
<td><input type="text" name="price" value="${p.price }">
</td>
</tr>

<tr>
<th>������</th>
<td><input type="text" name="origin" value="${p.origin }">
</td>
</tr>

<tr>
<th>���</th>
<td><input type="text" name="material" value="${p.material }">
</td>
</tr>

<tr>
<th>����</th>
<td><input type="text" name="quantity" value="${p.quantity }"></td>
</tr>

<tr>
<td colspan="2">
<input type="submit" value="����">
<input type="button" value="����" id="del">
</td>
</tr>

</table>
<a href="${pageContext.request.contextPath }/review/reviewForm">���� �ۼ�</a>
</body>
</html>