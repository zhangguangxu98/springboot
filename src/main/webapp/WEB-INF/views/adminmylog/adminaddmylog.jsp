<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminaddmylog.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/datepicker.css">
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
	<script type="text/javascript" src="../springboot/resources/js/adminaddmylog.js"></script>
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
                        <td  class="adminaddproject">
                            <div class="adminaddproject1">
                            <form action="adminaddmylog" method="post" id="addform">
                                <table>
							          <tr class="adminaddproject2">
							              <td align="left">添加日志:</td>
							              <!-- <td>
							              	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							              	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							              </td>
							              <td>
                                              	序号:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 50px; height: 30px;" name="id" id="id" value=''>
                                       	  </td> -->
							          </tr>
						        </table>
						        <table>
						          <tr>
                                          <td>
                                              	序号:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 50px; height: 30px;" name="id" id="id" value=''>
                                       	  </td>
                                          <td>
                                              	日期:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 50px; height: 30px;" name="date" id="date" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate">
                                          </td>
                                          <td>
                                              	家庭:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 50px; height: 30px;" name="home" id="home" value=''>
                                          </td>
                                           <td>
                                               	衣服:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="clothes" id="clothes" value=''>
                                           </td>
                                           <td>
                                               	食物:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="meal" id="meal" value=''>
                                           </td>
                                           <td>
                                               	住宿:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="room" id="room" value=''>
                                           </td>
                                           <td>
                                               	交通:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="trip" id="trip" value=''>
                                           </td>
                                           <td>
                                              	 用品:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="lifeuse" id="lifeuse" value=''>
                                           </td>
                                           <td>
                                               	娱乐:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="play" id="play" value=''>
                                           </td>
                                           <td>
                                               	税后:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="insurance" id="insurance" value=''>
                                           </td>
                                           <td>
                                               	税前:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="pretaxincome" id="pretaxincome" value=''>
                                           </td>
                                           
                                     </tr> 
                                     <tr>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="idroutine" id="idroutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="dateroutine" id="dateroutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="homeroutine" id="homeroutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="clothesroutine" id="clothesroutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="mealroutine" id="mealroutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="roomroutine" id="roomroutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="triproutine" id="triproutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="useroutine" id="useroutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="playroutine" id="playroutine" value=''>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="insuranceroutine" id="insuranceroutine" value=''>
                                           </td>
                                     </tr> 
                                     <tr>
                                            <td>
                                              	 自制:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="selfcontrol" id="selfcontrol" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 勤奋:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="diligence" id="diligence" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 秩序:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="goodorder" id="goodorder" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 整洁:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="clean" id="clean" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 节俭:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="frugality" id="frugality" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 诚实:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="honest" id="honest" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 正直:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="integrity" id="integrity" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 谦虚:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="modest" id="modest" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 友善:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="friendly" id="friendly" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 宽容:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="tolerant" id="tolerant" >
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                       </tr>   
                                       <tr>
                                       		<td>
                                       		           日记:
                                       		</td>
                                       		<td colspan=20>
                                       		 	<textarea style="width: 1000px; height: 200px;" name="diary" id="diary" ></textarea>
                                       		</td>
                                       </tr>               
                               </table> 
                               <table align="center">
                               		  <tr>                                     
                                          <td>                                          
                                               <input type="button" value="添加日志" style="width: 100px; height: 30px;" onclick="checkId()"/>                
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
