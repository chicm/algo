package chicm;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Graph:
https://oj.leetcode.com/problems/trapping-rain-water/
 * 
 * @author chicm
 *
 */
public class TrappingRainWater {
  public int trap(int[] A) {
    int l = 0, r = A.length -1;
    int lv = 0, rv = 0;
    int total = 0, raintotal = 0;
    
    for (; l < r; ) {
        if(A[l] < A[r]) {
            lv = lv > A[l] ? lv: A[l];
            total +=A[l];
            raintotal += lv;
            l++;
        } else {
            rv = rv > A[r] ? rv: A[r];
            total += A[r];
            raintotal += rv;
            r --; 
        }
    }
    return raintotal - total;
  }
}
