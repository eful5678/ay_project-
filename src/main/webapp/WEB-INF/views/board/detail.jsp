<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		$("#edit").click(function(){
			var result = confirm("���� �����Ͻðڽ��ϱ�?");
			if(result){
				location.href = "${pageContext.request.contextPath}/board/del?num="+${b.num};
			}
		});
		
		$("#repWrite").click(function(){
			$.post("/rep/write",
					{
						board_num : ${b.num},
						text : $("#rep_title").val(),
						content : $("#rep_content").val()
					})
			.done(function(data){
				var items = eval("(" + data + ")");
				for(i=0;i<items.length;i++){
		    		str+=items[i].content+"(�ۼ���:"+items[i].writer+")<br>";
		    	}
				

		    	$("#reply").html(str);
			});
		});
	});
</script>
</head>
<body>

	<c:if test="${sessionScope.id ne b.writer }">
		<c:set var="data" value="readonly" />
	</c:if>
	<form action="${pageContext.request.contextPath }/board/edit" method="post">
		<table border="1" cellspacing="0">
		
			<tr>
				<td>�ۼ���</td>
				<td><input type="text" name="writer" value="${b.writer}"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="title" value="${b.title}" ${data}></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="content" value="${b.content}" ${data}></td>
			</tr>
			<tr>
				<td>�ۼ���¥</td>
				<td><input type="text" name="b_date" value="${b.b_date}"></td>
			
			</tr>
			<table border="1">
			<c:if test="${not empty file0 }">
				<tr>
					<td>�̹���</td>
					<td><img src="${pageContext.request.contextPath }/board/img?fname=${file0}&num=${b.num}" class="img" width="50" height="50"></td>
					<td><img src="${pageContext.request.contextPath }/board/img?fname=${file1}&num=${b.num}" class="img" width="50" height="50"></td>
					<td><img src="${pageContext.request.contextPath }/board/img?fname=${file2}&num=${b.num}" class="img" width="50" height="50"></td>
				</tr>
			</c:if>
			</table>
		</table>
			<input type="hidden" name="num" value="${b.num}">
			<input type="hidden" name="pwd" value="${b.pwd}">
			
			<!-- �ۼ��ڸ� ����, ���� ��ư �߰� �ϱ� -->
			<c:if test="${sessionScope.id eq b.writer}">
				<input type="submit" value="�����ϱ�">
				<input type="button" value="�����ϱ�" id="edit">
			</c:if>
			
			<!-- �����ڴ� ������ư�� �߰� �ϱ� -->
			<c:if test="${sessionScope.id eq 'admin'}">
				<input type="button" value="�����ϱ�" id="edit">
			</c:if>
	</form>
	<!-- ������ �������ϰ�쿡�� �� -->	
	<form action="" method="post">
		<table border="1">
			<tr>
				���� : <td><input type="text" id="rep_title"></td>
			</tr>
			<tr>
				���� : <td><textarea id="rep_content"></textarea></td>
			</tr>
			<tr>
				<td><input type="button" id="repWrite" value="�ۼ�" ></td>
			</tr>
		</table>
	</form>
	
	<!-- ��� �ۼ��Ǹ� �� ������ �ִ´� -->
	<div id="reply"></div>
	
	<!-- ���������� ����ϱ� -->

</body>
</html>