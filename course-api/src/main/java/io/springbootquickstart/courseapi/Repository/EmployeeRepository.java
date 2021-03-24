package io.springbootquickstart.courseapi.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.springbootquickstart.courseapi.Entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	
	@Transactional
	@Query(value = "SELECT * FROM employee_details WHERE emp_Id = ?1", nativeQuery = true)
	List<Employee> getEmployeeInfoByIdForEditEmployeeRepo(Long empId);	
	
}
