package MoneyOwing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Payment {
    public void payup(ArrayList paying){
        Scanner sc = new Scanner(System.in);

        System.out.print("Select a name to pay: ");
        String input = sc.nextLine();

        for (int i = 0; i < paying.size(); i++){
            HashMap checker = (HashMap) paying.get(i);

            if (checker.containsKey(input)){
                System.out.print("Input currency to pay: ");
                String currencyinput = sc.nextLine();

                //Retrieve current data
                Peopleowe toedit = (Peopleowe) checker.get(input);
                HashMap gettingedit = toedit.getOweThem();
                Double original = (Double) gettingedit.get(currencyinput);

                System.out.println("You owe " + input + " " + currencyinput + " " + original);
                System.out.print("How much would you like to pay?: ");
                Double moneydeduct = Double.valueOf(sc.next());


                Double remaining = original - moneydeduct;

                //Replace it
                gettingedit.remove(currencyinput);
                gettingedit.put(currencyinput, remaining);

                if (remaining == 0){
                    System.out.println("Congrats! You have paid " + input + " fully!!!");
                } else {
                    System.out.println("Remaining balance owe is: " + currencyinput + " " + remaining);
                }
                break;
            }
        }
    }
}
