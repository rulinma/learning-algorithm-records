/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * https://leetcode.cn/problems/climbing-stairs/
 * @author 马如林
 * @Data 2022/6/21 21:56
 */

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    // 迭代
    // s = s1 + s2
    // s1 = s2
    // s2 = s
    let s1 = 1;
    let s2 = 2;
    let c = 3;
    while (c <= n) { 
        s = s1 + s2;
        s1 = s2;
        s2 = s;
        c++;
    }

    return s;

};

var climbStairs0 = function(n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    return climbStairs(n - 1) + climbStairs(n - 2);
};

console.log(climbStairs(4))