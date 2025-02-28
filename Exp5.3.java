import java.io.*;
import java.util.*;

class Employee implements Serializable {
    String name;
    int id;
    String designation;
    double salary;

    public Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }
}

public class EmployeeApp {
    private static final String FILE_NAME = "employees.dat";
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        loadEmployees();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter employee name: ");
                String name = scanner.nextLine();
                System.out.print("Enter employee ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter designation: ");
                String designation = scanner.nextLine();
                System.out.print("Enter salary: ");
                double salary = scanner.nextDouble();
                employees.add(new Employee(name, id, designation, salary));
                saveEmployees();
            } else if (choice == 2) {
                displayEmployees();
            } else if (choice == 3) {
                break;
            }
        }
        scanner.close();
    }

    private static void saveEmployees() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    private static void loadEmployees() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) in.readObject();
        } catch (FileNotFoundException e) {
            employees = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }

    private static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employees) {
                System.out.println("Name: " + employee.name + ", ID: " + employee.id + ", Designation: " + employee.designation + ", Salary: " + employee.salary);
            }
        }
    }
}
