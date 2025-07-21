import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private final String FILE_NAME = "students.ser";

    public StudentManagementSystem() {
        students = loadStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(s -> s.getRollNumber() == rollNumber);
        saveStudents();
    }

    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void editStudent(int rollNumber, String newName, String newGrade) {
        Student s = searchStudent(rollNumber);
        if (s != null) {
            s.setName(newName);
            s.setGrade(newGrade);
            saveStudents();
        }
    }

    private void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Student> loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
