package spring.tutorial.junit_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.tutorial.junit_test.dto.Student;
import spring.tutorial.junit_test.repository.StudentRepository;
import java.util.List;

/**
 * StudentService
 */
@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	/**
	 * Get all student
	 *
	 * @return
	 */
	public List<Student> getStudents() {
		return repository.findAll();
	}

	/**
	 * Add new student
	 *
	 * @param student
	 * @return
	 */
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	/**
	 * Update student
	 *
	 * @param student
	 * @return
	 */
	public Student updateStudent(Student student) {
		return repository.save(student);
	}

	/**
	 * Delete student
	 *
	 * @param id
	 * @return
	 */
	public String deleteStudent(Long id) {
		String result = "Student is deleted";
		try {
			repository.deleteById(id);
		} catch (Exception ex) {
			result = "fail";
		}
		return result;
	}
}