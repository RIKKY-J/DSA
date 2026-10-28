
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int pv = 0;
        int pn = 0;
        int pt = 0;

        while (pt < n) {
            while (pv < n && nums[pv] < 0) pv++;

            arr[pt++] = nums[pv++];

            while (pn < n && nums[pn] > 0) pn++;

            arr[pt++] = nums[pn++];
        }

        return arr;
    }
}