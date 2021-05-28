import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String num){
        if(num==null || num.isEmpty()){
            return 0;
        }
        boolean check=false;
        List<Integer> op = new ArrayList<>();
        List<Integer> cp = new ArrayList<>();
        for(int k=0;k<num.length();k++){
            if(num.charAt(k) == '['){
                op.add(k);
                check=true;
            } else if(num.charAt(k) == ']'){
                cp.add(k);
            }
        }
        List<String> del = new ArrayList<>();
        for(int i=0;i<op.size();i++){
            del.add(num.substring(op.get(i) + 1, cp.get(i)));
        }
        String delimiter = ",";
        if(check) {
            num = num.substring(cp.get(cp.size()-1)+2);
            for (String s : del) {
                num = num.replace(s, ",");
            }
        } else{
            if(num.charAt(0) == '/'){
                delimiter = "" + num.charAt(2);
                num = num.substring(4);
                num = num.replace(delimiter, ",");
            }
        }

        num=num.replace("\n",",");
        String [] listNum = num.split("[,]",0);
        List<String> negatives = new ArrayList<>();
        int sum=0;
        for(String xx:listNum){
            int val = xx.isEmpty()?0:Integer.parseInt(xx);
            if(val<0){
                negatives.add(xx);
            }
            if(val<=1000){
                sum+=val;
            }
        }
        if(!negatives.isEmpty()){
            throw new IllegalArgumentException(
                    "Negatives not allowed " + String.join(",", negatives));
        }
        return sum;
    }
}
