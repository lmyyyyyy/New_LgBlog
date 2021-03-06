<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Font-Awesome -->
    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
    <!-- Google Webfonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic' rel='stylesheet' type='text/css'>
    <!-- 分页 -->
	<link rel="stylesheet" href="../dist/css/share.min.css">
	<!-- share.js -->
	<script src="../dist/js/social-share.min.js"></script>
    <!-- Styles -->
    <link rel="stylesheet" href="css/style.css" id="theme-styles">
    <script src="<%=path %>/cropper/js/jquery.min.js"></script>
    <script src="../js/common.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/index.css">
    <!--[if lt IE 9]>      
        <script src="js/respond.js"></script>
    <![endif]-->
</head>
<body>
    <header>
        <div class="widewrapper masthead">
            <div class="container">
                <a href="/index" id="logo">
                    <img src="img/logo.png" alt="clean Blog">
                </a>
        
                <div id="mobile-nav-toggle" class="pull-right">
                    <a href="#" data-toggle="collapse" data-target=".clean-nav .navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </a>
                </div>

                <nav class="pull-right clean-nav">
                    <div class="collapse navbar-collapse">
                        <ul class="nav nav-pills navbar-nav">
                          
                            <li>
                                <a href="/home">Home</a>
                            </li>
                            <li>
                                <a href="/index">Index</a>
                            </li>
                            <li>
                                <a href="/about">About</a>
                            </li>
                            <li>
                                <a href="/contact">Contact</a>
                            </li>                        
                        </ul>
                    </div>
                </nav>        

            </div>
        </div>

        <div class="widewrapper subheader">
            <div class="container">
                <div class="clean-breadcrumb">
                    <a href="/index">Blog</a>
                    <c:if test='${blogType!="all" }'>
                    <span class="separator">&#x2F;</span>
                    	<a href="">${blogType }</a>
                    </c:if>
                </div>

                <div class="clean-searchbox">
                    <form action="/index" method="get" accept-charset="utf-8">
                        <input class="searchfield" id="searchbox" name="searchbox" type="text" placeholder="Search">
                        <button class="searchbutton" type="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </header>

    <div class="widewrapper main">
        <div class="container">
            <div class="row">
                <div class="col-md-8 blog-main">
                    <div class="row">
                    <c:forEach items="${page.list}" var="list" varStatus="status">
                    	<c:if test="${status.count % 2 == 0 }">
	                        <div class="col-md-6 col-sm-6">
	                            <article class=" blog-teaser">
	                                <header> <%-- src="${list.blogPicture }" --%>
	                                    <img src="${list.blogPicture }" alt="">
	                                    <h3 class="cont" title="${list.blogTitle}"><a href="/single/${list.id }">${list.blogTitle }</a></h3>
	                                    <span class="meta">${list.blogCreatetime },${list.blogAuthor }</span><br>
	                                    <div class="meta">
			                               <i class="fa fa-eye" style="color:blue;"></i>${list.blogClickCount } Views<i class="fa fa-heart" style="color:red;"></i>${list.blogUpvoteCount } Likes<i class="fa fa-comments"style="color:green"></i><span class="data">${list.blogReplyCount } Comments</span>
			                            </div>
	                                    <hr>
	                                    
	                                </header>
	                            </article>
	                        </div>
                        </c:if>
                     	<c:if test="${status.count % 2 != 0 }">
	                        <div class="col-md-6 col-sm-6">
	                            <article class="blog-teaser">
	                                <header>
	                                    <img src="${list.blogPicture }" alt="">
	                                    <h3 class="cont" title="${list.blogTitle}"><a href="/single/${list.id }" >${list.blogTitle}</a></h3>
	                                    <span class="meta">${list.blogCreatetime},${list.blogAuthor }</span>
	                                    <div class="meta">
			                               <i class="fa fa-eye" style="color:blue;"></i>${list.blogClickCount } Views<i class="fa fa-heart" style="color:red;"></i>${list.blogUpvoteCount } Likes<i class="fa fa-comments" style="color:green;"></i><span class="data">${list.blogReplyCount } Comments</span>
			                            </div>
	                                    <hr>
	                                </header>
	                            </article>
	                        </div>
                        </c:if>
                      </c:forEach>
                    </div>
                   	 <div class="paging" >
                   	 <ul class="pagination">
                    <c:if test="${page.hasPreviousPage}">
                        <li><a href="${pageContext.request.contextPath}/index?blogType=${blogType }&index?pageNum=${page.prePage}&pageSize=${page.pageSize}">Pre</a></li>
                    </c:if>
                    <c:forEach items="${page.navigatepageNums}" var="nav">
                        <c:if test="${nav == page.pageNum}">
                            <li><a>${nav}</a></li>
                        </c:if>
                        <c:if test="${nav != page.pageNum}">
                            <li><a href="${pageContext.request.contextPath}/index?blogType=${blogType }&pageNum=${nav}&pageSize=${page.pageSize}">${nav}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${page.hasNextPage}">
                        <li><a href="${pageContext.request.contextPath}/index?blogType=${blogType }&pageNum=${page.nextPage}&pageSize=${page.pageSize}" >Next</a></li>
                    </c:if>
				 		 <!-- <a href="#" class="older"><i>Older Post</i></a> -->
				 		</ul>
                	</div>
               
                </div>
                
               
                <aside class="col-md-4 blog-aside">
                    
                    <div class="aside-widget">
                        <header>
                            <h3>Tags</h3>
                        </header>
                        <div class="body clearfix">
                            <ul class="tags">
                            <c:forEach items="${lgTypeList }" var="lgType">
                            	<li><a href="/index?blogType=${lgType.lgType }">${lgType.lgType }</a></li>
                            </c:forEach>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="aside-widget">
                        <header>
                            <h3>Recommend Articles</h3>
                        </header>
                        <div class="body">
                            <ul class="clean-list">
                            <c:forEach items="${lgRecommendList}" var="lgRecommend" >
                                <li><a href="/single/${lgRecommend.blogId}">${lgRecommend.blogTitle }</a></li>
                             </c:forEach>
                            </ul>
                        </div>
                    </div>
                
                    <div class="aside-widget">
                        <header>
                            <h3>Ji Qing Links</h3>
                        </header>
                        <div class="body">
                            <ul class="clean-list">
                            <c:forEach items="${lgLinksList}" var="lgLinks" >
                            	<li><a href="${lgLinks.userLink }">${lgLinks.userLink }</a></li>
                            </c:forEach>
                            </ul>
                        </div>
                    </div>
                </aside>
                <a id="gotop" href="javascript:;"><i class="fa fa-arrow-up"></i></a>
            </div>
        </div>
        
    </div>
    
     <footer>
        <div class="widewrapper footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-user"></i><a style="color:#fff;" href="/about">About</a></h3>

                       <p>My English is not very good, please read the reader not to mind. This is my first online blog.The whole blog is my own hand code(In addition to the front frame), If there is a bad place to do, hope to give me advice</p>
                       <p>Similarly, if the reader has any technical aspects of the problem, you can comment or contact me, I will try the first time to reply.</p>
                    </div>

                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-pencil"></i> Three lines of love letters</h3>
                        <ul class="clean-list">
                            <li><a href="javascript:;">int i = 10;</a></li>
                            <li><a href="javascript:;">int you = 3;</a></li>
                            <li><a href="javascript:;">you = i / you;</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-envelope"></i><a style="color:#fff;" href="/contact">Contact Me</a></h3>
                        <p>Tips, if you want to contact me, be sure to write a real email address, or I may not receive your message.</p>
                        <p>If you think my blog has something useful to you, share it to other people, the hard link below the link.</p>
                         <div class="footer-widget-icon">
                            <div class="social-share" data-initialized="true">
                        <a href="#" class="social-share-icon icon-qq"></a>
                        <a href="#" class="social-share-icon icon-wechat"></a>
					    <a href="#" class="social-share-icon icon-qzone"></a>
                        <a href="#" class="social-share-icon icon-weibo"></a>
                        </div>
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
        <div class="widewrapper copyright">
                Copyright 2017 . <a href="/about">LIUMINGYU</a>
        </div>
    </footer>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/modernizr.js"></script>
</body>
</html>