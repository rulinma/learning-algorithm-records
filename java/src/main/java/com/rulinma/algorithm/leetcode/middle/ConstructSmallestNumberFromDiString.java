package com.rulinma.algorithm.leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 2375. 根据模式串构造最小数字
 * <p>
 * 给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。
 * <p>
 * 你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件：
 * <p>
 * num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。
 * 如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。
 * 如果 pattern[i] == 'D' ，那么 num[i] > num[i + 1] 。
 * 请你返回满足上述条件字典序 最小 的字符串 num。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pattern = "IIIDIDDD"
 * 输出："123549876"
 * 解释：
 * 下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。
 * 下标 3 ，5 ，6 和 7 处，我们需要使 num[i] > num[i+1] 。
 * 一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
 * "123549876" 是满足条件最小的数字。
 * 注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。
 * 示例 2：
 * <p>
 * 输入：pattern = "DDD"
 * 输出："4321"
 * 解释：
 * 一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
 * "4321" 是满足条件最小的数字。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= pattern.length <= 8
 * pattern 只包含字符 'I' 和 'D' 。
 * <p>
 * https://leetcode.cn/problems/construct-smallest-number-from-di-string
 *
 * @author 马如林
 * @Data 2022/8/25 16:43
 */
public class ConstructSmallestNumberFromDiString {

    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();

        int len = pattern.length();
        // 双向队列
        Deque<Integer> deque = new LinkedList<>();

        int cur = 0;
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'I') {
                // 检查stack是否为空，并且stack的元素是否
                if (deque.size() == 0) {
                    sb.append(++cur);
                } else {
                    // 先添加deque size大小的内容，再添加i
                    int sz = deque.size();
                    while (sz > 0) {
                        sb.append(cur + sz + 1);
                        sz--;
                    }
                    sb.append(cur + 1);
                    cur = cur + deque.size() + 1;
                    deque.clear();
                }
            } else if (chars[i] == 'D') {
                deque.add(i + 1);
            }
        }

        // 最后一个数字
        if (chars[len - 1] == 'I') {
            sb.append(len + 1);
        }

        if (chars[len - 1] == 'D') {
            deque.add(len);
        }

        // deque处理到非空
        int sz = deque.size();
        while (sz > 0) {
            sb.append(cur + sz);
            sz--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ConstructSmallestNumberFromDiString constructSmallestNumberFromDiString = new ConstructSmallestNumberFromDiString();

        String rs = constructSmallestNumberFromDiString.smallestNumber("IIIDIDDD");
        System.out.println(rs);

        String rs1 = constructSmallestNumberFromDiString.smallestNumber("DDDI");
        System.out.println(rs1);
    }

}
