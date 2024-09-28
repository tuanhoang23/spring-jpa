<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>


	<!-- Page Content -->
	<div class="container">

		<!-- Heading Row -->
<%--		<div class="row align-items-center my-5">
			<div class="col-lg-7">
				<img class="img-fluid rounded mb-4 mb-lg-0"
					src="http://placehold.it/900x400" alt="">
			</div>
			<!-- /.col-lg-8 -->
			<div class="col-lg-5">
				<h1 class="font-weight-light">{$news.}</h1>
				<p>This is a template that is great for small businesses. It
					doesn't have too much fancy flare to it, but it makes a great use
					of the standard Bootstrap core components. Feel free to use this
					template for any project you want!</p>
				<a class="btn btn-primary" href="#">Call to Action!</a>
			</div>
			<!-- /.col-md-4 -->
		</div>--%>
		<!-- /.row -->

		<!-- Call to Action Well -->
<%--		<div class="card text-white bg-secondary my-5 py-4 text-center">--%>
<%--			<div class="card-body">--%>
<%--				<p class="text-white m-0">This call to action card is a great--%>
<%--					place to showcase some important information or display a clever--%>
<%--					tagline!</p>--%>
<%--			</div>--%>
<%--		</div>--%>

		<header class="news-header bg-light py-3 mt-1">
			<div class=" align-items-center">
						<ul class="list-inline mb-0 d-flex justify-content-center">
							<li class="list-inline-item">
								<button class="btn btn-link">Chính trị</button>
							</li>
							<li class="list-inline-item">
								<button class="btn btn-link">Công nghệ</button>
							</li>
							<li class="list-inline-item">
								<button class="btn btn-link">Sức khỏe</button>
							</li>
							<li class="list-inline-item">
								<button class="btn btn-link">Thể thao</button>
							</li>
							<li class="list-inline-item">
								<button class="btn btn-link">Giải trí</button>
							</li>
						</ul>
			</div>
		</header>

		<!-- Content Row -->
		<div class="row mt-2">


			<c:forEach var="item" items="${news}">
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<div class="card-body">
							<h2 class="card-title">${item.title}</h2>
							<p class="card-text">${item.shortDescription}</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary btn-sm">More Info</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	
</body>
</html>