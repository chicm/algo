package chicm;

import java.util.ArrayList;
import java.util.List;


public class TravelMatrixTriangle {

  public static void main(String[] args) {
    int[][] a1 = {{1}};
    int[][] a2 = {{1,2,3,4}, {5, 6, 7, 8}, {9, 10, 11,12}, {13, 14, 15,16}, {17,18,19,20}};
    int[][] a3 = {{1, 2, 3}};
    int[][] a4 = {{1}, {2}, {3}};
    int[][] a5 = {{1,2,3,4,5,6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
    int[][] a6 = {{1,2,3,4,5,6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, 
        {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}};
    
    //printMatrix(a3);
    System.out.println(traverse(a1));
    System.out.println(traverse(a2));
    System.out.println(traverse(a3));
    System.out.println(traverse(a4));
    System.out.println(traverse(a5));
    System.out.println(traverse(a6));

  }

  public static void printMatrix(int[][] a) {
    if(a == null || a.length < 1)
      return;
    System.out.println("rows:" + a.length);
    System.out.println("cols:" + a[0].length);
    for(int i=0; i < a.length; i++) {
      for(int j =0; j < a[0].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }
  public static  List<Integer> traverse(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if(matrix == null)
      return result;
    if(matrix.length == 1 && matrix[0].length == 1) {
      result.add(matrix[0][0]);
      return result;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;
    
    int minDimension = Math.min(rows, cols);
    int maxRound = minDimension % 2 == 0 ? minDimension/2: minDimension/2 +1;
    
    for(int k = 0; k < maxRound; k++) {
      //start from top left for each round
      int startX = k, startY =k,  minY = k, maxX = rows - 1 - k;
      // rightX and rightY represents the top right point we traverse to
      int rightX = k;
      int rightY = cols - 1 - 2 * k;
      
      if(rightY < startY || rightX > maxX || startX >maxX || rightY < minY) {
        return result;
      }
      
      int x=startX, y=startY; // start point
      // left to right
      for(y = startY; y<=rightY; y++) {
        result.add(matrix[x][y]);
      }
      
      // top right to bottom left
      x = rightX + 1; y=rightY-1; // start point
      if(x > maxX || y <minY) { //start point out of range, stop travel 
        return result;
      }
      for(; x <= maxX && y>=minY; x++, y--) {
        result.add(matrix[x][y]);
      }
      
      // now x, y is out of range, adjust it to next start point
      // adjust start point of the line from bottom right to left
      if(y >=minY) {
        x--;
      } else {   // y< minY, it is tri-angle
        y++;
        x -= 2;
      }
      // bottom right to left if needed
      for(; y > minY; y--) {
        result.add(matrix[x][y]);
      }
      // now x = minx
      // now at the start point of the line from bottom to up
      for(; x>startX; x--) {
        result.add(matrix[x][y]);
      }
    }
    
    return result;
  }
}
