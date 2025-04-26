/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

public class Solution {    
    public ListNode MergeKLists(ListNode[] lists) {
        var head = lists.Length switch {
            0 => null,
            _ => lists[0]
        };


        for (int i = 1; i < lists.Length; i++) {
            head = MergeTwoLists(head, lists[i]);
        }

        return head; 
    }

    private ListNode MergeTwoLists(ListNode left, ListNode right) {
        // Base, figure out where to start
        ListNode head = null;
        if (left.val > right.val) {
            head = right;
            right = right.next;
        } else {
            head = left;
            left = left.next;
        }
        var tail = head;

        while (left != null || right != null) {
            // Consume right
            if (left == null) {
                tail.next = right;
                right = right.next;
                tail = tail.next;
                continue;
            }

            // Consume left
            if (right == null) {
                tail.next = left;
                left = left.next;
                tail = tail.next;
                continue;
            }

            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
                tail = tail.next; 
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }

        return head;
    }
}

