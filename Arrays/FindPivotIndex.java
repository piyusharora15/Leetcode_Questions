// Problem Link: https://leetcode.com/problems/find-pivot-index?envType=problem-list-v2&envId=wh88bf73

// Brute Force Approach: We can iterate through each index of the array and for each index, calculate the sum of elements to the left and right of that index. If the sums are equal, we return that index as the pivot index. If no such index is found, we return -1.

// Code:
class Solution {
    public int pivotIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int leftSum = 0;
            for(int j=0;j<i;j++){
                leftSum += nums[j];
            }
            int rightSum = 0;
            for(int j=i+1;j<nums.length;j++){
                rightSum += nums[j];
            }
            if(leftSum == rightSum) return i;
        }
        return -1;
    }
}

// Time Complexity: O(n^2) where n is the number of elements in the array.
// Space Complexity: O(1) as we are using only a constant amount of extra space.

// Optimal Approach: Prefix Sum Technique
// We can calculate the total sum of the array first. Then, we can iterate through the array while maintaining a running sum of the elements to the left of the current index. For each index, we can check if the left sum is equal to the total sum minus the left sum minus the current element. If they are equal, we return that index as the pivot index. If no such index is found, we return -1.

// Code:
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int leftSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum -= nums[i];
            if(leftSum == totalSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}

// Time Complexity: O(n) where n is the number of elements in the array.
// Space Complexity: O(1) as we are using only a constant amount of extra space.