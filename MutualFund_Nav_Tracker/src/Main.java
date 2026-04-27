public class Main {

    public static void main(String[] args) {

        FundHouse house =
                new FundHouse();

        house.addFund(
                new EquityFund(
                        "HDFC Top 200",
                        "EQ01",
                        100000,
                        5000000
                )
        );

        house.addFund(
                new DebtFund(
                        "SBI Short Term",
                        "DT01",
                        500000,
                        20000000,
                        0.05
                )
        );

        house.addFund(
                new HybridFund(
                        "Balanced Fund",
                        "HY01",
                        100000,
                        8000000,
                        0.60
                )
        );

        house.updateAUM(
                "EQ01",
                5500000
        );

        house.generateNAVReport();
    }
}
