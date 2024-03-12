package bitlab.com.example.studentManager.DBManager;

import bitlab.com.example.studentManager.model.Student;

import java.util.ArrayList;

public class Manager {
    public static ArrayList <Student> studentList = new ArrayList<>();

    public static Long id = 3L;

    static {
        studentList.add(new Student(1L, "Dastan", "Amandossv", 100, "A"));
        studentList.add(new Student(2L, "John", "Rambo", 30,"F"));
    }

    public static ArrayList<Student> getAllStudents(){
        return studentList;
    }
    public static void addStudent(Student student){
        student.setId(id);
        studentList.add(student);
        id++;
        if(student.getExam()>90){
            student.setMark("A");
        }else if(student.getExam()>75 && student.getExam()<89){
            student.setMark("B");
        }else if(student.getExam()>60 && student.getExam()<74){
            student.setMark("C");
        }else if(student.getExam()>50 && student.getExam()<59){
            student.setMark("D");
        }else{
            student.setMark("F");
        }
    }
    public static void updateStudent(Long id, Student student){
        for (Student stud : studentList){
            if(stud.getId()==id){
                studentList.set(Integer.parseInt(String.valueOf(id)),student);
            }
        }
    }
    public static void deleteStudent(Long id){
        for (Student stud : studentList){
            if(stud.getId()==id){
                studentList.remove(Integer.parseInt(String.valueOf(id)));
            }
        }
    }
    public static Student getStudentById(Long id){
        for(Student stud : studentList){
            if(stud.getId() == id) {
                return stud;
            }
        }
        return null;
    }
}
