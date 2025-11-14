class KthLargest {
    List<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new ArrayList<Integer>() {{ add(0); }};
        this.k = k;

        for (var num : nums)
            this.push(num);
    }
    
    public int add(int val) {
        push(val);

        var remmed = new ArrayList<Integer>();
        for (int i = 0; i < k; i++)
            remmed.add(pop());
        for (var b : remmed)
            push(b);

        return remmed.get(remmed.size() - 1);
    }

    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        // Percolate up
        while (i > 1 && heap.get(i) > heap.get(i / 2)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, tmp);
            i = i / 2;
        }
    }

    public int pop() {
        if (heap.size() == 2) {
            return heap.remove(heap.size() - 1); // equivalent to heap.remove(1)
        }

        int res = heap.get(1);
        // Move last value to root
        heap.set(1, heap.remove(heap.size() - 1));
        int i = 1;
        // Percolate down
        while(2 * i < heap.size()) {
            if (2*i + 1 < heap.size() &&
            heap.get(2 * i + 1) > heap.get(2 * i) &&
            heap.get(i) < heap.get(2 * i + 1)) {
                // Swap right child
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, tmp);
                i = 2 * i + 1;
            } else if (heap.get(i) < heap.get(2 * i)) {
                // Swap left child
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, tmp);
                i = 2 * i;
            } else {
                break;
            }
        }
        return res;
    }
}

