<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="" id="formdangky" data-backdrop="static" tabindex="-1" aria-labelledby="dangky_tieude"
        aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <ul class="tabs d-flex justify-content-around list-unstyled mb-0">
                        <li class="tab  text-center">
                            <a href="/login">Đăng nhập</a>
                            <hr>
                        </li>
                        <li class="tab text-center">
                            <a href="/register">Đăng ký</a>
                            <hr>
                        </li>
                    </ul>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                 <form id="form-signup" class="form-signin mt-2" action="/register/check" modelAttribute="userRegister" method="post">
                   
                        <div class="form-label-group">
                            <input  type="email" class="form-control mr-2" placeholder="Nhập địa chỉ email" path="email" name="email" aria-label="Recipient's username"
											aria-describedby="button-addon2" 
                                required>
                            <button type="submit" class="btn btn-success" id="button-addon2" formaction="/register/mailSender">Lấy mã xác nhận</button>
                        </div>
                        <div class="modal fade" id="exampleModal" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true"
									style="border-radius: 0;">
									<div class="modal-dialog" style="border-radius: 0;">
										<div class="modal-content" style="border-radius: 0;">
											<div class="modal-header">
												<h5 class="modal-title text-danger" id="exampleModalLabel">Thông
													báo</h5>
												<!-- <button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button> -->
											</div>
											<div class="modal-body">Đường dẫn làm mới mật khẩu đã
												được gửi qua email của bạn. Vui lòng check email!</div>
											<div class="modal-footer">
												<!-- <button type="button" class="btn btn-secondary" data-dismiss="modal" style="border-radius: 0;">Đóng</button> -->
												<button type="submit" formaction="/register/mailSender"
													class="btn btn-primary" style="border-radius: 0;">Xác
													nhận</button>
											</div>
										</div>
									</div>
								</div>
								
						 <div class="form-label-group mb-4">
                            <input type="password" class="form-control" name="code"
                                placeholder="Nhập mã xác nhận">
                        </div>
                        <div class="form-label-group">
                            <input type="text" class="form-control mr-2" placeholder="Nhập vào họ" name="firstName" path="firstName"
                                >
                            <input type="text" class="form-control" placeholder="Nhập vào tên" name="lastName" path="lastName"
                               >
                        </div>
                        <div class="form-label-group">
                            <input type="password" class="form-control" placeholder="Nhập mật khẩu" name="password" path="password"
                                >
                        </div>
                          <div class="form-label-group">
                            <input type="password" class="form-control" placeholder="Nhập lại mật khẩu" name="confirm" path="confirm"
                                >
                        </div>                 
                        <button class="btn btn-lg btn-block btn-signin text-uppercase text-white mt-3" type="submit"
                            style="background: #F5A623">Đăng ký</button>
                        <hr class="mt-3 mb-2">
                        <div class="custom-control custom-checkbox">
                            <p class="text-center">Bằng việc đăng ký, bạn đã đồng ý với NogulBook về</p>
                            <a href="#" class="text-decoration-none text-center" style="color: #F5A623">Điều khoản dịch
                                vụ & Chính sách bảo mật</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>