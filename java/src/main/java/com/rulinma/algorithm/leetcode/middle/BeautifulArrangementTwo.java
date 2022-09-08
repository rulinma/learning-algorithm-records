package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/8 08:40
 */
public class BeautifulArrangementTwo {

    /**
     * 对于其它的一般情况，我们可以将这两种特殊情况进行合并，即列表的前半部分相邻差均为 1，
     * 后半部分相邻差从 k 开始逐渐递减到 1，这样从 1 到 k 的差值均出现一次，对应的列表即为：
     * [1,2,⋯,n−k,n,n−k+1,n−1,n−k+2,⋯]
     */
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];

        int idx = 0;
        for (int i = 1; i < n - k; ++i) {
            answer[idx] = i;
            ++idx;
        }

        // 从n-k开始
        for (int i = n - k, j = n; i <= j; ++i, --j) {
            answer[idx] = i;
            ++idx;
            // 最后一个特殊处理
            if (i != j) {
                answer[idx] = j;
                ++idx;
            }
        }

        return answer;
    }

    /**
     * 如果有 n 个数字，最大值 k 可以是 n - 1，定义左、右两个指针 l 和 r，随着 k 的递减，分别处理其奇偶位置不同的情况：
     * <p>
     * k 是奇数：填充当前位置的值为 l；
     * k 是偶数：将 r 填充到当前位置。
     * 当 k 不满足条件时，说明已全部处理，剩下的位置全部填充升序或降序的序列即可。
     */
    public int[] constructArray1(int n, int k) {
        int[] ret = new int[n];
        for (int l = 1, r = n, i = 0; i < n; i++) {
            ret[i] = k % 2 == 0 ? r-- : l++;
            if (k > 1) {
                k--;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        BeautifulArrangementTwo beautifulArrangementTwo = new BeautifulArrangementTwo();

        int[] arr = beautifulArrangementTwo.constructArray(3, 1);

        System.out.println(Arrays.toString(arr));
    }
}
