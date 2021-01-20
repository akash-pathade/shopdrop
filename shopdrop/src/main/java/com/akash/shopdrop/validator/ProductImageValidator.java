package com.akash.shopdrop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.akash.shopdropbackend.dto.Product;

public class ProductImageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		
		//Null and blank field check
		if(product.getFile()==null ||
				product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null,"Please select an Image file to upload");
			return;
		}
		
		//Image type check
		if(!(product.getFile().getContentType().equals("image/jpeg") ||
			product.getFile().getContentType().equals("image/png") ||
			product.getFile().getContentType().equals("image/gif") ||
			product.getFile().getContentType().equals("image/jpg"))) {
			
			errors.rejectValue("file", null,"Unsupported format!! Select from (jpeg,png,gif,jpg)");
			
		}

	}

}
