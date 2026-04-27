class DebtFund extends MutualFund {

    private double accruedInterestPerUnit;

    public DebtFund(String fundName,
                    String fundCode,
                    double totalUnits,
                    double totalAUM,
                    double accruedInterestPerUnit) {

        super(fundName,
                fundCode,
                totalUnits,
                totalAUM);

        this.accruedInterestPerUnit =
                accruedInterestPerUnit;
    }

    @Override
    public double calculateNAV() {

        double interest =
                accruedInterestPerUnit *
                        getTotalUnits();

        return (totalAUM + interest)
                / getTotalUnits();
    }

    @Override
    public double calculateExitLoad(double units,
                                    int holdingDays) {

        if (holdingDays < 180) {

            return units *
                    calculateNAV() *
                    0.005;
        }

        return 0;
    }

    @Override
    public String getFundCategory() {
        return "Debt";
    }
}
