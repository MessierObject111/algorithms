package com.companies.meta;

/**
 * 1570. Dot Product of Two Sparse Vectors
 * Medium
 * Given two sparse vectors, compute their dot product.
 *
 * Implement class SparseVector:
 *
 * SparseVector(nums) Initializes the object with the vector nums
 * dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
 * A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.
 *
 * Follow up: What if only one of the vectors is sparse?
 */
public class SparseVector {
    public int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int[] nums2 = vec.nums;
        int sum = 0;
        for(int i =0; i < nums.length; i++){
            sum += nums[i] * nums2[i];
        }
        return sum;
    }
    //2022-06-18: I don't quite get the point of this algo question, it is so straighforward...you just loop it and sum, done - What's the twist here?
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
