package com.nogul9x.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.model.ChangePassword;
import com.nogul9x.service.SessionService;
import com.nogul9x.service.impl.SessionServiceImpl;


@Component
public class ChangePasswordValidator implements Validator {
	@Autowired
	UserDAO userDao;
	@Autowired
	AccountDAO accountDao;
	@Autowired
	SessionServiceImpl sessionService;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz==ChangePassword.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ChangePassword entity = (ChangePassword) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "NotBlank.changePass.fullname");
		
		if(!entity.getOldPassword().isEmpty()) {
			AccountEntity user= sessionService.get("account");
			System.out.println(user);
			if(passwordEncoder.matches(entity.getOldPassword(), user.getPassword()) == false) {
				errors.rejectValue("oldPassword", "NotDuplicate.changePass.oldPassword");
				System.out.println(1);
			}
			else {
				if(entity.getNewPassword().isEmpty()) {
					errors.rejectValue("newPassword", "NotBlank.changePass.newPassword");
					System.out.println(2);
				}
				else {
					if(entity.getNewPassword().length()<7) {
						errors.rejectValue("newPassword", "Min.changePass.newPassword");
						System.out.println(3);
					}
					if(entity.getNewPassword().length()>15) {
						errors.rejectValue("newPassword", "Max.changePass.newPassword");
						System.out.println(4);
					}
				}
				if(entity.getConfirm().isEmpty()) {
					errors.rejectValue("confirm", "NotBlank.changePass.confirm");
					System.out.println(5);
				}
				if((!entity.getNewPassword().isEmpty())&&(!entity.getConfirm().isEmpty())) {
					if(!entity.getNewPassword().equals(entity.getConfirm())) {
						errors.rejectValue("confirm", "NotDuplicate.changePass.confirm");
						System.out.println(6);
					}
				}
			}
		}
	}
}
