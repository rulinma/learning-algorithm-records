package com.rulinma.algorithm.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/19 19:13
 */
@Slf4j
public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(nums, target);
        Assert.assertEquals(4, result);
        log.info("success");
    }

    @Test
    public void testBinarySearch2() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 2;
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(nums, target);
        Assert.assertEquals(-1, result);
        log.info("success");
    }

}
