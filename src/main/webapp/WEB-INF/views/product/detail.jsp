<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
<a href="${pageContext.request.contextPath }/review/reviewForm">�����ۼ�</a>
</body>
</html>