package my.util.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A common validator based on javax.validation
 * Created by eric on 5/24/19.
 */
public class BeanValidator {
    private static final Logger logger = LoggerFactory.getLogger(BeanValidator.class);

    private Validator validator;

    public BeanValidator(){
        this.validator = ValidatorUtil.getValidator();
    }

    /**
     * Return a set that contains constraint violation, if the size of this set is 0, that mean the bean is matching.
     * @param request, a bean based javax.validator constraint
     * @return
     */
    public <T> BeanValidatedResult validate(T request){
        BeanValidatedResult result = new BeanValidatedResult();
        List<ValidationMessage> messages = new ArrayList<>();
        result.setMessages(messages);
        if (request == null){
            result.setPassed(false);
            ValidationMessage m = new ValidationMessage();
            m.setId("No Valid");
            m.setMessage("Not valid request.");
            logger.warn("No request is set to validate");
            messages.add(m);
            return result;
        }
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(request);
        logger.debug("There are {} ConstraintViolations for Request {}"
                , constraintViolations.size(), request.getClass().getName());
        result.setPassed(constraintViolations.size() == 0);
        if (constraintViolations.size() > 0){
            result.setMessages(ValidatorUtil.transform(constraintViolations));
        }
        return result;
    }
}
