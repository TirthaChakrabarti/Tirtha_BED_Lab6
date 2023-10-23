package com.gl.studentManagementSystem.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.studentManagementSystem.entity.Student;
import com.gl.studentManagementSystem.repository.StudentRepository;
import com.gl.studentManagementSystem.serviceInterface.StudentService;

@Service
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
	StudentRepository repo;
	
	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Student getStudentsById(int Id) {
		return repo.findById(Id).get();
	}

	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student, int Id) {
		Student tempStudent = getStudentsById(Id);
		tempStudent.setFirstName(student.firstName);
		tempStudent.setLastName(student.lastName);
		tempStudent.setCourse(student.course);
		tempStudent.setCountry(student.country);
		return repo.save(student);
	}

	@Override
	public void deleteStudentById(int Id) {
		repo.deleteById(Id);
	}

}
