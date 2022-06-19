package com.rulinma.algorithm.leetcode.middle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/18 18:21
 */
@Slf4j
public class SortAnArrayTest {

    @Test
    public void testBubble() {
        int[] nums = new int[]{5, 2, 3, 1};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArrayByFlagBubbleOptimize(nums);
        log.info("nums {}", nums);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3, 5});
    }

    @Test
    public void testBubble2() {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArrayByFlagBubbleOptimize(nums);
        log.info("nums {}", nums);
        Assert.assertArrayEquals(nums, new int[]{0, 0, 1, 1, 2, 5});
    }

    @Test
    public void testortArrayBySelect() {
        int[] nums = new int[]{5, 2, 3, 1};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArrayBySelect(nums);
        log.info("nums {}", nums);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3, 5});
    }

    @Test
    public void testortArrayBySelect2() {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArrayBySelect(nums);
        log.info("nums {}", nums);
        Assert.assertArrayEquals(nums, new int[]{0, 0, 1, 1, 2, 5});
    }

    @Test
    public void testortArrayByOptimizeSelect() {
        int[] nums = new int[]{5, 2, 3, 1};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArrayByInsert(nums);
        log.info("nums {}", nums);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3, 5});
    }

    @Test
    public void testortArrayBySelectOptimize2() {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArrayByInsert(nums);
        log.info("nums {}", nums);
        Assert.assertArrayEquals(nums, new int[]{0, 0, 1, 1, 2, 5});
    }

    @Test
    public void testortArrayByOptimizeSelect3() {
        int[] nums = new int[]{2, 1};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArrayByInsert(nums);
        log.info("nums {}", nums);
        Assert.assertArrayEquals(nums, new int[]{1, 2});
    }

    @Test
    public void testortArrayByOptimizeSelect4() {
        int[] nums = new int[]{1, 2};
        SortAnArray sortAnArray = new SortAnArray();
        sortAnArray.sortArrayByInsert(nums);
        log.info("nums {}", nums);
        Assert.assertArrayEquals(nums, new int[]{1, 2});
    }

}
