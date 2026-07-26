import java.util.*;
class Student {
    int rollNo;
    String name;
    double percentage;
    Student(int rollNo, String name, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.percentage = percentage;
    }
}
public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        HashMap<Integer, Student> studentMap = new HashMap<>();
        Student s1 = new Student(101, "Rahul", 88.5);
        Student s2 = new Student(102, "Sneha", 91.2);
        Student s3 = new Student(103, "Kiran", 84.8);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        studentMap.put(s1.rollNo, s1);
        studentMap.put(s2.rollNo, s2);
        studentMap.put(s3.rollNo, s3);
        System.out.println("Student Records (ArrayList)");
        System.out.println("--------------------------------");
        System.out.println("Roll\tName\tPercentage");
        System.out.println("--------------------------------");

        for (Student s : students) {
            System.out.println(s.rollNo + "\t" + s.name + "\t" + s.percentage);
        }      
        int searchRoll = 102;
        System.out.println("\nSearching for Roll No : " + searchRoll);
        Student found = studentMap.get(searchRoll);
        if (found != null) {
            System.out.println("\nRecord Found\n");
            System.out.println("Roll No     : " + found.rollNo);
            System.out.println("Name        : " + found.name);
            System.out.println("Percentage  : " + found.percentage);
        } else {
            System.out.println("Record Not Found");
        }
        students.remove(0);
        System.out.println("\nAfter Removing First Student\n");
        System.out.println("--------------------------------");
        System.out.println("Roll\tName\tPercentage");
        System.out.println("--------------------------------");
        for (Student s : students) {
            System.out.println(s.rollNo + "\t" + s.name + "\t" + s.percentage);
        }
        System.out.println("\nStudent Records (HashMap)");
        System.out.println("--------------------------------");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            Student s = entry.getValue();
            System.out.println(entry.getKey() + " -> " + s.name + " (" + s.percentage + "%)");
        }
    }
}
