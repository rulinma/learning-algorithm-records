package com.rulinma.algorithm.leetcode.easy;

/**
 * 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * https://leetcode.cn/problems/first-bad-version
 *
 * @author 马如林
 * @Data 2022/6/24 10:34
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        // 调用API
        int low = 1;
        int high = n;
        int ans = 0;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if (isBadVersion(middle)) {
                // 左移动
                ans = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return ans;
    }

    private boolean isBadVersion(int middle) {
        return true;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
    }
}
