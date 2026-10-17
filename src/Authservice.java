
import java.util.ArrayList;

public class Authservice {

    private ArrayList<User> users = new ArrayList<>();
    private int nextUserId = 1;

    // Register a new student
    public Student registerStudent(String name, String email, String password) {

        // Check if email already exists
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email already registered!");
                return null;
            }
        }

        // Create and store student
        Student student = new Student(nextUserId, name, email, password);
        users.add(student);
        nextUserId++;

        System.out.println("Registration successful!");
        return student;
    }

    // Login a user
    public User login(String email, String password) {

        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)
                    && user.getPassword().equals(password)) {

                System.out.println("Login successful! Welcome, " + user.getName());
                return user;
            }
        }

        System.out.println("Invalid email or password!");
        return null;
    }

    // Logout a user
    public void logout() {
        System.out.println("Logged out successfully!");
    }
}
