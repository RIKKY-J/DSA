class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int x : piles) max = Math.max(max, x);
        int low = 1;
        while(low < max){
            int mid = low + (max- low)/2;
            boolean out = fn(piles, h, mid);
            if(out){
                max = mid;
            }else low = mid+1;
        }
        return low;
    }
    public boolean fn(int[] piles, int h, int speed) {
        long count = 0;
        for (int p : piles) {
            count += (p + speed - 1) / speed;
            if (count > h) return false;
        }
        return count <= h;
    }
}