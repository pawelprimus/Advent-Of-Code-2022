package DAY_06;

import READER.FileReader;

public class DAY_06_2 {

    private static final String DAY = "06";
    private static final int MARKET_LENGTH = 14;

    public static void main(String[] args) throws Exception {

        String input = FileReader.readFileAsString(DAY);
        int result = 0;

        for (int i = 0; i < input.length() - MARKET_LENGTH; i++) {
            if (isHereFourUniqueCharacters(input.substring(i, i + MARKET_LENGTH))) {
                System.out.println(input.substring(i, i + MARKET_LENGTH));
                result = i + MARKET_LENGTH;
                break;
            }
        }

        System.out.println("RESULT: " + result);
    }

    private static boolean isHereFourUniqueCharacters(String word) {
        int[] occurences = new int[26];
        for (int i = 0; i < word.length(); i++) {
            occurences[word.charAt(i) - 97]++;
        }
        int ones = 0;
        for (int i = 0; i < occurences.length; i++) {
            if (occurences[i] == 1) {
                ones++;
            }
        }
        return ones == MARKET_LENGTH;
    }
}
