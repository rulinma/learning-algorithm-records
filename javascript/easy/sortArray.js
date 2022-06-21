/**
 * 912. 排序数组
 * <p>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * https://leetcode.cn/problems/sort-an-array/
 *
 * @author 马如林
 * @Data 2022/6/21 18:19
 */
var sortArray = function (nums) {

    // bubble sort
    // select sort
    // insert sort

    // 从第2位置开始，进行位置寻找并插入
    for (let i = 1; i < nums.length; i++) { 
        // 待插入值
        const currentValue = nums[i];
        let pos = i - 1;
        // 当前位置值大于待插入值，后移数据
        while (nums[pos] > currentValue && pos>=0) { 
            nums[pos + 1] = nums[pos];
            pos--;
        }
        // 寻找到的位置
        nums[pos + 1] = currentValue;
    }

    return nums;
};

console.log(sortArray([1, 23, 45, 6, 12, 23]));
console.log(sortArray([5,2,3,1]));