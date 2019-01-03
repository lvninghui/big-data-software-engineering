<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>组织者页面_我的</title>
<link rel="stylesheet" type="text/css" href="css/header_footer.css">
<link rel="stylesheet" type="text/css" href="css/organization_mine.css">
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<div class="wrapper">
		<!-- 页头 -->
		<%@include file="organization_header.jsp"%>
		<!-- 主要部分 -->
		<div class="main">
			<!-- 上部分 -->
			<div class="top_org">
				<div class="top_nav">
					<a href="organization_index.jsp">首页</a>/ <span>我的</span>
				</div>
				<div class="top_list">
					<div class="top_list_part">
						<div class="box">
							<div class="box_top">
								<span>未开始</span>
							</div>
							<div class="box_bottom">
								<span>${countBeforeTime }个活动</span>
							</div>
						</div>
					</div>
					<div class="top_list_part">
						<div class="box">
							<div class="box_top">
								<span>进行中</span>
							</div>
							<div class="box_bottom">
								<span>${countInTime }个活动</span>
							</div>
						</div>
					</div>
					<div class="top_list_part">
						<div class="box">
							<div class="box_top">
								<span>已完成</span>
							</div>
							<div class="box_bottom">
								<span>${countAfterTime }个活动</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<!-- 下部分 -->
			<div class="bottom">
				<div class="bottom_detail">
					<div class="bottom_nav">
						<div class="bottom_nav_left">
							<span>我发布的活动列表</span>
						</div>
						<div class="bottom_nav_right">
							<div class="button">
								<c:if test="${key eq '0' }">
									<div class="btn active">
										<a href="toDisplayOrganizationMine">全部</a>
									</div>
									<div class="btn" id="btn_before">
										<a href="displayBeforeTime">未开始</a>
									</div>
									<div class="btn" id="btn_ing">
										<a href="displayInTime">进行中</a>
									</div>
									<div class="btn" id="btn_after">
										<a href="displayAfterTime">已结束</a>
									</div>
								</c:if>

								<c:if test="${key eq '1' }">
									<div class="btn">
										<a href="toDisplayOrganizationMine">全部</a>
									</div>
									<div class="btn active" id="btn_before">
										<a href="displayBeforeTime">未开始</a>
									</div>
									<div class="btn" id="btn_ing">
										<a href="displayInTime">进行中</a>
									</div>
									<div class="btn" id="btn_after">
										<a href="displayAfterTime">已结束</a>
									</div>
								</c:if>

								<c:if test="${key eq '2' }">
									<div class="btn">
										<a href="toDisplayOrganizationMine">全部</a>
									</div>
									<div class="btn" id="btn_before">
										<a href="displayBeforeTime">未开始</a>
									</div>
									<div class="btn active" id="btn_ing">
										<a href="displayInTime">进行中</a>
									</div>
									<div class="btn" id="btn_after">
										<a href="displayAfterTime">已结束</a>
									</div>
								</c:if>


								<c:if test="${key eq '3' }">
									<div class="btn">
										<a href="toDisplayOrganizationMine">全部</a>
									</div>
									<div class="btn" id="btn_before">
										<a href="displayBeforeTime">未开始</a>
									</div>
									<div class="btn" id="btn_ing">
										<a href="displayInTime">进行中</a>
									</div>
									<div class="btn active" id="btn_after">
										<a href="displayAfterTime">已结束</a>
									</div>
								</c:if>

							</div>
							<div class="search_org">
								<form>
									<input type="text" placeholder="请输入活动名称">
									<button type="submit"></button>
								</form>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="bottom_publish">
						<a class="btn_publish" href="organization_publishactivity.jsp">+发布活动</a>
					</div>
					<div class="bottom_list">
						<c:if test="${key eq '0' }">
							<c:forEach items="${allActivity.list }" var="all" varStatus="s">
								<div class="bottom_list_detail">
									<div class="bottom_list_detail_left">
										<div class="num">
											<span>${s.count }</span>
										</div>
										<div class="detail">
											<a class="title">${all[0] }</a>
											<p class="text">${all[1] }</p>
										</div>
										<div class="author">
											<p class="text">发布者</p>
											<p class="text">${o.name }</p>
										</div>
									</div>
									<div class="bottom_list_detail_right">
										<div class="time">
											<p class="text">活动开始时间</p>
											<p class="text">${all[2] }</p>
										</div>
										<div class="progress">
											<div class="statusList">
												<div class="scheduleGray">
													<c:if test="${all[2]>currentTime }">
														<div class="scheduleGreen" style="width: 0%"></div>
													</c:if>
													<c:if test="${all[2]<=currentTime and all[3]>=currentTime}">
														<div class="scheduleGreen"
															style="width:${(currentTime.time-all[2].time)/(all[3].time-all[2].time)*100 }%"></div>
													</c:if>
													<c:if test="${all[3]<currentTime }">
														<div class="scheduleGreen" style="width: 100%"></div>
													</c:if>
												</div>
											</div>
										</div>
										<div class="operation">
											<a href="display?act=${all[0] }">编辑活动</a> <a href="toparticipationall?activityid=${all[4]}">参与详情</a> <a href="delete?act=${all[4] }">删除活动</a>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</c:forEach>
						</c:if>
						<c:if test="${key eq '1' }">
							<c:forEach items="${beforeActivity.list }" var="ba" varStatus="s">
								<div class="bottom_list_detail">
									<div class="bottom_list_detail_left">
										<div class="num">
											<span>${s.count }</span>
										</div>
										<div class="detail">
											<a class="title">${ba[0] }</a>
											<p class="text">${ba[1] }</p>
										</div>
										<div class="author">
											<p class="text">发布者</p>
											<p class="text">${o.name }</p>
										</div>
									</div>
									<div class="bottom_list_detail_right">
										<div class="time">
											<p class="text">活动开始时间</p>
											<p class="text">${ba[2] }</p>
										</div>
										<div class="progress">
											<div class="statusList">
												<div class="scheduleGray">
													<div class="scheduleGreen" style="width: 0%"></div>
												</div>
											</div>
										</div>
										<div class="operation">
											<a href="display?act=${ba[0] }">编辑活动</a> <a href="toparticipationall?activityid=${ba[4]}">参与详情</a> <a href="delete?act=${ba[4] }">删除活动</a>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</c:forEach>
						</c:if>
						<c:if test="${key eq '2' }">
							<c:forEach items="${inActivity.list }" var="ia" varStatus="s">
								<div class="bottom_list_detail">
									<div class="bottom_list_detail_left">
										<div class="num">
											<span>${s.count }</span>
										</div>
										<div class="detail">
											<a class="title">${ia[0] }</a>
											<p class="text">${ia[1] }</p>
										</div>
										<div class="author">
											<p class="text">发布者</p>
											<p class="text">${o.name }</p>
										</div>
									</div>
									<div class="bottom_list_detail_right">
										<div class="time">
											<p class="text">活动开始时间</p>
											<p class="text">${ia[2] }</p>
										</div>
										<div class="progress">
											<div class="statusList">
												<div class="scheduleGray">
													<div class="scheduleGreen"
														style="width:${(currentTime.time-ia[2].time)/(ia[3].time-ia[2].time)*100 }%">
													</div>
												</div>
											</div>
										</div>
										<div class="operation">
											<a href="display?act=${ia[0] }">编辑活动</a> <a href="toparticipationall?activityid=${ia[4]}">参与详情</a> <a href="delete?act=${ia[4] }">删除活动</a>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</c:forEach>
						</c:if>
						<c:if test="${key eq '3' }">
							<c:forEach items="${afterActivity.list }" var="aa" varStatus="s">
								<div class="bottom_list_detail">
									<div class="bottom_list_detail_left">
										<div class="num">
											<span>${s.count }</span>
										</div>
										<div class="detail">
											<a class="title">${aa[0] }</a>
											<p class="text">${aa[1] }</p>
										</div>
										<div class="author">
											<p class="text">发布者</p>
											<p class="text">${o.name }</p>
										</div>
									</div>
									<div class="bottom_list_detail_right">
										<div class="time">
											<p class="text">活动开始时间</p>
											<p class="text">${aa[2] }</p>
										</div>
										<div class="progress">
											<div class="statusList">
												<div class="scheduleGray">
													<div class="scheduleGreen" style="width: 100%"></div>
												</div>
											</div>
										</div>
										<div class="operation">
											<a href="display?act=${aa[0] }">编辑活动</a> <a href="toparticipationall?activityid=${aa[4]}">参与详情</a> <a href="delete?act=${aa[4] }">删除活动</a>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</c:forEach>
						</c:if>
					</div>
					<div class="bottom_page">
						<div class="page">
							<c:if test="${key eq '0' }">
								<ul class="pagination">
									<li><a href="toDisplayOrganizationMine?pageNum=1">首页</a></li>
									<li><a
										href="toDisplayOrganizationMine?pageNum=${allActivity.prePageNum }">上一页</a></li>
									<li><a href="#" class="currentPage active">${allActivity.currentPageNum }/${allActivity.totalPageNum }</a></li>
									<li><a
										href="toDisplayOrganizationMine?pageNum=${allActivity.nextPageNum }">下一页</a></li>
									<li><a
										href="toDisplayOrganizationMine?pageNum=${allActivity.totalPageNum }">尾页</a></li>
								</ul>
							</c:if>
							<c:if test="${key eq '1' }">
								<ul class="pagination">
									<li><a href="displayBeforeTime?pageNum=1">首页</a></li>
									<li><a
										href="displayBeforeTime?pageNum=${beforeActivity.prePageNum }">上一页</a></li>
									<li><a href="#" class="currentPage active">${beforeActivity.currentPageNum }/${beforeActivity.totalPageNum }</a></li>
									<li><a
										href="displayBeforeTime?pageNum=${beforeActivity.nextPageNum }">下一页</a></li>
									<li><a
										href="displayBeforeTime?pageNum=${beforeActivity.totalPageNum }">尾页</a></li>
								</ul>
							</c:if>
							<c:if test="${key eq '2' }">
								<ul class="pagination">
									<li><a href="displayInTime?pageNum=1">首页</a></li>
									<li><a
										href="displayInTime?pageNum=${inActivity.prePageNum }">上一页</a></li>
									<li><a href="#" class="currentPage active">${inActivity.currentPageNum }/${inActivity.totalPageNum }</a></li>
									<li><a
										href="displayInTime?pageNum=${inActivity.nextPageNum }">下一页</a></li>
									<li><a
										href="displayInTime?pageNum=${inActivity.totalPageNum }">尾页</a></li>
								</ul>
							</c:if>
							<c:if test="${key eq '3' }">
								<ul class="pagination">
									<li><a href="displayAfterTime?pageNum=1">首页</a></li>
									<li><a
										href="displayAfterTime?pageNum=${afterActivity.prePageNum }">上一页</a></li>
									<li><a href="#" class="currentPage active">${afterActivity.currentPageNum }/${afterActivity.totalPageNum }</a></li>
									<li><a
										href="displayAfterTime?pageNum=${afterActivity.nextPageNum }">下一页</a></li>
									<li><a
										href="displayAfterTime?pageNum=${afterActivity.totalPageNum }">尾页</a></li>
								</ul>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 页尾 -->
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>