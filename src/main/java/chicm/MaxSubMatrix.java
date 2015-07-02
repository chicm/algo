package chicm;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSubMatrix {

  public static void main(String[] args) {
    // TODO Implement MaxSubMatrix.main
    char[][] matrix = {"01101".toCharArray(),
        "11010".toCharArray(),
        "01110".toCharArray(),
        "11110".toCharArray(),
        "11111".toCharArray(),
        "00000".toCharArray()};
    
    System.out.println(maximalRectangle(matrix));

  }
  public static int maximalRectangle(char[][] matrix) {
    if(matrix == null || matrix.length == 0) {
        return 0;
    }
    int[][] height = new int[matrix.length][matrix[0].length];
    int max = 0;
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(i == 0) {
                height[i][j] = matrix[i][j] == '1' ? 1 : 0;
            } else {
                height[i][j] = matrix[i][j] == '1' ? height[i-1][j] + 1 : 0;
            }
        }
        printArray(height[i]);
        max = Math.max(max, maxRect(height[i]));
        System.out.println(max);
    }
    
    return max;
  }

  private static int maxRect(int[] height) {
    if(height == null || height.length == 0 ) {
        return 0;
    }
    if(height.length == 1) {
        return height[0];
    }
    Deque<Integer> stack = new LinkedList<>();
    int max = height[0];
    for(int i = 0; i < height.length; ) {
        if(stack.isEmpty() || height[i] > height[stack.peek()]) {
            stack.push(i++);
        } else {
            int top = stack.pop();
            int curArea = height[top] * (stack.isEmpty() ? i: i-1-stack.peek());
            if(curArea> max) {
              max = curArea;
            }
        }
    }
    while(!stack.isEmpty()) {
        int top = stack.pop();
        int curArea = height[top] * (stack.isEmpty() ? height.length : height.length - stack.peek() -1);
        if(curArea> max) {
          max = curArea;
        }
    }
    return max;
  }
  
  private static void printArray(int[] a) {
    for(int i : a) {
      System.out.print(i);
    }
    System.out.println();
  }
}
