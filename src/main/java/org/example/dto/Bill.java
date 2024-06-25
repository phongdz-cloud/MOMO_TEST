package org.example.dto;

import org.example.enumdef.StateEnum;

import java.util.Date;

public class Bill extends IdBase{
    private String type;

    private long amount;

    private Date dueDate;

    private StateEnum state = StateEnum.NOT_PAID;

    private String provider;

    public Bill(int id, String type, long amount, Date dueDate, String provider) {
        super(id);
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
        this.provider = provider;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
