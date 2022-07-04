package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * <p>
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * <p>
 * https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary
 * <p>
 * 3 <= salary.length <= 100
 * 10^3 <= salary[i] <= 10^6
 * salary[i] 是唯一的。
 * 与真实值误差在 10^-5 以内的结果都将视为正确答案。
 *
 * @author 马如林
 * @Data 2022/7/4 08:54
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salary) {
        double sum = 0;
        int max = salary[0];
        int min = salary[0];
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
        }
        return (sum - max - min) / (salary.length - 2);
    }


    public double average0(int[] salary) {
        Arrays.sort(salary);
        int len = salary.length - 2;
        double sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return sum / len;
    }

}
