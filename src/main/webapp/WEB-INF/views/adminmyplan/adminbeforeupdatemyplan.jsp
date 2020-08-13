<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.springboot.entity.Plan" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<Plan> str= (ArrayList<Plan>)request.getAttribute("adminbeforeupdatemyplanlist");
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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminbeforeupdatemyplan.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminaddmyplan.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/datepicker.css">
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
	<script type="text/javascript" src="../springboot/resources/js/adminbeforeupdatemyplan.js"></script>
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
                                <form action="adminupdatemyplan" method="post">
                                <table align="center">
							          <tr class="adminaddproject2">
							              <td>更新日志:</td>
							          </tr>
						        </table>
						        <table>
						              <%
									  		for(Plan myplan:str){
									  		%>
						          	  <tr>
                                          <td>
                                              	序号:
                                          </td>
                                          <td>
                                           <input type="button" style="width: 100px; height: 30px;" name="id" id="id1" value='<%=myplan.getId()%>'>
                                           <input type="hidden" style="width: 100px; height: 30px;" name="id" id="id2" value='<%=myplan.getId()%>'>
                                       	  </td>
                                          <td>
                                              	起始日期:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 100px; height: 30px;" name="startdate" id="startdate" value='<%=myplan.getStartdate()%>' onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate">
                                          </td>
                                          <td>
                                              	结束日期:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 100px; height: 30px;" name="enddate" id="enddate" value='<%=myplan.getEnddate()%>' onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate">
                                          </td>
                                          <td>
                                       			<select style="width: 50px; height: 30px;" name="assessment" id="assessment" >
                                       								  <option><%=myplan.getAssessment()%></option>
										                              <option>优</option>
										                              <option>良</option>
										                              <option>中</option>
										                              <option>差</option>
										        </select> 
                                       	  </td>
                                     </tr>  
                                       <tr>
                                       		<td>
                                       		           计划:
                                       		</td>
                                       		<td colspan=20>
                                       			<input style="width: 1000px; height: 30px;" name="plan" id="plan" value='<%=myplan.getPlan()%>'>
                                       		</td>
                                       </tr>  
                                       <tr>
                                       		<td>
                                       		           计划:
                                       		</td>
                                       		<td colspan=20>
                                       		 	<textarea style="width: 1000px; height: 200px;" name="content" id="content"><%=myplan.getContent()%></textarea>
                                       		</td>
                                       </tr>
                                       <%
									  		}
								      %>             
                               </table> 
                               <table align="center">
                               		  <tr>                                     
                                          <td>                                          
                                               <input type="submit" value="更新计划" style="width: 100px; height: 30px;" onclick="checkId()"/>                
                                          </td>
                                          <td>
                                          		<font color="red"><c:out value="${sucess}"></c:out></font>
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
