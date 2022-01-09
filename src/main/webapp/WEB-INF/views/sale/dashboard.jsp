<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Sale - DasgBoard</title>
</head>
<body id="page-top">
	<h1 class="h3 mb-2 text-gray-800 ml-2">DashBoard</h1>
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					</br> </br> </br>
					<div class="row">

						<div class="col-3" style="border: 2px solid #e3e6f0">
							<a href="/sale/authorTable/list">
								<div class="row mt-2">
									<div class="col-1"></div>
									<div class="col-10">
										<li class="nav-item giohang  ml-2 mt-2 mr-2 "
											style="list-style: none;">
											<div class="btn btn-secondary green rounded-circle ml-2"
												style="background: #6fb3e0;">
												<i class="ace-icon fa fa-user"></i>
											</div>
										</li>

										<div class="infobox-content ">
											Tác giả<span class="infobox-data-number ml-2">(${numberAuthor })</span>
										</div>
									</div>
									<div class="col-1"></div>

								</div>
							</a>
						</div>
						<div class="col-3" style="border: 2px solid #e3e6f0">
							<a href="/sale/bookTable/list">
								<div class="row mt-2">
									<div class="col-1"></div>
									<div class="col-10">
										<li class="nav-item giohang  ml-2 mt-2 mr-2 "
											style="list-style: none;">
											<div class="btn btn-secondary green rounded-circle ml-2"
												style="background: #9abc32;">
												<i class="ace-icon fa fa-book"></i>
											</div>
										</li>

										<div class="infobox-content ">
											Sách<span class="infobox-data-number ml-2">(${numberBook })</span>
										</div>
									</div>
									<div class="col-1"></div>

								</div>
							</a>
						</div>
						<div class="col-3" style="border: 2px solid #e3e6f0">
							<a href="/sale/publisherTable/list">
								<div class="row mt-2">
									<div class="col-1"></div>
									<div class="col-10">
										<li class="nav-item giohang  ml-2 mt-2 mr-2 "
											style="list-style: none;">
											<div class="btn btn-secondary green rounded-circle ml-2"
												style="background: #6fb3e0;">
												<i class="ace-icon fa fa-upload"></i>
											</div>
										</li>

										<div class="infobox-content ">
											Nhà Xuất bản<span class="infobox-data-number ml-2">(${numberPublisher })</span>
										</div>
									</div>
									<div class="col-1"></div>

								</div>
							</a>
						</div>
						<div class="col-3" style="border: 2px solid #e3e6f0">
							<a href="/sale/categoryTable/list">
								<div class="row mt-2">
									<div class="col-1"></div>
									<div class="col-10">
										<li class="nav-item giohang  ml-2 mt-2 mr-2 "
											style="list-style: none;">
											<div class="btn btn-secondary green rounded-circle ml-2"
												style="background: #FEE074;">
												<i class="ace-icon fa fa-caret-square-right"></i>
											</div>
										</li>

										<div class="infobox-content ">
											Danh Mục<span class="infobox-data-number ml-2">(${numberCategory })</span>
										</div>
									</div>
									<div class="col-1"></div>

								</div>
							</a>
						</div>
					</div>
					</br> </br>
					<div class="row">
						<div class="col-3" style="border: 2px solid #e3e6f0">
							<a href="/sale/order/send">
								<div class="row mt-2">
									<div class="col-1"></div>
									<div class="col-10">
										<li class="nav-item giohang  ml-2 mt-2 mr-2 "
											style="list-style: none;">
											<div class="btn btn-secondary green rounded-circle ml-2"
												style="background: #cb6fd7;">
												<i class="ace-icon fa fa-shopping-cart"></i>
											</div>
										</li>

										<div class="infobox-content ">
											Đơn hàng đã bán<span class="infobox-data-number ml-2">(${numberOrdered })</span>
										</div>
									</div>
									<div class="col-1"></div>

								</div>
							</a>
						</div>
						<div class="col-3" style="border: 2px solid #e3e6f0">
							<a href="/sale/order/wait">
								<div class="row mt-2">
									<div class="col-1"></div>
									<div class="col-10">
										<li class="nav-item giohang  ml-2 mt-2 mr-2 "
											style="list-style: none;">
											<div class="btn btn-secondary green rounded-circle ml-2"
												style="background: #c1c11;">
												<i class="ace-icon fa fa-shopping-cart"></i>
											</div>
										</li>

										<div class="infobox-content ">
											Đơn hàng mới<span class="infobox-data-number ml-2">(${numberOrder })</span>
										</div>
									</div>
									<div class="col-1"></div>

								</div>
							</a>
						</div>
						<div class="col-3" style="border: 2px solid #e3e6f0">
							<a href="/sale/feedBackTable/list">
								<div class="row mt-2">
									<div class="col-1"></div>
									<div class="col-10">
										<li class="nav-item giohang  ml-2 mt-2 mr-2 "
											style="list-style: none;">
											<div class="btn btn-secondary green rounded-circle ml-2"
												style="background: #2fb3e0;">
												<i class="ace-icon fa fa-comments"></i>
											</div>
										</li>

										<div class="infobox-content ">
											Bình luận<span class="infobox-data-number ml-2">(${numberFeedBack })</span>
										</div>
									</div>
									<div class="col-1"></div>

								</div>
						</div>
						<div class="col-3" style="border: 2px solid #e3e6f0">
							<a href="/sale/statis/favorite">
								<div class="row mt-2">
									<div class="col-1"></div>
									<div class="col-10">
										<li class="nav-item giohang  ml-2 mt-2 mr-2 "
											style="list-style: none;">
											<div class="btn btn-secondary green rounded-circle ml-2"
												style="background: red;">
												<i class="ace-icon fa fa-heart"></i>
											</div>
										</li>

										<div class="infobox-content ">
											Yêu thích<span class="infobox-data-number ml-2">(${numberAuthor })</span>
										</div>
									</div>
									<div class="col-1"></div>

								</div>
							</a>
						</div>
					</div>
				</div>
				<div class="col-2"></div>
			</div>
			</br> </br> </br> </br> </br> </br> </br> </br> </br>
		</div>
	</div>
	<div class="container"></div>
</body>

</html>