package com.rulinma.algorithm.leetcode.easy;

/**
 * 6136. 算术三元组的数目
 * <p>
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
 * <p>
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 200
 * 0 <= nums[i] <= 200
 * 1 <= diff <= 50
 * nums 严格 递增
 * <p>
 * https://leetcode.cn/problems/number-of-arithmetic-triplets
 *
 * @author 马如林
 * @Data 2022/8/7 14:15
 */
public class NumberOfArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                int t = nums[j] - nums[i];
                if (t > diff) {
                    break;
                }
                if (t == diff) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] - nums[j] > diff) {
                            break;
                        }
                        if (nums[k] - nums[j] == diff) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 4, 6, 7, 10};
        int diff = 3;

//        int[] nums = new int[]{4, 5, 6, 7, 8, 9};
//        int diff = 2;

        NumberOfArithmeticTriplets numberOfArithmeticTriplets = new NumberOfArithmeticTriplets();

        System.out.println(numberOfArithmeticTriplets.arithmeticTriplets(nums, diff));
    }

}
