<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jianshenjiaolianhsgb" scope="page" class="com.bean.JianshenjiaolianBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jianshenjiaolian.xls");
%>
<html>
  <head>
    <title>�������</title>
  </head>

  <body >
 <%
			String sql="select * from jianshenjiaolian  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�������</td>    <td align='center'>��������</td>    <td  width='40' align='center'>�Ա�</td>    <td align='center'>ר��</td>    <td  width='90' align='center'>��Ƭ</td>    <td align='center'>�绰</td>    <td align='center'>��ַ</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=jianshenjiaolianhsgb.getAllJianshenjiaolian(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.jiaolianbianhao}</td>    <td>${u.jiaolianxingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.zhuanchang}</td>    <td width='90' align='center'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>    <td>${u.dianhua}</td>    <td>${u.dizhi}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

