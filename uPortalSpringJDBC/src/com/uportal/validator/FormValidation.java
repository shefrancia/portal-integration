package com.uportal.validator;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  


import org.springframework.validation.Errors;  
import org.springframework.validation.ValidationUtils;  
import org.springframework.validation.Validator;  
  


import com.uportal.domain.User;  
  
public class FormValidation implements Validator {  
  
 private Pattern pattern;  
 private Matcher matcher;  
  
 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
 String ID_PATTERN = "[0-9]+";  
 String STRING_PATTERN = "[a-zA-Z\\s]+";  
 String MOBILE_PATTERN = "[0-9]{10}";   
 String ALPHA_NUMERIC = "[A-Za-z0-9]+";
 String NAME_PATTERN = "[A-Za-z0-9\\s]+";
 String PASSWORD_PATTERN = "[A-Za-z0-9\\s\\p{Punct}]+";
  
 @Override  
 public void validate(Object target, Errors errors) {  
  
  User user = (User) target;  

  
  ValidationUtils.rejectIfEmpty(errors, "firstName", "required.firstName",  
    "First name is required.");  
  
  if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {  
   pattern = Pattern.compile(NAME_PATTERN);  
   matcher = pattern.matcher(user.getFirstName());  
   if (!matcher.matches()) {  
    errors.rejectValue("firstName", "firstName.containNonAlphaNumeric",  
      "Enter a valid name");  
   }  
  } 
  
  ValidationUtils.rejectIfEmpty(errors, "lastName", "required.lastName",  
		  "Last name is required.");  
  if (!(user.getLastName() != null && user.getLastName().isEmpty())) {  
	   pattern = Pattern.compile(NAME_PATTERN);  
	   matcher = pattern.matcher(user.getLastName());  
	   if (!matcher.matches()) {  
	    errors.rejectValue("lastName", "lastName.containNonAlphaNumeric",  
	      "Enter a valid name");  
	   }  
	  } 
  
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",  
    "required.email", "Email is required.");  
  
// email validation in spring  
  if (!(user.getEmail() != null && user.getEmail().isEmpty())) {  
   pattern = Pattern.compile(EMAIL_PATTERN);  
   matcher = pattern.matcher(user.getEmail());  
   if (!matcher.matches()) {  
    errors.rejectValue("email", "email.incorrect",  
      "Enter a valid email");  
   }  
  }  
  
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",  
    "required.username", "Username is required.");  
  
// phone number validation  
  if (!(user.getUsername() != null && user.getUsername().isEmpty())) {  
	   pattern = Pattern.compile(ALPHA_NUMERIC);  
	   matcher = pattern.matcher(user.getUsername());  
	   if (!matcher.matches()) {  
	    errors.rejectValue("username", "username.containNonChar",  
	      "Enter a valid username");  
	   }  
	   
	   if (user.getUsername().toString().length() < 8) {  
		    errors.rejectValue("username", "username.exceed",  
		      "Username should be 8 or more characters");  
		   }  
	  } 
  
  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",  
    "required.password", "Password is required.");  
  
  if (!(user.getPassword() != null && user.getPassword().isEmpty())) {  
	   pattern = Pattern.compile(PASSWORD_PATTERN);  
	   matcher = pattern.matcher(user.getPassword());  
	   if (!matcher.matches()) {  
	    errors.rejectValue("password", "password.containNonChar",  
	      "Enter a valid password");  
	   }  
	   
	   if (user.getPassword().toString().length() < 8) {  
		    errors.rejectValue("password", "password.exceed",  
		      "Password should be 8 or more characters");  
		   }  
	  } 
  
// password matching validation  
  if (!user.getPassword().equals(user.getConfirmPassword())) {  
   errors.rejectValue("confirmPassword", "password.mismatch",  
     "Password does not match");  
  }  
 
 }

@Override
public boolean supports(Class<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}
}  
