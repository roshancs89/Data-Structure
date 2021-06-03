package org.ds.greedy;

/**
 * This is a leetcode problems under greedy category
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s, split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of split balanced strings.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 */
public class MaximumBalancedSubstring {
    public static void main(String args[]){
        MaximumBalancedSubstring maxSub = new MaximumBalancedSubstring();
        String s = "RLRRLLRLRL";
        System.out.println(maxSub.balancedStringSplit(s));
    }
    //Whenever r and l count matches, balanced substring
    //count is increased
    public int balancedStringSplit(String s) {
        int balancedSub = 0;
        int rCount = 0;
        int lCount = 0;
        for(char ch: s.toCharArray()){
            if(ch == 'L')
                lCount++;

            if(ch == 'R')
                rCount++;

            if(lCount == rCount)
                balancedSub++;
        }

        return balancedSub;

    }


}
