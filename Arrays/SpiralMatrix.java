// Problem Link: https://leetcode.com/problems/spiral-matrix?envType=problem-list-v2&envId=wh88bf73

// Approach: Simulation.
// We maintain four pointers to track the boundaries of the matrix (top, bottom, left, right).We then traverse the matrix in a spiral order by moving right, down, left, and up, adjusting the boundaries after each direction is completed. This continues until all elements are added to the result list.

// Code:
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top=0,left=0,bottom=n-1,right=m-1;
        while(top <= bottom && left <= right){
            for(int i=left;i<=right;i++) ans.add(matrix[top][i]);
            top++;
            for(int i=top;i<=bottom;i++) ans.add(matrix[i][right]);
            right--;
            if(top <= bottom){
                for(int i=right;i>=left;i--) ans.add(matrix[bottom][i]);
                bottom--;
            }
            if(left <= right){
                for(int i=bottom;i>=top;i--) ans.add(matrix[i][left]);
                left++;
            }
        }
        return ans;
    }
}

// Time Complexity: O(n*m) where n is the number of rows and m is the number of columns in the matrix.
// Space Complexity: O(1) if we don't count the output list, otherwise O(n*m) for the output list.