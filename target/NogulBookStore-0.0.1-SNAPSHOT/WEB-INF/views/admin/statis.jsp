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
										<li class="active"><a  href="/admin/statis">Theo
												Ngày</a></li>

										<li><a  href="/admin/statisMonth">Theo
												Tháng</a></li>

										<li><a  href="/admin/statisYear">Theo Năm</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="widget-body">
								<div class="widget-main padding-4">
									<div class="tab-content padding-8">
										<div id="task-tab" class="tab-pane active">
											<div class="row">
												<div class="col-xs-12">
													<h3 class="header smaller lighter blue">Thống kê doanh
														thu theo ngày</h3>
													<div class="table-header"></div>
													<form class="form-search">
														<div class="row">
															<div class="col-xs-12 col-sm-8">
																<form action="/admin/statis" method="post">
																	<div class="input-group">
																		<span class="input-group-addon"> <i
																			class="ace-icon fa fa-check"></i></span>																		
																		<div class="col-xs-12 col-sm-9">
																		<span>	
																		<span class=""> Tháng</span>
																				<select placeholder="Tháng" name="month">
																				<option value="${sessionScope.monthSearch }">${sessionScope.monthSearch }</option>
																				<option value="1">Tháng 1</option>
																				<option value="2">Tháng 2</option>
																				<option value="3">Tháng 3</option>
																				<option value="4">Tháng 4</option>
																				<option value="5">Tháng 5</option>
																				<option value="6">Tháng 6</option>
																				<option value="7">Tháng 7</option>
																				<option value="8">Tháng 8</option>
																				<option value="9">Tháng 9</option>
																				<option value="10">Tháng 10</option>
																				<option value="11">Tháng 11</option>
																				<option value="12">Tháng 12</option>
																			</select></span>
																			<span class=""> Năm</span>
																			<span>	<select placeholder="Năm" name="year">
																				<option value="${sessionScope.year }">${sessionScope.year }</option>
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
												
														<canvas id="buyers" width="1116" height="400"></canvas>
													</div>

												</div>
											</div>

										</div>
										<!-- Tháng -->
										<div id="member-tab" class="tab-pane">
											
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
			</div>
		</div>
	</div>
	<!-- /.main-content -->

	<script type="text/javascript">
		// line chart data
		let days =[];
		if(${type}==0){
			for(let i=1;i<=31;i++){
				if(i<10){
					days.push(${year}+"-"+${sessionScope.month}+"-0"+i);
				}
				else days.push(${year}+"-"+${sessionScope.month}+"-"+i);
			}
		}else if(${type}==1){
			for(let i=1;i<=28;i++){
				if(i<10){
					days.push(${year}+"-"+${sessionScope.month}+"-0"+i);
				}
				else days.push(${year}+"-"+${sessionScope.month}+"-"+i);
			}
		}else if(${type}==2){
			for(let i=1;i<=29;i++){
				if(i<10){
					days.push(${year}+"-"+${sessionScope.month}+"-0"+i);
				}
				else days.push(${year}+"-"+${sessionScope.month}+"-"+i);
			}
		}else{
			for(let i=1;i<=30;i++){
				if(i<10){
					days.push(${year}+"-"+${sessionScope.month}+"-0"+i);
				}
				else days.push(${year}+"-"+${sessionScope.month}+"-"+i);
			}
		}
		var buyerData = {
			labels :days,
			datasets : [ {
				fillColor : "rgba(172,194,132,0.4)",
				strokeColor : "#ACC26D",
				pointColor : "#fff",
				pointStrokeColor : "#9DB86D",
				data : ${revenue} ,
			} ]
		}

		// get line chart canvas
		var buyers = document.getElementById('buyers').getContext('2d');

		// draw line chart
		new Chart(buyers).Line(buyerData);

		// pie chart data
		var pieData = [ {
			value : 20,
			color : "#878BB6"
		}, {
			value : 40,
			color : "#4ACAB4"
		}, {
			value : 10,
			color : "#FF8153"
		}, {
			value : 30,
			color : "#FFEA88"
		} ];

		// pie chart options
		var pieOptions = {
			segmentShowStroke : false,
			animateScale : true
		}

		// get pie chart canvas
		var countries = document.getElementById("countries").getContext("2d");

		// draw pie chart
		new Chart(countries).Pie(pieData, pieOptions);

		// bar chart data
		var barData = {
			labels : [ "January", "February", "March", "April", "May", "June" ],
			datasets : [ {
				fillColor : "#48A497",
				strokeColor : "#48A4D1",
				data : [ 456, 479, 324, 569, 702, 600 ]
			}, {
				fillColor : "rgba(73,188,170,0.4)",
				strokeColor : "rgba(72,174,209,0.4)",
				data : [ 364, 504, 605, 400, 345, 320 ]
			} ]
		}

		// get bar chart canvas
		var income = document.getElementById("income").getContext("2d");

		// draw bar chart
		new Chart(income).Bar(barData);
	</script>
</body>
</html>

