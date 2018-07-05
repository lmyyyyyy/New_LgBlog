<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Contact Me</title>
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
<script src="../dist/js/social-share.min.js"></script>

<link rel="stylesheet" href="../dist/css/share.min.css">
    <!--[if lt IE 9]>      
        <script src="js/vendor/google/html5-3.6-respond-1.1.0.min.js"></script>
    <![endif]-->
    <script src="<%=path %>/cropper/js/jquery.min.js"></script>
    <script src="../js/contact.js"></script>
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
                    <a href="/contact">Contact Me</a>
                </div>
            </div>
        </div>
    </header>

    <div class="widewrapper main">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 clean-superblock" id="contact">
                    <h2>Contact</h2>
                    
                    <form action="#" method="get" accept-charset="utf-8" class="contact-form">
                        <input type="text"  id="contact-name" placeholder="Name" class="form-control input-lg">
                        <input type="email"  id="contact-email" placeholder="Email" class="form-control input-lg">
                        <textarea rows="10"  id="contact-body" placeholder="Your Message" class="form-control input-lg"></textarea>
                        <div class="buttons clearfix">
                            <button type="button" id="button" class="btn btn-xlarge btn-clean-one">Submit</button>
                        </div>                    
                    </form>
                </div>
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
    <script src="js/bootstrap.min.js"></script>
    <script src="js/modernizr.js"></script>
   
</body>
</html>