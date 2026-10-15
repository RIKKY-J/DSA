class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        List<Integer> ct = new ArrayList<>();
        for(int i = 0; i< nums.size() ; i++){
            Set<Integer> st = new HashSet<>();
            for(int j =i; j< nums.size(); j++){
                st.add(nums.get(j));
                ct.add(st.size());
            }
        }
        for(int i=0 ;i < ct.size(); i++){
            ans += ct.get(i) * ct.get(i);
        }
        return ans;
    }
}