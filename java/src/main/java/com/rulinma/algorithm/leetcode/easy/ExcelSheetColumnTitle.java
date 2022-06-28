package com.rulinma.algorithm.leetcode.easy;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 * <p>
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：columnNumber = 701
 * 输出："ZY"
 * <p>
 * <p>
 * https://leetcode.cn/problems/excel-sheet-column-title
 *
 * @author 马如林
 * @Data 2022/6/28 10:37
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        // 1 <= columnNumber <= 231 - 1
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
        System.out.println(excelSheetColumnTitle.convertToTitle(28));
    }
}
