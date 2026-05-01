class KthLargest {

    PriorityQueue<Integer> pq;
    int window;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        window = k;

        for(int i : nums) {
            pq.add(i);
        }

        while(!pq.isEmpty() && pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        if(pq.size() < window) {
            pq.add(val);
            return pq.peek();
        }
        int min = pq.peek();
        if(val > min) {
            pq.poll();
            pq.add(val);
            return pq.peek();
        }
        return min;
    }
}
