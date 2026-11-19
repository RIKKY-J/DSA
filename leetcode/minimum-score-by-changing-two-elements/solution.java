class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }
        return Math.min(
            nums[n - 1] - nums[2],  // change 2 smallest elements
            Math.min(
                nums[n - 3] - nums[0],  // change 2 largest elements
                nums[n - 2] - nums[1]   // change 1 smallest and 1 largest
            )
        );
    }
}