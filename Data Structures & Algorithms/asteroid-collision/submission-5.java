class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);

        for(int i=1; i<asteroids.length; ) {
            if(!st.isEmpty()) {
                if((st.peek() > 0 && asteroids[i] > 0) || (st.peek() < 0 && asteroids[i] < 0)) {
                    st.push(asteroids[i]);
                    i++;
                } else if (st.peek() < 0 && asteroids[i] > 0) {
                    st.push(asteroids[i]);
                    i++;
                } else {
                    if(st.peek() == Math.abs(asteroids[i])) {
                        st.pop();
                        i++;
                    } else if(st.peek() < Math.abs(asteroids[i])) {
                        st.pop();
                    } else {
                        i++;
                    }
                }
            } else {
                st.push(asteroids[i]);
                i++;
            }
        }
        
        if(!st.isEmpty()) {
            int[] result = new int[st.size()];
            int i = 0;

            while(!st.isEmpty()) {
                result[i++] = st.pop();
            }

            for(int ii=0, j=result.length-1; ii<=j; ii++) {
                int t = result[ii];
                result[ii] = result[j];
                result[j] = t;
                j--;
            }

            return result;
        }

        return new int[0];        
    }
}