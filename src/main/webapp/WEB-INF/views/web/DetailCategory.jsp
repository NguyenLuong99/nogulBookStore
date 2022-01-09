<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${category.name }</title>
</head>
<body>
	
	<div class="container">
	</br>
		<div class="row">
			<div class="col-3">
			 <div class="">
					<img width="200" height="250" src="/template/sale/img/${category.code}" />
					<p>Thể loại: ${category.name}</p>	
					<p></p>	 
             </div>
			</div>
			<div class="col-9">
			<h5>Sách về thể loại này </h5>
			<c:if test="${bookItem.totalElements==0 }"><span>0 kết quả</span></c:if>
			 <c:if test="${bookItem.totalElements>0 }"><span>${bookItem.totalElements} kết quả</span></c:if>
			 <div class="row">
			 		
                    <!-- 1 san pham -->
                    <c:forEach var="item" items="${bookItem.content}">
							<div class="col-3">
                        <a href="/detail-book/${item.id }" class="motsanpham" style="text-decoration: none; color: black;"
                            data-toggle="tooltip" data-placement="bottom" title="${item.name }">
                            <img class="card-img-top anh" src='<c:url value="/template/sale/img/${item.imgBook }"/>'
                                alt="${item.name }">
                            <div class="card-body noidungsp mt-3">
                                <h3 class="card-title ten">${item.name}</h3>
                                <small class="tacgia text-muted"></small>
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
                     
                 
                    </c:forEach>
                   
                </div>
                <nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center">
									<li class="page-item ${(bookItem.number==0)?'disabled':''}"><a
										class="page-link"
										href="/detail-author/${author.id }?p=${bookItem.number-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="page-item disabled"><a class="page-link"
										href="#">${bookItem.number+1}</a></li>
									<li
										class="page-item ${(bookItem.number>=bookItem.totalPages-1)?'disabled':''}"><a
										class="page-link"
										href="detail-author/${author.id }?p=${bookItem.number+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
	
	</div>

			</div>
		</div>
	
    <!-- form dang nhap khi click vao button tren header-->
</body>
</html>