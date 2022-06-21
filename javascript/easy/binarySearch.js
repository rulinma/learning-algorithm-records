/**
 * 704. 二分查找
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * https://leetcode.cn/problems/binary-search/
 *
 * @author 马如林
 * @Data 2022/6/21 19:11
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let low = 0;
    let high = nums.length - 1;
    // debugger
    while (low <= high) { 
        let middle =  Math.floor(( high - low) / 2) + low;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            low = middle + 1;
        } else { 
            high = middle - 1;
        }
    }

    return -1;
};

console.log("result " , search([1,2,3,4,5],2))
console.log("result ", search([-1, 0, 3, 5, 9, 12], 9))
console.log("result " , search([-1,0,3,5,9,12], 19))