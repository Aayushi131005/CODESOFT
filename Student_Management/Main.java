import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();

                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Error: Name and Grade cannot be empty.");
                        break;
                    }

                    sms.addStudent(new Student(name, roll, grade));
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    sms.removeStudent(Integer.parseInt(sc.nextLine()));
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    Student s = sms.searchStudent(Integer.parseInt(sc.nextLine()));
                    if (s != null)
                        System.out.println(s);
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter roll number to edit: ");
                    int editRoll = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = sc.nextLine();

                    if (newName.isEmpty() || newGrade.isEmpty()) {
                        System.out.println("Error: Name and Grade cannot be empty.");
                        break;
                    }

                    sms.editStudent(editRoll, newName, newGrade);
                    break;

                case 5:
                    sms.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
 