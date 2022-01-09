<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<!-- Sidebar -->
	<ul
		class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
		id="accordionSidebar">

		<!-- Sidebar - Brand -->
		<a
			class="sidebar-brand d-flex align-items-center justify-content-center"
			href="/sale/home" style="background-color: rgb(128, 0, 128);">
			<div class="sidebar-brand-icon rotate-n-15">
				<i class="fas fa-laugh-wink"></i>
			</div>
			<div class="sidebar-brand-text mx-3">Nogul Sale</div>
		</a>
		<!-- Divider -->

		<!-- Nav Item - Dashboard -->
			<li class="nav-item mt-2"><span style="margin-left: 25px;"></span>    <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil-alt"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button></li>

		<!-- Divider -->
		<li class="nav-item mt-2"><a class="nav-link" href="/sale/dashboard"><span style="margin-left: 25px;"></span> <i
				class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a></li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading"><span style="margin-left: 15px;"></span>Quản lý bán hàng</div>

		<!-- Nav Item - Employee Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseEmployee"
			aria-expanded="true" aria-controls="collapseTwo"><span style="margin-left: 25px;"></span> <i
				class="fas fa-user-friends"></i> <span>Tác giả</span>
		</a>	<hr class="sidebar-divider">
			<div id="collapseEmployee" class="collapse"
				aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Quản lý tác giả:</h6>
					<a class="collapse-item" href="/sale/authorTable/list">Danh
						Sách</a>
						<a class="collapse-item" href="/sale/authorTable/form">Form</a>
				</div>
			</div></li>

		<!-- Nav Item - Product Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseProduct"
			aria-expanded="true" aria-controls="collapseUtilities"><span style="margin-left: 25px;"></span> <i
				class="fas fa-industry"></i> <span>Sách</span>
		</a>	<hr class="sidebar-divider">
			<div id="collapseProduct" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Quản lý Sách:</h6>
					<a class="collapse-item" href="/sale/bookForm/form">Form
						Sách</a> <a class="collapse-item" href="/sale/bookTable/list">List Book
						</a> <a class="collapse-item" href="/sale/bookCateForm/form">Danh
						Mục</a>
				</div>
			</div></li>

		<!-- Nav Item - Product Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseManu"
			aria-expanded="true" aria-controls="collapseUtilities"><span style="margin-left: 25px;"></span> <i
				class="fas fa-trademark"></i> <span>Nhà xuất bản</span>
		</a>	<hr class="sidebar-divider">
			<div id="collapseManu" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Quản lý NXB:</h6>
					<a class="collapse-item" href="/sale/publisherForm/form">Form
						NXB</a> <a class="collapse-item" href="/sale/publisherTable/list">Danh
						Sách</a>
				</div>
			</div></li>

		<!-- Nav Item - Product Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseCate"
			aria-expanded="true" aria-controls="collapseUtilities"><span style="margin-left: 25px;"></span> <i
				class="fab fa-product-hunt"></i> <span>Thể loại</span>
		</a>	<hr class="sidebar-divider">
			<div id="collapseCate" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Quản lý thể loại:</h6>
					<a class="collapse-item" href="/sale/categoryForm/form">Form
						Thể loại</a> <a class="collapse-item" href="/sale/categoryTable/list">Danh
						Sách</a>
				</div>
			</div></li>

		<!-- Nav Item - User Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseUser"
			aria-expanded="true" aria-controls="collapseUtilities"><span style="margin-left: 25px;"></span> <i
				class="fas fa-user"></i> <span>Bình luận</span>
		</a>	<hr class="sidebar-divider">
			<div id="collapseUser" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Quản lý Bình luận:</h6>
					<a class="collapse-item" href="/sale/feedBackForm/form">Form Bình Luận
					</a> <a class="collapse-item" href="/sale/feedBackTable/list">Danh
						Sách</a>
				</div>
			</div></li>

		<!-- Nav Item - User Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseOrder"
			aria-expanded="true" aria-controls="collapseUtilities"><span style="margin-left: 25px;"></span> <i
				class="fas fa-user"></i> <span>Đơn hàng</span>
		</a>	<hr class="sidebar-divider">
			<div id="collapseOrder" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Quản lý đơn hàng:</h6>
					<a class="collapse-item" href="/sale/order/wait">Đang chờ</a> <a
						class="collapse-item" href="/sale/order/send">Đã giao</a>
				</div>
			</div></li>

		<!-- Nav Item - Product Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseSize"
			aria-expanded="true" aria-controls="collapseUtilities"><span style="margin-left: 25px;"></span> <i
				class="fas fa-circle-notch"></i> <span>Khác</span>
		</a>	
			<div id="collapseSize" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Quản lý </h6>
					<a class="collapse-item" href="#">Form</a>
					<h6 class="collapse-header">Quản lý </h6>
					<a class="collapse-item" href="#">Form</a>
				</div>
			</div></li>


		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading"><span style="margin-left: 15px;"></span>Thống Kê</div>

		<!-- Nav Item - Product Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseStatisFavorite"
			aria-expanded="true" aria-controls="collapseUtilities"><span style="margin-left: 25px;"></span> <i
				class="fas fa-circle-notch"></i> <span>Sản Phẩm</span>
		</a>	<hr class="sidebar-divider">
			<div id="collapseStatisFavorite" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Thống kê Sản phẩm</h6>
					<a class="collapse-item" href="/sale/statis/favorite">Yêu Thích</a>					
					<a class="collapse-item" href="/sale/statis/order">Đơn Hàng</a>
				</div>
			</div></li>

		<!-- Nav Item - Charts -->
		<!-- <li class="nav-item"><a class="nav-link" href="charts.html">
				<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
		</a></li> -->

		<!-- Nav Item - Tables -->
		<!-- <li class="nav-item"><a class="nav-link" href="tables.html">
				<i class="fas fa-fw fa-table"></i> <span>Tables</span>
		</a></li> -->

		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">

		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>
	</ul>
	<!-- End of Sidebar -->
