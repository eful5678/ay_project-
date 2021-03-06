<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 페이지입니다!</title>
 <!-- Required meta tags -->
 <meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

 <!-- Option 1: Bootstrap Bundle with Popper -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
 
 
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>

 
<script type="text/javascript">
function go() {
	var id = document.getElementById("id");
	var password = document.getElementById("password");
		
	if(id.value == ""){
		alert("아이디를 작성해주세요! ")
		return
	}
	if(password.value == ""){
		alert("비밀번호를 작성해주세요!")
		return
	}else{
		formName.submit()
	}
}

// https://solbel.tistory.com/217
function press(f) {
	var id = document.getElementById("id");
	var password = document.getElementById("password");
	
	if (f.keyCode == 13) { // 13 = enter키
		alert("enter");
		if(id.value == ""){
			alert("아이디를 작성해주세요! ");
			return;
		}
		if(password.value == ""){
			alert("비밀번호를 작성해주세요!");
			return;
		}else{
			formName.submit();
		}
	}
}
</script>
<script>
$(document).ready(function(){
  $('#showPassword').on('click', function(){
    var passwordField = $('#password');
    var passwordFieldType = passwordField.attr('type');
    if(passwordFieldType == 'password')
    {
    	passwordField.attr('type', 'text');
    	$(this).val('Hide');
    } else {
    	passwordField.attr('type', 'password');
    	$(this).val('Show');
    }
  });
  // https://stackoverflow.com/questions/477691/submitting-a-form-by-pressing-enter-without-a-submit-button
  $('form').each(function() { // each = 선택한 요소 각각에 대하여 함수를 실행시키고 싶을 경우
	$(this).find('input').keypress(function(e) {
		if (e.which == 13) { // 13 = enter
			this.form.submit();
		}
	});
  }); 
});
</script>
<style type="text/css">
hr{
background-color:red;
}
.vertical-center {
  min-height: 100%;
  min-height: 100vh; 
  display: flex;
  align-items: center;
}
h2{
text-align:center;
color;
}
input{
border:1px;
}
div{
width:400px;
}
</style>
</head>
<body>
		<h2 class="text-danger">관리자로그인</h2>
		<hr>
<div class="container-fluid vertical-top d-flex justify-content-center">
<form name="formName" method="POST" action="${pageContext.request.contextPath }/admin/login">
	<div id="container" class="container">
	<div class="input-group mb-3 input-group-lg">
      		<input class="form-control" type="text" name="id" id="id" placeholder="아이디를 입력해주세요.">
      	</div>
		<div class="input-group mb-3 input-group-lg">
      		<input class="form-control" type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요.">&nbsp;
    	</div>
			<div class="card card-outline-secondary my-4">
			<button class="btn btn-danger" onclick="go()" id="passwordCheck" onclick="go()">로그인</button>
		</div>
		</div>
</form>

</div>
</body>
</html>