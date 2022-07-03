package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * 1985. 找出数组中的第 K 大整数
 * 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
 * <p>
 * 返回 nums 中表示第 k 大整数的字符串。
 * <p>
 * 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = ["3","6","7","10"], k = 4
 * 输出："3"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
 * 其中第 4 大整数是 "3"
 * <p>
 * 链接：https://leetcode.cn/problems/find-the-kth-largest-integer-in-the-array
 *
 * @author 马如林
 * @Data 2022/7/3 19:24
 */
public class FindTheKthLargestIntegerInTheArray {

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        String[] nums = new String[]{"623986800", "3", "887298", "695", "794", "6888794705", "269409", "59930972", "723091307", "726368", "8028385786", "378585"};
        FindTheKthLargestIntegerInTheArray findTheKthLargestIntegerInTheArray = new FindTheKthLargestIntegerInTheArray();
        String result = findTheKthLargestIntegerInTheArray.kthLargestNumber(nums, 11);
        System.out.println(result);
    }

}
