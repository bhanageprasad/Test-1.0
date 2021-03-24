package io.springbootquickstart.courseapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import javax.persistence.TableGenerator;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.Mapping;

@Entity
@Table(name = "employee_details")
public class Employee {

	
	 	@Id
	 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 	@Column(name="empId", unique = true, nullable = false)
	 	private Long empId;
	 	
		@Column(name="firstName")
		private String firstName;
		
		@Column(name="lastName")
		private String lastName;
		
		@Column(name="city")
		private String city;
		
		@Column(name="department")
		private String department;
		 
		@Column(name="age")
		private String age;
		
		@Column(name="salary")
		private String salary;
		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

		public Employee(Long empId, String firstName, String lastName, String city, String department, String age,
				String salary) {
			super();
			this.empId = empId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.city = city;
			this.department = department;
			this.age = age;
			this.salary = salary;
		}



		public Long getEmpId() {
			return empId;
		}

		public void setEmpId(Long empId) {
			this.empId = empId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getDepartment() {
			return department;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getSalary() {
			return salary;
		}

		public void setSalary(String salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
					+ ", department=" + department + ", age=" + age + ", salary=" + salary + "]";
		}

		
		
		
		
		
		
	

}
