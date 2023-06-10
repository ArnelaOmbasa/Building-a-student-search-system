package task1;
import java.util.Comparator;

public class MergeSort {

    public static void sort(Student[] students /*, Comparator<Student> comparator*/) {

        Student [] aux = new Student [students.length];
        sort(students, aux, 0, students.length - 1/*, comparator*/);

    }
    private static void merge(Student[] students, Student[] aux, int low, int mid, int high/*, Comparator<Student> comparator*/) {
        for(int k = low; k<= high; k++) {
            aux[k] = students[k];
        }
        int i = low;
        int j = mid + 1;
        for(int k = low; k<=high; k++) {
            if(i>mid) students[k] = aux[j++];
            else if(j > high) students[k] = aux[i++];
                //by id
            else if(less(aux[j], aux[i])) students[k] = aux[j++];
                //using comparator
                //else if(comparator.compare(aux[j], aux[i]) < 0) students[k] = aux[j++];
            else students[k] = aux[i++];

        }
    }
    private static void sort(Student [] students, Student [] aux, int low, int high /*, Comparator<Student> comparator*/) {
        if(high<=low) return;
        int mid = low + (high - low) / 2;
        sort(students, aux, low, mid/*,comparator*/);
        sort(students, aux, mid + 1, high/*,comparator*/);
        merge(students, aux, low, mid, high/*,comparator*/);
    }
    public static boolean less(Student v, Student w) {
        if(v.compareTo(w) == 1) return false;
        return true;
    }

    //optional task

    public static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }

    public class DobComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.dob.compareTo(s2.dob);
        }
    }

    public class UniversityComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.university.compareTo(s2.university);
        }
    }

    public class DeptCodeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.deptCode.compareTo(s2.deptCode);
        }
    }

    public class DeptNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.deptName.compareTo(s2.deptName);
        }
    }

    public class EnrolYearComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.enrolYear, s2.enrolYear);
        }

    }}
