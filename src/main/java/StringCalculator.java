import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String num){
        if (num == null || num.isEmpty()) {
            return 0;
        }
        List<String> negatives = new ArrayList<String>();
        String delimiter = ",";
        if(num.matches("//(.*)\n(.*)")){
            delimiter = Character.toString(num.charAt(2));
            num = num.substring(4);
        }
        int sum = 0;
        String [] listNum = num.split(delimiter + "|\n");
        for (String xx : listNum) {
            int val = Integer.parseInt(xx);
            if (val < 0) {
                negatives.add(xx);
            }
            sum += val;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "Negatives not allowed " + String.join(",", negatives));
        }
        return sum;
    }
}