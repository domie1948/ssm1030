﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style type="text/css">
<!--
.STYLE1 {font-size: 24pt}
-->
</style>


<div class="header">
	<div class="wrap">
		<div class="head_top">
			<div class="logo fl"><a href="#"><img src="qtimages/logo.gif" width="79" height="78"/></a></div>
			<div style="position:absolute; top:30px; margin-left:130px;">
				<div style="font-family:宋体; color:#cccc; WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt">
                    <div align="left" class="STYLE1">健身俱乐部会员管理系统</div>
                </div>
			</div>
			<div style="float:right"> 
			
			<%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
               <a href="userlog.jsp">用户登陆</a> | <a href="userreg.jsp">用户注册</a>
				 <%
							}
				  else
				  {
				 %>
				当前用户:<%=request.getSession().getAttribute("username")%>,权限:<%=request.getSession().getAttribute("cx")%>; <a href="logout.jsp">退出</a>|<a href="main.jsp">个人后台</a>
				  <%
				  }
				  %>
				  
			
			
			</div>
			<div class="phone fr"><img src="qtimages/phone.jpg"/></div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="nav_bar">
		<div class="wrap">
			<div class="nav">
				<ul>
					<li id="m1" class="m"><h3><a href="index.do">首页</a></h3></li>
			         <li id="m4" class="m"><h3><a href="jskcList.do">健身课程</a></h3></li>
					  <li id="m2" class="m">
						<h3><a >在线建议</a></h3>
						<ul class="sub">
						  <li><a href="lyb.jsp">我要建议</a></li>
						  <li><a href="lybList.do">查看建议</a></li>
						</ul>
					</li>
						 
				
					<li id="m4" class="m"><h3><a href="xwtzList.do?lb=健身新闻">健身新闻</a></h3></li>
								
					
					<li id="m4" class="m"><h3><a href="login.jsp">后台管理</a></h3></li>
				</ul>
			</div>
		
			<div class="clear"></div>
		</div>
	</div>
</div>
