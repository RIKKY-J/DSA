class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i =0; i<n ; i++){
            if(nums[i] < 0) arr[i] = -nums[i];
            else arr[i] = nums[i];
        }
        Arrays.sort(arr);
        long ans = 0;
        for(int i=0; i< n; i++){
            long square = (long) arr[i] * arr[i];
            if (i < n / 2) {
                ans -= square;
            } else {
                ans += square;
            }
        }
        return ans;
    }
}