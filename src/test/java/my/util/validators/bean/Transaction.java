package my.util.validators.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by eric on 5/27/19.
 */
public class Transaction {
    @NotNull(message = "transId is required.")
    @Length(max=255, message="Field too long, max length of transId is {max}.")
    private String transId;
    private String countryCode = "USA";
    private int timeoutMs = 10000;
    @NotBlank(message = "agentAssociateId is required.")
    private String agentAssociateId;

    public String getAgentAssociateId() {
        return agentAssociateId;
    }

    public void setAgentAssociateId(String agentAssociateId) {
        this.agentAssociateId = agentAssociateId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }
}
