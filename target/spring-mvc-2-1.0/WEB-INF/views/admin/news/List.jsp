<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<main class="content">
	<form action="#" id="formSubmit" method="get" >
		<div class="container-fluid p-0">
			<div class="text-center mt-1">
				<span class="text-center h1 responsive-font">QUẢN LÝ BÀI VIẾT</span>
			</div>
			<div class="mt-5 p-2">
				<div class="d-flex justify-content-end mb-3">
					<a class="btn btn-success" title="thêm bài viết" href="" >
						<i class="fa-solid fa-folder-plus m-1"></i>
						<span>Thêm</span>
					</a>
					<a class="btn btn-danger mx-2" title="thêm bài viết" href="" id="btnRemove" >
						<i class="fa-solid fa-trash m-1"></i>
						<span class="">Xóa</span>
					</a>
				</div>
				<table class="table mt-100">
					<thead class="text-center">
						<tr>
							<th scope="col">Tên bài viết</th>
							<th scope="col">Mô tả ngắn</th>
							<th scope="col">#</th>
							<th scope="col"><input type="checkbox" id="checkAll"><span class="p-1">All</span></th>

						</tr>
					</thead>
					<tbody class="table-group-divider text-center">
						<c:forEach var="item" items="${model.result }">
							<tr>
								<td>${item.title}</td>
								<td>${item.shortDescription }</td>
								<td width="10%">
									<a class="btn btn-info btn-sm" title="sửa" href="#"><i class="fa-solid fa-pen-to-square m-1"></i>sửa</a>
								</td>
								<td width="5%"><input class="" type="checkbox" id="c_${item.id}" value="${item.id}"></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="d-flex justify-content-end  ">
					<!-- <ul class="pagination" id="pagination"></ul> -->
					<input type="hidden" id="type" name="type">
				</div>
			</div>
		</div>
	</form>
	</main>



	<script type="text/javascript">
		

		$('#btnRemove').click(function (){
			var data = {};
			var dataArray = $("tbody input[type=checkbox]:checked").map(function (){
				return $(this).val();
			}).get();
			data['ids'] = dataArray;
			remove(data);
		});

		function remove(data){
			$.ajax({
				url: '${APIurl}',
				type: 'DELETE',
				contentType:'application/json',
				data: JSON.stringify(data),
				success: function (succes) {
					window.location.href = '${newUrl}?type=list&maxPageItem=2&page=1';
				},
				error: function (error) {
					console.log(error);
				}
			});
		}
	</script>
</body>

</html>