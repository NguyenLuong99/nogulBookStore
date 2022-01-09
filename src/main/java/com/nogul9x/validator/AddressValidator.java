package com.nogul9x.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nogul9x.model.Address;

@Component
public class AddressValidator implements Validator {
	private EmailValidator emailValidator = EmailValidator.getInstance();

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Address.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Address entity = (Address) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotBlank.addressForm.firstname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotBlank.addressForm.lastname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank.addressForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotBlank.addressForm.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "provincial", "NotBlank.addressForm.provincial");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotBlank.addressForm.address");

		if (!errors.hasFieldErrors("email")) {
			if (!this.emailValidator.isValid(entity.getEmail())) {
				errors.rejectValue("email", "Pattern.addressForm.email");
				System.out.println("ss1");
			}
			System.out.println("ss2");
		}
	}
}
