<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê sách</title>
<script src="<c:url value='/template/admin/js/Chart.min.js' />"></script>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-sm-10">
						<div class="widget-box transparent" id="recent-box">
							<div class="widget-header">
								<h4 class="widget-title lighter smaller">
									<i class="ace-icon fa fa-rss orange"></i>THỐNG KÊ DOANH THU
								</h4>

								<div class="widget-toolbar no-border">
									<ul class="nav nav-tabs" id="recent-tab">
										<li ><a href="/admin/statis">Theo
												Ngày</a></li>

										<li class="active"><a  href="/admin/statisMonth">Theo
												Tháng</a></li>

										<li><a  href="/admin/statisYear">Theo Năm</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="widget-body">
								<div class="widget-main padding-4">
									<div class="tab-content padding-8">
										<div id="task-tab" class="tab-pane">
											
										</div>
										<!-- Tháng -->
										<div id="member-tab" class="tab-pane active">
										<div class="row">
												<div class="col-xs-12">
													<h3 class="header smaller lighter blue">Thống kê doanh
														thu theo tháng</h3>
													<div class="table-header"></div>
													<form class="form-search">
														<div class="row">
															<div class="col-xs-12 col-sm-8">
																<form action="/admin/statisMonth" method="post">
																	<div class="input-group">
																		<span class="input-group-addon"> <i
																			class="ace-icon fa fa-check"></i></span>																		
																		<div class="col-xs-12 col-sm-9">
																		
																			<span class=""> Năm</span>
																			<span>	<select placeholder="Năm" name="year">
																				<option value="${sessionScope.year }">${sessionScope.year}</option>
																				<option value="2021">2021</option>
																				<option value="2022">2022</option>
																			</select></span><span>
																				<button type="submit" class="btn btn-purple btn-sm">
																					<span
																						class="ace-icon fa fa-search icon-on-right bigger-110"></span>
																					Search
																				</button>
																			</span>
																		</div></div>
																</form>
															</div>
														</div>
													</form>
													</br>
													<!-- div.table-responsive -->

													<!-- div.dataTables_borderWrap -->
													<div>
														<canvas id="income" width="1080" height="400"></canvas>
													</div>

												</div>
											</div>
										
										</div>
										<!-- /.#member-tab -->

										<div id="comment-tab" class="tab-pane">

											
										</div>
									</div>
								</div>
								<!-- /.widget-main -->
							</div>
							<!-- /.widget-body -->
						</div>
						<!-- /.widget-box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
				<!-- pie chart canvas element -->
				<!-- 			<canvas id="countries" width="600" height="400"></canvas>
		
				<canvas id="income" width="600" height="400"></canvas>


				<div class="footer-bar">
					<span class="article-wrapper"> <span class="article-label">Xem
							Bài Viết: </span> <span class="article-link"><a
							href="https://www.thuthuatweb.net/javacript/de-dang-tao-bieu-do-tren-web-voi-chart-js.html">Dễ
								dàng tạo biểu đồ trên web với Chart.js</a></span>
					</span>

				</div>-->


			</div>
		</div>
	</div>
	<!-- /.main-content -->

	<script type="text/javascript">
		// line chart data

		// bar chart data
		var barData = {
				labels : [ "January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November",
					"December" ],
				datasets : [ {
					fillColor : "#48A497",
					strokeColor : "#48A4D1",
					data : ${revenueMonth}
				},]
		}

		// get bar chart canvas
		var income = document.getElementById("income").getContext("2d");

		// draw bar chart
		new Chart(income).Bar(barData);
	</script>
</body>
</html>
