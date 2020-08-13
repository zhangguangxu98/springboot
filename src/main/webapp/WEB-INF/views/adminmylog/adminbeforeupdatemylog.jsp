<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.springboot.entity.Log" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<Log> str= (ArrayList<Log>)request.getAttribute("adminbeforeupdatemyloglist");
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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminbeforeupdatemylog.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminaddmylog.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/datepicker.css">
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
	<script type="text/javascript" src="../springboot/resources/js/adminbeforeupdatemylog.js"></script>
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
                                <form action="adminupdatemylog" method="post">
                                <%
									  		for(Log mylog:str){
									  		%>
                                <table>
							          <tr class="adminaddproject2">
							              <td align="left">更新日志:</td>
							              <%-- <td>
							              	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							              	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							              </td>
							              <td>
                                              	序号:
                                          </td>
                                          <td>
                                           <input type="button" style="width: 50px; height: 30px;" name="id" id="id" value='<%=mylog.getId()%>'>
                                           <input type="hidden" style="width: 50px; height: 30px;" name="id" id="id" value='<%=mylog.getId()%>'>
                                       	  </td> --%>
							          </tr>
						        </table>
						        <table>
						              
						          	  <tr>
                                          <td>
                                              	序号:
                                          </td>
                                          <td>
                                           <input type="button" style="width: 50px; height: 30px;" name="id" id="id1" value='<%=mylog.getId()%>'>
                                           <input type="hidden" style="width: 50px; height: 30px;" name="id" id="id2" value='<%=mylog.getId()%>'>
                                       	  </td>
                                          <td>
                                              	日期:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 50px; height: 30px;" name="date" id="date" value='<%=mylog.getDate()%>' onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate">
                                          </td>
                                          <td>
                                              	家庭:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 50px; height: 30px;" name="home" id="home" value='<%=mylog.getHome()%>'>
                                          </td>
                                           <td>
                                               	衣服:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="clothes" id="clothes" value='<%=mylog.getClothes()%>'>
                                           </td>
                                           <td>
                                               	食物:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="meal" id="meal" value='<%=mylog.getMeal()%>'>
                                           </td>
                                           <td>
                                               	住宿:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="room" id="room" value='<%=mylog.getRoom()%>'>
                                           </td>
                                           <td>
                                               	交通:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="trip" id="trip" value='<%=mylog.getTrip()%>'>
                                           </td>
                                           <td>
                                              	 用品:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="lifeuse" id="lifeuse" value='<%=mylog.getLifeuse()%>'>
                                           </td>
                                           <td>
                                               	娱乐:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="play" id="play" value='<%=mylog.getPlay()%>'>
                                           </td>
                                           
                                           <td>
                                               	税后:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="insurance" id="insurance" value='<%=mylog.getInsurance()%>'>
                                           </td>
                                           <td>
                                               	税前:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 50px; height: 30px;" name="pretaxincome" id="pretaxincome" value='<%=mylog.getPretaxincome()%>'>
                                           </td>
                                           
                                     </tr> 
                                     <tr>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="idroutine" id="idroutine" value='<%=mylog.getIdroutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="dateroutine" id="dateroutine" value='<%=mylog.getDateroutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="homeroutine" id="homeroutine" value='<%=mylog.getHomeroutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="clothesroutine" id="clothesroutine" value='<%=mylog.getClothesroutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="mealroutine" id="mealroutine" value='<%=mylog.getMealroutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="roomroutine" id="roomroutine" value='<%=mylog.getRoomroutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="triproutine" id="triproutine" value='<%=mylog.getTriproutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="useroutine" id="useroutine" value='<%=mylog.getUseroutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="playroutine" id="playroutine" value='<%=mylog.getPlayroutine()%>'>
                                           </td>
                                           <td colspan=2>
                                               <input type="text" style="width: 100px; height: 30px;" name="insuranceroutine" id="insuranceroutine" value='<%=mylog.getInsuranceroutine()%>'>
                                           </td>
                                     </tr> 
                                     <tr>
                                            <td>
                                              	 自制:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="selfcontrol" id="selfcontrol" >
										                              <option><%=mylog.getSelfcontrol()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 勤奋:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="diligence" id="diligence" >
										                              <option><%=mylog.getDiligence()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 秩序:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="goodorder" id="goodorder" >
										                              <option><%=mylog.getGoodorder()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 整洁:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="clean" id="clean" >
										                              <option><%=mylog.getClean()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 节俭:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="frugality" id="frugality" >
										                              <option><%=mylog.getFrugality()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 诚实:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="honest" id="honest" >
										                              <option><%=mylog.getHonest()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 正直:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="integrity" id="integrity" >
										                              <option><%=mylog.getIntegrity()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 谦虚:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="modest" id="modest" >
										                              <option><%=mylog.getModest()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 友善:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="friendly" id="friendly" >
										                              <option><%=mylog.getFriendly()%></option>
										                              <option>√</option>
										                              <option>×</option>
										        </select> 
                                       		</td>
                                            <td>
                                              	 宽容:
                                            </td>
                                       		<td>
                                       			<select style="width: 50px; height: 30px;" name="tolerant" id="tolerant" >
										                              <option><%=mylog.getTolerant()%></option>
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
                                       		 	<textarea style="width: 1000px; height: 200px;" name="diary" id="diary"><%=mylog.getDiary()%></textarea>
                                       		</td>
                                       </tr>  
                                                   
                               </table> 
                               <%
									  		}
								      %> 
                               <table align="center">
                               		  <tr>                                     
                                          <td>                                          
                                               <input type="submit" value="更新日志" style="width: 100px; height: 30px;" onclick="checkId()"/>                
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
