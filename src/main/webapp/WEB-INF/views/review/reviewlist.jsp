<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

 <!-- Required meta tags -->
 <meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

 <!-- Option 1: Bootstrap Bundle with Popper -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

<!-- highlight -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.5.0/stylesdefault.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.5.0/highlight.min.js">
</script> <script>hljs.initHighlightingOnLoad();</script>

<style>
.highlight{
	color: yellow;
}
</style>
<script>
/**
 * @author Hyun Jin Kim
 * 2021.02.25
 * 기능 : 리뷰 리스트 출력
 */
 
 
/**
 * 기능 : 기준에 따라 리스트를 정렬 : 최신순 / 좋아요순 / 별점
 * @param criteria : 정렬의 기준을 받아오는 parameter
 * @return p_num
 * @return what
 */
 
function sort(criteria){
	var what = document.getElementById(criteria);
	var xhttp = new XMLHttpRequest();
	console.log("선택된 기준에 따라 정렬");
	console.log("선택된 기준 : " + what.value);
	
	console.log("type : " + typeof(what.value));
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState === 4 && xhttp.status === 200){
			if(what.value === "like" || what.value === "latest" || what.value === "1"|| what.value === "2"|| what.value === "3"|| what.value === "4"|| what.value === "5"){
				console.log("입력에 따른 반환 값 : " + xhttp.responseText);
				
				print(xhttp);
				
			}else{
				console.log("what : " + what.value)
				highlight(what,xhttp);
			}
		}
	}
	xhttp.open("POST", "/review/list?p_num=${p.num}&what=" + what.value, true);
	xhttp.send();
}

function highlight(what, xhttp){
	
	if(what.value==""){
		print(xhttp);
	}else{
		var reAll = new RegExp(what.value, "g");
		console.log(reAll);	
		console.log(xhttp.responseText.indexOf("<pre>"));
		console.log(xhttp.responseText.lastIndexOf("</pre>"));
		var start = xhttp.responseText.indexOf("<pre>");
		var end = xhttp.responseText.lastIndexOf("</pre>");
		var c = xhttp.responseText[start]+xhttp.responseText[end];
		var b = 0;
		console.log("type of start : " + typeof(start));
		console.log(a);
		console.log("범위 : " + xhttp.responseText[start,end].replace(reAll, "XX"));
		console.log(end-start);
		var key = [];
		for(var i = start; i <= end; i++){
			
			b += xhttp.responseText[i];
			
		}
		console.log("b : " + b);
		
		var a = document.querySelector("#ntable");
		var q = document.querySelector("#content2");
		var z = document.querySelector("#content3");
		var l = document.querySelector("#content1");
		
		
		console.log(q);
		
		console.log(a);
		console.log(z);
		
		//a.innerHTML = xhttp.responseText.replace(reAll, "<font color='red'>" + what.value + "</font>");
		//t.innerHTML = b.replace(reAll, "<font color='red'>" + what.value + "</font>");
		//console.log("t : " + xhttp.responseText.b);
		a.innerHTML = xhttp.responseText;
		var t = document.getElementsByTagName("PRE");
		
		console.log("t : " + t.value);
		
		//z.innerHTML = "asdfasdf";	
		//q.innerHTML = "dfdf";
		
		console.log("pre : " );
		console.log("div : " + l);
		//z.innerHTML = z.replace(reAll, "<font color='red'>" + what.value + "</font>");
		console.log("D : "  + document.querySelector("#content3").replace(reAll, "<font color='red'>" + what.value + "</font>"));
		
		//a.innerHTML = xhttp.responseText[].replace(reAll, "<font color='red'>" + what.value + "</font>");
		
		//a.innerHTML = xhttp.responseText[b].replace(reAll, "<font color='red'>" + what.value + "</font>");
		
		
		
		//console.log(a.innerHTML);
		
		
		//content.innerHTML // PRE replacee
		
		
		
	}
	

	
}

function print(xhttp){
	
	
	document.querySelector("#ntable").innerHTML = xhttp.responseText;
	
}

