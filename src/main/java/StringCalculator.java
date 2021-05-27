public class StringCalculator {
    public int add(String num){
        if (num == null || num.isEmpty()) {
            return 0;
        }
        int sum=0;
        String[] listNum = num.split(",|\n");
        for (String xx : listNum) {
            int value = Integer.parseInt(xx);
            sum += value;
        }
        return sum;
    }
}