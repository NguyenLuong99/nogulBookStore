<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Order</title>

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
                          <a class="nav-item nav-link active" id="nav-donhang-tab" href="/my-order" role="tab" aria-controls="nav-profile" aria-selected="true">Danh sách đơn hàng</a>
                          <a class="nav-item nav-link" id="nav-yeuthich-tab"  href="/my-favorites" role="tab" aria-controls="nav-profile" aria-selected="false">Yêu Thích</a>
                          <a class="nav-item nav-link " id="nav-diachi-tab" href="/my-address" role="tab" aria-controls="nav-home" aria-selected="false">Địa chỉ nhận hàng</a>
                        </div>
                    </nav>

                    <!-- nội dung 2 tab -->
                    <div class="tab-content">

                        <!-- nội dung tab 1: thông tin tài khoản  -->
                        <div class="tab-pane fade show  pl-4 " id="nav-taikhoan" role="tabpanel" aria-labelledby="nav-taikhoan-tab">
                           
                        </div>

                        <!-- nội dung tab 2: danh sách đơn hàng -->
                        <div class="tab-pane  active show fade py-3" id="nav-donhang" role="tabpanel" aria-labelledby="nav-donhang-tab">
                            <div class="donhang-table">
                                <table class="m-auto">
                                    <tr>
                                        <th>Mã đơn hàng</th>
                                        <th>Ngày mua</th>
                                        <th>Tổng tiền</th>
                                        <th>Trạng thái đơn hàng</th>                                       
                                        <th>Hoạt động</th>
                                    </tr>
                                   
                                    <c:forEach var="item" items="${order}">
                                     <tr>
                                      <td>${item.name}</td>
                                        <td>${item.date}</td>  
                                        <td>${item.price+30000}VND</td>
                                          <td>${item.status?'Đã giao':'Đang chờ'}</td>
                                        <td>
                                           <a href="/shop/invoice/${item.name}"> <span><button class="btn btn-google" >Hóa Đơn</button></span></a>
                                            <a href="/my-order/delete/${item.name}"><span>&nbsp;&nbsp;&nbsp;
                                            <c:if test="${item.status==false }">
                                             
                                            <button class="btn btn-dark" 
                                            >Hủy</button></span></a> 
                                            </c:if>
                                           
                                        </td>
                                  </tr>
                                    </c:forEach>
                                   
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade py-3" id="nav-yeuthich" role="tabpanel" aria-labelledby="nav-yeuthich-tab">
                            
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