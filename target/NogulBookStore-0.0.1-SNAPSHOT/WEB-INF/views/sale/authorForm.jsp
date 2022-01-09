<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${!edit2?'Thêm tác giả':'Cập nhật tác giả '}</title>

</head>

<body id="page-top">
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Form Tác giả</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Cập Nhật</h6>
						</div>
						<div class="card-body">
							<form:form action="/sale/authorForm/form" method="post"
								modelAttribute="authorForm" enctype="multipart/form-data">
								<div class="form-group">
									<label for="inputEmail4">Tên tác giả</label>
									<form:input path="name" cssClass="form-control"
										cssErrorClass="form-control is-invalid" id="inputEmail4" />
									<form:errors path="name" cssClass="invalid-feedback"></form:errors>
								</div>

								<div class="form-group">
									<label for="inputEmail4">Hình ảnh</label>
									<div class="custom-file mb-3 ">
										<form:input path="image" type="file"
											cssClass="custom-file-input"
											cssErrorClass="custom-file-input is-invalid"
											id="validatedCustomFile" />
										<label class="custom-file-label" for="validatedCustomFile">Choose
											file...</label>
										<form:errors path="" cssClass="invalid-feedback"></form:errors>
									</div>
								</div>
								
								<div class="form-group">
									<label for="inputEmail4">Mô tả</label>
									<form:textarea rows="3" path="des" cssClass="form-control"
										cssErrorClass="form-control is-invalid" id="inputEmail4" />
									<form:errors path="" cssClass="invalid-feedback"></form:errors>
								</div>
								<div class="form-group">
									<label for="inputEmail4">Số tác phẩm</label>
									<form:input path="numberOfbook" cssClass="form-control"
										cssErrorClass="form-control is-invalid" id="inputEmail4" />
									<form:errors path="" cssClass="invalid-feedback"></form:errors>
								</div>
								<div class="form-group d-flex justify-content-center">
									<c:if test="${edit2}">
												<img  width="200px" height="200px" src="/template/sale/img/${ sessionScope.nameImage2}"
										 alt="${ sessionScope.nameImage2}">
									</c:if>
						
								</div>
								<c:if test="${!edit2}">
									<button type="submit" class="btn btn-primary">
										<i class="fas fa-pen"></i> Lưu
									</button>
								</c:if>

								<c:if test="${edit2}">
									<button
										formaction="/sale/authorForm/form/edit/${sessionScope.id2 }"
										class="btn btn-primary">
										<i class="fas fa-pen"></i> Cập nhật
									</button>
								</c:if>

								<button formaction="/sale/authorForm/refresh"
									class="btn btn-info">
									<i class="fas fa-redo-alt"></i> Làm mới
								</button>
									<button formaction="/sale/authorTable/list" formmethod="get"
									class="btn btn-danger">
									<i class="fas fa-list"></i> Danh sách
								</button>
							</form:form>
						
						</div>
					</div>

				</div>

</body>

</html>