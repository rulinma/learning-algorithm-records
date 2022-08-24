package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * 2385. 感染二叉树需要的总时间
 * <p>
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * <p>
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * <p>
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 * 返回感染整棵树需要的分钟数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
 * 输出：4
 * 解释：节点按以下过程被感染：
 * - 第 0 分钟：节点 3
 * - 第 1 分钟：节点 1、10、6
 * - 第 2 分钟：节点5
 * - 第 3 分钟：节点 4
 * - 第 4 分钟：节点 9 和 2
 * 感染整棵树需要 4 分钟，所以返回 4 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1], start = 1
 * 输出：0
 * 解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 * 每个节点的值 互不相同
 * 树中必定存在值为 start 的节点
 * <p>
 * https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected
 *
 * @author 马如林
 * @Data 2022/8/24 16:44
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        int c = -1;
        // 算法：BFS
        // 1. visitedSet记录所有已经访问的节点
        // 2. 从节点开始获取对应的parent和child，并进行扩散，需要记录节点的父节点map
        // 3. 每次迭代，队列里所有节点的父和子节点，直到队列为空
        Set<Integer> visitedSet = new HashSet<>();

        // 设置每个node的父节点
        traverTree(root, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        // 获取开始节点
        TreeNode startNode = traver(root, start);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            // System.out.println(queue.size());
            c++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visitedSet.add(node.val);
                // get parent
                TreeNode p = parentMap.get(node);
                if (p != null && !visitedSet.contains(p.val)) {
                    queue.add(p);
                }

                // get child
                if (node.left != null) {
                    if (!visitedSet.contains(node.left.val)) {
                        queue.add(node.left);
                    }
                }

                if (node.right != null) {
                    if (!visitedSet.contains(node.right.val)) {
                        queue.add(node.right);

                    }
                }

            }
        }

        return c;
    }

    private TreeNode traver(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        TreeNode left = traver(root.left, val);
        if (left == null) {
            TreeNode right = traver(root.right, val);
            return right;
        }

        return left;
    }


    private void traverTree(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        // dfs
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
        }
        traverTree(root.left, parentMap);
        traverTree(root.right, parentMap);
    }

}
