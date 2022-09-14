package com.rulinma.algorithm.leetcode.util;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/9 21:25
 */
public class Test {

    /**
     * 1619. 删除某些元素后的数组均值
     */
    public double trimMean(int[] arr) {
        int len = (int) Math.round(arr.length * 0.05);
        int left = len;
        int right = arr.length - len;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = left; i < right; i++) {
            // [5 95)
            sum += arr[i];
        }

        double v = new Double(sum) / (right - left);

        return v;
    }

    /**
     * 670. 最大交换
     */
    public int maximumSwap(int num) {
        // 暴力求解
        if (num < 10) {
            return num;
        }

        // 8位
        char[] arr = String.valueOf(num).toCharArray();
        int max = num;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                max = Math.max(max, Integer.parseInt(new String(arr)));
                swap(arr, i, j);
            }
        }

        return max;
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    /**
     * 670. 最大交换
     */
    public int maximumSwap1(int num) {
        if (num % 10 == num) {
            return num;
        }

        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            // 从i后面选择一个最大的，这个最大的离i越远越好，比如1993，1交换第二个9更优，所以j倒序遍历
            int maxIndex = i;
            for (int j = arr.length - 1; j >= i + 1; j--) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                char tmp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmp;
                return Integer.parseInt(new String(arr));
            }
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

        System.out.println(test.maximumSwap(2736));
        System.out.println(test.maximumSwap(9973));

        System.out.println(test.maximumSwap(1993));
    }

}
