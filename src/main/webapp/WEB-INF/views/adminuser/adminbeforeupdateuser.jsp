<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.springboot.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<User> str= (ArrayList<User>)request.getAttribute("adminbeforeupdateuserlist");
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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminbeforeupdateuser.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/datepicker.css">
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
	<script type="text/javascript" src="../springboot/resources/My97DatePicker/WdatePicker.js"></script>
  </head>
  <jsp:include page="../adminhome/adminheader.jsp"/>
  <body>
	   <div class="adminhome21"> 
           <table>
                  <tr>
                      <td>
	                       <div>
	                         	  <jsp:include page="../adminhome/adminnavigator.jsp"/>
	                       </div>
                   	  </td>
                      <td  class="adminbeforeupdateemployee">
                           <div class="adminbeforeupdateemployee1">
                               <form action="adminupdateuser" method="post">
                                   <table>     
                                     <tr class="adminaddemployee2">
                                         <td>
                                             Update User:
                                         </td>
                                      </tr>   
                                      <%
							  		for(User user:str){
							  		%>                        
                                     <tr>
                                         <td>
                                             User Name:
                                         </td>
                                         <td>
                                             <input type="button" style="width: 300px; height: 40px;" name="name" id="name1" value='<%=user.getName() %>'>
                                             <input type="hidden" style="width: 300px; height: 40px;" name="name" id="name2" value='<%=user.getName() %>'>
                                         </td>
                                     </tr>
                                     <tr><td></td></tr>
                                     <tr>
                                         <td>
                                             User Password:
                                         </td>
                                         <td>
                                             <input type="text" style="width: 300px; height: 40px;" name="password" id="password" value='<%=user.getPassword() %>'> 
                                         </td>
                                     </tr>
                                     <tr><td></td></tr>
                                     <tr>
                                         <td>
                                             User Email:
                                         </td>
                                         <td>
                                             <input type="text" style="width: 300px; height: 40px;" name="email" id="email" value='<%=user.getEmail() %>'>
                                         </td>
                                     </tr>
                                     <tr><td></td></tr>
                                     <tr>
                                         <td>
                                             Mark:
                                         </td>
                                         <td>
                                             <select style="width: 300px; height: 40px;" name="mark" id="mark" value='<%=user.getMark() %>'>
                                                 <option>admin</option>
                                                 <option>employee</option>
                                                 <option>leader</option>
                                             </select> 
                                         </td>
                                     </tr>
                                     <tr><td></td></tr>
                                     <tr>
                                         <td>
                                             User Phone:
                                         </td>
                                         <td>
                                             <input type="text" style="width: 300px; height: 40px;" name="phone" id="phone" value='<%=user.getPhone() %>'> 
                                         </td>
                                     </tr>
                                     <%
							  		}
							      %>
                                     <tr><td></td></tr>                		                                     
                                     <tr>        
                                         <td></td>                             
                                         <td>                                          
                                              <input type="submit" value="Update"/>                
                                         </td>
                                     </tr>
                              </table>
                           </form>
				   		  </div>
                       </td>
                  </tr>
           </table>
	  </div>
  </body>
  <jsp:include page="../adminhome/adminfooter.jsp"/>
</html>
