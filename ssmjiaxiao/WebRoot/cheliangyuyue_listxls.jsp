<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="cheliangyuyuehsgb" scope="page" class="com.bean.CheliangyuyueBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=cheliangyuyue.xls");
%>
<html>
  <head>
    <title>����ԤԼ</title>
  </head>

  <body >
 <%
			String sql="select * from cheliangyuyue  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���ƺ�</td>    <td align='center'>Ʒ���ͺ�</td>    <td align='center'>��ԤԼʱ��</td>    <td  width='65' align='center'>ԤԼ����</td>    <td align='center'>ԤԼ��</td>    <td align='center'>����</td>    <td align='center'>��ϵ�绰</td>    <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=cheliangyuyuehsgb.getAllCheliangyuyue(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.chepaihao}</td>    <td>${u.pinpaixinghao}</td>    <td>${u.keyuyueshiduan}</td>    <td>${u.yuyueriqi}</td>    <td>${u.yuyueren}</td>    <td>${u.xingming}</td>    <td>${u.lianxidianhua}</td>    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=cheliangyuyue'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

