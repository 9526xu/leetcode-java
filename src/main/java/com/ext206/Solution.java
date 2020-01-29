package com.ext206;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2020/1/29
 */
public class Solution {
    /**
     * 集合记录方式
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> temp = new ArrayList<>();

        while (head != null) {
            ListNode listNode = new ListNode(head.val);
            temp.add(listNode);
            head = head.next;
        }

        ListNode tempNode = temp.get(temp.size() - 1);

        ListNode result = tempNode;
        for (int i = temp.size() - 2; i >= 0; i--) {
            tempNode.next = temp.get(i);
            tempNode = tempNode.next;
        }

        return result;
    }

    /***
     * 两个指针方式
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;


    }


}
