<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>组织者页面_活动列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="css/organization_activitylist.css">
<link rel="stylesheet" type="text/css" href="css/header_footer.css" />
</head>
<body>
	<%@include file="organization_header.jsp"%>
	<table name="table2-1" cellpadding="0" cellspacing="0">
		<!-- 首页活动列表 -->
		<tr>
			<td class="table2-1tr0td0">
				<table class="table2-2">
					<tr>
						<!-- 首页/活动列表 -->
						<td><a href="organization_index.jsp" class="table2-2-tr0td0-a0">首页 </a>/ <a
							href="#" class="table2-2-tr0td0-a1"> 活动列表</a></td>
					</tr>
					<tr>
						<!-- 活动列表 -->
						<td class="table2-2-tr1td0">活动列表</td>
						<!-- 搜索框 -->
						<td>
							<form>
								<input type="text" class="table2-2-tr1td1-input"
									placeholder="请输入要搜索的活动/组织"> <span
									class="table2-2-tr1td1-span"> <input type="button"
									class="table2-2-tr1td1-span-button" style='font-size: 18px'
									value='搜索' /> <!-- <button class="table2-2-tr1td1-span-button">搜索</button> -->
								</span>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 按创建时间/按报名热度 -->
		<tr>
			<td class="table2-1tr1td0">
				<div class="table2-1tr1td0-div">
					<table class="table2-3" cellpadding="0" cellspacing="0"
						align="left">
						<tr>
							<td><a href="listByTime">按报名时间</a></td>
							<td><a href="listByHot">按报名热度</a></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
		<!-- 德艺双馨志愿活动 -->
		<tr>
			<td class="table2-1tr2td0">
				<table class="table2-4" cellpadding="0" cellspacing="0">
					<!-- “德艺双馨”志愿活动1 -->
					<c:if test="${key eq '1' }">
						<c:forEach items="${pageByTime.list }" var="byTime">
							<tr>
								<td class="table2-4-tr0td0">
									<div class="table2-4-tr0td0-div">
										<table cellspacing="0" cellpadding="0" class="table2-5"
											width="1020px">
											<table width="1020px" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr0td0" style="width: 22%"><a
														href="跳转到详情页">${byTime.name }</a></td>
													<td class="table2-5-tr0td1"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr1td0" style="width: 8%">${byTime.searchType }</td>
													<td class="table2-5-tr1td1" style="width: 1%"></td>
													<td class="table2-5-tr1td2" style="width: 18%">${byTime.organization.name }</td>
													<td class="table2-5-tr1td3" style="width: 1%"></td>
													<td class="table2-5-tr1td4" style="width: 5%">${byTime.level }</td>
													<td class="table2-5-tr1td5"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr2td0" style="width: 100%"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr3td0">
														${byTime.description }
													</td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr4td0" colspan="102"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr5td0" colspan="3" style="width: 3%"><a
														href="跳转到个人中心"><img src="images/05.png"></a></td>
													<td class="table2-5-tr5td1" style="width: 1%"></td>
													<td class="table2-5-tr5td2" style="width: 20%">${byTime.organization.name }承办</td>
													<td class="table2-5-tr5td3"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr6td0" style="width: 2%"><img
														src="images/06.png" width="20" height="20"></td>
													<td class="table2-5-tr6td1" style="width: 6%">156</td>
													<td class="table2-5-tr6td2" style="width: 2%"><img
														src="images/07.png" width="20" height="20"></td>
													<td class="table2-5-tr6td3" style="width: 6%">156</td>
													<td class="table2-5-tr6td4"></td>
													<td class="table2-5-tr6td5" style="width: 22%">举办时间：${byTime.holdBegin }</td>
												</tr>
											</table>
											<tr>
												<td></td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</c:forEach>
						<div class="bottom_page">
							<div class="page">
								<ul class="pagination">
									<li><a href="listByTime?pageNum=1">首页</a></li>
									<li><a
										href="listByTime?pageNum=${pageByTime.prePageNum }">上一页</a></li>
									<li><a href="#" class="currentPage active">${pageByTime.currentPageNum }/${pageByTime.totalPageNum }</a></li>
									<li><a
										href="listByTime?pageNum=${pageByTime.nextPageNum }">下一页</a></li>
									<li><a
										href="listByTime?pageNum=${pageByTime.totalPageNum }">尾页</a></li>
								</ul>
							</div>
						</div>
					</c:if>
					<c:if test="${key eq '2' }">
						<c:forEach items="${pageByHot.list }" var="byHot">
							<tr>
								<td class="table2-4-tr0td0">
									<div class="table2-4-tr0td0-div">
										<table cellspacing="0" cellpadding="0" class="table2-5"
											width="1020px">
											<table width="1020px" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr0td0" style="width: 22%"><a
														href="跳转到详情页">${byHot.name }</a></td>
													<td class="table2-5-tr0td1"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr1td0" style="width: 8%">${byHot.searchType }</td>
													<td class="table2-5-tr1td1" style="width: 1%"></td>
													<td class="table2-5-tr1td2" style="width: 18%">${byHot.organization.name }</td>
													<td class="table2-5-tr1td3" style="width: 1%"></td>
													<td class="table2-5-tr1td4" style="width: 5%">${byHot.level }</td>
													<td class="table2-5-tr1td5"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr2td0" style="width: 100%"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr3td0">
														${byHot.description }
													</td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr4td0" colspan="102"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr5td0" colspan="3" style="width: 3%"><a
														href="跳转到个人中心"><img src="images/05.png"></a></td>
													<td class="table2-5-tr5td1" style="width: 1%"></td>
													<td class="table2-5-tr5td2" style="width: 20%">${byHot.organization.name }承办</td>
													<td class="table2-5-tr5td3"></td>
												</tr>
											</table>
											<table width="1020" cellspacing="0" cellpadding="0">
												<tr>
													<td class="table2-5-tr6td0" style="width: 2%"><img
														src="images/06.png" width="20" height="20"></td>
													<td class="table2-5-tr6td1" style="width: 6%">156</td>
													<td class="table2-5-tr6td2" style="width: 2%"><img
														src="images/07.png" width="20" height="20"></td>
													<td class="table2-5-tr6td3" style="width: 6%">156</td>
													<td class="table2-5-tr6td4"></td>
													<td class="table2-5-tr6td5" style="width: 22%">举办时间：${byHot.holdBegin }</td>
												</tr>
											</table>
											<tr>
												<td></td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</c:forEach>
						<div class="bottom_page">
							<div class="page">
								<ul class="pagination">
									<li><a href="listByHot?pageNum=1">首页</a></li>
									<li><a
										href="listByHot?pageNum=${pageByHot.prePageNum }">上一页</a></li>
									<li><a href="#" class="currentPage active">${pageByHot.currentPageNum }/${pageByHot.totalPageNum }</a></li>
									<li><a
										href="listByHot?pageNum=${pageByHot.nextPageNum }">下一页</a></li>
									<li><a
										href="listByHot?pageNum=${pageByHot.totalPageNum }">尾页</a></li>
								</ul>
							</div>
						</div>
					</c:if>
				</table>
			</td>
		</tr>
	</table>
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>