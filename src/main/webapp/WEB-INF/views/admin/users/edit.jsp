<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file='/common/tablib.jsp'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<c:url var="ListUrl" value="/quan-tri/nguoi-dung/danh-sach"/>
<c:url var="UserUrl" value="/api/user"/>
<html>
<head>
<title>Chỉnh Sửa Tài Khoản</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--	<script src="<c:url value='/template/ckeditor5/ckeditor5.js' />"></script>--%>
<link rel="stylesheet"
	href="<c:url value="https://cdn.ckeditor.com/ckeditor5/42.0.1/ckeditor5.css"/>" />
	<style>
	.main-content-inner {
 	 	overflow-x: hidden;
 	 	align-items:center;
	}
	</style>
</head>
<body>
	<div class="main-content-inner">
		<div class="page-content">
			<div class="page-header">
				<h1>
					Form Elements <small> <i
						class="ace-icon fa fa-angle-double-right"></i> Common form
						elements and layouts
					</small>
				</h1>
			</div>
			<!-- /.page-header -->

			<div class="">
				<div class="col-xs-12 mt-5">

					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="user">

						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="username"> Tên tài khoản</label>

								<div class="col-sm-4">
										<form:input path="username" cssClass="form-control" id="username"/> 
										<%-- <input type="text" id="username" placeholder="Tên tài khoản"
										class="form-control" name="username" value="${user.username}"/>  --%>
								</div>
							</div>
						</div>

						<div class="space-4"></div>

						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="fullname"> Họ tên </label>

								<div class="col-sm-4">
									<!--  <input type="text" id="fullname" placeholder="Text Field"
										class="form-control" name="fullname "/>  -->
									<form:input path="fullname" cssClass="form-control" id="fullname"/> 
								</div>
							</div>
						</div>

						<div class="space-4"></div>

						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="password">Mật khẩu </label>

								<div class="col-sm-4">
										<form:input path="password" cssClass="form-control" id="password"/>
										<!-- <input type="text" id="password" placeholder="Text Field"
										class="form-control" name="password "/>  -->
								</div>
							</div>
						</div>

						<div class="space-4"></div>
						
						<%-- <div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="catagoryCode"> Thể loại 
								</label> 
								
								<div class="col-sm-9">
						
									<form:select path="code" id="code" cssClass="form-control">
										<form:option value="" label="--chọn thể loại--" />
										<form:options items="${role }"/>
									</form:select>
								</div>
						</div> --%>
						
						<div class="space-4"></div>
						
						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg "
									for="catagoryCode"> Trạng thái 
								</label> 
								
								<div class="col-sm-4">
									<select name="status" id="status" class="form-control">
									    <option value="0" ${user.status == 0 ? 'selected' : ''}>Không hoạt động</option>
										<option value="1" ${user.status == 1 ? 'selected' : ''}>Hoạt động</option>
									</select> 
								</div>
								
							</div>
						</div>
						
						<div class="space-4"></div>
						
						<form:hidden path="id" id="id"/>
						
						<div class="clearfix form-actions">
							<div class="d-flex justify-content-center mt-5">
								<c:if test="${not empty user.id }">
									<button class="btn btn-info me-3" type="button" id="btnAddNews">
										<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật
									</button>
								</c:if>
								
								<c:if test="${empty user.id }">
									<button class="btn btn-info me-3" type="button" id="btnAddNews">
										<i class="ace-icon fa fa-check bigger-110"></i> Thêm 
									</button>
								</c:if> 
								<button class="btn btn-success" type="button">
									<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddNews').click(function (e){
			e.preventDefault();
			var data = {};
			var form = $('#formSubmit').serializeArray();
			$.each(form , function(i,v){
				data[""+v.name+""] = v.value;
			});
			var id = $('#id').val();
			if(id == ""){
				addUser(data);
			}else{
				updateUser(data);
			}
			console.log(form);
		});

		function addUser(data){
			$.ajax({
				url: '${UserUrl}',
				type:'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType:'json',
				success : function(success){
					window.location.href = "${ListUrl}?page=1&limit=2";
				},
				error : function(error){
					window.location.href = "${ListUrl}?page=1&limit=2";
				}
				
			});
		}

		function updateUser(data){
			$.ajax({
				url:'${UserUrl}',
				type:'PUT',
				contentType:'application/json',
				data:JSON.stringify(data),
				dataType:'json',
				success : function(success){
					window.location.href = "${ListUrl}?page=1&limit=2";
				},
				error : function(error){
					window.location.href = "${ListUrl}?page=1&limit=2";
				}
			});
		}
	</script>
	
	
</body>
</html>
