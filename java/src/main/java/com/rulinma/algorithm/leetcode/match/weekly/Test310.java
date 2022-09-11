package com.rulinma.algorithm.leetcode.match.weekly;

import com.rulinma.algorithm.leetcode.other.Test;
import javafx.util.Pair;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/9/11 10:29
 */
public class Test310 {

    public int minGroups(int[][] intervals) {
        int min = 1;
        // sort intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        // System.out.println(intervals);

        List<List<int[]>> list = new ArrayList<>();
        for (int[] i : intervals) {
            int start = i[0];
            // 第一个
            if (list.size() == 0) {
                List<int[]> group = new ArrayList<>();
                group.add(i);
                list.add(group);
            } else {
                boolean insert = false;
                for (List<int[]> x : list) {
                    // every group
                    // 检查每个group的最后一个值，如果新的start>该值，则添加，否则继续遍历，最后没有添加则需要新建一个group
                    int max = x.get(x.size() - 1)[1];
                    if (start > max) {
                        x.add(i);
                        insert = true;
                        break;
                    }
                }

                if (!insert) {
                    List<int[]> group = new ArrayList<>();
                    group.add(i);
                    list.add(group);
                }
            }
        }

        min = list.size();

        return min;
    }


    public int minGroups1(int[][] intervals) {
        int min = 1;
        // sort intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        // System.out.println(intervals);

        List<List<int[]>> list = new ArrayList<>();
        for (int[] i : intervals) {
            int start = i[0];
            // 第一个
            if (list.size() == 0) {
                List<int[]> group = new ArrayList<>();
                group.add(i);
                list.add(group);
            } else {
                boolean insert = false;
                for (List<int[]> x : list) {
                    // every group
                    // 检查每个group的最后一个值，如果新的start>该值，则添加，否则继续遍历，最后没有添加则需要新建一个group
                    int max = x.get(x.size() - 1)[1];
                    if (start > max) {
                        x.add(i);
                        insert = true;
                        break;
                    }
                }

                if (!insert) {
                    List<int[]> group = new ArrayList<>();
                    group.add(i);
                    list.add(group);
                }
            }
        }

        min = list.size();

        return min;
    }

    public int mostFrequentEven(int[] nums) {
        int max = -1;
        int ans = -1;
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (i % 2 == 0) {
                int c = map.getOrDefault(i, 0);
                map.put(i, c + 1);
                int cv = map.get(i);
                if (cv > max) {
                    max = cv;
                    ans = i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

//        int[] nums = new int[]{0, 1, 2, 2, 4, 4, 1};
//        System.out.println(new Test310().mostFrequentEven(nums));
//
//
//        int[] nums1 = new int[]{4, 4, 4, 9, 2, 4};
//        System.out.println(new Test310().mostFrequentEven(nums1));
//
//        int[] nums2 = new int[]{29, 47, 21, 41, 13, 37, 25, 7};
//        System.out.println(new Test310().mostFrequentEven(nums2));
//
//        int[] nums3 = new int[]{0, 0, 0, 0};
//        System.out.println(new Test310().mostFrequentEven(nums3));
        int[][] intervals = new int[][]{
                {5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}
        };
        int rs = new Test310().minGroups(intervals);
        System.out.println(rs);


        int[][] intervals2 = new int[][]{
                {1, 3}, {5, 6}, {8, 10}, {11, 13}
        };
        int rs2 = new Test310().minGroups(intervals2);
        System.out.println(rs2);

    }
}
