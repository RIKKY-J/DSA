class Solution {
    public int smallestIndex(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i =0; i< nums.length; i++){
            if(sum(nums[i]) == i) ans = Math.min(ans, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int sum(int x){
        int num = 0;
        while(x > 0){
            num += x%10;
            x /= 10;
        }
        return num;
    }
}
