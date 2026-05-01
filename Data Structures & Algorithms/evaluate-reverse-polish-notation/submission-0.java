class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int v2 = st.pop();
                int v1 = st.pop();

                if(s.equals("+")) {
                    st.push(v1 + v2);
                } else if (s.equals("-")) {
                    st.push(v1 - v2);
                } else if (s.equals("*")) {
                    st.push(v1 * v2);
                } else {
                    st.push(v1 / v2);
                }
            } else {
                st.push(Integer.valueOf(s));
            }
        }

        return st.pop();
        
    }
}
