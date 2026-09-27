class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i< nums.length; i++){
            if(maxi < nums[i] ) maxi = nums[i];
            if(sum + nums[i] > 0) {
                sum += nums[i];
                maxi = Math.max(maxi , sum);
            }else sum = 0;
        }
        return maxi;
    }
}