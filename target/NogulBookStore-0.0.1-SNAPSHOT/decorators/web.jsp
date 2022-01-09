<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
 <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <title><dec:title/></title>
    <meta name="description"
        content="Mua sách online hay, giá tốt nhất, combo sách hot bán chạy, giảm giá cực khủng cùng với những ưu đãi như miễn phí giao hàng, quà tặng miễn phí, đổi trả nhanh chóng. Đa dạng sản phẩm, đáp ứng mọi nhu cầu.">
    <meta name="keywords" content="nhà sách online, mua sách hay, sách hot, sách bán chạy, sách giảm giá nhiều">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<c:url value='/template/web/css/home.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/template/web/css/product-item.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/template/web/js/owlcarousel/assets/owl.carousel.min.css' />"/>
  <script type="text/javascript" src="<c:url value='/template/web/js/owlcarousel/owl.carousel.min.js'/>"/></script>
    <script type="text/javascript" src="<c:url value='/template/web/js/main.js'/>"/></script>
     <script type="text/javascript" src="<c:url value='/template/web/js/quality.js'/>"/></script>
    <link rel="stylesheet" href="<c:url value='/template/web/fontawesome_free_5.13.0/css/all.css'/>"/>

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap"
        rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/slick/slick.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/slick/slick-theme.css'/>" />
    <script type="text/javascript" src="<c:url value='/template/web/slick/slick.min.js'/>"/></script>
    <script type="text/javascript"
        src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
    <link rel="canonical" href="http://dealbook.xyz/">
    <meta name="google-site-verification" content="urDZLDaX8wQZ_-x8ztGIyHqwUQh2KRHvH9FhfoGtiEw" />
    <link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/template/web/favicon_io/apple-touch-icon.png' />" />
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/template/web/favicon_io/favicon-32x32.png' />" />
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/template/web/favicon_io/favicon-16x16.png' />"/>
    <link rel="manifest" href="<c:url value='/template/web/favicon_io/site.webmanifest'/>"/>

    <style>img[alt="www.000webhost.com"]{display: none;}</style>
</head>
<body>
    <!-- start page loading -->
    <div id="preloader">
        <div class="row loader">
            <div class="loader-icon"></div>
        </div>
    </div>
    <!-- end page loading -->

    <!-- start main-wrapper section -->
    <div class="main-wrapper">

        <!-- start header section -->
<%@ include file="/common/web/header.jsp" %>
<dec:body/>
<%@ include file="/common/web/footer.jsp" %> 
	<!-- start scroll to top -->
	    </div>
<script type="text/javascript">
function myFunction() {
	  let text = "Nhấn ok để nhận mail thông báo nếu không cancel";
	  if (confirm(text) == true) {
		  window.location="/mailNotif";
	  } else {
		  window.location="/faq";
	  }
	
	}
function sendCode() {
	  let text = "Nhấn ok để nhận mã xác nhận";
	  if (confirm(text) == true) {
		  window.location="/register/mailSender";
	  } else {
		  window.location="/register";
	  }
	
	}
</script>
</body>
</html>