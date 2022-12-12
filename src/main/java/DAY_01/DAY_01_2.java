package DAY_01;


import READER.FileReader;

import java.util.ArrayList;
import java.util.List;

public class DAY_01_2 {

    public static void main(String[] args) throws Exception {

        String[] input = FileReader.readFileAsString("01").split("[\\r]");

        int currentSum = 0;

        List<Integer> allCalories = new ArrayList<>();
        for (String str : input) {

            if (str.equals("\n")) {
                allCalories.add(currentSum);
                currentSum = 0;
            } else {
                currentSum += Integer.valueOf(str.replaceAll("\n", ""));
            }
        }
        allCalories.add(currentSum);

        int result = allCalories.stream().sorted().skip(Math.max(0, allCalories.size() - 3)).reduce(0, Integer::sum);

        System.out.println("RESULT: " + result);
    }
}
