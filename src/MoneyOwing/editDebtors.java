package MoneyOwing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class editDebtors{
    public void editing(ArrayList editinglist) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select a Name to edit: ");
        String input = sc.nextLine();

        for (int i = 0; i <= editinglist.size(); i++){
            HashMap checker = (HashMap) editinglist.get(i);

            if (checker.containsKey(input)){
                System.out.println("[1] Edit Name");
                System.out.println("[2] Edit Amount Owed");
                System.out.println("[3] Edit Amount to Pay");
                System.out.println("[4] Quit Editing");

                String action = sc.nextLine();

                if (action.compareTo("1") == 0){
                    System.out.println("Please enter new name:");
                    String editname = sc.nextLine();

                    //Retrieve current data and replace it
                    HashMap<String, Peopleowe> newinfo = new HashMap<>();
                    newinfo.put(editname, (Peopleowe) checker.get(input));
                    checker.remove(input);

                    editinglist.add(newinfo);
                    break;

                } else if (action.compareTo("2") == 0){
                    System.out.print("Currency to edit: ");
                    String curredit = sc.nextLine();

                    System.out.print("Choose [1] edit amount, [2] auto-conversion or [3] to quit: ");
                    String option = sc.nextLine();

                    if (option.compareTo("1") == 0){
                        System.out.print("Edit amount: ");
                        Double amounedit = Double.valueOf(sc.next());

                        //Retrieve current data
                        Peopleowe toedit = (Peopleowe) checker.get(input);

                        //Replace it
                        HashMap gettingedit = toedit.getOweYou();
                        gettingedit.remove(curredit);
                        gettingedit.put(curredit, amounedit);

                        break;
                    } else if (option.compareTo("2") == 0){
                        System.out.print("Change to which currency?: ");
                        String convertcurrency = sc.nextLine();

                        //Retrieve current data
                        Peopleowe toedit = (Peopleowe) checker.get(input);
                        HashMap gettingedit = toedit.getOweYou();
                        Double original = (Double) gettingedit.get(curredit);

                        System.out.println("Insert Exchange Rate: ");
                        Double exchangerate = Double.valueOf(sc.next());

                        Double converted = original * exchangerate;
                        System.out.println("Converted amount: " + convertcurrency + " " + converted);

                        //Replace it
                        gettingedit.remove(curredit);
                        gettingedit.put(convertcurrency, converted);

                        break;
                    } else {
                        break;
                    }

                } else if (action.compareTo("3") == 0){
                    System.out.println("Currency to edit: ");
                    String curredit = sc.nextLine();

                    System.out.print("Choose [1] edit amount, [2] auto-conversion or [3] to quit: ");
                    String option = sc.nextLine();

                    if (option.compareTo("1") == 0){
                        System.out.print("Edit amount: ");
                        Double amounedit = Double.valueOf(sc.next());

                        //Retrieve current data
                        Peopleowe toedit = (Peopleowe) checker.get(input);

                        //Replace it
                        HashMap gettingedit = toedit.getOweThem();
                        gettingedit.remove(curredit);
                        gettingedit.put(curredit, amounedit);

                        break;
                    } else if (option.compareTo("2") == 0){
                        System.out.print("Change to which currency?: ");
                        String convertcurrency = sc.nextLine();

                        //Retrieve current data
                        Peopleowe toedit = (Peopleowe) checker.get(input);
                        HashMap gettingedit = toedit.getOweThem();
                        Double original = (Double) gettingedit.get(curredit);

                        System.out.println("Insert Exchange Rate: ");
                        Double exchangerate = Double.valueOf(sc.next());

                        Double converted = original * exchangerate;
                        System.out.println("Converted amount: " + converted);

                        //Replace data
                        gettingedit.remove(curredit);
                        gettingedit.put(convertcurrency, converted);

                        break;
                    } else {
                        break;
                    }

                } else {
                    break;
                }
            }
        }
    }
}
