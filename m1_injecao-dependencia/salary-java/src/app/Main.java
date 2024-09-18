package app;

import entities.Employee;
import services.BrazilTaxService;
import services.PensionService;
import services.SalaryService;
import services.TaxService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Salario bruto: ");
        double grossSalary = sc.nextDouble();

        Employee emp = new Employee(name, grossSalary);
        SalaryService salaryService = new SalaryService(new BrazilTaxService(), new PensionService());

        System.out.printf("Salario liquido = %.2f%n", salaryService.netSalary(emp));

        sc.close();

    }
}