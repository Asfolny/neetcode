public class MinStack {

    private int min = 0;
    private Stack<int> stack;

    public MinStack() {
        stack = new Stack<int>();
    }
    
    public void Push(int val) {
        if (stack.Count == 0 || min > val) {
            min = val;
        }
        stack.Push(val);
    }
    
    public void Pop() {
        var top = stack.Pop();
        if (top == min && stack.Count > 0) {
            min = stack.Peek();

            foreach (int n in stack)
            {
                if (min > n) {
                    min = n;
                }
            }
        }
    }
    
    public int Top() {
        return stack.Peek();
    }
    
    public int GetMin() {
        return min;
    }
}

