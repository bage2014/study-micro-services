package com.bage.study.micro.services.h2.domain;


public class Customer {
	
    private long id;
    private String firstName, lastName;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Customer(long id, String firstName, String lastName) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    // getters & setters omitted for brevity
}
