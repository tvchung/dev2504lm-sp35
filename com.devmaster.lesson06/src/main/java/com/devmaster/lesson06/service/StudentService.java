package com.devmaster.lesson06.service;

import com.devmaster.lesson06.dto.StudentDTO;
import com.devmaster.lesson06.entity.Student;
import com.devmaster.lesson06.repository.StudentRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // list all
    public List<Student> fillAll(){
        return studentRepository.findAll();
    }

    // save
    public Boolean save(StudentDTO student){
        Student stud = new Student();
        stud.setName(student.getName());
        stud.setEmail(student.getEmail());
        stud.setAge(student.getAge());
        try {
            studentRepository.save(stud);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // getby id
    public Optional<StudentDTO> findById(Long id){
        Student stud = studentRepository.findById(id).orElse(null);
        StudentDTO studDTO = new StudentDTO();
        studDTO.setId(id);
        studDTO.setName(stud.getName());
        studDTO.setEmail(stud.getEmail());
        studDTO.setAge(stud.getAge());
        return Optional.of(studDTO);
    }

    // update
    public Student updateStudentById(Long id, StudentDTO studentUpdate){
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentUpdate.getName());
                    student.setEmail(studentUpdate.getEmail());
                    student.setAge(studentUpdate.getAge());
                    return studentRepository.save(student);
                }).orElseThrow(() ->
                        new IllegalIdentifierException("Student not found"));
    }

    //delete
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }
}
