package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * <p>
 * https://leetcode.cn/problems/restore-ip-addresses
 *
 * @author 马如林
 * @Data 2022/9/15 15:03
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> rs = new ArrayList<>();
        // 0 - 255
        // 回溯
        List<String> list = new ArrayList<>();

        backtrace(s, 0, rs, list);

        return rs;
    }

    private void backtrace(String s, int index, List<String> rs, List<String> nums) {
        if (nums.size() == 4 && s.length() == index) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums.get(0)).append(".").append(nums.get(1)).append(".").append(nums.get(2)).append(".").append(nums.get(3));
//            System.out.println(sb.toString());
            // 结果
//            if (sb.toString().length() == s.length() + 3)
            {
                rs.add(sb.toString());
            }
        }

        if (nums.size() >= 4) {
            return;
        }

        {
            // 添加sb
            String v = "";
            // 选择index开始后的1-3位有效数字进行递进
            for (int i = 1; i < 4; i++) {
                if (index + i > s.length()) {
                    break;
                }
                if (i == 1) {
                    // 首字母不为0
                    String t = s.substring(index, index + 1);
                    v = t;
                } else if (i == 2) {
                    String t = s.substring(index, index + 2);
                    if (t.startsWith("0")) {
                        break;
                    } else if (Integer.parseInt(t) > 255) {
                        break;
                    } else {
                    }
                    v = t;
                } else if (i == 3) {
                    String t = s.substring(index, index + 3);
                    if (t.startsWith("0")) {
                        break;
                    } else if (Integer.parseInt(t) > 255) {
                        break;
                    } else {
                    }
                    v = t;
                }

                index = index + i;
                nums.add(v);
                backtrace(s, index, rs, nums);
                nums.remove(nums.size() - 1);
                index = index - i;
            }

        }

    }


    public static void main(String[] args) {

        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();

        String s = "25525511135";
        List<String> list = restoreIpAddresses.restoreIpAddresses(s);
        System.out.println(Arrays.toString(list.toArray()));

        String s1 = "0000";
        List<String> list1 = restoreIpAddresses.restoreIpAddresses(s1);
        System.out.println(Arrays.toString(list1.toArray()));

        String s2 = "101023";
        List<String> list2 = restoreIpAddresses.restoreIpAddresses(s2);
        System.out.println(Arrays.toString(list2.toArray()));
    }
}
