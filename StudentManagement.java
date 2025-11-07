import java.util.*;

// Provides static methods for managing student records.
// Uses private static variables for storing all students and the total count.
public class StudentManagement {
    private static Map<String, Student> students = new HashMap<>();
    private static int totalStudents = 0;

    // Adds a new student if the ID does not already exist.
    public static boolean addStudent(Student s) {
        if (s == null || s.getId() == null || s.getId().isBlank()) return false;
        if (students.containsKey(s.getId())) return false;
        students.put(s.getId(), s);
        totalStudents++;
        return true;
    }

    // Updates an existing student by ID.
    // Fields remain unchanged if parameters are null or blank.
    public static boolean updateStudent(String id, String name, Integer age, String grade) {
        Student target = students.get(id);
        if (target == null) return false;

        if (name != null && !name.isBlank()) target.setName(name);
        if (age != null) {
            if (age >= 3 && age <= 120) {
                target.setAge(age);
            } else {
                return false;
            }
        }
        if (grade != null && !grade.isBlank()) target.setGrade(grade);
        return true;
    }

    // Retrieves a student record by ID, wrapped in Optional.
    public static Optional<Student> getStudent(String id) {
        return Optional.ofNullable(students.get(id));
    }

    // Returns a list of all students for display purposes.
    public static List<Student> listStudents() {
        return new ArrayList<>(students.values());
    }

    // Returns the total number of students stored.
    public static int getTotalStudents() {
        return totalStudents;
    }
}
