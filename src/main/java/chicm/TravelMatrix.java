package chicm;

public class TravelMatrix {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] matrix2 = {{1}};
    //travelDiagonally(matrix);
    travel(matrix2);
  }

  public static void travelDiagonally (int[][] array) {
    
    for (int k = 0; k <= 2 * (array.length - 1); ++k) {
      int yMin = Math.max(0, k - array.length + 1);
      int yMax = Math.min(array.length - 1, k);
      for (int y = yMin; y <= yMax; ++y) {
          int x = k - y;
          System.out.print(array[y][x]);
      }
      System.out.println();
    }
  }
  
  public static void travel(int[][] array) {
    int len = array.length;
    
    for(int k = 0; k <= 2 * (len-1); k++) {
      for (int i = 0; i <= k; i++) {
        int j = k - i;
        if(i > len-1 || i < 0 || j > len-1 || j <0) {
          continue;
        }
        System.out.print(array[i][j]);
      }
      System.out.println();
    }
  }
 }
