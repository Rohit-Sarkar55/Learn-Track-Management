package com.airtribe.learntrack.enums;

public enum StudentMenuOption {

    ADD_STUDENT("Add Student"),
    SEARCH_STUDENT_BY_ID("Search Student By Id"),
    VIEW_ALL_STUDENTS("View All Students"),
    REMOVE_STUDENT("Remove Student"),
    BACK("Back");

    private final String displayName;

    StudentMenuOption(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
