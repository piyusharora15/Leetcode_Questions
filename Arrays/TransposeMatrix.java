// Problem Link: https://leetcode.com/problems/transpose-matrix?envType=problem-list-v2&envId=wh88bf73

// Approach: Create a new matrix with swapped dimensions and fill it by iterating through the original matrix.

// Code:
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] transposed = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}

// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the original matrix.
// Space Complexity: O(m*n) for the new transposed matrix.