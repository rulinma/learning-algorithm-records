package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * <p>
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr 按 升序 排列
 * -104 <= arr[i], x <= 104
 * <p>
 * https://leetcode.cn/problems/find-k-closest-elements
 *
 * @author 马如林
 * @Data 2022/8/25 09:52
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> rs = new ArrayList<>();

        // 二叉查找x，找到返回该值，并指针指向其位置并从left和right进行比较添加k个数
        // 二次查找的x，没有找到，则寻找最接近的该值，获取位置，并从left和right进行比较添加k个数

        int mid = binarySearch(arr, x);
//        System.out.println("mid " + mid);
        if (mid != -1 && arr[mid] == x) {
            // 找到了
            rs.add(arr[mid]);
            // 向左或向右再添加k-1个
            getData(arr, k - 1, x, rs, mid);
        } else {
            // 没有找到，则需要对arr[mid-1]和arr[mid+1]进行比较，也要注意边界情况
            // 向左或向右再添加k个
            // 首先选择一个，再继续寻找

//            if (left >= 0 && right < arr.length
//                    && ((Math.abs(arr[left] - x) < Math.abs(arr[right] - x))
//                    || (Math.abs(arr[left] - x) == Math.abs(arr[right] - x)))
            // mid返回值后，是选择mid-1 还是mid 还是 mid+1?
            // 选择mid-1, mid, mid+1 3个中最接近x的作为最终mid
            int minIndex = mid;

            int minv = Math.abs(arr[mid] - x);
            if (mid - 1 >= 0) {
                int m1 = Math.abs(arr[mid - 1] - x);
                if (m1 <= minv) {
                    minIndex = mid - 1;
                    minv = m1;
                }
            }

            if (mid + 1 < arr.length) {
                int m2 = Math.abs(arr[mid + 1] - x);
                if (m2 < minv) {
                    minIndex = mid + 1;
                }
            }

            rs.add(arr[minIndex]);
            getData(arr, k - 1, x, rs, minIndex);
        }

        Integer[] xa = new Integer[rs.size()];
        rs.toArray(xa);

        Arrays.sort(xa);
        List<Integer> ans = new ArrayList<>();
        for (int t : xa) {
            ans.add(t);
        }

        return ans;
    }

    private void getData(int[] arr, int c, int x, List<Integer> rs, int mid) {
        int left = mid - 1;
        int right = mid + 1;
        int count = 0;
        while (count < c) {
            if (left < 0) {
                rs.add(arr[right]);
                right++;
                count++;
                continue;
            }

            if (right >= arr.length && left >= 0) {
                rs.add(arr[left]);
                left--;
                count++;
                continue;
            }

            if (left >= 0 && right < arr.length
                    && ((Math.abs(arr[left] - x) < Math.abs(arr[right] - x))
                    || (Math.abs(arr[left] - x) == Math.abs(arr[right] - x)))) {
                rs.add(arr[left]);
                left--;
                count++;
                continue;
            } else {
                rs.add(arr[right]);
                right++;
                count++;
            }

        }
    }

    public int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        FindKClosestElements findKClosestElements = new FindKClosestElements();

        int k = 4;
        int x = 3;
        int[] arr = {1, 2, 3, 4, 5};

// [1, 2, 3, 4]
        System.out.println(findKClosestElements.findClosestElements(arr, k, x));
//[1, 2, 3, 4]
        System.out.println(findKClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
//[-2, -1, 1, 2, 3, 4, 5]
//        // arr 中不存在x的情况
        System.out.println(findKClosestElements.findClosestElements(new int[]{-2, -1, 1, 2, 3, 4, 5}, 7, 3));
//[1]
        System.out.println(findKClosestElements.findClosestElements(new int[]{1, 3}, 1, 2));
//[3, 3, 4]
        System.out.println(findKClosestElements.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));

        System.out.println(findKClosestElements.findClosestElements(new int[]{1, 10, 15, 25, 35, 45, 50, 59}, 1, 30));
    }

}
