package org.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A leet code problem to get the number of calls in time range. (Queue category)
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 *
 * Implement the RecentCounter class:
 *
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 */
public class RecentCalls {

    public static void main(String args[]){
        RecentCalls recentCalls = new RecentCalls();
        System.out.println(recentCalls.ping(1));
        System.out.println(recentCalls.ping(100));
        System.out.println(recentCalls.ping(3001));
        System.out.println(recentCalls.ping(3002));
        //recentCalls.leastInterval(new char[]{'A','A','A','B','B','B'}, 2 );
    }

    Queue<Integer> callCounter;
    public RecentCalls() {
        callCounter = new LinkedList<Integer>();
    }

    public int ping(int t) {
        int startRange = t-3000;

        while(!callCounter.isEmpty() && callCounter.peek() < startRange){
            callCounter.remove();
        }

        callCounter.add(t);

        return callCounter.size();

    }

}
