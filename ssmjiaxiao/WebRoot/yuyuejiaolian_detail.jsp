<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>预约教练详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  预约教练详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${yuyuejiaolian.gonghao}</td>     <td width='11%'>教练姓名：</td><td width='39%'>${yuyuejiaolian.jiaolianxingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${yuyuejiaolian.xingbie}</td>     <td width='11%'>预约人：</td><td width='39%'>${yuyuejiaolian.yuyueren}</td></tr><tr>     <td width='11%'>预约日期：</td><td width='39%'>${yuyuejiaolian.yuyueriqi}</td>     <td width='11%'>学员姓名：</td><td width='39%'>${yuyuejiaolian.xueyuanxingming}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${yuyuejiaolian.lianxidianhua}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

