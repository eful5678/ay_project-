<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- Required meta tags -->
 <meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

 <!-- Option 1: Bootstrap Bundle with Popper -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<script src="/js/header.js"></script>
<style type="text/css">

	textarea {
		height: 200px;
	}
	h2{
		text-align:center;
	}
	div#side_left{
	width:200px;
	height:400px;
	float:left;
	margin:5px;
	}
</style>
<title>Review Form</title>

<script>

	function getByte(s){
		var cnt = 0;
		console.log(s.charAt());
		console.log(s.charCodeAt());
	}
	
	// 글자 수를 체크하는 기능
	function countLetter(type){
		
		console.log(type);
		if(type === "title"){
			var length = 50;
		}else if(type === "content"){
			var length = 500;
		}
		console.log(length);
		var title = document.getElementById("title");
		var pattern = /\s/g;
		getByte(title.value);
		if(title.value.match(pattern) || title.value.length < 5){
			document.getElementById("titleReg").innerHTML = "빈칸 안되고, 5글자 이상 입력하세여해요..";
		}else{
			document.getElementById("titleReg").innerHTML = "";
			
		}
		document.getElementById(type+"Span1").innerHTML = document.getElementById(type).value.length;
		if(document.getElementById(type).value.length > length){
			document.getElementById(type+"Div").style.color="red";
			document.getElementById(type+"Span2").innerHTML = "글자수 초과!!";
		}else{
			document.getElementById(type+"Div").style.color="black";
			document.getElementById(type+"Span2").innerHTML = "";
		}	
	}
	
	// 글자수가 조건에 위배되었는지를 체크
	function sub(){
		var titleLength = 50;
		var contentLength = 500;
		var title = document.getElementById("title");
		var content = document.getElementById("content");
		if(title.value.length > titleLength || content.value.length > contentLength){
			alert("글자수가 초과되었습니다.");
		}else if(title.value.length <= titleLength && content.value.length <= contentLength){
			f.submit();
		}
	}
	
	function upload(){
		
	}
</script>
</head>
<body>
<h2>리뷰 작성</h2>
<div id="df" class="card-header">
<form class="row g-3" name="f" id="f" action="${pageContext.request.contextPath }/review/write" enctype="multipart/form-data" method="POST">
	<div class="mb-3">
		<label class="form-label">작성자</label>
		<input class="form-contorl" type="text" name="writer" id="writer" value="${sessionScope.id}" readonly>
	</div>
	<div class="mb-3">
		<label class="form-label">제목</label>
		<input class="form-control" type="text" name="title" id="title" onkeyup="countLetter('title')">
		<div class="form-text">
			50글자 이내로 입력해주세요.
		</div>
		<div id="titleDiv">
					<span id="titleSpan1">0</span>/50 
					<span id="titleSpan2"></span>
					<span id="titleReg"></span>
		</div>
	</div>
	<div class="mb-3">
		<label class="form-label">구매후기</label>
		<textarea class="form-control" name="content" id="content" cols="140" onkeyup="countLetter('content')"></textarea>
		<div id="contentDiv">
					<span id="contentSpan1">0</span>/50
					<span id="contentSpan2"></span>
				</div>	
	</div>
	<div class="mb-3">
		<label class="form-label">사진첨부</label>
		<input class="form-control" type="file" name="uploadFile" multiple>
	</div>
	<div class="form-check">
		<input type="radio" name="stars" value="★☆☆☆☆">★
		<input type="radio" name="stars" value="★★☆☆☆">★★
		<input type="radio" name="stars" value="★★★☆☆">★★★
		<input type="radio" name="stars" value="★★★★☆">★★★★
		<input type="radio" name="stars" value="★★★★★">★★★★★
	</div>
	<button class="btn btn-danger" onclick="sub()">등록</button>
	<input type="hidden" name="pnum" value="${p.num }">
	<input type="hidden" name="path" value="123">
</form>
</div>
<hr>


<%-- <form name="f" action="${pageContext.request.contextPath }/review/write" enctype="multipart/form-data" method="POST">
	<table border="1">
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="title" id="title" onkeyup="countLetter('title')">
				<div id="titleDiv">
					<span id="titleSpan1">0</span>/50 
					<span id="titleSpan2"></span>
					<span id="titleReg"></span>
				</div>

			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${sessionScope.id }" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" id="content" cols="50" rows="50" onkeyup="countLetter('content')"></textarea>
				<div id="contentDiv">
					<span id="contentSpan1">0</span>/50
					<span id="contentSpan2"></span>
				</div>	
			</td>
		</tr>
		<tr>
			<th>사진 업로드</th>
			<td><input class="form-control" type="file" name="uploadFile" multiple></td>
		</tr>
		<tr>
			<th>별점</th>
			<td>
				<input type="radio" name="stars" value="★☆☆☆☆">★
				<input type="radio" name="stars" value="★★☆☆☆">★★
				<input type="radio" name="stars" value="★★★☆☆">★★★
				<input type="radio" name="stars" value="★★★★☆">★★★★
				<input type="radio" name="stars" value="★★★★★">★★★★★
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="작성" onclick="sub()">
				<input type="reset" value="지우기">
				
				<input type="hidden" name="pnum" value="${p.num }">
			</td>
		</tr>
	</table>
	
	<input type="hidden" name="path" value="123">
</form> --%>
</body>
</html>