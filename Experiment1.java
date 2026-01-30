class Student {
    String name;
    int rollNumber;
    double percentage;

    Student() {
        this.name = "Himanshu";
        this.rollNumber = 243;
        this.percentage = 99.0;
        System.out.println("Default constructor ");
    }
    Student(String name, int rollNumber, double percentage) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.percentage = percentage;
        System.out.println("Parameterized constructor");
    }
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Percentage: " + percentage + "%");
    }
}

public class Experiment1 {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.displayDetails();
        Student student2 = new Student("Harsh", 101, 88.5);
        student2.displayDetails();
    }
}
