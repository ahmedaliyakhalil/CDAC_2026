/*. 1. Create a class named 'Student' with String variable 'name' , integer variable 
'roll_no'., String variable ‘phone_no’ and String variable ‘address’
a.  Assign the value of roll_no as '2' and that of name as "John" by creating an 
object of the class Student.
b. Assign and print the roll number, phone number and address of two students 
having names "Sam" and "John" respectively by creating two objects of class 
'Student*/


package easyAssg1;


class Student {

    String name;
    int roll_no;
    String phone_no;
    String address;
}

public class studentClass {

    public static void main(String[] args) {

        // Part A
        Student s1 = new Student();

        s1.roll_no = 2;
        s1.name = "John";

        System.out.println("Part A:");
        System.out.println("Name: " + s1.name);
        System.out.println("Roll No: " + s1.roll_no);

        // Part B
        Student s2 = new Student();

        s2.name = "Sam";
        s2.roll_no = 1;
        s2.phone_no = "9876543210";
        s2.address = "Mumbai";

        Student s3 = new Student();

        s3.name = "John";
        s3.roll_no = 2;
        s3.phone_no = "9876501234";
        s3.address = "Pune";

        System.out.println("\nPart B:");

        System.out.println("Student 1");
        System.out.println("Name: " + s2.name);
        System.out.println("Roll No: " + s2.roll_no);
        System.out.println("Phone No: " + s2.phone_no);
        System.out.println("Address: " + s2.address);

        System.out.println("\nStudent 2");
        System.out.println("Name: " + s3.name);
        System.out.println("Roll No: " + s3.roll_no);
        System.out.println("Phone No: " + s3.phone_no);
        System.out.println("Address: " + s3.address);
    }
}
