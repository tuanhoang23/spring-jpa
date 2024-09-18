<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file='/common/tablib.jsp'%>
<html>
<head>
	<title>Admin</title>
	<link href="<c:url value='https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css'/>"rel="stylesheet" >
	<link href="<c:url value='/template/admin/css/styles.css' />"rel="stylesheet" >
	<link href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />"rel="stylesheet" >
	<link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/> " rel="stylesheet"> 
	<script src="<c:url value="https://code.jquery.com/jquery-3.6.0.min.js"/>"></script>
	
</head>

<body class="sb-nav-fixed">

	<%@ include file="/common/admin/header.jsp"%>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<%@ include file="/common/admin/menu.jsp"%>
		</div>
		<div id="layoutSidenav_content">
			<dec:body />
			<%@ include file="/common/admin/footer.jsp"%>
		</div>
	</div>

	<script src="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/scripts.js' />"></script>
	<script src="<c:url value='/template/admin/paging/jquery.twbsPagination.js'/>"></script>
	<script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js'/>"></script>
	<script src="<c:url value='https://use.fontawesome.com/releases/v6.3.0/js/all.js'/>"></script>

</body>
</html>
