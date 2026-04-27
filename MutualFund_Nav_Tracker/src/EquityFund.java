class EquityFund extends MutualFund {

    public EquityFund(String fundName,
                      String fundCode,
                      double totalUnits,
                      double totalAUM) {

        super(fundName,
                fundCode,
                totalUnits,
                totalAUM);
    }

    @Override
    public double calculateExitLoad(double units,
                                    int holdingDays) {

        if (holdingDays < 365) {
            return units *
                    calculateNAV() *
                    0.01;
        }

        return 0;
    }

    @Override
    public String getFundCategory() {
        return "Equity";
    }
}