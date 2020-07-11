package queue;
//203. 移除链表元素
//        删除链表中等于给定值 val 的所有节点。
//
//        示例:
//
//        输入: 1->2->6->3->4->5->6, val = 6
//        输出: 1->2->3->4->5

import javax.sound.midi.Soundbank;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {


    public ListNode removeElements1(ListNode head, int val) {
        // Solution 1
        ListNode dummHead = new ListNode(-1);
        dummHead.next = head;
        ListNode prev = dummHead;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }
            else {
                prev = prev.next;
            }
        }
        return head;
    }



    public ListNode removeElements(ListNode head, int val) {
        // Solution 2
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = new Solution().removeElements(head, 6);
        System.out.println(res);
    }
}
