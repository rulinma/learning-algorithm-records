package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

/**
 * 654. 最大二叉树
 * <p>
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 * <p>
 * https://leetcode.cn/problems/maximum-binary-tree
 *
 * @author 马如林
 * @Data 2022/8/24 16:46
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        // 递归出口
        if (left > right) {
            return null;
        }

        int maxIndex = getMax(nums, left, right);
        TreeNode rootNode = new TreeNode(nums[maxIndex]);
        // 设置左边
        TreeNode leftNode = build(nums, left, maxIndex - 1);
        // 设置右边
        TreeNode rightNode = build(nums, maxIndex + 1, right);

        rootNode.left = leftNode;
        rootNode.right = rightNode;

        return rootNode;
    }

    public int getMax(int[] nums, int left, int right) {
        int maxIndex = left;
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[maxIndex];
            }
        }
        return maxIndex;
    }
}
