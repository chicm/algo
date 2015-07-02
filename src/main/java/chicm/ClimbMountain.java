package chicm;

public class ClimbMountain {

  public static void main(String[] args) {
    int[][] m1 = {{1,3,2}, {2, 4, 4}, {6, 7, 5}};
    int[][] m2 = {};
    int[][] m3 = {{0,6,3}, {1, 4, 5}, {2, 5, 1}};

    int[] heights = getHeightArray(m3);
    if(heights == null) {
      System.out.println(0);
      return;
    }
    
    int lastHeight = 0;
    //total horizontal distance is heights.length -1, 
    //so we only need to calculate vertical distance
    int totalVertical = 0;
    for(int i = 0; i < heights.length; i++) {
      if(heights[i] != lastHeight) {
        totalVertical += Math.abs(heights[i] - lastHeight);
        lastHeight = heights[i];
      }
      if(i == heights.length-1) {
        totalVertical += heights[i];
      }
    }
    System.out.println(heights.length-1 + totalVertical );
    printArray(heights);
  }
  
  // convert array of mountains to array of heights
  // The height array stores maximum height of each point
  public static int[] getHeightArray(int[][] mountains) {
    if(mountains.length < 1) {
      return null;
    }
    int maxEnd = 0;
    for(int[] m: mountains) {
      if(m[1] > maxEnd) {
        maxEnd = m[1];
      }
    }
    int[] heights = new int[maxEnd+1];
    for(int[] m : mountains) {
      if(heights[m[0]] < m[2]) {
        for(int i = m[0]; i <=m[1]; i++) {
          heights[i] = m[2];
        }
      }
    }
    return heights;
  }
  
  public static void printArray(int[] a) {
    for(int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

}
