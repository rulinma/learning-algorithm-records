package com.rulinma.algorithm.leetcode.util;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/9 21:25
 */
public class Test {

    /**
     * 1608. 特殊数组的特征值
     */
    public int specialArray(int[] nums) {
        int rs = -1;
        Arrays.sort(nums);

        // x 并且刚好 刚好有x个元素 >=x
        for (int i = 1; i <= 1000; i++) {
            int c = 0;
            for (int n : nums) {
                if (n >= i) {
                    break;
                } else {
                    c++;
                }
            }

            int g = nums.length - c;
            if (i == g) {
                return g;
            } else if (i > g) {
                break;
            }
        }

        return rs;
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // dfs
        TreeNode root = mergeNode(root1, root2);
        return root;
    }

    private TreeNode mergeNode(TreeNode root1, TreeNode root2) {
        TreeNode root = null;
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            root = new TreeNode(root1.val);
            root.left = mergeNode(root1.left, null);
            root.right = mergeNode(root1.right, null);
        } else if (root1 == null && root2 != null) {
            root = new TreeNode(root2.val);
            root.left = mergeNode(null, root2.left);
            root.right = mergeNode(null, root2.right);
        } else {
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeNode(root1.left, root2.left);
            root.right = mergeNode(root1.right, root2.right);
        }

        return root;
    }

    /**
     * 283. 移动零
     */
    public void moveZeroes(int[] nums) {
        int notZeroPos = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[notZeroPos] = nums[i];
                notZeroPos++;
            }
            i++;
        }

        for (int j = notZeroPos; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[]{0};
        test.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }

}
