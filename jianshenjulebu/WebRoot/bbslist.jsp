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
<% String bk=request.getParameter("bk"); %>
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
					
					<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" class="newsline" style="border-collapse:collapse">
                          <tr>
                            <td height="104" valign="top"><table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
                                <tr>
                                  <td width="30" bgcolor="#EBE2FE">序号</td>
                                  <td width="352" bgcolor='#EBE2FE'>标题</td>
                                  <td width="48" bgcolor='#EBE2FE'>类型</td>
                                  <td width="60" bgcolor='#EBE2FE'>发帖人</td>
                                  <td width="130" align="center" bgcolor="#EBE2FE">发布时间</td>
                                  <td width="65" align="center" bgcolor="#EBE2FE">已有回帖</td>
                                </tr>
                                 <% 

  	
    String sqlbbs =  "select * from tiezi where bankuai='"+bk+"' and fid='0' order by issh desc, id desc";
	int bbsi=0;
	 ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
	while(RS_resultbbs.next()){
	bbsi++;

     %>
                                <tr>
                                  <td width="30"><%=bbsi%></td>
                                  <td><a href="tiezidetail.jsp?id=<%=RS_resultbbs.getString("id") %>"><%
								  if(RS_resultbbs.getString("issh").equals("是"))
								  {
								  %>
								  <img src="bbs/zhiding.png" width="15" height="15" style="padding-top:5px;">
								  <%
								  }
								  %><%=RS_resultbbs.getString("biaoti") %> </a></td>
                                  <td><img src="bbs/<%=RS_resultbbs.getString("leixing") %>.gif" width="18" height="18"></td>
                                  <td><%=RS_resultbbs.getString("faburen") %></td>
                                  <td width="130" align="center"><%=RS_resultbbs.getString("addtime") %></td>
                                  <td width="65" align="center"><%=connDbBean.gettzs((String)RS_resultbbs.getString("id")) %></td>
                                </tr>
	<%
  }
   %>
                            </table></td>
                          </tr>
                          <tr>
                            <td align="right"><a href="tieziadd.jsp?bk=<%=bk%>">我要发帖</a> <a href="bbs.jsp" onClick="javascript:history.back();">返回</a></td>
                          </tr>
                        </table>
					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

