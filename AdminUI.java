import java.util.*;

// Provides the administrator interface through a console-based menu.
// Handles input, calls StudentManagement methods, and displays results.
public class AdminUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": handleAdd(sc); break;
                case "2": handleUpdate(sc); break;
                case "3": handleView(sc); break;
                case "4": handleList(); break;
                case "0":
                    running = false;
                    System.out.println("Bye.");
                    break;
                default:
                    System.out.println("Please choose a valid option.");
            }
        }
        sc.close();
    }

    // Prints the main menu
    private static void printMenu() {
        System.out.println("\n=== Student Record Management ===");
        System.out.println("1) Add new student");
        System.out.println("2) Update student information");
        System.out.println("3) View student details");
        System.out.println("4) List all students");
        System.out.println("0) Exit");
        System.out.print("Select: ");
    }

    // Handles adding a new student with input validation
    private static void handleAdd(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine().trim();
        if (id.isBlank()) { System.out.println("ID cannot be blank."); return; }

        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();
        if (name.isBlank()) { System.out.println("Name cannot be blank."); return; }

        Integer age = readAge(sc);
        if (age == null) return;

        System.out.print("Enter grade: ");
        String grade = sc.nextLine().trim();
        if (grade.isBlank()) { System.out.println("Grade cannot be blank."); return; }

        Student s = new Student(id, name, age, grade);
        boolean ok = StudentManagement.addStudent(s);
        if (ok) {
            System.out.println("Added student: " + id);
        } else {
            System.out.println("Could not add student. The ID may already exist or input was invalid.");
        }
    }

    // Handles updating an existing student
    private static void handleUpdate(Scanner sc) {
        System.out.print("Enter ID to update: ");
        String id = sc.nextLine().trim();
        if (id.isBlank()) { System.out.println("ID cannot be blank."); return; }

        System.out.print("Enter new name (or press Enter to keep): ");
        String name = sc.nextLine();
        if (name != null && name.isBlank()) name = null;

        System.out.print("Enter new age (or press Enter to keep): ");
        String ageStr = sc.nextLine().trim();
        Integer age = null;
        if (!ageStr.isBlank()) {
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid age. Update cancelled.");
                return;
            }
        }

        System.out.print("Enter new grade (or press Enter to keep): ");
        String grade = sc.nextLine();
        if (grade != null && grade.isBlank()) grade = null;

        boolean ok = StudentManagement.updateStudent(id, name, age, grade);
        if (ok) {
            System.out.println("Updated student: " + id);
        } else {
            System.out.println("Update failed. Check that the ID exists and inputs are valid.");
        }
    }

    // Handles viewing a student by ID
    private static void handleView(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine().trim();
        if (id.isBlank()) { System.out.println("ID cannot be blank."); return; }

        var opt = StudentManagement.getStudent(id);
        if (opt.isPresent()) {
            System.out.println(opt.get());
        } else {
            System.out.println("Student ID not found.");
        }
    }

    // Handles listing all students
    private static void handleList() {
        var list = StudentManagement.listStudents();
        if (list.isEmpty()) {
            System.out.println("(no students yet)");
        } else {
            for (Student s : list) System.out.println(s);
            System.out.println("Total: " + StudentManagement.getTotalStudents());
        }
    }

    // Reads and validates age input
    private static Integer readAge(Scanner sc) {
        System.out.print("Enter age: ");
        String ageStr = sc.nextLine().trim();
        try {
            int age = Integer.parseInt(ageStr);
            if (age < 3 || age > 120) {
                System.out.println("Age must be between 3 and 120.");
                return null;
            }
            return age;
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid integer for age.");
            return null;
        }
    }
}
