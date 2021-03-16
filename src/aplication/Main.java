package aplication;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<TaxPayer> taxPayers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");

            char r;

            do {
                System.out.print("Individual or company (i/c)? ");
                r = sc.next().charAt(0);
                sc.nextLine();
            } while (r != 'i' && r != 'c');

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            Double annualIncome = sc.nextDouble();

            TaxPayer taxPayer;

            if (r == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                taxPayer = new Individual(name, annualIncome, healthExpenditures);
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayer = new Company(name, annualIncome, numberOfEmployees);
            }

            taxPayers.add(taxPayer);
        }

        System.out.println("TAXES PAID:");
        for (TaxPayer t : taxPayers) {
            System.out.println(t.getName() + ": $ " + String.format("%.2f", t.dueTax()));
        }

        sc.close();
    }
}
