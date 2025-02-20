public class LinkedList {
    private ListNode head = null;
    private ListNode tail = null;

    public int Get(int index) {
        if (head == null)
            return -1;

        var node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
            if (node == null)
                return -1;
        }

        return node.val;
    }

    public void InsertHead(int val) {
        var node = new ListNode(val, head);
        if (tail == null)
            tail = node;
        head = node;
    }

    public void InsertTail(int val) {
        var node = new ListNode(val);
        if (tail != null)
            tail.next = node;
        tail = node;
        if (head == null)
            head = node;
    }

    public bool Remove(int index) {
        if (head == null)
            return false;
        
        var node = head;
        ListNode prev = null;
        for (int i = 0; i < index; i++) {
            prev = node;
            node = node.next;
            if (node == null)
                return false;
        }

        if (prev == null) {
            head = head.next;
            return true;
        }

        if (node == tail) {
            tail = prev;
        }

        prev.next = node.next;
        return true;
    }

    public List<int> GetValues() {
        var res = new List<int>();
        var node = head;

        while (node != null) {
            res.Add(node.val);
            node = node.next;
        }

        return res;
    }
}

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int v, ListNode n=null) {
        val = v;
        next = n;
    }
}
