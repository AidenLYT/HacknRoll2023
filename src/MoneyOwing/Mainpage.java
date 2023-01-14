package MoneyOwing;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Mainpage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<HashMap> datastoring = new ArrayList<>();

        DecimalFormat formatter = new DecimalFormat("#,###.##");

        //Action to be made
        while (true) {
            System.out.println("Select an action: ");
            System.out.println("[1] Add Debtors");
            System.out.println("[2] Amend Debtors information");
            System.out.println("[3] Perform Auto-deduction");
            System.out.println("[4] Paying people");
            System.out.println("[5] Summary of Debts");
            System.out.println("[6] Expense Tracker");
            System.out.println("[X] Exit");

            String input = sc.nextLine();

            //Action to add debts
            if (input.compareTo("1") == 0){
                System.out.println("'Adding Debtors' is selected");

                InputMoneyOwing debt = new InputMoneyOwing();
                debt.Debtors();
                datastoring.add(debt.getHashMap());

                System.out.println("Do you wish to continue? Y/N ");
                String continuing = sc.nextLine();

                if (continuing.compareTo("N") == 0){
                    break;
                }

            //Action to change information that has been added
            } else if (input.compareTo("2") == 0) {
                System.out.println("'Amending Debtors information' is selected");

                if (datastoring.isEmpty()) {
                    System.out.println("Please add Debtors first!");
                } else {
                    editDebtors editit = new editDebtors();
                    editit.editing(datastoring);
                }

                System.out.println("Do you wish to continue? Y/N ");
                String continuing = sc.nextLine();

                if (continuing.compareTo("N") == 0) {
                    break;
                }

            //Auto-deduction option
            } else if (input.compareTo("3") == 0){
                System.out.println("'Auto-deduction' is selected");

                if (datastoring.isEmpty()) {
                    System.out.println("Please add Debtors first!");
                } else {
                    for (HashMap datas : datastoring){
                        for (Object key : datas.keySet()){
                            Peopleowe check = (Peopleowe) datas.get(key);

                            for (Object currencyoweyou : check.getOweYou().keySet()){
                                for (Object currencyowethem : check.getOweThem().keySet()){
                                        String currenoweyou = (String) currencyoweyou;
                                        String currenowethem = (String) currencyowethem;
                                        if (currenoweyou.compareTo(currenowethem) == 0) {
                                            double oweyou = (double)check.getOweYou().get(currencyoweyou);
                                            double owethem = (double)check.getOweThem().get(currencyowethem);
                                            double leftover = Math.abs(oweyou - owethem);

                                            if (oweyou >= owethem){
                                                HashMap gettingedit = check.getOweYou();
                                                HashMap owingedit = check.getOweThem();

                                                gettingedit.remove(currenowethem);
                                                owingedit.remove(currenowethem);

                                                gettingedit.put(currenowethem, leftover);
                                                owingedit.put(currenowethem, 0.0);

                                            } else {
                                                HashMap gettingedit = check.getOweYou();
                                                HashMap owingedit = check.getOweThem();

                                                gettingedit.remove(currenowethem);
                                                owingedit.remove(currenowethem);

                                                gettingedit.put(currenowethem, 0.0);
                                                owingedit.put(currenowethem, leftover);
                                            }
                                        }

                                    }
                                }
                            }

                        }
                    }

                System.out.println("Do you wish to continue? Y/N ");
                String continuing = sc.nextLine();

                if (continuing.compareTo("N") == 0) {
                    break;
                }

            //Action to pay people
            } else if (input.compareTo("4") == 0) {
                System.out.println("'Paying others' is selected");

                if (datastoring.isEmpty()) {
                    System.out.println("Please add Debtors first!");
                } else {
                    Payment paypay = new Payment();
                    paypay.payup(datastoring);
                }

                System.out.println("Do you wish to continue? Y/N ");
                String continuing = sc.nextLine();

                if (continuing.compareTo("N") == 0) {
                    break;
                }

            //Summary of how much the User needs to pay
            } else if (input.compareTo("5") == 0) {
                System.out.println("'Summary' is selected");

                if (datastoring.isEmpty()) {
                    System.out.println("Please add Debtors first!");
                } else {
                    for (HashMap datas : datastoring) {
                        for (Object key : datas.keySet()) {
                            System.out.println(key + " owes you ");
                            Peopleowe toprint = (Peopleowe) datas.get(key);
                            HashMap<String, Double> whatpeopleoweyou = toprint.getOweYou();
                            for (String currency : whatpeopleoweyou.keySet()) {
                                Double moneyowetoyou = Double.valueOf(whatpeopleoweyou.get(currency));
                                System.out.println(currency + " " + formatter.format(moneyowetoyou));
                            }

                            System.out.println("You owe " + key);
                            HashMap<String, Double> whatyouowepeople = toprint.getOweThem();
                            for (String currency : whatyouowepeople.keySet()) {
                                Double moneytopay = Double.valueOf(whatyouowepeople.get(currency));
                                System.out.println(currency + " " + formatter.format(moneytopay));
                            }
                            System.out.println();
                        }
                    }
                }

                System.out.println("Do you wish to continue? Y/N ");
                String continuing = sc.nextLine();

                if (continuing.compareTo("N") == 0) {
                    break;
                }

            } else if (input.compareTo("6") == 0){
                Expenses track = new Expenses();
                track.trackExpenses();

                System.out.println("Do you wish to continue? Y/N ");
                String continuing = sc.nextLine();

                if (continuing.compareTo("N") == 0) {
                    break;
                }

            //Quit Application
            } else if (input.compareTo("X") == 0){
                break;
            } else {
                System.out.println("Error! Please key in again!");
            }
        }

    }
}