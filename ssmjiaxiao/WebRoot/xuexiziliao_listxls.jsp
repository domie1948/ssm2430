<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xuexiziliaohsgb" scope="page" class="com.bean.XuexiziliaoBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xuexiziliao.xls");
%>
<html>
  <head>
    <title>ѧϰ����</title>
  </head>

  <body >
 <%
			String sql="select * from xuexiziliao  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>��������</td>    <td  width='90' align='center'>����</td>    <td  width='90' align='center'>��Ƶ</td>    <td  width='90' align='center'>�ļ�</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=xuexiziliaohsgb.getAllXuexiziliao(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.ziliaomingcheng}</td>    <td width='90' align='center'><a href='${u.shumian}' target='_blank'><img src='${u.shumian}' width=88 height=99 border=0 /></a></td>    <td width='90' align='center'><a href='play.jsp?spwj=${u.shipin}' target='_blank'>��˲���</a></td>    <td width='90' align='center'><a href='${u.wenjian}' target='_blank'>����</a></td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

