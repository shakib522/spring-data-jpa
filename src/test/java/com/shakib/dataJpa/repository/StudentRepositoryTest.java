package com.shakib.dataJpa.repository;

import com.shakib.dataJpa.entity.Guardian;
import com.shakib.dataJpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("shakib@gmail.com")
                .firstName("Shakib")
                .lastName("Hasan")
//                .guardianName("Abdul")
//                .guardianEmail("abdul@gmail.com")
//                .guardianMobile("01700000000")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("nikhil")
                .mobile("018993300454")
                .build();

        Student student=Student.builder()
                .firstName("akash")
                .emailId("akash@gmail.com")
                .lastName("khan")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students=studentRepository.findByFirstName("akash");
        System.out.println("students = "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students=studentRepository.findByFirstNameContaining("a");
        System.out.println("students = "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("nikhil");
        System.out.println("students = "+students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("akash@gmail.com");
        System.out.println("student = "+student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("akash@gmail.com");
        System.out.println("firstName = "+firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("akash@gmail.com");
        System.out.println("student = "+student);
    }

}