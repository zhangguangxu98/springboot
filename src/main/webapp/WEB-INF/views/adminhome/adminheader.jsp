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
	   <div class="adminhome21">
	        <div>
	              <table class="adminhome1">
	                     <tr>
	                         <td class="adminhome2">
	                             <img src="../springboot/resources/images/adminhome.gif" alt="adminhome" height="60px" width="150px"/>
	                         </td>
	                         <td class="adminhome15">
	                              <center>Welcome to My Controlling Center</center>
	                         </td>
	                         <td class="adminhome16">
	                              <img src="../springboot/resources/images/adminhome.gif" alt="adminhome" height="60px" width="150px"/>
	                         </td>
	                     </tr>
	              </table>
	        </div>
	        <div>
	             <table class="adminhome3">
	                    <tr>
	                         <td><a href="/springboot/adminhome">Home</a></td>
	                         <td class="adminhome18">
	                              <img src="../springboot/resources/images/adminhome1.png" alt="logout"/>
	                              <a href="/springboot/login" onclick="return window.confirm('Really want to exit the system')">Log out</a>
	                         </td>
	                    </tr>
	             </table>
	        </div>
	  </div>
  </body>
</html>
