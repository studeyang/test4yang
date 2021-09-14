package string;

import java.util.Scanner;

public class StringRunMem {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder data = new StringBuilder();
        while ("10".equals(scanner.next())) {
            data.append(get10Mdata());
        }
        System.out.println(data.length());
    }

    private static String get10Mdata() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 65534; i++) {
            builder.append("a");
        }
        return builder.toString();
    }

}
