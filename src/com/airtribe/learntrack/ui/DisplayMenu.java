package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.enums.MenuOption;
import com.airtribe.learntrack.enums.StudentMenuOption;


public class DisplayMenu {
    public static void mainMenu(){
        System.out.println(">>>>>>>>>> "+  AppConstants.APPLICATION_NAME + " <<<<<<<<<<");
        System.out.println("Press 1: " + MenuOption.STUDENT_MANAGER);
        System.out.println("Press 2: " + MenuOption.COURSE_MANAGER);
        System.out.println("Press 3: " + MenuOption.ENROLLMENT_MANAGER);
        System.out.println("Press 4: " + MenuOption.QUIT);

        System.out.println("---------------------------------------------------------");
    }

    public static void studentMenu(){
        System.out.println(">>>>>>>>>> "+  MenuOption.STUDENT_MANAGER + " <<<<<<<<<<");
        System.out.println("Press 1: " + StudentMenuOption.ADD_STUDENT);
        System.out.println("Press 2: " + StudentMenuOption.REMOVE_STUDENT);
        System.out.println("Press 3: " + StudentMenuOption.SEARCH_STUDENT_BY_ID);
        System.out.println("Press 4: " + StudentMenuOption.VIEW_ALL_STUDENTS);
        System.out.println("Press 5: " + StudentMenuOption.BACK);
    }
}
