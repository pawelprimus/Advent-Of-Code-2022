package DAY_03;

import READER.FileReader;

public class DAY_03_2 {

    private static final String DAY = "03";

    public static void main(String[] args) throws Exception {

        String[] input = FileReader.readFileAsString(DAY).split("[\\r\\n]+");
        int result = 0;

        for (int i = 0; i < input.length; i += 3) {
            result += getPointFromLine(input[i], input[i + 1], input[i + 2]);
        }
        System.out.println("RESULT: " + result);
    }

    private static int getPointFromLine(String first, String second, String third) {
        char commonChar = getCommontChar(first, second, third);

        return Character.isLowerCase(commonChar) ? commonChar - 96 : commonChar - 38;
    }

    private static char getCommontChar(String first, String second, String third) {

        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                for (int k = 0; k < third.length(); k++) {
                    if (first.charAt(i) == second.charAt(j) && second.charAt(j) == third.charAt(k)) {
                        return first.charAt(i);
                    }
                }

            }
        }
        return '@';
    }
}
