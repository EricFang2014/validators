package my.util.validators;

import java.util.List;

/**
 * Result for validated bean
 * Created by eric on 5/27/19.
 */
public class BeanValidatedResult {
    private String beanUniqueId;

    public String getBeanUniqueId() {
        return beanUniqueId;
    }

    public void setBeanUniqueId(String beanUniqueId) {
        this.beanUniqueId = beanUniqueId;
    }

    private boolean passed;
    private List<ValidationMessage> messages;

    public List<ValidationMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ValidationMessage> messages) {
        this.messages = messages;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
