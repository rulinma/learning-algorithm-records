package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.easy.TwoSum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/18 17:31
 */
@Slf4j
public class TwoSumTest {

    @Test
    public void test1() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSumSimple(nums, target);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
        log.info("success");
    }

}
