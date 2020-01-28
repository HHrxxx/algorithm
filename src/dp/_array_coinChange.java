package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 零钱兑换。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * dp[i]=Math.min(dp[i-coins[j]]+1, dp[i]) coins[1,2,5]
 * f(11)=min{f(10),f(9),f(6)}+1 以此类推
 */
public class _array_coinChange {

    private static int countByMap(int[] arr, int index, int target) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int res = 0;
        if (index == arr.length) {
            res = target == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= target; i++) {
                int nextAim = target - i * arr[index];
                String key = String.valueOf(index + 1) + "_" + String.valueOf(nextAim);
                if (map.containsKey(key)) {
                    res += map.get(key);
                } else {
                    res += countByMap(arr, index + 1, nextAim);
                }
            }
        }
        map.put(String.valueOf(index + 1) + "_" + String.valueOf(target), res);
        return res;
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0)
            return 0;
        int[] dp = new int[amount + 1];
        // getMin 初值设置Integer.MAX_VALUE
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if ((i - coins[j]) >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        // 没有匹配的则返回-1
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.substring(1, str.length() - 1);
        String[] r = str.split(",");
        int N = sc.nextInt();
        int[] arr = new int[r.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(r[i]);
        }
        System.out.println(coinChange(arr, N));
        System.out.println(countByMap(arr, 0, N));
    }

}
