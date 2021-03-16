package entities;

public class Company extends TaxPayer {
    private Integer numberOfEmployees;

    public Company() {
    }

    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double dueTax() {
        return getAnnualIncome() * ((getNumberOfEmployees() < 10) ? 0.16 : 0.14);
    }
}
