<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ�����ۼ�</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/pquestion/write">
	<table border="1" cellspacing="0">
	
	
	<tr>	
		<th>�ۼ���</th>	
		<td><input type="text" name="writer" value="${sessionScope.id }" readonly></td>
	</tr>
	
	<tr>
		<th>����</th>
		<td><input type="text" name="title"></td>
	</tr>
	
	
	<tr>	
		<th>����</th>
		<td><textarea name="content" cols="50" rows="50"></textarea></td>
	</tr>	
	
	<tr>
	<td>
	<input type="submit" value="�����ۼ�">
	<input type="reset" value="�����">
	<input type="hidden" name="pnum" value="${pq.num }">
	</td>
	</tr>

	</table>
</form>
</body>
</html>