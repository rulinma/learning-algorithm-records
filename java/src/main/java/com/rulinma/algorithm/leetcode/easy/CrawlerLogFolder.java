package com.rulinma.algorithm.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1598. 文件夹操作日志搜集器
 * <p>
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 * <p>
 * 下面给出对变更操作的说明：
 * <p>
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 * <p>
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * <p>
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：logs = ["d1/","../","../","../"]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= logs.length <= 103
 * 2 <= logs[i].length <= 10
 * logs[i] 包含小写英文字母，数字，'.' 和 '/'
 * logs[i] 符合语句中描述的格式
 * 文件夹名称由小写英文字母和数字组成
 * <p>
 * <p>
 * https://leetcode.cn/problems/crawler-log-folder
 *
 * @author 马如林
 * @Data 2022/9/9 08:45
 */
public class CrawlerLogFolder {

    public int minOperations1(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if ("./".equals(log)) {
                continue;
            } else if ("../".equals(log)) {
                if (depth > 0) {
                    depth--;
                }
            } else {
                depth++;
            }
        }
        return depth;
    }

    public int minOperations(String[] logs) {
        Deque<String> stack = new LinkedList();

        for (String s : logs) {
            if ("../".equals(s)) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else if ("./".equals(s)) {
                // no op
            } else {
                stack.push(s);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(new CrawlerLogFolder().minOperations(logs));

        String[] logs1 = new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"};
        System.out.println(new CrawlerLogFolder().minOperations(logs1));

        String[] logs2 = new String[]{"d1/", "../", "../", "../"};
        System.out.println(new CrawlerLogFolder().minOperations(logs2));
    }
}
