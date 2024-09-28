<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.spring.util.SecurityUtils" %>
<%@ include file='/common/tablib.jsp'%>



<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">News</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
<%--				<li class="nav-item active"><a class="nav-link"--%>
<%--					href="<c:url value="/trang-chu" />">Home <span class="sr-only">(current)</span>--%>
<%--				</a></li>--%>
				<security:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/dang-nhap'/>">Đăng nhập</a></li>
<%--					<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>--%>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<security:authorize access="hasRole('USER')">
						<li class="nav-item"><a class="nav-link"
												href="" >Wellcome <%=SecurityUtils.getPrincipal().getFullname()%></a></li>
					</security:authorize>
					<security:authorize access="hasRole('ADMIN')">
						<li class="nav-item">
							<a class="nav-link" href="<c:url value='/quan-tri/trang-chu'/>">Trang Quản Trị</a>
						</li>
					</security:authorize>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a></li>
				</security:authorize>

			</ul>
		</div>
	</div>
</nav>