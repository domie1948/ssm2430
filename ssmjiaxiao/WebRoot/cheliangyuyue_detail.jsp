<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>车辆预约详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  车辆预约详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>车牌号：</td><td width='39%'>${cheliangyuyue.chepaihao}</td>     <td width='11%'>品牌型号：</td><td width='39%'>${cheliangyuyue.pinpaixinghao}</td></tr><tr>     <td width='11%'>可预约时段：</td><td width='39%'>${cheliangyuyue.keyuyueshiduan}</td>     <td width='11%'>预约日期：</td><td width='39%'>${cheliangyuyue.yuyueriqi}</td></tr><tr>     <td width='11%'>预约人：</td><td width='39%'>${cheliangyuyue.yuyueren}</td>     <td width='11%'>姓名：</td><td width='39%'>${cheliangyuyue.xingming}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${cheliangyuyue.lianxidianhua}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

