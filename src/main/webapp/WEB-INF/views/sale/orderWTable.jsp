<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Admin - Order Wait Table</title>
</head>

<body id="page-top">
	<div id="wrapper">



		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">


				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Danh Sách Đơn Hàng Đang chờ</h1>
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
								<div class="col-lg-8 mb-3">
								
								</div>	
								<div class="col-lg-4 mb-3">
									<form action="/sale/order/wait" method="post">
										<div class="input-group">
											<input type="text" name="keyword11"
												value="${sessionScope.keyword11}" class="form-control"
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
										<th>STT</th>
										<th>Mã hàng</th>
										<th>Ngày đặt</th>
										<th>Giá</th>
										<th>Trạng thái</th>
										<th>Hoạt động</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>STT</th>
										<th>Mã hàng</th>
										<th>Ngày đặt</th>
										<th>Giá</th>
										<th>Trạng thái</th>
										<th>Hoạt động</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="item" items="${orderWait.content}">
										<tr>
											<td>${location = location + 1}</td>
											<td>${item.name}</td>
											<td>${item.date}</td>
											<td><fmt:formatNumber type="number"
													pattern="###,###,###" value="${item.price+30000}" /> VNĐ</td>
											<td>${item.status?'Đã giao':'Đang chờ'}</td>
											<td><a href="/sale/orderDetail/${item.name}"
												class="btn btn-primary">Chi tiết</a> <a
												href="/sale/order/wait/send/${item.name}"
												class="btn btn-success">Giao hàng</a></td>
										</tr>
										<!-- Modal -->
										<%-- <div class="modal fade" id="exampleModal${user.id}"
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
													<div class="modal-body">Tài khoản với email
														${user.email} sẽ bị xóa vĩnh viễn khỏi hệ thống. Bạn có
														muốn tiếp tục?</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Đóng</button>
														<a href="/admin/userTable/list/delete/${user.id}"
															class="btn btn-danger">Xóa</a>
													</div>
												</div>
											</div>
										</div> --%>
									</c:forEach>
								</tbody>
							</table>
							<nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center">
									<li class="page-item ${(orderWait.number==0)?'disabled':''}"><a
										class="page-link"
										href="/sale/order/wait?p=${orderWait.number-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="page-item disabled"><a class="page-link"
										href="#">${orderWait.number+1}</a></li>
									<li
										class="page-item ${(orderWait.number>=orderWait.totalPages-1)?'disabled':''}"><a
										class="page-link"
										href="/sale/order/wait?p=${orderWait.number+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>

					</div>

				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
	
		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Thông Báo!</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Vui lòng nhấn nút "Đăng xuất" bên dưới
					nếu bạn muốn đăng xuất tài khoản.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Thoát</button>
					<a class="btn btn-primary" href="/logout">Đăng xuất</a>
				</div>
			</div>
		</div>
	</div>

</body>

</html>