package firstspringprojects.mvc.validationdemo;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public class Customer {



    private String firstName;

    @NotNull(message = "field cant be empty")
    @Size(min = 1 ,message = "field cant be empty")
    private String lastName;

    @NotNull(message = "field is required")
    @Min(value = 0,message = "value must be greater than or equal to zero")
    @Max(value = 15 , message = "value must be lesser than or equal to 15")

    private  Integer freePasses;

   @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "have to be only 5 chars/digits")
    private String  postalCode;



    public Customer() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "have to be only 5 chars/digits") String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "have to be only 5 chars/digits") String postalCode) {
        this.postalCode = postalCode;
    }
}
