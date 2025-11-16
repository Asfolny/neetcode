class HashTable {
    private Node[] table;
    private int size;
    private int cap;

    public HashTable(int capacity) {
        table = new Node[capacity];
        size = 0;
        cap = capacity;
    }

    private int hashFunction(int key) {
        return key % cap;
    }

    public void insert(int key, int value) {
        var in = new Node(key, value);
        var location = hashFunction(key);

        if (table[location] != null) {
            Node prev = null;
            var node = table[location];
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    return;
                }
                prev = node;
                node = node.next;
            }

            prev.next = in;
        } else {
            table[location] = in;
        }

        size++;
        if (size >= cap / 2)
            resize();
    }

    public int get(int key) {
        var location = hashFunction(key);
        var node = table[location];
        while (node != null && node.key != key)
            node = node.next;

        return node == null ? -1 : node.val;
    }

    public boolean remove(int key) {
        var location = hashFunction(key);
        if (table[location] == null) return false;

        var node = table[location];
        if (node.key == key) {
            table[location] = node.next;
            size--;
            return true;
        }

        while (node.next != null && node.next.key != key)
            node = node.next;
        
        if (node.next == null)
            return false;

        node.next = node.next.next;
        return true;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return cap;
    }

    public void resize() {
        cap *= 2;
        size = 0;
        var old_table = table;
        table = new Node[cap];

        for (var node : old_table) {
            while (node != null) {
                insert(node.key, node.val);
                node = node.next;
            }
        }
    }
}

class Node {
    public int key;
    public int val;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

