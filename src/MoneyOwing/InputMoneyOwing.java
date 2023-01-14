package MoneyOwing;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class InputMoneyOwing {
    private HashMap<String, Peopleowe> whoelse;
    public void Debtors() {
        Scanner sc = new Scanner(System.in);
        this.whoelse = new HashMap<>();

        HashMap<String, Double> oweyou = new HashMap<>();
        HashMap<String, Double> owethem = new HashMap<>();

        DecimalFormat formatter = new DecimalFormat("#,###.##");

        while (true) {
            System.out.print("Money Transaction to whom? Enter 'nil' to quit adding. ");
            String owingname = sc.nextLine();

            if (owingname.compareTo("nil") == 0) {
                break;
            } else {
                //User input
                System.out.print("How much did they owe you? ");
                Double moneyowe = Double.valueOf(sc.nextLine());
                System.out.print("What is the currency? ");
                String oweyoucurr = sc.nextLine();

                System.out.print("How much did you owe them? ");
                Double moneypay = Double.valueOf(sc.nextLine());
                System.out.print("What is the currency? ");
                String owethemcurr = sc.nextLine();

                //Add to current data or create new ones
                if (oweyou.containsKey(oweyoucurr)){
                    oweyou.replace(oweyoucurr, oweyou.get(oweyoucurr) + moneyowe);
                } else {
                    oweyou.put(oweyoucurr, moneyowe);
                }

                if (owethem.containsKey(owethemcurr)){
                    owethem.replace(owethemcurr, owethem.get(owethemcurr) + moneypay);
                } else {
                    owethem.put(owethemcurr, moneypay);
                }

                //Create HashMap to store data
                Peopleowe owemoney = new Peopleowe(oweyou, owethem);
                if (whoelse.containsKey(owingname)){
                    whoelse.replace(owingname, owemoney);
                } else {
                    whoelse.put(owingname, owemoney);
                }

            }
        }

        //Summary of input
        for (String key : whoelse.keySet()){
            System.out.println(key + " owes you ");
            HashMap<String, Double> whatpeopleoweyou = whoelse.get(key).getOweYou();
            for (String currency : whatpeopleoweyou.keySet()){
                Double moneyowetoyou = Double.valueOf(whatpeopleoweyou.get(currency));
                System.out.println(currency + " " + formatter.format(moneyowetoyou));
            }

            System.out.println("You owe " + key);
            HashMap<String, Double> whatyouowepeople = whoelse.get(key).getOweThem();
            for (String currency : whatyouowepeople.keySet()){
                Double moneytopay = Double.valueOf(whatyouowepeople.get(currency));
                System.out.println(currency + " " + formatter.format(moneytopay));
            }
        }
    }

    public HashMap<String, Peopleowe> getHashMap(){
        return this.whoelse;
    }
}