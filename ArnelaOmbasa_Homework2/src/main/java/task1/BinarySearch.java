package task1;

public class BinarySearch {
    // track the number of iterations needed for a search to complete
    public static int numSteps = 0;


    public static int search(Student[] students, int key) {
        // implement the actual logic (remove next line)
        int left = 0;
        int right = students.length - 1;
        while (left <= right) {
            numSteps++;
            int middle = (left + right) / 2;
            if (students[middle].id == key) {
                return middle;
            } else if (students[middle].id < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
