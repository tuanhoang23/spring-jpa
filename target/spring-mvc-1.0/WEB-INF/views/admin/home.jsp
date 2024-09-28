<%@ page import="com.spring.util.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
</head>
<body>


	<main class="content">
		<div class="container-fluid p-0">
			<div class="container">
				<h1 style="text-align: center;">Chào mừng đến với trang quản trị</h1>
				<p>Xin chào <%= SecurityUtils.getPrincipal().getFullname() %>! Cảm ơn bạn đã đăng nhập vào trang quản trị của web tin tức.</p>
				<p>Hãy quản lý và cập nhật nội dung tin tức của bạn một cách hiệu quả!</p>

				<h2 style="text-align: center;">Chỉ dẫn sử dụng:</h2>
				<ul>
					<li><strong>Thêm tin tức:</strong> Vào danh sách bài viết chọn mục "Thêm mới" trong menu để thêm các bài viết mới.</li>
					<li><strong>Chỉnh sửa tin tức:</strong> Vào danh sách bài viết, nhấp vào nút "Chỉnh sửa" bên cạnh bài viết mà bạn muốn thay đổi.</li>
					<li><strong>Xóa tin tức:</strong> Trong danh sách bài viết, chọn bài viết và nhấp vào nút "Xóa" để xóa bài viết không còn cần thiết.</li>
					<li><strong>Đăng xuất:</strong> Để đăng xuất khỏi trang quản trị, hãy nhấp vào icon ở góc trên bên phải và chọn "Thoát".</li>
				</ul>

				<p>Nếu bạn cần hỗ trợ, vui lòng liên hệ với bộ phận kỹ thuật qua email:support@website.com.</p>
			</div>

		</div>
	</main>


</body>
</html>
