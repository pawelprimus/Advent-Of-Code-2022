package DAY_04;

import READER.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DAY_04_2 {

    private static final String DAY = "04";

    private static final String NUM_PERIOD_REG = "(\\d+-\\d+),(\\d+-\\d+)";

    public static void main(String[] args) throws Exception {

        String[] input = FileReader.readFileAsString(DAY).split("[\\r\\n]+");
        int result = 0;
        for (String str : input) {
            if (areOverlap(str)) {
                result++;
            }
        }
        System.out.println("RESULT: " + result);
    }


    private static boolean areOverlap(String line) {

        Pattern r = Pattern.compile(NUM_PERIOD_REG);
        Matcher m = r.matcher(line);
        String[] firstPeriod = new String[]{};
        String[] secondPeriod = new String[]{};
        if (m.find()) {
            firstPeriod = m.group(1).split("-");
            secondPeriod = m.group(2).split("-");
        }

        int[] first = new int[]{Integer.parseInt(firstPeriod[0]), Integer.parseInt(firstPeriod[1])};
        int[] second = new int[]{Integer.parseInt(secondPeriod[0]), Integer.parseInt(secondPeriod[1])};


        if(second[0] >= first[0] && second[0] <= first[1]){
            return true;
        }
        if(second[1] >= first[0] && second[0] <= first[1]){
            return true;
        }

        if(first[0] >= second[0] && first[0] <= second[1]){
            return true;
        }
        if(first[1] >= second[0] && first[0] <= second[1]){
            return true;
        }

        return false;
    }

}
