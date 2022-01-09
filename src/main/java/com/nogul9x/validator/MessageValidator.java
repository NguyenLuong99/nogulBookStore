package com.nogul9x.validator;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nogul9x.model.Book;
import com.nogul9x.model.Message;
@Component
public class MessageValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Message.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Message entity = (Message) target;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotBlank.productForm.name");

		
//		if(entity.getManuDay().isEmpty()) {
//			errors.rejectValue("manuDay", "NotBlank.productForm.manuDay");
//		}
		
		if(entity.getEmail().isEmpty()) {
			System.out.println("sai");
			errors.rejectValue("image", "NotBlank.productForm.image");			
		}
	}

}
