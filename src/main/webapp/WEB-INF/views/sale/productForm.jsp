<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Admin - Index</title>
</head>
<body id="page-top">
	<div id="wrapper">
	

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
			
				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Form Sách</h1>


					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Cập Nhật</h6>
						</div>
						<div class="card-body">
							<form:form action="/sale/bookForm/form" method="post"
								enctype="multipart/form-data" modelAttribute="bookForm">
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="inputEmail4">Tên Sách</label>
										<form:input path="name" cssClass="form-control"
											cssErrorClass="form-control is-invalid" id="inputEmail4" />
										<form:errors path="name" cssClass="invalid-feedback"></form:errors>
									</div>
									<div class="form-group col-md-6">
										<label for="inputState">Tác giả</label>
										<%-- <form:select path="manufacture" cssClass="form-control">
											<form:options items="${manufacture1}" itemValue="id" itemLabel="id"/>
										</form:select>	 --%>
										
									
										<form:select path="author" cssClass="form-control">
											<c:if test="${sessionScope.idAuthor!=null }">
											<form:option value="${sessionScope.idAuthor}">${bookForm.author}</form:option></c:if>
											<form:option value="" >---------</form:option>
											<form:options items="${author }"/>
										</form:select>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="inputEmail4">Giá nhập sách</label>
										<form:input type="number" path="inPrice" cssClass="form-control"
											cssErrorClass="form-control is-invalid" id="inputEmail4" />
										<form:errors path="" cssClass="invalid-feedback"></form:errors>
									</div>
									<div class="form-group col-md-4">
										<label for="inputEmail4">Giá bìa sách</label>
										<form:input type="number" path="price" cssClass="form-control"
											cssErrorClass="form-control is-invalid" id="inputEmail4" />
										<form:errors path="" cssClass="invalid-feedback"></form:errors>
									</div>
									<div class="form-group col-md-4">
										<label for="inputEmail4">Giá bán sách</label>
										<form:input type="number" path="salePrice" cssClass="form-control"
											cssErrorClass="form-control is-invalid" id="inputEmail4" />
										<form:errors path="" cssClass="invalid-feedback"></form:errors>
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="inputEmail4">Chọn hình</label>
										<div class="custom-file mb-3 ">
											<form:input path="imgBook" type="file"
												cssClass="custom-file-input"
												cssErrorClass="custom-file-input is-invalid"
												id="validatedCustomFile" />
											<label class="custom-file-label" for="validatedCustomFile">Choose
												file...</label>
											<form:errors path="" cssClass="invalid-feedback"></form:errors>
										</div>
									</div>
									<div class="form-group col-md-6">
										<label for="inputState">Nhà sản xuất</label>
										<%-- <form:select path="manufacture" cssClass="form-control">
											<form:options items="${manufacture1}" itemValue="id" itemLabel="id"/>
										</form:select>	 --%>
										<form:select path="publisher" cssClass="form-control">
											<form:option value="${sessionScope.idPublisher}">${bookForm.publisher }</form:option>
											<form:options  items="${publisher}"/>
										</form:select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="inputPassword4">Ngày xuất bản</label>
								
								<c:if test="${!edit3}">
								<form:input type="date" path="pubDay" cssClass="form-control" 
										cssErrorClass="form-control is-invalid" id="inputPassword4" />
									<form:errors path="" cssClass="invalid-feedback"></form:errors>
								</c:if>
						
									<c:if test="${edit3}">
								<form:input type="date" path="pubDay" cssClass="form-control" value="${sessionScope.pubDay}"
										cssErrorClass="form-control is-invalid" id="inputPassword4" />
									<form:errors path="" cssClass="invalid-feedback"></form:errors>
								</c:if>
								
								</div>
								<div class="form-group col-md-6">
										<label for="inputEmail4">Số lượng</label>
										<form:input type="number" path="quality" cssClass="form-control"
											cssErrorClass="form-control is-invalid" id="inputEmail4" />
										<form:errors path="" cssClass="invalid-feedback"></form:errors>
									</div>
								<div class="form-group">
									<label for="inputPassword4">Mô tả</label>
									<form:textarea rows="5" path="des" cssClass="form-control"
										cssErrorClass="form-control is-invalid" id="inputPassword4" />
									<form:errors path="" cssClass="invalid-feedback"></form:errors>
								</div>

								

								<c:if test="${!edit3}">
									<button type="submit" class="btn btn-primary">
										<i class="fas fa-pen"></i> Lưu
									</button>
								</c:if>

								<c:if test="${edit3}">
									<button
										formaction="/sale/bookForm/form/edit/${sessionScope.id3}"
										class="btn btn-primary">
										<i class="fas fa-pen"></i> Cập nhật
									</button>
								</c:if>

								<button formaction="/sale/bookForm/refresh"
									class="btn btn-info">
									<i class="fas fa-redo-alt"></i> Làm mới
								</button>
								<button formaction="/sale/book`Form/list" formmethod="get"
									class="btn btn-danger">
									<i class="fas fa-list"></i> Danh sách
								</button>
							</form:form>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->



		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Thông Báo!</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Vui lòng nhấn nút "Đăng xuất" bên dưới
					nếu bạn muốn đăng xuất tài khoản.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Thoát</button>
					<a class="btn btn-primary" href="/logout">Đăng xuất</a>
				</div>
			</div>
		</div>
	</div>

</body>

</html>