/*

Problem Link: https://leetcode.com/problems/move-zeroes?envType=problem-list-v2&envId=wh88bf73

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]


Approach: Using Two Pointers.

1. First, we initialize two pointers, `i` and `j`, to 0. 
The pointer `i` will be used to traverse the array, while `j` will keep track of the position where the next non-zero element should be placed.

2. We iterate through the array using the pointer `i`. For each element at index `i`:

   - If the element is non-zero, we assign it to the position pointed to by `j` and then increment `j` to point to the next position for potential non-zero elements.

   - If the element is zero, we simply continue to the next iteration without making any changes.

3. After the loop, all non-zero elements will have been moved to the front of the array in their original order, and the pointer `j` will indicate the position where the first zero should be placed.

4. Finally, we fill the remaining positions from `j` to the end of the array with zeros.

Dry Run:
Let's take an example to dry run the approach:
Input: nums = [0,1,0,3,12]
1. Initialize pointers: i = 0, j = 0
2. Start iterating through the array:
   - i = 0: nums[0] is 0, so we do nothing and move to the next index.
   - i = 1: nums[1] is 1 (non-zero), so we assign nums[j] = nums[i] (nums[0] = 1) and increment j to 1.
   - i = 2: nums[2] is 0, so we do nothing and move to the next index.
   - i = 3: nums[3] is 3 (non-zero), so we assign nums[j] = nums[i] (nums[1] = 3) and increment j to 2.
   - i = 4: nums[4] is 12 (non-zero), so we assign nums[j] = nums[i] (nums[2] = 12) and increment j to 3.

3. After the loop, all non-zero elements are at the front of the array: [1,3,12,0,0].
4. The pointer `j` is at index 3, so we fill the remaining positions with zeros: [1,3,12,0,0].


Time Complexity: O(n), where n is the length of the input array. 
We traverse the array once to move the non-zero elements and once more to fill the remaining positions with zeros.

Space Complexity: O(1), since we are modifying the array in place and not using any additional data structures that grow with the input size.

*/


// Code:

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0; // Pointer for the position of the next non-zero element
        
        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        
        // Fill the remaining positions with zeros
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}