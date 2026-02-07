package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person{
    private String batch;
    private boolean active = true;

    public Student(String fName, String lName, String email){
        super(fName,lName,email);
        this.setId(IdGenerator.getNextStudentId());
    }

    public Student(String fName, String lName){
        super(fName, lName);
        this.setId(IdGenerator.getNextStudentId());
    }
    public Student(){
        super();
        this.setId(IdGenerator.getNextStudentId());

    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    void displayName() {
        System.out.println("The Name of the Student "+this.getId() + " is "+ this.getFirstName() + " "+ this.getLastName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.getId() +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", batch='" + batch + '\'' +
                ", active='" + active +'\''+
                '}';
    }
}
