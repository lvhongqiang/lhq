<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<title></title>
	<base href="<%=basePath%>nb/">
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content=""/>
</head>
<body>
<!---header---->
<div class="header">
	<div class="container">
		<div class="logo">
			<a href="/"><img src="images/logo.jpg" title="" /></a>
		</div>
		<!---start-top-nav---->
		<div class="top-menu">
			<div class="search">
				<form>
					<input type="text" placeholder="" required="">
					<input type="submit" value=""/>
				</form>
			</div>
			<span class="menu"> </span>
			<ul>
				<li class="active"><a href="/">HOME</a></li>
				<li><a href="/">ABOUT</a></li>
				<li><a href="/">CONTACT</a></li>
				<div class="clearfix"> </div>
			</ul>
		</div>
		<div class="clearfix"></div>
		<!---//End-top-nav---->
	</div>
</div>
<!--/header-->
<div class="single">
	<div class="container">
		<div class="col-md-8 single-main">
			<div class="content-form">
				<h3>${article.title}</h3>
			</div>
			<div class="single-grid">
				<s:property escape="false" value="article.content"/>
			</div>

			<div class="desc">
				<p>上一篇：<a href="/${pre.id}">${pre.title}</a></p>
				<p class="next">下一篇：<a href="/${next.id}">${next.title}</a></p>
			</div>
		</div>

		<div class="col-md-4 side-content">
			<div class="recent">
				<h3>RECENT POSTS</h3>
				<ul>
					<li><a href="/">Aliquam tincidunt mauris</a></li>
					<li><a href="/">Vestibulum auctor dapibus  lipsum</a></li>
					<li><a href="/">Nunc dignissim risus consecu</a></li>
					<li><a href="/">Cras ornare tristiqu</a></li>
				</ul>
			</div>
			<div class="comments">
				<h3>RECENT COMMENTS</h3>
				<ul>
					<li><a href="/">Amada Doe </a> on <a href="/">Hello World!</a></li>
					<li><a href="/">Peter Doe </a> on <a href="/"> Photography</a></li>
					<li><a href="/">Steve Roberts  </a> on <a href="/">HTML5/CSS3</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
			<div class="archives">
				<h3>ARCHIVES</h3>
				<ul>
					<li><a href="/">October 2013</a></li>
					<li><a href="/">September 2013</a></li>
					<li><a href="/">August 2013</a></li>
					<li><a href="/">July 2013</a></li>
				</ul>
			</div>
			<div class="categories">
				<h3>CATEGORIES</h3>
				<ul>
					<li><a href="/">Vivamus vestibulum nulla</a></li>
					<li><a href="/">Integer vitae libero ac risus e</a></li>
					<li><a href="/">Vestibulum commo</a></li>
					<li><a href="/">Cras iaculis ultricies</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
</div>
<!---->
<div class="footer">
	<div class="container">
		<p>Copyrights © 2015 Blog All rights reserved</p>
	</div>
</div>


</body>
