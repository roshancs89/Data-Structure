package org.ds.greedy;

/**
 * This is a problem under greedy category for Leetcode Platform
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 * Given a string s and an array of integers cost where cost[i] is the cost of deleting the ith character in s.
 *
 * Return the minimum cost of deletions such that there are no two identical letters next to each other.
 *
 * Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abaac", cost = [1,2,3,4,5]
 * Output: 3
 * Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
 */
public class MinimumDeletionCost {

    public static void main(String args[]){
        MinimumDeletionCost minCost = new MinimumDeletionCost();
        //""aaabbbabbbb"
        //[3,5,10,7,5,3,5,5,4,8,1]"

        System.out.println(minCost.minCost("aaabbbabbbb",new int[]{3,5,10,7,5,3,5,5,4,8,1}));
    }

    public int minCost(String s, int[] cost) {
        char[] chars = s.toCharArray();
        int totalCost = 0;
        for(int i = 0; i < chars.length-1;i++){

            if(chars[i] == chars[i+1]){
                if(cost[i] < cost[i+1]) {
                    totalCost += cost[i];
                }else{
                    totalCost += cost[i+1];
                    cost[i+1] = cost[i];
                }

            }
        }

        return totalCost;

    }

}
