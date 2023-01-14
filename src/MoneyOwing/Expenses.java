package MoneyOwing;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Expenses {
    private HashMap<String, Double> tracker;
    private ArrayList<ExpensesPrint> expensetracking;

    public void trackExpenses(){
        Scanner sc = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("###.#");
        this.tracker = new HashMap<>();
        this.expensetracking = new ArrayList<>();
        double total = 0;

        System.out.println("Add daily expenses limit: ");
        double limit = Double.valueOf(sc.nextLine());

        while (true){
            System.out.println("Add expenses: [X] to quit");
            String input = sc.nextLine();

            if (input.compareTo("X") == 0){
                break;
            } else {
                System.out.println("How much did you spend? ");
                double expendings = Double.valueOf(sc.next());

                if (tracker.containsKey(input)){
                    tracker.replace(input, tracker.get(input) + expendings);
                } else {
                    tracker.put(input, expendings);
                }

                total += expendings;
                input = sc.nextLine();
            }
        }

        for (String activities : tracker.keySet()){
            Double percentage = (tracker.get(activities) / total) * 100;
            expensetracking.add(new ExpensesPrint(activities, tracker.get(activities), percentage));
        }

        expensetracking.stream().sorted((p1, p2) -> {
            return (int)p2.getPercent() - (int)p1.getPercent();
        }).forEach(p -> System.out.println(p.getActivity() + " " + p.getAmount() + " " + p.getPercent() + "%"));

        if (total <= limit){
            System.out.println("You left " + (limit - total) + " to spend!");
        } else {
            System.out.println("You spent " + (total - limit) + " over your budget!");
        }

    }
}
