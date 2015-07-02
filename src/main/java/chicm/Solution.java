package chicm;

import java.util.*;

public class Solution {

  public static void main(String args[]) throws Exception {
    int[][] mountains = getMountainsFromInput();
    if (mountains == null || mountains.length < 1) {
      System.out.println("0");
      return;
    }
    int[] heights = getHeightArray(mountains);
    if (heights == null) {
      System.out.println("0");
      return;
    }

    int lastHeight = 0;
    // total horizontal distance is heights.length -1,
    // so we only need to calculate vertical distance
    int totalVertical = 0;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != lastHeight) {
        totalVertical += Math.abs(heights[i] - lastHeight);
        lastHeight = heights[i];
      }
      if (i == heights.length - 1) {
        totalVertical += heights[i];
      }
    }
    System.out.println(heights.length - 1 + totalVertical);
  }

  // convert array of mountains to array of heights
  // The height array stores maximum height of each point
  public static int[] getHeightArray(int[][] mountains) {
    if (mountains.length < 1) {
      return null;
    }
    int maxEnd = 0;
    for (int[] m : mountains) {
      if (m[1] > maxEnd) {
        maxEnd = m[1];
      }
    }
    int[] heights = new int[maxEnd + 1];
    for (int[] m : mountains) {
      if (heights[m[0]] < m[2]) {
        for (int i = m[0]; i <= m[1]; i++) {
          heights[i] = m[2];
        }
      }
    }
    return heights;
  }

  public static int[][] getMountainsFromInput() {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    if (num <= 0) {
      return null;
    }
    int[][] m = new int[num][3];
    for (int i = 0; i < num; i++) {
      m[i][0] = sc.nextInt();
      m[i][1] = sc.nextInt();
      m[i][2] = sc.nextInt();
    }
    return m;
  }
}