<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kết quả tìm kiếm cho từ khóa: ${sessionScope.keyword}</title>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-3">
			 <div class="categorycontent2">
                            <c:forEach var="item" items="${bookcate}">
						   <ul>
    						<li> <a href="#"> ${item.group.name} (${item.count})</a><i class="fa fa-chevron-right float-right"></i>
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
                                		 			
                                		 <li><a href="#">${bookcate.book.author.name }</a></li>  
                                		 </c:if>
                                
                       				  </c:forEach>
                                    </div>
                                </ul>
                            </li>
                            </ul>
    					</c:forEach>                        
                    </div>
			</div>
			<div class="col-9">
			<h5>${bookItem.totalElements+authorItem.totalElements+publisherItem.totalElements+categoryItem.totalElements }
			Kết quả tìm kiếm cho từ khóa: ${sessionScope.keyword} </h5>
			<span>Sách</span>
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
                  <span>Tác giả</span>
                  <c:if test="${authorItem.totalElements==0 }"><span>0 kết quả</span></c:if>
                   <c:if test="${authorItem.totalElements>0 }"><span>${authorItem.totalElements} kết quả</span></c:if>
                <div class="row">
                    <!-- 1 san pham -->
                  
                    <c:forEach var="item" items="${authorItem.content}">
							<div class="col-3">
                        <a href="/detail-author/${item.id }" class="motsanpham" style="text-decoration: none; color: black;"
                            data-toggle="tooltip" data-placement="bottom" title="${item.name }">
                            <img class="card-img-top anh" src='<c:url value="/template/sale/img/${item.createdBy }"/>'
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
                    <span>Nhã xuất bản</span>
                  <c:if test="${publisherItem.totalElements==0 }"><span>0 kết quả</span></c:if>
                   <c:if test="${publisherItem.totalElements>0 }"><span>${publisherItem.totalElements} kết quả</span></c:if>
                <div class="row">
                    <!-- 1 san pham -->
                  
                    <c:forEach var="item" items="${publisherItem.content}">
							<div class="col-3">
                        <a href="/detail-book/${item.id }" class="motsanpham" style="text-decoration: none; color: black;"
                            data-toggle="tooltip" data-placement="bottom" title="${item.name }">
                            <img class="card-img-top anh" src='<c:url value="/template/sale/img/${item.createdBy }"/>'
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
                    <span>Thể loại</span>
                  <c:if test="${categoryItem.totalElements==0 }"><span>0 kết quả</span></c:if>
                  <c:if test="${categoryItem.totalElements>0 }"><span>${categoryItem.totalElements} kết quả</span></c:if>
                <div class="row">
                    <!-- 1 san pham -->
                  
                    <c:forEach var="item" items="${categoryItem.content}">
							<div class="col-3">
                        <a href="/detail-book/${item.id }" class="motsanpham" style="text-decoration: none; color: black;"
                            data-toggle="tooltip" data-placement="bottom" title="${item.name }">
                            <img class="card-img-top anh" src='<c:url value="/template/sale/img/${item.code }"/>'
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
	
	</div>

			</div>
		</div>
	
    <!-- form dang nhap khi click vao button tren header-->
</body>
</html>