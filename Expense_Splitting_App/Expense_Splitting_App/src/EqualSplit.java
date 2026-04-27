import java.util.*;

public class EqualSplit implements SplitStrategy{

    @Override
    public Map<String,Double>split(double totalAmount,List<String>participants,Map<String,Object>params){
        Map<String,Double> shares=new HashMap<>();

        double each=totalAmount/participants.size();

        for(String person:participants){
            shares.put(person,each);
        }
        return shares;


    }
}
