console.log("two sum")
// 1. 两数之和

// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
// 你可以按任意顺序返回答案。

// 链接：https://leetcode.cn/problems/two-sum

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var twoSum = function(nums, target) {
// map处理
// 1. map.put(num, i)
// 2. 遍历nums if(target - num) exist map中则返回 
    const map = new Map();
    // let i = 0;
    // nums.forEach(item => { 
    //     map.set(item, i++);
    // })
    // debugger
    map.set(nums[0], 0);
    for (let j = 1; j < nums.length; j++) { 
        if (map.has(target - nums[j])) {
            return [map.get(target - nums[j]), j ]
        } else { 
            map.set(nums[j], j); 
        }
    }
    
    return []
};

var twoSum0 = function(nums, target) {
    for (let i = 0; i < nums.length - 1; i++ ) { 
        for (let j = i + 1; j < nums.length; j++) { 
            if ((nums[i] + nums[j]) == target) { 
                return [i, j]
            }
        }
    }
    
    return []
};

const nums = [3, 2, 4];
const target = 6;

let result = twoSum(nums, target)
console.log("result ", result)