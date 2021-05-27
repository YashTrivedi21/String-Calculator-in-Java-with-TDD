import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String num){
        if (num == null || num.isEmpty()) {
            return 0;
        }
        int i = 0, j = 0;
        boolean check = false;
        if(num.contains("[") && num.contains("]")){
            i = num.indexOf("[");
            j = num.indexOf("]");
            check = true;

        }
        List<String> negatives = new ArrayList<String>();

        String delimiter = ",";
        if(check){
            delimiter = num.substring(i+1, j);
            num = num.substring(j+1);
        }
        else {
            if (num.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(num.charAt(2));
                num = num.substring(4);
            }
        }
        int sum = 0;
        String [] listNum = num.split(delimiter + "|\n");
        for (String xx : listNum) {
            int val = xx.isEmpty()?0:Integer.parseInt(xx);
            if (val < 0) {
                negatives.add(xx);
            }
            if(val<=1000) {
                sum += val;
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "Negatives not allowed " + String.join(",", negatives));
        }
        return sum;
    }
}