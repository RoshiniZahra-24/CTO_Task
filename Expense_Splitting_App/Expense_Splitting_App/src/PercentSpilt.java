import java.util.*;
public class PercentSpilt implements SplitStrategy {

    @Override
    public Map<String,Double>split(double totalAmount,List<String> participants,Map<String,Object>params){

        Map<String,Double>percentages=(Map<String, Double>)params.get("percentages");
        double totalpercent=0;

        for(double p:percentages.values()){
            totalpercent+=p;
        }
        if(totalpercent!=100){
            throw new IllegalArgumentException(
                    "Percentages must sum to 100");

        }
        Map<String,Double> shares =
                new HashMap<>();

        for(String person: participants){

            double percent =
                    percentages.get(person);

            shares.put(
                    person,
                    totalAmount * percent/100
            );
        }

        return shares;
    }

    }

