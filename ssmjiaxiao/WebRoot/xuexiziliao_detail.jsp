<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>学习资料详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  学习资料详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>资料名称：</td><td width='39%'>${xuexiziliao.ziliaomingcheng}</td><td  rowspan=3 align=center><a href=${xuexiziliao.shumian} target=_blank><img src=${xuexiziliao.shumian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>视频：</td><td width='39%'><a href="play.jsp?spwj=${xuexiziliao.shipin}">点此播放</a></td></tr><tr><td width='11%' height=44>文件：</td><td width='39%'><a href="${xuexiziliao.wenjian}">点此下载</a></td></tr><tr><td width='11%' height=100  >简介：</td><td width='39%' colspan=2 height=100 >${xuexiziliao.jianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

