package com.nogul9x.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nogul9x.model.Author;

@Component
public class AuthorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Author.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Author entity = (Author) target;
		if(entity.getImage().isEmpty()) {
			errors.rejectValue("code", "NotBlank.manuForm.image");
		}
	}

}
