<%@ page language="java" contentType="text/html; charset=UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact -us</title>
<script type='text/javascript' src='<c:url value="/template/web/js/jquery.min.js" />'></script>
</head>
<body>

        <!-- start page title section -->
       <section class="">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 sm-margin-25px-bottom">
                    <div class="padding-30px-all sm-padding-25px-all xs-padding-20px-all bg-light-gray text-center">
                        <i class="far fa-envelope" ></i>
                        <h5 class="margin-5px-bottom margin-20px-top sm-margin-15px-top font-size20 xs-font-size18">Email Us:</h5>
                        <p class="no-margin-bottom">1buinguyenluong1999@gmail.com</p>
                    </div>
                </div>
                <div class="col-lg-4 sm-margin-25px-bottom">
                    <div class="padding-30px-all sm-padding-25px-all xs-padding-20px-all bg-light-gray text-center">
                        <i class="fas fa-phone font-size40 sm-font-size38 xs-font-size34 text-theme-color"></i>
                        <h5 class="margin-5px-bottom margin-20px-top sm-margin-15px-top font-size20 xs-font-size18">Call Us:</h5>
                        <p class="no-margin-bottom">(+84) 396911849 </p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="padding-30px-all sm-padding-25px-all xs-padding-20px-all bg-light-gray text-center">
                        <i class="fas fa-map-marker-alt font-size40 sm-font-size38 xs-font-size34 text-theme-color"></i>
                        <h5 class="margin-5px-bottom margin-20px-top sm-margin-15px-top font-size20 xs-font-size18">Our Address:</h5>
                        <p class="no-margin-bottom">x2 - Dang Son - Do Luong - Nghe An</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- end contact-info section -->

    <!-- start form section -->
    <section class="no-padding-top">
        <div class="container">
            <div class="padding-40px-all sm-padding-30px-all xs-padding-20px-all bg-light-gray">
                <h2 class="font-size38 sm-font-size34 xs-font-size28 line-height-45 sm-line-height-40 font-weight-500 margin-10px-bottom text-center">Contact Us</h2>
                <p class="margin-50px-bottom sm-margin-30px-bottom xs-margin-25px-bottom width-60 md-width-70 sm-width-auto center-col text-center">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ainim veniam.</p>
                <form action="/contact" modelAtrribute="Message" method="post">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Name</label>
                                <input id="name" name="name" type="text" class="no-margin-bottom">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Email</label>
                                <input id="email" type="email" name="email" class="no-margin-bottom">
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label>Subject</label>
                                <input id="subject" type="text" name="title" class="no-margin-bottom">
                            </div>
                        </div>
                        <div class="col-lg-12 margin-20px-bottom sm-margin-10px-bottom">
                            <div class="form-group">
                                <label>Message</label>
                                <textarea id="text" name="content" class="form-control line-height-70"></textarea>
                            </div>
                        </div>
                        <div class="col-lg-12">
                                <button type="submit" class="btn btn-primary">Send Message</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7549.362154145282!2d105.28815212476275!3d18.901224470294462!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3139e23e38a70293%3A0x76e7f5f9cd432bc1!2zQ-G6p3UgxJDDtCBMxrDGoW5nLCBQaMO6IE5odeG6rW4sIMSQ4bq3bmcgU8ahbiwgxJDDtCBMxrDGoW5nLCBOZ2jhu4cgQW4sIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1637640086918!5m2!1svi!2s" width="100%" height="400" style="border:0;" allowfullscreen="" loading="lazy"></iframe>

</body>
</html>