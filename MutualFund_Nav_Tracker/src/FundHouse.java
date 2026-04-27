import java.util.*;

class FundHouse {

    private List<MutualFund> funds;

    public FundHouse() {
        funds = new ArrayList<>();
    }

    public void addFund(MutualFund fund) {
        funds.add(fund);
    }

    public void updateAUM(String fundCode,
                          double newAUM) {

        for (MutualFund f : funds) {

            if (f.getFundCode().equals(fundCode)) {

                f.setTotalAUM(newAUM);
                return;
            }
        }
    }

    public MutualFund getTopPerformer() {

        MutualFund best = funds.get(0);

        for (MutualFund f : funds) {

            if (f.calculateNAV() >
                    best.calculateNAV()) {

                best = f;
            }
        }

        return best;
    }

    public void generateNAVReport() {

        System.out.println(
                "Fund\t\tCategory\tNAV\tExitLoad"
        );

        for (MutualFund f : funds) {

            System.out.printf(
                    "%-15s %-8s Rs.%-7.4f Rs.%-7.2f%n",
                    f.getFundName(),
                    f.getFundCategory(),
                    f.calculateNAV(),
                    f.calculateExitLoad(100,200)
            );
        }

        MutualFund best =
                getTopPerformer();

        System.out.println(
                "Top Performer: "
                        + best.getFundName()
                        + " (NAV: Rs."
                        + String.format(
                        "%.4f",
                        best.calculateNAV()
                )
                        + ")"
        );
    }
}