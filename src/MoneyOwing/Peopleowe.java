package MoneyOwing;

import java.util.HashMap;

public class Peopleowe {
    private HashMap<String, Double> oweyou;
    private HashMap<String, Double> owethem;

    public Peopleowe(HashMap oweyou, HashMap owethem) {
        this.oweyou = oweyou;
        this.owethem = owethem;
    }

    public HashMap getOweYou(){
        return this.oweyou;
    }

    public HashMap getOweThem(){
        return this.owethem;
    }
}
