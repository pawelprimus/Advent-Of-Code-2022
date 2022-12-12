package DAY_01;


import READER.FileReader;

public class DAY_01_1 {

    public static void main(String[] args) throws Exception {

        String[] input = FileReader.readFileAsString("01").split("[\\r]");

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (String str : input) {
            if (str.equals("\n")) {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                currentSum = 0;
            } else {
                currentSum += Integer.parseInt(str.replaceAll("\n", ""));
            }
        }
        if (currentSum > maxSum) {
            maxSum = currentSum;
        }

        System.out.println("RESULT:" + maxSum);
    }
}
