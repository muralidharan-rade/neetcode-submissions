class MinStack {

    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(!min.isEmpty()) {
            int v = min.peek();
            if(val <= v) {
                min.push(val);
            }
        } else {
            min.push(val);
        }
    }
    
    public void pop() {
        int val = st.pop();
        if(min.peek() == val) {
            min.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();        
    }
}
