﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>车辆信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  车辆信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>车牌号：</td><td width='39%'>${cheliangxinxi.chepaihao}</td><td  rowspan=4 align=center><a href=${cheliangxinxi.zhaopian} target=_blank><img src=${cheliangxinxi.zhaopian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>品牌型号：</td><td width='39%'>${cheliangxinxi.pinpaixinghao}</td></tr><tr><td width='11%' height=44>首次上牌时间：</td><td width='39%'>${cheliangxinxi.shoucishangpaishijian}</td></tr><tr><td width='11%' height=44>可预约时段：</td><td width='39%'>${cheliangxinxi.keyuyueshiduan}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

