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
        // 1个节点
        if (root == null) {
            return new TreeNode(val);
        }
        // 根节点值小于val，则添加val，并返回新节点
        if (val > root.val) {
            TreeNode rs = new TreeNode(val);
            rs.left = root;
            return rs;
        }
        // 否则肯定在右子树上
        TreeNode parent = null;
        TreeNode cur = root;
        // 当前cur节点值<val时进行插入，把当前节点parent的right设置为val，新节点的left设置为cur的值
        // 最终cur==null的时候，则直接插入right即可
        while (cur != null) {
            if (cur.val < val) {
                // 插入
                TreeNode rs = new TreeNode(val);
                parent.right = rs;
                rs.left = cur;
                return root;
            }
            parent = cur;
            cur = cur.right;
        }

        // 最终cur==null
        TreeNode rs = new TreeNode(val);
        parent.right = rs;

        return root;
    }

    public static void main(String[] args) {
        MaximumBinaryTreeTwo maximumBinaryTreeTwo = new MaximumBinaryTreeTwo();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.right = node3;

        TreeNode ans = maximumBinaryTreeTwo.insertIntoMaxTree(root, 4);

        System.out.println(ans);
    }
}
