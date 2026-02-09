package com.airtribe.learntrack.enums;

public enum MenuOption {
    STUDENT_MANAGER("Student Manager"),
    COURSE_MANAGER("Course Manager"),
    ENROLLMENT_MANAGER("Enrollment Manager"),
    QUIT("Quit");

    private final String displayName;

    MenuOption(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
