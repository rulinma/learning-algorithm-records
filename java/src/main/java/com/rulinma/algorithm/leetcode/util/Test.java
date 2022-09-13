package com.rulinma.algorithm.leetcode.util;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author 马如林
 * @Data 2022/9/9 21:25
 */
public class Test {

    public int maximumSwap(int num) {
        // 第1个变化位，进行交换就可以
        String v = String.valueOf(num);
        Integer[] x = new Integer[v.length()];
        char[] chars = v.toCharArray();
        int i = 0;
        for (char ch : chars) {
            x[i++] = Integer.parseInt(String.valueOf(ch));
        }

        Integer[] y = x.clone();
        Arrays.sort(y, Collections.reverseOrder());

//        System.out.println(Arrays.toString(y));
//        System.out.println(Arrays.toString(x));
        // [2, 7, 3, 6]
        // [7, 6, 3, 2]
        //  7 2 3 6

        for (int j = 0; j < x.length; j++) {
            if (!x[j].equals(y[j])) {
                // 此处应该是y[j], 当前j开始后的swap x[j] 和 y[j]
                int t = x[j];
                x[j] = y[j];
                // 当前位置后的第一个y[j]值设置为t
                for (int k = j + 1; k < x.length; k++) {
                    //
                    while (x[k].equals(y[j])) {
                        k++;
                    }
                    if (x[k].equals(y[j])) {
                        x[k] = t;
                        break;
                    }
                }
                break;
            }
        }

        // 输出num
        num = 0;
        for (int k = 0; k < x.length; k++) {
            num = num * 10 + x[k];
        }

        return num;

    }

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
//
//        int[] nums = new int[]{0, 1, 0, 3, 12};
//        test.moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));
//
//        int[] nums1 = new int[]{0};
//        test.moveZeroes(nums1);
//        System.out.println(Arrays.toString(nums1));

//        System.out.println(test.maximumSwap(2736));
//        System.out.println(test.maximumSwap(9973));

        System.out.println(test.maximumSwap(1993));
    }

}
