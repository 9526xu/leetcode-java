package com.ext141;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2020/1/29
 * <p>
 * leetcode 141 判断链表上是否有环
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
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
                return true;
            }



        }
        return false;


    }

}
