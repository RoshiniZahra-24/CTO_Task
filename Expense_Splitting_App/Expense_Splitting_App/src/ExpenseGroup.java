import java.util.*;

public class ExpenseGroup {

    private List<Expense> expenses =
            new ArrayList<>();

    public void addExpense(Expense e){

        expenses.add(e);

    }

    public Map<String,Double> getNetBalance(){

        Map<String,Double> balance =
                new HashMap<>();

        for(Expense e: expenses){

            Map<String,Double> shares =
                    e.getShares();

            String payer = e.getPaidBy();

            for(String p: shares.keySet()){

                balance.putIfAbsent(p,0.0);

                balance.put(
                        p,
                        balance.get(p)
                                - shares.get(p)
                );
            }

            balance.put(
                    payer,
                    balance.get(payer)
                            + shares.values()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .sum()
            );
        }

        return balance;
    }

    public void printSettlement(){

        Map<String,Double> net =
                getNetBalance();

        System.out.println("Net Balances:");

        for(String p: net.keySet()){

            System.out.printf(
                    "%s : %.2f%n",
                    p,
                    net.get(p)
            );
        }

        List<String> creditors=
                new ArrayList<>();

        List<String> debtors=
                new ArrayList<>();

        for(String p: net.keySet()){

            if(net.get(p)>0)
                creditors.add(p);

            else if(net.get(p)<0)
                debtors.add(p);
        }

        System.out.println(
                "\nSettlement:"
        );

        for(String d:debtors){

            double debt=-net.get(d);

            for(String c:creditors){

                double credit=
                        net.get(c);

                if(debt==0)
                    break;

                if(credit<=0)
                    continue;

                double pay=
                        Math.min(debt,credit);

                System.out.printf(
                        "%s pays %s Rs.%.2f%n",
                        d,c,pay
                );

                debt-=pay;

                net.put(c,
                        credit-pay);
            }
        }

    }

}
