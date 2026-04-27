class HybridFund extends MutualFund {

    private double equityRatio;

    public HybridFund(String fundName,
                      String fundCode,
                      double totalUnits,
                      double totalAUM,
                      double equityRatio) {

        super(fundName,
                fundCode,
                totalUnits,
                totalAUM);

        this.equityRatio = equityRatio;
    }

    @Override
    public double calculateNAV() {

        double baseNAV =
                totalAUM / getTotalUnits();

        double equityNAV =
                baseNAV * 1.10;

        double debtNAV =
                baseNAV * 0.95;

        return (equityRatio * equityNAV)
                + ((1 - equityRatio) * debtNAV);
    }

    @Override
    public double calculateExitLoad(double units,
                                    int holdingDays) {

        if (holdingDays < 365) {

            return units *
                    calculateNAV() *
                    0.0075;
        }

        return 0;
    }

    @Override
    public String getFundCategory() {
        return "Hybrid";
    }
}