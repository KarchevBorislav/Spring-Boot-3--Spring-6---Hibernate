package firstspringprojects.mvc.validationdemo.validaion;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;


    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();

    }

    @Override
    public boolean isValid(String inputCode, ConstraintValidatorContext constraintValidatorContext) {


        boolean result;
        if (inputCode != null) {

            result = inputCode.startsWith(coursePrefix);
        } else {
            result = true;
        }


        return result;
    }


}
