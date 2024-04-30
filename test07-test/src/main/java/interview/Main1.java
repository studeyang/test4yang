package interview;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {

    private static int totalSum = 0;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 1 2 3 4 5 6 7 8 9 10
        try (Scanner in = new Scanner(System.in)) {
            // 输入的10个数
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = in.nextInt();
                totalSum += nums[i];
            }
            int target = totalSum / 2;
            // 深度优先
            dfs(nums, 0, 0, 0, target);
            System.out.println(result);
        }
    }

    private static void dfs(int[] nums, int pathSum, int pathLen, int startIdx, int target) {
        if (pathSum > target) {
            return;
        }
        if (pathLen == 5) {
            result = Math.min(result, totalSum - 2 * pathSum);
            return;
        }
        for (int i = startIdx; i < 10; i++) {
            dfs(nums, pathSum + nums[i], pathLen + 1, i + 1, target);
        }
    }

}
