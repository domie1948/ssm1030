<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<!DOCTYPE html>
<html class="no-js">
<head>
<meta />
<title>在线论坛</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<link href="qtimages/css/sub.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>

<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
</head>

<body>
<jsp:include page="qttop.jsp"></jsp:include>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">在线论坛</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					<table border="0" cellpadding="0" bgcolor="#35A2AE" cellspacing="1" style="border-collapse: collapse" bordercolor="#FFFFFF" width="98%" align="center" class="newsline">
                          <% 
    int bbsi=0;
    String sqlbbs =  "select * from bankuai  order by id desc";
	 ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
	while(RS_resultbbs.next()){
	bbsi++;
     %>
                          <tr bgcolor="#E1F3F4" height="60" valign="middle">
                            <td width="13%" align="center" bgcolor="#FFFFFF"><a href="bbslist.jsp?bk=<%=RS_resultbbs.getString("mingcheng") %>"><img src="bbs/1.gif" border="0"></a> </td>
                            <td width="37%" align="left" bgcolor="#FFFFFF"><a href="bbslist.jsp?bk=<%=RS_resultbbs.getString("mingcheng") %>">&nbsp;<%=RS_resultbbs.getString("mingcheng") %>&nbsp;</a> </td>
                            <td width="27%" align="left" bgcolor="#FFFFFF">共有<%=connDbBean.getwzs(RS_resultbbs.getString("mingcheng"))%> 篇文章 </td>
                            <td width="23%" bgcolor="#FFFFFF">版主： <%=RS_resultbbs.getString("banzhu") %> </td>
                          </tr>
                          <%
					   	}
					   %>
                        </table>
					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

