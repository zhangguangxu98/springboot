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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminhome.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminshowalluser.css">
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
	<script type="text/javascript" src="../springboot/resources/js/adminshowalluser.js"></script>
	<script>
	// 当前第几页数据  
	var currentPage = ${pager.currentPage};  
	// 总页数  
	var totalPage = ${pager.totalPage};
	</script>
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
                     <td  class="adminshowallproject">
                           <div class="adminshowallproject1">
                                <form action="adminshowalluser?pageNum=<%=1%>" method="post" id=sform>
                                 <table class="adminshowallproject4">
								   <tr>
								   		 <td>
									       <input type="button" value="删除用户" style="height:30px;" onclick="submitDelForm()"/>
										 </td>
										 <td>
											 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		         </td>
										 <td>
										       <input type="button" value="添加用户" style="height:30px;" onclick="javascript:window.location.href='/springboot/adminadd'"/>
										 </td>
										 <td>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		         </td>
								       <td>
								           <input type="text" style="height:30px;" id="name" name="name" placeholder="请在这里输入用户名"/>
								       </td>
								       <td>
									       <input type="submit" style="height:30px;" value="查询用户"/>
									   </td>
								   </tr>
						   </table>
					   </form>
					    <form action="admindeleteuser" method="post" id="delform">
                        <table id="adminshowallproject2">
							   <tr class="adminshowallproject3">
							   		   <td width="5%" align="center">
											<input type="checkbox" id="input_checkbox" onclick="selectAllCheckBox();"/>
									   </td>
							           <td>
                                            	姓名
                                        </td>
                                        <td>
                                            	密码
                                        </td>
                                        <td>
                                            	邮箱
                                        </td>
                                        <td>
                                            	权限
                                        </td>
                                        <td>
                                            	手机
                                        </td>
							   </tr>
							   <c:forEach items="${pager.dataList }" var="user"> 
							   		<tr>  
							   			<td  align="center"><input type="checkbox" id="checkbox"  name="tduCheckBox" value="${user.name}" /></td>
							   		    <td><a href="adminbeforeupdateuser?name=${user.name}"><c:out value="${user.name}"></c:out></a></td>
			                            <td><c:out value="${user.password }"></c:out></td>  
			                            <td><c:out value="${user.email }"></c:out></td> 
			                            <td><c:out value="${user.mark}"></c:out></td>  
			                            <td><c:out value="${user.phone }"></c:out></td>  
			                        </tr>  
								</c:forEach>
					      </table>
					      </form>
					      <!-- <table align="center">
						   		<tr>
			                    	<td>
									       <input type="submit" value="Delete" onclick="submitDelForm()"/>
									 </td>
									 <td>
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   		         </td>
									 <td>
									       <input type="submit" value="Add" onclick="javascript:window.location.href='/springmvc/adminuser/adminadduser.jsp'"/>
									 </td>
				                 </tr> 
				            </table> -->
				            <table align="center">
				            	<tr>
				            		<td>
				            			<br> 共${pager.totalRecord}条记录共${pager.totalPage}页  当前第${pager.currentPage}页      
							            <a href="javascript:firstPage()">首页</a>    
							            <a href="javascript:nextPage()">下一页</a> 
							            <a href="javascript:previousPage()">上一页</a> 
							            <a href="javascript:lastPage()">尾页</a>
				            		</td>
				            	</tr>
				           </table>
                           </div>
                       </td>
                  </tr>
           </table>
	  </div>
  </body>
  <jsp:include page="../adminhome/adminfooter.jsp"/>
</html>
