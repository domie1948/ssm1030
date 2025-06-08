<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改健身教练</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="jianshenjiaolian_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateJianshenjiaolian.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改健身教练<input type="hidden" name="id" value="${jianshenjiaolian.id}" /></td>
						</tr>
						<tr ><td width="200">教练编号：</td><td><input name='jiaolianbianhao' type='text' id='jiaolianbianhao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeljiaolianbianhao' /></td></tr>		<tr ><td width="200">教练姓名：</td><td><input name='jiaolianxingming' type='text' id='jiaolianxingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeljiaolianxingming' /></td></tr>		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select></td></tr>		<tr ><td width="200">专长：</td><td><input name='zhuanchang' type='text' id='zhuanchang' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">照片：</td><td><input name='zhaopian' type='text' id='zhaopian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('zhaopian')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.jiaolianbianhao.value='${jianshenjiaolian.jiaolianbianhao}';</script>	<script language="javascript">document.form1.jiaolianxingming.value='${jianshenjiaolian.jiaolianxingming}';</script>	<script language="javascript">document.form1.xingbie.value='${jianshenjiaolian.xingbie}';</script>	<script language="javascript">document.form1.zhuanchang.value='${jianshenjiaolian.zhuanchang}';</script>	<script language="javascript">document.form1.zhaopian.value='${jianshenjiaolian.zhaopian}';</script>	<script language="javascript">document.form1.dianhua.value='${jianshenjiaolian.dianhua}';</script>	<script language="javascript">document.form1.dizhi.value='${jianshenjiaolian.dizhi}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var jiaolianbianhaoobj = document.getElementById("jiaolianbianhao"); if(jiaolianbianhaoobj.value==""){document.getElementById("clabeljiaolianbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入教练编号</font>";return false;}else{document.getElementById("clabeljiaolianbianhao").innerHTML="  "; } 	var jiaolianxingmingobj = document.getElementById("jiaolianxingming"); if(jiaolianxingmingobj.value==""){document.getElementById("clabeljiaolianxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入教练姓名</font>";return false;}else{document.getElementById("clabeljiaolianxingming").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
