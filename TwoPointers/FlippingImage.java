// Problem Link: https://leetcode.com/problems/flipping-an-image?envType=problem-list-v2&envId=wh88bf73

// Brute Force Approach: Do exactly what the problem statement says. For each row, reverse the row and then flip each element.

// Code:
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i=0;i<n;i++){
            int left = 0,right = image[i].length-1;
            while(left < right){
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;
                left++;
                right--;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<image[i].length;j++){
                image[i][j] = (image[i][j] == 0 ? 1 : 0);
            }
        }
        return image;
    }
}

// Time Complexity: O(n*m) where n is the number of rows and m is the number of columns in the image.
// Space Complexity: O(1) as we are modifying the input image in place.

// Optimal Approach: We can combine both operations (reversing and flipping) in a single pass for each row. While swapping the elements, we can also flip them.

// Code:
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image){
            int left = 0, right = row.length-1;
            while(left < right){
                if(row[left] == row[right]){
                    row[left] ^= 1;
                    row[right] ^= 1;
                }
                left++;
                right--;
            }
            if(left == right){
                row[left] ^= 1;
            }
        }
        return image;
    }
}

// Time Complexity: O(n*m) where n is the number of rows and m is the number of columns in the image.
// Space Complexity: O(1) as we are modifying the input image in place.