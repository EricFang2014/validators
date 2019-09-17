package my.util.validators.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by eric on 5/27/19.
 */
public class Item {
    private String echoKey;
    @NotBlank(message = "ActionFlag is required.")
    @Length(max=1, message="ActionFlag should C, U or D.")
    private String actionFlag;


    @Length(max=50, message="Field too long, max length of FirstName is {max}.")
    @NotBlank(message = "FistName is required.")
    private String firstName;
    @Length(max=50, message="Field too long, max length of LastName is {max}.")
    private String lastName;

    public String getActionFlag() {
        return actionFlag;
    }

    public void setActionFlag(String actionFlag) {
        this.actionFlag = actionFlag;
    }

    public String getEchoKey() {
        return echoKey;
    }

    public void setEchoKey(String echoKey) {
        this.echoKey = echoKey;
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
}
