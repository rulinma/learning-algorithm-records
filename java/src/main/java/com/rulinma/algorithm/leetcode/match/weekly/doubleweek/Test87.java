package com.rulinma.algorithm.leetcode.match.weekly.doubleweek;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 马如林
 * @Data 2022/9/17 22:52
 */
public class Test87 {

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
        int rs = test87.countDaysTogether("01-01", "01-01", "01-01", "01-01");

        System.out.println(rs);
    }

}
