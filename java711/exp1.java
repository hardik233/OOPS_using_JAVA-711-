class Student {
    int rollNo;
    String name;
    int age;

    // Default Constructor
    Student() {
        rollNo = 0;
        name = "Not Assigned";
        age = 0;
    }

    // Parameterized Constructor
    Student(int r, String n, int a) {
        rollNo = r;
        name = n;
        age = a;
    }

    // Member function to display details
    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        // Object using default constructor
        Student s1 = new Student();
        s1.display();

        // Object using parameterized constructor
        Student s2 = new Student(101, "Hardik", 20);
        s2.display();
    }
}