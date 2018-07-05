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
    <title>Single Post</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">

    <!-- Font-Awesome -->
    <link rel="stylesheet" href="../css/font-awesome/css/font-awesome.min.css">

    <!-- Google Webfonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic' rel='stylesheet' type='text/css'>

    <!-- Styles -->
   <link rel="stylesheet" href="../css/style.css" id="theme-styles">
    <!--[if lt IE 9]>      
        <script src="js/vendor/google/html5-3.6-respond-1.1.0.min.js"></script>
    <![endif]-->
<link rel="stylesheet" href="../dist/css/share.min.css">
<script src="<%=path %>/cropper/js/jquery.min.js"></script>
 <script src="../js/common.js"></script>
  <script src="../js/single.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/single.css">
<!-- share.js -->
<script src="../dist/js/social-share.min.js"></script>
    <script>
        $(function() {
  $(".heart").on("click", function() {
	var id = $("#sId").val();
    $.ajax({
        type:'POST',
        url:'/single/upvote/${id}',
        dataType:'json',
        contentType:'application/json;charset=UTF-8',
        success:function(data){
        	var obj = eval(data);
        	if(obj.result == "ok") {
        		$(".heart").addClass("is-active");
        		$(".message-hidden").html("谢谢~");
        		setTimeout("location.reload()",1000);
        	} 
        	if(obj.result == "not") {
        		$(".message-hidden").html("您已经赞过啦~");
        	}
        	if(obj.result == "error") {
        		$(".message-hidden").html("有点小故障~");
        	}
        }
    })
    $ ('.message-hidden').show().delay(1000).fadeOut();
  });
});
    </script>

