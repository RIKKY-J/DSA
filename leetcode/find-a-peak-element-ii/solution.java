class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startC = 0, endC = mat[0].length-1;

        while(startC <= endC){
            int maxR = 0, midC = startC + (endC -startC)/2;

            for(int row = 0; row< mat.length; row++){
                maxR = mat[row][midC] >= mat[maxR][midC] ? row : maxR;
            }
            boolean leftB = midC-1 >= startC && mat[maxR][midC-1] > mat[maxR][midC];
            boolean rightB = midC+1 <= endC && mat[maxR][midC+1] > mat[maxR][midC];

            if(!leftB && !rightB) return new int[]{maxR, midC};
            else if(rightB) startC = midC+1;
            else endC = midC-1;
        }
        return null;
    }
}