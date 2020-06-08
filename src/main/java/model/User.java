package model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.*;
import java.util.Set;


public class User implements Validator {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @Min(18)
    private int age;


    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        String phoneNumber = user.getPhone();

        ValidationUtils.rejectIfEmpty(errors, "phone", "number.empty");

        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
            errors.rejectValue("phone", "number.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phone", "number.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phone", "number.matches");
        }
    }
}
