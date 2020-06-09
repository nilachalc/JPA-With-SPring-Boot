package com.jpa.practice.SpringJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.jpa.practice.SpringJPA.repository.CourseRepository;
import com.jpa.practice.SpringJPA.repository.EmployeeRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.jpa.practice.bean")
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository ;
	
	@Autowired
	private CourseRepository courseRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//employeeRepository.save(new TemporaryEmployee("Unmesha", "CTS", 200.00, 500));
		//employeeRepository.save(new PermanentEmployee("Swarnali", "Infy", 50000.00, "All"));
		
		/*
		 * for (Employee employee : employeeRepository.findAll()) {
		 * System.out.println(employee.getId()); System.out.println(employee.getName());
		 * System.out.println(employee.getOrganisationName()); if (employee instanceof
		 * PermanentEmployee) {
		 * System.out.println(((PermanentEmployee)employee).getSalary());
		 * System.out.println(((PermanentEmployee)employee).getFacility()); } else {
		 * System.out.println(((TemporaryEmployee)employee).getWedgePerHour());
		 * System.out.println(((TemporaryEmployee)employee).getDaysServed()); } }
		 */
	}
}
