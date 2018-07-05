<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=path %>/cropper/js/jquery.min.js"></script>
<style>
table {  
margin-left: auto; 
margin-right: auto;
     border-collapse: collapse;  
     font-family: Futura, Arial, sans-serif;   
     background-color: #DDDDDD;
     border-top-left-radius:1em;
	border-top-right-radius:1em;
	border-bottom-right-radius:1em;
	border-bottom-left-radius:1em;
}   
th,td {     padding: .65em;   }   
</style>
  </head>
  
  <body>
    <div>
            <table>
              <tr>
                <td><span>链接url：&nbsp;&nbsp; </span></td>
                <td><input type="text" id="userLink" name="userLink"/></td>
                <td><div style="color:#f00;font-size:12px;"></div></td>
              </tr>
              <tr>
                <td><input type="button" id="button" value="添加"/></td>
              </tr>
            </table>
    </div>
  </body>
  <script> 
        $(function () {
            $("#button").click(function(){
                var userLink = $("#userLink").val();
                
                /* alert(picture)
            	alert(title)
            	alert(desc)
            	alert(type)
            	alert(editor.txt.html()) */
                var data={
                		"userLink":userLink,
                	}
                $.ajax({
                    type:'POST',
                    url:'/manage/addLink',
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
                    		alert("添加成功");
                    		window.location.href="/manage/allLinks?pageNum=1&pageSize=10";
                    	} 
                    	if(obj.result == "error") {
                    		alert("添加失败");
                    	}
                    }

                })
            });
        });
    </script>
</html>
