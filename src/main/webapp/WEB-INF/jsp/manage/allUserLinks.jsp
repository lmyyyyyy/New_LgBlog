<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>友情链接</title>
    <style type="text/css">
        * {
            margin: 0;
        }

        html, body {
            height: 100%;
        }

        .wrapper {
            min-height: 100%;
            height: auto !important;
            height: 100%;
            margin: 0 auto -155px;
        }

        .footer, .push {
            height: 155px;
        }

        table.gridtable {
            font-family: verdana, arial, sans-serif;
            font-size: 11px;
            color: #333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
            margin: 5px auto;
        }

        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
        }

        table.gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
        }

        .middle {
            text-align: center;
            margin: 0 auto;
            width: 600px;
            height: auto;
        }

        .info {
            font-size: 12px;
            text-align: center;
            line-height: 20px;
            padding: 40px;
        }

        .info a {
            margin: 0 10px;
            text-decoration: none;
            color: green;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <div class="middle">
        <c:if test="${page.list==null}">
            <h1 style="padding: 150px 0 20px;">沒有記錄</h1>
        </c:if>
        <c:if test="${page.list!=null}">
            <h1 style="padding: 50px 0 20px;">查询列表</h1>
        </c:if>

        <c:if test="${err!=null}">
            <h3 style="color:red;">${err}</h3>
        </c:if>
            <table class="gridtable" style="width:100%;">
                <thead>
                <tr>
                    <th colspan="4">查询结果</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>类型</th>
                    <th>更新</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.list}" var="list">
                    <tr>
                        <td>${list.id}</td>
                        <td>${list.userLink}</td>
                        <td><a href="/manage/toModifyLink/${list.id }">修改</a></td>
                        <td><a href="/manage/delLink/${list.id }">删除</a></td>
                    </tr>
                </c:forEach>
                	<tr>
                		<td><a href="/manage/toAddLink">添加链接</a></td>
                	</tr>
                </tbody>
            </table>
            <table class="gridtable" style="width:100%;text-align: center;">
                <tr>
                    <c:if test="${page.hasPreviousPage}">
                        <td><a href="${pageContext.request.contextPath}/manage/allLinks?pageNum=${page.prePage}&pageSize=${page.pageSize}">前一页</a></td>
                    </c:if>
                    <c:forEach items="${page.navigatepageNums}" var="nav">
                        <c:if test="${nav == page.pageNum}">
                            <td style="font-weight: bold;">${nav}</td>
                        </c:if>
                        <c:if test="${nav != page.pageNum}">
                            <td><a href="${pageContext.request.contextPath}/manage/allLinks?pageNum=${nav}&pageSize=${page.pageSize}">${nav}</a></td>
                        </c:if>
                    </c:forEach>
                    <c:if test="${page.hasNextPage}">
                        <td><a href="${pageContext.request.contextPath}/manage/allLinks?pageNum=${page.nextPage}&pageSize=${page.pageSize}">下一页</a></td>
                    </c:if>
                </tr>
            </table>
    </div>
    <div class="push"></div>
</div>

</body>
</html>