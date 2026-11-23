class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                int d1 = a[0]*a[0] + a[1]*a[1];
                int d2 = b[0]*b[0] + b[1]*b[1];
                return Integer.compare(d1, d2);
            }
        );
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            pq.add(new int[]{x, y});
        }

        int[][] ans = new int[k][2];

        for(int i = 0; i < k; i++){
            int[] nums = pq.poll();
            ans[i][0] = nums[0];
            ans[i][1] = nums[1];
        }
        return ans;
    }
}
