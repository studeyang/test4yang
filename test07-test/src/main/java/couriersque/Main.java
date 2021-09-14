package couriersque;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yanglulu
 * @date 2021/7/9
 */
public class Main {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = Main.class.getResourceAsStream("/couriersque/check_squence.txt");

        List<String> lines = IOUtils.readLines(inputStream, "UTF-8");

        for (int i = 0; i < lines.size(); i++) {
            // 结束标识
            if ("##".equals(lines.get(i + 1))) {
                break;
            }

            int first = Integer.parseInt(lines.get(i));
            int second = Integer.parseInt(lines.get(i + 1));
            if (first + 1 != second) {
                System.out.println("error of " + i);
            }
        }
    }

}
