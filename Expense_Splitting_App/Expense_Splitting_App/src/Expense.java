import java.util.*;

public class Expense {

    private String description;
    private double totalAmount;
    private String paidBy;

    private List<String> participants;

    private SplitStrategy strategy;

    private Map<String,Object> params;

    public Expense(
            String description,
            double totalAmount,
            String paidBy,
            List<String> participants,
            SplitStrategy strategy,
            Map<String,Object> params){

        this.description=description;
        this.totalAmount=totalAmount;
        this.paidBy=paidBy;
        this.participants=participants;
        this.strategy=strategy;
        this.params=params;
    }

    public String getPaidBy(){
        return paidBy;
    }

    public Map<String,Double> calculateOwed(){

        Map<String,Double> splitMap =
                strategy.split(
                        totalAmount,
                        participants,
                        params
                );

        Map<String,Double> owed =
                new HashMap<>();

        for(String p : participants){

            if(!p.equals(paidBy)){

                owed.put(
                        p,
                        splitMap.get(p)
                );
            }

        }

        return owed;
    }

    public Map<String,Double> getShares(){
        return strategy.split(
                totalAmount,
                participants,
                params
        );
    }

}
