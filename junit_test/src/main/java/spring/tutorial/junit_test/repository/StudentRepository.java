package spring.tutorial.junit_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.tutorial.junit_test.dto.Student;

/**
 * StudentRepository
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
