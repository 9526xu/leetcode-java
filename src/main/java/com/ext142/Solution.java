package com.ext142;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2020/1/29
 * <p>
 * 需要经过一定算式推导。。。、
 *
 * 快指针走的步数为慢指针 2 倍。
 *
 * 快指针比慢指针夺走了 N 倍环的长度
 *
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode quickNode = head;
        ListNode solwNode = head;


        // 如果 next 指针为 null，链表肯定不存在环
        while (quickNode != null && quickNode.next != null) {
            solwNode = solwNode.next;
            // 相隔一个指针 就需要考虑空指针问题
            quickNode = quickNode.next.next;

            // 快慢指针相遇，即代表链表存在环
            if (quickNode == solwNode) {
                break;
            }
        }
        if (quickNode == null || quickNode.next == null) {
            return null;
        }

        while (head != solwNode) {
            head = head.next;
            solwNode = solwNode.next;

        }

        return head;
    }
}
