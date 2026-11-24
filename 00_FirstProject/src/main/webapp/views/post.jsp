<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" %>
<%
	
	String shopName = (String)request.getAttribute("shopName");
	String address = (String)request.getAttribute("address");
	List<String> names = (List<String>)request.getAttribute("names");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국밥 등록 응답 페이지</title>
</head>
<body>

	<h1><%= shopName %> </h1>
	<p>주소지: <%= address %>입니다.</p>
	<hr />
	
	<% if(names.isEmpty()){ %>
		<p style="color : red"> 이름이 존재하지 않습니다. </p>
	<% }else{ %>	
		<ul>
		<% for(int i = 0; i < names.size(); i++){ %>
			<li><%= names.get(i)%></li>
		 <% } %>
		</ul>
	<% } %>
	
	
</body>
</html>