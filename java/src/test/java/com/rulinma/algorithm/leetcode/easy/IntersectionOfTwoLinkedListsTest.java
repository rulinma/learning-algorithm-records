package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.zip.GZIPInputStream;

/**
 * @author 马如林
 * @Data 2022/6/22 15:02
 */
@Slf4j
public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void testIntersectionOfTwoLinkedLists() throws IOException {
        ListNode headA = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        headA.next = a1;
        a1.next = a2;

        ListNode headB = new ListNode(11);
        ListNode b1 = new ListNode(22);
//        ListNode b2 = new ListNode(33);
        headB.next = b1;
        b1.next = a2;

        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode result = intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB);
        log.info("result {} ", result);

//        Calendar.getInstance()

        // 创建原始的数据源:
        InputStream fis = new FileInputStream("test.gz");
// 增加缓冲功能:
        InputStream bis = new BufferedInputStream(fis);
// 增加解压缩功能:
        InputStream gis = new GZIPInputStream(bis);

    }
}
