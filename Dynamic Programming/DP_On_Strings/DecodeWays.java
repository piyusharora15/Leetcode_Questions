// Problem Link: https://leetcode.com/problems/decode-ways?envType=problem-list-v2&envId=wh8gjvyh

// Approach 1: Recursion.
// We can use recursion to explore all possible ways to decode the string.We start from the first character and try to decode one or two characters at a time,depending on whether they form a valid mapping to a letter. We continue this process until we reach the end of the string, counting the number of valid decodings along the way.

// Code:
class Solution {
    public int numDecodings(String s) {
        return helper(s,0);
    }
    private int helper(String s,int idx){
        int n = s.length();
        if(idx == n){
            return 1;
        }
        int ways = 0;
        if(s.charAt(idx) != '0'){
            ways = helper(s,idx+1);
        }
        if((idx+1 < n) && ((s.charAt(idx) == '1' && s.charAt(idx+1) <= '9') || (s.charAt(idx) == '2' && s.charAt(idx+1) <= '6'))){
            ways += helper(s,idx+2);
        }
        return ways;
    }
}

// Time Complexity: O(2^n) in the worst case, where n is the length of the string. This is because, in the worst case, we can make two recursive calls at each step (one for decoding one character and another for decoding two characters).
// Space Complexity: O(n) for the recursion stack, where n is the length of the string.

// Approach 2: Recursion with Memoization.
// We can optimize the recursive approach by using memoization to store the results of previously computed subproblems. This way, we avoid redundant calculations and improve the time complexity.

// Code:
class Solution {
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return helper(s,0,memo);
    }
    private int helper(String s,int idx,Integer[] memo){
        int n = s.length();
        if(idx == n){
            return 1;
        }
        if(memo[idx] != null){
            return memo[idx];
        }
        int ways = 0;
        if(s.charAt(idx) != '0'){
            ways = helper(s,idx+1,memo);
        }
        if((idx+1 < n) && ((s.charAt(idx) == '1' && s.charAt(idx+1) <= '9') || (s.charAt(idx) == '2' && s.charAt(idx+1) <= '6'))){
            ways += helper(s,idx+2,memo);
        }
        memo[idx] = ways;
        return ways;
    }
}

// Time Complexity: O(n), where n is the length of the string. Each subproblem is solved only once.
// Space Complexity: O(n) for the memoization array and O(n) for the recursion stack, resulting in a total space complexity of O(n).

// Approach 3: Tabulation.
// We can use a bottom-up dynamic programming approach to solve the problem iteratively. We create a dp array where dp[i] represents the number of ways to decode the substring s[0..i-1]. We fill this array based on the valid one-digit and two-digit mappings.We start from the base cases and build up to the final result.

// Code:
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1; // Base case: empty string has one way to decode
        for(int i=1;i<=n;i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            if(i > 1 && ((s.charAt(i-2) == '1' && s.charAt(i-1) <= '9') || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6'))){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}

// Time Complexity: O(n), where n is the length of the string. We iterate through the string once to fill the dp array.
// Space Complexity: O(n) for the dp array.

// Approach 4: Space Optimization.
// We can optimize the space complexity of the tabulation approach by using two variables to keep track of the last two computed values instead of maintaining a full dp array.We update these variables as we iterate through the string.

// Code:
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int prev2 = 1; // dp[i-2]
        int prev1 = 0; // dp[i-1]
        for(int i=1;i<=n;i++){
            int curr = 0;
            if(s.charAt(i-1) != '0'){
                curr += prev1 == 0 ? 1 : prev1;
            }
            if(i > 1 && ((s.charAt(i-2) == '1' && s.charAt(i-1) <= '9') || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6'))){
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// Time Complexity: O(n), where n is the length of the string. We iterate through the string once.
// Space Complexity: O(1) since we are using only a constant amount of extra space.