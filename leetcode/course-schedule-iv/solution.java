class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> temp = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) temp.add(new ArrayList<>());

        for(int i = 0; i < prerequisites.length; i++){
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            temp.get(x).add(y);
        }

        int[] in = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int j : temp.get(i)) in[j]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(in[i] == 0) q.add(i);
        }

        int[] list = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            list[idx++] = node;

            for(int n : temp.get(node)){
                in[n]--;
                if(in[n] == 0) q.add(n);
            }
        }

        // Track direct and indirect prerequisites
        boolean[][] pre = new boolean[numCourses][numCourses];

        // Process nodes in topological order
        for(int i = 0; i < idx; i++){
            int node = list[i];

            for(int n : temp.get(node)){
                pre[node][n] = true;

                for(int j = 0; j < numCourses; j++){
                    if(pre[j][node]){
                        pre[j][n] = true;
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for(int i = 0; i < queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];

            ans.add(pre[x][y]);
        }

        return ans;
    }
}
