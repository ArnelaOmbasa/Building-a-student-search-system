package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static Student[] readFile(String filePath) throws FileNotFoundException {
        // implement the actual logic (remove next line)
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        List<Student> students = new ArrayList<>();
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
            students.add(new Student(id, name, dob, university, deptCode, deptName, enrolYear));
        }

        return students.toArray(new Student[0]);
    }

    public static void writeToFile(Student[] students, String filePath) throws IOException {
        // implement the actual logic
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file);
        for (Student s : students) {
            writer.write(s.toString() + "\n");
        }
        writer.close();
    }

}
