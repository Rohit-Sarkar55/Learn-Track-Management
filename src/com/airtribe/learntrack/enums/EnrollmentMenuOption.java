package com.airtribe.learntrack.enums;

public enum EnrollmentMenuOption {

    MAKE_ENROLLMENT("Make an enrollment"),
    VIEW_ENROLLMENT_FOR_A_STUDENT("View enrollments for a student"),
    COMPLETE_ENROLLMENT("Complete an enrollment"),
    CANCEL_ENROLLMENT("Cancel an enrollment"),
    BACK("Back");

    private final String displayName;

    EnrollmentMenuOption(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
