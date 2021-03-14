package spring.tutorial.junit_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.tutorial.junit_test.dto.Student;
import spring.tutorial.junit_test.service.StudentService;
import java.util.List;

/**
 * StudentController
 */
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * Get all student
	 *
	 * @return
	 */
	@GetMapping("/getMapping")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	/**
	 * Add new student
	 *
	 * @param student
	 * @return
	 */
	@PostMapping("/postMapping")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		student = studentService.saveStudent(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	/**
	 * Update student
	 *
	 * @param student
	 * @return
	 */
	@PutMapping("/putMapping")
	public ResponseEntity<Student> putExample(@RequestBody Student student) {
		student = studentService.updateStudent(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	/**
	 * Delete student
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteMapping")
	public ResponseEntity<String> deleteExample(@RequestParam("student-id") Long id) {
		String response = studentService.deleteStudent(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
