package com.airtribe.learntrack.entity;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;

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


    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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
                '}';
    }
}
