class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        fn(nums , 0, subset);
        return res;
    }
    public void fn(int[] nums, int idx, List<Integer> subset){
        if(idx == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[idx]);
        fn(nums, idx+1, subset);

        subset.remove(subset.size()-1);
        fn(nums, idx+1, subset);
    }
}