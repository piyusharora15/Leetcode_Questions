/*

Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array?envType=study-plan-v2&envId=top-interview-150

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Approach: Using Two Pointers.

1. First, we initialize two pointers, `i` and `j`, to 0.
The pointer `i` will be used to traverse the array, while `j` will keep track of the position where the next unique element should be placed.
2. We iterate through the array using the pointer `i`. For each element at index `i`:

   - If the element is different from the element at index `j`, we increment `j` and assign the value of `nums[i]` to `nums[j]`. This effectively moves the unique element to the front of the array.

   - If the element is the same as the element at index `j`, we simply continue to the next iteration without making any changes.

3. After the loop ends, the pointer `j` will be pointing to the last unique element in the array. The number of unique elements is `j + 1`, so we return `j + 1` as the result.

Dry Run:
Let's take an example to understand the dry run of the approach.
Input: nums = [0,0,1,1,1,2,2,3,3,4]

- i = 0, j = 0: nums[0] = 0, nums[0] = 0. They are the same, so we continue to the next iteration.
- i = 1, j = 0: nums[1] = 0, nums[0] = 0. They are the same, so we continue to the next iteration.
- i = 2, j = 0: nums[2] = 1, nums[0] = 0. They are different, so we increment j to 1 and assign nums[1] = nums[2]. Now, nums = [0,1,1,1,1,2,2,3,3,4].
- i = 3, j = 1: nums[3] = 1, nums[1] = 1. They are the same, so we continue to the next iteration.
- i = 4, j = 1: nums[4] = 1, nums[1] = 1. They are the same, so we continue to the next iteration.
- i = 5, j = 1: nums[5] = 2, nums[1] = 1. They are different, so we increment j to 2 and assign nums[2] = nums[5]. Now, nums = [0,1,2,1,1,2,2,3,3,4].
- i = 6, j = 2: nums[6] = 2, nums[2] = 2. They are the same, so we continue to the next iteration.
- i = 7, j = 2: nums[7] = 3, nums[2] = 2. They are different, so we increment j to 3 and assign nums[3] = nums[7]. Now, nums = [0,1,2,3,1,2,2,3,3,4].
- i = 8, j = 3: nums[8] = 3, nums[3] = 3. They are the same, so we continue to the next iteration.
- i = 9, j = 3: nums[9] = 4, nums[3] = 3. They are different, so we increment j to 4 and assign nums[4] = nums[9]. Now, nums = [0,1,2,3,4,2,2,3,3,4].
After the loop ends, j = 4, so we return j + 1 = 5 as the number of unique elements in the array.

Time Complexity: O(n), where n is the length of the input array nums. We traverse the array once, so the time complexity is linear.

Space Complexity: O(1), as we are using only a constant amount of extra space for the pointers i and j, regardless of the input size.

*/


// Code:
class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
