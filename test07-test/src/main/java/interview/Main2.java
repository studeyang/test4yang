package interview;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {
        //ace
        //abcde
        try (Scanner in = new Scanner(System.in);) {
            // 短字符串
            String shortString = in.nextLine();
            // 长字符串
            String longString = in.nextLine();
            int result = getResult(shortString, longString);
            System.out.println(result);
        }
    }

    private static int getResult(String shortString, String longString) {
        int i = 0;
        int j = 0;
        int result = -1;
        while (i < shortString.length() && j < longString.length()) {
            if (shortString.charAt(i) == longString.charAt(j)) {
                result = j;
                i++;
            }
            j++;
            if (j == longString.length() && result == -1) {
                break;
            }
        }
        return result;
    }

}