</head>
<body>
    <header>
        <div class="widewrapper masthead">
            <div class="container">
                <a href="/home" id="logo">
                    <img src="../img/logo.png" alt="clean Blog">
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
                    <a href="/home">Blog</a>
                    <span class="separator">&#x2F;</span>
                    <a href="/home?blogType=${lgBlog.blogType }">${lgBlog.blogType }</a>
                    <!-- <span class="separator">&#x2F;</span>
                    <a href="#">HTML Template</a> -->
                </div>

              
                <div class="clean-searchbox">
                    <form action="#" method="get" accept-charset="utf-8">
                       
                        <input class="searchfield" id="searchbox" type="text" placeholder="Search">
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
                    <article class="blog-post">
                        <header>
							<input type="hidden" id="bId" value="${lgBlog.id }"/>                        
                            <div class="lead-image">
                                <img src="${lgBlog.blogPicture }" alt="" class="img-responsive">
                            </div>
                        </header>
                        <div class="body">
                            <h1>${lgBlog.blogTitle }</h1>
                            <div class="meta">
                                <i class="fa fa-user"></i> ${lgBlog.blogAuthor } <i class="fa fa-calendar"></i>${lgBlog.blogCreatetime }<i class="fa fa-eye"></i>${lgBlog.blogClickCount }Views<i class="fa fa-heart"></i>${lgBlog.blogUpvoteCount }Likes<i class="fa fa-comments"></i><span class="data"><a href="#create-comment">${lgBlog.blogReplyCount } Comments</a></span>
                            </div>
                            ${lgBlog.blogContent }
                        </div>
                    </article>
   
	<p><a href="javascript:void(0)" onclick="dashangToggle()" class="dashang" title="打赏，支持一下">打赏</a></p> 
	<div class="hide_box"></div> 
	<div class="shang_box"> 
    <a class="shang_close" href="javascript:void(0)" onclick="dashangToggle()" title="关闭"><img src="../img/close.jpg" alt="取消" /></a> 
   	<div class="shang_tit"> 
        <p>感谢您的支持，我会继续努力的!</p> 
    </div> 
    <div class="shang_payimg"> 
        <img src="../img/alipayimg.png" alt="扫码支持" title="扫一扫" /> 
    </div> 
    <div class="pay_explain">扫码打赏，你说多少就多少</div> 
    <div class="shang_payselect"> 
        <div class="pay_item checked" data-id="alipay"> 
            <span class="radiobox"></span> 
            <span class="pay_logo"><img src="../img/alipay.jpg" alt="支付宝" /></span> 
        </div> 
        <div class="pay_item" data-id="weipay"> 
            <span class="radiobox"></span> 
            <span class="pay_logo"><img src="../img/wechat.jpg" alt="微信" /></span> 
        </div> 
    </div> 
    <div class="shang_info"> 
        <p>打开<span id="shang_pay_txt">支付宝</span>扫一扫，即可进行扫码打赏哦</p> 
    </div> 
	</div>

                    <aside class="social-icons clearfix">
                    	<div class="stage">
                    	<c:if test="${isView =='isViewed'}">
						  <div class="heart" style="color:red;-webkit-transition-duration: 1s;transition-duration: 1s;background-position: -2800px 0;font-weight:bold;" title="Love this">${lgBlog.blogUpvoteCount } Like</div>
						</c:if>
						<c:if test="${isView =='UnView'}">
						  <div class="heart" style="color:red;font-weight:bold;" title="Love this"><span class="upvoteCount">${lgBlog.blogUpvoteCount }</span> Like</div>
						</c:if>
						  <div class="message-hidden" style="color:red;"></div>
						</div>
						
                       <h3>Share on </h3> 
                        <!-- <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-google"></i></a> -->
                        <div class="social-share" data-initialized="true">
                        <a href="#" class="social-share-icon icon-qq"></a>
                        <a href="#" class="social-share-icon icon-wechat"></a>
					    <a href="#" class="social-share-icon icon-qzone"></a>
                        <a href="#" class="social-share-icon icon-weibo"></a>
                        </div>
                    </aside>
		<c:if test="${lgReplyList != null }">
                    <aside class="comments" id="comments">
                        <hr>
					
                        <h2><i class="fa fa-comments"></i> ${lgBlog.blogReplyCount } Comments</h2>
					<c:forEach items="${lgReplyList}" var="lgReply">
					
                        <article class="comment">
                            <header class="clearfix">
                                <img src="../img/lgBlog.png" alt="A Smart Guy" class="avatar">
                                <div class="meta">
                                    <h3><a href="#">${lgReply.replyUsername }</a></h3>
                                    <span class="date">
                                        ${lgReply.replyCreatetime }
                                    </span>
                                    <span class="separator">
                                        -
                                    </span>
                                    
                                    <a href="#create-comment" class="reply-link" style="color:red;">Reply</a>
                                </div>
                               
                            </header>
                             <div class="body">
                               ${lgReply.replyContent }
                            </div>
                        </article>
				</c:forEach>
				
				</aside>
			</c:if>
                        <!-- <article class="comment reply">
                            <header class="clearfix">
                                <img src="../img/avatar.png" alt="A Smart Guy" class="avatar">
                                <div class="meta">
                                    <h3><a href="#">John Doe</a></h3>
                                    <span class="date">
                                        24 August 2015
                                    </span>
                                    <span class="separator">
                                        -
                                    </span>
                                    
                                    <a href="#create-comment" class="reply-link">Reply</a>                
                                </div>
                            </header>
                             <div class="body">
                               Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis, vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsam similique sapiente obcaecati tenetur beatae voluptatibus.
                            </div>
                        </article>

                        <article class="comment ">
                            <header class="clearfix">
                                <img src="../img/avatar.png" alt="A Smart Guy" class="avatar">
                                <div class="meta">
                                    <h3><a href="#">John Doe</a></h3>
                                    <span class="date">
                                        24 August 2015
                                    </span>
                                    <span class="separator">
                                        -
                                    </span>
                                    
                                    <a href="#create-comment" class="reply-link">Reply</a>                
                                </div>
                            </header>
                             <div class="body">
                               Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis, vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsam similique sapiente obcaecati tenetur beatae voluptatibus.
                            </div>
                        </article>

                        <article class="comment">
                            <header class="clearfix">
                                <img src="../img/avatar.png" alt="A Smart Guy" class="avatar">
                                <div class="meta">
                                    <h3><a href="#">John Doe</a></h3>
                                    <span class="date">
                                        24 August 2015
                                    </span>
                                    <span class="separator">
                                        -
                                    </span>
                                    
                                    <a href="#create-comment" class="reply-link">Reply</a>                
                                </div>
                            </header>
                             <div class="body">
                               Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis, vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsam similique sapiente obcaecati tenetur beatae voluptatibus.
                            </div>
                        </article>        
                    </aside> -->

                    <aside class="create-comment" id="create-comment">
                        <hr>    

                        <h2><i class="fa fa-pencil"></i> Add Comment</h2>

                        <form action="#" method="get" accept-charset="utf-8">
                            <div class="row">
                                <div class="col-md-6">
                                    <input type="text" name="name" id="comment-name" placeholder="Your Name" class="form-control input-lg">    
                                </div>
                                <div class="col-md-6">
                                    <input type="email" name="email" id="comment-email" placeholder="Email" class="form-control input-lg">    
                                </div>
                            </div>

                            <input type="url" name="name" id="comment-url" placeholder="Website (选填)" class="form-control input-lg">

                            <textarea rows="10" name="message" id="comment-body" placeholder="Your Message" class="form-control input-lg"></textarea>

                            <div class="buttons clearfix">
                                <button type="button" id="button" class="btn btn-xlarge btn-clean-one">Submit</button>
                            </div>
                        </form>
                    </aside>
                </div>
                <aside class="col-md-4 blog-aside">
                     <div class="aside-widget">
                        <header>
                            <h3>Tags</h3>
                        </header>
                        <div class="body clearfix">
                            <ul class="tags">
                            <c:forEach items="${lgTypeList }" var="lgType">
                            	<li><a href="/home?blogType=${lgType.lgType }">${lgType.lgType }</a></li>
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
                                <li><a href="/home/${lgRecommend.blogId}">${lgRecommend.blogTitle }</a></li>
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

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/modernizr.js"></script>

	
</body>
</html>