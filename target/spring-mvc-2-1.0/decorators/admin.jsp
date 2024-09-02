<%--
  Created by IntelliJ IDEA.
  User: FPT SHOP
  Date: 7/26/2024
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file='/common/tablib.jsp'%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Admin</title>
<link
	href="<c:url value='https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/template/admin/css/styles.css' /> "
	rel="stylesheet" />
<script
	src="<c:url value='https://use.fontawesome.com/releases/v6.3.0/js/all.js'/>"
	crossorigin="anonymous"></script>
	<link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/> " rel="stylesheet">
	
</head>
<body class="sb-nav-fixed">


	<%@ include file='/common/admin/header.jsp'%>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<%@ include file='/common/admin/menu.jsp'%>
		</div>
		<div id="layoutSidenav_content">
			<dec:body />
			<%@ include file='/common/admin/footer.jsp'%>
		</div>
	</div>




	<script
		src="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' />"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/template/admin/js/scripts.js' />"></script>
	<script
		src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js'/>"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value='/template/admin/assets/demo/chart-area-demo.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/demo/chart-bar-demo.js' />"></script>
	<script
		src="<c:url value='https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js'/>"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value='/template/admin/js/datatables-simple-demo.js' />"></script>

</body>
</html>
