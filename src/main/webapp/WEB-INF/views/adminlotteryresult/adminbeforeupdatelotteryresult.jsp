<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.springboot.entity.Lottery"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<Lottery> str= (ArrayList<Lottery>)request.getAttribute("adminbeforeupdatelotteryresultlist");
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
	<link rel="stylesheet" type="text/css" href="css/adminhome.css">
	<link rel="stylesheet" type="text/css" href="css/adminbeforeupdatelotteryresult.css">
	<link rel="stylesheet" type="text/css" href="css/datepicker.css">
	<script type="text/javascript" src="js/adminhome.js"></script>
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  </head>
  <jsp:include page="../adminheader.jsp"/>
  <body>
	   <div class="adminhome21">
            <table>
                   <tr>
                        <td>
                       		<div>
                       			  <jsp:include page="../adminnavigator.jsp"/>
                       		</div>
                       	</td>
                        <td  class="adminbeforeupdateemployee">
                            <div class="adminbeforeupdateemployee1">
                                <form action="adminupdatelotteryresult" method="post">
                                    <table>     
                                      <tr class="adminaddemployee2">
                                          <td>
                                              	更新彩票结果:
                                          </td>
                                       </tr>   
                                       <%
									  		for(Lottery lotteryresult:str){
									  		%>     
								  	  <tr>
                                           <td>
                                               	期号:
                                           </td>
                                           <td>
	                                           <input type="button" style="width: 300px; height: 30px;" name="phase" id="phase1" value='<%=lotteryresult.getPhase()%>'>
	                                           <input type="hidden" style="width: 300px; height: 30px;" name="phase" id="phase2" value='<%=lotteryresult.getPhase()%>'>
	                                       </td>
                                      </tr>
                                      <tr><td></td></tr>                   
                                      <tr>
                                          <td>
                                              	日期:
                                          </td>
                                          <td>
                                              <input type="text" style="width: 300px; height: 30px;" name="date" id="date" value='<%=lotteryresult.getDate() %>' onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"> 
                                          </td>
                                      </tr>
                                      <tr><td></td></tr>
                                      
                                      <tr>
                                          <td>
                                              	红1:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 300px; height: 30px;" name="red1" id="red1" value='<%=lotteryresult.getRed1()%>'>
                                       </td>
                                      </tr>
                                      <tr><td></td></tr>
                                      <tr>
                                           <td>
                                               	红2:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="red2" id="red2" value='<%=lotteryresult.getRed2()%>'>
                                           </td>
                                      </tr>
                                      <tr><td></td></tr>
                                      <tr>
                                           <td>
                                               	红3:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="red3" id="red3" value='<%=lotteryresult.getRed3()%>'>
                                           </td>
                                      </tr>    
                                      <tr>
                                           <td>
                                               	红4:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="red4" id="red4" value='<%=lotteryresult.getRed4()%>'>
                                           </td>
                                      </tr>      
                                      <tr>
                                           <td>
                                               	红5:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="red5" id="red5" value='<%=lotteryresult.getRed5()%>'>
                                           </td>
                                      </tr>      	
                                      <tr>
                                           <td>
                                               	蓝1:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="blue1" id="blue1" value='<%=lotteryresult.getBlue1()%>'>
                                           </td>
                                      </tr>	   
                                      <tr>
                                           <td>
                                               	蓝2:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="blue2" id="blue2" value='<%=lotteryresult.getBlue2()%>'>
                                           </td>
                                      </tr>	  
	                                      <%
									  		}
								      %>                                
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
  <jsp:include page="../adminfooter.jsp"/>
</html>
