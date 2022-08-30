package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

/**
 * 998. 最大二叉树 II
 * <p>
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * <p>
 * 给你最大树的根节点 root 和一个整数 val 。
 * <p>
 * 就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
 * <p>
 * 如果 a 为空，返回 null 。
 * 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
 * root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回 root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
 * <p>
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * <p>
 * 返回 Construct(b) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,2,4,null,1], val = 3
 * 输出：[5,2,4,null,1,null,3]
 * 解释：a = [2,1,5,4], b = [2,1,5,4,3]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [5,2,3,null,1], val = 4
 * 输出：[5,2,4,null,1,3]
 * 解释：a = [2,1,5,3], b = [2,1,5,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 100] 内
 * 1 <= Node.val <= 100
 * 树中的所有值 互不相同
 * 1 <= val <= 100
 * <p>
 * <p>
 * https://leetcode.cn/problems/maximum-binary-tree-ii
 *
 * @author 马如林
 * @Data 2022/8/30 08:07
 */
public class MaximumBinaryTreeTwo {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode rs = null;
        // 其中每个节点的值都大于其子树中的任何其他值。
        // insert val
        // 1. root == null 创建
        // 2. > root, 创建新节点，并把旧的添加到左子树
        // 3. < root, 向下寻找插入点
            // 3.1 dfs(node) 有双子节点
                // 3.1.1 小于left，则继续dfs(left)
                // 3.1.2 大于left，小于right，则继续dfs(right)
                // 3.1.3 大于right，插入新节点到right，然后right节点接入到新节点的左节点
            // 3.2 dfs(node)单子节点
                // 则可以直接添加到另外一个单节点上
            // 3.3 dfs(node)为空
                // 则可以直接添加到左子节点上
            // 3.2和3.3可以合并为，如果左子节点不存在，则可以直接添加，有左子节点，则可以添加右子节点上


        return rs;
    }

    public static void main(String[] args) {
        MaximumBinaryTreeTwo maximumBinaryTreeTwo = new MaximumBinaryTreeTwo();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.right = node3;

        TreeNode ans = maximumBinaryTreeTwo.insertIntoMaxTree(root, 3);

        System.out.println(ans);
    }
}
