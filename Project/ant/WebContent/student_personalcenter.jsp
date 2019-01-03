<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>个人页面_个人中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="css/student_personalcenter.css" />
<link rel="stylesheet" type="text/css" href="css/header_footer.css" />
<script type="text/javascript" src="js/student_personalcenter2.js"></script>
</head>
<body>
	<%@include file="student_header.jsp"%>
	<table>
		<!--页面header-->
		<!--首页/个人首页-->
		<tr>
			<td>
				<table class="table1">
					<tr>
						<td class="tr0td0"><a href="student_index.jsp" class="toplink">首页</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a
							href="personalcenter" class="currentpage">个人中心</a></td>
					</tr>
					<tr>
						<td><img src="images/01.png" class="img1"></td>
						<td>
							<p class="table1-welcome">您好，${s.name }！</p> <br>
							<p class="table1-little">LittleAnt | 最权威的活动展示和统计平台</p>
						</td>
						<td>
							<p class="table1-youshang">
								参加活动数<br>
							</p>
							<p class="table1-youxia">${activityNum}</p>
						</td>
						<td>
							<p class="table1-youshang">
								参加活动得分<br>
							</p>
							<p class="table1-youxia">${nowScore}</p>
						</td>
						<td>
							<p class="table1-youshang">
								可报名活动数<br>
							</p>
							<p class="table1-youxia">${studentActivityNum}</p>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>

			<table class="table2">
				<tr>
					<td class="table2-tr0td0">
						<!--我报名过的活动-->
						<table class="table5" cellspacing="0" cellpadding="0">
							<tr>
								<td colspan="3" class="table5-tr0">我报名过的活动</td>
							</tr>
							<!--未开始-->
							<tr class="table5-tr1">
								<td colspan="3" class="table5-tr1td0">
									<div class="module" onclick="changestatus1()">
										<img src="images/03.png" class="status1" id="status1">
										<lable class="prompt">未开始</lable>
									</div>
								</td>
							</tr>
							<tr class="table5-tr2" name="hidde1">
								<c:forEach items="${appliedActsWithNotBegin }" var="notBeginAct"
									varStatus="abc">
									<td class="table5-tr2td0">
										<div class="table5-tr2td0-div">
											<table class="table6" cellspacing="0" cellpadding="5">
												<tr>
													<td class="table6-tr0td0"><img src="images/tag.png"
														class="table6-tr0td0-img"></td>
													<td class="table6-tr0td1"><a class="table6-tr0td1-a"
														href="activitydetail?actid=${notBeginAct.id }"
														name="table6-tr0td1-a">${notBeginAct.name }</a></td>
												</tr>
												<tr>
													<td colspan="2" class="table6-tr2"><div class="des">
														${notBeginAct.description }</div></td>
												</tr>
												<tr>
													<td class="table6-tr4td0">${notBeginAct.organization.name }</td>
													<td class="table6-tr4td1">Begin:${notBeginAct.holdBegin }</td>
												</tr>
											</table>
										</div>
									</td>
									<c:if test="${abc.count%3==0 }">
							</tr>
							<tr class="table5-tr2" name="hidde1">
								</c:if>
								</c:forEach>
							</tr>
							<!--进行中-->
							<tr class="table5-tr3">
								<td colspan="3" class="table5-tr3td0">
									<div class="module" onclick="changestatus2()">
										<img src="images/03.png" class="status2" id="status2">
										<lable class="prompt">进行中</lable>
									</div>
								</td>
							</tr>
							<tr class="table5-tr4" name="hidde2">
								<c:forEach items="${appliedActsOnHolding }" var="onHoldingAct"
									varStatus="abc">
									<td class="table5-tr2td0">
										<div class="table5-tr2td0-div">
											<table class="table6" cellspacing="0" cellpadding="5">
												<tr>
													<td class="table6-tr0td0"><img src="images/tag.png"
														class="table6-tr0td0-img"></td>
													<td class="table6-tr0td1"><a class="table6-tr0td1-a"
														href="activitydetail?actid=${onHoldingAct.id }"
														name="table6-tr0td1-a">${onHoldingAct.name }</a></td>
												</tr>
												<tr>
													<td colspan="2" class="table6-tr1"></td>
												</tr>
												<tr>
													<td colspan="2" class="table6-tr2">
														${onHoldingAct.description }</td>
												</tr>
												<tr>
													<td colspan="2" class="table6-tr3"></td>
												</tr>
												<tr>
													<td class="table6-tr4td0">${onHoldingAct.organization.name }</td>
													<td class="table6-tr4td1">Begin:${onHoldingAct.holdBegin }</td>
												</tr>
											</table>
										</div>
									</td>
									<c:if test="${abc.count%3==0 }">
							</tr>
							<tr class="table5-tr4" name="hidde2">
								</c:if>
								</c:forEach>
							</tr>
							<!--已结束-->
							<tr class="table5-tr5">
								<td colspan="3" class="table5-tr5td0">
									<div class="module" onclick="changestatus3()">
										<img src="images/03.png" class="status3" id="status3">
										<lable class="prompt">已结束</lable>
									</div>
								</td>
							</tr>
							<tr class="table5-tr6" name="hidde3">
								<c:forEach items="${appliedActsWithAlreadyEnd }" var="endActs"
									varStatus="abc">
									<td class="table5-tr2td0">
										<div class="table5-tr2td0-div">
											<table class="table6" cellspacing="0" cellpadding="5">
												<tr>
													<td class="table6-tr0td0"><img src="images/tag.png"
														class="table6-tr0td0-img"></td>
													<td class="table6-tr0td1"><a class="table6-tr0td1-a"
														href="activitydetail?actid=${endActs.id }"
														name="table6-tr0td1-a">${endActs.name }</a></td>
												</tr>
												<tr>
													<td colspan="2" class="table6-tr1"></td>
												</tr>
												<tr>
													<td colspan="2" class="table6-tr2">
														${endActs.description }</td>
												</tr>
												<tr>
													<td colspan="2" class="table6-tr3"></td>
												</tr>
												<tr>
													<td class="table6-tr4td0">${endActs.organization.name }</td>
													<td class="table6-tr4td1">End:${endActs.holdEnd }</td>
												</tr>
											</table>
										</div>
									</td>
									<c:if test="${abc.count%3==0 }">
							</tr>
							<tr class="table5-tr6" name="hidde3">
								</c:if>
								</c:forEach>
							</tr>
						</table>
					</td>
					<!--留白宽20px-->
					<td class="table2-tr0td1"></td>
					<!--日历+浏览历史-->
					<td class="add">
						<table class="table3" cellpadding="0px" cellspacing="0px">
							<tr>
								<td class="table3-tr0td0">
									<!--日历-->
									<div class='calendar' id='calendar'></div> <script
										type='text/javascript' src='js/student_personalcenter.js'></script>
								</td>
							</tr>

							<tr>
								<td class="table3-tr1td0">
									<!--留白高10px-->
								</td>
							</tr>

							<tr>
								<td class="table3-tr2td0">
									<!--浏览历史-->
									<div class="table4">
										<p class="table4-p">浏览历史</p>
										<div class="table4-div">
											<ul class="table4-divul1">
												<c:forEach items="${scannedActList }" var="scannedAct">
													<li><a onclick="getactid()"
														href="activitydetail?actid=${scannedAct.id }">${scannedAct.name }</a>
														<lable class="scannedhidid" id="idvalue">${scannedAct.id }</lable></li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</tr>
	</table>
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>