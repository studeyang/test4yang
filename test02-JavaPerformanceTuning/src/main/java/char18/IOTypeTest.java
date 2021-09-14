/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package char18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * I/O密集型线程数测试
 *
 * @author yangll
 */
public class IOTypeTest implements Runnable {

    // 整体执行时间，包括在队列中等待的时间
    Vector<Long> wholeTimeList;
    // 真正执行时间
    Vector<Long> runTimeList;

    private long initStartTime = 0;

    /**
     * 构造函数
     *
     * @param runTimeList
     * @param wholeTimeList
     */
    public IOTypeTest(Vector<Long> runTimeList, Vector<Long> wholeTimeList) {
        initStartTime = System.currentTimeMillis();
        this.runTimeList = runTimeList;
        this.wholeTimeList = wholeTimeList;
    }

    /**
     * IO 操作
     *
     * @return
     * @throws IOException
     */
    public void readAndWrite() throws IOException {
        File sourceFile = new File("D:/test.txt");
        // 创建输入流
        BufferedReader input = new BufferedReader(new FileReader(sourceFile));
        // 读取源文件, 写入到新的文件
        String line = null;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        // 关闭输入输出流
        input.close();
    }

    public void run() {
        long start = System.currentTimeMillis();
        try {
            readAndWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();


        long wholeTime = end - initStartTime;
        long runTime = end - start;
        wholeTimeList.add(wholeTime);
        runTimeList.add(runTime);
        System.out.println(" 单个线程花费时间：" + (end - start));
    }
}
