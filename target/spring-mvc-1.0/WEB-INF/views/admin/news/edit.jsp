<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file='/common/tablib.jsp'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<c:url  var ="ListUrl" value ="/quan-tri/bai-viet/danh-sach"/>
<c:url  var ="EditNewsUrl" value ="/quan-tri/bai-viet/sua-bai-viet"/>
<c:url  var ="ApiUrl" value ="/api/new"/>
<html>
<head>
<title>Sửa bài viết</title>
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
					<c:if test="${not empty message }">
						<div class="d-flex justify-content-end mr-5">
							<div class="alert alert-${alert } text-center col-4 " role="alert">
						  		${message }
							</div>
						</div>
						
					</c:if>
					<%--@elvariable id="model" type=""--%>
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">

						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="catagoryCode"> Thể loại 
								</label> 
								
								<div class="col-sm-9">
						
									<form:select path="catagoryCode" id="catagoryCode" cssClass="form-control">
										<form:option value="" label="--chọn thể loại--" />
										<form:options items="${category }"/>
									</form:select>
								</div>
								
							</div>
						</div>

						<div class="space-4"></div>

						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="title"> Tiêu đề </label>

								<div class="col-sm-9">
									<%-- <input type="text" id="title" placeholder="Tiêu đề"
										class="form-control" name="title" value="${model.title }"/> --%>
										<form:input path="title" cssClass="form-control" id="title"/>
								</div>
							</div>
						</div>

						<div class="space-4"></div>

						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="thumbnail"> Hình thu nhỏ </label>

								<div class="col-sm-9">
									<!-- <input type="file" id="thumbnail" placeholder="Text Field"
										class="form-control" name="thumbnail "/> -->
									<form:input path="thumbnail" cssClass="form-control" id="thumbnail"/>
								</div>
							</div>
						</div>

						<div class="space-4"></div>

						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="shortDescription"> Mô tả </label>

								<div class="col-sm-9">
									<%-- <textarea id="shortDescription" placeholder="Mô tả"
										class="form-control" rows="4" name="shortDescription" >
										${model.shortDescription }
										</textarea> --%>
										<form:textarea path="shortDescription" rows="4" cssClass="form-control" id="shortDescription"/>
								</div>
							</div>
						</div>

						<div class="space-4"></div>

						<div class="form-group row">
							<div class="d-flex justify-content-evenly">
								<label class="col-sm-2 control-label no-padding-right lh-lg"
									for="content"> Nội dung </label>

								<div class="col-sm-9">
									<%-- <textarea id="content" placeholder="Nội dung"
										class="form-control" rows="4" name="content">${model.content }</textarea> --%>
										<form:textarea path="content" rows="4" cssClass="form-control" id="content"/>
								</div>
							</div>
						</div>

						<div class="space-4"></div>
						<form:hidden path="id" id="newsId"/>
						<div class="clearfix form-actions">
							<div class="d-flex justify-content-center mt-5">
								<c:if test="${not empty model.id }">
									<button class="btn btn-info me-3" type="button" id="btnAddNews">
										<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật
									</button>
								</c:if>
								
								<c:if test="${empty model.id }">
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
			
			var id = $('#newsId').val();
			if( id == ''){
				addNewData(data);
			}else{
				updateData(data);
			}
		});

		function addNewData(data){
			$.ajax({
				url :'${ApiUrl}' ,
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success: function(result){
					window.location.href = "${EditNewsUrl}?id="+result.id+"&mesage=insert_success ";
				},
				error:function(result){
					window.location.href ="${ListUrl}?page=1&limit=2&message=error_system";
				}
				
				
			});
		}

		
		function updateData(data){
			$.ajax({
				url: '${ApiUrl}',
				type:'PUT',
				contentType : 'application/json',
				data:JSON.stringify(data),
				dataType:'json',
				success: function(result){
					window.location.href = "${EditNewsUrl}?id="+result.id+"&message=update_success ";
				},
				error : function(result){
					window.location.href = "${EditNewsUrl}?id="+result.id+"&message=error_system ";
				}
			})
		}
	</script>
	
	
</body>
</html>
