package com.nogul9x.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.dao.UserDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.model.RegisterUser;



@Component
public class RegisterFormValidator implements Validator{
	@Autowired
	UserDAO userDao;
	@Autowired
	AccountDAO accountDao;
	private EmailValidator emailValidator = EmailValidator.getInstance();
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == RegisterUser.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		RegisterUser entity = (RegisterUser)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank.userRegister.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotBlank.userRegister.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotBlank.userRegister.code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm", "NotBlank.userRegister.confirm");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotBlank.userRegister.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotBlank.userRegister.lastName");
		if(!this.emailValidator.isValid(entity.getEmail())) {
			errors.rejectValue("email", "Pattern.userRegister.email");
			System.out.println("sai1");
		}
		
		if(!errors.hasFieldErrors("email")) {
			AccountEntity account = accountDao.findByEmail(entity.getEmail());
			System.out.println(account);
			if(account != null) {
				errors.rejectValue("email", "Duplicate.userRegister.email");
			}
			
		}
		
		if(!errors.hasFieldErrors("password")) {
			if(entity.getPassword().length()<7) {
				errors.rejectValue("password", "Min.userRegister.password");
				System.out.println("sai3");
			}
			if(entity.getPassword().length()>15) {
				errors.rejectValue("password", "Max.userRegister.password");
				System.out.println("sai4");
			}
		}
		
		if(!errors.hasFieldErrors("confirm")) {
			if(entity.getPassword().equals(entity.getConfirm()) == false) {
				errors.rejectValue("confirm", "NotDuplicate.userRegister.password");
				System.out.println("sai5");
			}
		}
	}

}
