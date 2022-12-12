package DAY_03;

import READER.FileReader;

public class DAY_03_1 {

    private static final String DAY = "03";

    public static void main(String[] args) throws Exception {

        String[] input = FileReader.readFileAsString(DAY).split("[\\r\\n]+");
        int result = 0;
        for (String str : input) {
            result += getPointFromLine(str);
        }

        System.out.println("RESULT: " + result);
    }

    private static int getPointFromLine(String line) {
        String firstPart = line.substring(0, line.length() / 2);
        String secondPart = line.substring(line.length() / 2);

        char commonChar = getCommontChar(firstPart, secondPart);

        return Character.isLowerCase(commonChar) ? commonChar - 96 : commonChar - 38;
    }

    private static char getCommontChar(String firstWord, String secondWord) {

        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 0; j < secondWord.length(); j++) {
                if (firstWord.charAt(i) == secondWord.charAt(j)) {
                    return firstWord.charAt(i);
                }
            }
        }
        return '@';
    }
}
