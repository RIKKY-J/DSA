class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0;
        int max = 0;
        int low = 0;
        for(int x : weights){
            max += x;
            low = Math.max(low , x);
        }
        total = max;
        while(low < max){
            int mid = low + (max-low)/2;
            if(possible(mid , weights , days)){
                max = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean possible(int capacity, int[] weights, int days){
        int day = 1;
        int wt = 0;
        for(int i : weights){
            if(wt+i > capacity){
                day++;
                wt = 0;
            }
            wt += i;
        }
        return day <= days;
    }
}