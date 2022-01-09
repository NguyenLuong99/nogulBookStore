<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<link rel="shortcut icon"
	href="https://actappg1.misacdn.net/favicon.ico" type="image/x-icon">
<title><dec:title /></title>
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link rel="stylesheet"
	href="/template/sale/vendor/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="/template/sale/css/sb-admin-2.min.css">
<body>
	<div id="wrapper">

		<%@include file="/common/sale/slidebar.jsp"%>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<%@include file="/common/sale/navbar.jsp"%>
				<dec:body />
			</div>
			<!-- End of Main Content -->
			<%@include file="/common/sale/footer.jsp"%>
		</div>

	</div>
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
	<script src="/template/sale/vendor/jquery/jquery.min.js"></script>
	<script
		src="/template/sale/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/template/sale/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/template/sale/js/sb-admin-2.min.js"></script>
	<script src="/template/sale/js/sb-admin-2.js"></script>

	<!-- Page level plugins -->
	<script src="/template/sale/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/template/sale/js/demo/chart-area-demo.js"></script>
	<script src="/template/sale/js/demo/chart-pie-demo.js"></script>
</body>
</html>