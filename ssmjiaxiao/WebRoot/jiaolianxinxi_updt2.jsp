﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>修改教练信息</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>


	<body>
			<form action="updateJiaolianxinxi2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改教练信息<input type="hidden" name="id" value="${jiaolianxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgonghao' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>		<tr ><td width="200">教练姓名：</td><td><input name='jiaolianxingming' type='text' id='jiaolianxingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeljiaolianxingming' /></td></tr>		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select></td></tr>		<tr ><td width="200">照片：</td><td><input name='zhaopian' type='text' id='zhaopian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('zhaopian')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">出生日期：</td><td><input name='chushengriqi' type='text' id='chushengriqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">教龄：</td><td><input name='jiaoling' type='text' id='jiaoling' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">简介：</td><td><textarea name='jianjie' cols='50' rows='5' id='jianjie' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.gonghao.value='${jiaolianxinxi.gonghao}';</script>	<script language="javascript">document.form1.mima.value='${jiaolianxinxi.mima}';</script>	<script language="javascript">document.form1.jiaolianxingming.value='${jiaolianxinxi.jiaolianxingming}';</script>	<script language="javascript">document.form1.xingbie.value='${jiaolianxinxi.xingbie}';</script>	<script language="javascript">document.form1.zhaopian.value='${jiaolianxinxi.zhaopian}';</script>	<script language="javascript">document.form1.chushengriqi.value='${jiaolianxinxi.chushengriqi}';</script>	<script language="javascript">document.form1.jiaoling.value='${jiaolianxinxi.jiaoling}';</script>	<script language="javascript">document.form1.jianjie.value='${jiaolianxinxi.jianjie}';</script>	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var gonghaoobj = document.getElementById("gonghao"); if(gonghaoobj.value==""){document.getElementById("clabelgonghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入工号</font>";return false;}else{document.getElementById("clabelgonghao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var jiaolianxingmingobj = document.getElementById("jiaolianxingming"); if(jiaolianxingmingobj.value==""){document.getElementById("clabeljiaolianxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入教练姓名</font>";return false;}else{document.getElementById("clabeljiaolianxingming").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
