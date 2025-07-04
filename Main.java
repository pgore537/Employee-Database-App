import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n1. Add Employee\n2. View All\n3. Update\n4. Delete\n5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Department: ");
                        String dept = sc.next();
                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        dao.addEmployee(new Employee(0, name, dept, salary));
                        break;

                    case 2:
                        for (Employee e : dao.getAllEmployees()) {
                            System.out.printf("%d | %s | %s | %.2f%n",
                                    e.getId(), e.getName(), e.getDepartment(), e.getSalary());
                        }
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        System.out.print("New Name: ");
                        name = sc.next();
                        System.out.print("New Dept: ");
                        dept = sc.next();
                        System.out.print("New Salary: ");
                        salary = sc.nextDouble();
                        dao.updateEmployee(new Employee(id, name, dept, salary));
                        break;

                    case 4:
                        System.out.print("ID: ");
                        id = sc.nextInt();
                        dao.deleteEmployee(id);
                        break;

                    case 5:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
