abstract class MutualFund {

    private String fundName;
    private String fundCode;
    private double totalUnits;
    protected double totalAUM;

    public MutualFund(String fundName,
                      String fundCode,
                      double totalUnits,
                      double totalAUM) {

        this.fundName = fundName;
        this.fundCode = fundCode;
        this.totalUnits = totalUnits;
        this.totalAUM = totalAUM;
    }


    public double calculateNAV() {
        return totalAUM / totalUnits;
    }


    public abstract double calculateExitLoad(
            double units,
            int holdingDays
    );

    public abstract String getFundCategory();

    public String getFundName() {
        return fundName;
    }

    public String getFundCode() {
        return fundCode;
    }

    public double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalAUM(double newAUM) {
        totalAUM = newAUM;
    }
}