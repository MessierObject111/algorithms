package com.alg.binarySearch;

//https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/
//1870. Minimum Speed to Arrive on Time
//Medium
//2.1K
//245
//company
//PhonePe
//company
//Google
//You are given a floating-point number hour, representing the amount of time you have to reach the office. To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.
//
//Each train can only depart at an integer hour, so you may need to wait in between each train ride.
//
//For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
//Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time.
//
//Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
//
//
//
//Example 1:
//
//Input: dist = [1,3,2], hour = 6
//Output: 1
//Explanation: At speed 1:
//- The first train ride takes 1/1 = 1 hour.
//- Since we are already at an integer hour, we depart immediately at the 1 hour mark. The second train takes 3/1 = 3 hours.
//- Since we are already at an integer hour, we depart immediately at the 4 hour mark. The third train takes 2/1 = 2 hours.
//- You will arrive at exactly the 6 hour mark.
//Example 2:
//
//Input: dist = [1,3,2], hour = 2.7
//Output: 3
//Explanation: At speed 3:
//- The first train ride takes 1/3 = 0.33333 hours.
//- Since we are not at an integer hour, we wait until the 1 hour mark to depart. The second train ride takes 3/3 = 1 hour.
//- Since we are already at an integer hour, we depart immediately at the 2 hour mark. The third train takes 2/3 = 0.66667 hours.
//- You will arrive at the 2.66667 hour mark.
//Example 3:
//
//Input: dist = [1,3,2], hour = 1.9
//Output: -1
//Explanation: It is impossible because the earliest the third train can depart is at the 2 hour mark.
//
//
//Constraints:
//
//n == dist.length
//1 <= n <= 105
//1 <= dist[i] <= 105
//1 <= hour <= 109
//There will be at most two digits after the decimal point in hour.
public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(dist.length - 1 > hour) return -1;
        int s = -1;
        /* Original thought is to increase speed linearly, but this cost performance for extreme cases
        while(!canArrive(dist, hour, s)) {
            s++;
        }
        */
        //Instead, we need to use binary search to find the target speed. There is a hint in the end:
        //"Tests are generated such that the answer will not exceed 10^7 and hour will have at most two digits after the decimal point."
        int left = 1, right = 10000000;
        while(left <= right) {
            int mid = (left + right) /2;
            if(canArrive(dist, hour, mid)) {
                right = mid - 1;
                s = mid;
            } else {
                left = mid + 1;
            }
        }
        return s;
    }

    private boolean canArrive(int[] dist, double hour, int s) {
        double time = calcTime(dist, s);
        return time > hour ? false : true;
    }

    private double calcTime(int[] dist, int s) {
        double totalTime = 0;
        //Calculate time spent before last train (need to consider the round-ups)
        for(int i = 0; i < dist.length-1; i++){
            int time = 0;
            if(dist[i] % s != 0) {
                time = dist[i]/s + 1;
            }else {
                time = dist[i]/s;
            }
            //System.out.println("time added: " + time);
            totalTime = totalTime + time;
        }
        //Calculate time spent at last train (no need to consider the round-ups)
        double lastTime = dist[dist.length - 1]/(double)s;
        //System.out.println("time added: " + lastTime);
        totalTime = totalTime + lastTime;
        System.out.println("Total time: " + totalTime + " speed:" + s);
        return totalTime;
    }
}
