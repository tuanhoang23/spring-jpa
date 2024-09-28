
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file='/common/tablib.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
	<div class="sb-sidenav-menu">
		<div class="nav">
			<div class="sb-sidenav-menu-heading">Danh Mục</div>
			<a class="nav-link" href="<c:url value="/trang-chu"/> ">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				</div> Trang chủ
			</a>
			<a class="nav-link" href="<c:url value="/quan-tri/bai-viet/danh-sach?page=1&limit=2"/> ">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				</div> Danh sách bài viết
			</a>
<%--			<a class="nav-link" href="<c:url value="/quan-tri/nguoi-dung/danh-sach?page=1&limit=2"/> ">--%>
<%--				<div class="sb-nav-link-icon">--%>
<%--					<i class="fas fa-tachometer-alt"></i>--%>
<%--				</div> Danh sách người dùng--%>
<%--			</a>--%>
		</div>
	</div>
	<div class="sb-sidenav-footer">
		<div class="small">@tuanhoang</div>
	</div>
</nav>
