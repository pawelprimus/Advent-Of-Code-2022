package DAY_02;

import READER.FileReader;

import java.util.HashMap;
import java.util.Map;

public class DAY_02_2 {

    private static final String DAY = "02";

    // A X - ROCK
    // B Y - PAPER
    // C Z - SCISSORS

    // X - LOSE
    // Y - DRAW
    // Z - WIN

    // AX - 4  AY - 8 +  AZ - 3
    // BX - 1 + BY - 5 + BZ - 9
    // CX - 7 + CY - 2 + CZ - 6

    private static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        String[] input = FileReader.readFileAsString(DAY).split("[\\r\\n]+");
        fillMap();

        int result = 0;

        for (String str : input) {
            String newPlayCombination = str.charAt(0) + getAnswer(str.charAt(0) + "", str.charAt(2) + "");
            result += resultMap.get(newPlayCombination);
        }
        System.out.println("RESULT: " + result);
    }

    private static String getAnswer(String oponent, String winDrawLow) {

        switch (winDrawLow) {
            case "X":
                switch (oponent) {
                    case "A":
                        return "Z";
                    case "B":
                        return "X";
                    case "C":
                        return "Y";
                    default:
                        return "";
                }
            case "Y":
                switch (oponent) {
                    case "A":
                        return "X";
                    case "B":
                        return "Y";
                    case "C":
                        return "Z";
                    default:
                        return "";
                }
            case "Z":
                switch (oponent) {
                    case "A":
                        return "Y";
                    case "B":
                        return "Z";
                    case "C":
                        return "X";
                    default:
                        return "";
                }
        }
        return "";
    }

    private static void fillMap() {
        resultMap.put("AX", 4);
        resultMap.put("AY", 8);
        resultMap.put("AZ", 3);

        resultMap.put("BX", 1);
        resultMap.put("BY", 5);
        resultMap.put("BZ", 9);

        resultMap.put("CX", 7);
        resultMap.put("CY", 2);
        resultMap.put("CZ", 6);
    }
}
