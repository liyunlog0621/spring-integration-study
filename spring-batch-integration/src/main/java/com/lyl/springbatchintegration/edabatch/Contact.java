package com.lyl.springbatchintegration.edabatch;

/**
 * ClassName Contact
 * Author liyunlong
 * Data 下午 4:01
 * Version 1.0
 **/
public class Contact {


    private long id;

    private String fullName, email;

    private boolean validEmail;

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", validEmail=" + validEmail +
                '}';
    }

    public Contact(String fullName, String email, boolean validEmail, long id) {
        this.fullName = fullName;
        this.email = email;
        this.validEmail = validEmail;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValidEmail() {
        return validEmail;
    }

    public void setValidEmail(boolean validEmail) {
        this.validEmail = validEmail;
    }
}
