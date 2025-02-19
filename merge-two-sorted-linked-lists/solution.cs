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
    public ListNode MergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }


        var start = list1.val < list2.val ? list1 : list2;
        var l1 = list1.val < list2.val ? list2 : list1;
        var l2 = start.next;
        var parent = start;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                parent.next = l2;
                break;
            }
            
            if (l2 == null) {
                parent.next = l1;
                break;
            }


            parent.next = l1.val < l2.val ? l1 : l2;
            l1 = l1.val < l2.val ? l2 : l1;
            parent = parent.next;
            l2 = parent.next;
        }

        return start;
    }
}
