package com.example.cablenetwork;

public class Payment {

     String name;
     String email;
     String ph;
     String amount;
     String pmethod;
     String tranid;

    public Payment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTranid() {
        return tranid;
    }

    public void setTranid(String tranid) {
        this.tranid = tranid;
    }

    public String getPmethod() {
        return pmethod;
    }

    public void setPmethod(String pmethod) {
        this.pmethod = pmethod;
    }

}
