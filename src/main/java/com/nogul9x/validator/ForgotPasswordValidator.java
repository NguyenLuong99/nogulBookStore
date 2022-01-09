package com.nogul9x.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nogul9x.dao.AccountDAO;
import com.nogul9x.entity.AccountEntity;
import com.nogul9x.model.ForgotPassword;
@Component
public class ForgotPasswordValidator implements Validator {
	@Autowired
	AccountDAO accountDao;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == ForgotPassword.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
	ForgotPassword entity = (ForgotPassword) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank.forgotPassword.email");
	
		if(!errors.hasFieldErrors()) {
			AccountEntity account = accountDao.findByEmail(entity.getEmail());
		
			if(account == null) {
				errors.rejectValue("email", "NotFind.forgotPassword.email");
			}
		}
	}
}
