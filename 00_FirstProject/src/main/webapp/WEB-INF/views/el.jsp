<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 및 JSTL 공부하기</title>
</head>
<body>
	<h1>만들기</h1>

<h3>EL구문 사용해보기</h3>

학생의 이름 : ${ student.name } <br/>
학생의 주소 : ${ student.address } <br/> 

<button onclick="hwang();">황비홍버튼</button>

<script>
	function hwang(){
	const name = '황비홍';
	const str = '점심밥';
	alert(`문자열은 : \${name}`);
	}
</script>

<p>없는 키값 출력 하는 경우</p>

<%-- 서버의 주석
<p>출력식을 씀: <%= asddkjfl %> 서버가 터짐</p>
 --%>
<p>EL 구문을 씀 (빈문자열) : ${asdkfja} </p>

num : ${num } <br/>
str : ${str } <br/>
list : ${list } <br/>

${1+2}
${2>1}

<h4>동등비교</h4>

${"안녕" eq '안녕'} 또는 ${"안녕"=='안녕'}


</body>
</html>