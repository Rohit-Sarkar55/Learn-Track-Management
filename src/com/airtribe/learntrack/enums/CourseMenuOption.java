package com.airtribe.learntrack.enums;

public enum CourseMenuOption {

    ADD_COURSE("Add Course"),
    DEACTIVATE_COURSE("Deactivate Course"),
    VIEW_ALL_COURSES("View All Courses"),
    BACK("Back");

    private final String displayName;

    CourseMenuOption(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
