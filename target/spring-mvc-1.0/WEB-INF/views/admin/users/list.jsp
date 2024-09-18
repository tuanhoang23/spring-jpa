<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file='/common/tablib.jsp'%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<main class="content">
		<form action="<c:url value="/quan-tri/nguoi-dung/danh-sach"/>" id="formSubmit" method="get" >
			<div class="container-fluid p-0">
				<div class="text-center mt-1">
					<span class="text-center h1 responsive-font">QUẢN LÝ NGƯỜI DÙNG</span>
				</div>
				<div class="mt-5 p-2">
					<div class="d-flex justify-content-end mb-3">
						<a class="btn btn-success" title="thêm" href="<c:url value="/quan-tri/nguoi-dung/chinh-sua"/>" >
							<i class="fa-solid fa-folder-plus m-1"></i>
							<span>Thêm</span>
						</a>
						<a class="btn btn-danger mx-2" title="xóa" href="" id="btnRemove" >
							<i class="fa-solid fa-trash m-1"></i>
							<span class="">Xóa</span>
						</a>
					</div>
					<table class="table mt-100">
						<thead class="text-center">
							<tr>
								<th scope="col">UserName</th>
								<th scope="col">FullName</th>
								<th scope="col">PassWord</th>
								<th scope="col">Status</th>
								<th scope="col">#</th>
								<th scope="col"><input type="checkbox" id="checkAll"><span class="p-1">All</span></th>
	
							</tr>
						</thead>
						<tbody class="table-group-divider text-center">
							<c:forEach var="item" items="${user.result }">
								<tr>
									<td>${item.username}</td>
									<td>${item.fullname}</td>
									<td>${item.password}</td>
									<td>${item.status}</td>
									<td width="10%">
										<c:url var="updateUrl" value="/quan-tri/nguoi-dung/chinh-sua">
											<c:param name="id" value="${item.id }"/>
										</c:url>
										<a class="btn btn-info btn-sm" title="sửa" href="${updateUrl }"><i class="fa-solid fa-pen-to-square m-1"></i>sửa</a>
									</td>
									<td width="5%"><input class="" type="checkbox" id="c_${item.id}" value="${item.id}"></td>
								</tr>
							</c:forEach>
	
						</tbody>
					</table>
					<div class="d-flex justify-content-end  ">
						<ul class="pagination" id="pagination"></ul>
						<input type="hidden" id="page" name="page">
						<input type="hidden" id="limit" name="limit">
					</div>
				</div>
			</div>
		</form>
	</main>



	<script>
		var totalPages = ${user.totalPages};
		var currentPage = ${user.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 5,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if(currentPage !== page){
						$('#limit').val(2);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		}); 
		
			
	</script>
</body>

</html>