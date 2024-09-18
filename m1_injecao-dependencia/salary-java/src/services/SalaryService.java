package services;

import entities.Employee;

public class SalaryService {

    //Forma Errada!
    private TaxService taxService = new TaxService();
    private PensionService pensionService = new PensionService();

    public double netSalary(Employee employee) {

        return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary())
                - pensionService.discount(employee.getGrossSalary());

    }


}
