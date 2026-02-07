package com.airtribe.learntrack.util;

public final class IdGenerator {
    private static int studentIdCounter = 0;
    private static int courseIdCounter = 100;

    public static int getNextStudentId(){
        return ++studentIdCounter;
    }
    public static int getNextCourseId(){
        return ++courseIdCounter;
    }
}
