<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="" id="formdangnhap" data-backdrop="static" tabindex="-1"
        aria-labelledby="dangnhap_tieude" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <ul class="tabs d-flex justify-content-around list-unstyled mb-0">
                      
                        <a href="/login">
                          <li class="tab  text-center">
                            <a class=" ">Đăng nhập</a>
                            <hr>
                        </li></a>
                        <a href="/register">
                         <li class="tab  text-center">
                            <a href ="/register"class="">Đăng ký</a>
                            <hr>
                        </li></a>
                        
                    </ul>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form:form  action="/login" method="post"  id="form-signin" class="form-signin mt-2" modelAttribute="LoginUser" >
                        <div class="form-label-group">
                            <form:input type="email" class="form-control" placeholder="Nhập địa chỉ email"  name="username" path="username"
                                />
                                 <form:errors path="username" cssClass="error"/>
                        </div>

                        <div class="form-label-group">
                            <input type="password" class="form-control" placeholder="Mật khẩu"  name="password" />
                      
                            <form:errors path="password" cssClass="error"/>
                        </div>

                        <div class="custom-control custom-checkbox mb-3">
                            <input type="checkbox" class="custom-control-input" path="remember" id="customCheck1" />
                            <label class="custom-control-label" for="customCheck1">Nhớ mật khẩu</label>
                            <a href="/forgot-password" class="float-right text-decoration-none" style="color: #F5A623">Quên mật
                                khẩu</a>
                        </div>

                        <button class="btn btn-lg btn-block btn-signin text-uppercase text-white" type="submit"
                            style="background: #F5A623">Đăng nhập</button>
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
    