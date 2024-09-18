package com.devsuperior.aula.services;


import com.devsuperior.aula.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    private TaxService taxService;
    private PensionService pensionService;

    //@Autowiring é automatico aqui
    public SalaryService (TaxService taxService, PensionService pensionService) {
        this.taxService = taxService;
        this.pensionService = pensionService;
    }

    public double netSalary(Employee employee) {

        return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary())
                - pensionService.discount(employee.getGrossSalary());

    }


}
