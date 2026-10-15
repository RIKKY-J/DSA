class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        List<Integer> ct = new ArrayList<>();
        for(int i = 0; i< nums.size() ; i++){
            for(int j =i; j< nums.size(); j++){
                Set<Integer> st = new HashSet<>();
                for(int k =i; k<=j; k++){
                    st.add(nums.get(k));
                }
                ct.add(st.size());
            }
        }
        for(int i=0 ;i < ct.size(); i++){
            ans += ct.get(i) * ct.get(i);
        }
        return ans;
    }
}