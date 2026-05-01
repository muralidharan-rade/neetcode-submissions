class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> finalSt = new Stack<>();

        for(int i=0; i<operations.length; i++) {
            if(operations[i].equals("+")) {
                int val = st.pop() + st.pop();
                
                finalSt.push(val);
                st.clear();
                st.addAll(finalSt);
            } else if (operations[i].equals("C")) {
                st.pop();
                finalSt.pop();
            } else if (operations[i].equals("D")) {
                int last = st.peek();
                st.push(last * 2);
                finalSt.push(last * 2);
            } else {
                st.push(Integer.valueOf(operations[i]));
                finalSt.push(Integer.valueOf(operations[i]));
            }
        }

        int ans = 0;

        while(!finalSt.empty()) {
            ans += finalSt.pop();
        }

        return ans;
    }
}