<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Address</title>

    <link rel="stylesheet" href="<c:url value='/template/web/css/tai-khoan.css'/>"/>
</head>
<body>
  <section class="account-page my-3">
        <div class="container">
            <div class="page-content bg-white">
                <div class="account-page-tab-content m-4">
                    <!-- 2 tab: thông tin tài khoản, danh sách đơn hàng  -->
                    <nav>
                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                          <a class="nav-item nav-link " id="nav-taikhoan-tab" href="/my-profile" role="tab" aria-controls="nav-home" aria-selected="false">Thông tin tài khoản</a>
                          <a class="nav-item nav-link" id="nav-donhang-tab"  href="/my-order" role="tab" aria-controls="nav-profile" aria-selected="false">Danh sách đơn hàng</a>
                          <a class="nav-item nav-link active" id="nav-yeuthich-tab"  href="/my-favorites" role="tab" aria-controls="nav-profile" aria-selected="true">Yêu Thích</a>
                          <a class="nav-item nav-link " id="nav-diachi-tab" href="/my-address" role="tab" aria-controls="nav-home" aria-selected="false">Địa chỉ nhận hàng</a>
                        </div>
                    </nav>

                    <!-- nội dung 2 tab -->
                    <div class="tab-content">

                        <!-- nội dung tab 1: thông tin tài khoản  -->
                        <div class="tab-pane fade show  pl-4 " id="nav-taikhoan" role="tabpanel" aria-labelledby="nav-taikhoan-tab">
                          
                        </div>

                        <!-- nội dung tab 2: danh sách đơn hàng -->
                        <div class="tab-pane fade py-3" id="nav-donhang" role="tabpanel" aria-labelledby="nav-donhang-tab">
                            
                        </div>
                        <div class="tab-pane fade active show py-3" id="nav-yeuthich" role="tabpanel" aria-labelledby="nav-yeuthich-tab">
                            <div class="donhang-table">
                                <table class="m-auto">
                                    <tr>
                                        <th>STT</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Ngày thích</th>
                                        <th>Giá</th>
                                        <th>Trạng thái </th>
                                    </tr>
                                    <tr>
                                       	<c:forEach var="item" items="${favorite.content}">
											<tr>
												<td>${location = location + 1}</td>
												<td>${item.book.name}</td>
												<td>${item.date}</td>
												<td>
														${item.book.salePrice}
													VNĐ</td>
												<td><a href="/detail-book/${item.book.id}"
													class="btn btn-success ">Xem</a> <a
													href="/shop/favorite/delete/${item.id}" class="btn btn-danger">Xóa</a></td>
											</tr>
										</c:forEach>
                                    </tr>
                               
                                </table></br></br>
                                     	<nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center">
									<li class="page-item ${(favorite.number==0)?'disabled':''}"><a
										class="page-link"
										href="/my-favorite?p=${favorite.number-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="page-item disabled"><a class="page-link"
										href="#">${favorite.number+1}</a></li>
									<li
										class="page-item ${(favorite.number>=favorite.totalPages-1)?'disabled':''}"><a
										class="page-link"
										href="/my-favorite?p=${favorite.number+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
                            </div>
                        </div>
                        <div class="tab-pane fade show pl-4 " id="nav-diachi" role="tabpanel" aria-labelledby="nav-diachi-tab">
                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    <!-- thanh cac dich vu :mien phi giao hang, qua tang mien phi ........ -->
   


</body>
</html>