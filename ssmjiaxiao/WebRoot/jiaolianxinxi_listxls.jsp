<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jiaolianxinxihsgb" scope="page" class="com.bean.JiaolianxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jiaolianxinxi.xls");
%>
<html>
  <head>
    <title>教练信息</title>
  </head>

  <body >
 <%
			String sql="select * from jiaolianxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>工号</td>    <td align='center'>密码</td>    <td align='center'>教练姓名</td>    <td  width='40' align='center'>性别</td>    <td  width='90' align='center'>照片</td>    <td  width='65' align='center'>出生日期</td>    <td align='center'>教龄</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=jiaolianxinxihsgb.getAllJiaolianxinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gonghao}</td>    <td>${u.mima}</td>    <td>${u.jiaolianxingming}</td>    <td align='center'>${u.xingbie}</td>    <td width='90' align='center'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>    <td>${u.chushengriqi}</td>    <td>${u.jiaoling}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

