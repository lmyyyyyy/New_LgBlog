<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>About Me</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
 

    <!-- Font-Awesome -->
    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">

    <!-- Google Webfonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic' rel='stylesheet' type='text/css'>

    <!-- Styles -->
    <link rel="stylesheet" href="css/style.css" id="theme-styles">

    <!--[if lt IE 9]>      
        <script src="js/vendor/google/html5-3.6-respond-1.1.0.min.js"></script>
    <![endif]-->
    <script src="../dist/js/social-share.min.js"></script>
    <link rel="stylesheet" href="../dist/css/share.min.css">
</head>
<body>
    <header>
        <div class="widewrapper masthead">
            <div class="container">
                <a href="/home" id="logo">
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
                    <a href="#">About Me</a>
                </div>
            </div>
        </div>
    </header>

    <div class="widewrapper main">
        <div class="container about">
            <h1>Hello, My name is <span class="about-bold">  刘明宇</span></h1>
            <p>性别是个男的,处于含苞待放的年纪 (可能会有人一撇嘴,没办法,羡慕嫉妒的表现).</p>
            <p>本人就读学校：黑龙江 哈尔滨理工大学 软件学院 (本科).</p>
            <p>该博客所采用的技术：SpringMVC,MyBatis,Mysql,Redis,Tomcat (不是wordpress).</p>
			<p>做过的项目：在线考试,博客,爬虫等项目,参与过论坛后台建设. </p>
			<p>个人性格：极易执着于某一具体功能的实现,表面高冷,内心火热.完美主义者 (难听点就是喜欢钻牛角尖,但是能出的来).</p>
			<p>本人很喜欢交流技术和心得,如果你擅长吹bi,或者你喜欢沉默,也许你真的爱笑...只要你不是砸场子的都可以联系我 (我会在你吹bi的时候沉默,在你沉默的时候邪眼笑,在你笑的时候使劲往你脸上喷吐沫星子并说出我的故事).</p>
			<p>联系方式：QQ 532033837  微信 lmy532033837 </p>
			<p>(我觉得联系我有必要设置一个暗号,要不你要是自刀骗药的话我岂不是很亏,请求附上"<span style="color:red;">刘明宇真帅</span>"我看到就会光速通过,你以为我是爱慕虚荣,其实是因为谁会为难一个诚实的人呢!)</p>
			<p>除了以上方式,还可以点击最下方的 Contact Me 去对我说出你的故事.</p>
            <div class="about-button">
                <a class="btn btn-xlarge btn-clean-one" href="contact.html">Contact Me</a>
            </div>
            <hr>
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
    <script src="js/bootstrap.min.js"></script>
    <script src="js/modernizr.js"></script>

</body>
</html>