package interview;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            // 输入的字符串  abC124ACb
            String input = in.nextLine();
            // 满足条件的最长子串是C124或者124A，长度都是4
            System.out.println(getSubLength(input));
        }
    }

    private static int getSubLength(String input) {
        int result = -1;
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 2; j < input.length() + 1; j++) {
                String subString = input.substring(i, j);
                if (subString.replaceAll("[0-9]", "").length() == 1) {
                    result = Math.max(subString.length(), result);
                }
            }
        }
        return result;
    }

}
