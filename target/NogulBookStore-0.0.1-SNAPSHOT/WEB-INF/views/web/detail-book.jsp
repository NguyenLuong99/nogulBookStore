<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${loadInfo.group.name}</title>
</head>
<body onload="check2(true)">
	<section class="breadcrumbbar">
		<div class="container">
			<ol class="breadcrumb mb-0 p-0 bg-transparent">
				<li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
				<li class="breadcrumb-item active"><a href="#">Sách kỹ năng
						làm việc</a></li>
			</ol>
		</div>
	</section>

	<!-- nội dung của trang  -->
	<section class="product-page mb-4">
		<div class="container">
			<!-- chi tiết 1 sản phẩm -->
			<div class="product-detail bg-white p-4">
				<div class="row">
					<!-- ảnh  -->
					<div class="col-md-5 khoianh">
						<div class="anhto mb-4">
							<a class="active"
								href='/template/web/images/${loadInfo.group.imgBook }'
								data-fancybox="thumb-img"> <img class="product-image"
								src='<c:url value="/template/web/images/${loadInfo.group.imgBook }"/>'
								alt="${loadInfo.group.name }" style="width: 100%;">
							</a>
						</div>
						<div class="list-anhchitiet d-flex mb-4"
							style="margin-left: 2rem;">
							<img class="thumb-img thumb1 mr-3"
								src='<c:url value="/template/web/images/${loadInfo.group.imgBook }"/>'
								class="img-fluid" alt="ma-bun-luu-manh-mt">
						</div>
					</div>
					<!-- thông tin sản phẩm: tên, giá bìa giá bán tiết kiệm, các khuyến mãi, nút chọn mua.... -->
					<div class="col-md-7 khoithongtin">
						<div class="row">
							<div class="col-md-12 header">
								<h4 class="ten">${loadInfo.group.name}</h4>
								<div class="rate">
									<i class="fa fa-star active"></i> <i class="fa fa-star active"></i>
									<i class="fa fa-star active"></i> <i class="fa fa-star active"></i>
									<i class="fa fa-star "></i>
								</div>
								<hr>
							</div>
							<div class="col-md-7">
								<div class="gia">
									<div class="giabia">
										Giá bìa:<span class="giacu ml-2">${loadInfo.group.price }₫</span>
									</div>
									<div class="giaban">
										Giá bán tại NogulBooks: <span class="giamoi font-weight-bold">${loadInfo.group.salePrice}
										</span><span class="donvitien ml-2">₫</span>
									</div>
									<div class="tietkiem">
										Tiết kiệm: <b>${loadInfo.esale}₫</b> <span class="sale">-${loadInfo.sale}%</span>
									</div>
									<div class="tietkiem">
										Đã bán: <b>${loadInfo.group.oQuality}${loadInfo.group.oQuality==null?'0':''}</b>
										 <span>|| Còn lại: ${loadInfo.group.quality} quyển</span>
									</div>
								</div>
								<div class="uudai my-3">
									<h6 class="header font-weight-bold">Khuyến mãi & Ưu đãi
										tại NogulBook:</h6>
									<ul>
										<li><b>Miễn phí giao hàng </b>cho đơn hàng từ 150.000đ ở
											TP.HCM và 300.000đ ở Tỉnh/Thành khác <a href="#">>> Chi
												tiết</a></li>
										<li><b>Combo sách HOT - GIẢM 25% </b><a href="#">>>Xem
												ngay</a></li>
										<li>Tặng Bookmark cho mỗi đơn hàng</li>
										<li>Bao sách miễn phí (theo yêu cầu)</li>
									</ul>
								</div>
								<form action="/detail-book/${sessionScope.cateId}" method="post"
									tabindex="-1">
									<div class="soluong d-flex">
										<label class="font-weight-bold">Số lượng: </label>
										<div class="input-number input-group mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text btn-spin btn-dec">-</span>
											</div>
											<input type="text" value="${quality}" name="quality"
												class="soluongsp  text-center">
											<div class="input-group-append">
												<span class="input-group-text btn-spin btn-inc">+</span>
											</div>
										</div>
									</div>
									<c:if test="${loadInfo.group.quality==0 }">
											<H6>sẢN PHẨM ĐÃ HẾT HÀNG</H6>
									</c:if>
									<c:if test="${loadInfo.group.quality>0 }">
											<button class="btn btn-success">Thêm vào giỏ hàng</button>
									</c:if>
									<c:if test="${checkFavorite==true }">
											<a href="/shop/favorite/${loadInfo.group.id}" class="btn btn-danger px-3 ml-3 "><i class="fas fa-heart"></i> Yêu Thích</a>
									
									</c:if>
									<c:if test="${checkFavorite==false && sessionScope.user!=null}">
									<a href="/shop/unFavorite/${loadInfo.group.id}" class="btn btn-danger px-3 ml-3 "><i class="fas fa-heart-broken"></i>Bỏ Thích</a>
									</c:if>
									<c:if test="${checkFavorite==false && sessionScope.user==null}">
									<a href="/shop/favorite/${loadInfo.group.id}" class="btn btn-danger px-3 ml-3 disabled " ><i class="fas fa-heart"></i> Yêu Thích</a>
									
	
									</c:if>
									<a class="huongdanmuahang text-decoration-none" href="#">(Vui
										lòng xem hướng dẫn mua hàng)</a> <small class="share">Share:
									</small>
							
								</form>
								<div class="fb-like" data-href="https://www.facebook.com"
									data-width="300px" data-layout="button" data-action="like"
									data-size="small" data-share="true"></div>

							</div>
							<div class="col-md-5">
								<div class="thongtinsach">
									<ul>
										<li>Tác giả: <a href="/detail-author/${loadInfo.group.author.id }" class="tacgia">${loadInfo.author}</a></li>
										<li>Ngày xuất bản: <b>${loadInfo.group.createdDate}</b></li>
										<li>Kích thước: <b>20.5 x 13.5 cm</b></li>
										<li>Dịch giả: <a href="#" class="tacgia">${loadInfo.group.modifiedBy}</a></li>
										<li>Nhà xuất bản: <a href="/detail-publisher/${loadInfo.group.publisher.id }" class="tacgia">${loadInfo.publisher}</a></li>
										<li>Thể loại: <c:forEach var="item" items="${category}">
												<a href="/detail-category/${item.id }"><span class="ml-2">${item.name}</span></a>
											</c:forEach>
										</li>

									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- decripstion của 1 sản phẩm: giới thiệu , đánh giá độc giả  -->
					<div class="product-description col-md-9">
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link text-uppercase"
									id="nav-gioithieu-tab" data-toggle="tab" href="#nav-gioithieu"
									role="tab" aria-controls="nav-gioithieu" aria-selected="true">Giới
									thiệu</a> <a class="nav-item nav-link active text-uppercase"
									id="nav-danhgia-tab" data-toggle="tab" href="#nav-danhgia"
									role="tab" aria-controls="nav-danhgia" aria-selected="false">Đánh
									giá của độc giả</a>
							</div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show  ml-3" id="nav-gioithieu"
								role="tabpanel" aria-labelledby="nav-gioithieu-tab">
								<h6 class="tieude font-weight-bold">${loadInfo.group.name}</h6>
								<p>
									<span>Khi bắt đầu thành lập doanh nghiệp hay mở rộng quy
										mô hoạt động, lập ra một bản kế hoạch kinh doanh là bước đi
										đầu tiên không thể thiếu. Bản kế hoạch kinh doanh càng được
										chuẩn bị kỹ lưỡng và lôi cuốn bao nhiêu, cơ hội ghi điểm trước
										các nhà đầu tư càng lớn bấy nhiêu. Phải chăng, thông qua bản
										kế hoạch kinh doanh, bạn muốn người đọc: </span>
								</p>
								<p>
									<span>- Đầu tư vào một ý tưởng kinh doanh mới hay một
										doanh nghiệp đang hoạt động?</span>
								</p>
								<p>
									<span>- Mua lại doanh nghiệp của bạn?</span>
								</p>
								<p>
									<span>- Tham gia liên doanh với bạn?</span>
								</p>
								<p>
									<span>- Chấp nhận đề nghị của bạn để thực hiện hợp đồng?</span>
								</p>
								<p>
									<span>- Cấp cho bạn một khoản hỗ trợ hoặc phê duyệt theo
										quy định?</span>
								</p>
								<p>
									<span>- Thuyết phục hội đồng quản trị thay đổi phương
										hướng hoạt động doanh nghiệp của bạn?</span>
								</p>
								<p>
									<span>Cuốn sách “Lập kế hoạch kinh doanh hiệu quả” sẽ
										hướng dẫn bạn cách để tạo ra bản kế hoạch kinh doanh thu hút
										mọi tổ chức tài chính, khiến họ phải đáp ứng mong muốn của bạn
										và hỗ trợ bạn tới cùng trong công việc kinh doanh. Thông qua
										cuốn sách, bạn sẽ biết cách:</span>
								</p>
								<p>
									<span>Tạo ra bản kế hoạch kinh doanh hoàn chỉnh Xây dựng
										chiến lược hoạt động cho doanh nghiệp.</span>
								</p>
								<p>
									<span>Đưa ra dự báo kinh doanh sát với thực tế.</span>
								</p>
								<p>
									<span>Nắm rõ các thông tin tài chính ảnh hưởng lớn tới
										doanh nghiệp.</span>
								</p>
								<p>
									<span>Trong quá trình xây dựng kế hoạch, việc tham khảo
										ý kiến chuyên gia là điều cần thiết nhưng bạn phải là người
										đóng góp chính và hiểu tường tận mỗi chi tiết có trong đó. Hãy
										xem việc lập kế hoạch giống như việc truyền đạt câu chuyện của
										mình nhằm thuyết phục người đọc đồng hành cùng bạn trên con
										đường chinh phục mục tiêu kinh doanh.</span>
								</p>
								<p>
									<span>Bạn chỉ có một cơ hội duy nhất để tạo ấn tượng đầu
										tiên tốt đẹp. Đừng để nó vụt mất. Hãy trình bày một văn bản có
										tính thuyết phục cao, bố cục đẹp mắt, không mắc lỗi chính tả,
										ngữ pháp, bao gồm các vấn đề trọng tâm và cuối cùng là chứa
										các thông tin bổ trợ cần thiết.</span>
								</p>
								<p>
									<span>Bằng kiến thức, kinh nghiệm của mình, Brian Finch
										- một chuyên gia trong lĩnh vực tư vấn lập kế hoạch kinh doanh
										và quản lý tài chính - chắc chắn sẽ giúp bạn xây dựng thành
										công kế hoạch kinh doanh của riêng mình.</span>
								</p>
							</div>
							<div class="tab-pane show active fade" id="nav-danhgia" role="tabpanel"
								aria-labelledby="nav-danhgia-tab">
								<div class="row">
								<div class="col-md-12">
									<h4 class="mb-4">${countFeedBack-1}  review for "${loadInfo.group.name}"</h4>
									<c:forEach var="feedback" items="${userItem.content}">
												<div class="media mb-4">
										<img src="/template/sale/img/${feedback.image}" alt="Image"
											class="img-fluid mr-3 mt-1" style="width: 45px;">
										<div class="media-body">
											<h6>
												${feedback.firstname} ${feedback.lastname}<small> - <i>${feedback.group.thumbnail}</i></small>
												<c:if test="${feedback.group.user.id==sessionScope.user.id}">
												<a href="/detail-book/delete/new/${sessionScope.cateId}/${feedback.group.id}"><smail><i>Xóa</i></smail></a>
												</c:if>
											</h6>
											<div class="text-primary mb-2">
												<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
													class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i>
												<i class="far fa-star"></i>
											</div>
											<p>${feedback.group.content}</p>
										</div>
										
									</div>
									</c:forEach>
									<c:if test="${sessionScope.user!=null}">
									
									<form class="media mb-4" action="/detail-book/post/new/${sessionScope.cateId}" method="post">
									
										<img src="${sessionScope.userLogin.img}" alt="Image"
											class="img-fluid mr-3 mt-1" style="width: 45px;">
										<div class="media-body">
											<h6>
												${sessionScope.userLogin.username}<small> - <i></i></small>
											</h6>
											<div class="text-primary mb-2">
												<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
													class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i>
												<i class="far fa-star"></i>
											</div>
											<div class="form-group">
												<input type="text" class="txtComment w-100" name="content"
													placeholder="Đánh giá của bạn về sản phẩm này">
											</div>
											<button class= "btn btn-success" type="submit">Gửi bình luận</button>
											</div>
									</form>
									</c:if>
										<nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center">
									<li class="page-item ${(userItem.number==0)?'disabled':''}"><a
										class="page-link"
										href="/detail-book/${sessionScope.cateId}?p=${userItem.number-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="page-item disabled"><a class="page-link"
										href="#">${userItem.number+1}</a></li>
									<li
										class="page-item ${(userItem.number>=userItem.totalPages-1)?'disabled':''}"><a
										class="page-link"
										href="/detail-book/${sessionScope.cateId}?p=${userItem.number+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
								
							</div>
								<div class="row">
									<div class="col-md-3 text-center">
										<p class="tieude">Đánh giá trung bình</p>
										<div class="diem">0/5</div>
										<div class="sao">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
										<p class="sonhanxet text-muted">(0 nhận xét)</p>
									</div>
									<div class="col-md-5">
										<div class="tiledanhgia text-center">
											<div class="motthanh d-flex align-items-center">
												5 <i class="fa fa-star"></i>
												<div class="progress mx-2">
													<div class="progress-bar" role="progressbar"
														aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
												0%
											</div>
											<div class="motthanh d-flex align-items-center">
												4 <i class="fa fa-star"></i>
												<div class="progress mx-2">
													<div class="progress-bar" role="progressbar"
														aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
												0%
											</div>
											<div class="motthanh d-flex align-items-center">
												3 <i class="fa fa-star"></i>
												<div class="progress mx-2">
													<div class="progress-bar" role="progressbar"
														aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
												0%
											</div>
											<div class="motthanh d-flex align-items-center">
												2 <i class="fa fa-star"></i>
												<div class="progress mx-2">
													<div class="progress-bar" role="progressbar"
														aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
												0%
											</div>
											<div class="motthanh d-flex align-items-center">
												1 <i class="fa fa-star"></i>
												<div class="progress mx-2">
													<div class="progress-bar" role="progressbar"
														aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
												0%
											</div>
											<c:if test="${sessionScope.user==null}">
											<div class="btn vietdanhgia mt-3">Viết đánh giá của bạn</div>
											</c:if>
										
											
										</div>
										<!-- nội dung của form đánh giá  -->
										<div class="formdanhgia">
											<h6 class="tieude text-uppercase">GỬI ĐÁNH GIÁ CỦA BẠN</h6>
											<span class="danhgiacuaban">Đánh giá của bạn về sản
												phẩm này:</span>
											<div
												class="rating d-flex flex-row-reverse align-items-center justify-content-end">
												<input type="radio" name="star" id="star1"><label
													for="star1"></label> <input type="radio" name="star"
													id="star2"><label for="star2"></label> <input
													type="radio" name="star" id="star3"><label
													for="star3"></label> <input type="radio" name="star"
													id="star4"><label for="star4"></label> <input
													type="radio" name="star" id="star5"><label
													for="star5"></label>
											</div>
											<div class="form-group">
												<input type="text" class="txtFullname w-100"
													placeholder="Mời bạn nhập tên(Bắt buộc)">
											</div>
											<div class="form-group">
												<input type="text" class="txtEmail w-100"
													placeholder="Mời bạn nhập email(Bắt buộc)">
											</div>
											<div class="form-group">
												<input type="text" class="txtComment w-100"
													placeholder="Đánh giá của bạn về sản phẩm này">
											</div>
											<div class="btn nutguibl">Gửi bình luận</div>
										</div>
									</div>
								</div>
							</div>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- khối sản phẩm tương tự -->
	<section class="_1khoi sachmoi">
		<div class="container">
			<div class="noidung bg-white" style="width: 100%;">
				<div class="row">
					<!--header-->
					<div
						class="col-12 d-flex justify-content-between align-items-center pb-2 bg-light pt-4">
						<h5 class="header text-uppercase" style="font-weight: 400;">Sách cùng tác giả</h5>
						<a href="sach-moi-tuyen-chon.html"
							class="btn btn-warning btn-sm text-white">Xem tất cả</a>
					</div>
				</div>
				<div class="khoisanpham" style="padding-bottom: 2rem;">		
					<!-- 1 sp -->
					<c:forEach var="item" items="${authorBook}">
					<div class="card">
						<a href="/detail-book/${item.id }"
							class="motsanpham" style="text-decoration: none; color: black;"
							data-toggle="tooltip" data-placement="bottom"
							title="${item.imgBook }"> <img
							class="card-img-top anh"
							src='<c:url value="/template/sale/img/${item.imgBook }"/>'
							alt="lap-ke-hoach-kinh-doanh-hieu-qua">
							<div class="card-body noidungsp mt-3">
								<h6 class="card-title ten">${item.name }</h6>
								<small class="tacgia text-muted">${loadInfo.author}</small>
								<div class="gia d-flex align-items-baseline">
									<div class="giamoi">${item.salePrice} ₫</div>
									<div class="giacu text-muted">${item.price} ₫</div>
									
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
					
					<div class="card">
					
					</div>
					<div class="card">
					
					</div>
				
				</div>
			</div>
		</div>
	</section>

	<!-- khối sách bạn đã xem  -->
	<section class="_1khoi combohot mt-4">
		<div class="container">
			<div class="noidung bg-white" style="width: 100%;">
				<div class="row">
					<!--header-->
					<div
						class="col-12 d-flex justify-content-between align-items-center pb-2 bg-light">
						<h5 class="header text-uppercase" style="font-weight: 400;">Sản
							phẩm bạn đã xem</h5>
						<a href="#" class="btn btn-warning btn-sm text-white">Xem tất
							cả</a>
					</div>
				</div>
				
				<div class="khoisanpham">
					<!-- 1 sp -->
					<c:forEach var="item" items="${historyBook.items }">
				<div class="card">
						<a href="/detail-book/${item.id}" class="motsanpham"
							style="text-decoration: none; color: black;"
							data-toggle="tooltip" data-placement="bottom"
							title="${item.name }"> <img
							class="card-img-top anh"
							src="/template/sale/img/${item.image }"
							alt="combo-chuyen-nghe-chuyen-doi">
							<div class="card-body noidungsp mt-3">
								<h6 class="card-title ten">${item.name }</h6>
								<small class="tacgia text-muted"></small>
								<div class="gia d-flex align-items-baseline">
									<div class="giamoi">${item.price }</div>
									<div class="giacu text-muted">139.000 ₫</div>
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
					
					<div class="card">
						
						
					</div>
					<div class="card">
						
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
 
	function check2(u){
        if(u == true){
            $("#exampleModal").modal("show");
        }
    }
	</script>
</body>
</html>