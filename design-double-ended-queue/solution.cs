class Node {
    public int value;
    public Node next = null;

    public Node(int val) {
        value = val;
    }
}

class Deque {
    Node head = null;
    Node tail = null;

    public bool isEmpty() => head == null;

    public void append(int value) {
        var node = new Node(value);
        if (head == null)
            head = node;
        if (tail != null)
            tail.next = node;
        tail = node;
    }

    public void appendleft(int value) {
        var node = new Node(value);
        if (tail == null)
            tail = node;

        node.next = head;
        head = node;
    }

    public int pop() {
        if (isEmpty())
            return -1;

        if (head == tail)
            return popleft();

        var node = head;
        while (node.next != tail)
            node = node.next;
        
        var value = tail.value;
        node.next = null;
        tail = node;
        if (node == head)
            head.next = null;
        return value;
    }

    public int popleft() {
        if (isEmpty())
            return -1;
        var val = head.value;
        head = head.next;

        if (head == null)
            tail = null;

        return val;
    }
}

