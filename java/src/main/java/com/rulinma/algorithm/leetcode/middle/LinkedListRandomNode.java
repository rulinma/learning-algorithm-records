package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.ListNode;

import java.util.Random;

/**
 * 382. 链表随机节点
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出
 * [null, 1, 3, 2, 2, 3]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // 返回 1
 * solution.getRandom(); // 返回 3
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 3
 * // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中的节点数在范围 [1, 104] 内
 * -104 <= Node.val <= 104
 * 至多调用 getRandom 方法 104 次
 * <p>
 * https://leetcode.cn/problems/linked-list-random-node
 *
 * @author 马如林
 * @Data 2022/8/3 17:43
 */
public class LinkedListRandomNode {
    ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int i = 1;
        int ans = 0;
        Random random = new Random();
        ListNode node = head;

        while (node != null) {
            if (random.nextInt(i) == 0) {
                ans = node.val;
            }
            ++i;
            node = node.next;
        }

        return ans;
    }
}
