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
 <% 
 if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.jsp';</script>");
	return;
}
String id=request.getParameter("id");

%>
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
					
					<table width="96%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                      <tr>
                        <td height="104" valign="top">
						
						
						
					
                            <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                              <tr>
                                <td width="13%">标题：</td>
                                <td width="87%"><%=connDbBean.readzd("tiezi","biaoti","id",id)%> &nbsp;<img src="bbs/<%=connDbBean.readzd("tiezi","leixing","id",id)%>.gif" width="18" height="18"> 发帖人：<%=connDbBean.readzd("tiezi","faburen","id",id)%> ：<%=connDbBean.readzd("tiezi","addtime","id",id)%> <%
								if(connDbBean.readzd("tiezi","fujian","id",id).equals(""))
								{}
								else
								{
									out.print("<a href='"+connDbBean.readzd("tiezi","fujian","id",id)+"'>附件下载</a>");
								}
								%></td>
                              </tr>
                              <tr>
                                <td>内容：</td>
                                <td height="100"><%=connDbBean.readzd("tiezi","neirong","id",id)%></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                              </tr>
                            </table>
                        
                        </td>
                      </tr>
                      <tr>
                        <td align="right"><table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                            <tr>
                              <td colspan="2">已有回帖如下：</td>
                            </tr>
							 <%
							int bbsi=0;
							  String sqlbbs =  "select * from tiezi where fid='"+id+"' order by id desc";
							  ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
								while(RS_resultbbs.next()){
								bbsi++;
								%>
								 <tr>
                              <td width="19%"><p>回复人:<%=RS_resultbbs.getString("faburen") %></p>
                                <p><%=RS_resultbbs.getString("addtime") %></p></td>
                              <td width="81%" height="100"><%=RS_resultbbs.getString("neirong") %></td>
                            </tr>
								<%
								}
							 %>
                            <tr>
                              <td colspan="2">我也来回一个：</td>
                            </tr>
                            <tr>
                              <td colspan="2"><form action="addTiezi.do" name="form1" method="post">
                                  <textarea name="neirong" cols="70" rows="5" id="neirong"></textarea>
                                  <input type="submit" name="Submit" value="回复">
                                  
								  <input name="bankuai" type="hidden" id="bankuai" value="<%=connDbBean.readzd("tiezi","bankuai","id",id)%>"> <input name="faburen" type="hidden" id="faburen" value="<%=request.getSession().getAttribute("username")%>"> <input name="fid" type="hidden" id="fid" value="<%=id%>"> <input name="addtime" type="hidden" id="addtime" value="<%=connDbBean.gettime()%>" />
                              </form></td>
                            </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td align="right"><a href="bbs.jsp" >返回</a></td>
                      </tr>
                    </table>
					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

