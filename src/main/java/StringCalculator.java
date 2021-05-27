public class StringCalculator {
    public int add(String num){
        if (num == null || num.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        if(num.matches("//(.*)\n(.*)")){
            delimiter = Character.toString(num.charAt(2));
            num = num.substring(4);
        }
        int sum = 0;
        String [] listNum = num.split(delimiter + "|\n");
        for (String xx : listNum) {
            int val = Integer.parseInt(xx);
            sum += val;
        }
        return sum;
    }
}