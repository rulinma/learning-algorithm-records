package com.rulinma.algorithm.leetcode.easy;

/**
 * 171. Excel 表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
 * <p>
 * https://leetcode.cn/problems/excel-sheet-column-number
 *
 * @author 马如林
 * @Data 2022/6/27 19:42
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }

    public int titleToNumber0(String columnTitle) {
        int result = 0;
        // 1. 26进制
        int len = columnTitle.length();
        int i = len - 1;
        int j = 0;
        while (i >= 0) {
            int number = 1;
            int count = 0;
            if (j == 0) {
                number = 1;
            } else {
                while (count++ < j) {
                    number = number * 26;
                }
            }
            result += number * (columnTitle.charAt(i) - 'A' + 1);
            i--;
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        int result = excelSheetColumnNumber.titleToNumber("ZY");
        System.out.println(result);
    }
}
