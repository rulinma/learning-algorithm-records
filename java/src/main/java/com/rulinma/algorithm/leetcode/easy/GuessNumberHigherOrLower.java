package com.rulinma.algorithm.leetcode.easy;

/**
 * 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * <p>
 * https://leetcode.cn/problems/guess-number-higher-or-lower
 *
 * @author 马如林
 * @Data 2022/6/24 12:35
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int low = 1;
        int higher = n;

        while (low <= higher) {
            int middle = (higher - low) / 2 + low;
            int result = guess(middle);
            if (result == 0) {
                return middle;
            } else if (result == -1) {
                higher = middle - 1;
            } else if (result == 1) {
                low = middle + 1;
            }
        }

        return -1;
    }

    private int guess(int middle) {
        return 1;
    }
}
