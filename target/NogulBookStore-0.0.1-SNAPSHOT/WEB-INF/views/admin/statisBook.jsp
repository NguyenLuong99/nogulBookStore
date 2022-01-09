<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê sách</title>
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
					<div class="col-sm-12">
						<div class="widget-box transparent" id="recent-box">
							<div class="widget-header">
								<h4 class="widget-title lighter smaller">
									<i class="ace-icon fa fa-rss orange"></i>THỐNG KÊ SẢN PHẨM
								</h4>

								<div class="widget-toolbar no-border">
									<ul class="nav nav-tabs" id="recent-tab">
										<li class="active"><a data-toggle="tab" href="#task-tab">Theo
												Ngày</a></li>

										<li><a href="/admin/statisBookMonth">Theo Tháng</a></li>

										<li><a href="/admin/statisBookYear">Theo Năm</a></li>
									</ul>
								</div>
							</div>

							<div class="widget-body">
								<div class="widget-main padding-4">
									<div class="tab-content padding-8">
										<div id="task-tab" class="tab-pane active">
											<div class="row">
												<div class="col-xs-12">
													<h3 class="header smaller lighter blue">Thống kê sản
														phẩm theo ngày</h3>
													<div class="table-header"></div>
													<form class="form-search">
														<div class="row">
															<div class="col-xs-12 col-sm-8">
																<form action="/admin/statisBook" method="post">
																	<div class="input-group">
																		<span class="input-group-addon"> <i
																			class="ace-icon fa fa-check"></i>
																		</span> <input type="date" value="${sessionScope.keyword}"
																			name="keyword" class="form-control search-query"
																			placeholder="Type your query" /> <span
																			class="input-group-btn">
																			<button type="submit" class="btn btn-purple btn-sm">
																				<span
																					class="ace-icon fa fa-search icon-on-right bigger-110"></span>
																				Search
																			</button>
																		</span>
																	</div>
																</form>
															</div>
														</div>
													</form>
													</br>
													<!-- div.table-responsive -->

													<!-- div.dataTables_borderWrap -->
													<div>
														<table id="dynamic-table"
															class="table table-striped table-bordered table-hover">
															<thead>
																<tr>
																	<th>Số TT</th>
																	<th>Tên Sách</th>
																	<th>Tác giả</th>
																	<th class="hidden-480">Số lượng bán</th>
																	<th>Ngày bán</th>

																	<th><i
																		class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
																		Còn lại</th>
																	<th class="hidden-480">Status</th>

																	<th></th>
																</tr>
															</thead>

															<tbody>
																<c:forEach var="item" items="${statisDayItem.content}">
																	<tr>
																		<td class="center">${locationDay=locationDay+1}</td>

																		<td>${item.group.name}</td>
																		<td class="text-center">${item.group.author.name}</td>
																		<td class="hidden-480">${item.count}</td>
																		<td>${item.date}</td>
																		<td>${item.group.quality }</td>
			
																		<td class="hidden-480"><span
																			class="label label-sm label-warning">${item.group.quality>0?'Còn hàng':'Hết hàng'}</span></td>

																		<td>
																			<div class="hidden-sm hidden-xs action-buttons">
																				<a class="blue" href="#"> <i
																					class="ace-icon fa fa-search-plus bigger-130"></i>
																				</a> <a class="green" href="#"> <i
																					class="ace-icon fa fa-pencil bigger-130"></i>
																				</a> <a class="red" href="#"> <i
																					class="ace-icon fa fa-trash-o bigger-130"></i>
																				</a>
																			</div>

																			<div class="hidden-md hidden-lg">
																				<div class="inline pos-rel">
																					<button
																						class="btn btn-minier btn-yellow dropdown-toggle"
																						data-toggle="dropdown" data-position="auto">
																						<i
																							class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
																					</button>

																					<ul
																						class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																						<li><a href="#" class="tooltip-info"
																							data-rel="tooltip" title="View"> <span
																								class="blue"> <i
																									class="ace-icon fa fa-search-plus bigger-120"></i>
																							</span>
																						</a></li>

																						<li><a href="#" class="tooltip-success"
																							data-rel="tooltip" title="Edit"> <span
																								class="green"> <i
																									class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																							</span>
																						</a></li>

																						<li><a href="#" class="tooltip-error"
																							data-rel="tooltip" title="Delete"> <span
																								class="red"> <i
																									class="ace-icon fa fa-trash-o bigger-120"></i>
																							</span>
																						</a></li>
																					</ul>
																				</div>
																			</div>
																		</td>
																	<div style="display:none;">${total=total+item.count}</div>
																	</tr>
																</c:forEach>
																<tr>
																		<td class="center">Tổng</td>

																		<td></td>
																		<td class="text-center"></td>
																		<td class="hidden-480">${total}</td>
																		<td></td>
																		<td></td>
			
																		<td class="hidden-480">
																			
																		<td>
																</tr>
															</tbody>
														</table>
													</div>
													<div class="modal-footer no-margin-top center">

														<nav aria-label="Page navigation example">
														<ul class="pagination justify-content-center">
															<li
																class="page-item ${(statisDayItem.number==0)?'disabled':''}"><a
																class="page-link"
																href="/admin/statisBook?p=${statisDayItem.number-1}"
																aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
															</a></li>
															<li class="page-item disabled"><a class="page-link"
																href="#">${statisDayItem.number+1}</a></li>
															<li
																class="page-item ${(statisDayItem.number>=statisDayItem.totalPages-1)?'disabled':''}"><a
																class="page-link"
																href="/admin/statisBook?p=${statisDayItem.number+1}"
																aria-label="Next"> <span aria-hidden="true">&raquo;</span>
															</a></li>
														</ul>
														</nav>
													</div>
												</div>
											</div>

										</div>
										<!-- Tháng -->
										<div id="member-tab" class="tab-pane"></div>
										<!-- /.#member-tab -->

										<div id="comment-tab" class="tab-pane"></div>
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


			</div>
		</div>
	</div>
	</body>
	</html>
	<!-- /.main-content -->