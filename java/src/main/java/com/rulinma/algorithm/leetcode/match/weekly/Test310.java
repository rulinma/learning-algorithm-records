package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/9/11 10:29
 */
public class Test310 {

    /**
     * 贪心就行
     */
    public int partitionString(String s) {
        char[] chars = s.toCharArray();

        int right = 1;
        int count = 1;
        List<Character> list = new ArrayList<>();
        list.add(chars[0]);

        while (right < chars.length) {
            if (list.contains(chars[right])) {
                // shrink
                count++;
                list.clear();
            }
            list.add(chars[right]);
            right++;
        }

        return count;
    }


    public int minGroups(int[][] intervals) {
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

        int count = 1;
        int min = intervals[0][1];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            // System.out.println("min: " + min + " start " + start);
            if (start <= min) {
                // insert new one
                count++;
                min = Math.min(min, intervals[i][1]);
            } else {
                // 加入已有组的话，并且刚好是min所在组，需要修改min
            }
            priorityQueue.add(intervals[i][1]);


        }

        return count;
    }

    public int minGroups2(int[][] intervals) {
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

        List<Integer> list = new ArrayList<>();
        for (int[] i : intervals) {
            int start = i[0];
            // 第一个
            if (list.size() == 0) {
                // 设置第一个的最大值
                list.add(i[1]);
            } else {
                boolean insert = false;
                for (int j = 0; j < list.size(); j++) {
                    // every group
                    // 检查每个group的最后一个值，如果新的start>该值，则添加，否则继续遍历，最后没有添加则需要新建一个group
                    if (start > list.get(j)) {
                        list.set(j, i[1]);
                        insert = true;
                        break;
                    }
                }

                if (!insert) {
                    // 末尾添加新组
                    list.add(i[1]);
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
//        int[][] intervals = new int[][]{
//                {5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}
//        };
//        int rs = new Test310().minGroups(intervals);
//        System.out.println(rs);
//
//
//        int[][] intervals2 = new int[][]{
//                {1, 3}, {5, 6}, {8, 10}, {11, 13}
//        };
//        int rs2 = new Test310().minGroups(intervals2);
//        System.out.println(rs2);

//        int[][] intervals3 = new int[][]{
//                {441459, 446342}, {801308, 840640}, {871890, 963447}, {228525, 336985},
//                {807945, 946787}, {479815, 507766}, {693292, 944029}, {751962, 821744}
//        };
//        int rs3 = new Test310().minGroups(intervals3);
//        System.out.println(rs3);

        String s = "abacaba";
        System.out.println(new Test310().partitionString(s));

        String s1 = "ssssss";
        System.out.println(new Test310().partitionString(s1));

    }
}
