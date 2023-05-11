package project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDto {
    @JsonProperty("customer_id")
    private int customerId;
    private String name;
    private Status status;

    // setter
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    // getter
    public int getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public Status getStatus() {
        return status;
    }
}