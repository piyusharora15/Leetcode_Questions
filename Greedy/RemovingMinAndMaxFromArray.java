/*

Problem Link: https://leetcode.com/problems/removing-minimum-and-maximum-from-array

You are given a 0-indexed array of distinct integers nums.

There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.

A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.

Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.

Example 1:
Input: nums = [2,10,7,5,4,1,8,6]
Output: 5
Explanation: 
The minimum element in the array is nums[5], which is 1.
The maximum element in the array is nums[1], which is 10.
We can remove both the minimum and maximum by removing 2 elements from the front and 3 elements from the back.
This results in 2 + 3 = 5 deletions, which is the minimum number possible.

Example 2:
Input: nums = [0,-4,19,1,8,-2,-3,5]
Output: 3
Explanation: 
The minimum element in the array is nums[1], which is -4.
The maximum element in the array is nums[2], which is 19.
We can remove both the minimum and maximum by removing 3 elements from the front.
This results in only 3 deletions, which is the minimum number possible.

Example 3:
Input: nums = [101]
Output: 1
Explanation:  
There is only one element in the array, which makes it both the minimum and maximum element.
We can remove it with 1 deletion.


Approach: Using Greedy Algorithm.

1. First, we need to find the minimum and maximum elements in the array along with their indices.
2. Once we have the indices of the minimum and maximum elements, we can calculate the number of deletions required to remove them from the array.
3. We can remove elements from the front or the back of the array, so we need to consider all possible combinations of deletions:
   - Remove both from the front.
   - Remove both from the back.
   - Remove one from the front and one from the back.

4. Finally, we return the minimum number of deletions required from the above combinations.


Dry Run:
Let's take an example to dry run the approach:
Input: nums = [2,10,7,5,4,1,8,6]
1. Find the minimum and maximum elements:
   - Minimum element is 1 at index 5.
   - Maximum element is 10 at index 1.

2. Calculate the number of deletions for each combination:
   - Remove both from the front: 2 (to remove 10) + 6 (to remove 1) = 8 deletions
   - Remove both from the back: 3 (to remove 1) + 7 (to remove 10) = 10 deletions
    - Remove one from the front and one from the back: 
      - Remove 10 from the front and 1 from the back: 2 (to remove 10) + 3 (to remove 1) = 5 deletions
      - Remove 1 from the front and 10 from the back: 6 (to remove 1) + 7 (to remove 10) = 13 deletions

3. The minimum number of deletions required is 5.


Time Complexity: O(n), where n is the number of elements in the array. We need to traverse the array once to find the minimum and maximum elements.

Space Complexity: O(1), as we are using a constant amount of extra space for variables to store indices and counts.

*/

// Code:

class RemovingMinAndMaxFromArray {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0, maxIndex = 0;

        // Find the indices of the minimum and maximum elements
        for (int i = 0; i < n; i++) {
            if(nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Calculate the number of deletions required for each combination
        int removeBothFromFront = Math.max(minIndex, maxIndex) + 1;
        int removeBothFromBack = Math.max(n - minIndex, n - maxIndex);
        int removeOneFromFrontOneFromBack = Math.min(minIndex + 1 + (n - maxIndex), maxIndex + 1 + (n - minIndex));

        // Return the minimum number of deletions required
        return Math.min(removeBothFromFront, Math.min(removeBothFromBack, removeOneFromFrontOneFromBack));
    }
}