<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>健身教练详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  健身教练详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>教练编号：</td><td width='39%'>${jianshenjiaolian.jiaolianbianhao}</td><td  rowspan=6 align=center><a href=${jianshenjiaolian.zhaopian} target=_blank><img src=${jianshenjiaolian.zhaopian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>教练姓名：</td><td width='39%'>${jianshenjiaolian.jiaolianxingming}</td></tr><tr><td width='11%' height=44>性别：</td><td width='39%'>${jianshenjiaolian.xingbie}</td></tr><tr><td width='11%' height=44>专长：</td><td width='39%'>${jianshenjiaolian.zhuanchang}</td></tr><tr><td width='11%' height=44>电话：</td><td width='39%'>${jianshenjiaolian.dianhua}</td></tr><tr><td width='11%' height=44>地址：</td><td width='39%'>${jianshenjiaolian.dizhi}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

