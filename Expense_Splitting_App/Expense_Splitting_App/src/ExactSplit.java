import java.util.*;

public class ExactSplit implements SplitStrategy {

    @Override
    public Map<String,Double> split(
            double totalAmount,
            List<String> participants,
            Map<String,Object> params){

        Map<String,Double> amounts =
                (Map<String,Double>) params.get("amounts");

        double sum=0;

        for(double v : amounts.values()){
            sum += v;
        }

        if(sum != totalAmount){
            throw new IllegalArgumentException(
                    "Amounts must sum to bill"
            );
        }

        return amounts;
    }
}
