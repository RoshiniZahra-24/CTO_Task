import java.util.*;

public class ShareSplit implements SplitStrategy {

    @Override
    public Map<String,Double> split(
            double totalAmount,
            List<String> participants,
            Map<String,Object> params){

        Map<String,Integer> sharesMap =
                (Map<String,Integer>) params.get("shares");

        int totalShares=0;

        for(int s : sharesMap.values()){
            totalShares += s;
        }

        double oneShareValue =
                totalAmount/totalShares;

        Map<String,Double> result =
                new HashMap<>();

        for(String person:participants){

            result.put(
                    person,
                    sharesMap.get(person)
                            * oneShareValue
            );
        }

        return result;
    }

}