function rating(hi, r_num){
	var type = null;
	var rnum = document.getElementById("rnum");
	var xhttp = new XMLHttpRequest();
	console.log("현재 리뷰 글 번호 : " + r_num);	
	
	if(hi === "like"){
		type = "like";
	}else{
		type = "hate";
	}
	console.log("선택된 기능 : " + type);

	xhttp.onreadystatechange = function(){
		if(xhttp.readyState === 4 && xhttp.status === 200){
			console.log("입력에 따른 반환 값 : " + xhttp.responseText);
			
			if(xhttp.responseText === "로그인을 하여야 좋아요 기능을 이용할 수 있습니다."){
				alert("로그인을 하여야 좋아요 기능을 이용할 수 있습니다.");
			}else if(xhttp.responseText === "이미 좋아요를 누르셨습니다."){
				alert("${sessionScope.id}님 이미 좋아요를 누르셨습니다.");	
			}else{
				ratingPrint(xhttp, r_num);
			}
		}
	}
	xhttp.open("POST", "/review/reviewRating?num="+r_num+"&type="+type, true);
	xhttp.send();
}

function ratingPrint(go, r_num){
	
	document.querySelector("#rating"+r_num).innerHTML = go.responseText;	
}

function newImg(){	
	var img = document.getElementsByTagName("img");
	for(var x = 0; x < img.length; x++){
		img.item(x).onclick=function(){window.open(this.src)}
	}

}


</script>
</head>
<body>
	<h3>리뷰</h3>
	<nav class="navbar navbar-expand-lg navbar-danger bg-danger">
		<div class="container-fluid">
			<div class="collpase navbar-collapse">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<div class="btn-group" role="group" aria-label="Basic exmaple">
						<button class="btn btn-danger" id="likesort" value="like" onclick="sort('likesort')">좋아요순</button>
						<button class="btn btn-danger" id="latest" value="latest" onclick="sort('latest')">최신순</button>
						</div>
				</ul>
			<div>
				<input class="form-control me-2" type="text" placeholder="search" id="word" onkeyup="sort('word')">
			</div>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item dropdown">
						<select class="form-select" id="byStar" onchange="sort('byStar')">
							<option value="none">평점 별 정렬</option>
							<option value="1">★☆☆☆☆</option>
							<option value="2">★★☆☆☆</option>
							<option value="3">★★★☆☆</option>
							<option value="4">★★★★☆</option>
							<option value="5">★★★★★</option>
						</select>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<nav id="ntable">
	<c:forEach var="r" items="${list}">
	<div>
	<hr class="bg-danger" size="5px">
		${r.writer } 님<br>
		<div>
			<span class="text-danger fs-2">${r.stars }</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${r.pdate}" /><br>
		</div>
		<br>
		<a href="${pageContext.request.contextPath }/review/reviewDetail?num=${r.num}&p_num=${p.num }" class="text-secondary">${p.name }</a><br><br>
        <img src="${pageContext.request.contextPath }/review/img?fname=${r.path }&num=${r.num }" style="width:150px;height:150px" onclick="newImg()">
        <img src="${pageContext.request.contextPath }/review/img?fname=${r.path1 }&num=${r.num }" style="width:150px;height:150px" onclick="newImg()">
        <img src="${pageContext.request.contextPath }/review/img?fname=${r.path2 }&num=${r.num }" style="width:150px;height:150px" onclick="newImg()">
        <br>
        <div id="content1">
        <input id="content2" type="hidden" value="${r.content }">
        <pre id="content3"><c:out value="${r.content }"/></pre><br>
        </div>
		<div class="btn-group" role="group" aria-label="Basic exmaple">
			<button class="btn btn-danger" id="like" value="like" onclick="rating('like', ${r.num})">종아요</button>
			<button class="btn btn-danger" id="hate" value="hate" onclick="rating('hate', ${r.num})">싫어요</button>
		</div>
			<span id="rating${r.num }">${r.likey }</span> 명이 좋아합니다. 
	</div>	
	</c:forEach>
	</nav>
</body>
</html>