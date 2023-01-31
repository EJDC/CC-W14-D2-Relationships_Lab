package com.codeclan.example.employeeservice;

import com.codeclan.example.employeeservice.models.Department;
import com.codeclan.example.employeeservice.models.Employee;
import com.codeclan.example.employeeservice.models.Project;
import com.codeclan.example.employeeservice.repositories.DepartmentRepository;
import com.codeclan.example.employeeservice.repositories.EmployeeRepository;
import com.codeclan.example.employeeservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeserviceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department department = new Department("Finance");
		departmentRepository.save(department);

		Employee ema = new Employee("Ema", 26, 1232, "ema@email.com", department);
		employeeRepository.save(ema);

	}

	@Test
	public void addEmployeeAndProject() {
		Department department = new Department("Finance");
		departmentRepository.save(department);

		Employee ewan = new Employee("Ewan", 26, 1232, "ema@email.com", department);
		employeeRepository.save(ewan);

		Employee ali = new Employee("Ali", 26, 1232, "ema@email.com", department);
		employeeRepository.save(ali);

		Project project = new Project("lab", 2);
		projectRepository.save(project);

		project.addEmployee(ewan);
		projectRepository.save(project);

		project.addEmployee(ali);
		projectRepository.save(project);

	}


}
