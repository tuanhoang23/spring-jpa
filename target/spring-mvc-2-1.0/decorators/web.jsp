<%--
  Created by IntelliJ IDEA.
  User: FPT SHOP
  Date: 7/26/2024
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file='/common/tablib.jsp'%>
<html>
<head>
<title>Trang chủ</title>
<link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/> " rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/small-business.css'/> " rel="stylesheet">
</head>
<body>

	<%@ include file='/common/web/header.jsp'%>
	<dec:body />
	<%@ include file='/common/web/footer.jsp'%>
	
	
	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/> "></script>
	<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/> "></script>
</body>
</html>
