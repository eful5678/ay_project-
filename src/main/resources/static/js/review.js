/**
 * reviewlist
 */

	function sort(criteria){
	var what = document.getElementById(criteria);
	var xhttp = new XMLHttpRequest();
	console.log("선택된 기준에 따라 정렬");
	console.log("선택된 기준 : " + what.value);
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState === 4 && xhttp.status === 200){
			console.log("입력에 따른 반환 값 : " + xhttp.responseText);
			print(xhttp);
			
		}
	}
	
	xhttp.open("POST", "/review/list?p_num=${p.num}&what=" + what.value, true);
	xhttp.send();
}

function print(xhttp){
	console.log(xhttp.responseText);
	document.querySelector("#ntable").innerHTML = xhttp.responseText;
}

function rating(hi, r_num){
	var type = null;
	if(hi === "like"){
		type = "like";
	}else{
		type = "hate";
	}
	var rnum = document.getElementById("rnum");
	console.log(type);
	
	console.log(typeof(r_num));
	console.log(r_num);
	

	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState === 4 && xhttp.status === 200){
			console.log("입력에 따른 반환 값 : " + xhttp.responseText);
			document.querySelector("#rating"+r_num).innerHTML = xhttp.responseText;
		}
		
	}
	xhttp.open("POST", "/review/reviewRating?num="+r_num+"&type="+type, true);
	xhttp.send();
}
/**
 * reviewDetail
 */

/**
 * reviewForm
 */

