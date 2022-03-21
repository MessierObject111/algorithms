package com.alg.twoPointers;

/**
 * 11. Container With Most Water
 * Medium
 *
 * 14970
 *
 * 893
 *
 * Add to List
 *
 * Share
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //This problems was solved by me back in Aug 2015, but today I have no memory of it at all, at Mar 2022..
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r) {
            int min_height = height[l] < height[r] ? height[l] : height[r];
            int area = min_height * (r-l);
            max = max > area ? max : area;
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }

    public int maxAreaBruteForce(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length -1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int area = (height[i] > height[j] ? height[j] : height[i]) * (j-i);
                if(area > max) {
                    System.out.println("i:"+ i+ " j: "+ j);
                    max = area;
                }
                //max = max < area? area:max;
            }
        }
        return max;
    }
}
