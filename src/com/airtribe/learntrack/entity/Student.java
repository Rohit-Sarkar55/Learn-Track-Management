package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person{
    private String email;

    public Student(String fName, String lName, String email){
        super(fName,lName);
        this.email = email;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", email='" + this.email + '\'' +
                '}';
    }
}
