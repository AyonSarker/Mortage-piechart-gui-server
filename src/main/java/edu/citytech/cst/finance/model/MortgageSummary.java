package edu.citytech.cst.finance.model;

public class MortgageSummary {
    private  double cumulativeInterest;
    private  double totalPrincipal;

    public MortgageSummary(double cumulativeInterest, double totalPrincipal) {
        this.cumulativeInterest = cumulativeInterest;
        this.totalPrincipal = totalPrincipal;
    }

    public double getCumulativeInterest() {
        return cumulativeInterest;
    }

    public double getTotalPrincipal() {
        return totalPrincipal;
    }

    @Override
    public String toString() {
        return "MortgageSummary{" +
                "cumulativeInterest=" + cumulativeInterest +
                ", totalPrincipal=" + totalPrincipal +
                '}';
    }
}
