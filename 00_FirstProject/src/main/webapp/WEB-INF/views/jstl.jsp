<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL</h1>

	<c:if test="${redFruit eq 'apple'}">
		<p style="color :red">사과</p>	
		</c:if>
<hr/>

	<c:choose> 
		<c:when test="${yellowFruit eq 'banana' }">
				<p style="color : yellow">바나나</p>
			</c:when>
			<c:otherwise>
				<p> 안바나나</p>
			</c:otherwise>
		</c:choose>
<hr/>
	<table border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>주소지</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${ empty list }">
					<tr>
						<th colspan="2">조회결과가 존재하지 않습니다.</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="p" items="${list}">
						<tr>
							<td>${p.name}</td>
							<td>${p.address}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	
	<c:forEach var="i" begin="1" end="6">
		<h${i}>이런것도 가능</h${i}>
	</c:forEach>
	
	
	<c:remove var="redFruit" />
	${redFruit}	
	
</body>
</html>