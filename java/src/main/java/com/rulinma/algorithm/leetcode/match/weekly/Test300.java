package com.rulinma.algorithm.leetcode.match.weekly;

import com.rulinma.algorithm.leetcode.common.ListNode;
import javafx.util.Pair;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/8/31 11:14
 */
public class Test300 {

    int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        //dp[i] 表示第 i 天新增了多少人
        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            // 找第 i 天前，能对第 i 天造成影响的日子，
            // 1. 在 i - forget 以前的新增都忘记了，所以无影响
            // 2. 在 i -delay 之后的日子，还没有开始传播，所以无影响
            // 有密码 没有忘记 能传播的人数
            for (int j = Math.max(i - forget + 1, 0); j <= i - delay; j++) {
                dp[i] = (dp[i] + dp[j]) % MOD;
            }
        }

        int res = 0;

        //第 n 天还剩余的人数，为最后几天新增的人数之和
        for (int i = n - forget + 1; i <= n; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;
    }

    /**
     * 2326. 螺旋矩阵 IV
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];

        int[][] visited = new int[m][n];
        List<Pair> list = new ArrayList<>();

        // 按照顺时针顺序打印i和j
        // i++
        int i = 0;
        int j = 0;

        // row和col变化
        // 右 下 左 上 遇到墙则调整为 下 左 上 右
        int count = 0;
        count++;
        visited[i][j] = 1;
        list.add(new Pair(i, j));

        while (true) {
            // 退出循环
            if (count == m * n) {
                break;
            }
            // 检查下一个值
            // 向右走是否合法
            while (j + 1 < n && visited[i][j + 1] == 0) {
                j++;
                count++;
                visited[i][j] = 1;
                list.add(new Pair(i, j));
//                System.out.println("i: " + i + " j: " + j);
            }
            // 向下走是否合法
            while (i + 1 < m && visited[i + 1][j] == 0) {
                i++;
                count++;
                visited[i][j] = 1;
                list.add(new Pair(i, j));
//                System.out.println("i: " + i + " j: " + j);
            }
            // 向左走
            while (j - 1 >= 0 && visited[i][j - 1] == 0) {
                j--;
                count++;
                visited[i][j] = 1;
                list.add(new Pair(i, j));
//                System.out.println("i: " + i + " j: " + j);
            }
            // 向上走
            while (i - 1 >= 0 && visited[i - 1][j] == 0) {
                i--;
                count++;
                visited[i][j] = 1;
                list.add(new Pair(i, j));
//                System.out.println("i: " + i + " j: " + j);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        while (head != null) {
            list1.add(head.val);
            head = head.next;
        }

        for (int k = 0; k < list.size(); k++) {
            int r = (int) list.get(k).getKey();
            int c = (int) list.get(k).getValue();
            if (k < list1.size() && list1.get(k) != null) {
                ans[r][c] = list1.get(k);
            } else {
                ans[r][c] = -1;
            }
        }

        return ans;
    }

    /**
     * 2325. 解密消息
     */
    public String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();
        // 1 建立映射表
        // 2 替换message
        char[] ks = key.toCharArray();

        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();

        int i = 0;
        for (char ch : ks) {
            if (ch != ' ') {
                if (!set.contains(ch)) {
                    map.put(ch, (char) ('a' + i));
                    i++;
                    set.add(ch);
                }
            }
        }

        char[] msgs = message.toCharArray();
        for (char ch : msgs) {
            if (ch != ' ') {
                sb.append(map.get(ch));
            } else {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        String key = "the quick brown fox jumps over the lazy dog";
//        String message = "vkbs bs t suepuv";
//
//        String rs = new Test300().decodeMessage(key, message);
//        System.out.println(rs);

//        int m = 3;
//        int n = 5;
//        ListNode head = new ListNode(3);
//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(6);
//        ListNode l4 = new ListNode(8);
//        ListNode l5 = new ListNode(1);
//        ListNode l6 = new ListNode(7);
//        ListNode l7 = new ListNode(9);
//        ListNode l8 = new ListNode(4);
//        ListNode l9 = new ListNode(2);
//        ListNode l10 = new ListNode(5);
//        ListNode l11 = new ListNode(5);
//        ListNode l12 = new ListNode(0);
//
//        head.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
//        l7.next = l8;
//        l8.next = l9;
//        l9.next = l10;
//        l10.next = l11;
//        l11.next = l12;
//
//        int[][] ans = new Test300().spiralMatrix(m, n, head);
//
//        System.out.println(ans);

        int n = 6, delay = 2, forget = 4;
        Test300 test300 = new Test300();
        int rs = test300.peopleAwareOfSecret(n, delay, forget);
        System.out.println(rs);

        System.out.println(test300.peopleAwareOfSecret(4, 1, 3));
    }

}
