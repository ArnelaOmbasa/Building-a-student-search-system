package task2;


import task1.Student;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class StudentSearchV2 {

    public static void main(String[] args) {
        // main application logic
        try {
            String filePath = "src/test/resources/students.csv";
            RedBlackTree<Integer, Student> redBlackTree;
            redBlackTree = FileUtils.readFile(filePath);
            System.out.println("Loading the students into tree...");
            System.out.println("The tree was built with " + redBlackTree.countRedLinks() +" red links." );
            System.out.println("============================");
            System.out.println("System is ready. ");

            // Create scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Keep prompting the user to enter a student ID until they enter -1
            while (true) {
                System.out.println("Enter the ID of the student you want to retrieve, or -1 to exit: ");
                int id = scanner.nextInt();
                Student student = redBlackTree.get(id);

                if (id == -1) {
                    System.out.println("Thank you for using the student search system.");
                    break;
                }

                if (student == null) {
                    System.out.println("The student with the requested ID does not exist.");
                    System.out.println("The search was completed in " + redBlackTree.numSteps + " steps.");
                } else {
                    System.out.println("Name and Surname: " + student.name);
                    System.out.println("Date of Birth: " + student.dob);
                    System.out.println("University: " + student.university);
                    System.out.println("Department code: " + student.deptCode);
                    System.out.println("Department: " + student.deptName);
                    System.out.println("Year of Enrollment: " + student.enrolYear);
                    System.out.println("The student was retrieved in " + redBlackTree.numSteps + " steps");
                }

                // Reset the number of steps
                redBlackTree.numSteps = 0;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }


}

