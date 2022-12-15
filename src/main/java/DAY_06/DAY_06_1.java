package DAY_06;

import READER.FileReader;

public class DAY_06_1 {

    private static final String DAY = "06";

    public static void main(String[] args) throws Exception {

        String input = FileReader.readFileAsString(DAY);
        int result = 0;

        for (int i = 0; i < input.length() - 4; i++) {
            if (isHereFourUniqueCharacters(input.substring(i, i + 4))) {
                System.out.println(input.substring(i, i + 4));
                result = i + 4;
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
        return ones == 4;
    }
}
