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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminadduser.css">
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
	<script type="text/javascript" src="../springboot/resources/js/adminadduser.js"></script>
  </head>
   <jsp:include page="../adminhome/adminheader.jsp"/>
  <body>
  		<div class="adminhome21">
            <table>
                   <tr>
                       	<td  class="adminaddproject">
                            <div class="adminaddproject1">
							   <form action="adminadduser" method="post">
						             <table>   
						             	<tr>  
						             		<td>
												<jsp:include page="../adminhome/adminnavigator.jsp"/>
						                    </td>
											<td>
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							   		         </td>
											<td>
												<table>
														<tr class="adminaddemployee2">
										                   <td>
										                       Add User:
										                   </td>
										                </tr>                           
										               <tr>
										                   <td>
										                       User Name:
										                   </td>
										                   <td>
										                       <input type="text" style="width: 300px; height: 40px;" name="name" id="name" value=''> 
										                   </td>
										               </tr>
										               <tr><td></td></tr>
										               <tr>
										                   <td>
										                       User Password:
										                   </td>
										                   <td>
										                       <input type="text" style="width: 300px; height: 40px;" name="password" id="password" value=''> 
										                   </td>
										               </tr>
										               <tr><td></td></tr>
										               <tr>
										                   <td>
										                       Confirm Password:
										                   </td>
										                   <td>
										                       <input type="text" style="width: 300px; height: 40px;" name="password1" id="password1" onblur="checkPassword()" value=''> 
										                   </td>
										                   <td id="adminaddemployee3"></td>
										               </tr>
										               <tr><td></td></tr>
										               <tr>
										                   <td>
										                       User Email:
										                   </td>
										                   <td>
										                       <input type="text" style="width: 300px; height: 40px;" name="email" id="email" value=''>
										                   </td>
										               </tr>
										               <tr><td></td></tr>
										               <tr>
										                   <td>
										                       Mark:
										                   </td>
										                   <td>
										                       <select style="width: 300px; height: 40px;" name="mark" id="mark" >
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
										                       <input type="text" style="width: 300px; height: 40px;" name="phone" id="phone" value=''> 
										                   </td>
										               </tr>
										               <tr><td></td></tr>                		                                     
										               <tr>        
										                   <td></td>                             
										                   <td>                                          
										                        <input type="submit" value="Add"/>                
										                   </td>
										               </tr>
												</table>
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
