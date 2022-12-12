package DAY_02;

import READER.FileReader;

import java.util.HashMap;
import java.util.Map;

public class DAY_02_1 {

    private static final String DAY = "02";

    // A X - ROCK
    // B Y - PAPER
    // C Z - SCISSORS

    private static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        String[] input = FileReader.readFileAsString(DAY).split("[\\r\\n]+");
        fillMap();
        int result = 0;

        for (String str : input) {
            result += resultMap.get(str.replaceAll("\\s", ""));
        }
        System.out.println("RESULT: " + result);
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
