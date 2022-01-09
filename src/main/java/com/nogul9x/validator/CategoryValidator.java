package com.nogul9x.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nogul9x.model.Category;
@Component
public class CategoryValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Category.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Category entity = (Category) target;
		if(entity.getImage().isEmpty()) {
			errors.rejectValue("image", "NotBlank.manuForm.image");
		}
	}

}
