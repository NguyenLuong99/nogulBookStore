<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách khách hàng</title>
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
					<div class="col-xs-12">
						<h3 class="header smaller lighter blue">Danh sách khách hàng</h3>

						<div class="clearfix">
							<div class="pull-right tableTools-container"></div>
						</div>
						<div class="table-header"></div>
						<form class="form-search">
							<div class="row">
								<div class="col-xs-12 col-sm-8">
								<form action="/admin/employeeTable/list" method="post">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="ace-icon fa fa-check"></i>
										</span> <input type="text" value="${sessionScope.keyword}" name="keyword" class="form-control search-query"
											placeholder="Type your query" /> <span
											class="input-group-btn">
											<button type="submit" class="btn btn-purple btn-sm">
												<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
												Search
											</button>
										</span>
									</div>
								</form>
								</div>
							</div>
						</form>
						</br> </br>
						<!-- div.table-responsive -->

						<!-- div.dataTables_borderWrap -->
						<div>
							<table id="dynamic-table"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"><label class="pos-rel"> <input
												type="checkbox" class="ace" /> <span class="lbl"></span>
										</label></th>
										<th>Tên Khách Hàng</th>
										<th>Hình ảnh</th>
										<th class="hidden-480">Số điện thoại</th>

										<th><i
											class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
											Mô tả </th>
										<th class="hidden-480">Status</th>

										<th></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="item" items="${userItem.content}">
									<tr>
										<td class="center"><label class="pos-rel"> <input
												type="checkbox" class="ace" /> <span class="lbl"></span>
										</label></td>

										<td><a href="#">${item.fullName.firstname} ${item.fullName.lastname}</a></td>
										<td class="text-center"><img width="100" height="100"
												src="/template/sale/img/${item.imgUser}"></td>
										<td class="hidden-480">${item.address.phone}</td>
										<td>${item.address.email}</td>

										<td class="hidden-480"><span
											class="label label-sm label-warning">${item.status==1?'Đang online':'Offline'}</span></td>

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
													<button class="btn btn-minier btn-yellow dropdown-toggle"
														data-toggle="dropdown" data-position="auto">
														<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
													</button>

													<ul
														class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
														<li><a href="#" class="tooltip-info"
															data-rel="tooltip" title="View"> <span class="blue">
																	<i class="ace-icon fa fa-search-plus bigger-120"></i>
															</span>
														</a></li>

														<li><a href="#" class="tooltip-success"
															data-rel="tooltip" title="Edit"> <span class="green">
																	<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
															</span>
														</a></li>

														<li><a href="#" class="tooltip-error"
															data-rel="tooltip" title="Delete"> <span class="red">
																	<i class="ace-icon fa fa-trash-o bigger-120"></i>
															</span>
														</a></li>
													</ul>
												</div>
											</div>
										</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="modal-footer no-margin-top center">

								<nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center">
									<li class="page-item ${(userItem.number==0)?'disabled':''}"><a
										class="page-link"
										href="/admin/customerTable/list?p=${userItem.number-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="page-item disabled"><a class="page-link"
										href="#">${userItem.number+1}</a></li>
									<li
										class="page-item ${(userItem.number>=userItem.totalPages-1)?'disabled':''}"><a
										class="page-link"
										href="/admin/customerTable/list?p=${userItem.number+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
</body>