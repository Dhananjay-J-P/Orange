package orange.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import orange.user.impl.User;

@Component("loginValidator")
public class LoginValidator implements Validator {

	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
	
		ValidationUtils.rejectIfEmpty(errors, "username", "error.username");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password");
	}
	
	

}
