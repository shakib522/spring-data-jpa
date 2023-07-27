package com.shakib.dataJpa.repository;

import com.shakib.dataJpa.entity.Course;
import com.shakib.dataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){
        Course course=Course.builder()
                .title("DBA")
                .credit(3)
                .build();

        Course courseJava=Course.builder()
                .title("Java")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Motin")
                .lastName("Sir")
                .courses(List.of(course,courseJava))
                .build();
        teacherRepository.save(teacher);
    }
}
