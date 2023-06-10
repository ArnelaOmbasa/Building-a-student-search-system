package task2;

import task1.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileUtils {

    public static RedBlackTree<Integer, Student> readFile(String filePath) throws FileNotFoundException {
        // implement the actual logic (remove next line)
        RedBlackTree<Integer, Student> tree = new RedBlackTree<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            LocalDate dob = LocalDate.parse(parts[2], dtf);
            String university = parts[3];
            String deptCode = parts[4];
            String deptName = parts[5];
            int enrolYear = Integer.parseInt(parts[6]);
            Student student = new Student(id, name, dob, university, deptCode, deptName, enrolYear);
            tree.put(id, student);

        } return tree;}
}
