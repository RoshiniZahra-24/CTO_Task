import java.util.*;

public interface SplitStrategy {
    Map<String, Double>split(double totalAmount, List<String>participants, Map<String,Object>params);
}

