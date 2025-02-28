import java.util.List;
import java.util.ArrayList;

public class SumOfIntegers {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("10");
        stringList.add("20");
        stringList.add("30");
        
        int sum = calculateSum(stringList);
        System.out.println("Sum: " + sum);
    }

    public static int calculateSum(List<String> stringList) {
        int sum = 0;
        for (String str : stringList) {
            Integer number = Integer.parseInt(str);
            sum += number;
        }
        return sum;
    }
}
