package com.rulinma.algorithm.leetcode.match.weekly.doubleweek;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 马如林
 * @Data 2022/9/17 22:52
 */
public class Test87 {

    public long minimumMoney(int[][] transactions) {
        // 1. 先把所有能赚的钱拿到
        // 2. 再看所有负值的值
        // 3. 统计+ -

        int ans = 0;
        int[] m = new int[transactions.length];

        for (int i = 0; i < transactions.length; i++) {
            int v = transactions[i][1] - transactions[i][0];
        }

        if (ans >= 0) {
            return 0;
        }

        return ans;
    }

    /**
     * 6186. 按位或最大的最小子数组长度
     */
    public int[] smallestSubarrays(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            int v = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int last = v;
                v = v | nums[j];
//                if (v < last) {
//                    ans[i] = j - i - 1;
//                    break;
//                }
            }
        }

        ans[nums.length - 1] = 1;

        return ans;
    }

    /**
     * 6185. 运动员和训练师的最大匹配数
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int c = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);

        Deque<Integer> deque = new LinkedList<>();
        for (int n : trainers) {
            deque.add(n);
        }

        for (int i : players) {
            // trainers
            while (!deque.isEmpty()) {
                if (deque.peek() >= i) {
                    c++;
                    deque.poll();
                    break;
                }
                deque.poll();
            }
        }

        return c;
    }

    /**
     * 6184. 统计共同度过的日子数
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int ans = 0;

        // 检测合法输入


        // 计算日期是一年的多少天 s1 - e1 s2 - e2
        // 2个区间的重复 max(s1,s2) min(e1, e2)
        //
        int s1 = getDays(arriveAlice);
        int e1 = getDays(leaveAlice);

        int s2 = getDays(arriveBob);
        int e2 = getDays(leaveBob);

        System.out.println("s1: " + s1 + " e1: " + e1 + " s2: " + s2 + " e2: " + e2);
        ans = Math.min(e1, e2) - Math.max(s1, s2) + 1;

        if (ans > 0) {
            return ans;
        }

        return 0;
    }

    private int getDays(String date) {
        int m = Integer.parseInt(date.split("-")[0]);
        int d = Integer.parseInt(date.split("-")[1]);
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int ans = 0;
        for (int i = 0; i < m - 1; i++) {
            ans += days[i];
        }

        ans += d;

        return ans;
    }

    public static void main(String[] args) {
        Test87 test87 = new Test87();
//        int rs = test87.countDaysTogether("09-01", "10-19", "06-19", "10-20");
//        int rs = test87.countDaysTogether("01-01", "01-01", "01-01", "01-01");

        int[] rs = test87.smallestSubarrays(new int[]{1, 0, 2, 1, 3});
        System.out.println(Arrays.toString(rs));
    }

}
