<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Sale- Xử lý hóa đơn</title>
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
									<a href="/sale/order/wait" class="btn btn-primary"> <i
										class="fas fa-step-backward"></i> Trở lại
									</a>
								</div>							
							</div>
							<table class="table table-bordered" width="100%" cellspacing="0">
								<thead>
									<tr>
										<th>STT</th>
										<th>Người đặt</th>
										<th>Người nhận</th>
										<th>Địa chỉ</th>
										<th>Tên sản phẩm</th>
										<th>Số lượng</th>
										<th>Giá</th>
										<th>PT Thanh toán</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>STT</th>
										<th>Người đặt</th>
										<th>Người nhận</th>
										<th>Địa chỉ</th>
										<th>Tên sản phẩm</th>
										<th>Số lượng</th>
										<th>Giá</th>
										<th>PT Thanh toán</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="item" items="${orderDetail}">
										<tr>
											<td>${location = location + 1}</td>
											<td>${address.email}</td>
											<td>${fullname.firstname} ${fullname.lastname}</td>
											<td>${address.address}</td>
											<td>${item.order.book.name}</td>
											<td>${item.order.quality}</td>
											<td><fmt:formatNumber type="number"
													pattern="###,###,###" value="${item.totalPrice/item.order.quality}" /></td>
											<td>${item.order.method?'Chuyển khoản':'Tiền mặt'}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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

</body>

</html>