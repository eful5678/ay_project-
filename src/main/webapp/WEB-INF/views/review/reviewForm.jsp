<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/review/write">
<table border="1">
<tr>
<td>����<td>
<td><input type="text" name="title"><td>
</tr>
<tr>
<td>�ۼ���<td>
<td><input type="text" name="writer" value="${sessionScope.id }" readonly><td>
</tr>
<tr>
<td>����<td>
<td><textarea name="content" cols="50" rows="50"></textarea><td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="�ۼ�">
<input type="reset" value="�����">
<input type="hidden" name="pnum" value="2">
</td>
</tr>
</table>
</form>
</body>0
</html>