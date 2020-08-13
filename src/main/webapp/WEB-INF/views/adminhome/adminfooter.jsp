<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminhome.css">
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
  </head>

  <body>
	     <div>
	          <table class="adminhome14">
	                <tr>
	                    <td>
	                        <center>
	                                 Copyright &copy; 1990 - 2020  Guangxu.Zhang, All Rights Reserved
	                                 <br>               
	                                 N0. 182 Mo Yu Road Anting Shanghai
	                        </center>
	                    </td>
	                </tr>
	          </table>
	     </div>
  </body>
</html>
