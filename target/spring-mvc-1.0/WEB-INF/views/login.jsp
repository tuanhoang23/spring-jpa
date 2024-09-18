<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file='/common/tablib.jsp'%>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" href="<c:url value="/template/login/style.css"/>" />
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">

			<!-- Tabs Titles -->
			<div>
				<h2 class="mb-3">Login</h2>
				<h6 class="mb-3">Welcom to system</h6>
			</div>
			<c:if test="${param.incorrectAccount != null}">
				<div class="alert alert-danger m-3" role="alert">sai tài khoản hoặc mật khẩu</div>
			</c:if>
			<c:if test="${param.accessDenied != null}">
				<div class="alert alert-warning m-3" role="alert">Đăng nhập tài khoản có quyền</div>
			</c:if>
			<!-- Login Form -->
			<form action="j_spring_security_check" method="post" id="formlogin">
				<!-- <input type="text" id="userName" class="fadeIn second" name="j_userName" placeholder="UserName"> 
				<input type="password" id="password" class="fadeIn third" name="j_password" placeholder="Password"> 
				<input type="submit" class="fadeIn fourth" value="Log In"> -->
				<div class="form-group">
					<input type="text" class="form-control p-2" id="userName"
						name="j_username" placeholder="Tên đăng nhập">
				</div>

				<div class="form-group">
					<input type="text" class="form-control p-2 custom_pass" id="password"
						name="j_password" placeholder="Mật khẩu">
				</div>
				<button type="submit" class="btn btn-primary mb-3">Đăng nhập</button> 


				
			</form>

		</div>
	</div>
</body>
</html>