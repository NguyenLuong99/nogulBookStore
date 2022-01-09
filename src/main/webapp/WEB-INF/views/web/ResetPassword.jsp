<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset-password</title>
</head>
<body>
		<div class="" id="formdangnhap" data-backdrop="static" tabindex="-1"
        aria-labelledby="dangnhap_tieude" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <ul class="tabs d-flex justify-content-around list-unstyled mb-0">
                      
                        <a href="/forgot-password">
                          <li class="tab  text-center">
                            <a class=" ">Reset mật khẩu</a>
                            <hr>
                        </li></a>  
                        <li class="tab  text-center">
                            <a class=" "></a>
                            <hr>
                        </li>          
                    </ul>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                    <form:form  action="" method="post"  id="form-signin" class="form-signin mt-2" modelAttribute="resetPassword" >
                    	<label >Bạn vui lòng nhập lại mật khẩu mới!</label>
                        <div class="form-label-group">
                           <input type="password" class="form-control" placeholder="Nhập mật khẩu mới"  name="password" />    
                            <form:errors path="password" cssClass="error"/>
                        </div>
                        <div class="form-label-group">
                           <input type="password" class="form-control" placeholder="Nhập lại mật khẩu"  name="confirm" />    
                            <form:errors path="confirm" cssClass="error"/>
                        </div>
                        <div class="custom-control custom-checkbox mb-3">
                            <a href="/login" class="float-right text-decoration-none" style="color: #F5A623">Quay lại đăng nhập</a>
                        </div>

                        <button class="btn btn-lg btn-block btn-signin text-uppercase text-white" type="submit"
                            style="background: #F5A623">Lưu</button>
                        <hr class="my-4">
                      
                    </form:form>
                    <div class="form-signin">
                    	                     <a href="https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile&state=profile&redirect_uri=https://localhost:8443/login-google&response_type=code
		&client_id=1085856975235-cgcj8drcfqpt8kgspssjb8h0o185dog6.apps.googleusercontent.com&approval_prompt=force">
								 <button class="btn btn-lg btn-google btn-block text-uppercase mb-2" type="submit"><i
                                class="fab fa-google mr-2"></i> Đăng nhập bằng Google</button>
						</a>
                       <a href="https://www.facebook.com/dialog/oauth?client_id=5181708718512968&redirect_uri=https://localhost:8443/login-facebook">
                          <button class=" btn btn-lg btn-facebook btn-block text-uppercase " type="submit"><i
                                class="fab fa-facebook-f mr-2"></i> Đăng nhập bằng Facebook</button>
                       </a>
                     
                    </div>
       
              
                </div>
            </div>
        </div>
    </div>
</body>
</html>