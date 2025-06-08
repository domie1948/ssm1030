<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>教练预约详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  教练预约详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>教练编号：</td><td width='39%'>${jiaolianyuyue.jiaolianbianhao}</td>     <td width='11%'>教练姓名：</td><td width='39%'>${jiaolianyuyue.jiaolianxingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${jiaolianyuyue.xingbie}</td>     <td width='11%'>专长：</td><td width='39%'>${jiaolianyuyue.zhuanchang}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${jiaolianyuyue.dianhua}</td>     <td width='11%'>地址：</td><td width='39%'>${jiaolianyuyue.dizhi}</td></tr><tr>     <td width='11%'>用户名：</td><td width='39%'>${jiaolianyuyue.yonghuming}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

