package my.util.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Get a default validator
 * Created by eric on 5/24/19.
 */
public class ValidatorUtil {
    private static final Logger logger = LoggerFactory.getLogger(ValidatorUtil.class);
    public  static Validator getValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    public static <T> List<ValidationMessage> transform(Set<ConstraintViolation<T>> violations){
        if (violations == null || violations.size() == 0){
            logger.warn("No ConstraintViolation is set to transform.");
            return new ArrayList<>();
        }
        List<ValidationMessage> messages = new ArrayList<>(violations.size());
        violations.stream().forEach(v -> {
            ValidationMessage m = new ValidationMessage();
            m.setId(v.getPropertyPath().toString());
            m.setMessage(v.getMessage());
            messages.add(m);
        });
        return messages;

    }
}
