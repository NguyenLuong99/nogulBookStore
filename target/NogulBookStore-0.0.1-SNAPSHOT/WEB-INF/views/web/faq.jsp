<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NogulBookStore Tri thức và cuộc sống</title>

</head>
<body>
    <section class="header bg-light">
        <div class="container">
            <div class="row">
                <div class="col-md-3" style="margin-right: -15px;">
                    <!-- CATEGORIES -->
                    <div class="categorycontent2">
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
                <!-- banner slider  -->
                <div class="col-md-9 px-0">
                    <div id="carouselId" class="carousel slide" data-ride="carousel">
                        <ol class="nutcarousel carousel-indicators rounded-circle">
                            <li data-target="#carouselId" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselId" data-slide-to="1"></li>
                            <li data-target="#carouselId" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                         <div class="carousel-item">
                                <a href="#"><img src='<c:url value="/template/sale/img/banner_web_khai_truong.jpg"/>' class="img-fluid"
                                        style="height: 386px;" alt="Third slide"></a>
                            </div>
                            <div class="carousel-item active">
                                <a href="#"><img src='<c:url value="/template/sale/img/banner-fb8.jpg"/>' class="img-fluid"
                                        style="height: 386px;" width="900px" alt="First slide"></a>
                            </div>
                            <div class="carousel-item">
                                <a href="#"><img src='<c:url value="/template/web/images/banner-beethoven.jpg"/>' class="img-fluid"
                                        style="height: 386px;" width="900px" alt="Second slide"></a>
                            </div>
                           
                        </div>
                        <a class="carousel-control-prev" href="#carouselId" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselId" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- khoi sach moi  -->
    <section class="_1khoi sachmoi bg-white">
        <div class="container">
            <div class="noidung" style=" width: 100%;">
                <div class="row">
                    <!--header-->
                    <div class="col-12 d-flex justify-content-between align-items-center pb-2 bg-transparent pt-4">
                        <h1 class="header text-uppercase" style="font-weight: 400;">SÁCH MỚI TUYỂN CHỌN</h1>
                        <a href="sach-moi-tuyen-chon.html" class="btn btn-warning btn-sm text-white">Xem tất cả</a>
                    </div>
                </div>
                <div class="khoisanpham" style="padding-bottom: 2rem;">
                    <!-- 1 san pham -->
                    <c:forEach var="item" items="${bookDetail}">
                           <div class="card">
                   
                        <a href="/detail-book/${item.group.id}" class="motsanpham"
                            style="text-decoration: none; color: black;" data-toggle="tooltip" data-placement="bottom"
                            title="${item.group.name }">
                            <img class="card-img-top anh" src='<c:url value="/template/sale/img/${ item.group.imgBook}"/>'
                                alt="lap-ke-hoach-kinh-doanh-hieu-qua"/>
                            <div class="card-body noidungsp mt-3">
                                <h3 class="card-title ten">${item.group.name }</h3>
                                <small class="tacgia text-muted">${item.publisher}</small>
                                <div class="gia d-flex align-items-baseline">
                                    <div class="giamoi">${item.group.salePrice}đ</div>
                                    <div class="giacu text-muted">${item.group.price}₫</div>
                                    <div class="sale">-${item.sale}</div>
                                </div>
                                <div class="danhgia">
                                    <ul class="d-flex" style="list-style: none;">
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li><i class="fa fa-star"></i></li>
                                        <li><span class="text-muted">0 nhận xét</span></li>
                                    </ul>
                                </div>
                            </div>
                        </a>
                    </div>
			</c:forEach>
             
                </div>
            </div>
        </div>
    </section>

    <!-- khoi sach combo hot  -->
    <section class="_1khoi combohot mt-4">
        <div class="container">
            <div class="noidung bg-white" style=" width: 100%;">
                <div class="row">
                    <!--header -->
                    <div class="col-12 d-flex justify-content-between align-items-center pb-2 bg-light">
                        <h2 class="header text-uppercase" style="font-weight: 400;">COMBO SÁCH HOT - GIẢM ĐẾN 25%</h2>
                        <a href="#" class="btn btn-warning btn-sm text-white">Xem tất cả</a>
                    </div>
                </div>
                <div class="khoisanpham">
          			<c:forEach var="item" items="${listSaleBook }">
          				          <div class="card">
                        <a href="/detail-book/${item.group.id }" class="motsanpham" style="text-decoration: none; color: black;"
                            data-toggle="tooltip" data-placement="bottom" title="${item.group.name}">
                            <img class="card-img-top anh" src='<c:url value="template/sale/img/${item.group.imgBook}"/>'
                                alt="combo-chuyen-nghe-chuyen-doi">
                            <div class="card-body noidungsp mt-3">
                                <h3 class="card-title ten">${item.group.name}</h3>
                                <small class="tacgia text-muted">${item.author}</small>
                                <div class="gia d-flex align-items-baseline">
                                    <div class="giamoi">${item.group.salePrice}  ₫</div>
                                    <div class="giacu text-muted">${item.group.price} ₫</div>
                                    <div class="sale">-${item.sale}%</div>
                                </div>
                                <div class="danhgia">
                                    <ul class="d-flex" style="list-style: none;">
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li><i class="fa fa-star"></i></li>
                                        <li><span class="text-muted">0 nhận xét</span></li>
                                    </ul>
                                </div>
                            </div>
                        </a>
                    </div>
          			</c:forEach>
                   
                   
                </div>
            </div>
        </div>
    </section>

    <!-- khoi sach sap phathanh  -->
    <section class="_1khoi sapphathanh mt-4">
        <div class="container">
            <div class="noidung bg-white" style=" width: 100%;">
                <div class="row">
                    <!--header-->
                    <div class="col-12 d-flex justify-content-between align-items-center pb-2 bg-light">
                        <h2 class="header text-uppercase" style="font-weight: 400;">SÁCH SẮP PHÁT HÀNH / ĐẶT TRƯỚC</h2>
                        <a href="#" class="btn btn-warning btn-sm text-white">Xem tất cả</a>
                    </div>
                </div>
                <div class="khoisanpham">
                    <!-- 1 san pham -->
                    <c:forEach var="item" items="${bookDetail}">
                    <c:set var="book" scope="session" value="${item.group.createdBy}" />
                    <c:if test="${book == '0' }">
							<div class="card">
                        <a href="/detail-book/${item.group.id }" class="motsanpham" style="text-decoration: none; color: black;"
                            data-toggle="tooltip" data-placement="bottom" title="${item.group.name }">
                            <img class="card-img-top anh" src='<c:url value="template/sale/img/${item.group.imgBook }"/>'
                                alt="${item.group.name }">
                            <div class="card-body noidungsp mt-3">
                                <h3 class="card-title ten">${item.group.name}</h3>
                                <small class="tacgia text-muted">${item.author}</small>
                                <div class="gia d-flex align-items-baseline">
                                </div>
                                <div class="danhgia">
                                    <ul class="d-flex" style="list-style: none;">
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li class="active"><i class="fa fa-star"></i></li>
                                        <li><i class="fa fa-star"></i></li>
                                        <li><span class="text-muted">0 nhận xét</span></li>
                                    </ul>
                                </div>
                            </div>
                        </a>
                    </div>
                    </c:if>
                     
                 
                    </c:forEach>
                   
                </div>
            </div>
        </div>
    </section>


    <!-- div _1khoi -- khoi sachnendoc -->
    <section class="_1khoi sachnendoc bg-white mt-4">
        <div class="container">
            <div class="noidung" style=" width: 100%;">
                <div class="row">
                    <!--header-->
                    <div class="col-12 d-flex justify-content-between align-items-center pb-2 bg-transparent pt-4">
                        <h2 class="header text-uppercase" style="font-weight: 400;">SÁCH HAY NÊN ĐỌC</h2>
                        <a href="#" class="btn btn-warning btn-sm text-white">Xem tất cả</a>
                    </div>
                    <!-- 1 san pham -->
              		<c:forEach var="item" items="${listViewBook}">
              		   <div class="col-lg col-sm-4">
                        <div class="card">
                            <a href="detail-book/${item.id }" class="motsanpham" style="text-decoration: none; color: black;"
                                data-toggle="tooltip" data-placement="bottom" title="Cảm ơn vì đã được thương">
                                <img class="card-img-top anh" src='<c:url value="/template/sale/img/${item.imgBook }"/>'
                                    alt="cam-on-vi-da-duoc-thuong">
                                <div class="card-body noidungsp mt-3">
                                    <h3 class="card-title ten">${item.name }</h3>
                                    <small class="thoigian text-muted">Views: ${item.views}</small></br>
                                    <small class="thoigian text-muted">NXB: 31/03/2020</small>
                                    <div><a class="detail" href="/detail-book/${item.id }">Xem chi tiết</a></div>
                                </div>
                            </a>
                        </div>
                    </div>
              		</c:forEach>
                 
         <!--           <div class="col-lg col-sm-4">
                        <div class="card">
                            <a href="#" class="motsanpham" style="text-decoration: none; color: black;"
                                data-toggle="tooltip" data-placement="bottom"
                                title="Hào quang của vua Gia Long trong mắt Michel Gaultier">
                                <img class="card-img-top anh" src='<c:url value="/template/web/images/vua-gia-long.jpg"/>' alt="vua-gia-long">
                                <div class="card-body noidungsp mt-3">
                                    <h3 class="card-title ten">Hào quang của vua Gia Long trong mắt Michel Gaultier</h3>
                                    <small class="thoigian text-muted">21/03/2020</small>
                                    <div><a class="detail" href="#">Xem chi tiết</a></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg col-sm-4">
                        <div class="card">
                            <a href="#" class="motsanpham" style="text-decoration: none; color: black;"
                                data-toggle="tooltip" data-placement="bottom"
                                title="Suối nguồn” và cái tôi hiện sinh trong từng cá thể">
                                <img class="card-img-top anh" src='<c:url value="/template/web/images/suoi-nguon-va-cai-toi-trong-tung-ca-the.jpg"/>'
                                    alt="suoi-nguon-va-cai-toi-trong-tung-ca-the">
                                <div class="card-body noidungsp mt-3">
                                    <h3 class="card-title ten">"Suối nguồn” và cái tôi hiện sinh trong từng cá thể</h3>
                                    <small class="thoigian text-muted">16/03/2020</small>
                                    <div><a class="detail" href="#">Xem chi tiết</a></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg col-sm-4">
                        <div class="card cuoicung">
                            <a href="#" class="motsanpham" style="text-decoration: none; color: black;"
                                data-toggle="tooltip" data-placement="bottom"
                                title="Đại dịch trên những con đường tơ lụa">
                                <img class="card-img-top anh" src='<c:url value="/template/web/images/dai-dich-tren-con-duong-to-lua.jpg"/>'
                                    alt="dai-dich-tren-con-duong-to-lua">
                                <div class="card-body noidungsp mt-3">
                                    <h3 class="card-title ten">Đại dịch trên những con đường tơ lụa</h3>
                                    <small class="thoigian text-muted">16/03/2020</small>
                                    <div><a class="detail" href="#">Xem chi tiết</a></div>
                                </div>
                            </a>
                        </div>
                    </div>-->
                </div>
            </div>
            <hr>
        </div>
    </section>
    <div>

    </div>
    </body>
    </html>