<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewBlog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
    	${lgReply.lgBlogId }
    	<hr>
    	${lgReply.replyIp }
    	<hr>
    	${lgReply.replyUsername}
    	<hr>
    	${lgReply.replyEmail}
    	<hr>
    	${lgReply.replyWebsite}
    	<hr>
    	${lgReply.replyContent}
    	<hr>
    	${lgReply.replyCreatetime}
    	<a href="manage/allReply">返回</a>
    </div>
  </body>
</html>
