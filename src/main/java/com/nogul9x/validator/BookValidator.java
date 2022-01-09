package com.nogul9x.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nogul9x.model.Book;

@Component
public class BookValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Book.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Book entity = (Book) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotBlank.productForm.name");

		
//		if(entity.getManuDay().isEmpty()) {
//			errors.rejectValue("manuDay", "NotBlank.productForm.manuDay");
//		}
		
		if(entity.getPrice() == 0) {
			errors.rejectValue("price", "NotBlank.productForm.price");
		}
		
		if(entity.getImgBook().isEmpty()) {
			System.out.println("sai");
			errors.rejectValue("image", "NotBlank.productForm.image");			
		}
	}
}
