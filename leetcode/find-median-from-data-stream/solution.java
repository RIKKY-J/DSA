class MedianFinder {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;
    
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());

        if(large.size() > small.size()){
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        double ans = 0.0;
        if(small.size() == large.size()) ans = (small.peek()+large.peek())/2.0;
        else ans = small.peek();
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */