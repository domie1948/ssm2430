<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="cheliangyuyuehsgb" scope="page" class="com.bean.CheliangyuyueBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=cheliangyuyue.xls");
%>
<html>
  <head>
    <title>车辆预约</title>
  </head>

  <body >
 <%
			String sql="select * from cheliangyuyue  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>车牌号</td>    <td align='center'>品牌型号</td>    <td align='center'>可预约时段</td>    <td  width='65' align='center'>预约日期</td>    <td align='center'>预约人</td>    <td align='center'>姓名</td>    <td align='center'>联系电话</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=cheliangyuyuehsgb.getAllCheliangyuyue(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.chepaihao}</td>    <td>${u.pinpaixinghao}</td>    <td>${u.keyuyueshiduan}</td>    <td>${u.yuyueriqi}</td>    <td>${u.yuyueren}</td>    <td>${u.xingming}</td>    <td>${u.lianxidianhua}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=cheliangyuyue'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

