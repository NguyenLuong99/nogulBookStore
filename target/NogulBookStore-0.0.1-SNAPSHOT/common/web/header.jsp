
<div class="top-header">
        <div class="row">
            <div class="col-lg-6">
                <ul> 
                    <li class=" top-support"> <i class="fas fa-truck"></i> Miễn phí giao hàng |
                    <div class="top-content" style=" opacity: 2;"> <span class="arrow">&nbsp;</span> <div class="content"> <strong>Miễn phí giao hàng toàn quốc</strong> cho Đơn hàng từ 250.000đ.
                        </div> </div> </li> 
                    <li class=" top-support"> <i class="fa fa-book" aria-hidden="true"></i> 80.000 tựa sách |
                    <div class="top-content" > <span class="arrow">&nbsp;</span> <div class="content">
                            Với hơn 80,000 đầu sách trong mọi lĩnh vực (và tiếp tục tăng mỗi ngày), NogulBook.com tự hào là nhà sách trên mạng có số lượng đầu sách lớn nhất Việt Nam, bạn có thể tìm được bất kỳ quyển sách nào cho mọi nhu cầu đọc sách của bạn.
                        </div> 
                    </div> </li> 
                    <li class="top-support"> <i class="fa fa-mobile"></i> <a href="" target="_blank">NogulBook Reader</a> <div class="vnb-tooltip-content" style="display: none; opacity: 1;"> <span class="arrow">&nbsp;</span> <div class="content">
                            Hơn 10,000 tựa sách và tạp chí trong thư viện sách khổng lồ của NogulBook Reader mọi lúc mọi nơi chỉ từ 825đ/ngày
                        </div> 
                    </div> 
                    </li> 
                </ul>
            </div>  
            <div class="col-lg-6">
                <ul>
                    <li class="top-support"> &nbsp; &nbsp; &nbsp; </li>
                    <li class="top-support"> <i class="fas fa-phone"></i> (+84)396911849</li>
                    <li class="top-support"> <i class="far fa-envelope"></i> luongbnptit@gmail.com</li>
                    <li class="top-support"> <i class="far fa-clock"></i> Mon-Sat: 7h00-17h00</li>
                </ul>
            </div>
        </div>
          
        <!-- <li> <div class="fb-like" data-href="https://www.googles.com/" data-layout="button_count" data-action="like" data-show-faces="false" data-share="true"></div> </li> 
        </ul> -->
    </div>
    <div id="fb-root"></div>
    <script async defer crossorigin="anonymous"
        src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v6.0"></script>

    <!-- header -->
    <nav class="navbar navbar-expand-md bg-white navbar-light">
        <div class="container">
            <!-- logo  -->
            <a class="navbar-brand" href="/faq" style="color: #800080;"><b>NogulBook</b>.com</a>

            <!-- navbar-toggler  -->
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>

            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <!-- form tìm kiếm  -->
                <form class="form-inline ml-auto my-2 my-lg-0 mr-3" action="/authorTable/list" method="post">
                    <div class="input-group" style="width: 520px;">
                        <input type="text" class="form-control" name="keyword" aria-label="Small"
                            placeholder="Tìm kiếm tên sách, tên tác giả..." required>
                        <div class="input-group-append">
                            <button type="submit" class="btn" style="background-color: #800080; color: white;">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- ô đăng nhập đăng ký giỏ hàng trên header  -->
                <ul class="navbar-nav mb-1 ml-auto">
                    <div class="dropdown">
                    <security:authorize access="!isAuthenticated()">
                    <li class="nav-item account" type="button" class="btn dropdown" data-toggle="dropdown">
                            <a href="#" class="btn btn-secondary rounded-circle">
                                <i class="fa fa-user"></i>
                            </a>
                            <a class="nav-link text-dark text-uppercase" href="#" style="display:inline-block">Tài
                                khoản</a>
                        </li>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item nutdangky text-center mb-2" href="#" data-toggle="modal"
                                data-target="#formdangky">Đăng ký</a>
                            <a class="dropdown-item nutdangnhap text-center" href="#" data-toggle="modal"
                                data-target="#formdangnhap">Đăng nhập</a>
                        </div>
                    </security:authorize>
                      <security:authorize access="isAuthenticated()">
                    <li class="nav-item account" type="button" class="btn dropdown" data-toggle="dropdown">
                            <a href="#" class="rounded-circle">
      
                               <img style="width:40px;height:40px;" class="rounded-circle" src="${sessionScope.userLogin.img}">
                            </a>
                            <a class="nav-link text-dark text-uppercase" href="#" style="display:inline-block">${sessionScope.userLogin.username}
                                </a>
                        </li>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item nutdangky text-center mb-2" href="/logout" >Đăng xuất</a>
                            <a class="dropdown-item nutdangnhap text-center mb-2" href="/my-profile" >Thông tin</a>
                            <security:authorize access="hasRole('ROLE_ADMIN')">  
 								    <a class="dropdown-item nutdangnhap text-center" href="/admin/home" 
                                >Quản lý</a>
							</security:authorize>
							  <security:authorize access="hasRole('ROLE_SALE')">  
 								    <a class="dropdown-item nutdangnhap text-center" href="/sale/home" >QL.SẢN PHẨM</a>
							</security:authorize>
                        </div>
                    </security:authorize>
                        
                    </div>
                    <li class="nav-item giohang mt-2 mr-2">
                        <a href="/cart" class="btn btn-secondary rounded-circle">
                            <i class="fa fa-shopping-cart"></i>
                            <div class="cart-amount">${sessionScope.countProduct} ${sessionScope.countProduct==null?'0':''}</div>
                        </a>
                    </li>
                      <li class="nav-item giohang mt-2">
                        <a href="/my-favorites" class="btn btn-secondary rounded-circle">
                            <i class="fa fa-heart mt-1"></i>
                            <div class="cart-amount">${sessionScope.countFavorite} ${sessionScope.countFavorite==null?'0':''}</div>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    

    <!-- form dang ky khi click vao button tren header-->
    <div class="modal fade mt-5" id="formdangky" data-backdrop="static" tabindex="-1" aria-labelledby="dangky_tieude"
        aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <ul class="tabs d-flex justify-content-around list-unstyled mb-0">
                        <li class="tab tab-dangnhap text-center">
                            <a class=" text-decoration-none">Đăng nhập</a>
                            <hr>
                        </li>
                        <li class="tab tab-dangky text-center">
                            <a class="text-decoration-none">Đăng ký</a>
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
                            <button type="button" class="btn btn-success" id="button-addon2" data-toggle="modal"
												data-target="#exampleModal">Lấy mã xác nhận</button>
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


    <!-- form dang nhap khi click vao button tren header-->
    <div class="modal fade mt-5" id="formdangnhap" data-backdrop="static" tabindex="-1"
        aria-labelledby="dangnhap_tieude" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <ul class="tabs d-flex justify-content-around list-unstyled mb-0">
                        <li class="tab tab-dangnhap text-center">
                            <a class=" text-decoration-none">Đăng nhập</a>
                            <hr>
                        </li>
                        <li class="tab tab-dangky text-center">
                            <a class="text-decoration-none">Đăng ký</a>
                            <hr>
                        </li>
                    </ul>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="form-signin" class="form-signin mt-2" action="/login" modelAttribute="LoginUser" method="post">
                        <div class="form-label-group">
                            <input type="email" class="form-control" placeholder="Nhập địa chỉ email" name="username"
                                required autofocus>
                        </div>

                        <div class="form-label-group">
                            <input type="password" class="form-control" placeholder="Mật khẩu" name="password" required>
                        </div>

                        <div class="custom-control custom-checkbox mb-3">
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                            <label class="custom-control-label" for="customCheck1">Nhớ mật khẩu</label>
                            <a href="#" class="float-right text-decoration-none" style="color: #F5A623">Quên mật
                                khẩu</a>
                        </div>

                        <button class="btn btn-lg btn-block btn-signin text-uppercase text-white" type="submit"
                            style="background: #F5A623">Đăng nhập</button>
                        <hr class="my-4">
                    </form>
                        <div class="form-signin">
                    	                     <a href="https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile&state=profile&redirect_uri=https://localhost:8443/login-google&response_type=code
		&client_id=1085856975235-cgcj8drcfqpt8kgspssjb8h0o185dog6.apps.googleusercontent.com&approval_prompt=force">
								 <button class="btn btn-lg btn-google btn-block text-uppercase mb-2" type="submit"><i
                                class="fab fa-google mr-2"></i> Đăng nhập bằng Google</button>
						</a>
               <a href="https://www.facebook.com/dialog/oauth?client_id=5181708718512968&redirect_uri=https://localhost:8443/login-facebook">
                          <button class=" btn btn-lg btn-facebook btn-block text-uppercase " type="submit"><i
                                class="fab fa-facebook-f mr-2"></i> Đăng nhập bằng Facebook</button>
                       </a>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- thanh tieu de "danh muc sach" + hotline + ho tro truc tuyen -->
    <section class="duoinavbar">
        <div class="container text-white">
            <div class="row justify">
                <div class="col-md-4">
                    <div class="categoryheader">
                        <div class="noidungheader text-white">
                            <i class="fa fa-bars"></i>
                            <span class="text-uppercase font-weight-bold ml-1">Danh mục sách</span>
                        </div>
                        <div class="categorycontent">
                                 <c:forEach var="item" items="${bookcate}">
						   <ul>
    						<li> <a href="/detail-category/${item.group.id }"> ${item.group.name} (${item.count})</a><i class="fa fa-chevron-right float-right"></i>
                                <ul>
                                   
                                    <div class="content trai">
                                     <li class="liheader"><a href="#" class="header text-uppercase">
                                          Một số tác phẩm</a></li>
                                	  <c:forEach var="bookcate" items="${listBookCate}">
                                		 <c:set var="id" scope="session" value="${bookcate.category.id }"/>
                                		 <c:if test="${id==item.group.id }">
                                		 <li><a href="/detail-book/${bookcate.book.id }">${bookcate.book.name }</a></li>  
                                		 </c:if>
                                          
                       				  </c:forEach>
                                    </div>
                                 
                                    <div class="content phai">
                                        <li class="liheader"><a href="#" class="header text-uppercase">Một số tác giả</a></li>
                                 	 	  <c:forEach var="bookcate" items="${listBookCate}">
                                		 <c:set var="id" scope="session" value="${bookcate.category.id }"/>
                                		 <c:if test="${id==item.group.id }">
                                		 			
                                		 <li><a href="/detail-author/${bookcate.book.author.id }">${bookcate.book.author.name }</a></li>  
                                		 </c:if>
                                
                       				  </c:forEach>
                                    </div>
                                </ul>
                            </li>
                            </ul>
    					</c:forEach>   
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="benphai float-right">
                        <div class="hotline">
                            <i class="fa fa-phone"></i>
                            <span>Hotline:<b>0396911849</b> </span>
                        </div>
                        <i class="fas fa-comments-dollar"></i>
                        <a href="#">Hỗ trợ trực tuyến </a>
                    </div>
                </div>
            </div>
        </div>
    </section>