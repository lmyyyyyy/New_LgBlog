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
    	<form action="/manage/addType" method="post">
            <table>
              <tr>
                <td><span>类型名称：&nbsp;&nbsp; </span></td>
                <td><input type="text" name="lgType"/></td>
                <td><div style="color:#f00;font-size:12px;"></div></td>
              </tr>
              
              <tr>
                <td><input type="submit" value="添加"/> </td>
                <td><input type="reset" value="重置"></td>
              </tr>
            </table>
            <br>
          </form>
    </div>
  </body>
</html>
