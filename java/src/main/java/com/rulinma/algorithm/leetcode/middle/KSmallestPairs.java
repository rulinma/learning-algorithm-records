package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 061. 和最小的 k 个数对
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * https://leetcode.cn/problems/qn8gGX
 *
 * @author 马如林
 * @Data 2022/8/3 21:39
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 优先级队列处理
        // 创建一个大根堆，堆中元素排序按照数对和进行逆序排序。
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(
                (pair1, pair2) -> pair2.get(0) + pair2.get(1) - pair1.get(0) - pair1.get(1)
        );

        // 数组1取前k个数 （长度n小于k则取n个，数组2也相同）,组成 k*k 个数对
        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 将数对加入大根堆中
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                heap.add(list);
                // 如果大根堆中的元素总量超过 k , 则将大根堆的堆顶元素删除。
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        // 最后剩下的大根堆中的数对就是和最小的k个数对，将其保存到列表中。
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Iterator<List<Integer>> iterator = heap.iterator();
        while (iterator.hasNext()) {
            ans.add(iterator.next());
        }
        return ans;
    }
}
