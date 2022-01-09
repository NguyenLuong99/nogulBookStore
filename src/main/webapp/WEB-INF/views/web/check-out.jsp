<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="<c:url value='/template/web/css/gio-hang.css'/>" />
</head>
<body>
<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="/index">Trang chủ</a> <span
						class="breadcrumb-item active">Thanh toán</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Checkout Start -->
	<form action="/shop/check-out" method="post"
		modelAttribute="addressForm">
		<div class="container-fluid">
			<div class="row px-xl-5">
				<div class="col-lg-8">
					<h5 class="section-title position-relative text-uppercase mb-3">
						<span class="bg-success pr-3">Địa Chỉ Giao Hàng</span>
					</h5>
					<div class="bg-light p-30 mb-5" >

						<div class="row">
							<div class="col-md-6 form-group">
								<label>Họ</label>
								<input name="firstname" cssClass="form-control"
								 placeholder="${addressForm.firstname}" value="${addressForm.firstname}" />
								<errors path="firstname" cssClass="invalid-feedback"></errors>
							</div>
							<div class="col-md-6 form-group">
								<label>Tên</label>
								<input name="lastname" cssClass="form-control"
									cssErrorClass="form-control is-invalid" placeholder="${addressForm.lastname} " value="${addressForm.lastname} " />
								<errors name="lastname" cssClass="invalid-feedback"></errors>
							</div>
							<div class="col-md-6 form-group">
								<label>E-mail</label>
								<input name="email" cssClass="form-control"
									cssErrorClass="form-control is-invalid"
									placeholder="${addressForm.email}" value="${addressForm.email}"/>
								<errors path="email" cssClass="invalid-feedback"></errors>
							</div>
							<div class="col-md-6 form-group">
								<label>Số điện thoại</label>
								<input name="phone" cssClass="form-control"
									cssErrorClass="form-control is-invalid"
									placeholder="${addressForm.phone}" value="${addressForm.phone}" />
								<errors path="phone" cssClass="invalid-feedback"></errors>
							</div>
							<div class="col-md-6 form-group">
								<label>Tỉnh </label>
								<input name="provincial" cssClass="form-control"
									cssErrorClass="form-control is-invalid"
									placeholder="${addressForm.provincial}" value="${addressForm.provincial}" />
								<errors path="provincial" cssClass="invalid-feedback"></errors>
							</div>
							<div class="col-md-6 form-group">
								<label>Địa chỉ</label>
								<input name="address" cssClass="form-control"
									cssErrorClass="form-control is-invalid"
									placeholder="${addressForm.address}" value="${addressForm.address}" />
								<errors path="address" cssClass="invalid-feedback"></errors>
							</div>
						</div>

					</div>
				</div>
				<div class="col-lg-4">
					<h5 class="section-title position-relative text-uppercase mb-3">
						<span class="bg-secondary pr-3">Hóa Đơn Chi Tiết</span>
					</h5>
					<div class="bg-light p-30 mb-5">
						<div class="border-bottom">
							<h6 class="mb-3">Sản Phẩm</h6>
							<c:forEach var="item" items="${cart.items}">
								<div class="d-flex justify-content-between">
									<p>${item.name} (${item.quality})</p>
									<p>
										<fmt:formatNumber type="number" pattern="###,###,###"
											value="${item.price}" />
										${item.price}VNĐ
									</p>
								</div>
							</c:forEach>
						</div>
						<div class="border-bottom pt-3 pb-2">
							<div class="d-flex justify-content-between mb-3">
								<h6>Tạm tính</h6>
								<h6>
									<fmt:formatNumber type="number" pattern="###,###,###"
										value="${total}" />
									${total}VNĐ
								</h6>
							</div>
							<div class="d-flex justify-content-between mb-3">
								<h6 class="font-weight-medium">Khuyến mãi</h6>
								<h6 class="font-weight-medium">0 VNĐ</h6>
							</div>
							<div class="d-flex justify-content-between">
								<h6 class="font-weight-medium">Phí Ship</h6>
								<h6 class="font-weight-medium">30.000 VNĐ</h6>
							</div>
						</div>
						<div class="pt-2">
							<div class="d-flex justify-content-between mt-2">
								<h5>Tổng</h5>
								<h5>
									<fmt:formatNumber type="number" pattern="###,###,###"
										value="${total+30000}" />
									${total+30000}VNĐ
								</h5>
							</div>
						</div>
					</div>
					<div class="mb-5">
						<h5 class="section-title position-relative text-uppercase mb-3">
							<span class="bg-secondary pr-3">Thanh toán</span>
						</h5>
						<div class="bg-light p-30">
							<div class="form-group">
								<div class="custom-control custom-radio">
									<!-- <input type="radio" class="custom-control-input" name="payment"
										id="directcheck" value="0"> -->
									<radiobutton path="payment" value="0"
										class="custom-control-input" id="directcheck"/>
									<label class="custom-control-label" for="directcheck">Tiền
										mặt</label>

								</div>
							</div>
							<div class="">
								<div class="custom-control custom-radio">
									<!-- <input type="radio" class="custom-control-input" name="payment"
										id="banktransfer" value="1" checked="checked"> -->
									<adiobutton path="payment" value="1"
										class="custom-control-input" id="banktransfer"/>
									<label class="custom-control-label" for="banktransfer">Chuyển
										khoản</label>
								</div>
							</div>
							<!-- <button type="submit" formaction="/shop/checkout"
							class="btn btn-block btn-primary font-weight-bold py-3"
							formmethod="post">Đặt Hàng</button> -->
							<button type="submit"
								class="btn btn-block btn-primary font-weight-bold py-3" formaction="/check-out">Đặt
								Hàng</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>