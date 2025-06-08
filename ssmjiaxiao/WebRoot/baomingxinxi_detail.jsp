<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>报名信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  报名信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${baomingxinxi.gonghao}</td>     <td width='11%'>教练姓名：</td><td width='39%'>${baomingxinxi.jiaolianxingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${baomingxinxi.xingbie}</td>     <td width='11%'>用户名：</td><td width='39%'>${baomingxinxi.yonghuming}</td></tr><tr>     <td width='11%'>学员姓名：</td><td width='39%'>${baomingxinxi.xueyuanxingming}</td>     <td width='11%'>联系电话：</td><td width='39%'>${baomingxinxi.lianxidianhua}</td></tr><tr>     <td width='11%'>身份证号：</td><td width='39%'>${baomingxinxi.shenfenzhenghao}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

