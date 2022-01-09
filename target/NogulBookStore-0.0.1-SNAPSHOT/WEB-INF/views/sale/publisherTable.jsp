<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Admin - Publisher Table</title>
</head>
<body >

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Danh Sách Nhà Xuất Bản</h1>
					<!-- <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Bảng danh sách</h6>
						</div>
						<div class="card-body">

							<div class="row">
								<div class="col-lg-8 ">
									<a href="/sale/publisherForm/form" class="btn btn-primary"> <i
										class="fas fa-plus-square"></i> Thêm mới
									</a> 
								</div>
								<div class="col-lg-4 mb-3">
									<form action="/sale/publisherTable/list" method="post">
										<div class="input-group">
											<input type="text" name="keyword"
												value="${sessionScope.keyword}" class="form-control"
												placeholder="Tìm theo tên">
											<div class="input-group-append">
												<button class="btn btn-outline-secondary bg-info text-white">
													<i class="fas fa-search"></i>
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							<table class="table table-bordered" width="100%" cellspacing="0">
								<thead>
									<tr>
										<th>Họ tên</th>
										<th>Ảnh đại diện</th>
										<th>Mô tả</th>
										<th>Số tác phẩm</th>
										<th></th>
									</tr>
								</thead>
								<tfoot>
									<tr>
									<th>Họ tên</th>
										<th>Ảnh đại diện</th>
										<th>Mô tả</th>
										<th>Số tác phẩm</th>
										<th></th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="item" items="${publisherItem.content}">
										<tr>
											<td>${item.name}</td>
											<td class="text-center"><img width="100" height="100"
												src="/template/sale/img/${item.createdBy}"></td>
											<td>${item.des}</td>
											<td>${item.location}</td>
											<td>
												<a href="/sale/publisherTable/list/load/${item.id}" class="btn btn-success">Sửa</a> 
												<button type="button" class="btn btn-danger"
													data-toggle="modal" data-target="#exampleModal${item.id}">Xóa</button>
<%-- 												<a href="/admin/userForm/edit/employee/${item.id}" class="btn btn-info">Nhân viên</a>
 --%>											</td>
										</tr>
										<!-- Modal -->
										<div class="modal fade" id="exampleModal${item.id}"
											tabindex="-1" aria-labelledby="exampleModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Thông
															Báo!</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="modal-body">Xóa nhé</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Đóng</button>
														<a href="/sale/publisherTable/list/delete/${item.id}"
															class="btn btn-danger">Xóa</a>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</tbody>
							</table>
							<nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center">
									<li class="page-item ${(publisherItem.number==0)?'disabled':''}"><a
										class="page-link"
										href="/sale/publisherTable/list?p=${publisherItem.number-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="page-item disabled"><a class="page-link"
										href="#">${publisherItem.number+1}</a></li>
									<li
										class="page-item ${(publisherItem.number>=publisherItem.totalPages-1)?'disabled':''}"><a
										class="page-link"
										href="/sale/publisherTable/list?p=${publisherItem.number+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>

					</div>


			
</body>

</html>