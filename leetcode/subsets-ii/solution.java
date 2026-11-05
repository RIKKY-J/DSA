class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        fn(nums, 0, subset);
        return ans;
    }
    public void fn(int[] nums, int idx, List<Integer>subset){
        if(idx == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        } 

        subset.add(nums[idx]);
        fn(nums, idx+1, subset);

        subset.remove(subset.size()-1);
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]) idx++;
        fn(nums, idx+1, subset);
    }
}