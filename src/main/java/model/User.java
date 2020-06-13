package model;

import javax.validation.constraints.*;


public class User {

    @NotNull(message = "Name cannot be empty")
    @Size(min = 2, max = 30
            , message = "Name must be within {min} and {max} characters")
    private String name;

    @Min(value = 18, message = "Age must be older than {value}")
    @NotNull(message = "Name cannot be empty")
    private int age;

    @NotNull(message = "{number.empty}")
    @Size(min = 10, max = 11,
            message ="Phone numbers must be between {min} and {max} numbers")
    @Pattern(regexp = "^0\\d*", message = "{number.startsWith}")
    @Pattern(regexp = "(^$|[0-9]*$)", message = "{number.matches}")
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
}
