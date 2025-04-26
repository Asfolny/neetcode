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
        if (lists == null || lists.Length == 0)
            return null;

        return Divide(lists, 0, lists.Length - 1);
    }

    private ListNode Divide(ListNode[] lists, int low, int high) {
        if (low > high)
            return null;
        if (low == high) 
            return lists[low];

        int mid = low + (high - low) / 2;
        ListNode left = Divide(lists, low, mid);
        ListNode right = Divide(lists, mid + 1, high);

        return Conquer(left, right);
    }

    private ListNode Conquer(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        } else {
            curr.next = right;
        }

        return head.next;
    }
}
