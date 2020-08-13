<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<link rel="stylesheet" type="text/css" href="resources/css/userlogin.css">
	<script type="text/javascript" src="resources/js/userlogin.js"></script>
  </head>
  <body>
     <div class="userlogin8">
	     <div >
	          <table class="userlogin1">
	                 <tr>
	                     <td class="userlogin2">
	                          <center>Welcome to My Controlling Center</center>                                                            
	                     </td>
	                     <td class="userlogin3">
	                         <img src="resources/images/adminhome.gif" alt="adminhome" width=300px height=100px;>
	                     </td>
	                 </tr>
	                 <tr>
	                     <td colspan="2">
	                         <img src="resources/images/userlogin1.jpg" alt="userlogin1" width=100% height="150px">
	                     </td>
	                 </tr>
	                 <tr height="8px">
	                     <td colspan="2"></td>
	                 </tr>
					<tr>
	                     <td>
	                          <table class="userlogin4">
	                                 <tr>
	                                     <td >
	                                     </td>
	                                  </tr>
	                           </table>
	                           <form action="userlogin" method="post">
	                                <table class="userlogin7">                                    
	                                      <tr>
	                                          <td>
	                                              please login here:
	                                          </td>
	                                      </tr>
	                                      <tr>
	                                          <td>
	                                              User ID:
	                                          </td>
	                                          <td>
	                                              <input type="text" size="20" name="name" id="name" value=''> 
	                                          </td>
	                                          <td>
	                                          		<font color="red"><c:out value="${error}"></c:out></font>
	                                          </td>
	                                      </tr>
	                                      <tr>
	                                          <td>
	                                              Password:
	                                          </td>
	                                          <td>
	                                              <input type="password" size="20" name="password" id="password" value=''>
	                                          </td>
	                                      </tr>
	                                      <tr>        
	                                          <td></td>                             
	                                          <td>                                          
	                                               <input type="submit" value="Login"/>                
	                                               <input type="button" value="Reset" onclick="rset()"/>
	                                          </td>
	                                      </tr>
	                               </table>
	                            </form>
	                      </td>
	                      <td class="userlogin5">
	                      </td>
	                 </tr>
	          </table>
	     </div>
	     <div>
	          <table class="userlogin6">
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
     </div>
  </body>
</html>
