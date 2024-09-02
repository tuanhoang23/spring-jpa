<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--	<script src="<c:url value='/template/ckeditor5/ckeditor5.js' />"></script>--%>
    <link rel="stylesheet" href="<c:url value="https://cdn.ckeditor.com/ckeditor5/42.0.1/ckeditor5.css"/>" />
    <style>
        .form-group {
            margin-bottom: 16px;
        }
        #content {
            width: 100%;
        }
        .form-actions {
            text-align: right;
        }
        .btn-custom {
            background-color: #e2c570; /* Màu vàng */
            border-color: #ffc107;
        }
        .btn-custom:hover {
            background-color: #e0a800; /* Màu vàng đậm hơn khi hover */
            border-color: #e0a800;
        }
    </style>

</head>
<body>
<div class="container-fluid px-3 py-3">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li  >
                        <i class="ace-icon fa fa-home home-icon mr-1"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active ml-2">Chỉnh sửa bài viết</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-12 ">
                        <c:if test="${not empty messageResponse}">
                            <div class="alert alert-${alert}">
                                    ${messageResponse}
                            </div>
                        </c:if>
                        <form id="formSubmit" class="d-flex flex-column justify-content-around" >
                            <div class="form-group d-flex">
                                <label class="col-sm-3 control-label no-padding-right h text-center m-auto">Thể loại</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="catagoryCode" name="catagoryCode">
                                        <c:if test="${empty model.catagoryCode}">
                                            <option value="">Chọn loại bài viết</option>
                                            <c:forEach var="category" items="${categories}" >
                                                <option value="${category.code}">${category.name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.catagoryCode}">
                                            <c:forEach var="category" items="${categories}" >
                                                <option value="${category.code}"  <c:if test="${category.code == model.catagoryCode}">selected="selected"</c:if> >
                                                        ${category.name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <label class="col-sm-3 control-label no-padding-right text-center">Tiêu đề</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <label class="col-sm-3 control-label no-padding-right text-center">Hình đại diện</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="thumbnail" name="thumbnail" value="${model.thumbnail}"/>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <label class="col-sm-3 control-label no-padding-right text-center">Mô tả ngắn</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="shortDescription" name="shortDescription" value="${model.shortDescription}"/>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <label class="col-sm-3 control-label no-padding-right text-center">Nội dung</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" id="content" name="content" rows="10">${model.content}</textarea>
                                </div>
                            </div>
                            <div class="form-group form-actions align-items-center text-center ">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-success btn-lg  mt-5" value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>

                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-secondary btn-lg  mt-5" value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>
                            </div>
                            <input type="hidden" value="${model.id}" id="id" name="id"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    var editor = '';
    $(document).ready(function (){
        // editor =  CKEDITOR.replace('content',{
        //     removePlugins: 'exportpdf'
        // });

       /*  if (typeof CKEDITOR !== 'undefined') {
            CKEDITOR
                .create(document.querySelector('#editor'))
                .then(editor => {
                    console.log('Editor was initialized', editor);
                })
                .catch(error => {
                    console.error('There was a problem initializing the editor', error);
                });
        } else {
            console.error('CKEditor 5 is not loaded properly.');
        } */
    });


    $("#btnAddOrUpdateNew").click(function(e){
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData,function (indexs,values){
            data[""+values.name+""] = values.value;
        });
        var id = $("#id").val();
        if(id == ""){
            addNew(data);
        }else{
            update(data);
        }
    });

    function addNew(data){
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
    function update(data){
        $.ajax({
            url:'${APIurl}',
            type:'PUT',
            contentType:'application/json',
            data: JSON.stringify(data),
            dataType:'json',
            success:function (result){
                console.log(result)
            },
            error: function (error){
                console.log(error)
            },
        });
    }


</script>



<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
