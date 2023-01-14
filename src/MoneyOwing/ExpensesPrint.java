package MoneyOwing;

import java.text.DecimalFormat;

public class ExpensesPrint {
    private String activity;
    private double amount;
    private double percent;
    DecimalFormat formatter = new DecimalFormat("###.#");

    public ExpensesPrint(String activity, double amount, double percent){
        this.activity = activity;
        this.amount = amount;
        this.percent = percent;
    }

    public String getActivity(){
        return this.activity;
    }

    public double getAmount(){
        return this.amount;
    }

    public double getPercent(){
        return Double.valueOf(formatter.format(this.percent));
    }
}
