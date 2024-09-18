package com.devsuperior.aula;

import com.devsuperior.aula.entities.Employee;
import com.devsuperior.aula.services.SalaryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.devsuperior.aula.services"}) //to optimize spring
public class AulaApplication implements CommandLineRunner {

	//@Autowiring //Outra forma de injetar a dependência
	private SalaryService salaryService;

	//@Autowiring é automatico aqui
	public AulaApplication(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Anderson", 4000.0);
		System.out.println(salaryService.netSalary(employee));
	}
}
