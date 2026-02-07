package com.airtribe.learntrack.entity;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public Person() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }

    Person(String firstName, String lastName,String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    void displayName(){
        System.out.println("Name of the Person "+this.id + " is " + this.firstName + " " + this.lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
