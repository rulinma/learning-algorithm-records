package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 马如林
 * @Data 2022/9/23 15:36
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int prelen = preorder.length;
        int postlen = postorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int x : postorder) {
            map.put(x, i++);
        }

        return buildTree(preorder, 0, prelen, map, 0, postlen);
    }


    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> map, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[preStart]);

        if(preStart + 1 >= map.size()) {
            treeNode.left = null;
            treeNode.right = null;
        } else {
            int index = map.get(preorder[preStart + 1]);
            int num = index - postStart;
            treeNode.left = buildTree(preorder, preStart + 1, num + preStart + 1, map, postStart, num);
            treeNode.right = buildTree(preorder, num + preStart + 1, preEnd, map, num + 1, postEnd);
        }

        return treeNode;
    }

}