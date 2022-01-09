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
                          <a class="nav-item nav-link " id="nav-taikhoan-tab"  href="/my-profile" role="tab" aria-controls="nav-home" aria-selected="false">Thông tin tài khoản</a>
                          <a class="nav-item nav-link" id="nav-donhang-tab" href="/my-order" role="tab" aria-controls="nav-profile" aria-selected="false">Danh sách đơn hàng</a>
                          <a class="nav-item nav-link" id="nav-yeuthich-tab"  href="/my-favorites" role="tab" aria-controls="nav-profile" aria-selected="false">Yêu Thích</a>
                          <a class="nav-item nav-link active " id="nav-diachi-tab"  href="/my-address" role="tab" aria-controls="nav-home" aria-selected="true">Địa chỉ nhận hàng</a>
                        </div>
                    </nav>

                    <!-- nội dung 2 tab -->
                    <div class="tab-content">

                        <!-- nội dung tab 1: thông tin tài khoản  -->
                        <div class="tab-pane fade show pl-4 " id="nav-taikhoan" role="tabpanel" aria-labelledby="nav-taikhoan-tab">
                            <div class="offset-md-4 mt-3">
                                <h3 class="account-header">Thông tin tài khoản</h3>
                            </div>
                            <div class="hoten my-3">
                                <div class="row">
                                    <label class="col-md-2 offset-md-2" for="account-hoten">Họ tên</label>
                                    <input class="col-md-4" type="text" name="account-hoten">
                                </div>
                            </div>
                            <div class="email my-3">
                                <div class="row">
                                    <label class="col-md-2 offset-md-2" for="account-email">Địa chỉ email</label>
                                    <input class="col-md-4" type="text" name="account-email" disabled="disabled" value="abc@gmail.com">
                                </div>
                            </div>
                            <div class="checkbox-change-pass my-3">
                                <div class="row">
                                    <input type="checkbox" name="changepass" id="changepass" class="offset-md-4" style="margin-top: 6px;margin-right: 5px; ">
                                    <label for="changepass">Thay đổi mật khẩu</label>
                                </div>
                            </div>
                            <div class="thay-doi-mk">
                                <div class="mkcu my-3">
                                    <div class="row">
                                        <label class="col-md-2 offset-md-2" for="account-mkcu">Mật khẩu cũ</label>
                                        <input class="col-md-4" type="text" name="account-mkcu">
                                    </div>
                                </div>
                                <div class="mkmoi my-3">
                                    <div class="row">
                                        <label class="col-md-2 offset-md-2" for="account-mkmoi">Mật khẩu mới</label>
                                        <input class="col-md-4" type="text" name="account-mkmoi">
                                    </div>
                                </div>
                                <div class="xacnhan-mkmoi my-3">
                                    <div class="row">
                                        <label class="col-md-2 offset-md-2" for="account-xacnhan-mkmoi">Xác nhận mật khẩu</label>
                                        <input class="col-md-4" type="text" name="account-xacnhan-mkmoi">
                                    </div>
                                </div>
                                <div class="capnhat my-3">
                                    <div class="row">
                                        <button type="button" class="button-capnhat text-uppercase offset-md-4 btn btn-warning mb-4">Cập nhật</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- nội dung tab 2: danh sách đơn hàng -->
                        <div class="tab-pane fade show py-3" id="nav-donhang" role="tabpanel" aria-labelledby="nav-donhang-tab">
                            <div class="donhang-table">
                                <table class="m-auto">
                                    <tr>
                                        <th>Mã đơn hàng</th>
                                        <th>Ngày mua</th>
                                        <th>Sản phẩm</th>
                                        <th>Tổng tiền</th>
                                        <th>Trạng thái đơn hàng</th>
                                    </tr>
                                    <tr>
                                        <td>DH201</td>
                                        <td>20-11-2021</td>
                                        <td>Thiên Thần</td>
                                        <td>150000</td>
                                        <td>
                                            <span><button class="btn btn-google">Hóa Đơn</button></span>
                                            <span>&nbsp;&nbsp;&nbsp;<button class="btn btn-dark">Hủy</button></span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade show py-3" id="nav-yeuthich" role="tabpanel" aria-labelledby="nav-yeuthich-tab">
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
                                        <td>1</td>
                                        <td>Thiên Thần</td>
                                        <td>30-11-2021</td>
                                        <td>150000</td>
                                        <td>
                                            <span><button class="btn btn-success">Xem</button></span>
                                            <span>&nbsp;&nbsp;&nbsp;<button class="btn btn-danger">Xóa</button></span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade show pl-4 active " id="nav-diachi" role="tabpanel" aria-labelledby="nav-diachi-tab">
                            <div class="offset-md-4 mt-3">
                                <h3 class="account-header">Địa chỉ nhận hàng</h3>
                            </div>
                            <form action="/update/my-address" modelAttribute="addressForm" method="post">
                            <div class="hoten my-3">
                                <div class="row">
                                    <label class="col-md-2 offset-md-2" for="account-hoten">Họ </label>
                                    <input class="col-md-4" type="text" name="firstname" value="${address.firstname} ">
                                </div>
                            </div>
                              <div class="hoten my-3">
                                <div class="row">
                                    <label class="col-md-2 offset-md-2" for="account-hoten">Tên</label>
                                    <input class="col-md-4" type="text" name="lastname" value="${address.lastname }">
                                </div>
                            </div>
                            <div class="email my-3">
                                <div class="row">
                                    <label class="col-md-2 offset-md-2" for="account-email">Địa chỉ email</label>
                                    <input class="col-md-4" type="text" path="email" name="email" value="${address.email }">
                                </div>
                            </div>
                            <div class="email my-3">
                                <div class="row">
                                    <label class="col-md-2 offset-md-2" for="account-phone">Số điện thoại</label>
                                    <input class="col-md-4" type="text" path="phone" name="phone"  value="${address.phone}">
                                </div>
                            </div>
                              <div class="hoten my-3">
                                <div class="row">
                                    <label class="col-md-2 offset-md-2" for="account-hoten">Tỉnh</label>
                                    <input class="col-md-4" type="text" name="provincial" value="${address.provincial}">
                                </div>
                            </div>
                            <div class="email my-3">
                                <div class="row">
                                    <label class="col-md-2 offset-md-2" for="account-address">Địa chỉ liên hệ</label>
                                    <input class="col-md-4" type="text" path="address" name="address" value="${address.address }">
                                </div>
                            </div>
                                <div class="capnhat my-3">
                                    <div class="row">
                                    <a href="/"></a>
                                        <button type="submit" class="button-capnhat text-uppercase offset-md-4 btn btn-warning mb-4">Cập nhật</button>
                                    </div>
                                </div>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    <!-- thanh cac dich vu :mien phi giao hang, qua tang mien phi ........ -->
   


</body>
</html>