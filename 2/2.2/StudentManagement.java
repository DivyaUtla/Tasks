import java.util.ArrayList;
import java.util.List;

class Student{
    int stId;
    String stName;
    String stClass;

    public Student(int stId, String stName, String stClass){
        this.stId=stId;
        this.stName=stName;
        this.stClass=stClass;
    }

}

class Teacher{
    int tId;
    String tName;
    List<Student> students;

    public Teacher(int tId, String tName){
        this.tId=tId;
        this.tName=tName;
        this.students=new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void showTeacher(){
        System.out.println("Teacher Name : " + tName);
        for(Student student:students){
            System.out.println("StudentName : " + student.stName + ", StudentId : "+ student.stId + ", StudentClass : " + student.stClass);
            System.out.println();
        }
    }

}

class Class{
    String className;
    List<Teacher> teachers;

    public Class(String className){
        this.className=className;
        this.teachers=new ArrayList<>();
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public void showClass(){
        System.out.println("Class Name : " + className);
        for(Teacher teacher: teachers){
            teacher.showTeacher();
        }
    }
}

public class StudentManagement{
    public static void main(String[] args) {
        Student s1= new Student(1, "Divya", "10");
        Student s2= new Student(1, "Roopa", "11");

        Teacher t1=new Teacher(23, "Amrutha");
        Teacher t2=new Teacher(29, "Hemanth");

        t1.addStudent(s2);
        t2.addStudent(s1);

        Class classes=new Class("Tenth");

        classes.addTeacher(t1);
        classes.addTeacher(t2);

        classes.showClass();

    }
}
