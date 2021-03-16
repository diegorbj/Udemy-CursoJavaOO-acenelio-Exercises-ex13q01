package entities;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual() {
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double dueTax() {
        return getAnnualIncome()
                * ((getAnnualIncome() < 20000) ? 0.15 : 0.25)
                - getHealthExpenditures() * 0.5;
    }
}
