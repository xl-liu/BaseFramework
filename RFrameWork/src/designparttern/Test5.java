package designparttern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangronghua on 14/12/7.
 */
public class Test5 {

    public static void main(String[] args) {
        List<UAStudent> studentList = new ArrayList<UAStudent>();
        //students from new version
        UAStudent student1 = new UAGraduateStudent(new Student_ID("test1"));
        UAStudent student2 = new UAUnderGraduate(new Student_ID("test2"));
        UAStudent student3 = new UAGraduateStudent(new Student_ID("test3"));
        UAStudent student4 = new UAUnderGraduate(new Student_ID("test4"));
        UAStudent student5 = new UAGraduateStudent(new Student_ID("test5"));


        UAStudent student6 = new UAStudentAdaptor(new UAGraduateStudent_Old(new Student_ID("test6")));
        UAStudent student7 = new UAStudentAdaptor(new UAGraduateStudent_Old(new Student_ID("test7")));
        UAStudent student8 = new UAStudentAdaptor(new UAUnderGraduate_Old(new Student_ID("test8")));
        UAStudent student9 = new UAStudentAdaptor(new UAUnderGraduate_Old(new Student_ID("test9")));
        UAStudent student10 = new UAStudentAdaptor(new UAGraduateStudent_Old(new Student_ID("test10")));

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);

        for(UAStudent student: studentList) {
            student.GPAPrint();
        }
    }
}

class UAStudent {

    protected Student_ID a_id;

    public UAStudent() {
    }

    public UAStudent(Student_ID a_id) {
        this.a_id = a_id;
    }

    public void GPAPrint(){
        System.out.println("This is a GPA of new version!, student id is:" + a_id.toString());
    }
}
class UAGraduateStudent extends UAStudent {

    public UAGraduateStudent(Student_ID a_id){
        super(a_id);
    }
    public void GPAPrint(){
        System.out.println("This is a GPA of new version for UAGraduateStudent!, student id is:" + a_id.toString());
    }
}

class UAUnderGraduate extends UAStudent {
    public UAUnderGraduate(Student_ID a_id) {
        super(a_id);
    }
    public void GPAPrint(){
        System.out.println("This is a GPA of new version for UAUnderGraduate!, student id is:" + a_id.toString());
    }
}

class UAStudent_Old {

    protected Student_ID a_id;

    public UAStudent_Old(Student_ID a_id) {
        this.a_id = a_id;
    }

    public void printGPA(){
        System.out.println("This is a GPA of old version!, student id is:" + a_id.toString());
    }
}

class UAGraduateStudent_Old extends  UAStudent_Old{

    public UAGraduateStudent_Old(Student_ID a_id) {
        super(a_id);
    }

    public void printGPA(){
        System.out.println("This is a GPA of old version for UAGraduateStudent!, student id is:" + a_id.toString());
    }
}

class UAUnderGraduate_Old extends  UAStudent_Old{
    public UAUnderGraduate_Old(Student_ID a_id) {
        super(a_id);
    }
    public void printGPA(){
        System.out.println("This is a GPA of old version for UAUnderGraduate!, student id is:" + a_id.toString());
    }
}

class UAStudentAdaptor extends UAStudent {

    protected UAStudent_Old old;

    public UAStudentAdaptor() {

    }

    public UAStudentAdaptor(UAStudent_Old old) {
        this.old = old;
    }

    /**
     * Adaptor method to print GPA
     * @return
     */
    public void GPAPrint(){
        old.printGPA();
    }

}

class Student_ID {

    private String studentId;

    public Student_ID (String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String toString() {
        return studentId;
    }
}
