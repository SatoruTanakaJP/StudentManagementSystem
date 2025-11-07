// Represents an individual student with private instance variables.
// Encapsulation is used to control access through getters and setters.
public class Student {
    private String id;
    private String name;
    private int age;
    private String grade;

    // Constructor to initialize all student fields
    public Student(String id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters: allow controlled read access
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    // Setters: allow controlled updates
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(String grade) { this.grade = grade; }

    // toString method for displaying student details
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name +
               "', age=" + age + ", grade='" + grade + "'}";
    }
}
