import java.util.*;

public class Main {

    public static void main(String[] args) {

        ExpenseGroup group =
                new ExpenseGroup();

        List<String> users =
                Arrays.asList(
                        "Alice","Bob","Carol"
                );

        // Expense 1 Equal
        Expense e1 = new Expense(
                "Dinner",
                1200,
                "Alice",
                users,
                new EqualSplit(),
                new HashMap<>()
        );

        // Expense 2 Percent
        Map<String,Object> p =
                new HashMap<>();

        Map<String,Double> perc=
                new HashMap<>();

        perc.put("Alice",50.0);
        perc.put("Bob",20.0);
        perc.put("Carol",30.0);

        p.put("percentages",perc);

        Expense e2=
                new Expense(
                        "Hotel",
                        3000,
                        "Bob",
                        users,
                        new PercentSpilt(),
                        p
                );

        // Expense 3 Exact

        Map<String,Object> ex =
                new HashMap<>();

        Map<String,Double> amounts =
                new HashMap<>();

        amounts.put("Alice",500.0);
        amounts.put("Bob",300.0);
        amounts.put("Carol",200.0);

        ex.put("amounts",amounts);

        Expense e3 =
                new Expense(
                        "Taxi",
                        1000,
                        "Carol",
                        users,
                        new ExactSplit(),
                        ex
                );

        // Expense 4 Shares

        Map<String,Object> sh =
                new HashMap<>();

        Map<String,Integer> shares=
                new HashMap<>();

        shares.put("Alice",2);
        shares.put("Bob",1);
        shares.put("Carol",1);

        sh.put("shares",shares);

        Expense e4 =
                new Expense(
                        "Pizza",
                        800,
                        "Alice",
                        users,
                        new ShareSplit(),
                        sh
                );

        group.addExpense(e1);
        group.addExpense(e2);
        group.addExpense(e3);
        group.addExpense(e4);

        group.printSettlement();

    }

}