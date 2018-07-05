<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改文章</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=path %>/cropper/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=path %>/cropper/css/cropper.min.css">
  <link rel="stylesheet" href="<%=path %>/cropper/css/main.css">
  <script src="<%=path %>/cropper/js/jquery.min.js"></script>
  <script src="<%=path %>/cropper/js/bootstrap.min.js"></script>
  <script src="<%=path %>/cropper/js/cropper.min.js"></script>
  <script src="<%=path %>/cropper/js/main.js"></script>
 <!--  <script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script> -->
	<link rel="stylesheet" type="text/css" href="/wangEditor-master/release/wangEditor.min.css">
	<style type="text/css">
		#t_table{
			margin-top:100px;
		}
		tr {
			display:block;
			margin:20px 0;
		}
	</style>
  </head>
  <body>
   <div class="container" id="crop-avatar">

    <!-- Current avatar -->
    <div class="avatar-view" title="Change the avatar">
      <img src="${lgBlog.blogPicture}" id="picture" alt="Avatar">
    </div>
    <!-- Cropping modal -->
    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <form class="avatar-form" action="uploadHeadImage" enctype="multipart/form-data" method="post" accept="image/*">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title" id="avatar-modal-label">更改封面</h4>
            </div>
            <div class="modal-body">
              <div class="avatar-body">

                <!-- avatar_file(源文件),avatar_data(裁剪参数JSON[x,y,w,h]),avatar-src(源文件路径) -->
                <div class="avatar-upload">
                  <input type="hidden" class="avatar-src" name="avatar_src">
                  <input type="hidden" class="avatar-data" name="avatar_data">
                  <label for="avatarInput" class="btn btn-primary">选择图片</label>
                  <input type="file" class="avatar-input" id="avatarInput" name="avatar_file" style="display: none;" accept="image/*">
                </div>

                <!-- Crop and preview -->
                <div class="row">
                  <div class="col-md-9">
                    <div class="avatar-wrapper"></div>
                  </div>
                  <div class="col-md-3">
                    <div class="avatar-preview preview-lg"></div>
                    <div class="avatar-preview preview-md"></div>
                    <div class="avatar-preview preview-sm"></div>
                  </div>
                </div>

                <div class="row avatar-btns">
                  <div class="col-md-9">
                    <div class="btn-group">
                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="90" title="Rotate 90 degrees">旋转图片</button>
                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="15">15deg</button>
                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="30">30deg</button>
                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="45">45deg</button>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <button type="submit" class="btn btn-primary btn-block avatar-save">提交</button>
                  </div>
                </div>
              </div>
            </div>
            <!-- <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div> -->
          </form>
        </div>
      </div>
    </div><!-- /.modal -->

    <!-- Loading state -->
    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
  </div>
	<input type="hidden" id="id" value="${lgBlog.id }"/>
  <table id="t_table">
  	<tr id="t_table_tr">
  		<td><span>标题：</span></td>
  		<td><input type="text" id="title" name="title" value="${lgBlog.blogTitle}"/></td>
  	</tr> 
  	<tr id="t_table_tr">
  		<td><span>描述：</span></td>
  		<td><textarea rows="10" cols="80" id="desc" name="desc">${lgBlog.blogDesc }</textarea></td>
  	</tr>
  	<tr id="t_table_tr">
  		<td><span>类型：</span></td>
  		<td><select  id="type" name="type" value="${lgBlog.blogType }">
  			<c:forEach  var="list" items="${lgTypeList }">
  			<c:choose>
  				<c:when test="${lgBlog.blogType == list.lgType }">
  					<option selected="selected" value="${list.lgType }">${list.lgType }</option>
  				</c:when>
  			</c:choose>
  				<option><c:out value="${list.lgType }"></c:out> </option>
  			</c:forEach>
  		</select></td>
  	</tr>
  </table>
  	
  	<div id="editor">
       ${lgBlog.blogContent}
    </div>
    <input id="button" type="button" value="修改" />
    <input type="button" id="clear" value="清空"/>

  
    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript" src="wangEditor-master/release/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#editor')
        // 或者 var editor = new E( document.getElementById('#editor') )
        editor.customConfig.menus = [
                                     'head',  // 标题
    'bold',  // 粗体
    'italic',  // 斜体
    'underline',  // 下划线
    'strikeThrough',  // 删除线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
    'link',  // 插入链接
    'list',  // 列表
    'justify',  // 对齐方式
    'quote',  // 引用
    'emoticon',  // 表情
    'image',  // 插入图片
    'table',  // 表格
    'video',  // 插入视频
    'code',  // 插入代码
    'undo',  // 撤销
    'redo'  // 重复
                                 ]
        
     // 隐藏“网络图片”tab
        editor.customConfig.uploadImgServer  = true
        editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
        editor.customConfig.uploadImgServer = '/picUploads';
        editor.customConfig.uploadImgMaxLength = 5
        editor.customConfig.uploadFileName = 'picture'
        	editor.customConfig.uploadImgHeaders = {
        	    'Accept': 'text/html'
        	}
        editor.customConfig.zIndex = 100
        editor.create()
		/* document.getElementById('clear').addEventListener('click', function () {
			editor.txt.clear()
		}, false)  */
    </script>
    <script> 
        $(function () {
            $("#button").click(function(){
            	var picture = $("#picture").attr("src");
                var title = $("#title").val();
                var desc = $("#desc").val();
                var type = $("#type").val();
                var id = $("#id").val();
                /* alert(picture)
            	alert(title)
            	alert(desc)
            	alert(type)
            	alert(editor.txt.html()) */
                var data={
                		"id":id,
                		"blogPicture":picture,
                		"blogTitle":title,
                		"blogDesc":desc,
                		"blogType":type,
                		"blogContent":editor.txt.html()
                	}
                $.ajax({
                    type:'POST',
                    url:'/manage/modify/article',
                    data:JSON.stringify(data),
                    	/* {
                		'blogPicture':picture,
                		'blogTitle':title,
                		'blogDesc':desc,
                		'blogType':type,
                		'blogContent':editor.txt.html()
                	} */
                    dataType:'json',
                    contentType:'application/json;charset=UTF-8',
                    success:function(data){
                    	var obj = eval(data);
                    	if(obj.result == "ok") {
                    		alert("修改成功");
                    		window.location.href="/manage/allArticle?pageNum=1&pageSize=10";
                    	} 
                    	if(obj.result == "error") {
                    		alert("修改失败");
                    	}
                    }

                })
            });
        });
    </script>

  </body>
</html>
