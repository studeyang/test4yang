import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyClass {

    /*
    输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8 这8个数字，则最小的4个数字是1、2、3、4。

    示例 1：

    ```
    输入：arr = [3,2,1], k = 2
    输出：[1,2] 或者 [2,1]
    ```

    示例 2：

    ```
    输入：arr = [0,1,2,1], k = 1
    输出：[0]
    ```
    */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
//        int[] arr = new int[]{3,2,1};
        int[] array = new MyClass().getLeastNumbers(arr, 4);
        for (int s : array) {
            System.out.println(s);
        }

    }

}
