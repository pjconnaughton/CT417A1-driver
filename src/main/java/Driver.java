import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        //Set up some students and modules to be assigned to a course to be made
        Student s1 = new Student("John Jones", 21, "23/11/2000", 19333142);
        Student s2 = new Student("Burt Clump", 19, "23/11/2002", 19333143);
        Student s3 = new Student("Pat Parsons", 31, "23/11/1990", 19333144);

        Lecturer l1 = new Lecturer("John Johnson", 44, "23/11/1970", 13332);
        Lecturer l2 = new Lecturer("Jack Jackson", 44, "23/11/1970", 13333);
        Lecturer l3 = new Lecturer("Patrick Fitzpatrick", 44, "23/11/1970", 13334);

        SingleModule m1 = new SingleModule("Software Engineering III", "CT417", l1);
        SingleModule m2 = new SingleModule("Machine Learning", "CT41001", l2);
        SingleModule m3 = new SingleModule("Programming", "CT414", l3);

        Course c1 = new Course("Computer Science");

        m1.addStudent(s1);
        m1.addStudent(s3);
        m1.addStudent(s2);
        m2.addStudent(s1);
        m2.addStudent(s3);
        m2.addStudent(s2);
        m3.addStudent(s3);

        c1.addModule(m1);
        c1.addModule(m2);
        c1.addModule(m3);
        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);

        s1.addModule(m1);
        s1.addModule(m2);
        s2.addModule(m1);
        s2.addModule(m2);
        s3.addModule(m1);
        s3.addModule(m2);
        s3.addModule(m3);
        s1.addCourse(c1);
        s2.addCourse(c1);
        s3.addCourse(c1);

        //Prove it all works with some prints
        System.out.println("Course Name: "+c1.getCourseName());
        ArrayList<Student> students = c1.getStudents();
        System.out.print("Students Registered: ");
        for(Student t : students) {
            System.out.print(t.getUsername()+", ");
        }

        ArrayList<SingleModule> modules = c1.getModules();
        System.out.print("\nModules in "+c1.getCourseName()+": ");
        for(SingleModule t : modules) {
            System.out.print(t.getModuleID()+", ");
        }

        System.out.print("\nAll Students:");
        for(Student t : students) {
            System.out.print("\n--------------------------");
            System.out.print("\nStudent: "+t.getUsername());
            ArrayList<SingleModule> mods = t.getModules();
            ArrayList<Course> courses = t.getCourses();

            System.out.print("\nCourse Registered For: "+courses.get(0).getCourseName());
            System.out.print("\nModules Registered For: \n");
            for(SingleModule m : mods){
                System.out.println(m.getModuleID());
            }
        }
    }
}
