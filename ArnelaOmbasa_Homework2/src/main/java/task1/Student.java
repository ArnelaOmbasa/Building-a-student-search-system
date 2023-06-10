package task1;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
    // implement the relevant student data attributes

    public int id;
    public String name;
    public LocalDate dob;
    public String university;
    public String deptCode;
    public String deptName;
    public int enrolYear;
    public Student(int id, String name, LocalDate dob, String university, String deptCode, String deptName, int enrolYear) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.university = university;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.enrolYear = enrolYear;
    }

    @Override
    public int compareTo(Student o) {

        return Integer.compare(this.id, o.id);

    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", university='" + university + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", enrolYear=" + enrolYear +
                '}';
    }
}
