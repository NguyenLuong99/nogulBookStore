<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>
<link rel="stylesheet"
	href="<c:url value='/template/web/css/gio-hang.css'/>" />

</head>
<body>
	<section class="content my-3">
		<div class="row" style="width: 100%">
			<c:set var="salary" scope="session"
				value="${sessionScope.countProduct}" />
			<c:if test="${salary == 0||salary==null}">
				<div class="col-12 cart-empty">
					<div class="py-3 pl-3">
						<h6 class="header-gio-hang">
							GIỎ HÀNG CỦA BẠN <span>(0 sản phẩm)</span>
						</h6>
						<div
							class="cart-empty-content w-100 text-center justify-content-center">
							<img
								src='<c:url value="/template/web/images/shopping-cart-not-product.png"/>'
								alt="shopping-cart-not-product">
							<p>Chưa có sản phẩm nào trong giở hàng của bạn</p>
							<a href="/faq" class="btn nutmuathem mb-3">Mua ngay</a>
						</div>
					</div>
				</div>
			</c:if>

			<!-- giao diện giỏ hàng khi không có item  -->


			<!-- giao diện giỏ hàng khi có hàng (phần comment màu xanh bên dưới là phần 2 sản phẩm trong giỏ hàng nhưng giờ đã demo bằng jquery) -->
			<c:if test="${salary > 0}">
				<div class="container">
					<div class="row " style="width: 100%">
						<div class="col-lg-9 table-responsive ">
							<table
								class="table table-light table-borderless table-hover text-center mb-0">
								<thead class="thead-dark">
									<tr>
										<th>Sản phẩm</th>
										<th>Giá</th>
										<th>Số lượng</th>
										<th>Tổng</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody class="align-middle">

									<c:forEach var="item" items="${cart.items}">
										<form action="/cart/update/${item.id}" method="post">
											<input type="hidden" name="id" value="${item.id}">
											<tr>
												<td class="align-middle">
													<div class="row">
														<img src="/template/web/images/${item.image}" alt=""
															style="width: 80px;height:80px;"><br> <a
															href="/detail-book/${item.id}">${item.name}</a>
													</div>
												</td>
												<td class="align-middle"><fmt:formatNumbertype
														="number" pattern="###,###,###" value="${item.price}" />
													${item.price}VNĐ</td>
												<td class="align-middle">

													<div class="input-group quantity mx-auto"
														style="width: 100px;">
														<div class="input-group-btn">
															<button class="btn btn-sm btn-primary btn-dec">
																<i class="fa fa-minus"></i>
															</button>
														</div>
														<input type="text" name="quality"
															class="form-control form-control-sm bg-secondary border-0 text-center"
															value="${item.quality}">
														<div class="input-group-btn">
															<button class="btn btn-sm btn-primary btn-inc">
																<i class="fa fa-plus"></i>
															</button>
														</div>
													</div>
												</td>
												<td class="align-middle"><fmt:formatNumber
														type="number" pattern="###,###,###"
														value="${item.price * item.quality}" /> ${item.price * item.quality}VNĐ</td>
												<td class="align-middle"><a
													href="/cart/remove/${item.id}"
													class="btn btn-sm btn-danger"> <i class="fa fa-times"></i>
												</a></td>
											</tr>
										</form>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="col-lg-3">
							<form class="" action="">
								<div class="input-group">
									<input type="text" class="form-control border-0 p-4"
										placeholder="Mã Giảm Giá">
									<div class="input-group-append">
										<button class="btn btn-primary mb-2">Áp Dụng</button>
									</div>
								</div>
							</form>
							<h5 class="section-title position-relative text-uppercase mb-3">
								<span class="bg-secondary pr-3 mt-2">Hóa đơn</span>
							</h5>
							<div class="bg-light p-30 mb-5">
								<div class="border-bottom pb-2">
									<div class="d-flex justify-content-between mb-3">
										<h6>Tạm tính</h6>
										<h6>
											<fmt:formatNumber type="number" pattern="###,###,###"
												value="${total}" />${total}
											VNĐ
										</h6>
									</div>
									<!-- 						<div class="d-flex justify-content-between mb-3">
							<h6 class="font-weight-medium">Tiền ship</h6>
							<h6 class="font-weight-medium">30.000 VNĐ</h6>
						</div> -->
									<div class="d-flex justify-content-between">
										<h6 class="font-weight-medium">Giảm giá</h6>
										<h6 class="font-weight-medium">0 VNĐ</h6>
									</div>
								</div>
								<div class="pt-2">
									<div class="d-flex justify-content-between mt-2">
										<h5>Tổng cộng</h5>
										<h5>
											<fmt:formatNumber type="number" pattern="###,###,###"
												value="${total}" />${total}
											VNĐ
										</h5>
									</div>
									<a href="/check-out"
										class="btn btn-block btn-primary font-weight-bold my-3 py-3">Tiến
										Hành Đặt Hàng</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>

		</div>
		<!-- het row  -->

	</section>
	<script type="text/javascript">
		
	</script>
</body>
</html>