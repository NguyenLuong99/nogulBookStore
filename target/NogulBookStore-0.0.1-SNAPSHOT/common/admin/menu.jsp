<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
    <li class="">
						<a href="/admin/dashboard">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>

						<b class="arrow"></b>
					</li>
    
        <li class="">
            <a href="#" class="dropdown-toggle">
              <i class="menu-icon fa fa-user"></i>
                <span class="menu-text">QL Nhân viên</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='/admin/employeeForm'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Forn Nhân vien
                    </a>
                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href='/admin/employeeTable/list'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS Nhân Viên
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-users"></i>
                <span class="menu-text">QL Khách hàng</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='#'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Form Khách hàng
                    </a>
                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href='/admin/customerTable/list'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS Khách hàng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
         <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fas fa-signal"></i>
                <span class="menu-text">Xem thống kê</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='/admin/statisBook'>
                        <i class="menu-icon fa fa-caret-right"></i>
                     Thống kê sản phẩm
                    </a>
                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href='/admin/statis'>
                        <i class="menu-icon fa fa-caret-right"></i>
                      Thống kê doanh thu
                    </a>
                    <b class="arrow"></b>
                </li>
                  <li class="">
                    <a href='#'>
                        <i class="menu-icon fa fa-caret-right"></i>
                      Thống kê khách hàng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <li class="">
						<a href="/admin/calendar">
							<i class="menu-icon fa fa-calendar"></i>

							<span class="menu-text">
								Lịch

								<span class="badge badge-transparent tooltip-error" title="2 Important Events">
									<i class="ace-icon fa fa-exclamation-triangle red bigger-130"></i>
								</span>
							</span>
						</a>

						<b class="arrow"></b>
					</li>
          <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-newspaper-o"></i>
                <span class="menu-text">QL bài viết</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href='#'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS bài viết series
                    </a>
                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href='#'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS bài viết con
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
    </script>
</div>