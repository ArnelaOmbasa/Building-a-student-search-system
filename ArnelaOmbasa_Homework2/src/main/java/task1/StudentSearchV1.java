package task1;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class StudentSearchV1 {

    public static void main(String[] args) {

        // main application logic
        try {
            System.out.println("Loading the students...");
            System.out.println("Sorting the student array...");
            System.out.println("Saving the sorted file...");
            System.out.println("=============================");
            System.out.println("System is ready. ");
            // Load the unsorted file into an array
            Student[] students = FileUtils.readFile("src/test/resources/students.csv");

            // Sort the students array using merge sort

            //Sorting by id without Comparator
            MergeSort.sort(students);

            //Sorting by student name
            // MergeSort.sort(students,new MergeSort.NameComparator());

            //Sorting by student dob
            //MergeSort.sort(students,new MergeSort.DobComparator());

            //Sorting by student department name
            //MergeSort.sort(students,new MergeSort.DeptNameComparator());

            //Sorting by student department code
            //MergeSort.sort(students,new MergeSort.DeptCodeComparator());

            //Sorting by student university
            //MergeSort.sort(students,new MergeSort.UniversityComparator());

            //Sorting by student enrollment year
            //MergeSort.sort(students,new MergeSort.EnrolYearComparator());


            // Write the sorted array to a new CSV file
            FileUtils.writeToFile(students, "src/test/resources/sorted_students.csv");

            // Create a Scanner for reading input
            Scanner scanner = new Scanner(System.in);

            // Keep prompting the user to enter a student ID until they enter -1
            while (true) {
                System.out.println("Enter the ID of the student you want to retrieve, or -1 to exit: ");
                int id = scanner.nextInt();

                if (id == -1) {
                    System.out.println("Thank you for using the student search system.");
                    break;
                }

                // Perform the binary search
                int index = BinarySearch.search(students, id);

                // Print the result
                if (index != -1) {
                    Student student = students[index];

                    System.out.println("Student ID: " + student.id);
                    System.out.println("Name and Surname: " + student.name);
                    System.out.println("Date of Birth: " + student.dob);
                    System.out.println("University: " + student.university);
                    System.out.println("Department code: " + student.deptCode);
                    System.out.println("Department: " + student.deptName);
                    System.out.println("Year of Enrollment: " + student.enrolYear);
                    System.out.println("The student was retrieved in " + BinarySearch.numSteps + "steps");
                } else {
                    System.out.println("The student with the requested ID does not exist.");
                    System.out.println("The search was completed in "  + BinarySearch.numSteps + " steps.");
                }

                // Reset the number of steps
                BinarySearch.numSteps = 0;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

