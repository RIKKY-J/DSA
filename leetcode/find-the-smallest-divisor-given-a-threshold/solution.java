class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int x : nums) max = Math.max(max, x);
        int low = 1;
        while(low < max){
            int mid = low + (max-low)/2;
            if(fn(nums, mid)> threshold) low = mid+1;
            else max = mid;
        }
        return low;
    }
    public int fn(int[] nums, int num){
        int ans = 0;
        for(int x : nums) ans += (x + num - 1) / num;
        return ans;
    }
}