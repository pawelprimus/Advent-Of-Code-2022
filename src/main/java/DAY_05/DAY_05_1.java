package DAY_05;

import READER.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DAY_05_1 {

    private static final String DAY = "05";
    private static final String MOVES_REGEX = "move (\\d+) from (\\d+) to (\\d+)";

    public static void main(String[] args) throws Exception {

        String[] input = FileReader.readFileAsString(DAY).split("[\\r]");
        String result = "";
        int createsIndex = 0;
        List<String> crates = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            crates.add(input[i].replaceAll("\\n", ""));
            if (input[i].equals("\n")) {
                createsIndex = i;
                break;
            }
        }

        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            stacks.add(new Stack<>());
        }

        for (int i = crates.size() - 2; i >= 0; i--) {
            System.out.println(crates.get(i).charAt(1));
            ifIsLetterAddToStack(stacks.get(0), crates.get(i).charAt(1));
            ifIsLetterAddToStack(stacks.get(1), crates.get(i).charAt(5));
            ifIsLetterAddToStack(stacks.get(2), crates.get(i).charAt(9));
            ifIsLetterAddToStack(stacks.get(3), crates.get(i).charAt(13));
            ifIsLetterAddToStack(stacks.get(4), crates.get(i).charAt(17));
            ifIsLetterAddToStack(stacks.get(5), crates.get(i).charAt(21));
            ifIsLetterAddToStack(stacks.get(6), crates.get(i).charAt(25));
            ifIsLetterAddToStack(stacks.get(7), crates.get(i).charAt(29));
            ifIsLetterAddToStack(stacks.get(8), crates.get(i).charAt(33));
        }

        for (int i = createsIndex + 1; i < input.length; i++) {
            // move 3 from 2 to 1
            int[] moves = getMovesFromLine(input[i]);
            for (int j = 0; j < moves[0]; j++) {
                Character poped = stacks.get(moves[1] - 1).pop();
                stacks.get(moves[2] - 1).push(poped);
            }
        }
        System.out.println("---------");
        for (Stack<Character> stack1 : stacks) {
            result += stack1.get(stack1.size() - 1).toString();
        }
        System.out.println("RESULT: " + result);
    }

    static void ifIsLetterAddToStack(Stack<Character> stack, Character character) {
        if (Character.isLetter(character)) {
            stack.push(character);
        }
    }


    private static int[] getMovesFromLine(String line) {
        Pattern r = Pattern.compile(MOVES_REGEX);
        Matcher m = r.matcher(line);
        String first = "";
        String second = "";
        String third = "";
        if (m.find()) {
            first = m.group(1);
            second = m.group(2);
            third = m.group(3);
        }

        return new int[]{Integer.parseInt(first), Integer.parseInt(second), Integer.parseInt(third)};
    }
}
